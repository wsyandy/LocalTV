package com.rothconsulting.android.localtv;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;

public class Search extends Activity {

	static final String TAG = "Search";
	private Context context;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		context = this;
		TextView searchField = (TextView) findViewById(R.id.autocomplete);
		searchField.setText("");

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		prepareSearch();
		AdMob ads = new AdMob();
		ads.showRemoveAds(this);

	}

	private void prepareSearch() {
		final SearchAutoCompleteTextView myAutoComplete = (SearchAutoCompleteTextView) findViewById(R.id.autocomplete);
		// myAutoComplete.setText("");

		myAutoComplete.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> listPopupWindow_DropDownListView, View textView, int arg2, long arg3) {

				String station = "";

				if (textView != null) {
					station += ((TextView) textView).getText();
				}
				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (!Stations.titles(context).contains(station)) {
					Util.hideKeyboard(context, textView);
					Util.play(context, station, Util.getUrl(station), Util.isFlashStation(station));
				} // else do nothing
			}
		});

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);

		List<String> stationNameList = Util.getStationNameList();
		for (String stationName : stationNameList) {
			adapter.add(stationName);
		}
		myAutoComplete.setAdapter(adapter);
		myAutoComplete.requestFocus();
	}

	// ------------------------------------------------------------
	// Menu Stuff
	// ------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 0, getResources().getString(R.string.info)).setIcon(android.R.drawable.ic_menu_info_details);
		menu.add(0, -2, 0, getResources().getString(R.string.help)).setIcon(android.R.drawable.ic_menu_help);
		menu.add(0, -3, 0, getResources().getString(R.string.ende)).setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case -1: // info
			startActivity(new Intent(this, Info.class));
			break;
		case -2: //
			startActivity(new Intent(this, Help.class));
			break;
		case -3: // ende
			// Util.clearApplicationData(this);
			Util.deleteWebViewDatabase(this);
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
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
