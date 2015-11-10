package csdn.shimiso.eim.activity.im;

import java.io.InputStream;

import org.jivesoftware.smackx.packet.VCard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.manager.UserManager;
import csdn.shimiso.eim.model.LoginConfig;
import csdn.shimiso.eim.util.StringUtil;

/**
 * 
 * 用户资料查看.
 * 
 * @author shimiso
 */
public class UserInfoActivity extends ActivitySupport {
	private ImageView titleBack, userimageView;
	private LinearLayout user_info_detail, user_info_edit;
	private Button edit_btn, finish_btn;
	private TextView firstnameView, nicknameView, orgnameView, orgunitView,
			mobileView, emailhomeView, discView;
	private EditText firstnameEdit, nicknameEdit, orgnameEdit, orgunitEdit,
			mobileEdit, emailhomeEdit, discEdit;
	private UserManager userManager;
	private LoginConfig loginConfig;
	private VCard vCard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_info);
		init();
	}

	private void init() {
		userManager = UserManager.getInstance(this);
		loginConfig = getLoginConfig();
		userimageView = (ImageView) findViewById(R.id.userimage);
		firstnameView = (TextView) findViewById(R.id.firstname);
		nicknameView = (TextView) findViewById(R.id.nickname);
		orgnameView = (TextView) findViewById(R.id.orgname);
		orgunitView = (TextView) findViewById(R.id.orgunit);
		mobileView = (TextView) findViewById(R.id.mobile);
		emailhomeView = (TextView) findViewById(R.id.emailhome);
		discView = (TextView) findViewById(R.id.disc);

		firstnameEdit = (EditText) findViewById(R.id.e_firstname);
		nicknameEdit = (EditText) findViewById(R.id.e_nickname);
		orgnameEdit = (EditText) findViewById(R.id.e_orgname);
		orgunitEdit = (EditText) findViewById(R.id.e_orgunit);
		mobileEdit = (EditText) findViewById(R.id.e_mobile);
		emailhomeEdit = (EditText) findViewById(R.id.e_emailhome);
		discEdit = (EditText) findViewById(R.id.e_disc);

		String jid = StringUtil.getJidByName(loginConfig.getUsername(),
				loginConfig.getXmppServiceName());
		vCard = userManager.getUserVCard(jid);
		InputStream is = userManager.getUserImage(jid);
		if (is != null) {
			Bitmap bm = BitmapFactory.decodeStream(is);
			userimageView.setImageBitmap(bm);
		}
		setVCardView(vCard);

		titleBack = (ImageView) findViewById(R.id.title_back);
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(1);
				finish();
			}
		});
		user_info_detail = (LinearLayout) findViewById(R.id.user_info_detail);
		user_info_edit = (LinearLayout) findViewById(R.id.user_info_edit);
		edit_btn = (Button) findViewById(R.id.edit_btn);
		finish_btn = (Button) findViewById(R.id.finish_btn);
		edit_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish_btn.setVisibility(View.VISIBLE);
				user_info_edit.setVisibility(View.VISIBLE);
				edit_btn.setVisibility(View.GONE);
				user_info_detail.setVisibility(View.GONE);
				discView.setVisibility(View.GONE);
				discEdit.setVisibility(View.VISIBLE);
			}
		});

		finish_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vCard.setFirstName(firstnameEdit.getText().toString());
				vCard.setNickName(nicknameEdit.getText().toString());
				vCard.setOrganization(orgnameEdit.getText().toString());
				vCard.setOrganizationUnit(orgunitEdit.getText().toString());
				vCard.setField("MOBILE", mobileEdit.getText().toString());
				vCard.setEmailHome(emailhomeEdit.getText().toString());
				vCard.setField("DESC", discEdit.getText().toString());
				vCard = userManager.saveUserVCard(vCard);
				if (vCard != null) {
					setVCardView(vCard);
					finish_btn.setVisibility(View.GONE);
					user_info_edit.setVisibility(View.GONE);
					edit_btn.setVisibility(View.VISIBLE);
					user_info_detail.setVisibility(View.VISIBLE);
					discView.setVisibility(View.VISIBLE);
					discEdit.setVisibility(View.GONE);
					showToast("用户信息已保存!");
				} else {
					showToast("更新用户信息失败!");
				}
			}
		});

	}

	private void setVCardView(VCard vCard) {
		firstnameView.setText(vCard.getFirstName());
		nicknameView.setText(vCard.getNickName());
		orgnameView.setText(vCard.getOrganization());
		orgunitView.setText(vCard.getOrganizationUnit());
		mobileView.setText(vCard.getField("MOBILE"));
		emailhomeView.setText(vCard.getEmailHome());
		discView.setText(vCard.getField("DESC"));

		firstnameEdit.setText(vCard.getFirstName());
		nicknameEdit.setText(vCard.getNickName());
		orgnameEdit.setText(vCard.getOrganization());
		orgunitEdit.setText(vCard.getOrganizationUnit());
		mobileEdit.setText(vCard.getField("MOBILE"));
		emailhomeEdit.setText(vCard.getEmailHome());
		discEdit.setText(vCard.getField("DESC"));
	}
}
