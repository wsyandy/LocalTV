package com.rothconsulting.android.localtv;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class Tabs extends TabActivity {

	Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tabs);

		context = this;
		Resources res = getResources(); // Resource object to get Drawables
		final TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_LIVE);
		spec = tabHost.newTabSpec(Constants.TAB_LIVE).setIndicator(getString(R.string.live), res.getDrawable(R.drawable.tab_tv_button)).setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_ARCHIV);
		spec = tabHost.newTabSpec(Constants.TAB_ARCHIV).setIndicator(getString(R.string.archiv), res.getDrawable(R.drawable.tab_tv_button)).setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_ALLE);
		spec = tabHost.newTabSpec(Constants.TAB_ALLE).setIndicator(getString(R.string.alle), res.getDrawable(R.drawable.tab_tv_button)).setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Favourites.class);
		intent.setAction(Constants.TAB_FAVORIT);
		spec = tabHost.newTabSpec(Constants.TAB_FAVORIT).setIndicator(getString(R.string.favourites), res.getDrawable(R.drawable.tab_favourites_button))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Search.class);
		intent.setAction(Constants.TAB_SEARCH);
		spec = tabHost.newTabSpec(Constants.TAB_SEARCH).setIndicator(getString(R.string.search), res.getDrawable(R.drawable.tab_search_button))
				.setContent(intent);
		tabHost.addTab(spec);

		// tabHost.getTabWidget().getChildAt(0)
		// .setBackgroundResource(R.color.blue_facebook);
		// tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 60;
		// tabHost.getTabWidget().getChildAt(2).getLayoutParams().height =
		// LayoutParams.MATCH_PARENT;

		tabHost.setCurrentTab(0);
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			public void onTabChanged(String tabId) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				if (Constants.TAB_SEARCH.equalsIgnoreCase(tabId)) {
					imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
				} else {
					imm.hideSoftInputFromWindow(tabHost.getApplicationWindowToken(), 0);
				}
			}
		});
	}

}
