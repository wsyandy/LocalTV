package com.rothconsulting.android.localtv;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

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
				Util.log(TAG, "URL=" + url);

				playInWebView(name, url);
			} else {
				String stationName = bundle.getString(Constants.NAME);
				finish();
				Util.showStatusBarNotification(this, stationName);
			}
		} else {
			Util.log(TAG, "bundle is null");
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
		if (Stations.noFlash().contains(name) && Build.VERSION.SDK_INT >= 11) {
			myWebView.getSettings().setPluginState(PluginState.OFF);
		}

		myWebView.getSettings().setAllowFileAccess(true);
		// avoid crash on Android 3.0, 3.1 & 3.2
		// Receiver not registered: android.widget.ZoomButtonsController crash
		if (Stations.allowZoom().contains(name) && !(Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13)) {
			myWebView.getSettings().setBuiltInZoomControls(true);
		}

		if (Stations.userAgentAndroid().contains(name)) {
			myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_CHROME_MOBILE_SGS3);
		} else {
			myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_SAFARI_DESKTOP);
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
			Util.log(TAG, "theURLtoPlay=" + theURLtoPlay);
		}

		final Activity activity = this;
		myWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int progress) {
				// Activities and WebViews measure progress with different scales.
				// The progress meter will automatically disappear when we reach 100%

				activity.setTitle(" Loading...");
				activity.setProgress(progress * 100);

				if (progress == 100) {
					getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_OFF);
				}
			}
		});

		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				Util.log(TAG, "WebViewClient ErrorCode=" + errorCode);
				Toast.makeText(context, "Oh no! " + description, Toast.LENGTH_LONG).show();
				finish();
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				activity.setTitle(" Loading...");
				View title = getWindow().findViewById(android.R.id.title);
				View titleBar = (View) title.getParent();
				titleBar.setBackgroundColor(Color.BLACK);
				titleBar.setVisibility(View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				activity.setTitle("");
				View title = getWindow().findViewById(android.R.id.title);
				View titleBar = (View) title.getParent();
				titleBar.setVisibility(View.GONE);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Util.log(TAG, "****** URL=" + url);
				if (Util.isMediaUrl(url)) {

					Toast.makeText(context, getResources().getString(R.string.openExternalPlayer), Toast.LENGTH_LONG).show();
					if (url.contains("id=com.rothconsulting.android.localtv")) {
						url = "market://details?id=com.rothconsulting.android.localtv";
					}
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					if (url.contains(".mp4") || url.contains("rtmp:")) {
						Util.log(TAG, "******* setType( video/mp4 );");
						intent.setType("video/mp4");
					}
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					view.getContext().startActivity(intent);
					Util.hideStatusBarNotification(context);
					// back to the list
					finish();
					return true;
				} else {
					return super.shouldOverrideUrlLoading(view, url);
				}
			}

		});

		if (Build.VERSION.SDK_INT >= 16) {
			myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
		}
		myWebView.loadUrl(theURLtoPlay);

		Util.showStatusBarNotification(this, name);

		if (Stations.getNotLiveStations().contains(name)) {
			Toast.makeText(this, getResources().getString(R.string.notLive), Toast.LENGTH_LONG).show();
		}
		if (Stations.noFlash().contains(name) && name.contains("SRF ") && Build.VERSION.SDK_INT >= 11) {
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
		} else if (!Stations.getNotLiveStations().contains(name)) {
			Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
			if (!Connectivity.isConnectedFast(this) || Build.VERSION.SDK_INT < 10) {
				Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
			}
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

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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
				Toast.makeText(context, getString(R.string.incomingCall) + " \n" + incomingNumber, Toast.LENGTH_SHORT).show();
				// stop playing
				closeTVPlayer(true);
				break;
			}
		}
	}
}
