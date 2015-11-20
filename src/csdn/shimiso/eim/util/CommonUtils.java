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

	/** ����Ƿ������� */
	public static boolean isNetworkAvailable(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			return info.isAvailable();
		}
		return false;
	}

	/** ����Ƿ���WIFI */
	public static boolean isWifi(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			if (info.getType() == ConnectivityManager.TYPE_WIFI)
				return true;
		}
		return false;
	}

	/** ����Ƿ����ƶ����� */
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

	/** ���SD���Ƿ���� */
	public static boolean checkSdCard() {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			return true;
		else
			return false;
	}

	// ����ѹ������
	public static Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // ����ѹ������������Bitmap.CompressFormat.JPEG��ʶҪ��ѹ����ͼƬ��ʽ(jpg/png/WEBP),100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		int options = 90;
		while (baos.toByteArray().length / 1024 > 100) { // ѭ���ж����ѹ����ͼƬ�Ƿ����100kb,���ڼ���ѹ��
			baos.reset();// ����baos�����baos
			options -= 10;// ÿ�ζ�����10
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// ����ѹ��options%����ѹ��������ݴ�ŵ�baos��

		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// ��ѹ���������baos��ŵ�ByteArrayInputStream��
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// ��ByteArrayInputStream��������ͼƬ
		return bitmap;
	}

	// ͼƬ��������Сѹ������������·����ȡͼƬ��ѹ������
	public static Bitmap getimage(String srcPath) {
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// ��ʼ����ͼƬ����ʱ��options.inJustDecodeBounds ���true��
		newOpts.inJustDecodeBounds = true;
        // ��ʱ����bmΪ��
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// ���������ֻ��Ƚ϶���800*480�ֱ��ʣ����ԸߺͿ���������Ϊ
		float hh = 800f;// �������ø߶�Ϊ800f
		float ww = 480f;// �������ÿ��Ϊ480f
		// ���űȡ������ǹ̶��������ţ�ֻ�ø߻��߿�����һ�����ݽ��м��㼴��
		int be = 1;// be=1��ʾ������
		if (w > h && w > ww) {// �����ȴ�Ļ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// ����߶ȸߵĻ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// �������ű���
		// ���¶���ͼƬ��ע���ʱ�Ѿ���options.inJustDecodeBounds ���false��
		bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
		return compressImage(bitmap);// ѹ���ñ�����С���ٽ�������ѹ��
	}

	// ͼƬ��������Сѹ������������BitmapͼƬѹ������
	public static Bitmap comp(Bitmap image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		if (baos.toByteArray().length / 1024 > 1024) {// �ж����ͼƬ����1M,����ѹ������������ͼƬ��BitmapFactory.decodeStream��ʱ���
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, 50, baos);// ����ѹ��50%����ѹ��������ݴ�ŵ�baos��
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		// ��ʼ����ͼƬ����ʱ��options.inJustDecodeBounds ���true��
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		// ���������ֻ��Ƚ϶���800*480�ֱ��ʣ����ԸߺͿ���������Ϊ
		float hh = 800f;// �������ø߶�Ϊ800f
		float ww = 480f;// �������ÿ��Ϊ480f
		// ���űȡ������ǹ̶��������ţ�ֻ�ø߻��߿�����һ�����ݽ��м��㼴��
		int be = 1;// be=1��ʾ������
		if (w > h && w > ww) {// �����ȴ�Ļ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// ����߶ȸߵĻ����ݿ�ȹ̶���С����
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// �������ű���
		// ���¶���ͼƬ��ע���ʱ�Ѿ���options.inJustDecodeBounds ���false��
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		return compressImage(bitmap);// ѹ���ñ�����С���ٽ�������ѹ��
	}

    // ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
	public static String GetImageStr(String imagDir) {
		InputStream in = null;
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			in = new FileInputStream(imagDir);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

	// base64�ַ���ת����ͼƬ
	public static String GenerateImage(String imgStr, String dir) { // ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null) // ͼ������Ϊ��
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// �����쳣����
					b[i] += 256;
				}
			}
			// ����jpegͼƬ
			String imgFilePath = PATH + dir + ".jpg";// �����ɵ�ͼƬ
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

	// base64�ַ���ת������Ƶ
	public static String GenerateVoic(String voicStr, String dir) { // ���ֽ������ַ�������Base64���벢����ͼƬ
		if (voicStr == null) // ͼ������Ϊ��
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] b = decoder.decodeBuffer(voicStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// �����쳣����
					b[i] += 256;
				}
			}
			// ������Ƶ
			String voicStrPath = PATH + dir + ".amr";// �����ɵ���Ƶ
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
	 * ��������
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
	 * �õ�ͼƬ��base64�ֽ��룬���ڷ����ֽ���
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
	 * �����ļ����ݵ�sd��
	 * 
	 * @param name
	 * @param content
	 */

	public static void saveToSDCard(String dir, String content) {

		FileOutputStream fos = null;

		try {

			// Environment.getExternalStorageDirectory()����ȡsd����·��
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
	 * �õ��ظ�ͼƬ��·����ֱ�ӵõ�bitmap������ͼƬ����
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

	// ��sd����ȡͼƬ��Դ
	public static List<String> getImagePathFromSD() {
		// ͼƬ�б�
		List<String> picList = new ArrayList<String>();
		// �õ�sd����·��
		String imagePath =PATH;
		// �õ���·���ļ��������е��ļ�
		File mfile = new File(imagePath);
		File[] files = mfile.listFiles();
		if(files==null){
			picList.add(PATH);
		}
		else{
			// �����е��ļ�����ArrayList��,����������ͼƬ��ʽ���ļ�
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				picList.add(file.getPath());
			}
		}
		// ���صõ���ͼƬ�б�
		return picList;

	}
	
	/**
	 * �ж��ļ��Ƿ������sd��  
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
	

	//��SD���ϴ���һ���ļ���

	    public static void createSDCardDir(){

	     if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){

	            // ����һ���ļ��ж��󣬸�ֵΪ�ⲿ�洢����Ŀ¼

	             File sdcardDir =Environment.getExternalStorageDirectory();

	           //�õ�һ��·����������sdcard���ļ���·��������

	             String path=sdcardDir.getPath()+"/MyVoiceForder/Record/";

	             File path1 = new File(path);

	            if (!path1.exists()) {

	             //�������ڣ�����Ŀ¼��������Ӧ��������ʱ�򴴽�

	             path1.mkdirs();

	           }

	            }


	    }
}
