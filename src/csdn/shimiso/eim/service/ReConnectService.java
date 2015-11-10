package csdn.shimiso.eim.service;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import csdn.shimiso.eim.comm.Constant;
import csdn.shimiso.eim.manager.XmppConnectionManager;

/**
 * 
 * �����ӷ���.
 * 
 * @author shimiso
 */
public class ReConnectService extends Service {
	private Context context;
	private ConnectivityManager connectivityManager;
	private NetworkInfo info;

	@Override
	public void onCreate() {
		context = this;
		IntentFilter mFilter = new IntentFilter();
		mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(reConnectionBroadcastReceiver, mFilter);
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		unregisterReceiver(reConnectionBroadcastReceiver);
		super.onDestroy();
	}

	BroadcastReceiver reConnectionBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
				Log.d("mark", "����״̬�Ѿ��ı�");
				connectivityManager = (ConnectivityManager) context
						.getSystemService(Context.CONNECTIVITY_SERVICE);
				XMPPConnection connection = XmppConnectionManager.getInstance()
						.getConnection();
				info = connectivityManager.getActiveNetworkInfo();
				if (info != null && info.isAvailable()) {
					if (!connection.isConnected()) {
						reConnect(connection);
					} else {
						sendInentAndPre(Constant.RECONNECT_STATE_SUCCESS);
						Toast.makeText(context, "�û�������!", Toast.LENGTH_LONG)
								.show();
					}
				} else {
					sendInentAndPre(Constant.RECONNECT_STATE_FAIL);
					Toast.makeText(context, "����Ͽ�,�û�������!", Toast.LENGTH_LONG)
							.show();
				}
			}

		}

	};

	/**
	 * 
	 * �ݹ�������ֱ����Ϊֹ.
	 * 
	 * @author shimiso
	 * @update 2012-7-10 ����2:12:25
	 */
	public void reConnect(XMPPConnection connection) {
		try {
			connection.connect();
			if (connection.isConnected()) {
				Presence presence = new Presence(Presence.Type.available);
				connection.sendPacket(presence);
				Toast.makeText(context, "�û�������!", Toast.LENGTH_LONG).show();
			}
		} catch (XMPPException e) {
			Log.e("ERROR", "XMPP����ʧ��!", e);
			reConnect(connection);
		}
	}

	private void sendInentAndPre(boolean isSuccess) {
		Intent intent = new Intent();
		SharedPreferences preference = getSharedPreferences(Constant.LOGIN_SET,
				0);
		// ��������������Ϣ
		preference.edit().putBoolean(Constant.IS_ONLINE, isSuccess).commit();
		intent.setAction(Constant.ACTION_RECONNECT_STATE);
		intent.putExtra(Constant.RECONNECT_STATE, isSuccess);
		sendBroadcast(intent);
	}

}
