package csdn.shimiso.eim.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import csdn.shimiso.eim.model.IMMessage;

import Decoder.BASE64Decoder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

public class CommonUtils {
	public static final String PATH = "/sdcard/MyVoiceForder/Record/";
	public static final String PATHIMG = "/sdcard/MyImageForder/Record/";
	public static final String PIC_SIGN = "<picture_YY>";
	public static final String VOICE_SIGN = "<voice_YY>";
	public static final String DIR = "dir";
	public static final String IMGNAME = "yyimg";
	public static final String VOCNAME = "yyvoc";
	public static MediaPlayer mMediaPlayer = new MediaPlayer();

	/** 检查是否有网络 */
	public static boolean isNetworkAvailable(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			return info.isAvailable();
		}
		return false;
	}

	/** 检查是否是WIFI */
	public static boolean isWifi(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			if (info.getType() == ConnectivityManager.TYPE_WIFI)
				return true;
		}
		return false;
	}

	/** 检查是否是移动网络 */
	public static boolean isMobile(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			if (info.getType() == ConnectivityManager.TYPE_MOBILE)
				return true;
		}
		return false;
	}

	private static NetworkInfo getNetworkInfo(Context context) {

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}

	/** 检查SD卡是否存在 */
	public static boolean checkSdCard() {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}

	// 质量压缩方法
	public static Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 90;
		while (baos.toByteArray().length / 1024 > 100) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
			baos.reset();// 重置baos即清空baos
			options -= 10;// 每次都减少10
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中

		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
		return bitmap;
	}

	// 图片按比例大小压缩方法（根据路径获取图片并压缩）：
	public static Bitmap getimage(String srcPath) {
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);// 此时返回bm为空

		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		float hh = 800f;// 这里设置高度为800f
		float ww = 480f;// 这里设置宽度为480f
		// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;// be=1表示不缩放
		if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置缩放比例
		// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
	}

	// 图片按比例大小压缩方法（根据Bitmap图片压缩）：
	public static Bitmap comp(Bitmap image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		if (baos.toByteArray().length / 1024 > 1024) {// 判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
			baos.reset();// 重置baos即清空baos
			image.compress(Bitmap.CompressFormat.JPEG, 50, baos);// 这里压缩50%，把压缩后的数据存放到baos中
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// 开始读入图片，此时把options.inJustDecodeBounds 设回true了
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
		float hh = 800f;// 这里设置高度为800f
		float ww = 480f;// 这里设置宽度为480f
		// 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
		int be = 1;// be=1表示不缩放
		if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置缩放比例
		// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
	}

	public static String GetImageStr(String imagDir) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
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
	public static String GenerateImage(String imgStr, String dir) { // 对字节数组字符串进行Base64解码并生成图片
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
			String imgFilePath = PATH + dir + ".jpg";// 新生成的图片
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
	public static String GenerateVoic(String voicStr, String dir) { // 对字节数组字符串进行Base64解码并生成图片
		if (voicStr == null) // 图像数据为空
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(voicStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String voicStrPath = PATH + dir + ".amr";// 新生成的图片
			// File directory = new File(imgFilePath).getParentFile();
			OutputStream out = new FileOutputStream(voicStrPath);
			out.write(b);
			out.flush();
			out.close();
			return voicStrPath;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 播放语音
	 * 
	 * @param name
	 */
	public static void playMusic(String name) {
		try {
			if (mMediaPlayer.isPlaying()) {
				mMediaPlayer.stop();
			}
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(name);

			mMediaPlayer.prepare();
			mMediaPlayer.start();
			mMediaPlayer.setVolume((float) 0.81, (float) 0.82);
			mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 得到图片的base64字节码，用于发送字节流
	 * 
	 * @param path
	 * @return
	 */
	public static String getImageBase64(String path, String name) {
		Bitmap bp = CommonUtils.getimage(path);
		bp = CommonUtils.compressImage(bp);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bp.compress(Bitmap.CompressFormat.JPEG, 70, stream);
		byte[] b = stream.toByteArray();
		BASE64Encoder encoder = new BASE64Encoder();
		String yy = encoder.encode(b);
		String imageMsg = CommonUtils.PIC_SIGN + yy + name
				+ CommonUtils.PIC_SIGN;

		return imageMsg;

	}

	/**
	 * 保存文件内容到sd卡
	 * 
	 * @param name
	 * @param content
	 */

	public static void saveToSDCard(String dir, String content) {

		FileOutputStream fos = null;

		try {

			// Environment.getExternalStorageDirectory()。获取sd卡的路径
			File file = new File(Environment.getExternalStorageDirectory(), dir);
			fos = new FileOutputStream(file);

			fos.write(content.getBytes());
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 得到重复图片的路径，直接得到bitmap，避免图片复制
	 * 
	 * @param items
	 * @param content
	 * @return path
	 */
	public static String getMediaPath(List<IMMessage> items, String content) {
		String path = DIR;
		String yy;
		int i = 0;
		while (i < items.size()) {
			if (items.get(i).getContent().equals(content)) {
				yy = "yes";
				if (items.get(i).getPath() != null) {
					path = items.get(i).getPath();
					break;
				}
			}
			i++;
		}
		return path;

	}

	// 从sd卡获取图片资源
	public static List<String> getImagePathFromSD() {
		// 图片列表
		List<String> picList = new ArrayList<String>();
		// 得到sd卡内路径
		String imagePath =PATH;
		// 得到该路径文件夹下所有的文件
		File mfile = new File(imagePath);
		File[] files = mfile.listFiles();
		if(files==null){
			picList.add(PATH);
		}
		else{
			// 将所有的文件存入ArrayList中,并过滤所有图片格式的文件
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				picList.add(file.getPath());
			}
		}
		// 返回得到的图片列表
		return picList;

	}
	
	/**
	 * 判断文件是否存在于sd卡  
	 * @param list
	 * @param dir
	 * @return
	 */
	public static boolean judge(List<String> list,String dir){
		boolean result=false;
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(dir)){
				result=true;
				return result;
			}
		}
		return result;
	}
	

	//在SD卡上创建一个文件夹

	    public static void createSDCardDir(){

	     if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){

	            // 创建一个文件夹对象，赋值为外部存储器的目录

	             File sdcardDir =Environment.getExternalStorageDirectory();

	           //得到一个路径，内容是sdcard的文件夹路径和名字

	             String path=sdcardDir.getPath()+"/MyVoiceForder/Record/";

	             File path1 = new File(path);

	            if (!path1.exists()) {

	             //若不存在，创建目录，可以在应用启动的时候创建

	             path1.mkdirs();

	           }

	            }


	    }
}
