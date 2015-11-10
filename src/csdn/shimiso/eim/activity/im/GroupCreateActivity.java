package csdn.shimiso.eim.activity.im;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.muc.MultiUserChat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.EimApplication;
import csdn.shimiso.eim.activity.MUCActivity;
import csdn.shimiso.eim.manager.XmppConnectionManager;

public class GroupCreateActivity extends Activity implements OnClickListener {

	private Button mBackBtn;
	private EditText mMUCNameEdit;
	private EditText mMUCNickPWDEdit;
	private EditText mMUCDescriptionEdit;
	private Button mCreateBtn;
	private XMPPConnection con;
	private EimApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_muc);

		mBackBtn = (Button) findViewById(R.id.add_reback_btn);
		mBackBtn.setOnClickListener(this);

		mMUCNameEdit = (EditText) findViewById(R.id.new_muc_name);
		mMUCNickPWDEdit = (EditText) findViewById(R.id.new_muc_nickname);
		mMUCDescriptionEdit = (EditText) findViewById(R.id.new_muc_description);
		app = EimApplication.getInstance();
		con = XmppConnectionManager.getInstance().getConnection();
		mCreateBtn = (Button) findViewById(R.id.create_btn);
		mCreateBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int viewId = v.getId();
		switch (viewId) {
		case R.id.add_reback_btn:
			finish();
			break;
		case R.id.create_btn:
			String qunId = mMUCNameEdit.getText().toString();
			String qunNickPwd = mMUCNickPWDEdit.getText().toString();
			String qunMiaoshu = mMUCDescriptionEdit.getText().toString();
			if ("".equals(qunId) || "".equals(qunNickPwd)
					|| "".equals(qunMiaoshu)) {
				showToast();
			} else {
				createRoom();
			}

			break;
		default:
			break;
		}
	}

	public void createRoom() {
		new AlertDialog.Builder(this)
		.setMessage("确认要创建群?")
		.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,
							int which) {
							app.execRunnable(new Runnable() {
								@Override
								public void run() {
									final MultiUserChat muc = XmppConnectionManager.getInstance()
											.createRoom(mMUCNameEdit.getText().toString(),
													mMUCNickPWDEdit.getText().toString(),
													mMUCDescriptionEdit.getText().toString());
//									final MultiUserChat muc = XmppConnectionManager.getInstance().joinRoom(con.getUser(),mMUCNickPWDEdit.getText().toString(),
//											mMUCNameEdit.getText().toString());
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											if (muc!=null){
												XmppConnectionManager.getInstance().setMuc(muc);
												Toast.makeText(GroupCreateActivity.this,
														"创建成功", Toast.LENGTH_SHORT).show();
											    GroupCreateActivity.this.finish();
												Intent intent = new Intent(GroupCreateActivity.this, RoomChatActivity.class);
												startActivity(intent);
											}
											else
												Toast.makeText(GroupCreateActivity.this,
														"创建失败", Toast.LENGTH_SHORT).show();

										}
									});
								}
							});
					
						}}).setNegativeButton("取消", null).create().show();
		
	}

	private void showToast() {
		Toast toast = Toast.makeText(getApplicationContext(), "资料都不填完整，怎么创建群聊......",
				Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(R.drawable.tips_error);
		toastView.addView(imageCodeProject, 0);
		toast.show();
	}
	
	
}
