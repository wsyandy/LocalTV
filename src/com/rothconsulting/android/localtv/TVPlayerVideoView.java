package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class TVPlayerVideoView extends Activity {

	private final String TAG = this.getClass().getSimpleName();
	private String stationName = "";
	private VideoView myVideoView = null;
	private RelativeLayout layout = null;
	private Context context;
	private TelephonyManager tm = null;
	private PhoneStateListener callStateListener;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;
	private ProgressDialog progressDialogWait;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

		context = this;

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		// Detect incoming phone call and register PhoneStateListener
		callStateListener = new CallStateListener();
		tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);

		setContentView(R.layout.player_videoview);
		layout = (RelativeLayout) findViewById(R.id.videoPlayerLayout);
		myVideoView = (VideoView) findViewById(R.id.videoview);

		// Toast.makeText(context, "Video", Toast.LENGTH_SHORT).show();

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			if (bundle.getString(Constants.FROM_NOTIFICATION) == null) {
				stationName = bundle.getString(Stations.NAME);
				String url = bundle.getString(Stations.URL);
				Util.log(TAG, "URL=" + url);

				SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
				String playerTyp = sharedPreferences.getString(Settings.KEY_INT_OR_EXT_PLAYER, context.getString(R.string.playerUseInternalPlayer));

				if (url.contains(Stations.streamFile) && Util.isPlatformBelow_4_0() && !Util.isSolHlsPlayerInstalled(context)) {
					Util.showSolPlayerAlert(context);
					return;
				} else if (playerTyp.equals(context.getString(R.string.playerUseSolHlsPlayer))) {
					if (!Util.isSolHlsPlayerInstalled(context)) {
						Util.showSolPlayerAlert(context);
					} else {
						Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
						// intent.setDataAndType(Uri.parse(url), "application/vnd.apple.mpegurl");
						intent.setDataAndType(Uri.parse(url), "application/x-mpegURL");
						startActivity(intent);
						finish();
					}
				} else if (playerTyp.equals(context.getString(R.string.playerUseOtherPlayer))) {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					intent.setDataAndType(Uri.parse(url), "video/mp4");
					startActivity(intent);
					finish();
				} else {
					playInVideoView(stationName, url);
				}
			} else {
				String stationName = bundle.getString(Stations.NAME);
				finish();
				Util.showStatusBarNotification(this, stationName);
			}
		} else {
			Util.log(TAG, "bundle is null - from intent");
		}

	}

	private void playInVideoView(final String name, final String url) {
		// String httpLiveUrl = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";
		// String httpLiveUrl = "http://apasfiisl.apa.at/ipad/orf2_q4a/orf.sdp/playlist.m3u8";
		// String httpLiveUrl = "http://webtv-aarh-9.stofa.dk:80/184_01.m3u8";
		// String httpLiveUrl = "http://rtmp.infomaniak.ch/livecast/barntele/playlist.m3u8";
		// String httpLiveUrl = "http://rtmp.infomaniak.ch/livecast/telezuri/playlist.m3u8";
		// String httpLiveUrl = "http://www.srf.ch/player/tv/videoembed?id=c4927fcf-e1a0-0001-7edd-1ef01d441651&autoplay=true";

		if (Util.isPlatformBelow_2_3_0()) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		} else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
		}

		Util.log(TAG, "name=" + name + " / url=" + url);

		myVideoView.setVideoURI(Uri.parse(url));
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();

		progressDialogWait = ProgressDialog.show(this, "Please wait ...", this.getString(R.string.verbinde), true);

		myVideoView.setOnPreparedListener(new OnPreparedListener() {
			public void onPrepared(MediaPlayer mp) {
				progressDialogWait.dismiss();
			}
		});

		myVideoView.setOnErrorListener(new OnErrorListener() {
			public boolean onError(MediaPlayer mp, int what, int extra) {
				Toast.makeText(context, "Cannot load...", Toast.LENGTH_LONG).show();
				progressDialogWait.dismiss();
				Util.showAlertDialog(context, R.string.info, R.string.cannotStartTV);
				return false;
			}
		});
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
		unregisterPhoneState();
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
		unregisterPhoneState();

		if (layout != null) {
			layout.removeView(myVideoView);
		}
		myVideoView.setFocusable(true);

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
		unregisterPhoneState();
	}

	private void unregisterPhoneState() {
		// Unregister PhoneStateListener
		if (tm != null) {
			tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
		}
	}
}
