package com.rothconsulting.android.localtv.sqlitedb;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;

import com.rothconsulting.android.localtv.Stations;
import com.rothconsulting.android.localtv.Util;

public class DbUtils {

	private static final String TAG = "DbUtil";

	public static void storeRemoveFav(Context context, String stationName) {
		Util.log(TAG, "storeRemoveFav START");

		DbAdapter dbadapter = new DbAdapter(context);

		dbadapter.open();
		Cursor cursor = dbadapter.fetchStation(stationName);
		dbadapter.close();

		if (cursor == null || cursor.getCount() == 0) {
			// insert new
			Util.log(TAG, "instertStation: " + stationName);
			dbadapter.open();
			dbadapter.insertStation(0, stationName); // TODO
			dbadapter.close();
		} else {
			// delete
			Util.log(TAG, "deleteStation: " + stationName);
			dbadapter.open();
			dbadapter.deleteStation(stationName);
			dbadapter.close();
		}
		Util.log(TAG, "storeRemoveFav STOP");
	}

	public static ArrayList<HashMap<String, Object>> getFavList(Context context) {
		Util.log(TAG, "fillFavSpinner START");

		DbAdapter dbadapter = new DbAdapter(context);
		dbadapter.open();
		Cursor cursor = null;
		cursor = dbadapter.fetchAllStations();
		ArrayList<HashMap<String, Object>> favList = new ArrayList<HashMap<String, Object>>();

		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			do {
				String name = cursor.getString(cursor
						.getColumnIndex(DbAdapter.KEY_STATION_NAME));
				HashMap<String, Object> map = Util.getFullStation(
						Stations.getAllStations(), name);
				favList.add(map);
			} while (cursor.moveToNext());

		}
		cursor.close();
		dbadapter.close();

		Util.log(TAG, "fillFavSpinner STOP");

		return favList;
	}

}
