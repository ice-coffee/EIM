package csdn.shimiso.eim.service;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;

import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.util.SLog;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class PresenceService extends Service {

	private XMPPConnection con;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		con = XmppConnectionManager.getInstance().getConnection();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		if (null != con && con.isConnected()) {
			PacketFilter filter = new AndFilter(new PacketTypeFilter(
					Presence.class), new MessageTypeFilter(Message.Type.chat));
			PacketListener listener = new PacketListener() {
				@Override
				public void processPacket(Packet packet) {
					SLog.i("Presence", "PresenceService------" + packet.toXML());
					// 看API可知�?Presence是Packet的子�?
					if (packet instanceof Presence) {
						Presence presence = (Presence) packet;
						// Presence还有很多方法，可查看API
						String from = presence.getFrom();// 发�?�?
						String to = presence.getTo();// 接收�?
						// Presence.Type�?中状�?
						if (presence.getType().equals(Presence.Type.subscribe)) {// 好友申请

						} else if (presence.getType().equals(
								Presence.Type.subscribed)) {// 同意添加好友

						} else if (presence.getType().equals(
								Presence.Type.unsubscribe)) {// 拒绝添加好友 �?删除好友

						} else if (presence.getType().equals(
								Presence.Type.unsubscribed)) {// 这个我没用到
						} else if (presence.getType().equals(
								Presence.Type.unavailable)) {// 好友下线
																// 要更新好友列表，可以在这收到包后，发广播到指定页�?
																// 更新列表

						} else if (presence.getType().equals(
								Presence.Type.available)) {// 好友上线

						}
					} else if (packet instanceof Message) {
						Message msg = (Message) packet;
						Toast.makeText(getApplicationContext(),
								msg.getFrom() + " 说：" + msg.getBody(),
								Toast.LENGTH_SHORT).show();
					}
				}
			};
			con.addPacketListener(listener, filter);
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

}
