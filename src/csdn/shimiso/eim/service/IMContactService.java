package csdn.shimiso.eim.service;

import java.util.Calendar;
import java.util.Collection;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.Roster.SubscriptionMode;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.notice.MyNoticeActivity;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.ContacterManager;
import csdn.shimiso.eim.manager.NoticeManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.Notice;
import csdn.shimiso.eim.model.User;
import csdn.shimiso.eim.util.DateUtil;
import csdn.shimiso.eim.util.StringUtil;

/**
 * 
 * ��ϵ�˷���.
 * 
 * @author shimiso
 */
public class IMContactService extends Service {

	private Roster roster = null;
	private Context context;
	/* ����������� */
	private NotificationManager myNotiManager;

	@Override
	public void onCreate() {
		context = this;
		addSubscriptionListener();
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		init();
		return super.onStartCommand(intent, flags, startId);
	}

	private void init() {
		/* ��ʼ������ */
		myNotiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		initRoster();
	}

	/**
	 * ���һ�����������������������
	 */
	private void addSubscriptionListener() {
		PacketFilter filter = new PacketFilter() {
			@Override
			public boolean accept(Packet packet) {
				if (packet instanceof Presence) {
					Presence presence = (Presence) packet;
					if (presence.getType().equals(Presence.Type.subscribe)) {
						return true;
					}
				}
				return false;
			}
		};
		XmppConnectionManager.getInstance().getConnection()
				.addPacketListener(subscriptionPacketListener, filter);
	}

	/**
	 * ��ʼ�������� ��������ʱ�����»�����
	 */
	private void initRoster() {
		roster = XmppConnectionManager.getInstance().getConnection()
				.getRoster();
		roster.removeRosterListener(rosterListener);
		roster.addRosterListener(rosterListener);
		ContacterManager.init(XmppConnectionManager.getInstance()
				.getConnection());
	}

	private PacketListener subscriptionPacketListener = new PacketListener() {

		@Override
		public void processPacket(Packet packet) {
			String user = getSharedPreferences(Constant.LOGIN_SET, 0)
					.getString(Constant.USERNAME, null);
			if (packet.getFrom().contains(user))
				return;
			// ������Զ���������������ظ�һ�������Ϣ
			if (Roster.getDefaultSubscriptionMode().equals(
					SubscriptionMode.accept_all)) {
				Presence subscription = new Presence(Presence.Type.subscribe);
				subscription.setTo(packet.getFrom());
				XmppConnectionManager.getInstance().getConnection()
						.sendPacket(subscription);
			} else {
				NoticeManager noticeManager = NoticeManager
						.getInstance(context);
				Notice notice = new Notice();
				notice.setTitle("��������");
				notice.setNoticeType(Notice.ADD_FRIEND);
				notice.setContent(StringUtil.getUserNameByJid(packet.getFrom())
						+ "�������Ϊ����");
				notice.setFrom(packet.getFrom());
				notice.setTo(packet.getTo());
				notice.setNoticeTime(DateUtil.date2Str(Calendar.getInstance(),
						Constant.MS_FORMART));
				notice.setStatus(Notice.UNREAD);
				long noticeId = noticeManager.saveNotice(notice);
				if (noticeId != -1) {
					Intent intent = new Intent();
					intent.setAction(Constant.ROSTER_SUBSCRIPTION);
					notice.setId("" + noticeId);
					intent.putExtra("notice", notice);
					sendBroadcast(intent);
					setNotiType(R.drawable.icon, "��������",
							StringUtil.getUserNameByJid(packet.getFrom())
									+ "�������Ϊ����", MyNoticeActivity.class);
				}

			}
		}
	};

	/**
	 * 
	 * ����Notification��method.
	 * 
	 * @param iconId
	 *            ͼ��
	 * @param contentTitle
	 *            ����
	 * @param contentText
	 *            ������
	 * @param activity
	 * @author shimiso
	 * @update 2012-5-14 ����12:01:55
	 */
	private void setNotiType(int iconId, String contentTitle,
			String contentText, Class activity) {
		/*
		 * �����µ�Intent����Ϊ���Notification������ʱ�� �����е�Activity
		 */
		Intent notifyIntent = new Intent(this, activity);
		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		/* ����PendingIntent��Ϊ���õ������е�Activity */
		PendingIntent appIntent = PendingIntent.getActivity(this, 0,
				notifyIntent, 0);

		/* ����Notication����������ز��� */
		Notification myNoti = new Notification();
		/* ����statusbar��ʾ��icon */
		myNoti.icon = iconId;
		/* ����statusbar��ʾ��������Ϣ */
		myNoti.tickerText = contentTitle;
		/* ����notification����ʱͬʱ����Ĭ������ */
		myNoti.defaults = Notification.DEFAULT_SOUND;
		/* ����Notification�������Ĳ��� */
		myNoti.setLatestEventInfo(this, contentTitle, contentText, appIntent);
		/* �ͳ�Notification */
		myNotiManager.notify(0, myNoti);
	}

	@Override
	public void onDestroy() {
		// �ͷ���Դ
		XmppConnectionManager.getInstance().getConnection()
				.removePacketListener(subscriptionPacketListener);
		ContacterManager.destroy();
		super.onDestroy();
	}

	private RosterListener rosterListener = new RosterListener() {

		@Override
		public void presenceChanged(Presence presence) {
			Intent intent = new Intent();
			intent.setAction(Constant.ROSTER_PRESENCE_CHANGED);
			String subscriber = presence.getFrom().substring(0,
					presence.getFrom().indexOf("/"));
			RosterEntry entry = roster.getEntry(subscriber);
			if (ContacterManager.contacters.containsKey(subscriber)) {
				// ��״̬�ı�֮ǰ��user�㲥��ȥ
				intent.putExtra(User.userKey,
						ContacterManager.contacters.get(subscriber));
				ContacterManager.contacters.remove(subscriber);
				ContacterManager.contacters.put(subscriber,
						ContacterManager.transEntryToUser(entry, roster));
			}
			sendBroadcast(intent);
		}

		@Override
		public void entriesUpdated(Collection<String> addresses) {
			for (String address : addresses) {
				Intent intent = new Intent();
				intent.setAction(Constant.ROSTER_UPDATED);
				// ���״̬�ı��entry
				RosterEntry userEntry = roster.getEntry(address);
				User user = ContacterManager
						.transEntryToUser(userEntry, roster);
				if (ContacterManager.contacters.get(address) != null) {
					// ���﷢�����Ǹ���ǰ��user
					intent.putExtra(User.userKey,
							ContacterManager.contacters.get(address));
					// �������ı���û����µ�userManager
					ContacterManager.contacters.remove(address);
					ContacterManager.contacters.put(address, user);
				}
				sendBroadcast(intent);
				// �û����£�getEntries�����
				// roster.getUnfiledEntries�е�entry�������
			}
		}

		@Override
		public void entriesDeleted(Collection<String> addresses) {
			for (String address : addresses) {
				Intent intent = new Intent();
				intent.setAction(Constant.ROSTER_DELETED);
				User user = null;
				if (ContacterManager.contacters.containsKey(address)) {
					user = ContacterManager.contacters.get(address);
					ContacterManager.contacters.remove(address);
				}
				intent.putExtra(User.userKey, user);
				sendBroadcast(intent);
			}
		}

		@Override
		public void entriesAdded(Collection<String> addresses) {
			for (String address : addresses) {
				Intent intent = new Intent();
				intent.setAction(Constant.ROSTER_ADDED);
				RosterEntry userEntry = roster.getEntry(address);
				User user = ContacterManager
						.transEntryToUser(userEntry, roster);
				ContacterManager.contacters.put(address, user);
				intent.putExtra(User.userKey, user);
				sendBroadcast(intent);
			}
		}
	};

}
