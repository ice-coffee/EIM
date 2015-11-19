package csdn.shimiso.eim.activity.im;

import csdn.shimiso.eim.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddFriendActivity extends Activity implements View.OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	private TextView tv;
	private Button add_btn,back_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friend);
		initView();
		add_btn.setOnClickListener(this);
		back_btn.setOnClickListener(this);
	}
	private void initView() {
		// TODO Auto-generated method stub
		tv=(TextView)findViewById(R.id.add_user_edit);
		add_btn=(Button)findViewById(R.id.add_btn);
		back_btn=(Button)findViewById(R.id.add_reback_btn);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.add_btn:
			break;
		case R.id.add_reback_btn:
			finish();
			break;
		default:
			break;

		}
	}

}
