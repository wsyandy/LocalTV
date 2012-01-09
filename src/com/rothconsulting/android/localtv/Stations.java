package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stations {

	public static final String LAND_LEER = "";
	public static final String LAND_SCHWEIZ = "--- Land: Schweiz ---";
	public static final String LAND_DEUTSCHLAND = "--- Land: Deutschland --- ";
	public static final String LAND_OESTERREICH = "--- Land: Österreich --- ";
	public static final String LAND_USA = "--- Land: USA ---";

	public static final String TELE_BASEL = "Tele Basel";
	public static final String TELE_BAERN = "Tele Bärn";
	public static final String TELE_ZUERI = "Tele Züri";
	public static final String TELE_M1 = "Tele M1";
	public static final String TELE_1 = "Tele 1";
	public static final String SCHWEIZ_5 = "Schweiz 5";
	public static final String LA_TELE = "La Tele";
	public static final String CANAL_ALPHA = "Canal Alpha";
	public static final String ROUGE_TV = "Rouge TV";
	public static final String JUMP_TV = "Jump-TV";
	public static final String TELE_BIELINGUE = "TeleBielingue";
	public static final String ALF_TV = "Alf-TV";
	public static final String TELE_OSTSCHWEIZ = "Tele Ostschweiz";
	public static final String TELE_SUEDOSTSCHWEIZ = "Tele Südostschweiz";
	public static final String SSF = "Schweizer Sport Fernsehen";
	public static final String TCH = "Trailer Cinema Highlights";
	public static final String TELE_TOP = "Tele Top";
	public static final String TELE_DIESSENHOFEN = "Tele Diessenhofen";
	public static final String TELE_NAPF = "Tele Napf";
	public static final String ZUERI_PLUS = "Züri Plus";
	public static final String GEMEINDE_TV = "Gemeinde TV";
	public static final String SARA_MACHTS_TV = "Sara machts TV";
	public static final String KANAL_9 = "Kanal 9";
	public static final String LEMAN_BLEU = "Léman bleu";
	public static final String ZUG_TV = "Zug TV";

	public static final String BW_FAMILY = "BW Family";
	public static final String FAMILY_TV = "Family TV";
	public static final String ALEX_BERLIN = "Alex Berlin";
	public static final String COMEDY_CENTRAL = "Comedy Central";

	public static final String CLASSIC_CARTOONS_ACME = "Classic Cartoons Acme Streaming";
	public static final String NASA_TV = "Nasa TV";

	public static List<String> noTransparentBackground() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_BIELINGUE);
		stations.add(LEMAN_BLEU);
		return stations;
	}

	public static List<String> noFullscreenMessage() {
		List<String> stations = new ArrayList<String>();
		stations.addAll(notLive());
		stations.add(TELE_BAERN);
		stations.add(SSF);
		return stations;
	}

	public static List<String> orientationLandscape() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_BAERN);
		stations.add(NASA_TV);
		stations.add(CANAL_ALPHA);
		return stations;
	}

	public static List<String> notLive() {
		List<String> stations = new ArrayList<String>();
		stations.add(ALF_TV);
		stations.add(JUMP_TV);
		stations.add(TELE_BIELINGUE);
		stations.add(TELE_OSTSCHWEIZ);
		stations.add(TELE_SUEDOSTSCHWEIZ);
		stations.add(TCH);
		stations.add(TELE_TOP);
		stations.add(TELE_DIESSENHOFEN);
		stations.add(TELE_NAPF);
		stations.add(ZUERI_PLUS);
		stations.add(GEMEINDE_TV);
		stations.add(SARA_MACHTS_TV);
		stations.add(KANAL_9);
		stations.add(LEMAN_BLEU);
		stations.add(COMEDY_CENTRAL);
		stations.add(ZUG_TV);
		return stations;
	}

	public static ArrayList<HashMap<String, Object>> getStations() {
		ArrayList<HashMap<String, Object>> stationList = new ArrayList<HashMap<String, Object>>();

		// ******* Schweiz *******
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", LAND_SCHWEIZ);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_schweiz);
		stationList.add(m);

		m = new HashMap<String, Object>();
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
		m.put("url", "ssf.html");
		m.put("icon", R.drawable.ssf);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", LA_TELE);
		m.put("url", "latele.html");
		m.put("icon", R.drawable.la_tele);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", CANAL_ALPHA);
		m.put("url", "canalalpha.html");
		m.put("icon", R.drawable.canal_alpha);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ROUGE_TV);
		m.put("url", "rougetv.html");
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
		m.put("name", KANAL_9);
		m.put("url", "kanal9.html");
		m.put("icon", R.drawable.kanal9);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", LEMAN_BLEU);
		m.put("url", "lemanbleu.html");
		m.put("icon", R.drawable.leman_bleu);
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
		m.put("name", TCH);
		m.put("url", "tch.html");
		m.put("icon", R.drawable.trailer_cinema_highlights);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUERI_PLUS);
		m.put("url", "zueriplustv.html");
		m.put("icon", R.drawable.zueri_plus);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_NAPF);
		m.put("url", "telenapf.html");
		m.put("icon", R.drawable.telenapf);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", GEMEINDE_TV);
		m.put("url", "gemeindetv.html");
		m.put("icon", R.drawable.gemeindetv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SARA_MACHTS_TV);
		m.put("url", "saramachtstv.html");
		m.put("icon", R.drawable.sara_machts_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_TOP);
		m.put("url", "teletop.html");
		m.put("icon", R.drawable.tele_top);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_DIESSENHOFEN);
		m.put("url", "telediessenhofen.html");
		m.put("icon", R.drawable.tele_diessenhofen);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUG_TV);
		m.put("url", "zugtv.html");
		m.put("icon", R.drawable.zug_tv);
		stationList.add(m);

		// ******* Deutschland *******
		stationList.add(getLeerZeile());

		m = new HashMap<String, Object>();
		m.put("name", LAND_DEUTSCHLAND);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_deutschland);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_FAMILY);
		m.put("url", "bwfamily.html");
		m.put("icon", R.drawable.bw_family);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", FAMILY_TV);
		m.put("url", "familytv.html");
		m.put("icon", R.drawable.family_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ALEX_BERLIN);
		m.put("url", "alexberlin.html");
		m.put("icon", R.drawable.alex_berlin);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", COMEDY_CENTRAL);
		m.put("url", "comedycentral.html");
		m.put("icon", R.drawable.comedy_central);
		stationList.add(m);

		// ******* USA *******
		stationList.add(getLeerZeile());

		m = new HashMap<String, Object>();
		m.put("name", LAND_USA);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_usa);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV);
		m.put("url", "nasatv.html");
		m.put("icon", R.drawable.nasa_tv);
		stationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", CLASSIC_CARTOONS_ACME);
		m.put("url", "acme-streaming.html");
		m.put("icon", R.drawable.acme_streaming);
		stationList.add(m);

		return stationList;
	}

	private static HashMap<String, Object> getLeerZeile() {
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", LAND_LEER);
		m.put("url", "");
		m.put("icon", R.drawable.leer1x1);
		return m;
	}
}
