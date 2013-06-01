package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		final Context context = this;

		final Button appInfoButton = (Button) findViewById(R.id.buttonAppInfo);
		appInfoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Util.showLocalTVappDetails(context);
			}
		});
		final Button zurueckButton = (Button) findViewById(R.id.buttonZurueck);
		zurueckButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

		final TextView flashTitle = (TextView) findViewById(R.id.textViewFlashTitle);
		final Button playStoreButton = (Button) findViewById(R.id.buttonAdobeFlashPlayer);
		if (Util.isBorderOver()) {
			playStoreButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
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
}
