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
