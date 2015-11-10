package csdn.shimiso.eim.service;

import java.util.Calendar;
import java.util.HashMap;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Packet;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.IBinder;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.notice.MyNoticeActivity;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.NoticeManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.Notice;
import csdn.shimiso.eim.util.DateUtil;

/**
 * 
 * ϵͳ��Ϣ����.
 * 
 * @author shimiso
 */
public class IMSystemMsgService extends Service {
	private Context context;
	PacketCollector myCollector = null;
	/* ����������� */
	private NotificationManager myNotiManager;

	SoundPool sp; // ����SoundPool������
	HashMap<Integer, Integer> hm; // ����һ��HashMap����������ļ�
	int currStreamId;// ��ǰ�����ŵ�streamId

	@Override
	public void onCreate() {
		context = this;
		super.onCreate();
		initSysTemMsgManager();
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
		XmppConnectionManager.getInstance().getConnection()
				.removePacketListener(pListener);
		super.onDestroy();
	}

	private void initSysTemMsgManager() {
		initSoundPool();
		XMPPConnection con = XmppConnectionManager.getInstance()
				.getConnection();
		con.addPacketListener(pListener, new MessageTypeFilter(
				Message.Type.normal));
	}

	// ����Ϣ����
	PacketListener pListener = new PacketListener() {

		@Override
		public void processPacket(Packet packetz) {
			Message message = (Message) packetz;

			if (message.getType() == Type.normal) {

				NoticeManager noticeManager = NoticeManager
						.getInstance(context);
				Notice notice = new Notice();
				// playSound(1, 0); //������Ч

				notice.setTitle("ϵͳ��Ϣ");
				notice.setNoticeType(Notice.SYS_MSG);
				notice.setFrom(packetz.getFrom());
				notice.setContent(message.getBody());
				notice.setNoticeTime(DateUtil.date2Str(Calendar.getInstance(),
						Constant.MS_FORMART));
				notice.setFrom(packetz.getFrom());
				notice.setTo(packetz.getTo());
				notice.setStatus(Notice.UNREAD);

				long noticeId = noticeManager.saveNotice(notice);
				if (noticeId != -1) {
					Intent intent = new Intent();
					intent.setAction(Constant.ACTION_SYS_MSG);
					notice.setId(String.valueOf(noticeId));
					intent.putExtra("notice", notice);
					sendBroadcast(intent);
					setNotiType(R.drawable.icon, Constant.SYS_MSG_DIS,
							message.getBody(), MyNoticeActivity.class);

				}
			}
		}
	};

	// ��ʼ�������صķ���
	public void initSoundPool() {
		sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0); // ����SoundPool����
		hm = new HashMap<Integer, Integer>(); // ����HashMap����
		// hm.put(1, sp.load(this, R.raw.musictest, 1)); //
		// ���������ļ�musictest��������Ϊ1����������hm��
	}

	// ���������ķ���
	public void playSound(int sound, int loop) { // ��ȡAudioManager����
		AudioManager am = (AudioManager) this
				.getSystemService(Context.AUDIO_SERVICE);
		// ��ȡ��ǰ����
		float streamVolumeCurrent = am
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		// ��ȡϵͳ�������
		float streamVolumeMax = am
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		// ����õ���������
		float volume = streamVolumeCurrent / streamVolumeMax;
		// ����SoundPool��play���������������ļ�
		currStreamId = sp.play(hm.get(sound), volume, volume, 1, loop, 1.0f);
	}

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

}
