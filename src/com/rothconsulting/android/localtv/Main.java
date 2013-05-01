package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.Log;
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

import com.rothconsulting.android.localtv.sqlitedb.DbUtils;

public class Main extends ListActivity {

	private final static String TAG = "Main";
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		context = this;
		Stations stations = new Stations();
		stations.init(context);

		String action = getIntent().getAction();
		String appName = getString(R.string.app_name);

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		Util.hideStatusBarNotification(this);

		ArrayList<HashMap<String, Object>> stationList = null;
		if (action.equals(Constants.TAB_ALLE)) {
			stationList = Stations.getAllStations();
			setTitle(appName + " - Alle verfügbaren Sender");
		} else if (action.equals(Constants.TAB_ARCHIV)) {
			setTitle(appName + " - Sender Archiv");
			stationList = stations.getArchivStations();
		} else {
			setTitle(appName + " - Live Sender");
			stationList = stations.getLiveStations();
		}
		Log.d(TAG, "Action=" + action + " / Stations=" + stationList.size());

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

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, show a toast with the TextView text
				TextView textViewName = (TextView) ((LinearLayout) view).getChildAt(1); // 1 = Die zweite View (name)
				TextView textViewUrl = (TextView) ((LinearLayout) view).getChildAt(2); // 2 = Die dritte View (url)

				Log.d(TAG, "name= " + textViewName.getText() + ", url= " + textViewUrl.getText());

				// Länder Titel haben keine URL und man kann sie nicht
				// klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Log.d(TAG, "Playing: " + textViewName.getText() + ", " + textViewUrl.getText());
					Util.play(context, "" + textViewName.getText(), "" + textViewUrl.getText());
				}
			}
		});

		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Log.e("MyApp", "get onItem Click position= " + position);

				TextView textViewName = (TextView) ((LinearLayout) view).getChildAt(1); // 1 = Die zweite View (name)
				TextView textViewUrl = (TextView) ((LinearLayout) view).getChildAt(2); // 2 = Die dritte View (url)

				String stationName = "" + textViewName.getText();
				Log.d(TAG, "name= " + stationName + ", url= " + textViewUrl.getText());

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Toast.makeText(context, textViewName.getText() + "\n" + getString(R.string.addedToFavourites), Toast.LENGTH_LONG).show();
					DbUtils.addFavourite(context, stationName);
					Favourites.updateFavList();
				}

				return true;
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, stationList, R.layout.list_item, new String[] { "icon", "name", "url" }, new int[] { R.id.list_icon,
				R.id.list_name, R.id.list_url });

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

}
