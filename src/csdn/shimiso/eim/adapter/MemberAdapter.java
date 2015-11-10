package csdn.shimiso.eim.adapter;

import java.util.List;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;

public class MemberAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private List<String> roomMb;
	private Context context;
	String mood="这家话很懒什么也没留下！";
	public MemberAdapter(Context context,List<String> list){
		this.context = context;
		this.roomMb = list;
		mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return roomMb.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String name=roomMb.get(position);
		ViewHolderx holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.room_member_list, null);
			holder = new ViewHolderx();
			holder.name = (TextView) convertView
					.findViewById(R.id.member_name);
			holder.head = (ImageView) convertView
					.findViewById(R.id.room_member_head);
			holder.mood = (TextView) convertView
					.findViewById(R.id.member_mood);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolderx) convertView.getTag();
		}
		// connection.getRoster().getEntry(user)

		holder.name.setText(name);
		holder.head.setBackgroundResource(R.drawable.head);
		holder.mood.setText(mood);
		//holder.newContent.setTag(u);
		//holder.newDate.setText(notice.getNoticeTime().substring(5, 16));

		return convertView;
	}
	public class ViewHolderx {
		private TextView name;
		private TextView mood;
		private ImageView head;

	}
	
}