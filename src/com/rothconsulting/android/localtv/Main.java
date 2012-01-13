package com.rothconsulting.android.localtv;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends ListActivity {

	private final String TAG = this.getClass().getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SimpleAdapter adapter = new SimpleAdapter(this, Stations.getStations(),
				R.layout.list_item, new String[] { "icon", "name", "url" },
				new int[] { R.id.list_icon, R.id.list_name, R.id.list_url });

		setListAdapter(adapter);

		ListView lv = (ListView) findViewById(android.R.id.list); // getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				TextView textViewName = (TextView) ((LinearLayout) view)
						.getChildAt(1); // 1 = Die zweite View (name)
				TextView textViewUrl = (TextView) ((LinearLayout) view)
						.getChildAt(2); // 2 = Die dritte View (url)

				Log.d(TAG, "name= " + textViewName.getText() + ", url= "
						+ textViewUrl.getText());

				// Länder Titel haben keine URL und man kann sie nicht klicken.
				if (textViewUrl != null && !textViewUrl.getText().equals("")) {
					Log.d(TAG, "Playing: " + textViewName.getText() + ", "
							+ textViewUrl.getText());
					play(getApplicationContext(), "" + textViewName.getText(),
							"" + textViewUrl.getText());
				}
			}
		});

		AdMob ads = new AdMob();
		ads.showRemoveAds(this);
	}

	private void play(Context context, String name, String url) {

		if (Util.isFlashInstalled(this)) {

			if (Util.isNetworkAvailable(this)) {
				Intent intent = new Intent(context, TVPlayer.class);
				intent.putExtra(Constants.NAME, name);
				intent.putExtra(Constants.URL, url);
				startActivity(intent);
			} else {
				Toast.makeText(
						this,
						getResources().getString(R.string.internetNotConnected),
						Toast.LENGTH_LONG).show();
			}
		} else {
			Util.showFlashAlert(this);
			// Toast.makeText(this,
			// getResources().getString(R.string.flashNotInstalled),
			// Toast.LENGTH_LONG).show();
		}

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
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
