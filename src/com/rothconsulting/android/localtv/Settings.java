package com.rothconsulting.android.localtv;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Settings extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	private static final String KEY_PLAYER_USE_INTERNAL = "player_type";

	private CheckBoxPreference mCheckBoxPreferenceOverview;
	private SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		addPreferencesFromResource(R.xml.preferences);

		// Get a reference to the preferences
		mCheckBoxPreferenceOverview = (CheckBoxPreference) getPreferenceScreen().findPreference(KEY_PLAYER_USE_INTERNAL);
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		AdMob admob = new AdMob();
		admob.showRemoveAds(this);
	}

	@Override
	protected void onResume() {
		super.onResume();

		// Setup the initial values
		mCheckBoxPreferenceOverview.setSummary(sharedPreferences.getBoolean(KEY_PLAYER_USE_INTERNAL, false) ? getString(R.string.playerUseInternalPlayer)
				: getString(R.string.playerUseExternalPlayer));

		// Set up a listener whenever a key changes
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Unregister the listener whenever a key changes
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		// Let's do something a preference value changes
		if (key.equals(KEY_PLAYER_USE_INTERNAL)) {
			mCheckBoxPreferenceOverview.setSummary(sharedPreferences.getBoolean(key, false) ? getString(R.string.playerUseInternalPlayer)
					: getString(R.string.playerUseExternalPlayer));
		}

	}

}