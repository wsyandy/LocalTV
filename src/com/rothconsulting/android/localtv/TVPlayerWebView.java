package com.rothconsulting.android.localtv;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class TVPlayerWebView extends Activity {

	private final String TAG = this.getClass().getSimpleName();
	private final String stationName = "";
	private WebView myWebView = null;
	private RelativeLayout layout = null;
	private Context context;
	private TelephonyManager tm = null;
	private PhoneStateListener callStateListener;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		setContentView(R.layout.player_webview);
		myWebView = (WebView) findViewById(R.id.webview);

		// Fit site to screen
		// myWebView.getSettings().setLoadWithOverviewMode(true);
		// myWebView.getSettings().setUseWideViewPort(true);
		// myWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);

		context = this;

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			final String stationName = bundle.getString(Stations.NAME);
			final String url = bundle.getString(Stations.URL);
			Util.log(TAG, "URL=" + url);

			playInWebView(stationName, url);
		} else {
			Util.log(TAG, "bundle is null");
		}

		// Detect incoming phone call and register PhoneStateListener
		callStateListener = new CallStateListener();
		tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	@SuppressLint("NewApi")
	private void playInWebView(final String name, final String url) {

		if (!Stations.orientationPortrait().contains(name)) {
			if (Util.isPlatformBelow_2_3_0()) {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			} else {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
			}
		}
		myWebView = null;
		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.clearCache(Boolean.FALSE);
		myWebView.setInitialScale(99);

		myWebView.getSettings().setPluginState(PluginState.ON_DEMAND);
		if (Util.isPlatformBelow_4_0()) {
			myWebView.getSettings().setPluginState(PluginState.ON);
		}
		myWebView.getSettings().setJavaScriptEnabled(true);

		myWebView.getSettings().setAllowFileAccess(true);
		// avoid crash on Android 3.0, 3.1 & 3.2
		// Receiver not registered: android.widget.ZoomButtonsController crash
		if (Stations.allowZoomList().contains(name) && !(Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13)) {
			myWebView.getSettings().setBuiltInZoomControls(true);
		}

		// if (Stations.userAgentAndroid().contains(name)) {
		// myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_CHROME_MOBILE_SGS3);
		// } else {
		// myWebView.getSettings().setUserAgentString(Constants.USER_AGENT_SAFARI_DESKTOP);
		// }

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
				if (Util.isMediaUrl(url) && Util.isPlatformBelow_4_0()) {
					startPlayer(view, name, url);
				}
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

				if (Util.isMediaUrl(url) && !Util.isPlatformBelow_4_0()) {
					return startPlayer(view, name, url);
				} else {
					return super.shouldOverrideUrlLoading(view, url);
				}
			}

		});

		if (!Util.isPlatformBelow_4_1()) {
			myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
		}
		myWebView.loadUrl(theURLtoPlay);

		if (name.contains("SRF ") && !Util.isPlatformBelow_3_0()) {
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
			Toast.makeText(this, getResources().getString(R.string.pressScreenToStartSRF), Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
			Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
			if (!Connectivity.isConnectedFast(this) || Util.isPlatformBelow_2_3_3()) {
				Toast.makeText(this, getResources().getString(R.string.verbinde), Toast.LENGTH_LONG).show();
			}
		}
	}

	private boolean startPlayer(WebView view, String name, String url) {
		if (url.contains(".m3u8")) {
			Intent intent = new Intent(context, TVPlayerVideoView.class);
			intent.putExtra(Stations.NAME, name);
			intent.putExtra(Stations.URL, url);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
			if (myWebView != null && Stations.allowZoomList().contains(stationName)) {
				myWebView.removeAllViews();
				myWebView.destroy();
			}
			finish();
			return true;
		} else {
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
			// back to the list
			finish();
			return true;
		}

	}

	@Override
	public void onDetachedFromWindow() {
		Util.log(TAG, "************ onDetachedFromWindow");
		super.onDetachedFromWindow();
		if (myWebView != null) {
			myWebView.destroy();
		}
	}

	@Override
	protected void onDestroy() {
		Util.log(TAG, "************ onDestroy");
		closeTVPlayer();
		super.onDestroy();
	}

	@Override
	public void onConfigurationChanged(Configuration _newConfig) {
		super.onConfigurationChanged(_newConfig);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Util.log(TAG, "************ onKeyDown");

		if (myWebView != null) {
			// Check if the key event was the BACK key and if there's history
			if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
				myWebView.goBack();
				return false;
			} else if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
				closeTVPlayer();
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPause() {
		Util.log(TAG, "************ onPause");

		super.onPause();
	}

	@Override
	protected void onResume() {
		Util.log(TAG, "************ onResume");

		super.onResume();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	private void closeTVPlayer() {
		Util.log(TAG, "************ closeTVPlayer");

		layout = (RelativeLayout) findViewById(R.id.webPlayerLayout);
		layout.removeView(myWebView);

		if (myWebView != null && myWebView.isShown()) {

			if (!Stations.allowZoomList().contains(stationName)) {
				if (layout != null) {
					layout.removeView(myWebView);
				}
				myWebView.removeAllViews();
				myWebView.setFocusable(true);
				myWebView.clearHistory();
				// myWebView.destroy();
			} else {
				// to avoid a crash
				// http://stackoverflow.com/questions/5267639/how-to-safely-turn-webview-zooming-on-and-off-as-needed
				long timeout = ViewConfiguration.getZoomControlsTimeout();
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						if (layout != null) {
							layout.removeView(myWebView);
						}
						myWebView.removeAllViews();
						myWebView.setFocusable(true);
						myWebView.clearHistory();
						// myWebView.destroy();
					}
				}, timeout);
			}
		}
		// Unregister PhoneStateListener
		unregisterPhoneState();
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
		case -2:
			closeTVPlayer();
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
				Toast.makeText(context, getString(R.string.incomingCall), Toast.LENGTH_SHORT).show();
				// stop playing
				closeTVPlayer();
				break;
			}
		}
	}

	@Override
	public void onStart() {
		Util.log(TAG, "************ onStart");

		super.onStart();
		// Google Analytics
		EasyTracker.getInstance().activityStart(this);
	}

	@Override
	public void onStop() {
		Util.log(TAG, "************ onStop");

		super.onStop();
		// Google Analytics
		EasyTracker.getInstance().activityStop(this);
		unregisterPhoneState();
	}

	private void unregisterPhoneState() {
		Util.log(TAG, "************ unregisterPhoneState");

		if (tm != null && callStateListener != null) {
			tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
		}
	}
}
