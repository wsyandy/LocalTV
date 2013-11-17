package com.rothconsulting.android.localtv;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {
	private static Context context;

	public void onCreate() {
		context = getApplicationContext();
	}

	public static Context getCustomAppContext() {
		return context;
	}
}