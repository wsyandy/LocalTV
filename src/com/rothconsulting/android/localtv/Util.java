package com.rothconsulting.android.localtv;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
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
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Util {

	private static final String TAG = "Util";

	private static final int NOTIFICATION_ID = 0;

	public static void log(String tag, String message) {
		// Log.d(tag, message);
	}

	public static boolean isFlashInstalled(Context context) {
		boolean flashInstalled = false;
		try {
			PackageManager pm = context.getPackageManager();
			ApplicationInfo ai = pm.getApplicationInfo("com.adobe.flashplayer", 0);
			if (ai != null)
				flashInstalled = true;
		} catch (NameNotFoundException e) {
			flashInstalled = false;
		}
		return flashInstalled;
	}

	public static String getFlashVersion(Context context) {
		String version = "";
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pInfo = pm.getPackageInfo("com.adobe.flashplayer", 0);
			version = pInfo.versionName;
		} catch (NameNotFoundException e) {
			// do nothing
		}
		return version;
	}

	public static void showFlashAlert(final Context context, final int titleResId) {

		final Builder b = new AlertDialog.Builder(context);
		b.setCancelable(true);
		b.setTitle(titleResId);
		String text = context.getString(R.string.flashDownloadText);
		b.setMessage(text);
		b.setNegativeButton(R.string.neinDanke, null);

		// // Ignore Play Store for: Jelly Bean or higher and CPU ARM-v6
		if (Build.VERSION.SDK_INT < 16 && !Build.CPU_ABI.contains("-v6")) {
			b.setPositiveButton(R.string.googlePlay, new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {

					if (isNetworkAvailable(context)) {
						final Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FLASH_PLAY_STORE_URL));
						i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(i);
					} else {
						Toast.makeText(context, context.getResources().getString(R.string.internetNotConnected), Toast.LENGTH_LONG).show();
					}
				}
			});
		}
		b.setNeutralButton(R.string.directDownload, new DialogInterface.OnClickListener() {
			public void onClick(final DialogInterface dialog, int which) {

				if (isNetworkAvailable(context)) {
					Intent i = null;
					if (Build.VERSION.SDK_INT < 14) { // 2.x and 3.x
						i = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FLASH_DIRCET_DOWNLOAD_URL_2X_3X));
					} else { // 4.x and higher
						i = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FLASH_DIRCET_DOWNLOAD_URL_4X));
					}
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(i);
				} else {
					Toast.makeText(context, context.getResources().getString(R.string.internetNotConnected), Toast.LENGTH_LONG).show();
				}
			}
		});
		b.show();
	}

	public static void showEmptyFavAlertDialog(final Context context) {
		final Builder b = new AlertDialog.Builder(context);
		b.setCancelable(true);
		b.setTitle(R.string.info);
		String text = context.getString(R.string.noFavouritesYet);
		b.setMessage(text);
		b.setPositiveButton(android.R.string.ok, null);
		b.show();
	}

	public static void startBrowserActivity(Context context, String url) {
		Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		viewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(viewIntent);
	}

	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] infos = connectivity.getAllNetworkInfo();
			if (infos != null) {
				for (NetworkInfo ni : infos) {
					if (ni.getState() == NetworkInfo.State.CONNECTED) {
						Util.log(TAG, "Wir sind connected!");
						return true;
					}
				}
			}
		}
		Util.log(TAG, "Keine Connectivity");
		return false;
	}

	public static void showStatusBarNotification(Context context, String stationName) {

		String appName = context.getResources().getString(R.string.app_name);

		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notification = new Notification(R.drawable.tv_icon, appName + " start...", System.currentTimeMillis());

		Intent intent = new Intent(context, TVPlayerWebView.class);
		intent.putExtra(Constants.FROM_NOTIFICATION, Constants.FROM_NOTIFICATION);
		intent.putExtra(Constants.NAME, stationName);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);

		notification.setLatestEventInfo(context, appName, stationName, contentIntent);

		mNotificationManager.notify(NOTIFICATION_ID, notification);
	}

	public static void hideStatusBarNotification(Context context) {
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);
		mNotificationManager.cancel(NOTIFICATION_ID);
	}

	public static String getAppVersionName(Context context, Class<?> cls) {
		try {
			ComponentName comp = new ComponentName(context, cls);
			PackageInfo pinfo = context.getPackageManager().getPackageInfo(comp.getPackageName(), 0);
			return pinfo.versionName;
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			return "";
		}
	}

	public static void clearApplicationDataFiles(Context context) {

		try {
			File cache = context.getCacheDir();
			File appDir = new File(cache.getParent());
			if (appDir.exists()) {
				String[] children = appDir.list();
				for (String s : children) {
					if (!s.equals("lib")) {
						deleteDir(new File(appDir, s));
						Util.log("TAG", "*************** File /data/data/APP_PACKAGE/" + s + " DELETED ***");
					}
				}
			}
		} catch (Exception e) {
			// do nothing
		}
	}

	private static boolean deleteDir(File dir) {
		boolean result = false;

		try {
			if (dir != null) {
				if (dir.isDirectory()) {
					String[] children = dir.list();
					for (int i = 0; i < children.length; i++) {
						boolean success = deleteDir(new File(dir, children[i]));
						if (!success) {
							return false;
						}
					}
				}
				result = dir.delete();
			}
		} catch (Exception e) {
			// do nothing
		}

		return result;
	}

	public static void deleteWebViewDatabase(Context context) {
		try {
			context.deleteDatabase("webview.db");
			context.deleteDatabase("webviewCache.db");
		} catch (Exception e) {
			// http://code.google.com/p/android/issues/detail?id=7260
			// ...delete webview.db and webviewCache.db and then swallow the
			// exception...
		}
	}

	public static List<String> getStationNameList() {
		return getStationListByAttribut("name");
	}

	public static List<String> getStationUrlList() {
		return getStationListByAttribut("url");
	}

	public static List<String> getStationListByAttribut(String stationAttribute) {
		ArrayList<HashMap<String, Object>> stationList = Stations.getAllStations();
		List<String> result = new ArrayList<String>();

		for (HashMap<String, Object> station : stationList) {
			result.add("" + station.get(stationAttribute));
		}
		return result;
	}

	public static String getUrl(String stationName) {
		ArrayList<HashMap<String, Object>> stationList = Stations.getAllStations();

		for (HashMap<String, Object> station : stationList) {
			if (("" + station.get("name")).equalsIgnoreCase(stationName)) {
				return "" + station.get("url");
			}
		}
		return "";
	}

	public static void hideKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (view != null) {
			imm.hideSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	public static void showKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
	}

	public static void showLocalTVappDetails(Context context) {

		final String localTVpackageName = "com.rothconsulting.android.localtv";
		final String SCHEME = "package";
		final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";
		final String APP_PKG_NAME_22 = "pkg";
		final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";
		final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails";

		Intent intent = new Intent();
		final int apiLevel = Build.VERSION.SDK_INT;
		if (apiLevel >= 9) { // above 2.3
			intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			Uri uri = Uri.fromParts(SCHEME, localTVpackageName, null);
			intent.setData(uri);
		} else { // below 2.3
			final String appPkgName = (apiLevel == 8 ? APP_PKG_NAME_22 : APP_PKG_NAME_21);
			intent.setAction(Intent.ACTION_VIEW);
			intent.setClassName(APP_DETAILS_PACKAGE_NAME, APP_DETAILS_CLASS_NAME);
			intent.putExtra(appPkgName, localTVpackageName);
		}
		context.startActivity(intent);
	}

	public static void play(Context context, String name, String url) {

		if (Util.isNetworkAvailable(context)) {

			Util.log(TAG, "name: " + name + " / NoFlash Stations: " + Stations.getNoFlashStations());
			if (Util.isFlashInstalled(context) || Stations.getNoFlashStations().contains(name)) {
				Intent intent = new Intent(context, TVPlayerWebView.class);
				intent.putExtra(Constants.NAME, name);
				intent.putExtra(Constants.URL, url);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			} else {
				Util.showFlashAlert(context, R.string.flashNotInstalled);
			}
		} else {
			Toast.makeText(context, context.getResources().getString(R.string.internetNotConnected), Toast.LENGTH_LONG).show();
		}
	}

	public static HashMap<String, Object> getFullStation(ArrayList<HashMap<String, Object>> stationList, String searchName) {

		for (HashMap<String, Object> station : stationList) {
			if (searchName == null || ((String) station.get("name")).toUpperCase().contains(searchName.toUpperCase())) {

				return station;
			}
		}
		return null;
	}

	public static final boolean isMediaUrl(String url) {
		List<String> urlParts = new ArrayList<String>();
		Collections.addAll(urlParts, ".mp4", ".m4v", ".3gp", "rtsp:", "rtmp:", ".m3u8", "id=com.rothconsulting.android.localtv");
		for (String urlPart : urlParts) {
			if (url.contains(urlPart)) {
				return true;
			}
		}
		return false;
	}

	public static final Date today = new Date();
	// border = 25.6.2013
	public static final GregorianCalendar border = new GregorianCalendar(2013, 7, 25);

	public static boolean isBorderOver() {
		// return true;
		if (today.getTime() > border.getTimeInMillis()) {
			return true;

		} else {
			return false;
		}
	}

}