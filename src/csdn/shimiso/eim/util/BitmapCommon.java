package csdn.shimiso.eim.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import android.R.string;
import android.graphics.Bitmap;
import csdn.shimiso.eim.R;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapCommon {

	/**
	 * 通过drawable 获取bitmap
	 * 
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {

		Bitmap bitmap = Bitmap.createBitmap(

		drawable.getIntrinsicWidth(),

		drawable.getIntrinsicHeight(),

		drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888

		: Bitmap.Config.RGB_565);

		Canvas canvas = new Canvas(bitmap);

		// canvas.setBitmap(bitmap);

		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());

		drawable.draw(canvas);

		return bitmap;

	}

	public static String getBase64(byte[] image) {
		String string = "";
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			string = encoder.encodeBuffer(image).trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

	/**
	 * 通过资源图片id获取Bitmap
	 * 
	 * @param R_DRAWABLE_ID
	 * @return
	 */
	
	
	 

	public static Drawable getDrawable(byte[] imgByte) {
		Bitmap bitmap;
		if (imgByte != null) {

			bitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
			Drawable drawable = new BitmapDrawable(bitmap);

			return drawable;
		}
		return null;
	}

	/**
	 * 通过bitmap 获取二进制数�?
	 * 
	 * @param image
	 * @return
	 */
	public static byte[] getDefaultIcon(Bitmap image) {
		// iconView.get
		// BitmapFactory.
		byte[] compressData = null;
		if (image != null) {
			compressData = getByteByBitmap(image);
		}
		return compressData;
	}

	private static byte[] getByteByBitmap(Bitmap bmp) {

		Bitmap output = Bitmap.createScaledBitmap(bmp, 150, bmp.getHeight()
				* 150 / bmp.getWidth(), true);
		// �?��要判断，如果图片压缩前后width,height不变�?
		// 引用同一个对象，系统会报
		// Canvas: trying to use a recycled bitmap android.graphics.Bitmap错误
		if (bmp != output) {
			bmp.recycle();
			bmp = null;
		}
		byte[] compressData = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			try {
				output.compress(Bitmap.CompressFormat.PNG, 100, baos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			compressData = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compressData;
	}

	/**
	 * 更改图片的大�?
	 * 
	 * @param bitmap
	 * @param _width
	 * @param _height
	 * @return
	 */
	public static Bitmap setBitmapSize(Bitmap bitmap, int _width, int _height) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		// 设置想要的大�?
		int newWidth = _width;
		int newHeight = _height;
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
	}

	/**
	 * 更改图片的大�?
	 * 
	 * @param bitmap
	 * @param _width
	 * @param _height
	 * @return
	 */
	public static Bitmap setBitmapSize(String bitmapPath, int _width,
			int _height) {
		Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		// 设置想要的大�?
		int newWidth = _width;
		int newHeight = _height;
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
	}

	/**
	 * 更改图片的大�?
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap setBitmapSize(String bitmapPath) {
		Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		// 设置想要的大�?
		int newWidth = width;
		int newHeight = height;
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
	}

}
