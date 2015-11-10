package csdn.shimiso.eim.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import csdn.shimiso.eim.R;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.model.LoginConfig;
import csdn.shimiso.eim.service.IMChatService;
import csdn.shimiso.eim.service.IMContactService;
import csdn.shimiso.eim.service.IMSystemMsgService;
import csdn.shimiso.eim.service.ReConnectService;

/**
 * Actity ����֧����
 * 
 * @author shimiso
 * 
 */
public class ActivitySupport extends Activity implements IActivitySupport {

	protected Context context = null;
	protected SharedPreferences preferences;
	protected EimApplication eimApplication;
	protected ProgressDialog pg = null;
	protected NotificationManager notificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		preferences = getSharedPreferences(Constant.LOGIN_SET, 0);
		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		pg = new ProgressDialog(context);
		eimApplication = (EimApplication) getApplication();
		eimApplication.addActivity(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public ProgressDialog getProgressDialog() {
		return pg;
	}

	@Override
	public void startService() {
		// ������ϵ�˷���
		Intent server = new Intent(context, IMContactService.class);
		context.startService(server);
		// �������
		Intent chatServer = new Intent(context, IMChatService.class);
		context.startService(chatServer);
		// �Զ��ָ����ӷ���
		Intent reConnectService = new Intent(context, ReConnectService.class);
		context.startService(reConnectService);
		// ϵͳ��Ϣ���ӷ���
		Intent imSystemMsgService = new Intent(context,
				IMSystemMsgService.class);
		context.startService(imSystemMsgService);
	}

	/**
	 * 
	 * ���ٷ���.
	 * 
	 */
	@Override
	public void stopService() {
		// ������ϵ�˷���
		Intent server = new Intent(context, IMContactService.class);
		context.stopService(server);
		// �������
		Intent chatServer = new Intent(context, IMChatService.class);
		context.stopService(chatServer);

		// �Զ��ָ����ӷ���
		Intent reConnectService = new Intent(context, ReConnectService.class);
		context.stopService(reConnectService);

		// ϵͳ��Ϣ���ӷ���
		Intent imSystemMsgService = new Intent(context,
				IMSystemMsgService.class);
		context.stopService(imSystemMsgService);
	}

	@Override
	public void isExit() {
		new AlertDialog.Builder(context).setTitle("ȷ���˳���?")
				.setNeutralButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						stopService();
						eimApplication.exit();
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).show();
	}

	@Override
	public boolean hasInternetConnected() {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);
		if (manager != null) {
			NetworkInfo network = manager.getActiveNetworkInfo();
			if (network != null && network.isConnectedOrConnecting()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validateInternet() {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);
		if (manager == null) {
			openWirelessSet();
			return false;
		} else {
			NetworkInfo[] info = manager.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		openWirelessSet();
		return false;
	}

	@Override
	public boolean hasLocationGPS() {
		LocationManager manager = (LocationManager) context
				.getSystemService(context.LOCATION_SERVICE);
		if (manager
				.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasLocationNetWork() {
		LocationManager manager = (LocationManager) context
				.getSystemService(context.LOCATION_SERVICE);
		if (manager
				.isProviderEnabled(android.location.LocationManager.NETWORK_PROVIDER)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void checkMemoryCard() {
		if (!Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			new AlertDialog.Builder(context)
					.setTitle(R.string.prompt)
					.setMessage("�����ڴ濨")
					.setPositiveButton(R.string.menu_settings,
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									Intent intent = new Intent(
											Settings.ACTION_SETTINGS);
									context.startActivity(intent);
								}
							})
					.setNegativeButton("�˳�",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									eimApplication.exit();
								}
							}).create().show();
		}
	}

	public void openWirelessSet() {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder
				.setTitle(R.string.prompt)
				.setMessage(context.getString(R.string.check_connection))
				.setPositiveButton(R.string.menu_settings,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
								Intent intent = new Intent(
										Settings.ACTION_WIRELESS_SETTINGS);
								context.startActivity(intent);
							}
						})
				.setNegativeButton(R.string.close,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.cancel();
							}
						});
		dialogBuilder.show();
	}

	/**
	 * 
	 * ��ʾtoast
	 * 
	 * @param text
	 * @param longint
	 * @author shimiso
	 * @update 2012-6-28 ����3:46:18
	 */
	public void showToast(String text, int longint) {
		Toast.makeText(context, text, longint).show();
	}

	@Override
	public void showToast(String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 
	 * �رռ����¼�
	 * 
	 * @author shimiso
	 * @update 2012-7-4 ����2:34:34
	 */
	public void closeInput() {
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (inputMethodManager != null && this.getCurrentFocus() != null) {
			inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus()
					.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 
	 * ����Notification��method.
	 * 
	 * @param iconId
	 *            ͼ��
	 * @param contentTitle
	 *            ����
	 * @param contentText
	 *            ������
	 * @param activity
	 * @author shimiso
	 * @update 2012-5-14 ����12:01:55
	 */
	public void setNotiType(int iconId, String contentTitle,
			String contentText, Class activity, String from) {
		/*
		 * �����µ�Intent����Ϊ���Notification������ʱ�� �����е�Activity
		 */
		Intent notifyIntent = new Intent(this, activity);
		notifyIntent.putExtra("to", from);
		// notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		/* ����PendingIntent��Ϊ���õ������е�Activity */
		PendingIntent appIntent = PendingIntent.getActivity(this, 0,
				notifyIntent, 0);

		/* ����Notication����������ز��� */
		Notification myNoti = new Notification();
		// ����Զ���ʧ
		myNoti.flags = Notification.FLAG_AUTO_CANCEL;
		/* ����statusbar��ʾ��icon */
		myNoti.icon = iconId;
		/* ����statusbar��ʾ��������Ϣ */
		myNoti.tickerText = contentTitle;
		/* ����notification����ʱͬʱ����Ĭ������ */
		myNoti.defaults = Notification.DEFAULT_SOUND;
		/* ����Notification�������Ĳ��� */
		myNoti.setLatestEventInfo(this, contentTitle, contentText, appIntent);
		/* �ͳ�Notification */
		notificationManager.notify(0, myNoti);
	}

	@Override
	public Context getContext() {
		return context;
	}

	@Override
	public SharedPreferences getLoginUserSharedPre() {
		return preferences;
	}

	@Override
	public void saveLoginConfig(LoginConfig loginConfig) {
		preferences.edit()
				.putString(Constant.XMPP_HOST, loginConfig.getXmppHost())
				.commit();
		preferences.edit()
				.putInt(Constant.XMPP_PORT, loginConfig.getXmppPort()).commit();
		preferences
				.edit()
				.putString(Constant.XMPP_SEIVICE_NAME,
						loginConfig.getXmppServiceName()).commit();
		preferences.edit()
				.putString(Constant.USERNAME, loginConfig.getUsername())
				.commit();
		preferences.edit()
				.putString(Constant.PASSWORD, loginConfig.getPassword())
				.commit();
		preferences.edit()
				.putBoolean(Constant.IS_AUTOLOGIN, loginConfig.isAutoLogin())
				.commit();
		preferences.edit()
				.putBoolean(Constant.IS_NOVISIBLE, loginConfig.isNovisible())
				.commit();
		preferences.edit()
				.putBoolean(Constant.IS_REMEMBER, loginConfig.isRemember())
				.commit();
		preferences.edit()
				.putBoolean(Constant.IS_ONLINE, loginConfig.isOnline())
				.commit();
		preferences.edit()
				.putBoolean(Constant.IS_FIRSTSTART, loginConfig.isFirstStart())
				.commit();
	}

	@Override
	public LoginConfig getLoginConfig() {
		LoginConfig loginConfig = new LoginConfig();
		String a = preferences.getString(Constant.XMPP_HOST, null);
		String b = getResources().getString(R.string.xmpp_host);
		loginConfig.setXmppHost(preferences.getString(Constant.XMPP_HOST,
				getResources().getString(R.string.xmpp_host)));
		loginConfig.setXmppPort(preferences.getInt(Constant.XMPP_PORT,
				getResources().getInteger(R.integer.xmpp_port)));
		loginConfig.setUsername(preferences.getString(Constant.USERNAME, null));
		loginConfig.setPassword(preferences.getString(Constant.PASSWORD, null));
		loginConfig.setXmppServiceName(preferences.getString(
				Constant.XMPP_SEIVICE_NAME,
				getResources().getString(R.string.xmpp_service_name)));
		loginConfig.setAutoLogin(preferences.getBoolean(Constant.IS_AUTOLOGIN,
				getResources().getBoolean(R.bool.is_autologin)));
		loginConfig.setNovisible(preferences.getBoolean(Constant.IS_NOVISIBLE,
				getResources().getBoolean(R.bool.is_novisible)));
		loginConfig.setRemember(preferences.getBoolean(Constant.IS_REMEMBER,
				getResources().getBoolean(R.bool.is_remember)));
		loginConfig.setFirstStart(preferences.getBoolean(
				Constant.IS_FIRSTSTART, true));
		return loginConfig;
	}

	@Override
	public boolean getUserOnlineState() {
		// preferences = getSharedPreferences(Constant.LOGIN_SET,0);
		return preferences.getBoolean(Constant.IS_ONLINE, true);
	}

	@Override
	public void setUserOnlineState(boolean isOnline) {
		// preferences = getSharedPreferences(Constant.LOGIN_SET,0);
		preferences.edit().putBoolean(Constant.IS_ONLINE, isOnline).commit();

	}

	@Override
	public EimApplication getEimApplication() {
		return eimApplication;
	}
}
