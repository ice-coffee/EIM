package csdn.shimiso.eim.view;


import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.im.ContacterMainActivity;
import csdn.shimiso.eim.activity.im.RoomInfoActivity;
import csdn.shimiso.eim.activity.im.RoomMemberActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class SelectPicPopupWindow extends PopupWindow {


	private View mMenuView;
	LinearLayout linear_setting,linear_tuichu,linear_yijian_fankui,linear_ziliao;

	public SelectPicPopupWindow(final Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.bottomdialog, null);
		//Ⱥ����
		linear_ziliao = (LinearLayout) mMenuView.findViewById(R.id.linear_ziliao);
		linear_ziliao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,RoomInfoActivity.class);
				context.startActivity(intent);
				dismiss();
				
			}
		});
		
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		
		//Ⱥ��Ա
		linear_yijian_fankui = (LinearLayout) mMenuView.findViewById(R.id.linear_yijian_fankui);
		linear_yijian_fankui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,RoomMemberActivity.class);
				context.startActivity(intent);
				dismiss();
				
			}
		});
		
		
		//Ⱥ����
		linear_setting = (LinearLayout) mMenuView.findViewById(R.id.linear_setting);
		linear_setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(context,RoomSettingActivity.class);
//				context.startActivity(intent);
				dismiss();
				
			}
		});
		//�˳�
		linear_tuichu = (LinearLayout) mMenuView.findViewById(R.id.linear_tuichu);
		linear_tuichu.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				//���ٵ�����
				new AlertDialog.Builder(context)
				.setMessage("ȷ���˳�Ⱥ��?")
				.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,int which) 
							{			
								//�˳�Ⱥ��
								Intent intent = new Intent(context,ContacterMainActivity.class);
								context.startActivity(intent);
								context.finish();
								dismiss();
								
							}
						}).setNegativeButton("ȡ��", null).create()
				.show();
				
				
			}
		});
		//���ð�ť����
		//����SelectPicPopupWindow��View
		this.setContentView(mMenuView);
		//����SelectPicPopupWindow��������Ŀ�
		this.setWidth(w/2);
		//����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		//����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.mystyle);
		//ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0000000000);
		//����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);
		//mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		mMenuView.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}				
				return true;
			}
		});

	}


}
