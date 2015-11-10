package csdn.shimiso.eim.activity;

import org.jivesoftware.smack.packet.Message;

public interface MessageListener {
	public void success(Message message);
}
