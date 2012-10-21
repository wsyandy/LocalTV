package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stations {

	public static final String LAND_LEER = "";
	public static final String LAND_SCHWEIZ = "-- Land: Schweiz --";
	public static final String LAND_DEUTSCHLAND = "-- Land: Deutschland --";
	// public static final String LAND_OESTERREICH = "-- Land: Österreich --";
	public static final String LAND_DIVERSE_LAENDER = "-- Diverse Länder --";

	public static final String TELE_BAERN = "Tele Bärn";
	public static final String TELE_ZUERI = "Tele Züri";
	public static final String TELE_BASEL_LIVE = "Tele Basel";
	public static final String TELE_BASEL_ARCHIV = "Tele Basel (Archiv)";
	public static final String TELE_M1_LIVE = "Tele M1";
	public static final String TELE_M1_ARCHIV = "Tele M1 (Archiv)";
	public static final String TELE_1_LIVE = "Tele 1";
	public static final String TELE_1_ARCHIV = "Tele 1 (Archiv)";
	public static final String SCHWEIZ_5 = "Schweiz 5";
	public static final String SSF = "Schweizer Sport Fernsehen";
	public static final String LA_TELE = "La Télé";
	public static final String CANAL_ALPHA = "Canal Alpha";
	public static final String ROUGE_TV = "Rouge TV";
	public static final String TV_105 = "105 TV";
	public static final String RTS_UN = "RTS Un";
	public static final String RTS_DEUX = "RTS Deux";
	public static final String RSI_LA2 = "RSI La 2";
	public static final String ZERMATT_KLEIN_MATTERHORN = "Zermatt Klein Matterhorn";
	public static final String ZERMATT_SCHWARZSEE = "Zermatt Schwarzsee";
	public static final String ZERMATT_ROTHORN = "Zermatt Rothorn";
	public static final String ZERMATT_SUNNEGGA = "Zermatt Sunnegga";
	public static final String ZERMATT_TROCKENER_STEG = "Zermatt Trockener Steg";

	public static final String NEUDINGS_TV = "neu dings TV";
	public static final String TV_ADMIN_CH = "Bundesverwaltung (admin.ch)";
	public static final String ALF_TV = "Alf-TV";
	public static final String JUMP_TV = "Jump-TV";
	public static final String CASH_TV = "Cash TV";
	public static final String TELE_BIELINGUE = "Tele Bielingue";
	public static final String KANAL_9 = "Kanal 9";
	public static final String RRO_TV = "RRO TV";
	public static final String LEMAN_BLEU = "Léman bleu";
	public static final String TELE_OSTSCHWEIZ = "Tele Ostschweiz";
	public static final String TELE_SUEDOSTSCHWEIZ = "Tele Südostschweiz";
	public static final String TELE_SUEDOSTSCHWEIZ_ARCHIV = "Tele Südostschweiz (Archiv)";
	public static final String TCH = "Trailer Cinema Highlights";
	public static final String REGIO_PLUS_TV = "Regio TV Plus";
	public static final String ZUERI_PLUS = "Züri Plus";
	public static final String TELE_NAPF = "Tele Napf";
	public static final String GEMEINDE_TV = "Gemeinde TV";
	public static final String SARA_MACHTS_TV = "Sara machts TV";
	public static final String TELE_TOP = "Tele Top";
	public static final String TELE_DIESSENHOFEN = "Tele Diessenhofen";
	public static final String ZUG_TV = "Zug TV";
	public static final String MURMI_TV = "Murmi TV";
	public static final String CANAL_29 = "Canal 29";
	public static final String MAX_TV = "max tv";
	public static final String SCHAFFHAUSER_FERNSEHEN = "Schaffhauser Fernsehen";
	public static final String SF_VIDEO_PORTAL = "SF Video Portal (Comedy, etc..)";
	public static final String ART_TV = "art tv";
	public static final String BNJ_TV = "bnj.tv";
	public static final String TSR_VIDEO = "TSR video";
	public static final String TELEVISTA = "Televista";
	public static final String GESUNDHEIT_SPRECHSTUNDE = "Gesundheit Sprechstunde";
	public static final String MOTOTRSHOW_TCS = "Motor Show TCS";

	public static final String BW_FAMILY = "BW Family";
	public static final String FAMILY_TV = "Family TV";
	public static final String ALEX_BERLIN = "Alex Berlin";
	public static final String MUENCHEN_TV = "München TV";
	public static final String FRANKEN_TV = "Franken Fernsehen";
	public static final String TRU_YOUNG_TV = "[tru:] young television";
	public static final String TRP1_FERNSEHEN = "TRP1 Fernsehen";
	public static final String BIBEL_TV = "Bibel TV";
	public static final String K_TV = "K-TV (Kephas Kirche Kultur)";
	public static final String ERF = "ERF";
	public static final String TV_SUEDBADEN = "TV Südbaden";
	public static final String NDR = "NDR";
	public static final String WDR = "WDR";
	public static final String HR = "HR";
	public static final String SPIEGEL_ONLINE = "Spiegel Online";
	public static final String SPONGEBOB = "Spongebob";
	public static final String NETZKINO = "Netzkino";
	public static final String KINDERKINO = "Kinderkino";
	public static final String MYSPASS = "myspass.de";
	public static final String RBB_MEDIATHEK = "RBB Mediathek";
	public static final String RBB_DOKU_REPORTAGEN = "RBB Doku Reportagen";
	public static final String FOUR_SESAONS_TV = "4 seasons TV";
	public static final String MASSIVE_SPORT_MAG = "Massive SportsTV - Mag";
	public static final String MASSIVE_SPORT_BIKE = "Massive SportsTV - Bike";
	public static final String MASSIVE_SPORT_RUNNING = "Massive SportsTV - Running";
	public static final String MASSIVE_SPORT_FREEZE = "Massive SportsTV - Freeze";
	public static final String MASSIVE_SPORT_EXTREME = "Massive SportsTV - Extreme";
	public static final String MASSIVE_SPORT_SPEED = "Massive SportsTV - Speed";
	public static final String L_TV = "L TV";
	public static final String _3_SAT = "3 sat";
	public static final String ARD_MEDIATHEK = "ARD Mediathek";
	public static final String OBERPFALZ_TV = "Oberpfalz TV";
	public static final String AUGSBURG_TV = "Augsburg TV";
	public static final String BERG_TV = "Bergisch Gladbach TV";
	public static final String ANDROID_NEW_TV = "Android News TV";
	public static final String DW = "DW - Deutsche Welle";
	public static final String LEIPZIG_TV = "Leipzig Fernsehen";
	public static final String BAYERN_TV = "Bayerisches Fernsehen";
	public static final String OK_DESSAU = "OK Dessau";
	public static final String OK_MAGDEBURG = "OK Magdeburg";
	public static final String OK_MERSEBURG = "OK Merseburg";
	public static final String OK_SALZWEDEL = "OK Salzwedel";
	public static final String OK_STENDAL = "OK Stendal";
	public static final String OK_WERNIGERODE = "OK Wernigerode";
	public static final String OK_WETTIN = "OK Wettin";
	public static final String TV_HALLE = "TV Halle";
	public static final String RAN_1 = "RAN 1 (Anhalt)";
	public static final String ELBEKANAL = "Elbekanal";
	public static final String PUNKT_UM = "PUNKTum";
	public static final String RBW = "RBW";
	public static final String RFH = "RFH";
	public static final String BLK_ONLINE_TV = "BLKonlineTV";
	public static final String DAS_VIERTE = "Das Vierte";
	public static final String RTF_1 = "RTF 1";
	public static final String BW_EINS = "BW Eins";
	public static final String PROMETHEUS = "Prometheus";
	public static final String SWR_MEDIATHEK = "SWR Mediathek";
	public static final String MDR_MEDIATHEK = "MDR Mediathek";
	public static final String HAMBURG_1_MEDIATHEK = "Hamburg1 Mediathek";
	public static final String SACHSEN_FERNSEHEN = "Sachsen Fernsehen";

	public static final String RED_BULL_TV = "Red Bull TV";
	public static final String SERVUS_TV = "Servus TV";
	public static final String NASA_TV_PUBLIC = "Nasa TV - Public";
	public static final String NASA_TV_MEDIA = "Nasa TV - Media";
	public static final String NASA_TV_EDUCATION = "Nasa TV - Education";
	public static final String CLASSIC_CARTOONS_ACME = "Classic Cartoons Acme Streaming";
	public static final String RTS_SALZBURG = "RTS Salzburg";

	private ArrayList<HashMap<String, Object>> liveStationList;
	private ArrayList<HashMap<String, Object>> archivStationList;
	private static ArrayList<HashMap<String, Object>> allStationList;
	private static ArrayList<String> notLiveList;

	public Stations() {
		liveStationList = new ArrayList<HashMap<String, Object>>();
		archivStationList = new ArrayList<HashMap<String, Object>>();
		allStationList = new ArrayList<HashMap<String, Object>>();
		notLiveList = new ArrayList<String>();
	}

	public static List<String> noTransparentBackground() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_BIELINGUE);
		stations.add(LEMAN_BLEU);
		stations.add(TV_ADMIN_CH);
		return stations;
	}

	public static List<String> orientationPortrait() {
		List<String> stations = new ArrayList<String>();
		stations.add(CASH_TV);
		stations.add(TELE_BIELINGUE);
		stations.add(ALF_TV);
		stations.add(SCHAFFHAUSER_FERNSEHEN);
		return stations;
	}

	public static List<String> userAgentAndroid() {
		List<String> stations = new ArrayList<String>();
		// stations.add(TELE_NAPF);
		// stations.add(NETZKINO);
		// stations.add(KINDERKINO);
		stations.add(NASA_TV_PUBLIC);
		stations.add(NASA_TV_MEDIA);
		stations.add(NASA_TV_EDUCATION);
		return stations;
	}

	public static List<String> allowZoom() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_M1_LIVE);
		stations.add(TELE_ZUERI);
		stations.add(HR);
		// stations.add(SWR_MEDIATHEK);
		return stations;
	}

	public ArrayList<HashMap<String, Object>> getLiveStations() {
		return liveStationList;
	}

	public ArrayList<HashMap<String, Object>> getArchivStations() {
		return archivStationList;
	}

	public static ArrayList<HashMap<String, Object>> getAllStations() {
		return allStationList;
	}

	public static ArrayList<String> getNotLiveStations() {
		return notLiveList;
	}

	private void addToArchiveAndNotLiveStations(HashMap<String, Object> map) {
		archivStationList.add(map);
		notLiveList.add((String) (map.get("name")));

	}

	public void init() {
		allStationList = new ArrayList<HashMap<String, Object>>();
		liveStationList = new ArrayList<HashMap<String, Object>>();
		archivStationList = new ArrayList<HashMap<String, Object>>();
		notLiveList = new ArrayList<String>();

		// *********************************************************************************
		// * Schweiz
		// *********************************************************************************
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", LAND_SCHWEIZ);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_schweiz);
		allStationList.add(m);
		liveStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BAERN);
		m.put("url", "telebaern.php");
		m.put("icon", R.drawable.tele_baern);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_ZUERI);
		m.put("url", "telezueri.html");
		m.put("icon", R.drawable.tele_zueri);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BASEL_LIVE);
		m.put("url", "telebasel.php");
		m.put("icon", R.drawable.tele_basel);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BASEL_ARCHIV);
		m.put("url", "telebaselArchiv.html");
		m.put("icon", R.drawable.tele_basel);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_M1_LIVE);
		m.put("url", "telem1.php");
		m.put("icon", R.drawable.tele_m1);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_M1_ARCHIV);
		m.put("url", "telem1Archiv.html");
		m.put("icon", R.drawable.tele_m1);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_1_LIVE);
		m.put("url", "tele1.php");
		m.put("icon", R.drawable.tele1);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_1_ARCHIV);
		m.put("url", "tele1Archiv.html");
		m.put("icon", R.drawable.tele1);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_SUEDOSTSCHWEIZ);
		m.put("url", "telesuedostschweiz.html");
		m.put("icon", R.drawable.tele_suedostschweiz);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_SUEDOSTSCHWEIZ_ARCHIV);
		m.put("url", "telesuedostschweizArchiv.html");
		m.put("icon", R.drawable.tele_suedostschweiz);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SCHWEIZ_5);
		m.put("url", "schweiz5.php");
		m.put("icon", R.drawable.schweiz_5);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SSF);
		m.put("url", "ssf.php");
		m.put("icon", R.drawable.ssf);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", LA_TELE);
		m.put("url", "latele.php");
		m.put("icon", R.drawable.la_tele);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", CANAL_ALPHA);
		m.put("url", "canalalpha.php");
		m.put("icon", R.drawable.canal_alpha);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ROUGE_TV);
		m.put("url", "rougetv.php");
		m.put("icon", R.drawable.rouge_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_105);
		m.put("url", "105tv.html");
		m.put("icon", R.drawable.tv_105);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_UN);
		m.put("url", "rtsUn.php");
		m.put("icon", R.drawable.rts_un);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_DEUX);
		m.put("url", "rtsDeux.php");
		m.put("icon", R.drawable.rts_deux);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RSI_LA2);
		m.put("url", "rsiLa2.php");
		m.put("icon", R.drawable.rsi_la2);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_KLEIN_MATTERHORN);
		m.put("url", "zermattKleinMatterhorn.php");
		m.put("icon", R.drawable.zermatt);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_SCHWARZSEE);
		m.put("url", "zermattSchwarzsee.php");
		m.put("icon", R.drawable.zermatt);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_ROTHORN);
		m.put("url", "zermattRothorn.php");
		m.put("icon", R.drawable.zermatt);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_SUNNEGGA);
		m.put("url", "zermattSunnegga.php");
		m.put("icon", R.drawable.zermatt);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_TROCKENER_STEG);
		m.put("url", "zermattTrockenerSteg.php");
		m.put("icon", R.drawable.zermatt);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_OSTSCHWEIZ);
		m.put("url", "teleostschweiz.html");
		m.put("icon", R.drawable.tele_ostschweiz);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_ADMIN_CH);
		m.put("url", "tv.admin.ch.html");
		m.put("icon", R.drawable.admin_ch);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NEUDINGS_TV);
		m.put("url", "neudingsTv.php");
		m.put("icon", R.drawable.neudings_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ALF_TV);
		m.put("url", "alf.html");
		m.put("icon", R.drawable.alf);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", JUMP_TV);
		m.put("url", "jumptv.html");
		m.put("icon", R.drawable.jump_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CASH_TV);
		m.put("url", "cashTV.html");
		m.put("icon", R.drawable.cash_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BIELINGUE);
		m.put("url", "telebielingue.html");
		m.put("icon", R.drawable.telebielingue);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", KANAL_9);
		m.put("url", "kanal9.html");
		m.put("icon", R.drawable.kanal9);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RRO_TV);
		m.put("url", "rroTV.html");
		m.put("icon", R.drawable.rro_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", LEMAN_BLEU);
		m.put("url", "lemanbleu.html");
		m.put("icon", R.drawable.leman_bleu);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TCH);
		m.put("url", "tch.html");
		m.put("icon", R.drawable.trailer_cinema_highlights);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", REGIO_PLUS_TV);
		m.put("url", "regioPlusTV.html");
		m.put("icon", R.drawable.regio_plus_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUERI_PLUS);
		m.put("url", "zueriplustv.html");
		m.put("icon", R.drawable.zueri_plus);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_NAPF);
		m.put("url", "telenapf.html");
		m.put("icon", R.drawable.telenapf);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", GEMEINDE_TV);
		m.put("url", "gemeindetv.html");
		m.put("icon", R.drawable.gemeindetv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SARA_MACHTS_TV);
		m.put("url", "saramachtstv.html");
		m.put("icon", R.drawable.sara_machts_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_TOP);
		m.put("url", "teletop.html");
		m.put("icon", R.drawable.tele_top);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_DIESSENHOFEN);
		m.put("url", "telediessenhofen.html");
		m.put("icon", R.drawable.tele_diessenhofen);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUG_TV);
		m.put("url", "zugtv.html");
		m.put("icon", R.drawable.zug_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MURMI_TV);
		m.put("url", "murmitv.html");
		m.put("icon", R.drawable.murmi_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CANAL_29);
		m.put("url", "canal29.html");
		m.put("icon", R.drawable.canal_29);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MAX_TV);
		m.put("url", "maxTV.html");
		m.put("icon", R.drawable.max_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SCHAFFHAUSER_FERNSEHEN);
		m.put("url", "schaffhausenFernsehen.html");
		m.put("icon", R.drawable.schaffhauser_fernsehen);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SF_VIDEO_PORTAL);
		m.put("url", "sf-video-portal.html");
		m.put("icon", R.drawable.schweizer_fernsehen);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TSR_VIDEO);
		m.put("url", "tsr.html");
		m.put("icon", R.drawable.tsr);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ART_TV);
		m.put("url", "artTV.html");
		m.put("icon", R.drawable.art_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BNJ_TV);
		m.put("url", "bnjTV.html");
		m.put("icon", R.drawable.bnj_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELEVISTA);
		m.put("url", "televista.html");
		m.put("icon", R.drawable.televista);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", GESUNDHEIT_SPRECHSTUNDE);
		m.put("url", "gesundheit-sprechstunde.html");
		m.put("icon", R.drawable.gesundheitsprechstunde);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MOTOTRSHOW_TCS);
		m.put("url", "motorshow-tcs.html");
		m.put("icon", R.drawable.motorshow_tcs);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		// *********************************************************************************
		// * Deutschland
		// *********************************************************************************
		allStationList.add(getLeerZeile());
		archivStationList.add(getLeerZeile());
		liveStationList.add(getLeerZeile());

		m = new HashMap<String, Object>();
		m.put("name", LAND_DEUTSCHLAND);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_deutschland);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NDR);
		m.put("url", "ndr.php");
		m.put("icon", R.drawable.ndr_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", WDR);
		m.put("url", "wdr.php");
		m.put("icon", R.drawable.wdr_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", HR);
		m.put("url", "hrTV.html");
		m.put("icon", R.drawable.hr_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_FAMILY);
		m.put("url", "bwfamily.php");
		m.put("icon", R.drawable.bw_family);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", FAMILY_TV);
		m.put("url", "familytv.php");
		m.put("icon", R.drawable.family_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ALEX_BERLIN);
		m.put("url", "alexberlin.php");
		m.put("icon", R.drawable.alex_berlin);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MUENCHEN_TV);
		m.put("url", "muenchenTV.php");
		m.put("icon", R.drawable.muenchen_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", FRANKEN_TV);
		m.put("url", "frankenTV.php");
		m.put("icon", R.drawable.franken_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TRU_YOUNG_TV);
		m.put("url", "truYoungTV.php");
		m.put("icon", R.drawable.tru_young_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BIBEL_TV);
		m.put("url", "bibelTV.php");
		m.put("icon", R.drawable.bibel_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", K_TV);
		m.put("url", "k-tv.php");
		m.put("icon", R.drawable.k_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ERF);
		m.put("url", "erf.php");
		m.put("icon", R.drawable.erf);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TRP1_FERNSEHEN);
		m.put("url", "trp1_fernsehen.php");
		m.put("icon", R.drawable.trp1_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_SUEDBADEN);
		m.put("url", "tvSuedbaden.php");
		m.put("icon", R.drawable.tv_suedbaden);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", FOUR_SESAONS_TV);
		m.put("url", "4seasonsTV.php");
		m.put("icon", R.drawable.fourseasons);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_MAG);
		m.put("url", "massiveSportsTvMag.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_BIKE);
		m.put("url", "massiveSportsTvBike.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_RUNNING);
		m.put("url", "massiveSportsTvRunning.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_FREEZE);
		m.put("url", "massiveSportsTvFreeze.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_EXTREME);
		m.put("url", "massiveSportsTvExtreme.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_SPEED);
		m.put("url", "massiveSportsTvSpeed.php");
		m.put("icon", R.drawable.massive_sports_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", L_TV);
		m.put("url", "l-tv.php");
		m.put("icon", R.drawable.ltv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OBERPFALZ_TV);
		m.put("url", "oberpfalzTV.php");
		m.put("icon", R.drawable.oberpfalz_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", AUGSBURG_TV);
		m.put("url", "augsburgTV.php");
		m.put("icon", R.drawable.augsburg_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", DW);
		m.put("url", "dw.php");
		m.put("icon", R.drawable.dw_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", LEIPZIG_TV);
		m.put("url", "leipzigTV.php");
		m.put("icon", R.drawable.leipzig_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BAYERN_TV);
		m.put("url", "bayerischesFernsehen.php");
		m.put("icon", R.drawable.bayrisches_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_DESSAU);
		m.put("url", "okDessau.php");
		m.put("icon", R.drawable.ok_dessau);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_MAGDEBURG);
		m.put("url", "okMagdeburg.php");
		m.put("icon", R.drawable.ok_magdeburg);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_MERSEBURG);
		m.put("url", "okMerseburg.php");
		m.put("icon", R.drawable.ok_merseburg);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_SALZWEDEL);
		m.put("url", "okSalzwedel.php");
		m.put("icon", R.drawable.ok_salzwedel);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_STENDAL);
		m.put("url", "okStendal.php");
		m.put("icon", R.drawable.ok_stendal);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_WERNIGERODE);
		m.put("url", "okWernigerode.php");
		m.put("icon", R.drawable.ok_wernigerode);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_WETTIN);
		m.put("url", "okWettin.php");
		m.put("icon", R.drawable.ok_wettin);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_HALLE);
		m.put("url", "tvHalle.php");
		m.put("icon", R.drawable.tv_halle);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RAN_1);
		m.put("url", "ran1.php");
		m.put("icon", R.drawable.ran1);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", ELBEKANAL);
		m.put("url", "elbekanal.php");
		m.put("icon", R.drawable.elbekanal);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", PUNKT_UM);
		m.put("url", "punktUm.php");
		m.put("icon", R.drawable.punkt_um);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RBW);
		m.put("url", "rbw.php");
		m.put("icon", R.drawable.rbw);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RFH);
		m.put("url", "rfh.php");
		m.put("icon", R.drawable.rfh);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", BLK_ONLINE_TV);
		m.put("url", "blkOnlineTv.php");
		m.put("icon", R.drawable.blk_online_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", DAS_VIERTE);
		m.put("url", "dasVierte.php");
		m.put("icon", R.drawable.das_vierte);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RTF_1);
		m.put("url", "rtf1.php");
		m.put("icon", R.drawable.rtf1);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SACHSEN_FERNSEHEN);
		m.put("url", "sachsenFernsehen.php");
		m.put("icon", R.drawable.sachsen_fernsehen);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", _3_SAT);
		m.put("url", "3sat.html");
		m.put("icon", R.drawable.drei_sat);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ARD_MEDIATHEK);
		m.put("url", "ardMediathek.php");
		m.put("icon", R.drawable.ard_mediathek);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SWR_MEDIATHEK);
		m.put("url", "swr.php");
		m.put("icon", R.drawable.swr);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MDR_MEDIATHEK);
		m.put("url", "mdr.php");
		m.put("icon", R.drawable.mdr);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", HAMBURG_1_MEDIATHEK);
		m.put("url", "hamburg1.php");
		m.put("icon", R.drawable.hamburg1);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RBB_MEDIATHEK);
		m.put("url", "rbb-fernsehen.php");
		m.put("icon", R.drawable.rbb_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RBB_DOKU_REPORTAGEN);
		m.put("url", "rbb-dokuReportagen.php");
		m.put("icon", R.drawable.rbb_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_EINS);
		m.put("url", "bwEins.php");
		m.put("icon", R.drawable.bw_eins);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", PROMETHEUS);
		m.put("url", "prometheus.php");
		m.put("icon", R.drawable.prometheus);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SPIEGEL_ONLINE);
		m.put("url", "spiegel_online.html");
		m.put("icon", R.drawable.spiegel_online);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SPONGEBOB);
		m.put("url", "spongebob.html");
		m.put("icon", R.drawable.spongebob);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", KINDERKINO);
		m.put("url", "https://www.youtube.com/profile?user=kinderkino");
		// m.put("url", "kinderkino.html");
		m.put("icon", R.drawable.kinderkino);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NETZKINO);
		// m.put("url", "netzkino.html");
		m.put("url", "https://www.youtube.com/profile?user=netzkino");
		m.put("icon", R.drawable.netzkino);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MYSPASS);
		m.put("url", "myspass.html");
		m.put("icon", R.drawable.myspass);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BERG_TV);
		m.put("url", "bergischGladbach.html");
		m.put("icon", R.drawable.berg_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ANDROID_NEW_TV);
		m.put("url", "androidNewsTV.html");
		m.put("icon", R.drawable.android_news_tv);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

		// *********************************************************************************
		// * Diverse
		// *********************************************************************************
		allStationList.add(getLeerZeile());
		liveStationList.add(getLeerZeile());

		m = new HashMap<String, Object>();
		m.put("name", LAND_DIVERSE_LAENDER);
		m.put("url", "");
		m.put("icon", R.drawable.flagge_globus);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RED_BULL_TV);
		m.put("url", "redbullTV.php");
		m.put("icon", R.drawable.red_bull_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", SERVUS_TV);
		m.put("url", "servusTV.php");
		m.put("icon", R.drawable.servus_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_PUBLIC);
		m.put("url", "nasaTvPublic.php");
		m.put("icon", R.drawable.nasa_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_MEDIA);
		m.put("url", "nasaTvMedia.php");
		m.put("icon", R.drawable.nasa_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_EDUCATION);
		m.put("url", "nasaTvEducation.php");
		m.put("icon", R.drawable.nasa_tv);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", CLASSIC_CARTOONS_ACME);
		m.put("url", "acme-streaming.php");
		m.put("icon", R.drawable.acme_streaming);
		allStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_SALZBURG);
		m.put("url", "rts-salzburg.html");
		m.put("icon", R.drawable.rts_salzburg);
		allStationList.add(m);
		addToArchiveAndNotLiveStations(m);

	}

	private static HashMap<String, Object> getLeerZeile() {
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", LAND_LEER);
		m.put("url", "");
		m.put("icon", R.drawable.leer1x1);
		return m;
	}
}
