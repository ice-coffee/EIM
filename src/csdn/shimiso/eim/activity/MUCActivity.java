package csdn.shimiso.eim.activity;

import java.util.List;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.packet.MUCAdmin;

import com.zn.zxw.intelligencize.model.MucRoom;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.im.RoomChatActivity;
import csdn.shimiso.eim.adapter.RoomListAdapter;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.util.SLog;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MUCActivity extends BaseActivity implements OnItemClickListener {

	private EditText roomName, roomPwd, roomSubject;
	private ListView roomList;
	List<MucRoom> listRoom;
	XMPPConnection con;
	private RoomListAdapter adapter = null;
	EimApplication app;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.muc_home);
		roomName = (EditText) findViewById(R.id.roomName);
		roomPwd = (EditText) findViewById(R.id.roomPwd);
		roomSubject = (EditText) findViewById(R.id.roomSubject);
		roomList = (ListView) findViewById(R.id.roomList);
		roomList.setOnItemClickListener(this);
		app = EimApplication.getInstance();
		try {
			Class.forName("org.jivesoftware.smackx.ServiceDiscoveryManager",
					true, XmppConnectionManager.class.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = XmppConnectionManager.getInstance().getConnection();
		

	}

	public void onItemClick(AdapterView<?> arg0, View arg1, final int pos,
			long arg3) {
		// TODO Auto-generated method stub
		final MucRoom mr = listRoom.get(pos);
		final EditText et = new EditText(this);

		new AlertDialog.Builder(this).setTitle("请输入密码!")
				.setIcon(android.R.drawable.ic_dialog_info).setView(et)
				.setPositiveButton("确定", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						String input = et.getText().toString();
						join(MUCActivity.this, con.getUser(), input, mr
								.getName().toString());
						Toast.makeText(getApplicationContext(), "输入密码错误!",
								Toast.LENGTH_LONG);
					}
				}).setNegativeButton("取消", null).show();

	}

	@SuppressLint("NewApi")
	public void createRoom(View v) {
		String a = roomName.getText().toString();
		String b = roomPwd.getText().toString();
		String c = roomSubject.getText().toString();
		if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
			Toast.makeText(getApplicationContext(), "请填写完整房间信息!",
					Toast.LENGTH_SHORT).show();
		} else {
			app.execRunnable(new Runnable() {
				@Override
				public void run() {
					final MultiUserChat result = XmppConnectionManager.getInstance()
							.createRoom(roomName.getText().toString(),
									roomPwd.getText().toString(),
									roomSubject.getText().toString());
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (result!=null)
								Toast.makeText(MUCActivity.this, "创建成功",
										Toast.LENGTH_SHORT).show();
							else
								Toast.makeText(MUCActivity.this, "创建失败",
										Toast.LENGTH_SHORT).show();

						}
					});
				}
			});
		}
	}

	public void joinRoom(View v) {
		String a = roomName.getText().toString();
		String b = roomPwd.getText().toString();
		String c = roomSubject.getText().toString();
		if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
			Toast.makeText(getApplicationContext(), "请填写完整房间信息!",
					Toast.LENGTH_SHORT).show();
		} else {
			app.execRunnable(new Runnable() {
				@Override
				public void run() {
					join(MUCActivity.this, con.getUser(), roomPwd.getText()
							.toString(), roomName.getText().toString());
				}
			});
		}

	}

	public void getHostedRooms(View v) {
		roomList = (ListView) findViewById(R.id.roomList);

		try {
			listRoom = XmppConnectionManager.getInstance().getConferenceRoom();
			int size = listRoom.size();
			adapter = new RoomListAdapter(MUCActivity.this, listRoom);
			roomList.setAdapter(adapter);
			adapter.notifyDataSetChanged();

		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub

	}
}
