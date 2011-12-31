package com.rothconsulting.android.localtv;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Util {

	private static final String TAG = "Util";

	public static boolean isFlashInstalled(Context context) {
		boolean flashInstalled = false;
		try {
			PackageManager pm = context.getPackageManager();
			ApplicationInfo ai = pm.getApplicationInfo("com.adobe.flashplayer",
					0);
			if (ai != null)
				flashInstalled = true;
		} catch (NameNotFoundException e) {
			flashInstalled = false;
		}
		return flashInstalled;
	}

	protected static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] infos = connectivity.getAllNetworkInfo();
			if (infos != null) {
				for (NetworkInfo ni : infos) {
					if (ni.getState() == NetworkInfo.State.CONNECTED) {
						Log.d(TAG, "Wir sind connected!");
						return true;
					}
				}
			}
		}
		Log.d(TAG, "Keine Connectivity");
		return false;
	}

}
