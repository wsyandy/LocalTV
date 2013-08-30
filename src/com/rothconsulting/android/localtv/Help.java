package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class Help extends Activity {

	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		final Context context = this;

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		final Button appInfoButton = (Button) findViewById(R.id.buttonAppInfo);
		appInfoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Google analytics
				if (mGaTracker != null) {
					mGaTracker.sendEvent("ui_action", "buttonAppInfo", "buttonAppInfo clicked", 0L);
				}
				Util.showLocalTVappDetails(context);
			}
		});
		final Button zurueckButton = (Button) findViewById(R.id.buttonZurueck);
		zurueckButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Google analytics
				if (mGaTracker != null) {
					mGaTracker.sendEvent("ui_action", "buttonZurueck", "buttonZurueck clicked", 0L);
				}
				finish();
			}
		});

		final TextView flashTitle = (TextView) findViewById(R.id.textViewFlashTitle);
		final Button playStoreButton = (Button) findViewById(R.id.buttonAdobeFlashPlayer);
		if (Util.isBorderOver()) {
			playStoreButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// Google analytics
					if (mGaTracker != null) {
						mGaTracker.sendEvent("ui_action", "buttonAdobeFlashPlayer", "buttonAdobeFlashPlayer clicked", 0L);
					}
					Util.showFlashAlert(context, R.string.flash);
				}
			});
		} else {
			flashTitle.setVisibility(View.INVISIBLE);
			playStoreButton.setVisibility(View.INVISIBLE);
		}
		AdMob ads = new AdMob();
		ads.showRemoveAds(this);

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
