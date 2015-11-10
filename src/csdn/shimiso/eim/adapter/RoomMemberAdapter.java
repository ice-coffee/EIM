package csdn.shimiso.eim.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import csdn.shimiso.eim.activity.im.RoomChatActivity;

class RoomMemberAdapter extends BaseAdapter{
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
	   return 0;//membersName.size();
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
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if(null == view){
			//view = LayoutInflater.from(RoomChatActivity.this).inflate(android.R.layout.simple_list_item_1, null);
		}
		TextView text = (TextView) view.findViewById(android.R.id.text1);
		//text.setText(membersName.get(arg0));
		return view;
	}
	
}