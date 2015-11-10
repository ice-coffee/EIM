package csdn.shimiso.eim.activity.im;

import java.util.List;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.ParticipantStatusListener;
import org.jivesoftware.smackx.pubsub.listener.ItemDeleteListener;


import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.EimApplication;
import csdn.shimiso.eim.adapter.MemberAdapter;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.util.FaceText;
import csdn.shimiso.eim.util.SLog;
import csdn.shimiso.eim.view.MainPageAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class RoomMemberActivity extends Activity implements ParticipantStatusListener,
OnItemClickListener{
	private ListView mlist;
	private MemberAdapter madapter;
	private XMPPConnection con;
	private MultiUserChat muc;
	private EimApplication app;
	private List<String> membersName;
	private String tag = "RoomMemberActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_member);
		mlist=(ListView)findViewById(R.id.room_mb_list);
		muc = XmppConnectionManager.getInstance().getMuc();
		con = XmppConnectionManager.getInstance().getConnection();
		app = EimApplication.getInstance();
		mlist.setOnItemClickListener(this);
		muc.addParticipantStatusListener(this);
		membersName = XmppConnectionManager.getInstance().getMUCMembers(muc);
		//MainPageAdapter = new MemberAdapter();
		madapter=new MemberAdapter(RoomMemberActivity.this,membersName);
		mlist.setAdapter(madapter);
		madapter.notifyDataSetChanged();
		
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
	
	private void initData(){
		app.execRunnable(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				membersName = XmppConnectionManager.getInstance().getMUCMembers(muc);
				madapter=new MemberAdapter(RoomMemberActivity.this,membersName);
				
				runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						mlist.setAdapter(madapter);
						madapter.notifyDataSetChanged();
					}});
				
			}});
		
	}
	private void showToast(final String msg){
		runOnUiThread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(RoomMemberActivity.this, msg, Toast.LENGTH_SHORT).show();
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
}
