package csdn.shimiso.eim.activity.im;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.muc.InvitationListener;
import org.jivesoftware.smackx.muc.InvitationRejectionListener;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.Occupant;
import org.jivesoftware.smackx.muc.ParticipantStatusListener;

import Decoder.BASE64Decoder;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zn.zxw.intelligencize.model.MucHistory;

import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.BaseActivity;
import csdn.shimiso.eim.activity.EimApplication;
import csdn.shimiso.eim.activity.LoginActivity;
import csdn.shimiso.eim.activity.MainActivity;
import csdn.shimiso.eim.adapter.EmoViewPagerAdapter;
import csdn.shimiso.eim.adapter.EmoteAdapter;
import csdn.shimiso.eim.adapter.RoomChatAdapter;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.ContacterManager;
import csdn.shimiso.eim.manager.MessageManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.RoomMsg;
import csdn.shimiso.eim.model.User;
import csdn.shimiso.eim.util.BASE64Encoder;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.DateUtil;
import csdn.shimiso.eim.util.EmoticonsEditText;
import csdn.shimiso.eim.util.FaceText;
import csdn.shimiso.eim.util.FaceTextUtils;
import csdn.shimiso.eim.util.HeaderLayout;
import csdn.shimiso.eim.util.SLog;
import csdn.shimiso.eim.util.StringUtil;
import csdn.shimiso.eim.view.SelectPicPopupWindow;

public class RoomChatActivity extends BaseActivity implements
		InvitationRejectionListener, InvitationListener,
		ParticipantStatusListener, PacketListener, OnClickListener {
	private String tag = "RoomChatActivity";
	private Button btn_chat_emo, btn_chat_send, btn_chat_add,
			btn_chat_keyboard, btn_speak, btn_chat_voice;
	String targetId = "";
	HeaderLayout mHeaderLayout;
	private static int MsgPagerNum;
	private MediaPlayer mMediaPlayer = new MediaPlayer();
	private LinearLayout layout_more, layout_emo, layout_add;
	private ViewPager pager_emo;
	private TextView tv_picture, tv_camera, tv_location;
	private TextView room_name;
	private String localCameraPath = "";
	RelativeLayout layout_record;
	private Handler mHandler = new Handler();
	TextView tv_voice_tips;
	ImageView iv_record;
	SelectPicPopupWindow menuWindow; // 弹出框
	private Drawable[] drawable_Anims;// ???????
	private ImageView titleBack;
	private RoomChatAdapter adapter = null;
	private List<RoomMsg> mDataArrays = new ArrayList<RoomMsg>();
	private EmoticonsEditText messageInput = null;
	private Button messageSendBtn = null;
	private ImageButton userInfo;
	private ListView listView;
	private int recordCount;
	private View listHead;
	private Button listHeadButton;
	private User user;// 聊天人
	private TextView tvChatTitle;
	private String to_name;
	private ImageView iv_status;
	boolean both=false;
	public static final int MESSAGE_TAG = 1;   //消息类型
	private static final String LOG_TAG = "AudioRecordTest";
	/** 语音文件保存路径 */
	private String mFileName = null;
	/** 按住说话按钮 */
	private Button mBtnVoice;
	/** 用于语音播放 */
	private MediaPlayer mPlayer = null;
	/** 用于完成录音 */
	private MediaRecorder mRecorder = null;
	private Bitmap bp;
	private static final String PATH = "/sdcard/MyVoiceForder/Record/";
	private static final String PATHIMG = "/sdcard/MyImageForder/Record/";
	XMPPConnection con;
	MultiUserChat muc;
	List<String> membersName;
	EimApplication app;
	Presence presence ;
	private FrameLayout fl;
	private  Message message = null;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message m) {
			if (m.what == 1) {
					adapter.refresh(mDataArrays);
					//fl.invalidate();
				} 
			}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_chat);
		room_name=(TextView)findViewById(R.id.to_room_name);
		con = XmppConnectionManager.getInstance().getConnection();
		muc = XmppConnectionManager.getInstance().getMuc();
		muc.addInvitationRejectionListener(this);
		MultiUserChat.addInvitationListener(con, this);
		muc.addParticipantStatusListener(this);
	    muc.addMessageListener(this);
	    muc.addMessageListener(new PacketListener() {
			@Override
			public void processPacket(Packet packet) {
				// TODO Auto-generated method stub
				message = (Message) packet;
				android.os.Message ms = new android.os.Message();
				ms.what = 1;
				//handler.handleMessage(ms);
			}
		});
		app = EimApplication.getInstance();
		room_name.setText(muc.getRoom().toString());
		initView();
		init();
	}


	@Override
	protected void onDestroy() {
		XmppConnectionManager.getInstance().leaveRoom();
		MultiUserChat.removeInvitationListener(con, this);
		super.onDestroy();
	}

	@Override
	public void invitationDeclined(final String invitee, final String reason) {
		// TODO Auto-generated method stub
		SLog.i(tag, "被邀请者:" + invitee + " , 原因:" + reason);
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(RoomChatActivity.this,
						"被邀请者:" + invitee + " , 原因:" + reason,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void invitationReceived(Connection conn, final String room,
			final String inviter, String reason, final String password,
			Message msg) {
		// TODO Auto-generated method stub
		SLog.i(tag, "room:" + room + " , inviter:" + inviter + " , reason"
				+ reason + " , password:" + password + " , msg:" + msg.toXML());

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("选择好友");
		builder.setMessage(inviter + " 邀请我加入 " + room);
		builder.setPositiveButton("加入", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			/*	 MultiUserChat tmp =
				 XmppConnectionManager.getInstance().joinRoom(user, password,
						 room, messageListener);
				 if(null!=tmp){
				 XmppConnectionManager.getInstance().leaveRoom();
				 XmppConnectionManager.getInstance().setMuc(tmp);
				 Toast.makeText(RoomChatActivity.this, "切换房间成功",
				 Toast.LENGTH_SHORT).show();
				 SLog.i(tag, "重新初始化房间.....");
				 }else{
				 Toast.makeText(RoomChatActivity.this, "进入新房间失败",
				 Toast.LENGTH_SHORT).show();
				 SLog.i(tag, "呆着不动.....");
				 }*/
			}
		});
		builder.setNeutralButton("拒绝", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				MultiUserChat.decline(con, room, inviter, "I'm too busy");
			}
		});

		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				builder.create().show();
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter.notifyDataSetChanged();
	}

	private void showToast(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(RoomChatActivity.this, msg, Toast.LENGTH_SHORT)
						.show();
			}
		});

	}
	@Override
	public void adminGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "adminGranted" + arg0);
		showToast("adminGranted" + arg0);
	}

	@Override
	public void adminRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "adminRevoked" + arg0);
		showToast("adminRevoked" + arg0);
		
	}

	@Override
	public void banned(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		SLog.i(tag, "banned" + arg0 + "," + arg1 + "," + arg2);
		showToast("banned" + arg0 + "," + arg1 + "," + arg2);
		// initData();
	}

	@Override
	public void joined(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "joined" + arg0);
		showToast("joined" + arg0);
		// initData();
	}

	@Override
	public void kicked(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		SLog.i(tag, "kicked" + arg0 + " , " + arg1 + " , " + arg2);
		showToast("kicked" + arg0 + " , " + arg1 + " , " + arg2);
		// initData();
	}

	@Override
	public void left(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "left" + arg0);
		showToast("left" + arg0);
		// initData();
	}

	@Override
	public void membershipGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "membershipGranted" + arg0);
		showToast("membershipGranted" + arg0);
	}

	@Override
	public void membershipRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "membershipRevoked" + arg0);
		showToast("membershipRevoked" + arg0);
	}

	@Override
	public void moderatorGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "moderatorGranted" + arg0);
		showToast("moderatorGranted" + arg0);
	}

	@Override
	public void moderatorRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "moderatorRevoked" + arg0);
		showToast("moderatorRevoked" + arg0);
	}

	@Override
	public void nicknameChanged(String arg0, String arg1) {
		// TODO Auto-generated method stub
		SLog.i(tag, "nicknameChanged" + arg0);
		showToast("nicknameChanged" + arg0);
	}

	@Override
	public void ownershipGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "ownershipGranted" + arg0);
		showToast("ownershipGranted" + arg0);
	}

	@Override
	public void ownershipRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "ownershipRevoked" + arg0);
		showToast("ownershipRevoked" + arg0);
	}

	@Override
	public void voiceGranted(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "voiceGranted" + arg0);
		showToast("voiceGranted" + arg0);
	}

	@Override
	public void voiceRevoked(String arg0) {
		// TODO Auto-generated method stub
		SLog.i(tag, "voiceRevoked" + arg0);
		showToast("voiceRevoked" + arg0);
	}

	
	@Override
	public void processPacket(Packet packet) {
		// TODO Auto-generated method stub
		SLog.i(tag, packet.toXML());
		message = (Message) packet;
		android.os.Message m = new android.os.Message();
		handler.sendEmptyMessage(MESSAGE_TAG);
		
		String from = StringUtils.parseResource(message.getFrom());
		String time = DateUtil.date2Str(Calendar.getInstance(),
				Constant.MS_FORMART);
		RoomMsg rm = new RoomMsg();
//		showToast(from+" 说："+message.getBody());
		rm.setCnt(message.getBody());
		rm.setTime(time);
		//当前用户
		String user = XmppConnectionManager.getInstance().getConnection().getUser();
		if (!from.equals(user)) {
			rm.setType(0); 
			rm.setFrom(from);
			mDataArrays.add(rm);
			int x=mDataArrays.size();
			if (mDataArrays.size() > 30) {
				mDataArrays.remove(0);
			}
		}
		adapter.refresh(mDataArrays);
		//adapter.notifyDataSetChanged();
		android.os.Message ms = new android.os.Message();
		ms.what = 1;
		handler.handleMessage(ms);
		// closeInput();
	}

	private void initView() {
		initBottomView();
		initVoiceView();
	}

	private void initVoiceView() {

		layout_record = (RelativeLayout) findViewById(R.id.layout_room_record);
		tv_voice_tips = (TextView) findViewById(R.id.room_voice_tips);
		iv_record = (ImageView) findViewById(R.id.iv_room_record);

		btn_speak.setOnTouchListener(new OnTouchListener() {
			long beforeTime;
			long afterTime;
			int timeDistance;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					beforeTime = System.currentTimeMillis();
					try {
						v.setPressed(true);
						layout_record.setVisibility(View.VISIBLE);
						tv_voice_tips
								.setText(getString(R.string.voice_cancel_tips));
						mHandler.postDelayed(new Runnable() {
							public void run() {
								layout_record.setVisibility(View.VISIBLE);
							}
						}, 300);
						// recordManager.startRecording(targetId);
					} catch (Exception e) {
					}
					startVoice();
					mHandler.postDelayed(mPollTask, POLL_INTERVAL);
					break;
				case MotionEvent.ACTION_UP:
					afterTime = System.currentTimeMillis();
					System.out.println(timeDistance + "声音录制时间");
					v.setPressed(false);
					layout_record.setVisibility(View.INVISIBLE);
					mHandler.removeCallbacks(mSleepTask);
					mHandler.removeCallbacks(mPollTask);
					stopVoice();
					String voiceFile = CommonUtils.VOICE_SIGN
							+ CommonUtils.GetImageStr(mFileName) + CommonUtils.VOICE_SIGN;
					if ("".equals(mFileName)) {
						Toast.makeText(RoomChatActivity.this, "不能为空",
								Toast.LENGTH_SHORT).show();
					} else {
						// (afterTime-beforeTime)/1000
						try {
							String time = DateUtil.date2Str(Calendar.getInstance(),
									Constant.MS_FORMART);
							RoomMsg rm = new RoomMsg();
							rm.setCnt(voiceFile + "&"+ (afterTime - beforeTime) / 1000);
							rm.setTime(time);
							rm.setFrom("我");
							rm.setType(1);
							mDataArrays.add(rm);
							adapter.refresh(mDataArrays);
							muc.sendMessage(voiceFile + "&"
									+ (afterTime - beforeTime) / 1000);
							// messageInput.setText("");
						} catch (Exception e) {
							showToast("信息发送失败");
							// messageInput.setText(message);
						}
						closeInput();
					}

					iv_record.setImageResource(R.drawable.chat_icon_voice1);
					break;
				default:
					break;
				}
				return false;
			}
		});
		// initVoiceAnimRes();
	}

	public void closeInput() {
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (inputMethodManager != null && this.getCurrentFocus() != null) {
			inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus()
					.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/** 开始录音 */
	private void startVoice() {
		// 设置录音保存路径
		mFileName = PATH + UUID.randomUUID().toString() + ".amr";
		System.out.println(mFileName);
		String state = android.os.Environment.getExternalStorageState();
		if (!state.equals(android.os.Environment.MEDIA_MOUNTED)) {
			Log.i(LOG_TAG, "SD Card is not mounted,It is  " + state + ".");
		}
		File directory = new File(mFileName).getParentFile();
		if (!directory.exists() && !directory.mkdirs()) {
			Log.i(LOG_TAG, "Path to file could not be created");
		}
		Toast.makeText(getApplicationContext(), "开始录音", 0).show();
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
		mRecorder.setOutputFile(mFileName);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		try {
			mRecorder.prepare();
		} catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}
		mRecorder.start();
	}

	/** 停止录音 */
	private void stopVoice() {
		mRecorder.stop();
		mRecorder.release();
		mRecorder = null;
		Toast.makeText(getApplicationContext(), "保存录音" + mFileName, 0).show();
	}

	private static final int POLL_INTERVAL = 300;
	private Runnable mPollTask = new Runnable() {
		public void run() {
			double amp = mRecorder.getMaxAmplitude() / 2700.0;
			updateDisplay(amp);
			mHandler.postDelayed(mPollTask, POLL_INTERVAL);

		}
	};

	private Runnable mSleepTask = new Runnable() {
		public void run() {
		}
	};

	private void updateDisplay(double signalEMA) {
		switch ((int) signalEMA) {
		case 0:
		case 1:
		case 2:
			iv_record.setImageResource(R.drawable.chat_icon_voice1);
			break;
		case 3:
		case 4:
		case 5:
			iv_record.setImageResource(R.drawable.chat_icon_voice2);
			break;
		case 6:
		case 7:
		case 8:
			iv_record.setImageResource(R.drawable.chat_icon_voice3);
			break;
		case 9:
		case 10:
		case 11:
			iv_record.setImageResource(R.drawable.chat_icon_voice4);
			break;
		case 12:
		case 13:
		case 14:
			iv_record.setImageResource(R.drawable.chat_icon_voice5);
			break;
		default:
			iv_record.setImageResource(R.drawable.chat_icon_voice6);
			break;
		}
	}

	private void initBottomView() {
		// ?????
		fl=(FrameLayout)findViewById(R.id.room_frame);
		btn_chat_add = (Button) findViewById(R.id.btn_chat_add);
		btn_chat_emo = (Button) findViewById(R.id.btn_chat_emo);
		btn_chat_add.setOnClickListener(this);
		btn_chat_emo.setOnClickListener(this);
		// ?????
		btn_chat_keyboard = (Button) findViewById(R.id.btn_chat_keyboard);
		btn_chat_voice = (Button) findViewById(R.id.btn_chat_voice);
		btn_chat_voice.setOnClickListener(this);
		btn_chat_keyboard.setOnClickListener(this);
		btn_chat_send = (Button) findViewById(R.id.btn_chat_send);
		btn_chat_send.setOnClickListener(this);
		layout_more = (LinearLayout) findViewById(R.id.layout_more);
		layout_emo = (LinearLayout) findViewById(R.id.layout_emo);
		layout_add = (LinearLayout) findViewById(R.id.layout_add);
		initAddView();
		initEmoView();

		btn_speak = (Button) findViewById(R.id.btn_speak);
		messageInput = (EmoticonsEditText) findViewById(R.id.edit_user_comment);
		messageInput.setOnClickListener(this);
		messageInput.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				if (!TextUtils.isEmpty(s)) {
					btn_chat_send.setVisibility(View.VISIBLE);
					btn_chat_keyboard.setVisibility(View.GONE);
					btn_chat_voice.setVisibility(View.GONE);
				} else {
					if (btn_chat_voice.getVisibility() != View.VISIBLE) {
						btn_chat_voice.setVisibility(View.VISIBLE);
						btn_chat_send.setVisibility(View.GONE);
						btn_chat_keyboard.setVisibility(View.GONE);
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});

	}

	List<FaceText> emos;

	private void initEmoView() {
		pager_emo = (ViewPager) findViewById(R.id.pager_emo);
		emos = FaceTextUtils.faceTexts;

		List<View> views = new ArrayList<View>();
		for (int i = 0; i < 2; ++i) {
			views.add(getGridView(i));
		}
		pager_emo.setAdapter(new EmoViewPagerAdapter(views));
	}

	private void initAddView() {
		tv_picture = (TextView) findViewById(R.id.tv_picture);
		tv_camera = (TextView) findViewById(R.id.tv_camera);
		tv_location = (TextView) findViewById(R.id.tv_location);
		tv_picture.setOnClickListener(this);
		tv_location.setOnClickListener(this);
		tv_camera.setOnClickListener(this);
	}

	private View getGridView(final int i) {
		View view = View.inflate(this, R.layout.include_emo_gridview, null);
		GridView gridview = (GridView) view.findViewById(R.id.gridview);
		List<FaceText> list = new ArrayList<FaceText>();
		if (i == 0) {
			list.addAll(emos.subList(0, 21));
		} else if (i == 1) {
			list.addAll(emos.subList(21, emos.size()));
		}
		final EmoteAdapter gridAdapter = new EmoteAdapter(
				RoomChatActivity.this, list);
		gridview.setAdapter(gridAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				FaceText name = (FaceText) gridAdapter.getItem(position);
				String key = name.text.toString();
				try {
					if (messageInput != null && !TextUtils.isEmpty(key)) {
						int start = messageInput.getSelectionStart();
						CharSequence content = messageInput.getText().insert(
								start, key);
						messageInput.setText(content);
						// ??λ???λ??
						CharSequence info = messageInput.getText();
						if (info instanceof Spannable) {
							Spannable spanText = (Spannable) info;
							Selection.setSelection(spanText,
									start + key.length());
						}
					}
				} catch (Exception e) {

				}

			}
		});
		return view;
	}

	private void init() {
		titleBack = (ImageView) findViewById(R.id.room_back);
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		userInfo = (ImageButton) findViewById(R.id.room_info);
		listView = (ListView) findViewById(R.id.room_chat_list);
		listView.setCacheColorHint(0);
		adapter = new RoomChatAdapter(RoomChatActivity.this, mDataArrays,listView);
		// 头
		LayoutInflater mynflater = LayoutInflater.from(RoomChatActivity.this);
		listHead = mynflater.inflate(R.layout.chatlistheader, null);
		listHeadButton = (Button) listHead.findViewById(R.id.buttonChatHistory);
		listHeadButton.setText("邀请好友进入聊天室");
		listHeadButton.setOnClickListener(invite);
		listView.addHeaderView(listHead);
		listView.setAdapter(adapter);

		messageInput = (EmoticonsEditText) findViewById(R.id.edit_user_comment);
		messageSendBtn = (Button) findViewById(R.id.btn_chat_send);
		messageSendBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String message = messageInput.getText().toString();
				if ("".equals(message)) {
					Toast.makeText(RoomChatActivity.this, "不能为空",
							Toast.LENGTH_SHORT).show();
				} else {

					try {
						String time = DateUtil.date2Str(Calendar.getInstance(),
								Constant.MS_FORMART);
						RoomMsg rm = new RoomMsg();
						rm.setCnt(message);

						rm.setTime(time);
						String useryy = XmppConnectionManager.getInstance()
								.getConnection().getUser();
						System.out.print(useryy);
						rm.setFrom("我");
						rm.setType(1);
						mDataArrays.add(rm);
						adapter.refresh(mDataArrays);
						muc.sendMessage(message);
						messageInput.setText("");
					} catch (Exception e) {
						showToast("信息发送失败");
						messageInput.setText(message);
					}
					closeInput();
				}
			}
		});
		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.chat_menu, menu);
		return true;
	}

	/**
	 * 点击邀请好友进入聊天室
	 */
	String a,b,c;
	private OnClickListener invite = new OnClickListener() {
		@Override
		public void onClick(View v) { 
			final List<RosterEntry> friends = XmppConnectionManager
					.getInstance().getAllEntrys(con.getRoster());
			int n = 0;
			for (int i = 0; i < friends.size(); i++) {
				RosterEntry entry = friends.get(i);
				 presence = con.getRoster().getPresence(entry.getUser());
				 both=presence.isAvailable();
				if (entry.getUser()!= null) {
					if(both){
						n += 1;
					}
					
				}
			}
			final String[] names = new String[n];
			final String[] invite = new String[n];
			n = 0;
			for (int i = 0; i < friends.size(); i++) {
				RosterEntry entry = friends.get(i);
				 presence = con.getRoster().getPresence(entry.getUser());
				 both=presence.isAvailable();
				if (entry.getUser()!= null) {
					if(both){
						names[n] = entry.getUser();
						//invite[n]=names[n].split("@")[0];
						n += 1;
					}
					/*if(entry.getType().equals("both")){
						
					}*/
				}
			}

			AlertDialog.Builder builder = new AlertDialog.Builder(
					RoomChatActivity.this);
			builder.setTitle("选择好友");
			builder.setItems(names, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int pos) {
					// TODO Auto-generated method stub
					dialog.cancel();
					muc.invite(names[pos], "加入我的会议室吧");
//					 if(XmppConnectionManager.getInstance().isUserSupportMUC(friends.get(pos).getUser())){
//						 
//					 }
//					 
//					 else{
//						 Toast.makeText(RoomChatActivity.this, "该好友设置了不加入会议室",
//								 Toast.LENGTH_SHORT).show();
//					 }
				}
			});
			builder.create().show();
		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.edit_user_comment:// ???????????
			// mListView.setSelection(mListView.getCount() - 1);
			if (layout_more.getVisibility() == View.VISIBLE) {
				layout_add.setVisibility(View.GONE);
				layout_emo.setVisibility(View.GONE);
				layout_more.setVisibility(View.GONE);
			}
			break;
		case R.id.btn_chat_emo:// ???Ц?????
			if (layout_more.getVisibility() == View.GONE) {
				showEditState(true);
			} else {
				if (layout_add.getVisibility() == View.VISIBLE) {
					layout_add.setVisibility(View.GONE);
					layout_emo.setVisibility(View.VISIBLE);
				} else {
					layout_more.setVisibility(View.GONE);
				}
			}

			break;
		case R.id.btn_chat_add://
			if (layout_more.getVisibility() == View.GONE) {
				layout_more.setVisibility(View.VISIBLE);
				layout_add.setVisibility(View.VISIBLE);
				layout_emo.setVisibility(View.GONE);
				hideSoftInputView();
			} else {
				if (layout_emo.getVisibility() == View.VISIBLE) {
					layout_emo.setVisibility(View.GONE);
					layout_add.setVisibility(View.VISIBLE);
				} else {
					layout_more.setVisibility(View.GONE);
				}
			}

			break;

		case R.id.btn_chat_voice:// ???????
			messageInput.setVisibility(View.GONE);
			layout_more.setVisibility(View.GONE);
			btn_chat_voice.setVisibility(View.GONE);
			btn_chat_keyboard.setVisibility(View.VISIBLE);
			btn_speak.setVisibility(View.VISIBLE);
			hideSoftInputView();
			break;

		case R.id.btn_chat_keyboard:// ?????????????????????????????????
			showEditState(false);
			break;

		case R.id.tv_camera:// ????
			selectImageFromCamera();
			break;
		case R.id.tv_picture:// ??
			selectImageFromLocal();
			break;
		case R.id.tv_location:// λ??
			selectLocationFromMap();
			break;
		default:
			break;
		}
	}

	private void selectLocationFromMap() {
		// Intent intent = new Intent(this, BMpActivityYY.class);
		// intent.putExtra("type", "select");
		// startActivityForResult(intent, 0x000003);
		// startActivity(intent);
	}

	public void selectImageFromLocal() {
		Intent intent;
		if (Build.VERSION.SDK_INT < 19) {
			intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setType("image/*");
		} else {
			intent = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		}
		startActivityForResult(intent, 2);
	}

	public void selectImageFromCamera() {
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File dir = new File(Environment.getExternalStorageDirectory()
				+ "/bmobimdemo/image/");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, String.valueOf(System.currentTimeMillis())
				+ ".jpg");
		localCameraPath = file.getPath();
		Uri imageUri = Uri.fromFile(file);
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		startActivityForResult(openCameraIntent, 0x000001);
	}

	Toast mToast;

	public void ShowToast(final int resId) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (mToast == null) {
					mToast = Toast.makeText(
							RoomChatActivity.this.getApplicationContext(),
							resId, Toast.LENGTH_LONG);
				} else {
					mToast.setText(resId);
				}
				mToast.show();
			}
		});
	}

	private void showEditState(boolean isEmo) {
		messageInput.setVisibility(View.VISIBLE);
		btn_chat_keyboard.setVisibility(View.GONE);
		btn_chat_voice.setVisibility(View.VISIBLE);
		btn_speak.setVisibility(View.GONE);
		messageInput.requestFocus();
		if (isEmo) {
			layout_more.setVisibility(View.VISIBLE);
			layout_more.setVisibility(View.VISIBLE);
			layout_emo.setVisibility(View.VISIBLE);
			layout_add.setVisibility(View.GONE);
			hideSoftInputView();
		} else {
			layout_more.setVisibility(View.GONE);
			showSoftInputView();
		}
	}

	public void hideSoftInputView() {
		InputMethodManager manager = ((InputMethodManager) this
				.getSystemService(Activity.INPUT_METHOD_SERVICE));
		if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
			if (getCurrentFocus() != null)
				manager.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	
	public void showSoftInputView() {
		if (getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
			if (getCurrentFocus() != null)
				((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
						.showSoftInput(messageInput, 0);
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case 1:// 获取照相机照片
					// ShowLog("本地图片的地址:" + localCameraPath);////
					// 当取到值的时候才上传path路径下的图片到服务器
				// sendImageMessage(localCameraPath);
				try {
					String time = DateUtil.date2Str(Calendar.getInstance(),
							Constant.MS_FORMART);
					RoomMsg rm = new RoomMsg();
					rm.setCnt(CommonUtils.getImageBase64(localCameraPath,String.valueOf(System.currentTimeMillis())));
					rm.setTime(time);
					rm.setFrom("我");
					rm.setType(1);
					mDataArrays.add(rm);
					adapter.refresh(mDataArrays);
					muc.sendMessage(CommonUtils.getImageBase64(localCameraPath,String.valueOf(System.currentTimeMillis())));
					System.out.print("消息发送成功！！！！！！消息发送成功！！！！！！！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				break;
			case 2: // 获取本地照片
				if (data != null) {
					Uri selectedImage = data.getData();
					if (selectedImage != null) {
						Cursor cursor = getContentResolver().query(
								selectedImage, null, null, null, null);
						cursor.moveToFirst();
						int columnIndex = cursor.getColumnIndex("_data");
						String localSelectPath = cursor.getString(columnIndex);
						System.out.println(localSelectPath);
						cursor.close();
						if (localSelectPath == null
								|| localSelectPath.equals("null")) {
							Toast.makeText(getApplicationContext(),
									"找不到您想要的图片", Toast.LENGTH_SHORT);
							return;
						}

						try {
							String time = DateUtil.date2Str(Calendar.getInstance(),
									Constant.MS_FORMART);
							RoomMsg rm = new RoomMsg();
							rm.setCnt(CommonUtils.getImageBase64(localSelectPath,String.valueOf(System.currentTimeMillis())));
							rm.setTime(time);
							rm.setFrom("我");
							rm.setType(1);
							mDataArrays.add(rm);
							adapter.refresh(mDataArrays);
							muc.sendMessage(CommonUtils.getImageBase64(localSelectPath,String.valueOf(System.currentTimeMillis())));
							System.out.print("消息发送成功！！！！！！消息发送成功！！！！！！！");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}  
				break;
			case 3:// 获取个人地理位置信息
				double latitude = data.getDoubleExtra("x", 0);// ???
				double longtitude = data.getDoubleExtra("y", 0);// ????
				String address = data.getStringExtra("address");
				if (address != null && !address.equals("")) {
					// sendLocationMessage(address, latitude, longtitude);
				} else {
					// ShowToast("无法获取到您的位置信息!");
				}

				break;
			}
		}
	}



	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		Log.i("", "");
		Log.i("", "");
		Log.i("", "");
		Log.i("", "");
	}
	public void member(View v){
		View view = findViewById(R.id.room_info);
		// 数组长度必须为2
		int[] locations = new int[2];
		view.getLocationOnScreen(locations);
		int x = locations[0];// 获取组件当前位置的横坐标
		int y = locations[1];// 获取组件当前位置的纵坐标
		Log.i("System.out", "x:" + x + "y:" + y);
		System.out.println("----------" + x + "---------" + y);
		uploadImage(RoomChatActivity.this, y + 60);
		/*Intent intent =new Intent(RoomChatActivity.this,RoomMemberActivity.class);
		startActivity(intent);*/
	}
	
	public void uploadImage(final Activity context, int y) {
		menuWindow = new SelectPicPopupWindow(RoomChatActivity.this,
				itemsOnClick);
		// 显示窗口
		menuWindow.showAtLocation(
				RoomChatActivity.this.findViewById(R.id.room_info),
				Gravity.TOP | Gravity.RIGHT, 0, y); // 设置layout在PopupWindow中显示的位置
	}
	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}
	};
}
