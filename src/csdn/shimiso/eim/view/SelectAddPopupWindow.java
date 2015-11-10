package csdn.shimiso.eim.view;

import org.jivesoftware.smackx.provider.VCardProvider;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.activity.EimApplication;
import csdn.shimiso.eim.activity.im.AddFriendActivity;
import csdn.shimiso.eim.activity.im.FriendInfoActivity;
import csdn.shimiso.eim.activity.im.GroupCreateActivity;
import csdn.shimiso.eim.service.IMChatService;
import csdn.shimiso.eim.service.IMContactService;
import csdn.shimiso.eim.service.IMSystemMsgService;
import csdn.shimiso.eim.service.ReConnectService;
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

public class SelectAddPopupWindow extends PopupWindow {

	private View mMenuView;
	LinearLayout linear_saoyisao, linear_erweima, linear_add_friend,
			linear_qunliao;
	public Context context = null;
	public EimApplication eimApplication;
	public SelectAddPopupWindow(final Activity context,
			OnClickListener itemsOnClick) {
		super(context);
		this.context=context;
		
		eimApplication = (EimApplication)context.getApplication();
		eimApplication.addActivity(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.addxml, null);

		// ����Ⱥ��
		linear_qunliao = (LinearLayout) mMenuView
				.findViewById(R.id.linear_qunliao);
		linear_qunliao.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GroupCreateActivity.class);
				context.startActivity(intent);
				dismiss();

			}
		});

		// ��Ӻ���
		linear_add_friend = (LinearLayout) mMenuView
				.findViewById(R.id.linear_add_friend);
		linear_add_friend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, AddFriendActivity.class);
				context.startActivity(intent);
				dismiss();

			}
		});
		// ��������
				linear_saoyisao = (LinearLayout) mMenuView
						.findViewById(R.id.linear_saoyisao);

				linear_saoyisao.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(context,FriendInfoActivity.class);
						context.startActivity(intent);
						dismiss();
					}
				});
		// �˳���¼
		linear_erweima = (LinearLayout) mMenuView
				.findViewById(R.id.linear_erweima);
		linear_erweima.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(context).setTitle("ȷ���˳���?")
				.setNeutralButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						stopService();
						eimApplication.exit();
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).show();
				dismiss();
			}
		});
		

		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		// ���ð�ť����
				// ����SelectPicPopupWindow��View
				this.setContentView(mMenuView);
				// ����SelectPicPopupWindow��������Ŀ�
				this.setWidth(w / 2);
				// ����SelectPicPopupWindow��������ĸ�
				this.setHeight(LayoutParams.WRAP_CONTENT);
				// ����SelectPicPopupWindow��������ɵ��
				this.setFocusable(true);
				// ����SelectPicPopupWindow�������嶯��Ч��
				this.setAnimationStyle(R.style.mystyle);
				// ʵ����һ��ColorDrawable��ɫΪ��͸��
				ColorDrawable dw = new ColorDrawable(0000000000);
				// ����SelectPicPopupWindow��������ı���
				this.setBackgroundDrawable(dw);
				// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.pop_layout2).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});

	}
	
	public void stopService() {
		// ������ϵ�˷���
		Intent server = new Intent(context, IMContactService.class);
		context.stopService(server);
		// �������
		Intent chatServer = new Intent(context, IMChatService.class);
		context.stopService(chatServer);

		// �Զ��ָ����ӷ���
		Intent reConnectService = new Intent(context, ReConnectService.class);
		context.stopService(reConnectService);

		// ϵͳ��Ϣ���ӷ���
		Intent imSystemMsgService = new Intent(context,
				IMSystemMsgService.class);
		context.stopService(imSystemMsgService);
	}


}
