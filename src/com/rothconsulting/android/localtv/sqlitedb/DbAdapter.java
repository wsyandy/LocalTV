package com.rothconsulting.android.localtv.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.rothconsulting.android.localtv.Util;

public class DbAdapter {

	private static final String TAG = "DbAdapter";
	// Database fields
	public static final String KEY_ROWID = "_id";
	public static final String KEY_STATION_NAME = "name";
	public static final String T_STATION = "station";
	private final Context context;
	private SQLiteDatabase database;
	private DbHelper dbHelper;

	public DbAdapter(Context context) {
		this.context = context;
	}

	public DbAdapter open() throws SQLException {
		dbHelper = new DbHelper(context);
		Util.log(TAG, "dbHelper=" + dbHelper);
		database = dbHelper.getWritableDatabase();
		Util.log(TAG, "database=" + database);
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	/**
	 * Create a new station. If the station is successfully created return the new rowId for that note, otherwise return a -1 to indicate failure.
	 */
	public long insertStation(String stationName) {

		ContentValues values = new ContentValues();
		values.put(KEY_STATION_NAME, stationName);

		return database.insert(T_STATION, null, values);
	}

	/**
	 * Deletes station
	 */
	public int deleteStation(String stationName) {
		Util.log(TAG, "delete stationName=" + stationName);
		int affected = database.delete(T_STATION, KEY_STATION_NAME + "='" + stationName + "'", null);
		Util.log(TAG, "rows deleted=" + affected);

		return affected;
	}

	/**
	 * Return a Cursor over the list of all stations in the database
	 * 
	 * @return Cursor over all station
	 */
	public Cursor fetchAllStations() {
		return database.rawQuery("SELECT * FROM " + T_STATION, null);
	}

	/**
	 * Return a Cursor positioned at the defined station
	 */
	public Cursor fetchStation(String stationName) throws SQLException {
		// Escaping
		if (stationName != null) {
			stationName = stationName.replaceAll("'", "''");
		}

		Cursor mCursor = null;
		mCursor = database
				.query(true, T_STATION, new String[] { KEY_STATION_NAME }, KEY_STATION_NAME + "= '" + stationName + "'", null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
			Util.log(TAG, "cursor.getCount()=" + mCursor.getCount());
		}
		Util.log(TAG, "cursor.position=" + mCursor.getPosition());
		return mCursor;
	}

}
