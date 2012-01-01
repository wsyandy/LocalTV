package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;

public class Stations {

	public static ArrayList<HashMap<String, Object>> getStations() {
		ArrayList<HashMap<String, Object>> stationList = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", "Tele Basel");
		m.put("url", "telebasel.html");
		m.put("icon", R.drawable.tele_basel);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele Bärn");
		// m.put("url", "telebaern.html");
		m.put("url",
				"http://static.infomaniak.ch/configvideo/barntele/livetv/live.html");
		m.put("icon", R.drawable.tele_baern);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele M1");
		m.put("url", "telem1.html");
		m.put("icon", R.drawable.tele_m1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele Züri");
		m.put("url", "telezueri.html");
		m.put("icon", R.drawable.tele_zueri);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Tele 1");
		m.put("url", "tele1.html");
		m.put("icon", R.drawable.tele1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Schweiz 5");
		m.put("url", "schweiz5.html");
		m.put("icon", R.drawable.schweiz_5);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "BW Family");
		m.put("url", "http://www.bwfamily.tv/interfaces/live.php");
		m.put("icon", R.drawable.bw_family);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", "Alex Berlin");
		m.put("url", "alexberlin.html");
		m.put("icon", R.drawable.alex_berlin);
		stationList.add(m);

		return stationList;
	}
}
