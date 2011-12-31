package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;

public class Stations {

	public static final String SCHWEIZER_SPORTFERNSEHEN_URL = "SSF.html";
	public static final String TELE_BASEL_URL = "telebasel.html";
	// public static final String TELE_BAERN_URL = "telebaern.html";
	public static final String TELE_BAERN_URL = "http://static.infomaniak.ch/configvideo/barntele/livetv/live.html";
	public static final String TELE_M1_URL = "telem1.html";
	public static final String TELE_ZUERI_URL = "telezueri.html";
	public static final String TELE_1_URL = "tele1.html";
	public static final String SCHWEIZ_5_URL = "schweiz5.html";

	public static ArrayList<HashMap<String, Object>> getStations() {
		ArrayList<HashMap<String, Object>> stationList = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", "Tele Basel");
		m.put("url", TELE_BASEL_URL);
		m.put("icon", R.drawable.tele_basel);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele Bärn");
		m.put("url", TELE_BAERN_URL);
		m.put("icon", R.drawable.tele_baern);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele M1");
		m.put("url", TELE_M1_URL);
		m.put("icon", R.drawable.tele_m1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele Züri");
		m.put("url", TELE_ZUERI_URL);
		m.put("icon", R.drawable.tele_zueri);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele 1");
		m.put("url", TELE_1_URL);
		m.put("icon", R.drawable.tele1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Schweiz 5");
		m.put("url", SCHWEIZ_5_URL);
		m.put("icon", R.drawable.schweiz_5);
		stationList.add(m);

		return stationList;
	}
}
