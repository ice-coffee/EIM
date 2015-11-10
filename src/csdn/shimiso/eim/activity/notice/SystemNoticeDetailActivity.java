package csdn.shimiso.eim.activity.notice;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.manager.NoticeManager;
import csdn.shimiso.eim.model.Notice;

/**
 * 
 * 消息明细页
 * 
 * @author shimiso
 */
public class SystemNoticeDetailActivity extends ActivitySupport {
	private ImageView titleBack;
	private String noticeId;
	private TextView ivTitleName;
	private TextView noticeTile;
	private TextView notice_content;
	private Button delBtn;
	private Notice notice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sys_notice_detail);
		init();

	}

	private void init() {
		titleBack = (ImageView) findViewById(R.id.title_back);
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(1);
				finish();
			}
		});
		// 获取传值
		noticeId = getIntent().getStringExtra("notice_id");
		notice = NoticeManager.getInstance(context).getNoticeById(noticeId);
		// 修改已读信息
		NoticeManager.getInstance(context).updateStatus(noticeId, Notice.READ);

		// head
		ivTitleName = (TextView) findViewById(R.id.ivTitleName);
		ivTitleName.setText(getResources().getString(R.string.check_sys_msg));
		// 小标题
		noticeTile = (TextView) findViewById(R.id.notice_title);
		noticeTile.setText(notice.getTitle());
		// 内容
		notice_content = (TextView) findViewById(R.id.notice_content);
		notice_content.setText(notice.getContent());

		// 删除
		delBtn = (Button) findViewById(R.id.buttonDelete);
		delBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NoticeManager.getInstance(context).delById(noticeId);
				setResult(1);
				finish();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
