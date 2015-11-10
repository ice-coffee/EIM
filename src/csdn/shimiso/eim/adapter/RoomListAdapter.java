package csdn.shimiso.eim.adapter;


import java.util.List;

import com.zn.zxw.intelligencize.model.MucRoom;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.ContacterManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.ChartHisBean;
import csdn.shimiso.eim.model.User;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.FaceTextUtils;

public class RoomListAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<MucRoom> rlist;
	private Context context;
	private OnClickListener contacterOnClick;

	public RoomListAdapter(Context context, List<MucRoom> list) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
		this.rlist = list;
	}

	public void setNoticeList(List<MucRoom> list) {
		this.rlist = list;
	}

	@Override
	public int getCount() {
		return rlist.size();
	}

	@Override
	public Object getItem(int position) {
		return rlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MucRoom notice = rlist.get(position);
		//Integer ppCount = notice.getNoticeSum();
		ViewHolderx holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.room_list, null);
			holder = new ViewHolderx();
			holder.name = (TextView) convertView
					.findViewById(R.id.room_name);
			holder.roomIcon = (ImageView) convertView
					.findViewById(R.id.room_icon);
			holder.theme = (TextView) convertView
					.findViewById(R.id.room_theme);
			holder.hold = (TextView) convertView.findViewById(R.id.room_hold);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolderx) convertView.getTag();
		}
		// connection.getRoster().getEntry(user)
		holder.roomIcon.setBackgroundResource(R.drawable.room_icon);
		holder.name.setText(notice.getName());
		holder.theme.setText(notice.getDescription());
		holder.hold.setText(notice.getOccupants()+"");
		//holder.newContent.setTag(u);
		//holder.newDate.setText(notice.getNoticeTime().substring(5, 16));

		return convertView;
	}

	public class ViewHolderx {
		public ImageView roomIcon;
		public TextView name;
		public TextView theme;
		//public TextView newDate;
		public TextView hold;

	}

	public void setOnClickListener(OnClickListener contacterOnClick) {

		this.contacterOnClick = contacterOnClick;
	}
}