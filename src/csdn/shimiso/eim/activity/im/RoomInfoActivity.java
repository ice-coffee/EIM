package csdn.shimiso.eim.activity.im;

import java.util.List;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChat;

import com.zn.zxw.intelligencize.model.MucRoom;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoomInfoActivity extends Activity implements android.view.View.OnClickListener{
	private TextView room_id,room_name,room_des,room_them,room_num;
	private Button btn_clear,btn_back;
	private XMPPConnection con;
	private MultiUserChat muc;
	private List<String> membersName;
	private List<MucRoom> listRoom;
	private MucRoom mr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_info);
		initView();
		muc = XmppConnectionManager.getInstance().getMuc();
		con = XmppConnectionManager.getInstance().getConnection();
		membersName = XmppConnectionManager.getInstance().getMUCMembers(muc);
		
		try {
			listRoom=XmppConnectionManager.getInstance().getConferenceRoom();
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String rn=roomName(muc.getRoom());
		mr=selectRoom(listRoom,rn);
		room_des.setText(mr.getDescription());
		room_num.setText(membersName.size()+"");
		room_id.setText(mr.getJid());
		room_name.setText(rn);
		btn_back.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
	}
	private void initView() {
		// TODO Auto-generated method stub
		room_id=(TextView)findViewById(R.id.group_id_detail);
		room_name=(TextView)findViewById(R.id.group_nickname_detail);
		room_des=(TextView)findViewById(R.id.group_description_detail);
		room_them=(TextView)findViewById(R.id.group_subject_detail);
		room_num=(TextView)findViewById(R.id.group_occupants_detail);
		btn_clear=(Button)findViewById(R.id.make_it_black);
		btn_back=(Button)findViewById(R.id.add_friends_reback_btn);
	}
	public String roomName(String name){
		return name.split("@")[0];
	}
	public MucRoom selectRoom(List<MucRoom> listRoom,String name){
		MucRoom mr=null;
		 for(int i=0;i<listRoom.size();i++){
			 if(listRoom.get(i).getName().equals(name)){
				 mr=listRoom.get(i);
			 }
		 }
		 return mr;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.add_friends_reback_btn:
			RoomInfoActivity.this.finish();
			break;
		case R.id.make_it_black:
			break;
		}
	}
	

}
