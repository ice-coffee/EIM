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
 * 系统消息服务.
 * 
 * @author shimiso
 */
public class IMSystemMsgService extends Service {
	private Context context;
	PacketCollector myCollector = null;
	/* 声明对象变量 */
	private NotificationManager myNotiManager;

	SoundPool sp; // 声明SoundPool的引用
	HashMap<Integer, Integer> hm; // 声明一个HashMap来存放声音文件
	int currStreamId;// 当前正播放的streamId

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

	// 来消息监听
	PacketListener pListener = new PacketListener() {

		@Override
		public void processPacket(Packet packetz) {
			Message message = (Message) packetz;

			if (message.getType() == Type.normal) {

				NoticeManager noticeManager = NoticeManager
						.getInstance(context);
				Notice notice = new Notice();
				// playSound(1, 0); //播放音效

				notice.setTitle("系统消息");
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

	// 初始化声音池的方法
	public void initSoundPool() {
		sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0); // 创建SoundPool对象
		hm = new HashMap<Integer, Integer>(); // 创建HashMap对象
		// hm.put(1, sp.load(this, R.raw.musictest, 1)); //
		// 加载声音文件musictest并且设置为1号声音放入hm中
	}

	// 播放声音的方法
	public void playSound(int sound, int loop) { // 获取AudioManager引用
		AudioManager am = (AudioManager) this
				.getSystemService(Context.AUDIO_SERVICE);
		// 获取当前音量
		float streamVolumeCurrent = am
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		// 获取系统最大音量
		float streamVolumeMax = am
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		// 计算得到播放音量
		float volume = streamVolumeCurrent / streamVolumeMax;
		// 调用SoundPool的play方法来播放声音文件
		currStreamId = sp.play(hm.get(sound), volume, volume, 1, loop, 1.0f);
	}

	/**
	 * 
	 * 发出Notification的method.
	 * 
	 * @param iconId
	 *            图标
	 * @param contentTitle
	 *            标题
	 * @param contentText
	 *            你内容
	 * @param activity
	 * @author shimiso
	 * @update 2012-5-14 下午12:01:55
	 */
	private void setNotiType(int iconId, String contentTitle,
			String contentText, Class activity) {
		/*
		 * 创建新的Intent，作为点击Notification留言条时， 会运行的Activity
		 */
		Intent notifyIntent = new Intent(this, activity);
		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		/* 创建PendingIntent作为设置递延运行的Activity */
		PendingIntent appIntent = PendingIntent.getActivity(this, 0,
				notifyIntent, 0);

		/* 创建Notication，并设置相关参数 */
		Notification myNoti = new Notification();
		/* 设置statusbar显示的icon */
		myNoti.icon = iconId;
		/* 设置statusbar显示的文字信息 */
		myNoti.tickerText = contentTitle;
		/* 设置notification发生时同时发出默认声音 */
		myNoti.defaults = Notification.DEFAULT_SOUND;
		/* 设置Notification留言条的参数 */
		myNoti.setLatestEventInfo(this, contentTitle, contentText, appIntent);
		/* 送出Notification */
		myNotiManager.notify(0, myNoti);
	}

}
