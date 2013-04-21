package com.rothconsulting.android.localtv;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TVPlayer extends Activity {

	private final String TAG = this.getClass().getSimpleName();
	private String stationName = "";
	private WebView myWebView = null;
	private Context context;
	private TelephonyManager tm = null;
	private PhoneStateListener callStateListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		getWindow().requestFeature(Window.FEATURE_PROGRESS);

		setContentView(R.layout.player);
		myWebView = (WebView) findViewById(R.id.webview);

		context = this;

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			if (bundle.getString(Constants.FROM_NOTIFICATION) == null) {
				String name = bundle.getString(Constants.NAME);
				stationName = name;
				String url = bundle.getString(Constants.URL);
				Log.d(TAG, "URL=" + url);

				playInWebView(name, url);
			} else {
				String stationName = bundle.getString(Constants.NAME);
				finish();
				Util.showStatusBarNotification(this, stationName);
			}
		} else {
			Log.d(TAG, "bundle is null");
		}

		// Detect incoming phone call and register PhoneStateListener
		callStateListener = new CallStateListener();
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	private void playInWebView(final String name, final String url) {

		if (!Stations.orientationPortrait().contains(name)) {
			if (Build.VERSION.SDK_INT < 9) {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			} else {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
			}
		}
		myWebView = null;
		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.clearCache(Boolean.FALSE);
		myWebView.setInitialScale(99);

		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginState(PluginState.ON);
		myWebView.getSettings().setAllowFileAccess(true);
		// avoid crash on Android 3.0, 3.1 & 3.2
		// Receiver not registered: android.widget.ZoomButtonsController crash
		if (Stations.allowZoom().contains(name) && !(Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13)) {
			myWebView.getSettings().setBuiltInZoomControls(true);
		}

		if (Stations.userAgentAndroid().contains(name)) {
			myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_CHROME_MOBILE_SGS3);
		} else {
			myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_FIREFOX);
		}

		if (!Stations.noTransparentBackground().contains(name)) {
			myWebView.setBackgroundColor(0);
		}

		String theURLtoPlay = Constants.BASE_URL + url;
		if (url.startsWith("http")) { // http or https
			theURLtoPlay = url;
		}

		if (theURLtoPlay.endsWith(".php")) {
			Display display = getWindowManager().getDefaultDisplay();
			int width = display.getWidth();
			int height = display.getHeight();
			theURLtoPlay += "?width=" + width + "&height=" + height;
			Log.d(TAG, "theURLtoPlay=" + theURLtoPlay);
		}

		final Activity activity = this;
		myWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int progress) {
				// Activities and WebViews measure progress with different
				// scales.
				// The progress meter will automatically disappear when we reach
				// 100%
				activity.setProgress(progress * 1000);
			}
		});

		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				Log.d(TAG, "WebViewClient ErrorCode=" + errorCode);
				Toast.makeText(context, "Oh no! " + description, Toast.LENGTH_LONG).show();
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Log.d(TAG, "****** URL=" + url);
				if (url.endsWith(".mp4") || url.endsWith(".3gp") || url.contains("rtsp:") || url.contains("id=com.rothconsulting.android.localtv")) {

					if (url.contains("id=com.rothconsulting.android.localtv")) {
						url = "market://details?id=com.rothconsulting.android.localtv";
					}
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					if (url.endsWith(".mp4")) {
						intent.setDataAndType(Uri.parse(url), "video/mp4");
					}
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					view.getContext().startActivity(intent);
					return true;
				} else {
					return super.shouldOverrideUrlLoading(view, url);
				}
			}

		});

		myWebView.loadUrl(theURLtoPlay);

		Util.showStatusBarNotification(this, name);

		if (Stations.getNotLiveStations().contains(name)) {
			Toast.makeText(this, getResources().getString(R.string.notLive), Toast.LENGTH_LONG).show();
		}
		Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
		if (!Connectivity.isConnectedFast(this) || Build.VERSION.SDK_INT < 10) {
			Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
		}
	}

	// public void playInVideoView(String url, boolean autoplay) {
	// // get current window information, and set format, set it up
	// // differently, if you need some special effects
	// getWindow().setFormat(PixelFormat.TRANSLUCENT);
	// // the VideoView will hold the video
	// VideoView videoHolder = new VideoView(this);
	// // MediaController is the ui control howering above the video (just like
	// // in the default youtube player).
	// videoHolder.setMediaController(new MediaController(this));
	// // assing a video file to the video holder
	// videoHolder
	// .setVideoURI(Uri
	// .parse("http://rtmp.infomaniak.ch/livecast/barntele/playlist.m3u8"));
	// // get focus, before playing the video.
	// videoHolder.requestFocus();
	// if (autoplay) {
	// videoHolder.start();
	// }
	// }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		closeTVPlayer(false);
	}

	@Override
	public void onConfigurationChanged(Configuration _newConfig) {
		super.onConfigurationChanged(_newConfig);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the BACK key and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return false;
		} else if (keyCode == KeyEvent.KEYCODE_BACK) {
			LinearLayout layout = (LinearLayout) findViewById(R.id.playerLayout);
			layout.removeView(myWebView);
			myWebView.removeAllViews();
			closeTVPlayer(true);
		}
		return super.onKeyDown(keyCode, event);
	}

	private void closeTVPlayer(boolean removeStatusBar) {
		if (myWebView != null) {

			if (!Stations.allowZoom().contains(stationName)) {
				myWebView.removeAllViews();
				myWebView.destroy();
			} else {
				// to avoid a crash
				// http://stackoverflow.com/questions/5267639/how-to-safely-turn-webview-zooming-on-and-off-as-needed
				long timeout = ViewConfiguration.getZoomControlsTimeout();
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						myWebView.removeAllViews();
						myWebView.destroy();
					}
				}, timeout);
			}
		}
		if (removeStatusBar) {
			Util.hideStatusBarNotification(this);
		}
		// Unregister PhoneStateListener
		if (tm != null) {
			tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
		}
		// Util.clearApplicationData(this);
		finish();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	// ------------------------------------------------------------
	// Menu Stuff
	// ------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 0, getResources().getString(R.string.help)).setIcon(android.R.drawable.ic_menu_help);
		menu.add(0, -2, 0, getResources().getString(R.string.back)).setIcon(android.R.drawable.ic_media_rew);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case -1:
			startActivity(new Intent(this, Help.class));
			break;
		case -2: //
			closeTVPlayer(true);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Listener to detect incoming calls.
	 */
	private class CallStateListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
				// called when someone is ringing to this phone
				Toast.makeText(context, getString(R.string.incomingCall) + " \n" + incomingNumber, Toast.LENGTH_LONG).show();
				// stop playing
				closeTVPlayer(true);
				break;
			}
		}
	}
}
