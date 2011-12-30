package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class LocalTV extends Activity {

	private final String TAG = this.getClass().getSimpleName();

	private final String BASEL_URL = "http://www.rothconsulting.com/android/localtv/";
	private final String TELE_BASEL = "telebasel.html";
	private final String TELE_BAERN = "telebaern.html";
	private final String TELE_M1 = "telem1.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.main);

		AdMob ads = new AdMob();
		ads.showRemoveAds(this);

	}

	private void play(String sender) {

		boolean flashInstalled = false;
		try {
			PackageManager pm = getPackageManager();
			ApplicationInfo ai = pm.getApplicationInfo("com.adobe.flashplayer",
					0);
			if (ai != null)
				flashInstalled = true;
		} catch (NameNotFoundException e) {
			flashInstalled = false;
		}

		if (flashInstalled) {
			WebView myWebView = (WebView) findViewById(R.id.webview);
			myWebView.clearCache(Boolean.TRUE);
			myWebView.setInitialScale(90);
			myWebView.getSettings().setBuiltInZoomControls(true);
			myWebView.getSettings().setJavaScriptEnabled(true);
			myWebView.getSettings().setPluginsEnabled(true);
			myWebView.getSettings().setAllowFileAccess(true);
			myWebView.setBackgroundColor(0);

			myWebView.loadUrl(BASEL_URL + sender);

		} else {
			Toast.makeText(
					this,
					"Kann TV nicht starten.\nAdobe Flash ist nicht installiert!!",
					Toast.LENGTH_LONG).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 0, this.getResources().getString(R.string.teleBaern))
				.setIcon(android.R.drawable.ic_menu_camera);
		menu.add(0, -2, 1, this.getResources().getString(R.string.teleBasel))
				.setIcon(android.R.drawable.ic_menu_camera);
		menu.add(0, -3, 2, this.getResources().getString(R.string.teleM1))
				.setIcon(android.R.drawable.ic_menu_camera);
		menu.add(0, -4, 3, this.getResources().getString(R.string.ende))
				.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case -1:
			this.play(TELE_BAERN);
			break;
		case -2:
			this.play(TELE_BASEL);
			break;
		case -3:
			this.play(TELE_M1);
			break;
		case -4:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
