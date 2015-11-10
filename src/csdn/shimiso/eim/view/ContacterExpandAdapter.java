package csdn.shimiso.eim.view;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.manager.ContacterManager.MRosterGroup;
import csdn.shimiso.eim.model.User;

public class ContacterExpandAdapter extends BaseExpandableListAdapter {

	private List<MRosterGroup> groups = null;
	private LayoutInflater inflater;
	private Context context;

	public ContacterExpandAdapter(Context context, List<MRosterGroup> groups) {
		this.context = context;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.groups = groups;
	}

	public void setContacter(List<MRosterGroup> groups) {
		this.groups = groups;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return groups.get(groupPosition).getUsers().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		User user = groups.get(groupPosition).getUsers().get(childPosition);
		ChoildHolder childHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.chat_item, null);
			childHolder = new ChoildHolder();
			childHolder.mood = (TextView) convertView.findViewById(R.id.mood);
			childHolder.username = (TextView) convertView
					.findViewById(R.id.username);
			childHolder.image = (ImageView) convertView
					.findViewById(R.id.child_item_head);

			convertView.setTag(childHolder);
		} else {
			childHolder = (ChoildHolder) convertView.getTag();
		}
		user.setGroupName(groups.get(groupPosition).getName());
		childHolder.username.setTag(user);
		childHolder.mood.setTag(groupPosition);
		childHolder.image.setTag(childPosition);
		childHolder.mood.setText(user.getStatus() == null ? "" : user
				.getStatus());      
		childHolder.username.setText(user.getName() + "---"
				+ (user.isAvailable() ? "在线" : "离线"));
		if (user.isAvailable()) {
			childHolder.username.setTextColor(Color.BLACK);
			childHolder.mood.setTextColor(Color.BLACK);
		} else {
			childHolder.username.setTextColor(Color.GRAY);
			childHolder.mood.setTextColor(Color.GRAY);
		}

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return groups.get(groupPosition).getUsers().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		GroupHolder groupHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.chat_group, null);
			groupHolder = new GroupHolder();
			groupHolder.onlineno = (TextView) convertView
					.findViewById(R.id.onlineno);
			groupHolder.groupname = (TextView) convertView
					.findViewById(R.id.groupname);
			convertView.setTag(groupHolder);
		} else {
			groupHolder = (GroupHolder) convertView.getTag();
		}

		// shimiso 修改
		groupHolder.groupname.setText(groups.get(groupPosition).getName());
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(groups.get(groupPosition).getCount());
		buffer.append("]");
		groupHolder.onlineno.setText(buffer.toString());
		// convertView.setOnLongClickListener(mainCcontacterOnLongClick);
		groupHolder.groupname.setTag(groups.get(groupPosition).getName());
		return convertView;
	}

	class GroupHolder {
		TextView onlineno;
		TextView groupname;
	}

	class ChoildHolder {
		TextView mood;
		TextView username;
		ImageView image;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}