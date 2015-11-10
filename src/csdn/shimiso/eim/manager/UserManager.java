package csdn.shimiso.eim.manager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.VCard;

import android.content.Context;

public class UserManager {
	private static UserManager userManager = null;

	private UserManager() {

	}

	public static UserManager getInstance(Context context) {

		if (userManager == null) {
			userManager = new UserManager();
		}

		return userManager;
	}

	/**
	 * 
	 * 获取用户的vcard信息 .
	 * 
	 * @return
	 * @author shimiso
	 * @update 2013-4-16 下午1:32:03
	 */
	public VCard getUserVCard(String jid) {
		XMPPConnection xmppConn = XmppConnectionManager.getInstance()
				.getConnection();
		VCard vcard = new VCard();
		try {
			vcard.load(xmppConn, jid);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return vcard;
	}

	/**
	 * 
	 * 保存用户的vcard信息. 注：修改vcard时，头像会丢失，此处为asmack.jar的bug，目前还无法修复
	 * 
	 * @param vCard
	 * @return
	 * @author shimiso
	 * @update 2013-4-16 下午2:39:37
	 */
	public VCard saveUserVCard(VCard vCard) {
		XMPPConnection xmppConn = XmppConnectionManager.getInstance()
				.getConnection();
		try {
			vCard.save(xmppConn);
			return getUserVCard(vCard.getJabberId());
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 获取用户头像信息 .
	 * 
	 * @param connection
	 * @param jid
	 * @return
	 * @author shimiso
	 * @update 2013-4-16 下午1:31:52
	 */
	public InputStream getUserImage(String jid) {
		XMPPConnection connection = XmppConnectionManager.getInstance()
				.getConnection();
		InputStream ic = null;
		try {
			System.out.println("获取用户头像信息: " + jid);
			VCard vcard = new VCard();
			vcard.load(connection, jid);

			if (vcard == null || vcard.getAvatar() == null) {
				return null;
			}
			ByteArrayInputStream bais = new ByteArrayInputStream(
					vcard.getAvatar());
			return bais;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ic;
	}
}
