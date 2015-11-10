package csdn.shimiso.eim.activity;

import org.jivesoftware.smackx.packet.VCard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.LoginConfig;
import csdn.shimiso.eim.task.LoginTask;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.StringUtil;
import csdn.shimiso.eim.util.ValidateUtil;

/**
 * 
 * 登录.
 * 
 * @author shimiso
 */
public class LoginActivity extends ActivitySupport {
	private EditText edt_username, edt_pwd;
	private CheckBox rememberCb, autologinCb, novisibleCb;
	private Button btn_login = null;
	private LoginConfig loginConfig;
	private VCard vc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		init();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 校验SD卡
		checkMemoryCard();
		// 检测网络和版本
		validateInternet();
		// 初始化xmpp配置
		XmppConnectionManager.getInstance().init(loginConfig);
	}

	/**
	 * 
	 * 初始化.
	 * 
	 * @author shimiso
	 * @update 2012-5-16 上午9:13:01
	 */
	protected void init() {
		vc=new VCard();
		loginConfig = getLoginConfig();
		// 如果为自动登录
		if (loginConfig.isAutoLogin()) {
			LoginTask loginTask = new LoginTask(LoginActivity.this, loginConfig);
			loginTask.execute();
		}
		edt_username = (EditText) findViewById(R.id.ui_username_input);
		edt_pwd = (EditText) findViewById(R.id.ui_password_input);
		rememberCb = (CheckBox) findViewById(R.id.remember);
		autologinCb = (CheckBox) findViewById(R.id.autologin);
		novisibleCb = (CheckBox) findViewById(R.id.novisible);
		btn_login = (Button) findViewById(R.id.ui_login_btn);

		// 初始化各组件的默认状态
		edt_username.setText(loginConfig.getUsername());
		edt_pwd.setText(loginConfig.getPassword());
		rememberCb.setChecked(loginConfig.isRemember());
		rememberCb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (!isChecked)
					autologinCb.setChecked(false);
			}
		});
		autologinCb.setChecked(loginConfig.isAutoLogin());
		novisibleCb.setChecked(loginConfig.isNovisible());
		
		btn_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkData() && validateInternet()) {
					CommonUtils.createSDCardDir();
					String username = edt_username.getText().toString();
					String password = edt_pwd.getText().toString();
					vc.setFirstName(edt_username.getText().toString());
					// 先记录下各组件的目前状态,登录成功后才保存
					loginConfig.setPassword(password);
					loginConfig.setUsername(username);
					loginConfig.setRemember(rememberCb.isChecked());
					loginConfig.setAutoLogin(autologinCb.isChecked());
					loginConfig.setNovisible(novisibleCb.isChecked());

					LoginTask loginTask = new LoginTask(LoginActivity.this,
							loginConfig);
				    loginTask.execute();
				}
			}
		});
	}

	/**
	 * 
	 * 登录校验.
	 * 
	 * @return
	 * @author shimiso
	 * @update 2012-5-16 上午9:12:37
	 */
	private boolean checkData() {
		boolean checked = false;
		checked = (!ValidateUtil.isEmpty(edt_username, "登录名") && !ValidateUtil
				.isEmpty(edt_pwd, "密码"));
		return checked;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.login_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final EditText xmppHostText = new EditText(context);
		xmppHostText.setText(loginConfig.getXmppHost());
		switch (item.getItemId()) {
		case R.id.menu_login_set:
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			dialog.setTitle("服务器设置")
					.setIcon(android.R.drawable.ic_dialog_info)
					.setView(xmppHostText)
					.setMessage("请设置服务器IP地址")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									String xmppHost = StringUtil
											.doEmpty(xmppHostText.getText()
													.toString());
									loginConfig.setXmppHost(xmppHost);
									XmppConnectionManager.getInstance().init(
											loginConfig);
									LoginActivity.this
											.saveLoginConfig(loginConfig);
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();// 取消弹出框
								}
							}).create().show();

			break;
		case R.id.menu_relogin:
			Intent intent = new Intent();
			intent.setClass(context, LoginActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.menu_exit:
			isExit();
			break;
		}
		return true;

	}

	@Override
	public void onBackPressed() {
		isExit();
	}
}
