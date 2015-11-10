package csdn.shimiso.eim.service;

import java.util.Calendar;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.im.ChatActivity;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.MessageManager;
import csdn.shimiso.eim.manager.NoticeManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.Notice;
import csdn.shimiso.eim.util.DateUtil;

/**
 * 
 * �������.
 * 
 * @author shimiso
 */
public class IMChatService extends Service {
	private Context context;
	private NotificationManager notificationManager;

	@Override
	public void onCreate() {
		context = this;
		super.onCreate();
		initChatManager();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private void initChatManager() {
		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		XMPPConnection conn = XmppConnectionManager.getInstance()
				.getConnection();
		conn.addPacketListener(pListener, new MessageTypeFilter(
				Message.Type.chat));
	}

	PacketListener pListener = new PacketListener() {

		@Override
		public void processPacket(Packet arg0) {
			Message message = (Message) arg0;
			if (message != null && message.getBody() != null
					&& !message.getBody().equals("null")) {
				IMMessage msg = new IMMessage();
				// String time = (String)
				// message.getProperty(IMMessage.KEY_TIME);
				String time = DateUtil.date2Str(Calendar.getInstance(),
						Constant.MS_FORMART);
				msg.setTime(time);
				msg.setContent(message.getBody());
				if (Message.Type.error == message.getType()) {
					msg.setType(IMMessage.ERROR);
				} else {
					msg.setType(IMMessage.SUCCESS);
				}
				String from = message.getFrom().split("/")[0];
				msg.setFromSubJid(from);

				// ����֪ͨ
				NoticeManager noticeManager = NoticeManager
						.getInstance(context);
				Notice notice = new Notice();
				notice.setTitle("�Ự��Ϣ");
				notice.setNoticeType(Notice.CHAT_MSG);
				notice.setContent(message.getBody());
				notice.setFrom(from);
				notice.setStatus(Notice.UNREAD);
				notice.setNoticeTime(time);

				// ��ʷ��¼
				IMMessage newMessage = new IMMessage();
				newMessage.setMsgType(0);
				newMessage.setFromSubJid(from);
				newMessage.setContent(message.getBody());
				newMessage.setTime(time);
				MessageManager.getInstance(context).saveIMMessage(newMessage);
				long noticeId = -1;

				noticeId = noticeManager.saveNotice(notice);

				if (noticeId != -1) {
					Intent intent = new Intent(Constant.NEW_MESSAGE_ACTION);
					intent.putExtra(IMMessage.IMMESSAGE_KEY, msg);
					intent.putExtra("notice", notice);
					sendBroadcast(intent);
					setNotiType(R.drawable.icon,
							getResources().getString(R.string.new_message),
							notice.getContent(), ChatActivity.class, from);
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
			String contentText, Class activity, String from) {

		/*
		 * �����µ�Intent����Ϊ���Notification������ʱ�� �����е�Activity
		 */
		Intent notifyIntent = new Intent(this, activity);
		notifyIntent.putExtra("to", from);
		// notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		/* ����PendingIntent��Ϊ���õ������е�Activity */
		PendingIntent appIntent = PendingIntent.getActivity(this, 0,
				notifyIntent, 0);

		/* ����Notication����������ز��� */
		Notification myNoti = new Notification();
		// ����Զ���ʧ
		myNoti.flags = Notification.FLAG_AUTO_CANCEL;
		/* ����statusbar��ʾ��icon */
		myNoti.icon = iconId;
		/* ����statusbar��ʾ��������Ϣ */
		myNoti.tickerText = contentTitle;
		/* ����notification����ʱͬʱ����Ĭ������ */
		myNoti.defaults = Notification.DEFAULT_SOUND;
		/* ����Notification�������Ĳ��� */
		myNoti.setLatestEventInfo(this, contentTitle, contentText, appIntent);
		/* �ͳ�Notification */
		notificationManager.notify(0, myNoti);
	}
}
