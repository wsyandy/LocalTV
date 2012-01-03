package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stations {

	public static final String TELE_BASEL = "Tele Basel";
	public static final String TELE_BAERN = "Tele Bärn";
	public static final String TELE_ZUERI = "Tele Züri";
	public static final String TELE_M1 = "Tele M1";
	public static final String TELE_1 = "Tele 1";
	public static final String SCHWEIZ_5 = "Schweiz 5";
	public static final String LA_TELE = "La Tele";
	public static final String ROUGE_TV = "Rouge TV";
	public static final String JUMP_TV = "Jump-TV (Solothurn)";
	public static final String TELE_BIELINGUE = "TeleBielingue";
	public static final String ALF_TV = "Alf-TV (Aarau-Olten-Zofingen)";
	public static final String TELE_OSTSCHWEIZ = "Tele Ostschweiz";
	public static final String TELE_SUEDOSTSCHWEIZ = "Tele Südostschweiz";
	public static final String SSF = "Schweizer Sport Fernsehen";
	public static final String BW_FAMILY = "BW Family";
	public static final String FAMILY_TV = "Family TV";
	public static final String ALEX_BERLIN = "Alex Berlin";
	public static final String CLASSIC_CARTOONS_ACME = "Classic Cartoons Acme Streaming";

	public static List<String> noTransparentBackground() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_BIELINGUE);
		return stations;
	}

	public static List<String> noFullscreenMessage() {
		List<String> stations = new ArrayList<String>();
		stations.addAll(notLive());
		stations.add(TELE_BASEL);
		stations.add(TELE_BAERN);
		stations.add(SSF);
		return stations;
	}

	public static List<String> notLive() {
		List<String> stations = new ArrayList<String>();
		stations.add(ALF_TV);
		stations.add(JUMP_TV);
		stations.add(TELE_BIELINGUE);
		stations.add(TELE_OSTSCHWEIZ);
		stations.add(TELE_SUEDOSTSCHWEIZ);
		return stations;
	}

	public static ArrayList<HashMap<String, Object>> getStations() {
		ArrayList<HashMap<String, Object>> stationList = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", TELE_BASEL);
		m.put("url", "telebasel.html");
		m.put("icon", R.drawable.tele_basel);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BAERN);
		m.put("url", "telebaern.html");
		m.put("icon", R.drawable.tele_baern);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_ZUERI);
		m.put("url", "telezueri.html");
		m.put("icon", R.drawable.tele_zueri);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_M1);
		m.put("url", "telem1.html");
		m.put("icon", R.drawable.tele_m1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_1);
		m.put("url", "tele1.html");
		m.put("icon", R.drawable.tele1);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SCHWEIZ_5);
		m.put("url", "schweiz5.html");
		m.put("icon", R.drawable.schweiz_5);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SSF);
		m.put("url", "http://internettv.ch/sport/ssf-live/ssf-live");
		m.put("icon", R.drawable.ssf);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", LA_TELE);
		m.put("url",
				"http://www.latele.ch/webtv/MAPlayer.swf?src=rtmp%3A%2F%2Frtmp.infomaniak.ch%2Flivecast%2Flatele&mode=overlay&themeColor=0395d3&frameColor=333333&fontColor=cccccc&autostart=true");
		m.put("icon", R.drawable.la_tele);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ROUGE_TV);
		m.put("url", "http://www.rougetv.ch/live.php");
		m.put("icon", R.drawable.rouge_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ALF_TV);
		m.put("url", "alf.html");
		m.put("icon", R.drawable.alf);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", JUMP_TV);
		m.put("url", "jumptv.html");
		m.put("icon", R.drawable.jump_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BIELINGUE);
		m.put("url", "telebielingue.html");
		m.put("icon", R.drawable.telebielingue);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_OSTSCHWEIZ);
		m.put("url", "teleostschweiz.html");
		m.put("icon", R.drawable.tele_ostschweiz);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_SUEDOSTSCHWEIZ);
		m.put("url", "telesuedostschweiz.html");
		m.put("icon", R.drawable.tele_suedostschweiz);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_FAMILY);
		m.put("url", "http://www.bwfamily.tv/interfaces/live.php");
		m.put("icon", R.drawable.bw_family);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", FAMILY_TV);
		m.put("url", "http://familytv.tv/livestream.php");
		m.put("icon", R.drawable.family_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ALEX_BERLIN);
		m.put("url", "alexberlin.html");
		m.put("icon", R.drawable.alex_berlin);
		stationList.add(m);

		// m = new HashMap<String, Object>();
		// m.put("name", "BR Mediathek");
		// m.put("url",
		// "http://mediathek-video.br.de/B7Mediathek.html?bccode=both");
		// m.put("icon", R.drawable.br_mediathek);
		// stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", CLASSIC_CARTOONS_ACME);
		m.put("url", "acme-streaming.html");
		m.put("icon", R.drawable.acme_streaming);
		stationList.add(m);

		return stationList;
	}
}
