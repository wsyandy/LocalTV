package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.player);

		Bundle bundle = this.getIntent().getExtras();
		String url = bundle.getString(Constants.URL);
		Log.d(TAG, "URL=" + url);

		playInWebView(url);
	}

	private void playInWebView(String url) {

		myWebView = (WebView) findViewById(R.id.webview);
		myWebView.clearCache(Boolean.TRUE);
		myWebView.setInitialScale(90);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setPluginsEnabled(true);
		myWebView.getSettings().setAllowFileAccess(true);
		myWebView.setBackgroundColor(0);

		String theURLtoPlay = BASE_URL + url;
		if (url.startsWith("http:")) {
			theURLtoPlay = url;
		}
		myWebView.loadUrl(theURLtoPlay);
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
		if (myWebView != null) {
			myWebView.destroy();
		}
		super.onDestroy();
	}

	@Override
	public void onConfigurationChanged(Configuration _newConfig) {
		super.onConfigurationChanged(_newConfig);
		// do nothing on rotation
	}

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
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
