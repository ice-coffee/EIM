package csdn.shimiso.eim.activity.im;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import Decoder.BASE64Decoder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.activity.LoginActivity;
import csdn.shimiso.eim.activity.MainActivity;
import csdn.shimiso.eim.adapter.EmoViewPagerAdapter;
import csdn.shimiso.eim.adapter.EmoteAdapter;
import csdn.shimiso.eim.manager.ContacterManager;
import csdn.shimiso.eim.manager.MessageManager;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.model.IMMessage;
import csdn.shimiso.eim.model.SoundMeter;
import csdn.shimiso.eim.model.User;
import csdn.shimiso.eim.util.BASE64Encoder;
import csdn.shimiso.eim.util.BitmapCommon;
import csdn.shimiso.eim.util.CommonUtils;
import csdn.shimiso.eim.util.EmoticonsEditText;
import csdn.shimiso.eim.util.FaceText;
import csdn.shimiso.eim.util.FaceTextUtils;
import csdn.shimiso.eim.util.HeaderLayout;
import csdn.shimiso.eim.util.StringUtil;

public class ChatActivity extends AChatActivity implements OnClickListener,
		ChatManagerListener, PacketListener {
	// ListView mListView;
    /* 聊天界面右下角的三个不同按钮分表代表: 内容数据/语音输入/发送 */
	private Button btn_chat_send, btn_chat_keyboard, btn_chat_voice;
	private Button btn_chat_emo, btn_chat_add,  btn_speak;
	String targetId = "";
	HeaderLayout mHeaderLayout;
	private static int MsgPagerNum;
	private LinearLayout layout_more, layout_emo, layout_add;
	private ViewPager pager_emo;
	private TextView tv_picture, tv_camera, tv_location;
	private String localCameraPath = "";
	RelativeLayout layout_record;
	private Handler mHandler = new Handler();
	TextView tv_voice_tips;
	ImageView iv_record;
	private Drawable[] drawable_Anims;// ???????
	public static String tag = "ChatActivity";
	private ImageView titleBack;
	private MessageListAdapter adapter = null;
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
	private static final String LOG_TAG = "AudioRecordTest";
	/** 语音文件保存路径 */
	private String mFileName = null;
	/** 按住说话按钮 */
	private Button mBtnVoice;
	/** 用于语音播放 */
	private MediaPlayer mPlayer = null;
	/** 用于完成录音 */
	private MediaRecorder mRecorder = null;
	public static Message message = null;
	private Bitmap bp;
	private static final String PATH = "/sdcard/MyVoiceForder/Record/";
	private static final String PATHIMG = "/sdcard/MyImageForder/Record/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		initView();
		// initData();
		init();
	}

	private void initView() {
		/*
		 * mHeaderLayout = (HeaderLayout) findViewById(R.id.common_actionbar);
		 * listView = (ListView) findViewById(R.id.listView);
		 * initTopBarForLeft("??" + targetUser.getUsername() + "???");
		 */
		initBottomView();
		initVoiceView();
		// initView();
	}

	private void initVoiceView() {

		layout_record = (RelativeLayout) findViewById(R.id.layout_record);
		tv_voice_tips = (TextView) findViewById(R.id.tv_voice_tips);
		iv_record = (ImageView) findViewById(R.id.iv_record);

		btn_speak.setOnTouchListener(new OnTouchListener() {
			long beforeTime;
			long afterTime;
			int timeDistance;
            String dir = null;

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
					dir = startVoice();
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
							+ CommonUtils.GetImageStr(mFileName) + "@" + dir
							+ CommonUtils.VOICE_SIGN;
					if ("".equals(mFileName)) {
						Toast.makeText(ChatActivity.this, "不能为空",
								Toast.LENGTH_SHORT).show();
					} else {
						// (afterTime-beforeTime)/1000
						try {
							if ((afterTime - beforeTime) < 500) {
								Toast.makeText(getApplicationContext(),
										"录音时间太短！", Toast.LENGTH_SHORT).show();
								File file = new File(mFileName);
								file.delete();
							} else {
								sendMessage(voiceFile + "&"
										+ (afterTime - beforeTime) / 1000);
							}

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

	/** 开始录音 */
	private String startVoice() {
        //获取当前时间
		String dir = String.valueOf(System.currentTimeMillis());
		// 设置录音保存路径
		mFileName = PATH + dir + ".amr";
		System.out.println(mFileName);
        // 获取SD卡的状态
		String state = android.os.Environment.getExternalStorageState();
		if (!state.equals(android.os.Environment.MEDIA_MOUNTED)) {
			Log.i(LOG_TAG, "SD Card is not mounted,It is  " + state + ".");
		}
		File directory = new File(mFileName).getParentFile();
		if (!directory.exists() && !directory.mkdirs()) {
			Log.i(LOG_TAG, "Path to file could not be created");
		}
		Toast.makeText(getApplicationContext(), "开始录音", Toast.LENGTH_SHORT).show();
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
		return dir;
	}

	/** 停止录音 */
	private void stopVoice() {
		mRecorder.stop();
		mRecorder.release();
		mRecorder = null;
		Toast.makeText(getApplicationContext(), "保存录音" + mFileName, Toast.LENGTH_SHORT).show();
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

    /**
     * 录音图标替换
     * @param signalEMA
     */
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
		// ??????
		layout_more = (LinearLayout) findViewById(R.id.layout_more);
		layout_emo = (LinearLayout) findViewById(R.id.layout_emo);
		layout_add = (LinearLayout) findViewById(R.id.layout_add);
		initAddView();
		initEmoView();

		// ???м?
		// ??????
		btn_speak = (Button) findViewById(R.id.btn_speak);
		// ?????
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

    /**
     * 初始化表情
     */
	private void initEmoView() {
		pager_emo = (ViewPager) findViewById(R.id.pager_emo);
		emos = FaceTextUtils.faceTexts;

        /**
         * 生成每一个pager放到一个list集合中
         */
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
		final EmoteAdapter gridAdapter = new EmoteAdapter(ChatActivity.this, list);
		gridview.setAdapter(gridAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				FaceText name = (FaceText) gridAdapter.getItem(position);
				String key = name.text.toString();
				try {
					if (messageInput != null && !TextUtils.isEmpty(key)) {
                        /*获取光标选中的位置*/
						int start = messageInput.getSelectionStart();
                        /*把选中的表情插入光标所在的位置*/
						CharSequence content = messageInput.getText().insert(
								start, key);
                        /*再把新的输入信息放到输入框中*/
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
		titleBack = (ImageView) findViewById(R.id.title_back);
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// iv_status=findViewById(R.id.)
		// 与谁聊天
		tvChatTitle = (TextView) findViewById(R.id.to_chat_name);
		user = ContacterManager.getByUserJid(to, XmppConnectionManager
				.getInstance().getConnection());
		if (null == user) {
			to_name = StringUtil.getUserNameByJid(to);
		} else {
			to_name = user.getName() == null ? user.getJID() : user.getName();

		}
		tvChatTitle.setText(to_name);

		userInfo = (ImageButton) findViewById(R.id.user_info);
		userInfo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, FriendInfoActivity.class);
				startActivity(intent);
			}
		});

		listView = (ListView) findViewById(R.id.chat_list);
		listView.setCacheColorHint(0);
		adapter = new MessageListAdapter(ChatActivity.this, getMessages(),
				listView);
		// 头

		LayoutInflater mynflater = LayoutInflater.from(context);
		listHead = mynflater.inflate(R.layout.chatlistheader, null);
		listHeadButton = (Button) listHead.findViewById(R.id.buttonChatHistory);
		listHeadButton.setOnClickListener(chatHistoryCk);
		listView.addHeaderView(listHead);
		listView.setAdapter(adapter);

		messageInput = (EmoticonsEditText) findViewById(R.id.edit_user_comment);
		messageSendBtn = (Button) findViewById(R.id.btn_chat_send);
		messageSendBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String message = messageInput.getText().toString();
				if ("".equals(message)) {
					Toast.makeText(ChatActivity.this, "不能为空",
							Toast.LENGTH_SHORT).show();
				} else {

					try {
						sendMessage(message);
						messageInput.setText("");
					} catch (Exception e) {
						showToast("信息发送失败");
						messageInput.setText(message);
					}
					closeInput();
				}
			}
		});
	}

	@Override
	protected void receiveNewMessage(IMMessage message) {

	}

	@Override
	protected void refreshMessage(List<IMMessage> messages) {

		adapter.refreshList(messages);
	}

	@Override
	protected void onResume() {
		super.onResume();
		recordCount = MessageManager.getInstance(context)
				.getChatCountWithSb(to);
		if (recordCount <= 0) {
			listHead.setVisibility(View.GONE);
		} else {
			listHead.setVisibility(View.VISIBLE);
		}
		adapter.refreshList(getMessages());
	}

	private class MessageListAdapter extends BaseAdapter {
		private List<IMMessage> items;
		private Context context;
		private ListView adapterList;
		private LayoutInflater inflater;

		public MessageListAdapter(Context context, List<IMMessage> items,
				ListView adapterList) {
			this.context = context;
			this.items = items;
			this.adapterList = adapterList;
		}

		public void refreshList(List<IMMessage> items) {
			this.items = items;
			this.notifyDataSetChanged();
			adapterList.setSelection(items.size() - 1);
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
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			IMMessage message = items.get(position);
			System.out.println(message.getContent());
			String[] strarray;
			String voiceFile;
			String voiceTime;
			String path;
			final Intent intent = new Intent();
			boolean result = false;
			List<String> list = CommonUtils.getImagePathFromSD();
			int msgViewTime;
            /* 根据MsgType区分消息来源:接收/发送 */
			if (message.getMsgType() == 0) {
                /* 判断是否是图片信息 */
				if (message.getContent().contains(CommonUtils.PIC_SIGN)) {
					convertView = this.inflater.inflate(
							R.layout.chat_rce_picture, null);
				} else {
					convertView = this.inflater.inflate(
							R.layout.formclient_chat_in, null);
				}
			} else {
				if (message.getContent().contains(CommonUtils.PIC_SIGN)) {
					convertView = this.inflater.inflate(
							R.layout.chat_send_picture, null);
				} else {
					convertView = this.inflater.inflate(
							R.layout.formclient_chat_out, null);
				}
			}
			ImageView imageMsg = (ImageView) convertView
					.findViewById(R.id.send_picture);
			TextView useridView = (TextView) convertView
					.findViewById(R.id.formclient_row_userid);
			TextView dateView = (TextView) convertView
					.findViewById(R.id.formclient_row_date);
			TextView msgView = (TextView) convertView
					.findViewById(R.id.formclient_row_msg);
			TextView voiceTimeView = (TextView) convertView
					.findViewById(R.id.voice_time);
			dateView.setText(message.getTime());
			if (message.getMsgType() == 0) {

				if (message.getContent().contains(CommonUtils.PIC_SIGN)) {
					String[] arr = message.getContent().split(
							CommonUtils.PIC_SIGN);
					String[] brr = arr[1].split("@");
					String imgFilePath = PATH + brr[1] + ".jpg";
					result = CommonUtils.judge(list, imgFilePath);
					if (!result) {
						imgFilePath = CommonUtils.GenerateImage(brr[0], brr[1]);
					}
					try {
					    // 实例化Bitmap
						bp = BitmapCommon.setBitmapSize(imgFilePath);
					} catch (OutOfMemoryError e) {
						e.printStackTrace();
					}
					imageMsg.setImageBitmap(bp);
					final String dir = imgFilePath;
					imageMsg.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							// System.out.println(voiceFileDir);
							intent.putExtra("dir",dir);
							intent.setClass(ChatActivity.this, ImageShower.class);
							startActivity(intent);
						}
					});
				} else if (message.getContent()
						.contains(CommonUtils.VOICE_SIGN)) {
					path = CommonUtils
							.getMediaPath(items, message.getContent());
					strarray = message.getContent().split("&");
					voiceFile = strarray[0];
					voiceTime = strarray[1];
					msgViewTime = Integer.parseInt(voiceTime);
					String msgViewLength = "";
					voiceTimeView.setVisibility(View.VISIBLE);
					voiceTimeView.setText(voiceTime + "\"");
					for (int i = 0; i < msgViewTime; i++) {
						msgViewLength += "  ";
					}
					String voiceArr[] = voiceFile.split(CommonUtils.VOICE_SIGN);
					String voiceBrr[] = voiceArr[1].split("@");
					String imgFilePath = PATH + voiceBrr[1] + ".amr";
					result = CommonUtils.judge(list, imgFilePath);
					final String voiceFileDir;
					if (result) {
						voiceFileDir = imgFilePath;
					} else {
						voiceFileDir = CommonUtils.GenerateVoic(voiceBrr[0],
								voiceBrr[1]);

					}
					msgView.setText(msgViewLength);
					msgView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							R.drawable.chatto_voice_playing, 0);
					msgView.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							System.out.println(voiceFileDir);
							if (voiceFileDir.contains(".amr")) {
								CommonUtils.playMusic(voiceFileDir);
							}
						}
					});
				} else {
					SpannableString spannableString = FaceTextUtils
							.toSpannableString(context, message.getContent());
					msgView.setText(spannableString);
					// viewHolder.tvContent.setCompoundDrawablesWithIntrinsicBounds(0,
					// 0, 0, 0);
					// viewHolder.tvTime.setText("");
				}
				if (null == user) {
					useridView.setText(StringUtil.getUserNameByJid(to));
				} else {
					useridView.setText(user.getName());
				}

			} else {
				if (message.getContent().contains(CommonUtils.PIC_SIGN)) {
					String[] arr = message.getContent().split(
							CommonUtils.PIC_SIGN);
					String[] brr = arr[1].split("@");
					String imgFilePath = PATH + brr[1] + ".jpg";
					result = CommonUtils.judge(list, imgFilePath);
					if (!result) {
						imgFilePath = CommonUtils.GenerateImage(brr[0], brr[1]);
					}
					try {
					    // 实例化Bitmap
						bp = BitmapCommon.setBitmapSize(imgFilePath);
					} catch (OutOfMemoryError e) {
						e.printStackTrace();
					}
					imageMsg.setImageBitmap(bp);
					final String dir = imgFilePath;
					imageMsg.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							// System.out.println(voiceFileDir);
							intent.putExtra("dir",dir);
							intent.setClass(ChatActivity.this, ImageShower.class);
							startActivity(intent);
						}
					});
				}

				else if (message.getContent().contains(CommonUtils.VOICE_SIGN)) {
					path = CommonUtils
							.getMediaPath(items, message.getContent());
					strarray = message.getContent().split("&");
					voiceFile = strarray[0];
					voiceTime = strarray[1];
					msgViewTime = Integer.parseInt(voiceTime);
					String msgViewLength = "";
					voiceTimeView.setVisibility(View.VISIBLE);
					voiceTimeView.setText(voiceTime + "\"");
					for (int i = 0; i < msgViewTime; i++) {
						msgViewLength += "  ";
					}
					String voiceArr[] = voiceFile.split(CommonUtils.VOICE_SIGN);
					String voiceBrr[] = voiceArr[1].split("@");
					String imgFilePath = PATH + voiceBrr[1] + ".amr";
					result = CommonUtils.judge(list, imgFilePath);
					final String voiceFileDir;
					if (result) {
						voiceFileDir = imgFilePath;
					} else {
						voiceFileDir = CommonUtils.GenerateVoic(voiceBrr[0],
								voiceBrr[1]);

					}
					// final String voiceFileDir =
					// CommonUtils.GenerateVoic(voiceArr[1]);
					// final String voiceFileDir = voiceFile;
					msgView.setText(msgViewLength);
					msgView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							R.drawable.chatto_voice_playing, 0);
					msgView.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							System.out.println(voiceFileDir);
							if (voiceFileDir.contains(".amr")) {
								CommonUtils.playMusic(voiceFileDir);
							}
						}
					});
				} else {
					SpannableString spannableString = FaceTextUtils
							.toSpannableString(context, message.getContent());
					msgView.setText(spannableString);
				}
				useridView.setText("我");
			}
			return convertView;
		}

	}

	public static void deleteFile(File file) {

		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			}
			// 如果它是一个目录
			else if (file.isDirectory()) {
				// 声明目录下所有的文件 files[];
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.chat_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent();
		switch (item.getItemId()) {
		case R.id.menu_return_main_page:
			intent.setClass(context, MainActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.menu_relogin:
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
	 * 点击进入聊天记录
	 */
	private OnClickListener chatHistoryCk = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent in = new Intent(context, ChatHistoryActivity.class);
			in.putExtra("to", to);
			startActivity(in);
		}
	};

	@Override
	public void processPacket(Packet arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chatCreated(Chat arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

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
		case R.id.btn_chat_send:
			String message = messageInput.getText().toString();
			if ("".equals(message)) {
				Toast.makeText(ChatActivity.this, "不能为空", Toast.LENGTH_SHORT)
						.show();
			} else {

				try {
					sendMessage(message);
					messageInput.setText("");
				} catch (Exception e) {
					showToast("信息发送失败");
					messageInput.setText(message);
				}
				closeInput();
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
		startActivityForResult(openCameraIntent, 1);
	}

	Toast mToast;

	public void ShowToast(final int resId) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (mToast == null) {
					mToast = Toast.makeText(
							ChatActivity.this.getApplicationContext(), resId,
							Toast.LENGTH_LONG);
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

	// ????????
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
				try {
					sendMessage(CommonUtils.getImageBase64(localCameraPath, "@"
							+ String.valueOf(System.currentTimeMillis())));
					System.out.print("消息发送成功！！！！！！消息发送成功！！！！！！！");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// CommonUtils.saveToSDCard("d.txt",
				// CommonUtils.getImageBase64(localCameraPath,String.valueOf(System.currentTimeMillis())));
				// sendImageMessage(localCameraPath);
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
							// CommonUtils.saveToSDCard("c.txt",
							// CommonUtils.getImageBase64(localSelectPath));
							sendMessage(CommonUtils.getImageBase64(
									localSelectPath,
									"@"
											+ String.valueOf(System
													.currentTimeMillis())));
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

	/* (non-Javadoc)
	 * @see csdn.shimiso.eim.activity.ActivitySupport#onDestroy()
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(bp != null && !bp.isRecycled()){ 

	        // 回收并且置为null
			bp.recycle(); 
			bp = null; 
	} 
	System.gc();
	}

}
