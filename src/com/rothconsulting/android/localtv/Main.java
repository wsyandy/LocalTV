package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.rothconsulting.android.localtv.sqlitedb.DbUtils;

public class Main extends ListActivity {

	private final static String TAG = "Main";
	private Context context;
	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		context = this;

		// Stations stations = new Stations();
		Stations.init(context);

		String action = getIntent().getAction();
		String appName = getString(R.string.app_name);

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		ArrayList<HashMap<String, Object>> stationList = null;
		if (action.equals(Constants.TAB_ALLE)) {
			stationList = Stations.getAllStations();
			setTitle(appName + " - Alle verfügbaren Sender");
		} else if (action.equals(Constants.TAB_ARCHIV)) {
			setTitle(appName + " - Sender Archiv");
			stationList = Stations.getArchivStations();
		} else {
			setTitle(appName + " - Live Sender");
			stationList = Stations.getLiveStations();
		}
		Util.log(TAG, "Action=" + action + " / Stations=" + stationList.size());

		ListView lv = (ListView) findViewById(android.R.id.list); // getListView();
		int[] colors = { 0, Color.RED, 0 }; // red for the example
		lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		lv.setDividerHeight(1);
		lv.setTextFilterEnabled(true);

		// LayoutInflater inflater = getLayoutInflater();
		// TextView header = (TextView) inflater.inflate(R.layout.list_header,
		// lv,
		// false);
		// lv.addHeaderView(header, null, false);

		// Get the GoogleAnalytics singleton. Note that the SDK uses
		// the application context to avoid leaking the current context.
		mGaInstance = GoogleAnalytics.getInstance(this);
		// Use the GoogleAnalytics singleton to get a Tracker.
		mGaTracker = mGaInstance.getTracker(Constants.ANALYTICS_ID);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				HashMap<String, Object> station = (HashMap<String, Object>) ((SimpleAdapter) parent.getAdapter()).getItem(position);

				String stationName = "" + station.get(Stations.NAME);
				String stationUrl = "" + station.get(Stations.URL);
				int stationTypRedId = (Integer) station.get(Stations.TYP);

				boolean isFlashStation = false;
				if (stationTypRedId == R.drawable.flash) {
					isFlashStation = true;
				}

				Util.log(TAG, "name= " + stationName + ", url= " + stationUrl);
				Util.log(TAG, "stationTypRedId=" + stationTypRedId + " / R.drawable.flash=" + R.drawable.flash);

				if (isFlashStation && !Util.isFlashInstalled(context)) {
					Util.log(TAG, "isFlash");
					Util.showFlashAlert(context, R.string.flashNotInstalled);
					return;
				}

				SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
				String playerTyp = sharedPreferences.getString(Settings.KEY_INT_OR_EXT_PLAYER, context.getString(R.string.playerUseInternalPlayer));
				if (Util.isPlatformBelow_4_0()) {
					playerTyp = context.getString(R.string.playerUseSolHlsPlayer);
				}

				if (stationUrl.contains(Stations.streamFile) && Util.isPlatformBelow_4_0() && !Util.isSolHlsPlayerInstalled(context)) {
					Util.showSolPlayerAlert(context);
					return;
				} else if (playerTyp.equals(context.getString(R.string.playerUseSolHlsPlayer))) {
					if (!Util.isSolHlsPlayerInstalled(context) && stationUrl.contains(Stations.streamFile)) {
						Util.showSolPlayerAlert(context);
						return;
					}
				}

				// Google analytics
				if (mGaTracker != null) {
					mGaTracker.sendEvent("ui_action", "station_clicked", "url: " + stationUrl, 0L);
				}

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (stationUrl != null && !stationUrl.equals("")) {
					Util.log(TAG, "Playing: " + stationName + ", " + stationUrl);
					Util.play(context, stationName, stationUrl, isFlashStation);
				}
			}
		});

		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Util.log(TAG, "get onItem Click position= " + position);

				TextView textViewName = (TextView) ((LinearLayout) view).getChildAt(1); // 1 = Die zweite View (name)
				TextView textViewUrl = (TextView) ((LinearLayout) view).getChildAt(2); // 2 = Die dritte View (url)

				String stationName = "" + textViewName.getText();
				Util.log(TAG, "name= " + stationName + ", url= " + textViewUrl.getText());

				// Google analytics
				if (mGaTracker != null) {
					mGaTracker.sendEvent("ui_action", "station_add_fav", "name: " + stationName, 0L);
				}

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Toast.makeText(context, textViewName.getText() + "\n" + getString(R.string.addedToFavourites), Toast.LENGTH_LONG).show();
					DbUtils.addFavourite(context, stationName);
				}

				return true;
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, stationList, R.layout.list_item, new String[] { Stations.ICON, Stations.NAME, Stations.URL,
				Stations.TYP }, new int[] { R.id.list_icon, R.id.list_name, R.id.list_url, R.id.stream_typ });

		setListAdapter(adapter);

		AdMob ads = new AdMob();
		ads.showRemoveAds(this);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Util.clearApplicationData(this);
			Util.deleteWebViewDatabase(this);
		}
		return super.onKeyDown(keyCode, event);
	}

	// ------------------------------------------------------------
	// Menu Stuff
	// ------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, -1, 0, getResources().getString(R.string.info)).setIcon(android.R.drawable.ic_menu_info_details);
		menu.add(0, -2, 0, getResources().getString(R.string.help)).setIcon(android.R.drawable.ic_menu_help);
		if (Util.isBorderOver()) {
			menu.add(0, -3, 0, getResources().getString(R.string.settings)).setIcon(android.R.drawable.ic_menu_preferences);
		}
		menu.add(0, -4, 0, getResources().getString(R.string.ende)).setIcon(android.R.drawable.ic_menu_close_clear_cancel);
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
		case -3: //
			startActivityForResult(new Intent(this, Settings.class), Constants.FROM_SETTINGS);
			break;
		case -4: // ende
			// Util.clearApplicationData(this);
			Util.deleteWebViewDatabase(this);
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Util.log(TAG, "requestCode=" + requestCode + " / resultCode=" + resultCode + " / data=" + data);
		if (requestCode == Constants.FROM_SETTINGS && data != null && data.getBooleanExtra(Settings.FLASH_OPTION_CHANGED, false)) {
			// redraw the view
			onCreate(null);
		}
		super.onActivityResult(requestCode, resultCode, data);
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
