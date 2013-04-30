package com.rothconsulting.android.localtv.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rothconsulting.android.localtv.Util;

public class DbHelper extends SQLiteOpenHelper {

	private static final String TAG = "DBHelper";

	public static final String DATABASE_NAME = "RadioRecPlus.db";

	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table " + DbAdapter.T_STATION + " (" + DbAdapter.KEY_ROWID + " integer primary key autoincrement, "
			+ DbAdapter.KEY_STATION_ICON_SMALL + " integer not null, " + DbAdapter.KEY_STATION_NAME + " text not null);";

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		Util.log(TAG, "executeSQL. database=" + database);
		database.execSQL(DATABASE_CREATE);
	}

	// Method is called during an upgrade of the database, e.g. if you increase
	// the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(DbHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + DbAdapter.T_STATION);
		onCreate(database);
	}
}