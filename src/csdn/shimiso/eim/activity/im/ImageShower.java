package csdn.shimiso.eim.activity.im;


import csdn.shimiso.eim.R;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.view.ImageLoadingDialog;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

public class ImageShower extends Activity {

	private ImageView img;
	private String path;
	private Bundle bundle;
	Bitmap bp ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageshower);
		img=(ImageView)findViewById(R.id.show_img);
		 path=getIntent().getStringExtra("dir");
		 bp = BitmapCommon.setBitmapSize(path);
		 img.setImageBitmap(bp);
		final ImageLoadingDialog dialog = new ImageLoadingDialog(this);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				dialog.dismiss();
			}
		}, 1000 * 2);
	}
 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		finish();
		return true;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(bp != null && !bp.isRecycled()){ 

	        // 回收并且置为null
			bp.recycle(); 
			bp = null; 
	} 
	System.gc();
	}
	
}
