package csdn.shimiso.eim.activity.im;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.VCard;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 
 * @author Administrator
 * 
 */
public class ProfileChangeActivity extends Activity implements OnClickListener {

	private Button changeBtn;
	private TextView profileFieldTextView;

	private String profileField;
	private String profileValue;
	private XMPPConnection con;
	Button change_profile_reback_btn;
	VCard vc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_change);
		vc=new VCard();
		con=XmppConnectionManager.getInstance().getConnection();
		changeBtn = (Button) findViewById(R.id.change_profile_btn);
		change_profile_reback_btn = (Button) findViewById(R.id.change_profile_reback_btn);
		
		change_profile_reback_btn.setOnClickListener(this);
		changeBtn.setOnClickListener(this);

		profileFieldTextView = (TextView) findViewById(R.id.change_profile_user_edit);

		profileField = getIntent().getStringExtra("profileField");
		profileValue = getIntent().getStringExtra("value");

		profileFieldTextView.setText(profileValue);
	}

	public void changeProfile() {
		profileValue = profileFieldTextView.getText().toString();
		if (profileValue.length() <= 0) {
			Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
			return;
		}

		changeBtn.setEnabled(false);
		// 设置个人资料
		if(profileField.equals("NICKNAME")){
			vc.setNickName(profileValue);
		}
		else if(profileField.equals("COMPANY")){
			vc.setOrganization(profileValue);
		}
		else if(profileField.equals("JOB")){
			vc.setEmailWork(profileValue);
		}
		else if(profileField.equals("SIGNATURE")){
			vc.setLastName(profileValue);
		}
		try {
			vc.save(con);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.change_profile_reback_btn:
			finish();
			break;
		case R.id.change_profile_btn:
			changeProfile();
			break;
		default:
			break;
		}
	}

	

}
