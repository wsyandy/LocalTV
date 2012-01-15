package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class TVPlayer extends Activity {

	private final String TAG = this.getClass().getSimpleName();

	private WebView myWebView;

	// private PowerManager.WakeLock wakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().requestFeature(Window.FEATURE_PROGRESS);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.player);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		// prevent dim screen
		// PowerManager pm = (PowerManager)
		// getSystemService(Context.POWER_SERVICE);
		// wakeLock = pm
		// .newWakeLock(PowerManager.FULL_WAKE_LOCK, "DoNotDimScreen");

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			if (bundle.getString(Constants.FROM_NOTIFICATION) == null) {
				String name = bundle.getString(Constants.NAME);
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
	}

	private void playInWebView(final String name, final String url) {

		if (!Stations.orientationPortrait().contains(name)) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}

		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.clearCache(Boolean.TRUE);
		myWebView.setInitialScale(80);
		// avoid crash on Android 3.0, 3.1 & 3.2
		// Receiver not registered: android.widget.ZoomButtonsController
		// crash
		if (!(Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13)) {
			myWebView.getSettings().setBuiltInZoomControls(true);
		}
		myWebView.getSettings().setSupportZoom(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginsEnabled(true);

		if (!Stations.userAgentAndroid().contains(name)) {
			myWebView.getSettings().setUserAgentString(
					Constants.USER_AGENT_FIREFOX);
		}
		if (!Stations.noTransparentBackground().contains(name)) {
			myWebView.setBackgroundColor(0);
		}

		String theURLtoPlay = Constants.BASE_URL + url;
		if (url.startsWith("http")) { // http or https
			theURLtoPlay = url;
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
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(activity, "Oh no! " + description,
						Toast.LENGTH_LONG).show();
			}
		});

		myWebView.loadUrl(theURLtoPlay);

		Util.showStatusBarNotification(this, name);

		if (!Stations.noFullscreenMessage().contains(name)) {
			for (int i = 0; i < 2; i++) { // langer Toast (2x)
				Toast.makeText(this,
						getResources().getString(R.string.vollbild),
						Toast.LENGTH_LONG).show();
			}
		}
		if (Stations.notLive().contains(name)) {
			for (int i = 0; i < 2; i++) { // langer Toast (2x)
				Toast.makeText(this,
						getResources().getString(R.string.notLive),
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void playInVideoView(String url, boolean autoplay) {
		// get current window information, and set format, set it up
		// differently, if you need some special effects
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		// the VideoView will hold the video
		VideoView videoHolder = new VideoView(this);
		// MediaController is the ui control howering above the video (just like
		// in the default youtube player).
		videoHolder.setMediaController(new MediaController(this));
		// assing a video file to the video holder
		videoHolder
				.setVideoURI(Uri
						.parse("http://rtmp.infomaniak.ch/livecast/barntele/playlist.m3u8"));
		// get focus, before playing the video.
		videoHolder.requestFocus();
		if (autoplay) {
			videoHolder.start();
		}
	}

	@Override
	protected void onDestroy() {
		closeTVPlayer(false);
		super.onDestroy();
	}

	@Override
	public void onConfigurationChanged(Configuration _newConfig) {
		super.onConfigurationChanged(_newConfig);
		// do nothing on rotation
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			closeTVPlayer(true);
		}
		return super.onKeyDown(keyCode, event);
	}

	private void closeTVPlayer(boolean removeStatusBar) {
		if (myWebView != null) {
			myWebView.destroy();
		}
		if (removeStatusBar) {
			Util.hideStatusBarNotification(this);
		}
		finish();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// if (wakeLock != null) {
		// wakeLock.release();
		// }
	}

	@Override
	protected void onResume() {
		super.onResume();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// if (wakeLock != null) {
		// wakeLock.acquire();
		// }
	}

	// ------------------------------------------------------------
	// Menu Stuff
	// ------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 1, getResources().getString(R.string.back)).setIcon(
				android.R.drawable.ic_media_rew);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case -1:
			closeTVPlayer(true);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
