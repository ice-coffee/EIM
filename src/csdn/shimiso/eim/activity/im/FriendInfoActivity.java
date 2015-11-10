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
 * 用户资料查看.
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
		// CharSequence[] items = { "手机相册", "手机拍照" };
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
	 * 选择提示对话框
	 */
	private void ShowPickDialog() {
		new AlertDialog.Builder(this)
				.setTitle("设置头像...")
				.setNegativeButton("相册", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						/**
						 * 刚开始，我自己也不知道ACTION_PICK是干嘛的，后来直接看Intent源码，
						 * 可以发现里面很多东西，Intent是个很强大的东西，大家一定仔细阅读下
						 */
						Intent intent = new Intent(Intent.ACTION_PICK, null);

						/**
						 * 下面这句话，与其它方式写是一样的效果，如果：
						 * intent.setData(MediaStore.Images
						 * .Media.EXTERNAL_CONTENT_URI);
						 * intent.setType(""image/*");设置数据类型
						 * 如果朋友们要限制上传到服务器的图片类型时可以直接写如
						 * ："image/jpeg 、 image/png等的类型"
						 * 这个地方小马有个疑问，希望高手解答下：就是这个数据URI与类型为什么要分两种形式来写呀？有什么区别？
						 */
						intent.setDataAndType(
								MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
								"image/*");
						startActivityForResult(intent, 1);

					}
				})
				.setPositiveButton("拍照", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
						/**
						 * 下面这句还是老样子，调用快速拍照功能，至于为什么叫快速拍照，大家可以参考如下官方
						 * 文档，you_sdk_path/docs/guide/topics/media/camera.html
						 * 我刚看的时候因为太长就认真看，其实是错的，这个里面有用的太多了，所以大家不要认为
						 * 官方文档太长了就不看了，其实是错的，这个地方小马也错了，必须改正
						 */
						Intent intent = new Intent(
								MediaStore.ACTION_IMAGE_CAPTURE);
						// 下面这句指定调用相机拍照后的照片存储的路径
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
		// 如果是直接从相册获取
		case 1:
			startPhotoZoom(data.getData());
			break;
		// 如果是调用相机拍照时
		case 2:
			File temp = new File(Environment.getExternalStorageDirectory()
					+ "/EIMhead/head.jpg");
			startPhotoZoom(Uri.fromFile(temp));
			break;
		// 取得裁剪后的图片
		case 3:
			/**
			 * 非空判断大家一定要验证，如果不验证的话， 在剪裁之后如果发现不满意，要重新裁剪，丢弃
			 * 当前功能时，会报NullException，小马只 在这个地方加下，大家可以根据不同情况在合适的 地方做判断处理类似情况
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
	 * 裁剪图片方法实现
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri) {
		/*
		 * 至于下面这个Intent的ACTION是怎么知道的，大家可以看下自己路径下的如下网页
		 * yourself_sdk_path/docs/reference/android/content/Intent.html
		 * 直接在里面Ctrl+F搜：CROP ，之前小马没仔细看过，其实安卓系统早已经有自带图片裁剪功能, 是直接调本地库的，小马不懂C C++
		 * 这个不做详细了解去了，有轮子就用轮子，不再研究轮子是怎么 制做的了...吼吼
		 */
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 150);
		intent.putExtra("outputY", 150);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, 3);
	}

	/**
	 * 保存裁剪之后的图片数据
	 * 
	 * @param picdata
	 */
	private void setPicToView(Intent picdata) {
		Bundle extras = picdata.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			Drawable drawable = new BitmapDrawable(photo);

			/**
			 * 下面注释的方法是将裁剪之后的图片以Base64Coder的字符方式上 传到服务器，QQ头像上传采用的方法跟这个类似
			 */

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			photo.compress(Bitmap.CompressFormat.JPEG, 60, stream);
			byte[] b = stream.toByteArray();
			// 将图片流以字符串形式存储下来

			// String tp = new String(Base64Coder.encodeLines(b));
			// 这个地方大家可以写下给服务器上传图片的实现，直接把tp直接上传就可以了，
			// 服务器处理的方法是服务器那边的事了，吼吼
			vc.setAvatar(b);
			try {
				vc.save(XmppConnectionManager.getInstance().getConnection());
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 如果下载到的服务器的数据还是以Base64Coder的形式的话，可以用以下方式转换
			// 为我们可以用的图片类型就OK啦...吼吼
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
