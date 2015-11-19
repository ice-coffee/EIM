package csdn.shimiso.eim.activity.notice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jivesoftware.smack.packet.Presence;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.activity.LoginActivity;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.NoticeManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.Notice;
import csdn.shimiso.eim.util.StringUtil;
import csdn.shimiso.eim.view.NoticeAdapter;

/**
 * �ҵ���Ϣ.
 *
 * @author shimiso
 */
public class MyNoticeActivity extends ActivitySupport
{
    private ImageView titleBack;
    private ListView noticeList = null;
    private NoticeAdapter noticeAdapter = null;
    private List<Notice> inviteNotices = new ArrayList<Notice>();
    private ContacterReceiver receiver = null;
    private NoticeManager noticeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_notice);
        init();
    }

    @Override
    protected void onPause()
    {
        // ж�ع㲥������
        unregisterReceiver(receiver);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        // ע��㲥������
        IntentFilter filter = new IntentFilter();
        // ��������
        filter.addAction(Constant.ROSTER_SUBSCRIPTION);
        // ϵͳ��Ϣ
        filter.addAction(Constant.ACTION_SYS_MSG);
        registerReceiver(receiver, filter);
        super.onResume();
    }

    private void init()
    {
        titleBack = (ImageView) findViewById(R.id.title_back);
        titleBack.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        receiver = new ContacterReceiver();
        noticeList = (ListView) findViewById(R.id.my_notice_list);
        noticeManager = NoticeManager.getInstance(context);
        inviteNotices = noticeManager.getNoticeListByTypeAndPage(Notice.All);
        noticeAdapter = new NoticeAdapter(context, inviteNotices);
        noticeList.setAdapter(noticeAdapter);
        noticeList.setOnItemClickListener(inviteListClick);
    }

    private class ContacterReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            Notice notice = (Notice) intent.getSerializableExtra("notice");
            // String action = intent.getAction();
            inviteNotices.add(notice);
            refresh();
        }
    }

    private OnItemClickListener inviteListClick = new OnItemClickListener()
    {

        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int arg2, long arg3)
        {
            final Notice notice = (Notice) view.findViewById(R.id.new_content).getTag();
            // ��Ϣ�����ж�
            if (Notice.ADD_FRIEND == notice.getNoticeType() && notice.getStatus() == Notice.UNREAD)
            {// ��Ӻ���
                showAddFriendDialag(notice);
            }
            else if (Notice.SYS_MSG == notice.getNoticeType())
            {// ϵͳ֪ͨ
                Intent intent = new Intent(context, SystemNoticeDetailActivity.class);
                intent.putExtra("notice_id", notice.getId());
                startActivityForResult(intent, 1);
            }

        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (resultCode)
        { // resultCodeΪ�ش��ı��
            case 1:
                refresh();
            default:
                break;
        }
    }

    /**
     * �ظ�һ��presence��Ϣ���û������û��ǽ��ջ��Ǿܾ�
     *
     * @param type
     * @param to
     */
    protected void sendSubscribe(Presence.Type type, String to)
    {
        Presence presence = new Presence(type);
        presence.setTo(to);
        XmppConnectionManager.getInstance().getConnection().sendPacket(presence);
    }

    /**
     * ɾ��һ����Ŀ
     *
     * @param subFrom
     */
    private void removeInviteNotice(String subFrom)
    {
        for (Notice notice : inviteNotices)
        {
            if (subFrom.equals(notice.getId()))
            {
                inviteNotices.remove(notice);
                break;
            }
        }
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_notice_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_clearall:
                NoticeManager.getInstance(context).delAll();
                refresh();
                break;
            case R.id.menu_relogin:
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_exit:
                isExit();
                break;
        }
        return true;

    }

    /**
     * .������Ӻ��ѵĶԻ���
     *
     * @param notice
     *
     * @author shimiso
     * @update 2012-7-3 ����4:50:53
     */
    private void showAddFriendDialag(final Notice notice)
    {
        final String subFrom = notice.getFrom();
        new AlertDialog.Builder(context)
                .setMessage(subFrom + "���������Ϊ����")
                .setTitle("��ʾ")
                .setPositiveButton("���", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // ��������
                        sendSubscribe(Presence.Type.subscribed, subFrom);
                        sendSubscribe(Presence.Type.subscribe, subFrom);
                        // removeInviteNotice(notice.getId());
                        NoticeManager noticeManager = NoticeManager.getInstance(context);
                        noticeManager.updateAddFriendStatus(notice.getId(), Notice.READ, "�Ѿ�ͬ��" + StringUtil.getUserNameByJid(notice.getFrom()) + "�ĺ�������");
                        refresh();
                    }
                }).setNegativeButton("�ܾ�", new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        sendSubscribe(Presence.Type.unsubscribed, subFrom);
                        // removeInviteNotice(notice.getId());
                        NoticeManager noticeManager = NoticeManager.getInstance(context);
                        noticeManager.updateAddFriendStatus(notice.getId(), Notice.READ, "�Ѿ��ܾ�" + StringUtil.getUserNameByJid(notice.getFrom()) + "�ĺ�������");
                        refresh();
                    }
                }).show();
    }

    /**
     * ˢ������
     */
    private void refresh()
    {
        inviteNotices = noticeManager.getNoticeListByTypeAndPage(Notice.All);
        Collections.sort(inviteNotices);
        noticeAdapter.setNoticeList(inviteNotices);
        noticeAdapter.notifyDataSetChanged();
    }
}
