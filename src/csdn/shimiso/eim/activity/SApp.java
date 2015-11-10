package csdn.shimiso.eim.activity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import csdn.shimiso.eim.comm.AppException;
import csdn.shimiso.eim.manager.XmppConnectionManager;
import csdn.shimiso.eim.service.PresenceService;


import android.app.Application;
import android.content.Intent;

public class SApp extends Application {
	
	private String tag = "App";
	
	private static SApp instance;
	public static SApp getInstance(){
		return instance;
	}
	
	private ExecutorService es;
	
	public void execRunnable(Runnable r){
		es.execute(r);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		Thread.setDefaultUncaughtExceptionHandler(AppException.getInstance());
		es = Executors.newFixedThreadPool(3);
	}
	
	public void exit(){
		XmppConnectionManager.getInstance().disconnect();
		stopService(new Intent(this,PresenceService.class));
	}

}
