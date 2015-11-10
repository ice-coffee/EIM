package csdn.shimiso.eim.activity.im;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.packet.VCard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.util.Base64Coder;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.util.CommonUtils;

/**
 * 
 * �û����ϲ鿴.
 * 
 * @author shimiso
 */
public class FriendInfoActivity extends ActivitySupport {
	private VCard vc;
	private TextView personal_company_detail;
	private TextView personal_username_detail;
	private TextView personal_nickname_detail;
	private TextView personal_job_detail;
	private TextView personal_signature_detail;
	private ImageView personal_head_imageview;
	private String imagePath;
	private Button mBackBtn;
	private XMPPConnection con;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		con = XmppConnectionManager.getInstance().getConnection();
		init();
		personal_username_detail.setText(con.getUser());
		if (vc != null) {
			String nickName = vc.getNickName();
			String company = vc.getOrganization();
			String job = vc.getEmailWork();
			String signature = vc.getLastName();
			if (nickName==null) {
				personal_nickname_detail.setText("");
			} else {
				personal_nickname_detail.setText(nickName);
			}

			if (company==null) {
				personal_company_detail.setText("");
			} else {
				personal_company_detail.setText(company);
			}
			if (job==null) {
				personal_job_detail.setText("");
			} else {
				personal_job_detail.setText(job);
			}
			if (signature==null) {
				personal_signature_detail.setText("");
			} else {
				personal_signature_detail.setText(signature);
			}
		}

	}

	private void init() {
		getEimApplication().addActivity(this);
		vc = new VCard();
		mBackBtn = (Button) findViewById(R.id.profile_reback_btn);
		personal_username_detail = (TextView) findViewById(R.id.personal_username_detail);
		// personal_username_detail.setText(KFSettingsManager.getSettingsManager(
		// this).getUsername());

		personal_nickname_detail = (TextView) findViewById(R.id.personal_nickname_detail);

		personal_company_detail = (TextView) findViewById(R.id.personal_company_detail);

		personal_job_detail = (TextView) findViewById(R.id.personal_job_detail);

		personal_signature_detail = (TextView) findViewById(R.id.personal_signature_detail);

		personal_head_imageview = (ImageView) findViewById(R.id.personal_head_imageview);

		mBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		}); 
		personal_head_imageview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowPickDialog();
			}
		});
		try {
			vc.load(con, con.getUser());
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vc.getAvatar()!=null){
			String by = new String(vc.getAvatar());
			String headImg = CommonUtils.GenerateImage(by, "head");
			Bitmap bp = BitmapCommon.setBitmapSize(headImg);
			personal_head_imageview.setImageBitmap(bp);
		}
	}

	public void change_avatar(View v) {
		// CharSequence[] items = { "�ֻ����", "�ֻ�����" };
		// imageChooseItem(items);
		ShowPickDialog();
	}

	public void change_nickname(View v) {
		Intent intent = new Intent(this, ProfileChangeActivity.class);
		intent.putExtra("profileField", "NICKNAME");
		intent.putExtra("value", vc.getNickName());
		startActivity(intent);
	}

	public void change_company(View v) {
		Intent intent = new Intent(this, ProfileChangeActivity.class);
		intent.putExtra("profileField", "COMPANY");
		intent.putExtra("value", vc.getOrganization());
		startActivity(intent);
	}

	public void change_job(View v) {
		Intent intent = new Intent(this, ProfileChangeActivity.class);
		intent.putExtra("profileField", "JOB");
		intent.putExtra("value", vc.getEmailWork());
		startActivity(intent);
	}

	public void change_signature(View v) {
		Intent intent = new Intent(this, ProfileChangeActivity.class);
		intent.putExtra("profileField", "SIGNATURE");
		intent.putExtra("value", vc.getLastName());
		startActivity(intent);
	}

	@Override
	protected void onStart() {
		super.onStart();

		/*
		 * IntentFilter intentFilter = new IntentFilter();
		 * intentFilter.addAction(KFMainService.ACTION_IM_GET_AVATAR_RESULT);
		 * registerReceiver(mXmppreceiver, intentFilter);
		 */
	}

	/**
	 * ѡ����ʾ�Ի���
	 */
	private void ShowPickDialog() {
		new AlertDialog.Builder(this)
				.setTitle("����ͷ��...")
				.setNegativeButton("���", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						/**
						 * �տ�ʼ�����Լ�Ҳ��֪��ACTION_PICK�Ǹ���ģ�����ֱ�ӿ�IntentԴ�룬
						 * ���Է�������ܶණ����Intent�Ǹ���ǿ��Ķ��������һ����ϸ�Ķ���
						 */
						Intent intent = new Intent(Intent.ACTION_PICK, null);

						/**
						 * ������仰����������ʽд��һ����Ч���������
						 * intent.setData(MediaStore.Images
						 * .Media.EXTERNAL_CONTENT_URI);
						 * intent.setType(""image/*");������������
						 * ���������Ҫ�����ϴ�����������ͼƬ����ʱ����ֱ��д��
						 * ��"image/jpeg �� image/png�ȵ�����"
						 * ����ط�С���и����ʣ�ϣ�����ֽ���£������������URI������ΪʲôҪ��������ʽ��дѽ����ʲô����
						 */
						intent.setDataAndType(
								MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
								"image/*");
						startActivityForResult(intent, 1);

					}
				})
				.setPositiveButton("����", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						/**
						 * ������仹�������ӣ����ÿ������չ��ܣ�����Ϊʲô�п������գ���ҿ��Բο����¹ٷ�
						 * �ĵ���you_sdk_path/docs/guide/topics/media/camera.html
						 * �Ҹտ���ʱ����Ϊ̫�������濴����ʵ�Ǵ�ģ�����������õ�̫���ˣ����Դ�Ҳ�Ҫ��Ϊ
						 * �ٷ��ĵ�̫���˾Ͳ����ˣ���ʵ�Ǵ�ģ�����ط�С��Ҳ���ˣ��������
						 */
						Intent intent = new Intent(
								MediaStore.ACTION_IMAGE_CAPTURE);
						// �������ָ������������պ����Ƭ�洢��·��
						intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri
								.fromFile(new File(Environment
										.getExternalStorageDirectory(),
										"/EIMhead/head.jpg")));
						startActivityForResult(intent, 2);
					}
				}).show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		// �����ֱ�Ӵ�����ȡ
		case 1:
			startPhotoZoom(data.getData());
			break;
		// ����ǵ����������ʱ
		case 2:
			File temp = new File(Environment.getExternalStorageDirectory()
					+ "/EIMhead/head.jpg");
			startPhotoZoom(Uri.fromFile(temp));
			break;
		// ȡ�òü����ͼƬ
		case 3:
			/**
			 * �ǿ��жϴ��һ��Ҫ��֤���������֤�Ļ��� �ڼ���֮��������ֲ����⣬Ҫ���²ü�������
			 * ��ǰ����ʱ���ᱨNullException��С��ֻ ������ط����£���ҿ��Ը��ݲ�ͬ����ں��ʵ� �ط����жϴ����������
			 * 
			 */
			if (data != null) {
				setPicToView(data);
			}
			break;
		default:
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * �ü�ͼƬ����ʵ��
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri) {
		/*
		 * �����������Intent��ACTION����ô֪���ģ���ҿ��Կ����Լ�·���µ�������ҳ
		 * yourself_sdk_path/docs/reference/android/content/Intent.html
		 * ֱ��������Ctrl+F�ѣ�CROP ��֮ǰС��û��ϸ��������ʵ��׿ϵͳ���Ѿ����Դ�ͼƬ�ü�����, ��ֱ�ӵ����ؿ�ģ�С����C C++
		 * ���������ϸ�˽�ȥ�ˣ������Ӿ������ӣ������о���������ô ��������...���
		 */
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// �������crop=true�������ڿ�����Intent��������ʾ��VIEW�ɲü�
		intent.putExtra("crop", "true");
		// aspectX aspectY �ǿ�ߵı���
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY �ǲü�ͼƬ���
		intent.putExtra("outputX", 150);
		intent.putExtra("outputY", 150);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 3);
	}

	/**
	 * ����ü�֮���ͼƬ����
	 * 
	 * @param picdata
	 */
	private void setPicToView(Intent picdata) {
		Bundle extras = picdata.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			Drawable drawable = new BitmapDrawable(photo);

			/**
			 * ����ע�͵ķ����ǽ��ü�֮���ͼƬ��Base64Coder���ַ���ʽ�� ������������QQͷ���ϴ����õķ������������
			 */

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 60, stream);
			byte[] b = stream.toByteArray();
			// ��ͼƬ�����ַ�����ʽ�洢����

			// String tp = new String(Base64Coder.encodeLines(b));
			// ����ط���ҿ���д�¸��������ϴ�ͼƬ��ʵ�֣�ֱ�Ӱ�tpֱ���ϴ��Ϳ����ˣ�
			// ����������ķ����Ƿ������Ǳߵ����ˣ����
			vc.setAvatar(b);
			try {
				vc.save(XmppConnectionManager.getInstance().getConnection());
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ������ص��ķ����������ݻ�����Base64Coder����ʽ�Ļ������������·�ʽת��
			// Ϊ���ǿ����õ�ͼƬ���;�OK��...���
			/*
			 * Bitmap dBitmap = BitmapFactory.decodeFile(tp); Drawable drawable
			 * = new BitmapDrawable(dBitmap);
			 */
			personal_head_imageview.setBackgroundDrawable(drawable);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		try {
			vc.load(con,con.getUser());
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vc != null) {
			String nickName = vc.getNickName();
			String company = vc.getOrganization();
			String job = vc.getEmailWork();
			String signature = vc.getLastName();
			if (nickName==null) {
				personal_nickname_detail.setText("");
			} else {
				personal_nickname_detail.setText(nickName);
			}

			if (company==null) {
				personal_company_detail.setText("");
			} else {
				personal_company_detail.setText(company);
			}
			if (job==null) {
				personal_job_detail.setText("");
			} else {
				personal_job_detail.setText(job);
			}
			if (signature==null) {
				personal_signature_detail.setText("");
			} else {
				personal_signature_detail.setText(signature);
			}
		}

	}
	
}
