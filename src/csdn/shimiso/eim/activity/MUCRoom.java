package csdn.shimiso.eim.activity;

import java.util.Date;
import java.util.List;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.muc.InvitationListener;
import org.jivesoftware.smackx.muc.InvitationRejectionListener;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.Occupant;
import org.jivesoftware.smackx.muc.ParticipantStatusListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.zn.zxw.intelligencize.model.MucHistory;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.util.SLog;

public class MUCRoom extends Activity implements InvitationRejectionListener, InvitationListener, ParticipantStatusListener, PacketListener, OnItemClickListener {
	
	private String tag = "MUCRoom";
	
	ListView membersList , chatsList;
	TextView subject;
	EditText content;
	XMPPConnection con;
	MultiUserChat muc;
	
	List<String> membersName;
	
	EimApplication app;
	MemberAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.muc_room);
		con = XmppConnectionManager.getInstance().getConnection();
		muc = XmppConnectionManager.getInstance().getMuc();
		muc.addInvitationRejectionListener(this);
		MultiUserChat.addInvitationListener(con, this);
		muc.addParticipantStatusListener(this);
		muc.addMessageListener(this);
		app = EimApplication.getInstance();
		membersList = (ListView) findViewById(R.id.members);
		chatsList = (ListView) findViewById(R.id.chats);
		content = (EditText) findViewById(R.id.content);
		membersList.setOnItemClickListener(this);
		initData();
		
	}
	
	class MemberAdapter extends BaseAdapter{
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return membersName.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View view, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if(null == view){
				view = LayoutInflater.from(MUCRoom.this).inflate(android.R.layout.simple_list_item_1, null);
			}
			TextView text = (TextView) view.findViewById(android.R.id.text1);
			text.setText(membersName.get(arg0));
			return view;
		}
		
	}
	
	private void initData(){
		app.execRunnable(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				membersName = XmppConnectionManager.getInstance().getMUCMembers(muc);
				mAdapter = new MemberAdapter();
				runOnUiThread(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						membersList.setAdapter(mAdapter);
					}});
				
			}});
		
	}
	
	public void invite(View v){
		final List<RosterEntry> friends = XmppConnectionManager.getInstance().getAllEntrys(con.getRoster());
		String[] names = new String[friends.size()];
		for(int i=0;i<friends.size();i++){
			RosterEntry entry = friends.get(i);
			names[i] = entry.getName();
		}
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("选择好友");
		builder.setItems(names, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int pos) {
				// TODO Auto-generated method stub
				dialog.cancel();
//				if(XmppTool.getInstance().isUserSupportMUC(friends.get(pos).getUser()))
					muc.invite(friends.get(pos).getUser(), "加入我的会议室吧");
//				else
//					Toast.makeText(MUCRoom.this, "该好友设置了不加入会议室", Toast.LENGTH_SHORT).show();
			}
		});
		builder.create().show();
	}
	
	public void send(View v){
		try {
			muc.sendMessage(content.getText().toString());
			content.setText("");
		} catch (XMPPException e) {
			SLog.e(tag, Log.getStackTraceString(e));
		}
	}
	
	@Override
	protected void onDestroy() {
		XmppConnectionManager.getInstance().leaveRoom();
		MultiUserChat.removeInvitationListener(con, this);
		super.onDestroy();
	}

	@Override
	public void invitationDeclined(final String invitee, final String reason) {
		// TODO Auto-generated method stub
		SLog.i(tag, "被邀请者:"+invitee+" , 原因:"+reason);
		runOnUiThread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(MUCRoom.this, "被邀请者:"+invitee+" , 原因:"+reason, Toast.LENGTH_SHORT).show();
			}});
	}

	@Override
	public void invitationReceived(Connection conn, final String room, final String inviter, String reason, final String password, Message msg) {
		// TODO Auto-generated method stub
		SLog.i(tag, "room:"+room+" , inviter:" +inviter+" , reason" + reason +" , password:"+password+" , msg:"+msg.toXML());
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("选择好友");
		builder.setMessage(inviter+" 邀请我加入 "+room);
		builder.setPositiveButton("加入", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
//				MultiUserChat tmp = XmppConnectionManager.getInstance().joinRoom(con.getUser(), password, room);
//				if(null!=tmp){
//					XmppConnectionManager.getInstance().leaveRoom();
//					XmppConnectionManager.getInstance().setMuc(tmp);
//					Toast.makeText(MUCRoom.this, "切换房间成功", Toast.LENGTH_SHORT).show();
//					SLog.i(tag, "重新初始化房间.....");
//				}else{
//					Toast.makeText(MUCRoom.this, "进入新房间失败", Toast.LENGTH_SHORT).show();
//					SLog.i(tag, "呆着不动.....");
//				}
			}
		});
		builder.setNeutralButton("拒绝", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				MultiUserChat.decline(con, room, inviter, "I'm too busy");
			}});
		
		runOnUiThread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				builder.create().show();
			}});
	}
	
	private void showToast(final String msg){
		runOnUiThread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(MUCRoom.this, msg, Toast.LENGTH_SHORT).show();
			}});
		
	}
	
	@Override
	public void adminGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "adminGranted"+arg0);
		showToast("adminGranted"+arg0);
	}

	@Override
	public void adminRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "adminRevoked"+arg0);
		showToast("adminRevoked"+arg0);
	}

	@Override
	public void banned(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		SLog.i(tag, "banned"+arg0+","+arg1+","+arg2);
		showToast("banned"+arg0+","+arg1+","+arg2);
		initData();
	}

	@Override
	public void joined(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "joined"+arg0);
		showToast("joined"+arg0);
		initData();
	}

	@Override
	public void kicked(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		SLog.i(tag, "kicked"+arg0+" , "+arg1+" , "+arg2);
		showToast("kicked"+arg0+" , "+arg1+" , "+arg2);
		initData();
	}

	@Override
	public void left(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "left"+arg0);
		showToast("left"+arg0);
		initData();
	}

	@Override
	public void membershipGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "membershipGranted"+arg0);
		showToast( "membershipGranted"+arg0);
	}

	@Override
	public void membershipRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "membershipRevoked"+arg0);
		showToast("membershipRevoked"+arg0);
	}

	@Override
	public void moderatorGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "moderatorGranted"+arg0);
		showToast("moderatorGranted"+arg0);
	}

	@Override
	public void moderatorRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "moderatorRevoked"+arg0);
		showToast("moderatorRevoked"+arg0);
	}

	@Override
	public void nicknameChanged(String arg0, String arg1) {
		// TODO Auto-generated method stub
		SLog.i(tag, "nicknameChanged"+arg0);
		showToast("nicknameChanged"+arg0);
	}

	@Override
	public void ownershipGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "ownershipGranted"+arg0);
		showToast("ownershipGranted"+arg0);
	}

	@Override
	public void ownershipRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "ownershipRevoked"+arg0);
		showToast("ownershipRevoked"+arg0);
	}

	@Override
	public void voiceGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "voiceGranted"+arg0);
		showToast("voiceGranted"+arg0);
	}

	@Override
	public void voiceRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "voiceRevoked"+arg0);
		showToast( "voiceRevoked"+arg0);
	}

	@Override
	public void processPacket(Packet packet) {
		// TODO Auto-generated method stub
		SLog.i(tag, packet.toXML());
		Message msg = (Message) packet;
		String from = StringUtils.parseResource(msg.getFrom());
		showToast(from+" 说："+msg.getBody());
		
	}

	private String[] memberActions = {"私聊","踢了他"};
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, final int pos, long arg3) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择");
		builder.setItems(memberActions, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				if(0==which){
					//私聊代码
				}else if(1==which){
					try {
						String jid = membersName.get(pos);
						SLog.i(tag, " jid:"+jid);
						muc.banUser(jid.contains(XmppConnectionManager.DOMAIN)?jid:jid+XmppConnectionManager.DOMAIN, "你被踢了");
					} catch (XMPPException e) {
						SLog.e(tag, Log.getStackTraceString(e));
					}
				}
			}
		});
		builder.create().show();
		
	}

}
