package csdn.shimiso.eim.activity;

import android.os.Message;

public interface HandlerListener {
	public void sendMsg(org.jivesoftware.smack.packet.Message message);
}
