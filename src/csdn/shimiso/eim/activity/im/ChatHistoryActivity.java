package csdn.shimiso.eim.activity.im;

import java.io.File;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.ActivitySupport;
import csdn.shimiso.eim.manager.ContacterManager;
import csdn.shimiso.eim.manager.MessageManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.User;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.FaceTextUtils;
import csdn.shimiso.eim.util.StringUtil;

/**
 * 
 * 用户资料查看.
 * 
 * @author shimiso
 */
public class ChatHistoryActivity extends ActivitySupport {
	private ImageView titleBack;
	private LinearLayout user_info_detail, user_info_edit;
	private Button edit_btn, finish_btn;
	private List<IMMessage> msgList;
	private MessageManager msgManager;
	private ListView listView;
	private MsgHisListAdapter adapter;
	private String to;
	private int pageSize = 10;
	private int currentPage = 1;
	private int pageCount;// 总页数
	private int recordCount;// 记录总数
	private ImageView imageViewLeft;// 上一页
	private ImageView imageViewRight;// 上一页
	private TextView editTextPage;// 当前页
	private Button delBtn;
	private TextView textViewPage;// 总页数
	private User user;// 聊天人
	private User me;// 聊天人自己
	private TextView ivTitleName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chathistory);
		init();
	}

	private void init() {
		to = getIntent().getStringExtra("to");
		if (to == null)
			return;
		msgManager = MessageManager.getInstance(context);
		getEimApplication().addActivity(this);
		titleBack = (ImageView) findViewById(R.id.title_back);
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// 头部标题
		ivTitleName = (TextView) findViewById(R.id.ivTitleName);
		user = ContacterManager.getByUserJid(to, XmppConnectionManager
				.getInstance().getConnection());
		String data = getResources().getString(R.string.chat_his_with_sb);
		if (null != user) {
			data = String.format(data, user.getName());
		} else {
			data = String.format(data, StringUtil.getUserNameByJid(to));
		}

		ivTitleName.setText(data);
		// 分页
		recordCount = MessageManager.getInstance(context)
				.getChatCountWithSb(to);
		pageCount = (recordCount + pageSize - 1) / pageSize;
		imageViewLeft = (ImageView) findViewById(R.id.imageViewLeft);
		imageViewRight = (ImageView) findViewById(R.id.imageViewRight);
		editTextPage = (TextView) findViewById(R.id.editTextPage);
		editTextPage.setText(currentPage + "");
		// 下一页
		imageViewRight.setOnClickListener(nextClick);
		// 上一页
		imageViewLeft.setOnClickListener(preClick);
		// 总页数
		textViewPage = (TextView) findViewById(R.id.textViewPage);
		textViewPage.setText("" + pageCount);

		// 删除
		delBtn = (Button) findViewById(R.id.buttonDelete);
		delBtn.setOnClickListener(delClick);

		listView = (ListView) findViewById(R.id.listViewHistory);
		msgList = msgManager.getMessageListByFrom(to, currentPage, pageSize);
		if (msgList != null && msgList.size() > 0) {
			Collections.sort(msgList);
			adapter = new MsgHisListAdapter(context, msgList);
			listView.setAdapter(adapter);
		}

	}

	private class MsgHisListAdapter extends BaseAdapter {

		private List<IMMessage> items;
		private Context context;
		private LayoutInflater inflater;
		List<String> list=CommonUtils.getImagePathFromSD();
		public MsgHisListAdapter(Context context, List<IMMessage> items) {
			this.context = context;
			this.items = items;

		}

		public void refreshList(List<IMMessage> items) {
			Collections.sort(items);
			this.items = items;
			this.notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return items == null ? 0 : items.size();
		}

		@Override
		public Object getItem(int position) {
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			inflater = LayoutInflater.from(context);
			IMMessage message = items.get(position);
			String[] strarray;
			String voiceFile;
			String voiceTime;
			int msgViewTime;
			Holder holder = null;
			boolean result=false;
			if (convertView == null) {
				convertView = this.inflater.inflate(R.layout.chathistoryitem,
						null);
				holder = new Holder();
				holder.imageMsg=(ImageView)convertView.findViewById(R.id.imgMsg);
				holder.name = (TextView) convertView
						.findViewById(R.id.tvHistoryName);
				holder.time = (TextView) convertView
						.findViewById(R.id.tvHistoryTime);
				holder.content = (TextView) convertView
						.findViewById(R.id.tvMsgItem);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			if (message.getMsgType() == 0) {
				if (user == null) {
					holder.name.setText(StringUtil.getUserNameByJid(to));
				} else {
					holder.name.setText(user.getName());
				}

			} else {
				holder.name.setText("我");
			}

			if (message.getContent().contains(CommonUtils.PIC_SIGN)) {
				String[] arr = message.getContent().split(
						CommonUtils.PIC_SIGN);
				String []brr=arr[1].split("@");
				String imgFilePath = CommonUtils.PATH + brr[1] + ".jpg";
				result=CommonUtils.judge(list, imgFilePath);
				holder.imageMsg.setVisibility(View.VISIBLE);
				holder.content.setVisibility(View.INVISIBLE);
				if(!result){
					imgFilePath= CommonUtils.GenerateImage(brr[0],brr[1]);
				}
				Bitmap bp = BitmapCommon.setBitmapSize(imgFilePath);
				holder.imageMsg.setImageBitmap(bp);
				
				// bp = BitmapCommon.setBitmapSize(localSelectPath);
				
				
				/*File file=new File(image2);
				deleteFile(file);*/
			} 

			else if (message.getContent().contains(CommonUtils.VOICE_SIGN)) {
				strarray = message.getContent().split("&");
				voiceFile = strarray[0];
				voiceTime = strarray[1];
				msgViewTime = Integer.parseInt(voiceTime);
				String msgViewLength = "";
				//voiceTimeView.setVisibility(View.VISIBLE);
				//voiceTimeView.setText(voiceTime + "\"");
				for (int i = 0; i < msgViewTime; i++) {
					msgViewLength += "  ";
				}
				String voiceArr[] = voiceFile.split(CommonUtils.VOICE_SIGN);
				String voiceBrr[] = voiceArr[1].split("@");
				String imgFilePath = CommonUtils.PATH + voiceBrr[1] + ".amr";
				result=CommonUtils.judge(list, imgFilePath);
				final String voiceFileDir ;
				if(result){
					voiceFileDir=imgFilePath;
				}
				else{
					voiceFileDir = CommonUtils.GenerateVoic(voiceBrr[0],voiceBrr[1]);;
				}
				//String image2 = GenerateImage(voiceArr[1]);
				//final String voiceFileDir = voiceFile;
				holder.content.setText(msgViewLength);
				holder.content.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.chatto_voice_playing, 0);
				holder.content.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						System.out.println(voiceFileDir);
						if (voiceFileDir.contains(".amr")) {
							CommonUtils.playMusic(voiceFileDir);
						}
					} 
				});
				File file=new File(voiceFileDir);
				//deleteFile(file);
			} else {
				SpannableString spannableString = FaceTextUtils.toSpannableString(
						context, message.getContent());
				holder.content.setText(spannableString);
			}
			return convertView;
		}

		class Holder {
			TextView name;
			TextView time;
			TextView content;
			ImageView imageMsg;
		}

	}

	private OnClickListener nextClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (currentPage >= pageCount) {
				return;
			}
			currentPage += 1;
			editTextPage.setText(currentPage + "");
			msgList = msgManager
					.getMessageListByFrom(to, currentPage, pageSize);
			adapter.refreshList(msgList);
		}
	};
	private OnClickListener preClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (currentPage <= 1) {
				return;
			}
			currentPage = currentPage - 1;
			editTextPage.setText(currentPage + "");
			msgList = msgManager
					.getMessageListByFrom(to, currentPage, pageSize);
			adapter.refreshList(msgList);
		}
	};
	private OnClickListener delClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			msgManager.delChatHisWithSb(to);
			finish();
		}
	};

}
