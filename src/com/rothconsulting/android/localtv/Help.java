package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

		final Button playStoreButton = (Button) findViewById(R.id.buttonAdobeFlashPlayer);
		playStoreButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Util.showFlashAlert(context, R.string.flash);
			}
		});

		AdMob ads = new AdMob();
		ads.showRemoveAds(this);

	}
}
