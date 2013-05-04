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

public class Favourites extends ListActivity {

	private final static String TAG = "Favourites";
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favourites);

		context = this;
		// Stations stations = new Stations();
		// stations.init(context);

		String action = getIntent().getAction();
		String appName = getString(R.string.app_name);

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		Util.hideStatusBarNotification(this);

		Util.log(TAG, "context=" + context);
		Util.log(TAG, "this=" + this);
		// ArrayList<HashMap<String, Object>> stationList = DbUtils.getFavListFromDb(context);

		setTitle(appName + " - Favoriten Sender");
		// Util.log(TAG, "Action=" + action + " / Stations=" + stationList.size());

		ListView lv = (ListView) findViewById(android.R.id.list); // getListView();
		int[] colors = { 0, Color.RED, 0 }; // red for the example
		lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		lv.setDividerHeight(1);
		lv.setTextFilterEnabled(true);

		// LayoutInflater inflater = getLayoutInflater();
		// TextView header = (TextView)
		// inflater.inflate(R.layout.list_header,
		// lv,
		// false);
		// lv.addHeaderView(header, null, false);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, show a toast with the TextView text
				TextView textViewName = (TextView) ((LinearLayout) view).getChildAt(1); // 1 = Die zweite View (name)
				TextView textViewUrl = (TextView) ((LinearLayout) view).getChildAt(2); // 2 = Die dritte View (url)

				Util.log(TAG, "name= " + textViewName.getText() + ", url= " + textViewUrl.getText());

				// Länder Titel haben keine URL und man kann sie nicht
				// klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Util.log(TAG, "Playing: " + textViewName.getText() + ", " + textViewUrl.getText());
					Util.play(context, "" + textViewName.getText(), "" + textViewUrl.getText());
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

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Toast.makeText(context, textViewName.getText() + "\n" + getString(R.string.removedFromFavourite), Toast.LENGTH_LONG).show();
					DbUtils.removeFavourite(context, stationName);
					updateFavList();
				}
				return true;
			}
		});

		// SimpleAdapter adapter = new SimpleAdapter(this, stationList, R.layout.list_item, new String[] { "icon", "name", "url" }, new int[] { R.id.list_icon,
		// R.id.list_name, R.id.list_url });
		// setListAdapter(adapter);

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

	@Override
	protected void onStop() {
		super.onStop();
		Util.log(TAG, "*********** onStop");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Util.log(TAG, "*********** onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Util.log(TAG, "*********** onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Util.log(TAG, "*********** onResume");
		updateFavList();
	}

	private void updateFavList() {
		Util.log(TAG, "context in update=" + context);
		ArrayList<HashMap<String, Object>> stationList = DbUtils.getFavListFromDb(context);
		Util.log(TAG, "Stations=" + stationList.size());

		SimpleAdapter adapter = new SimpleAdapter(context, stationList, R.layout.list_item, new String[] { "icon", "name", "url" }, new int[] { R.id.list_icon,
				R.id.list_name, R.id.list_url });

		((ListActivity) context).setListAdapter(adapter);

		if (stationList == null || stationList.size() == 0) {
			Util.showEmptyFavAlertDialog(context);
		}

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
