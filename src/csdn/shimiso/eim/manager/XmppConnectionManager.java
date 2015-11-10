package csdn.shimiso.eim.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.zn.zxw.intelligencize.model.User;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.jivesoftware.smackx.OfflineMessageManager;
import org.jivesoftware.smackx.PrivateDataManager;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.ReportedData.Row;
import org.jivesoftware.smackx.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferListener;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferRequest;
import org.jivesoftware.smackx.filetransfer.IncomingFileTransfer;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;
import org.jivesoftware.smackx.filetransfer.FileTransfer.Status;
import org.jivesoftware.smackx.muc.DiscussionHistory;
import org.jivesoftware.smackx.muc.HostedRoom;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;
import org.jivesoftware.smackx.packet.ChatStateExtension;
import org.jivesoftware.smackx.packet.LastActivity;
import org.jivesoftware.smackx.packet.OfflineMessageInfo;
import org.jivesoftware.smackx.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.packet.SharedGroupsInfo;
import org.jivesoftware.smackx.packet.VCard;
import org.jivesoftware.smackx.provider.DataFormProvider;
import org.jivesoftware.smackx.provider.DelayInformationProvider;
import org.jivesoftware.smackx.provider.DiscoverInfoProvider;
import org.jivesoftware.smackx.provider.DiscoverItemsProvider;
import org.jivesoftware.smackx.provider.MUCAdminProvider;
import org.jivesoftware.smackx.provider.MUCOwnerProvider;
import org.jivesoftware.smackx.provider.MUCUserProvider;
import org.jivesoftware.smackx.provider.MessageEventProvider;
import org.jivesoftware.smackx.provider.MultipleAddressesProvider;
import org.jivesoftware.smackx.provider.RosterExchangeProvider;
import org.jivesoftware.smackx.provider.StreamInitiationProvider;
import org.jivesoftware.smackx.provider.VCardProvider;
import org.jivesoftware.smackx.provider.XHTMLExtensionProvider;
import org.jivesoftware.smackx.search.UserSearch;
import org.jivesoftware.smackx.search.UserSearchManager;
import com.zn.zxw.intelligencize.model.MucRoom;

import android.util.Log;
import csdn.shimiso.eim.model.LoginConfig;
import csdn.shimiso.eim.util.SLog;

/**
 * 
 * XMPP服务器连接工具类.
 * 
 * @author shimiso
 */
public class XmppConnectionManager {
	private XMPPConnection connection;
	public static final String DOMAIN = "@zhanNeng/Smack";
	private static ConnectionConfiguration connectionConfig;
	private static XmppConnectionManager xmppConnectionManager;
	private String tag = "XmppConnectionManager";
	private final String CONFERENCE = "@conference.";

	private XmppConnectionManager() {

	}

	private MultiUserChat muc;

	public MultiUserChat getMuc() {
		return muc;
	}

	public void setMuc(MultiUserChat muc) {
		this.muc = muc;
	}

	public static XmppConnectionManager getInstance() {
		if (xmppConnectionManager == null) {
			xmppConnectionManager = new XmppConnectionManager();
		}
		return xmppConnectionManager;
	}

	// init
	public XMPPConnection init(LoginConfig loginConfig) {

		Connection.DEBUG_ENABLED = false;
		ProviderManager pm = ProviderManager.getInstance();
		configure(pm);
		connectionConfig = new ConnectionConfiguration(
				loginConfig.getXmppHost(), loginConfig.getXmppPort(),
				loginConfig.getXmppServiceName());
		 try {
			Class.forName("org.jivesoftware.smackx.ServiceDiscoveryManager", true, XmppConnectionManager.class.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/// ServiceDiscoveryManager discoManager = new ServiceDiscoveryManager(connection);
		connectionConfig.setSASLAuthenticationEnabled(false);// 不使用SASL验证，设置为false
		connectionConfig
				.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
		// 允许自动连接
		connectionConfig.setReconnectionAllowed(false);
		// 允许登陆成功后更新在线状态
		connectionConfig.setSendPresence(true);
		// connectionConfig.setSendPresence(false);
		// 收到好友邀请后manual表示需要经过同意,accept_all表示不经同意自动为好友
		Roster.setDefaultSubscriptionMode(Roster.SubscriptionMode.manual);
		connection = new XMPPConnection(connectionConfig);
		return connection;
	}

	/**
	 * 
	 * 返回一个有效的xmpp连接,如果无效则返回空.
	 * 
	 * @return
	 * @author shimiso
	 * @update 2012-7-4 下午6:54:31
	 */
	public XMPPConnection getConnection() {
		if (connection == null) {
			throw new RuntimeException("请先初始化XMPPConnection连接");
		}
		return connection;
	}

	/**
	 * 
	 * 销毁xmpp连接.
	 * 
	 * @author shimiso
	 * @update 2012-7-4 下午6:55:03
	 */
	public void disconnect() {
		if (connection != null) {
			connection.disconnect();
		}
	}

	public void configure(ProviderManager pm) {

		// Private Data Storage
		pm.addIQProvider("query", "jabber:iq:private",
				new PrivateDataManager.PrivateDataIQProvider());

		// Time
		try {
			pm.addIQProvider("query", "jabber:iq:time",
					Class.forName("org.jivesoftware.smackx.packet.Time"));
		} catch (ClassNotFoundException e) {
		}

		// XHTML
		pm.addExtensionProvider("html", "http://jabber.org/protocol/xhtml-im",
				new XHTMLExtensionProvider());

		// Roster Exchange
		pm.addExtensionProvider("x", "jabber:x:roster",
				new RosterExchangeProvider());
		// Message Events
		pm.addExtensionProvider("x", "jabber:x:event",
				new MessageEventProvider());
		// Chat State
		pm.addExtensionProvider("active",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("composing",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("paused",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("inactive",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("gone",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());

		// FileTransfer
		pm.addIQProvider("si", "http://jabber.org/protocol/si",
				new StreamInitiationProvider());

		// Group Chat Invitations
		pm.addExtensionProvider("x", "jabber:x:conference",
				new GroupChatInvitation.Provider());
		// Service Discovery # Items
		pm.addIQProvider("query", "http://jabber.org/protocol/disco#items",
				new DiscoverItemsProvider());
		// Service Discovery # Info
		pm.addIQProvider("query", "http://jabber.org/protocol/disco#info",
				new DiscoverInfoProvider());
		// Data Forms
		pm.addExtensionProvider("x", "jabber:x:data", new DataFormProvider());
		// MUC User
		pm.addExtensionProvider("x", "http://jabber.org/protocol/muc#user",
				new MUCUserProvider());
		// MUC Admin
		pm.addIQProvider("query", "http://jabber.org/protocol/muc#admin",
				new MUCAdminProvider());
		// MUC Owner
		pm.addIQProvider("query", "http://jabber.org/protocol/muc#owner",
				new MUCOwnerProvider());
		// Delayed Delivery
		pm.addExtensionProvider("x", "jabber:x:delay",
				new DelayInformationProvider());
		// Version
		try {
			pm.addIQProvider("query", "jabber:iq:version",
					Class.forName("org.jivesoftware.smackx.packet.Version"));
		} catch (ClassNotFoundException e) {
		}
		// VCard
		pm.addIQProvider("vCard", "vcard-temp", new VCardProvider());
		// Offline Message Requests
		pm.addIQProvider("offline", "http://jabber.org/protocol/offline",
				new OfflineMessageRequest.Provider());
		// Offline Message Indicator
		pm.addExtensionProvider("offline",
				"http://jabber.org/protocol/offline",
				new OfflineMessageInfo.Provider());
		// Last Activity
		pm.addIQProvider("query", "jabber:iq:last", new LastActivity.Provider());
		// User Search
		pm.addIQProvider("query", "jabber:iq:search", new UserSearch.Provider());
		// SharedGroupsInfo
		pm.addIQProvider("sharedgroup",
				"http://www.jivesoftware.org/protocol/sharedgroup",
				new SharedGroupsInfo.Provider());
		// JEP-33: Extended Stanza Addressing
		pm.addExtensionProvider("addresses",
				"http://jabber.org/protocol/address",
				new MultipleAddressesProvider());
	//  VCard
		pm.addIQProvider("vCard",  "vcard-temp", new VCardProvider());

	}

	/**
	 * 获取所有分组
	 * 
	 * @param roster
	 * @return
	 */
	public List<RosterGroup> getGroups(Roster roster) {
		List<RosterGroup> list = new ArrayList<RosterGroup>();
		list.addAll(roster.getGroups());
		return list;
	}

	/**
	 * 添加分组
	 * 
	 * @param roster
	 * @param groupName
	 * @return
	 */
	public boolean addGroup(Roster roster, String groupName) {
		try {
			roster.createGroup(groupName);
			return true;
		} catch (Exception e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
		return false;
	}

	/**
	 * 添加到分组
	 * 
	 * @param roster
	 * @param userName
	 * @param groupName
	 */
	public void addUserToGroup(Roster roster, String userName, String groupName) {
		RosterGroup group = roster.getGroup(groupName);
		if (null == group) {
			group = roster.createGroup(groupName);
		}
		RosterEntry entry = roster.getEntry(userName);
		try {
			group.addEntry(entry);
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
	}

	/**
	 * 获取所有成员
	 * 
	 * @param roster
	 * @return
	 */
	public List<RosterEntry> getAllEntrys(Roster roster) {
		List<RosterEntry> list = new ArrayList<RosterEntry>();
		list.addAll(roster.getEntries());
		return list;
	}

	/**
	 * 获取某一个分组的成员
	 * 
	 * @param roster
	 * @param groupName
	 * @return
	 */
	public List<RosterEntry> getEntrysByGroup(Roster roster, String groupName) {
		List<RosterEntry> list = new ArrayList<RosterEntry>();
		RosterGroup group = roster.getGroup(groupName);
		list.addAll(group.getEntries());
		return list;
	}

	/**
	 * 获取用户VCard信息
	 * 
	 * @param user
	 * @return
	 */
	public VCard getVCard(String user) {
		VCard vCard = new VCard();
		try {
			vCard.load(connection, user);
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
			return null;
		}
		return vCard;
	}

	/**
	 * 添加好友
	 * 
	 * @param roster
	 * @param userName
	 * @param name
	 * @param groupName
	 *            是否有分组
	 * @return
	 */
	public boolean addUser(Roster roster, String userName, String name,
			String groupName) {
		try {
			roster.createEntry(userName, name, null == groupName ? null
					: new String[] { groupName });
			return true;
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
		return false;
	}

	/**
	 * 删除好友
	 * 
	 * @param roster
	 * @param userName
	 * @return
	 */
	public boolean removeUser(Roster roster, String userName) {
		try {
			if (userName.contains("@"))
				userName = userName.split("@")[0];
			RosterEntry entry = roster.getEntry(userName);
			if (null != entry)
				roster.removeEntry(entry);
			return true;
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
		return false;
	}

	/**
	 * 查找用户
	 * 
	 * @param serverDomain
	 * @param userName
	 * @return
	 */
	public List<User> searchUsers(String serverDomain, String userName) {
		List<User> list = new ArrayList<User>();
		UserSearchManager userSearchManager = new UserSearchManager(connection);
		try {
			Form searchForm = userSearchManager.getSearchForm("search."
					+ serverDomain);
			Form answerForm = searchForm.createAnswerForm();
			answerForm.setAnswer("Username", true);
			answerForm.setAnswer("Name", true);
			answerForm.setAnswer("search", userName);
			ReportedData data = userSearchManager.getSearchResults(answerForm,
					"search." + serverDomain);
			Iterator<Row> rows = data.getRows();
			while (rows.hasNext()) {
				User user = new User();
				Row row = rows.next();
				user.setUserName(row.getValues("Username").next().toString());
				user.setName(row.getValues("Name").next().toString());
				SLog.i(tag, user.toString());
				list.add(user);
			}
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
		return list;
	}

	/**
	 * 发送文件
	 * 
	 * @param recvUser
	 * @param filePath
	 */
	/*
	 * public void sendFile(String recvUser, String filePath) {
	 * FileTransferManager fileTransferManager = new
	 * FileTransferManager(connection); try { final OutgoingFileTransfer
	 * outgoingFileTransfer = fileTransferManager
	 * .createOutgoingFileTransfer(recvUser); SLog.i(tag, "上送文件" + filePath);
	 * outgoingFileTransfer.sendFile(new File(filePath),
	 * "outgoingFileTransfer ^_^"); SApp.getInstance().execRunnable(new
	 * Runnable() {
	 * 
	 * @Override public void run() { while (!outgoingFileTransfer.isDone()) {
	 * SLog.i(tag, "进度:" + outgoingFileTransfer.getProgress()); try {
	 * Thread.sleep(100); } catch (InterruptedException e) { SLog.e(tag,
	 * Log.getStackTraceString(e)); } } SLog.i(tag, "上送状态" +
	 * outgoingFileTransfer.getStatus()); if (outgoingFileTransfer.getStatus()
	 * .equals(Status.complete)) SLog.i(tag, "上送完毕"); else if
	 * (outgoingFileTransfer.getStatus().equals( Status.error)) SLog.i(tag,
	 * "上送出错"); } }); } catch (XMPPException e) { SLog.i(tag, "上送文件异常");
	 * SLog.e(tag, Log.getStackTraceString(e)); } }
	 */

	/**
	 * 注册文件接收器
	 */
	/*
	 * public void registRecvFileListener() { FileTransferManager
	 * fileTransferManager = new FileTransferManager(connection);
	 * fileTransferManager.addFileTransferListener(new FileTransferListener() {
	 * public void fileTransferRequest(final FileTransferRequest request) {
	 * final IncomingFileTransfer transfer = request.accept(); try { SLog.i(tag,
	 * "接受文件：" + transfer.getFileName()); transfer.recieveFile(new
	 * File(Environment .getExternalStorageDirectory() + "/" +
	 * request.getFileName())); SApp.getInstance().execRunnable(new Runnable() {
	 * 
	 * @Override public void run() { while (!transfer.isDone()) { SLog.i(tag,
	 * "进度:" + transfer.getProgress()); try { Thread.sleep(100); } catch
	 * (InterruptedException e) { SLog.e(tag, Log.getStackTraceString(e)); } }
	 * SLog.i(tag, "接受状态" + transfer.getStatus()); if
	 * (transfer.getStatus().equals(Status.complete)) SLog.i(tag, "接受完毕"); else
	 * if (transfer.getStatus().equals(Status.error)) { transfer.cancel();
	 * SLog.i(tag, "接受出错"); } } }); } catch (Exception e) { SLog.e(tag,
	 * Log.getStackTraceString(e)); SLog.e(tag, "文件接收出错"); transfer.cancel(); }
	 * } }); }
	 */

	/**
	 * 获取离线消息
	 * 
	 * @return
	 */
	public List<Message> getOffLineMessages() {
		List<Message> msgs = new ArrayList<Message>();
		OfflineMessageManager offLineMessageManager = new OfflineMessageManager(
				connection);
		try {
			Iterator<Message> it = offLineMessageManager.getMessages();
			while (it.hasNext()) {
				Message msg = it.next();
				SLog.i(tag, msg.toXML());
				msgs.add(msg);
			}
			offLineMessageManager.deleteMessages();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return msgs;
	}

	/**
	 * 初始化聊服务会议列表
	 */
	/*
	 * private void initHostRoom() { Collection<HostedRoom> hostrooms; try {
	 * hostrooms = MultiUserChat.getHostedRooms(connection,
	 * connection.getServiceName()); for (HostedRoom entry : hostrooms) {
	 * roominfos.add(entry); Log.i(TAG, "名字：" + entry.getName() + " - ID:" +
	 * entry.getJid()); } Log.i(TAG, "服务会议数量:" + roominfos.size()); } catch
	 * (XMPPException e) { e.printStackTrace(); } }
	 */
	/**
	 * 创建会议室
	 * 
	 * @param roomName
	 * @param roomPwd
	 *            会议室密码
	 */
	public MultiUserChat createRoom(String roomName, String roomPwd, String subject) {
		MultiUserChat multiUserChat = new MultiUserChat(connection, roomName
				+ CONFERENCE + connection.getServiceName());
		try {
			multiUserChat.create(roomName);
			Form configForm = multiUserChat.getConfigurationForm();
			Form submitForm = configForm.createAnswerForm();
			for (Iterator<FormField> fields = configForm.getFields(); fields
					.hasNext();) {
				FormField formField = fields.next();
				if (!formField.getType().equals(FormField.TYPE_HIDDEN)
						&& formField.getVariable() != null) {
					submitForm.setDefaultAnswer(formField.getVariable());
				}
			}

			List<String> owners = new ArrayList<String>();
			owners.add(connection.getUser());
			//submitForm.setAnswer("muc#roomconfig_roomowners", owners);
			submitForm.setAnswer("muc#roomconfig_passwordprotectedroom", true);
			// 设置聊天室是持久聊天室，即将要被保存下来
			submitForm.setAnswer("muc#roomconfig_persistentroom", true);
			// 房间仅对成员开放
			submitForm.setAnswer("muc#roomconfig_membersonly", false);
			// 允许占有者邀请其他人
			submitForm.setAnswer("muc#roomconfig_allowinvites", true);
			// 允许加入的成员数
			submitForm.setAnswer("muc#roomconfig_maxusers", Arrays.asList("30"));
			// 能够发现占有者真实 JID 的角色
			// submitForm.setAnswer("muc#roomconfig_whois", "anyone");
			// 登录房间对话
			submitForm.setAnswer("muc#roomconfig_enablelogging", true);
			// 仅允许注册的昵称登录
			submitForm.setAnswer("x-muc#roomconfig_reservednick", true);
			// 允许使用者修改昵称
			submitForm.setAnswer("x-muc#roomconfig_canchangenick", false);
			// 允许用户注册房间
			submitForm.setAnswer("x-muc#roomconfig_registration", false);
			// 设置进入密码
			submitForm.setAnswer("muc#roomconfig_roomsecret", roomPwd);
			submitForm.setAnswer("muc#roomconfig_roomdesc", subject);
			multiUserChat.sendConfigurationForm(submitForm);

		} catch (XMPPException e) {
			SLog.e(tag, "创建聊天室 出错");
			SLog.e(tag, Log.getStackTraceString(e));
			e.getStackTrace();
		}
		return multiUserChat;
	}

	/**
	 * 加入聊天室
	 * 
	 * @param user
	 * @param pwd
	 *            会议室密码
	 * @param roomName
	 * @return
	 */
	public MultiUserChat joinRoom(String user, String pwd, String roomName) {
		MultiUserChat muc = new MultiUserChat(connection,
				roomName.contains(CONFERENCE) ? roomName : roomName
						+ CONFERENCE + connection.getServiceName());
		DiscussionHistory history = new DiscussionHistory();
		history.setMaxStanzas(100);
		history.setSince(new Date(2014, 07, 31));
		// history.setSince(new Date());
		try {
			muc.join(user, pwd, history,
					SmackConfiguration.getPacketReplyTimeout());
			Message msg = muc.nextMessage();
			if (null != msg)
				SLog.i(tag, msg.toXML());

			Message msg2 = muc.nextMessage(100);
			if (null != msg2)
				SLog.i(tag, msg2.toXML());

		} catch (XMPPException e) {
			SLog.e(tag, " 加入 聊天室 出错");
			SLog.e(tag, Log.getStackTraceString(e));
			return null;
		}
		return muc;
	}

	/**
	 * 获取会议室成员名字
	 * 
	 * @param muc
	 * @return
	 */
	public List<String> getMUCMembers(MultiUserChat muc) {
		List<String> members = new ArrayList<String>();
		Iterator<String> it = muc.getOccupants();
		while (it.hasNext()) {
			String name = StringUtils.parseResource(it.next());
			SLog.i("成员名字", name);
			members.add(name);
		}
		return members;
	}

	/**
	 * 获取Hostedrooms
	 * 
	 * @return
	 */
	public List<MucRoom> getAllHostedRooms() {
		List<MucRoom> rooms = new ArrayList<MucRoom>();
		try {
			new ServiceDiscoveryManager(connection);
			Collection<HostedRoom> hrooms = MultiUserChat.getHostedRooms(
					connection, connection.getServiceName());
			if (!hrooms.isEmpty()) {
				for (HostedRoom r : hrooms) {
					RoomInfo roominfo = MultiUserChat.getRoomInfo(connection,
							r.getJid());
					SLog.i("会议室Info", roominfo.toString());
					MucRoom mr = new MucRoom();
					mr.setDescription(roominfo.getDescription());
					mr.setName(r.getName());
					mr.setJid(r.getJid());
					mr.setOccupants(roominfo.getOccupantsCount());
					mr.setSubject(roominfo.getSubject());
					rooms.add(mr);
				}
			}
		} catch (XMPPException e) {
			SLog.e(tag, " 获取Hosted Rooms 出错");
			SLog.e(tag, Log.getStackTraceString(e));
		}
		return rooms;
	}

	public List<MucRoom> getJoinedRooms() {
		List<MucRoom> rooms = new ArrayList<MucRoom>();
		Iterator<String> jrs = MultiUserChat.getJoinedRooms(connection,
				connection.getUser());
		return rooms;
	}

	/**
	 * 创建给予聊天室的私聊
	 * 
	 * @param participant
	 *            myroom@conference.jabber.org/johndoe
	 * @param listener
	 * @return
	 */
	public Chat createPrivateChat(String participant, MessageListener listener) {
		return muc.createPrivateChat(participant, listener);
	}

	/**
	 * 用户是否支持聊天室
	 * 
	 * @param user
	 * @return
	 */
	// public boolean isUserSupportMUC(String user){
	// return MultiUserChat.isServiceEnabled(con, user);
	// }

	/**
	 * 离开聊天室
	 */
	public void leaveRoom() {
		if (null != muc)
			muc.leave();
		muc = null;
	}
	
	/** 
     * 获取服务器上所有会议室 
     * @return 
     * @throws XMPPException 
     */  
    public  List<MucRoom> getConferenceRoom() throws XMPPException {  
        List<MucRoom> list = new ArrayList<MucRoom>();  
        new ServiceDiscoveryManager(connection);  
        if (!MultiUserChat.getHostedRooms(connection,  
                connection.getServiceName()).isEmpty()) {  
            for (HostedRoom k : MultiUserChat.getHostedRooms(connection,  
                    connection.getServiceName())) {  
  
                for (HostedRoom j : MultiUserChat.getHostedRooms(connection,  
                        k.getJid())) {  
                    RoomInfo info2 = MultiUserChat.getRoomInfo(connection,  
                            j.getJid());  
                    if (j.getJid().indexOf("@") > 0) {  
  
                    	MucRoom friendrooms = new MucRoom();  
                        friendrooms.setName(j.getName());//聊天室的名称  
                        friendrooms.setJid(j.getJid());//聊天室JID  
                        friendrooms.setOccupants(info2.getOccupantsCount());//聊天室中占有者数量  
                        friendrooms.setDescription(info2.getDescription());//聊天室的描述  
                        friendrooms.setSubject(info2.getSubject());//聊天室的主题  
                        list.add(friendrooms);  
                    }  
                }  
            }  
        }  
        return list;  
    }  

    /**
	 * 用户是否支持聊天室
	 * @param user
	 * @return
	 */
	public boolean isUserSupportMUC(String user){
		return MultiUserChat.isServiceEnabled(connection, user);
	}
}
