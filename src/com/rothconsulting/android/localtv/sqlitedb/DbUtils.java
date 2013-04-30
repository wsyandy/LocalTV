package com.rothconsulting.android.localtv.sqlitedb;


public class DbUtils {

	private static final String TAG = "DbUtil";
	//
	// /**
	// *
	// * @param context
	// * @param favIcon
	// */
	// private void setFavIconStar(Context context, String stationName) {
	// Util.log(TAG, "setFavIconStar START");
	// DbAdapter dbadapter = new DbAdapter(context);
	// dbadapter.open();
	// Cursor cursor = null;
	// cursor = dbadapter.fetchStation(stationName);
	// if (cursor != null && cursor.getCount() > 0) {
	// Util.log(TAG, "favIcon ON");
	// favIcon.setTag(FAV_ON);
	// favIcon.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.star_big_on, 0, 0);
	// } else {
	// Util.log(TAG, "favIcon OFF");
	// favIcon.setTag(FAV_OFF);
	// favIcon.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.star_big_off, 0, 0);
	// }
	// cursor.close();
	// dbadapter.close();
	// Util.log(TAG, "setFavIconStar STOP");
	// }
	//
	// private void storeRemoveFav(Context context, String stationName) {
	// Util.log(TAG, "storeRemoveFav START");
	//
	// DbAdapter dbadapter = new DbAdapter(context);
	//
	// if (favIcon.getTag().equals(FAV_OFF)) {
	// favIcon.setTag(FAV_ON);
	// favIcon.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.star_big_on, 0, 0);
	// Util.log(TAG, "favOn -> instertStation: " + stationName);
	// dbadapter.open();
	// dbadapter.insertStation(Constants.SELECTED_STATION_ICON_SMALL_VALUE, stationName);
	// dbadapter.close();
	// } else {
	// favIcon.setTag(FAV_OFF);
	// favIcon.setCompoundDrawablesWithIntrinsicBounds(0, android.R.drawable.star_big_off, 0, 0);
	// Util.log(TAG, "favOff -> deleteStation: " + stationName);
	// dbadapter.open();
	// dbadapter.deleteStation(stationName);
	// dbadapter.close();
	// }
	// Util.log(TAG, "storeRemoveFav STOP");
	// }
	//
	// private void fillFavList(Context context) {
	// Util.log(TAG, "fillFavSpinner START");
	//
	// DbAdapter dbadapter = new DbAdapter(context);
	// dbadapter.open();
	// Cursor cursor = null;
	// cursor = dbadapter.fetchAllStations();
	// favList = new ArrayList<HashMap<String, Object>>();
	//
	// if (cursor != null && cursor.getCount() > 0) {
	// cursor.moveToFirst();
	// do {
	// String name = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_STATION_NAME));
	//
	// HashMap<String, Object> map = Util.getFullStation(stationList, name);
	//
	// favList.add(map);
	// } while (cursor.moveToNext());
	//
	// }
	// cursor.close();
	// dbadapter.close();
	//
	// SimpleAdapter favoritesAdapter = new SimpleAdapter(context, favList, R.layout.station_listitem, new String[] { "icon_small", "name" }, new int[] {
	// R.id.option_icon, R.id.option_text });
	// spnFavoriten.setAdapter(favoritesAdapter);
	//
	// Util.log(TAG, "fillFavSpinner STOP");
	//
	// }

}
