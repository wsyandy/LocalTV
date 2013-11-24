package com.rothconsulting.android.localtv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Settings extends PreferenceActivity implements OnSharedPreferenceChangeListener {

	// Keys see res/xml/preferences.xml
	public static final String KEY_INT_OR_EXT_PLAYER = "internal_or_external_player";
	public static final String KEY_FLASH_PLAYER_OPTIONS = "flash_player_options";

	public static final String FLASH_OPTION_CHANGED = "flash_option_changed";

	private SharedPreferences sharedPreferences;
	private ListPreference mListPreferenceIntOrExtPlayer;
	private ListPreference mListPreferenceAdobeFlashPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		addPreferencesFromResource(R.xml.preferences);

		// Get a reference to the preferences
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		mListPreferenceIntOrExtPlayer = (ListPreference) getPreferenceScreen().findPreference(KEY_INT_OR_EXT_PLAYER);
		mListPreferenceAdobeFlashPlayer = (ListPreference) getPreferenceScreen().findPreference(KEY_FLASH_PLAYER_OPTIONS);

		AdMob admob = new AdMob();
		admob.showRemoveAds(this);
	}

	@Override
	protected void onResume() {
		super.onResume();

		// Setup the initial values
		if (Util.isPlatformBelow_4_0()) {
			mListPreferenceIntOrExtPlayer.setEnabled(false);
			mListPreferenceIntOrExtPlayer.setSummary(getString(R.string.playerUseSolHlsPlayer));
			mListPreferenceIntOrExtPlayer.setValue(getString(R.string.playerUseSolHlsPlayer));
		} else {
			mListPreferenceIntOrExtPlayer.setSummary(getString(R.string.playerOptionsSummary,
					sharedPreferences.getString(KEY_INT_OR_EXT_PLAYER, getString(R.string.playerUseInternalPlayer))));
		}

		mListPreferenceAdobeFlashPlayer.setSummary(getString(R.string.flashOptionsSummary,
				sharedPreferences.getString(KEY_FLASH_PLAYER_OPTIONS, getString(R.string.flashWhenNoOther))));

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
		if (key.equals(KEY_INT_OR_EXT_PLAYER)) {
			mListPreferenceIntOrExtPlayer.setSummary(getString(R.string.playerOptionsSummary,
					sharedPreferences.getString(key, getString(R.string.playerUseInternalPlayer))));
		} else if (key.equals(KEY_FLASH_PLAYER_OPTIONS)) {
			mListPreferenceAdobeFlashPlayer.setSummary(getString(R.string.flashOptionsSummary,
					sharedPreferences.getString(key, getString(R.string.flashWhenNoOther))));
			Intent i = getIntent();
			i.putExtra(FLASH_OPTION_CHANGED, true);
			setResult(RESULT_OK, i);
		}

	}

	public static String getFlashOption(Context context) {
		if (Util.isBorderOver()) {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
			return sharedPreferences.getString(KEY_FLASH_PLAYER_OPTIONS, context.getString(R.string.flashWhenNoOther));
		} else {
			return context.getString(R.string.flashDoNotUse);
		}
	}
}