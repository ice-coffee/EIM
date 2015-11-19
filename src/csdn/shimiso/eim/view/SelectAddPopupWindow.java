package csdn.shimiso.eim.view;

import android.graphics.Point;
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

public class SelectAddPopupWindow extends PopupWindow
{

    private View mMenuView;
    private LinearLayout linear_saoyisao, linear_erweima, linear_add_friend, linear_qunliao;
    public Context context = null;
    public EimApplication eimApplication;

    public SelectAddPopupWindow(final Activity context, OnClickListener itemsOnClick)
    {
        super(context);
        this.context = context;

        eimApplication = (EimApplication) context.getApplication();
        eimApplication.addActivity(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.addxml, null);

        // 发起群聊
        linear_qunliao = (LinearLayout) mMenuView.findViewById(R.id.linear_qunliao);
        linear_qunliao.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, GroupCreateActivity.class);
                context.startActivity(intent);
                dismiss();

            }
        });

        // 添加好友
        linear_add_friend = (LinearLayout) mMenuView.findViewById(R.id.linear_add_friend);
        linear_add_friend.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, AddFriendActivity.class);
                context.startActivity(intent);
                dismiss();

            }
        });
        // 个人设置
        linear_saoyisao = (LinearLayout) mMenuView.findViewById(R.id.linear_saoyisao);

        linear_saoyisao.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                Intent intent = new Intent(context, FriendInfoActivity.class);
                context.startActivity(intent);
                dismiss();
            }
        });
        // 退出登录
        linear_erweima = (LinearLayout) mMenuView.findViewById(R.id.linear_erweima);
        linear_erweima.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                new AlertDialog.Builder(context).setTitle("确定退出吗?").setNeutralButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        stopService();
                        eimApplication.exit();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                }).show();
                dismiss();
            }
        });


        Point point = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(point);
        int h = point.y;
        int w = point.x;
        // 设置按钮监听
        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w / 2);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.mystyle);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new OnTouchListener()
        {

            public boolean onTouch(View v, MotionEvent event)
            {

                int height = mMenuView.findViewById(R.id.pop_layout2).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (y < height)
                    {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

    public void stopService()
    {
        // 好友联系人服务
        Intent server = new Intent(context, IMContactService.class);
        context.stopService(server);
        // 聊天服务
        Intent chatServer = new Intent(context, IMChatService.class);
        context.stopService(chatServer);

        // 自动恢复连接服务
        Intent reConnectService = new Intent(context, ReConnectService.class);
        context.stopService(reConnectService);

        // 系统消息连接服务
        Intent imSystemMsgService = new Intent(context, IMSystemMsgService.class);
        context.stopService(imSystemMsgService);
    }


}
