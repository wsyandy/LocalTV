package com.rothconsulting.android.localtv;

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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class TVPlayerVideoView extends Activity {

	private final String TAG = this.getClass().getSimpleName();
	private String stationName = "";
	private VideoView myVideoView = null;
	private Context context;
	private TelephonyManager tm = null;
	private PhoneStateListener callStateListener;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		setContentView(R.layout.player_videoview);
		myVideoView = (VideoView) findViewById(R.id.videoview);

		context = this;
		Toast.makeText(context, "Video Start...", Toast.LENGTH_SHORT).show();

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			if (bundle.getString(Constants.FROM_NOTIFICATION) == null) {
				String name = bundle.getString(Constants.NAME);
				stationName = name;
				String url = bundle.getString(Constants.URL);
				Util.log(TAG, "URL=" + url);

				playInVideoView(name, url);
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

	private void playInVideoView(final String name, final String url) {
		// String httpLiveUrl = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";
		// String httpLiveUrl = "http://apasfiisl.apa.at/ipad/orf2_q4a/orf.sdp/playlist.m3u8";
		// String httpLiveUrl = "http://webtv-aarh-9.stofa.dk:80/184_01.m3u8";
		// String httpLiveUrl = "http://rtmp.infomaniak.ch/livecast/barntele/playlist.m3u8";
		// String httpLiveUrl = "http://rtmp.infomaniak.ch/livecast/telezuri/playlist.m3u8";
		// String httpLiveUrl = "http://www.srf.ch/player/tv/videoembed?id=c4927fcf-e1a0-0001-7edd-1ef01d441651&autoplay=true";

		if (Build.VERSION.SDK_INT < 9) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		} else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
		}

		Util.log(TAG, "name=" + name + " / url=" + url);

		myVideoView.setVideoURI(Uri.parse(url));
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		closeTVPlayer(false);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
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
				Toast.makeText(context, getString(R.string.incomingCall), Toast.LENGTH_SHORT).show();
				// stop playing
				closeTVPlayer(true);
				break;
			}
		}
	}

	@Override
	public void onStart() {
		super.onStart();
		// Google Analytics
		EasyTracker.getInstance().activityStart(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		// Google Analytics
		EasyTracker.getInstance().activityStop(this);
	}

}
