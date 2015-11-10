package csdn.shimiso.eim.view;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.model.Notice;

public class NoticeAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Notice> inviteNotices;
	private Context context;

	public NoticeAdapter(Context context, List<Notice> inviteUsers) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
		this.inviteNotices = inviteUsers;
	}

	public void setNoticeList(List<Notice> inviteUsers) {
		this.inviteNotices = inviteUsers;
	}

	@Override
	public int getCount() {
		return inviteNotices == null ? 0 : inviteNotices.size();
	}

	@Override
	public Object getItem(int position) {
		return inviteNotices.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Notice notice = inviteNotices.get(position);
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.my_notice_item, null);
			holder = new ViewHolder();
			holder.newTitle = (TextView) convertView
					.findViewById(R.id.new_title);
			holder.itemIcon = (ImageView) convertView
					.findViewById(R.id.new_icon);
			holder.newContent = (TextView) convertView
					.findViewById(R.id.new_content);
			holder.newDate = (TextView) convertView.findViewById(R.id.new_date);
			holder.paopao = (TextView) convertView.findViewById(R.id.paopao);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (notice.getNoticeType() == Notice.ADD_FRIEND) {// 添加好友未处理
															// 加气泡，处理的就消失了整体
			holder.itemIcon.setBackgroundResource(R.drawable.h001);
			holder.newContent.setText(notice.getContent());

		} else if (Notice.SYS_MSG == notice.getNoticeType()) {// 如果系统消息未读，加气泡
			holder.itemIcon
					.setBackgroundResource(R.drawable.icon_recent_sysmsg);
			holder.newContent.setText(notice.getContent());
		}
		holder.newTitle.setText(notice.getTitle());
		holder.newDate.setText(notice.getNoticeTime().substring(5, 19));
		holder.newContent.setTag(notice);
		if (Notice.UNREAD == notice.getStatus()) {
			holder.paopao.setText("");
			holder.paopao.setVisibility(View.VISIBLE);
		} else {
			holder.paopao.setVisibility(View.GONE);
		}

		return convertView;
	}

	private class ViewHolder {
		public ImageView itemIcon;
		public TextView newTitle;
		public TextView newContent;
		public TextView newDate;
		public TextView paopao;
	}
}