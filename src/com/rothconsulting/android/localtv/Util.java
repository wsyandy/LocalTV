package com.rothconsulting.android.localtv;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Util {

	private static final String TAG = "Util";

	private static final int NOTIFICATION_ID = 0;

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

	public static void showFlashAlert(final Context context) {

		final Intent i = new Intent(Intent.ACTION_VIEW,
				Uri.parse(Constants.FLASH_MARKET_URL));

		final Builder b = new Builder(context);
		b.setCancelable(true);
		b.setTitle(R.string.flashNotInstalled);
		String text = context.getString(R.string.flashDownloadText);
		b.setMessage(text);
		b.setNegativeButton(R.string.neinDanke, null);
		b.setPositiveButton(R.string.download,
				new DialogInterface.OnClickListener() {
					public void onClick(final DialogInterface dialog,
							final int which) {

						if (isNetworkAvailable(context)) {
							context.startActivity(i);
						} else {
							Toast.makeText(
									context,
									context.getResources().getString(
											R.string.internetNotConnected),
									Toast.LENGTH_LONG).show();
						}
					}
				});
		b.show();
	}

	public static void startBrowserActivity(Context context, String url) {
		Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		viewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(viewIntent);
	}

	public static boolean isNetworkAvailable(Context context) {
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

	public static void showStatusBarNotification(Context context,
			String stationName) {

		String appName = context.getResources().getString(R.string.app_name);

		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification(R.drawable.tv_icon,
				appName + " start...", System.currentTimeMillis());

		Intent intent = new Intent(context, TVPlayer.class);
		intent.putExtra(Constants.FROM_NOTIFICATION,
				Constants.FROM_NOTIFICATION);
		intent.putExtra(Constants.NAME, stationName);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				intent, 0);

		notification.setLatestEventInfo(context, appName, stationName,
				contentIntent);

		mNotificationManager.notify(NOTIFICATION_ID, notification);
	}

	public static void hideStatusBarNotification(Context context) {
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(ns);
		mNotificationManager.cancel(NOTIFICATION_ID);
	}

	public static String getAppVersionName(Context context, Class<?> cls) {
		try {
			ComponentName comp = new ComponentName(context, cls);
			PackageInfo pinfo = context.getPackageManager().getPackageInfo(
					comp.getPackageName(), 0);
			return pinfo.versionName;
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			return "";
		}
	}

	public static void clearApplicationData(Context context) {

		File cache = context.getCacheDir();
		File appDir = new File(cache.getParent());
		if (appDir.exists()) {
			String[] children = appDir.list();
			for (String s : children) {
				if (!s.equals("lib")) {
					deleteDir(new File(appDir, s));
					Log.d("TAG", "*************** File /data/data/APP_PACKAGE/"
							+ s + " DELETED ***");
				}
			}
		}
	}

	public static boolean deleteDir(File dir) {
		if (dir != null && dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

	public static List<String> getStationNameList() {
		ArrayList<HashMap<String, Object>> stationList = Stations
				.getAllStations();
		List<String> result = new ArrayList<String>();

		for (HashMap<String, Object> station : stationList) {
			result.add("" + station.get("name"));
		}
		return result;
	}

	public static String getUrl(String stationName) {
		ArrayList<HashMap<String, Object>> stationList = Stations
				.getAllStations();

		for (HashMap<String, Object> station : stationList) {
			if (("" + station.get("name")).equalsIgnoreCase(stationName)) {
				return "" + station.get("url");
			}
		}
		return "";
	}

	public static void hideKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromInputMethod(view.getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
	}

	public static void showKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
	}
}