package csdn.shimiso.eim.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import Decoder.BASE64Decoder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.RoomMsg;
import csdn.shimiso.eim.util.BASE64Encoder;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.FaceTextUtils;
import csdn.shimiso.eim.util.StringUtil;

public class RoomChatAdapter extends BaseAdapter {
	private static final String PATH = "/sdcard/MyVoiceForder/Record/";
	private List<RoomMsg> items;
	private Context context;
	private ListView adapterList;
	private LayoutInflater inflater;
	private MediaPlayer mMediaPlayer = new MediaPlayer();
	public RoomChatAdapter(Context context, List<RoomMsg> items,ListView adapterList) {
		this.context = context;
		this.items = items;
		inflater = LayoutInflater.from(context);
		this.adapterList = adapterList;
	}

	public void refresh(List<RoomMsg> list) {
		items = list;
		this.notifyDataSetChanged();
		adapterList.smoothScrollToPosition(items.size() - 1);
	}

	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RoomMsg message = items.get(position);
		String[] strarray;
		String voiceFile;
		String voiceTime;
		int msgViewTime;
		if (message.getType() == 0) {
			if (message.getCnt().contains(CommonUtils.PIC_SIGN)) {
				convertView = this.inflater.inflate(R.layout.chat_rce_picture,
						null);
			} else {
				convertView = this.inflater.inflate(
						R.layout.formclient_chat_in, null);
			}
		} else {
			if (message.getCnt().contains(CommonUtils.PIC_SIGN)) {
				convertView = this.inflater.inflate(R.layout.chat_send_picture,
						null);
			} else {
				convertView = this.inflater.inflate(
						R.layout.formclient_chat_out, null);
			}
		}
		ImageView imageMsg = (ImageView) convertView
				.findViewById(R.id.send_picture);
		TextView useridView = (TextView) convertView
				.findViewById(R.id.formclient_row_userid);
		TextView dateView = (TextView) convertView
				.findViewById(R.id.formclient_row_date);
		TextView msgView = (TextView) convertView
				.findViewById(R.id.formclient_row_msg);
		TextView voiceTimeView = (TextView) convertView
				.findViewById(R.id.voice_time);
		dateView.setText(message.getTime());
		if (message.getType() == 0) {
			if (message.getCnt().contains(CommonUtils.PIC_SIGN)) {
				String[] arr = message.getCnt().split(CommonUtils.PIC_SIGN);
				String image2 = GenerateImage(arr[1]);
				Bitmap bp = BitmapCommon.setBitmapSize(image2);
				imageMsg.setImageBitmap(bp);
				File file = new File(image2);
				imageMsg.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						// System.out.println(voiceFileDir);
						Intent i = new Intent();

					}
				});
				// deleteFile(file);
			} else if (message.getCnt().contains(CommonUtils.VOICE_SIGN)) {
				strarray = message.getCnt().split("&");
				voiceFile = strarray[0];
				voiceTime = strarray[1];
				msgViewTime = Integer.parseInt(voiceTime);
				String msgViewLength = "";
				voiceTimeView.setVisibility(View.VISIBLE);
				voiceTimeView.setText(voiceTime + "\"");
				for (int i = 0; i < msgViewTime; i++) {
					msgViewLength += "  ";
				}
				String voiceArr[] = voiceFile.split(CommonUtils.VOICE_SIGN);
				// String image2 = GenerateImage(voiceArr[1]);
				final String voiceFileDir = GenerateVoic(voiceArr[1]);
				msgView.setText(msgViewLength);
				msgView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.chatto_voice_playing, 0);
				msgView.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						System.out.println(voiceFileDir);
						if (voiceFileDir.contains(".amr")) {
							playMusic(voiceFileDir);
						}
					}
				});
				File file = new File(voiceFileDir);
				// deleteFile(file);
			} else {
				SpannableString spannableString = FaceTextUtils
						.toSpannableString(context, message.getCnt());
				msgView.setText(spannableString);
				// viewHolder.tvContent.setCompoundDrawablesWithIntrinsicBounds(0,
				// 0, 0, 0);
				// viewHolder.tvTime.setText("");
			}
			useridView.setText(message.getFrom());

		} else {
			if (message.getCnt().contains(CommonUtils.PIC_SIGN)) {
				String[] arr = message.getCnt().split(CommonUtils.PIC_SIGN);
				String image2 = GenerateImage(arr[1]);
				// bp = BitmapCommon.setBitmapSize(localSelectPath);
				Bitmap bp = BitmapCommon.setBitmapSize(image2);
				imageMsg.setImageBitmap(bp);
				File file = new File(image2);
				// deleteFile(file);
			}

			else if (message.getCnt().contains(CommonUtils.VOICE_SIGN)) {
				strarray = message.getCnt().split("&");
				voiceFile = strarray[0];
				voiceTime = strarray[1];
				msgViewTime = Integer.parseInt(voiceTime);
				String msgViewLength = "";
				voiceTimeView.setVisibility(View.VISIBLE);
				voiceTimeView.setText(voiceTime + "\"");
				for (int i = 0; i < msgViewTime; i++) {
					msgViewLength += "  ";
				}
				String voiceArr[] = voiceFile.split(CommonUtils.VOICE_SIGN);
				// String image2 = GenerateImage(voiceArr[1]);
				final String voiceFileDir = GenerateVoic(voiceArr[1]);
				// final String voiceFileDir = voiceFile;
				msgView.setText(msgViewLength);
				msgView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.chatto_voice_playing, 0);
				msgView.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						System.out.println(voiceFileDir);
						if (voiceFileDir.contains(".amr")) {
							playMusic(voiceFileDir);
						}
					}
				});
				File file = new File(voiceFileDir);
				// deleteFile(file);
			} else {
				SpannableString spannableString = FaceTextUtils
						.toSpannableString(context, message.getCnt());
				msgView.setText(spannableString);
			}
			useridView.setText(message.getFrom());
		}
		return convertView;
	}

	public static String GetImageStr(String imagDir) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		// String imgFile =
		// "d://test.jpg";//待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imagDir);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	// base64字符串转化成图片
	public static String GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = PATH + UUID.randomUUID().toString() + ".jpg";// 新生成的图片
			// File directory = new File(imgFilePath).getParentFile();
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return imgFilePath;
		} catch (Exception e) {
			return null;
		}
	}

	// base64字符串转化成音频
	public static String GenerateVoic(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = PATH + UUID.randomUUID().toString() + ".amr";// 新生成的图片
			// File directory = new File(imgFilePath).getParentFile();
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return imgFilePath;
		} catch (Exception e) {
			return null;
		}
	}

	private void playMusic(String name) {
		try {
			if (mMediaPlayer.isPlaying()) {
				mMediaPlayer.stop();
			}
			System.out.println(name + "haha");
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(name);
			mMediaPlayer.prepare();
			mMediaPlayer.start();
			mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}