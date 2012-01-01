package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

public class TVPlayer extends Activity {

	private final String TAG = this.getClass().getSimpleName();

	private final String BASE_URL = "http://www.rothconsulting.com/android/localtv/";
	private WebView myWebView;
	private PowerManager.WakeLock wakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.player);

		// prevent dim screen
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = pm
				.newWakeLock(PowerManager.FULL_WAKE_LOCK, "DoNotDimScreen");

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

	private void playInWebView(String name, String url) {

		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.clearCache(Boolean.TRUE);
		myWebView.setInitialScale(90);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginsEnabled(true);
		myWebView.getSettings().setAllowFileAccess(true);
		myWebView
				.getSettings()
				.setUserAgentString(
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:9.0.1) Gecko/20100101 Firefox/9.0.1");
		myWebView.setBackgroundColor(0);

		String theURLtoPlay = BASE_URL + url;
		if (url.startsWith("http:")) {
			theURLtoPlay = url;
		}
		myWebView.loadUrl(theURLtoPlay);
		Util.showStatusBarNotification(this, name);
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
		if (wakeLock != null) {
			wakeLock.release();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (wakeLock != null) {
			wakeLock.acquire();
		}
	}

	// ------------------------------------------------------------
	// Menu Stuff
	// ------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 1, this.getResources().getString(R.string.back))
				.setIcon(android.R.drawable.ic_media_rew);
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
