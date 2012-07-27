package com.rothconsulting.android.localtv;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

public class Tabs extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tabs);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_LIVE);
		spec = tabHost
				.newTabSpec(Constants.TAB_LIVE)
				.setIndicator(getString(R.string.live),
						res.getDrawable(R.drawable.tab_buttons))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_ARCHIV);
		spec = tabHost
				.newTabSpec(Constants.TAB_ARCHIV)
				.setIndicator(getString(R.string.archiv),
						res.getDrawable(R.drawable.tab_buttons))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Main.class);
		intent.setAction(Constants.TAB_ALLE);
		spec = tabHost
				.newTabSpec(Constants.TAB_ALLE)
				.setIndicator(getString(R.string.alle),
						res.getDrawable(R.drawable.tab_buttons))
				.setContent(intent);
		tabHost.addTab(spec);
		// tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 50;
		// tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 60;
		// tabHost.getTabWidget().getChildAt(2).getLayoutParams().height =
		// LayoutParams.MATCH_PARENT;

		tabHost.setCurrentTab(0);
	}

}
