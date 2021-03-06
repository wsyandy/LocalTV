package com.rothconsulting.android.localtv;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
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
	private static final String PACKAGE_NAME_FLASH = "com.adobe.flashplayer";
	private static final String PACKAGE_NAME_SOL_HLS_PLAYER = "com.solbox.hlsplayer";

	public static void log(String tag, String message) {
		// Log.d(tag, message);
	}

	/**
	 * Android Platform 2.3.0 = Level 9
	 */
	public static boolean isPlatformBelow_2_3_0() {
		if (Build.VERSION.SDK_INT < 9) {
			return true;
		}
		return false;
	}

	/**
	 * Android Platform 2.3.3 = Level 10
	 */
	public static boolean isPlatformBelow_2_3_3() {
		if (Build.VERSION.SDK_INT < 10) {
			return true;
		}
		return false;
	}

	/**
	 * Android Platform 3.0 = Level 11
	 */
	public static boolean isPlatformBelow_3_0() {
		if (Build.VERSION.SDK_INT < 11) {
			return true;
		}
		return false;
	}

	/**
	 * Android Platform 4.0 = Level 14
	 */
	public static boolean isPlatformBelow_4_0() {
		if (Build.VERSION.SDK_INT < 14) {
			return true;
		}
		return false;
	}

	/**
	 * Android Platform 4.1.x = Level 16
	 */
	public static boolean isPlatformBelow_4_1() {
		if (Build.VERSION.SDK_INT < 16) {
			return true;
		}
		return false;
	}

	public static boolean isAppInstalled(Context context, String packageName) {
		boolean isInstalled = false;
		try {
			PackageManager pm = context.getPackageManager();
			ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
			if (ai != null)
				isInstalled = true;
		} catch (NameNotFoundException e) {
			isInstalled = false;
		}
		return isInstalled;
	}

	public static boolean isFlashInstalled(Context context) {
		return isAppInstalled(context, PACKAGE_NAME_FLASH);
	}

	public static boolean isSolHlsPlayerInstalled(Context context) {
		return isAppInstalled(context, PACKAGE_NAME_SOL_HLS_PLAYER);
	}

	public static String getVersionOfApp(Context context, String packageName) {
		String version = "?";
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pInfo = pm.getPackageInfo(packageName, 0);
			version = pInfo.versionName;
		} catch (NameNotFoundException e) {
			// do nothing
		}
		return version;
	}

	public static String getVersionOfFlash(Context context) {
		return getVersionOfApp(context, PACKAGE_NAME_FLASH);
	}

	public static String getVersionOfSolHlsPlayer(Context context) {
		return getVersionOfApp(context, PACKAGE_NAME_SOL_HLS_PLAYER);
	}

	public static void showFlashAlert(final Context context, int titleResId) {

		final Builder b = new AlertDialog.Builder(context);
		b.setCancelable(true);
		b.setTitle(context.getString(titleResId));
		String text = context.getString(R.string.flashDownloadText);
		b.setMessage(text);
		b.setNegativeButton(R.string.neinDanke, null);

		// // Ignore Play Store for: Jelly Bean or higher and CPU ARM-v6
		if (isPlatformBelow_4_1() && !Build.CPU_ABI.contains("-v6")) {
			b.setPositiveButton(R.string.googlePlay, new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {

					if (isNetworkAvailable(context)) {
						final Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FLASH_PLAYER_STORE_URL));
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
					if (isPlatformBelow_4_0()) { // < 2.x and 3.x
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

	public static void showSolPlayerAlert(final Context context) {
		showPlayerDownloadDialog(context, R.string.solHlsPlayer, R.string.solPlayerDownloadText, Constants.SOL_HLS_PLAYER_URL_GOOGLE,
				Constants.SOL_HLS_PLAYER_URL_GOOGLE_OLD);
	}

	public static void showVPlayerAlert(final Context context) {
		showPlayerDownloadDialog(context, R.string.vPlayer, R.string.vPlayerDownloadText, Constants.VPLAYER_URL_GOOGLE, null);
	}

	public static void showMxPlayerAlert(final Context context) {
		showPlayerDownloadDialog(context, R.string.mxPlayer, R.string.mxPlayerDownloadText, Constants.MX_PLAYER_URL_GOOGLE, null);
	}

	private static void showPlayerDownloadDialog(final Context context, int titleResId, int textResId, final String downloadLink, final String downloadLinkOld) {

		final Builder b = new AlertDialog.Builder(context);
		b.setCancelable(true);
		b.setTitle(context.getString(titleResId));
		String text = context.getString(textResId);
		b.setMessage(text);
		b.setNegativeButton(R.string.neinDanke, null);

		b.setNeutralButton(R.string.directDownload, new DialogInterface.OnClickListener() {
			public void onClick(final DialogInterface dialog, int which) {

				if (isNetworkAvailable(context)) {
					Intent i = null;
					String storeUrl = downloadLink;
					if (Util.isPlatformBelow_4_0() && downloadLinkOld != null) {
						storeUrl = downloadLinkOld;
					}
					i = new Intent(Intent.ACTION_VIEW, Uri.parse(storeUrl));
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(i);
				} else {
					Toast.makeText(context, context.getResources().getString(R.string.internetNotConnected), Toast.LENGTH_LONG).show();
				}
			}
		});
		b.show();
	}

	public static void showAlertDialog(final Context context, int titleResId, int messageResId) {
		final Builder b = new AlertDialog.Builder(context);
		b.setCancelable(true);
		b.setTitle(titleResId);
		String text = context.getString(messageResId);
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

	public static boolean isFlashStation(String stationName) {
		ArrayList<HashMap<String, Object>> stationList = Stations.getAllStations();

		for (HashMap<String, Object> station : stationList) {
			if (("" + station.get("name")).equalsIgnoreCase(stationName)) {
				if ((Integer) station.get(Stations.TYP) == R.drawable.flash) {
					return true;
				}
			}
		}
		return false;
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

	public static void play(Context context, String name, String url, boolean isFlashStation) {

		if (Util.isNetworkAvailable(context)) {
			Intent intent = new Intent(context, TVPlayerWebView.class);
			intent.putExtra(Stations.NAME, name);
			intent.putExtra(Stations.URL, url);
			intent.putExtra(Stations.TYP, isFlashStation);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);

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
	// GregorianCalendar(2013, 8, 10) = 10.9.2013
	public static final GregorianCalendar border = new GregorianCalendar(2013, 8, 10);

	public static boolean isBorderOver() {
		// return true;
		if (today.getTime() > border.getTimeInMillis()) {
			return true;

		} else {
			return false;
		}
	}

	public static ArrayList<HashMap<String, Object>> sortStationsByName(ArrayList<HashMap<String, Object>> stationList) {

		TreeMap<String, HashMap<String, Object>> sortedMap = new TreeMap<String, HashMap<String, Object>>(new StringComperator());
		for (HashMap<String, Object> station : stationList) {
			sortedMap.put((String) station.get("name"), station);
		}
		return new ArrayList<HashMap<String, Object>>(sortedMap.values());
	}

}