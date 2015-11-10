package csdn.shimiso.eim.manager;

import java.util.Iterator;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.OfflineMessageManager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.IActivitySupport;
import csdn.shimiso.eim.activity.im.ChatActivity;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.Notice;
import csdn.shimiso.eim.util.DateUtil;

/**
 * 
 * 离线信息管理类.
 * 
 * @author shimiso
 */
public class OfflineMsgManager {
	private static OfflineMsgManager offlineMsgManager = null;
	private IActivitySupport activitySupport;
	private Context context;

	private OfflineMsgManager(IActivitySupport activitySupport) {
		this.activitySupport = activitySupport;
		this.context = activitySupport.getContext();
	}

	public static OfflineMsgManager getInstance(IActivitySupport activitySupport) {
		if (offlineMsgManager == null) {
			offlineMsgManager = new OfflineMsgManager(activitySupport);
		}

		return offlineMsgManager;
	}

	/**
	 * 
	 * 处理离线消息.
	 * 
	 * @param connection
	 * @author shimiso
	 * @update 2012-7-9 下午5:45:32
	 */
	public void dealOfflineMsg(XMPPConnection connection) {
		OfflineMessageManager offlineManager = new OfflineMessageManager(
				connection);
		try {
			Iterator<org.jivesoftware.smack.packet.Message> it = offlineManager
					.getMessages();
			Log.i("离线消息数量: ", "" + offlineManager.getMessageCount());
			while (it.hasNext()) {
				org.jivesoftware.smack.packet.Message message = it.next();
				Log.i("收到离线消息", "Received from 【" + message.getFrom()
						+ "】 message: " + message.getBody());
				if (message != null && message.getBody() != null
						&& !message.getBody().equals("null")) {
					IMMessage msg = new IMMessage();
					String time = (String) message
							.getProperty(IMMessage.KEY_TIME);
					msg.setTime(time == null ? DateUtil.getCurDateStr() : time);
					msg.setContent(message.getBody());
					if (Message.Type.error == message.getType()) {
						msg.setType(IMMessage.ERROR);
					} else {
						msg.setType(IMMessage.SUCCESS);
					}
					String from = message.getFrom().split("/")[0];
					msg.setFromSubJid(from);

					// 生成通知
					NoticeManager noticeManager = NoticeManager
							.getInstance(context);
					Notice notice = new Notice();
					notice.setTitle("会话信息");
					notice.setNoticeType(Notice.CHAT_MSG);
					notice.setContent(message.getBody());
					notice.setFrom(from);
					notice.setStatus(Notice.UNREAD);
					notice.setNoticeTime(time == null ? DateUtil
							.getCurDateStr() : time);

					// 历史记录
					IMMessage newMessage = new IMMessage();
					newMessage.setMsgType(0);
					newMessage.setFromSubJid(from);
					newMessage.setContent(message.getBody());
					newMessage.setTime(time == null ? DateUtil.getCurDateStr()
							: time);
					MessageManager.getInstance(context).saveIMMessage(
							newMessage);

					long noticeId = noticeManager.saveNotice(notice);
					if (noticeId != -1) {
						Intent intent = new Intent(Constant.NEW_MESSAGE_ACTION);
						intent.putExtra(IMMessage.IMMESSAGE_KEY, msg);
						intent.putExtra("noticeId", noticeId);
						context.sendBroadcast(intent);
						activitySupport.setNotiType(
								R.drawable.icon,
								context.getResources().getString(
										R.string.new_message),
								notice.getContent(), ChatActivity.class, from);
					}
				}
			}

			offlineManager.deleteMessages();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
