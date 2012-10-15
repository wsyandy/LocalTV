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

public class Search extends Activity {

	static final String TAG = "Search";
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		context = this;
		TextView searchField = (TextView) findViewById(R.id.autocomplete);
		searchField.setText("");
		prepareSearch();
		AdMob admob = new AdMob();
		admob.showRemoveAds(this);
	}

	private void prepareSearch() {
		final SearchAutoCompleteTextView myAutoComplete = (SearchAutoCompleteTextView) findViewById(R.id.autocomplete);
		// myAutoComplete.setText("");

		myAutoComplete.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(
					AdapterView<?> listPopupWindow_DropDownListView,
					View textView, int arg2, long arg3) {

				String station = "" + ((TextView) textView).getText();

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (station.equalsIgnoreCase(Stations.LAND_DEUTSCHLAND)
						|| station
								.equalsIgnoreCase(Stations.LAND_DIVERSE_LAENDER)
						|| station.equalsIgnoreCase(Stations.LAND_SCHWEIZ)) {
					// do nothing
				} else {
					Util.hideKeyboard(context, textView);
					Main.play(getApplicationContext(), station,
							Util.getUrl(station));
				}
			}
		});

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line);

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
		menu.add(0, -1, 0, getResources().getString(R.string.info)).setIcon(
				android.R.drawable.ic_menu_info_details);
		menu.add(0, -2, 0, getResources().getString(R.string.ende)).setIcon(
				android.R.drawable.ic_menu_close_clear_cancel);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case -1: // info
			startActivity(new Intent(this, Info.class));
			break;
		case -2: // ende
			Util.clearApplicationData(this);
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
