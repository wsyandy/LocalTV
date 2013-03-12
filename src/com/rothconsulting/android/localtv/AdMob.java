package com.rothconsulting.android.localtv;

import android.app.Activity;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class AdMob {

	private final static String TAG = "AdMob";

	public void showRemoveAds(Activity context) {
		showRemoveAdsImpl(context);
	}

	private void showRemoveAdsImpl(Activity context) {
		if (hasValidKey()) {
			LinearLayout layout = (LinearLayout) context
					.findViewById(R.id.adsLayout);
			layout.removeAllViews();
		} else {
			// Create the adView
			AdView adView = new AdView(context, AdSize.BANNER,
					Constants.ADMOB_PUBLISHER_ID);
			Log.d(TAG, "adView=" + adView);

			LinearLayout layout = (LinearLayout) context
					.findViewById(R.id.adsLayout);
			// Add the adView to it
			layout.addView(adView);
			// Initiate a generic request to load it with an ad
			adView.loadAd(new AdRequest());
		}
	}

	private boolean hasValidKey() {
		String key = Constants.THE_ANTI_ADS_KEY;
		if (key != null && key.startsWith("loc") && key.endsWith("tv")) {
			return true;
		}
		return false;
	}

}