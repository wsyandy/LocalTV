package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		AdMob admob = new AdMob();
		admob.showRemoveAds(this);

		final TextView textViewAppVersion = (TextView) findViewById(R.id.textViewAppVersion);
		textViewAppVersion.setText("Version "
				+ Util.getAppVersionName(this, Info.class));

		final TextView website = (TextView) findViewById(R.id.textViewWebsite);
		website.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://sites.google.com/site/androiderwolke");
			}
		});

		final Button zurueckButton = (Button) findViewById(R.id.buttonZurueck);
		zurueckButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

		final TextView featureText = (TextView) findViewById(R.id.textViewFeatureEmail);
		featureText.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startEmailActivity();
			}
		});

		final TextView zattoo = (TextView) findViewById(R.id.textViewZattoo);
		zattoo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://www.zattoo.com");
			}
		});

		final TextView wilmaa = (TextView) findViewById(R.id.textViewWilmaa);
		wilmaa.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://www.wilmaa.com");
			}
		});

		final TextView teleboy = (TextView) findViewById(R.id.textViewTeleboy);
		teleboy.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://www.teleboy.ch");
			}
		});

		final TextView blick = (TextView) findViewById(R.id.textViewBlick);
		blick.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://tv.blick.ch");
			}
		});

		final TextView schoenerFernsehen = (TextView) findViewById(R.id.textViewSchoenerFernsehen);
		schoenerFernsehen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://www.schoener-fernsehen.com");
			}
		});

		final TextView nelloTv = (TextView) findViewById(R.id.textViewNelloTv);
		nelloTv.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				v.setBackgroundColor(R.color.orange);
				Util.startBrowserActivity(getApplicationContext(),
						"http://www.nello.tv");
			}
		});

	}

	private void startEmailActivity() {
		final Intent emailIntent = new Intent(
				android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
				new String[] { getString(R.string.emailAndroider) });
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "LocalTV");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
				"Hallo Koni\n\nMir fehlt folgender Sender: \n\n\n\n");
		emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(Intent.createChooser(emailIntent, "Send mail..."));
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
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
