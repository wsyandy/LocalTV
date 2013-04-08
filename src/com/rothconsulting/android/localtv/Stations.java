package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;

public class Stations {

	public static final String TELE_BAERN = "Tele Bärn";
	public static final String TELE_ZUERI = "Tele Züri";
	public static final String TELE_BASEL_LIVE = "Tele Basel";
	public static final String TELE_BASEL_ARCHIV = "Tele Basel (Archiv)";
	public static final String TELE_M1_LIVE = "Tele M1";
	public static final String TELE_M1_ARCHIV = "Tele M1 (Archiv)";
	public static final String TELE_1_LIVE = "Tele 1";
	public static final String TELE_1_ARCHIV = "Tele 1 (Archiv)";
	public static final String SRF_1 = "SRF 1";
	public static final String SRF_2 = "SRF 2";
	public static final String SRF_Info = "SRF Info";
	public static final String SCHWEIZ_5 = "Schweiz 5";
	public static final String SSF = "Sport Szene Fernsehen";
	public static final String LA_TELE = "La Télé";
	public static final String CANAL_ALPHA = "Canal Alpha";
	public static final String ROUGE_TV = "Rouge TV";
	public static final String TV_105 = "105 TV";
	public static final String RTS_UN = "RTS Un";
	public static final String RTS_DEUX = "RTS Deux";
	public static final String RTS_INFO = "RTS Info";
	public static final String RSI_LA2 = "RSI La 2";
	public static final String ZERMATT_KLEIN_MATTERHORN = "Zermatt Klein Matterhorn";
	public static final String ZERMATT_SCHWARZSEE = "Zermatt Schwarzsee";
	public static final String ZERMATT_ROTHORN = "Zermatt Rothorn";
	public static final String ZERMATT_SUNNEGGA = "Zermatt Sunnegga";
	public static final String ZERMATT_TROCKENER_STEG = "Zermatt Trockener Steg";
	public static final String TVM3 = "TVM3";
	public static final String JOIZ = "joiz";

	public static final String NEUDINGS_TV = "neu dings TV";
	public static final String TV_ADMIN_CH = "Bundesverwaltung (admin.ch)";
	public static final String ALF_TV = "Alf-TV";
	public static final String JUMP_TV = "Jump-TV";
	public static final String CASH_TV = "Cash TV";
	public static final String TELE_BIELINGUE = "Tele Bielingue";
	public static final String TELE_BIELINGUE_ARCHIV = "Tele Bielingue (Archiv)";
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
	public static final String TELE_TOP_ARCHIV = "Tele Top (Archiv)";
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
	public static final String STUDENTS_TV = "Students TV";
	public static final String TELE_BLOCHER = "Tele Blocher";

	public static final String BW_FAMILY = "BW Family";
	public static final String FAMILY_TV = "Family TV";
	public static final String ALEX_BERLIN = "Alex Berlin";
	public static final String MUENCHEN_TV = "München TV";
	public static final String FRANKEN_TV = "Franken Fernsehen";
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
	public static final String DONAU_TV_LIVE = "Donau TV";
	public static final String DONAU_TV_ARCHIV = "Donau TV (Archiv)";
	public static final String OBERFRANKEN_TV = "Oberfranken TV";
	public static final String ZDF_MEDIATHEK = "ZDF Mediathek";
	public static final String KIKA_PLUS = "KIKA Plus";
	public static final String OK_KIEL_TV = "OK Kiel TV";
	public static final String DIE_MAUS = "Die Maus";
	public static final String OS1_TV = "OS1 TV";
	public static final String OSTFRIESEN_TV = "Ostfriesen TV";
	public static final String FAN_TV = "Fan TV";
	public static final String RIC_TV_KINDER = "RiC TV - Kinder";
	public static final String SALVE_TV = "Salve TV";
	public static final String ALTENBURG_TV = "Altenburg TV";
	public static final String ARD_DAS_ERSTE = "ARD Das Erste";
	public static final String DRESDEN_TV = "Dresden Fernsehen";
	public static final String IT_NEWS_TV = "IT News TV";
	public static final String MDF1 = "MDF.1";
	public static final String DAF = "DAF";
	public static final String PHOENIX = "Phoenix";

	public static final String RED_BULL_TV = "Red Bull TV";
	public static final String SERVUS_TV = "Servus TV";
	public static final String RTS_SALZBURG = "RTS Salzburg";
	public static final String ORF_TV_THEK = "ORF TVthek";
	public static final String PULS_4 = "Puls 4";
	public static final String OKTO_TV = "OKTO TV";
	public static final String W24_WIEN = "W24 Wien";
	public static final String MUEHLVIERTEL_TV = "Mühlviertel TV";
	// public static final String TIROL_TV = "Tirol TV";
	public static final String REUTTE_EINS = "Reutte Eins";

	public static final String NASA_TV_PUBLIC = "Nasa TV - Public";
	public static final String NASA_TV_MEDIA = "Nasa TV - Media";
	public static final String NASA_TV_EDUCATION = "Nasa TV - Education";
	public static final String SPACE_TV = "SpaceTV.eu";
	public static final String CLASSIC_CARTOONS_ACME = "Classic Cartoons Acme Streaming";
	public static final String DISNEY_CHANNEL = "Disney Channel";
	public static final String AL_JAZEERA_EN = "Al Jazeera English";
	public static final String BLOOMBERG_TV_USA = "Bloomberg TV USA";
	public static final String PENTAGON_CHANNEL = "The Pentagon Channel";
	public static final String UNITED_NATIONS_TV = "United Nations TV";
	public static final String CCTV_CHINA = "CCTV China";
	public static final String VISIT_X = "Visit-X TV";

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

	public static List<String> titles(Context context) {
		List<String> titles = new ArrayList<String>();
		titles.add(context.getResources().getString(R.string.emptyString));
		titles.add(context.getResources().getString(R.string.switzerland));
		titles.add(context.getResources().getString(R.string.germany));
		titles.add(context.getResources().getString(R.string.austria));
		titles.add(context.getResources().getString(R.string.otherCountries));
		return titles;
	}

	public static List<String> noTransparentBackground() {
		List<String> stations = new ArrayList<String>();
		stations.add(LEMAN_BLEU);
		stations.add(TV_ADMIN_CH);
		return stations;
	}

	public static List<String> orientationPortrait() {
		List<String> stations = new ArrayList<String>();
		stations.add(CASH_TV);
		stations.add(ALF_TV);
		stations.add(SCHAFFHAUSER_FERNSEHEN);
		stations.add(DONAU_TV_ARCHIV);
		stations.add(OS1_TV);
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
		stations.add(ORF_TV_THEK);
		stations.add(DONAU_TV_LIVE);
		stations.add(DONAU_TV_ARCHIV);
		stations.add(MUEHLVIERTEL_TV);
		stations.add(OS1_TV);
		return stations;
	}

	public static List<String> allowZoom() {
		List<String> stations = new ArrayList<String>();
		stations.add(TELE_M1_LIVE);
		stations.add(TELE_ZUERI);
		stations.add(DAS_VIERTE);
		stations.add(TELE_TOP);
		stations.add(HR);
		stations.add(PULS_4);
		stations.add(CASH_TV);
		stations.add(DAF);
		return stations;
	}

	public ArrayList<HashMap<String, Object>> getLiveStations() {
		if (liveStationList == null) {
			liveStationList = new ArrayList<HashMap<String, Object>>();
		}
		return liveStationList;
	}

	public ArrayList<HashMap<String, Object>> getArchivStations() {
		if (archivStationList == null) {
			archivStationList = new ArrayList<HashMap<String, Object>>();
		}
		return archivStationList;
	}

	public static ArrayList<HashMap<String, Object>> getAllStations() {
		if (allStationList == null) {
			allStationList = new ArrayList<HashMap<String, Object>>();
		}
		return allStationList;
	}

	public static ArrayList<String> getNotLiveStations() {
		if (notLiveList == null) {
			notLiveList = new ArrayList<String>();
		}
		return notLiveList;
	}

	private void addToArchiveAndNotLiveStations(HashMap<String, Object> map) {
		allStationList.add(map);
		archivStationList.add(map);
		notLiveList.add((String) (map.get("name")));
	}

	private void addToLiveStations(HashMap<String, Object> map) {
		allStationList.add(map);
		liveStationList.add(map);
	}

	public void init(Context context) {
		allStationList = new ArrayList<HashMap<String, Object>>();
		liveStationList = new ArrayList<HashMap<String, Object>>();
		archivStationList = new ArrayList<HashMap<String, Object>>();
		notLiveList = new ArrayList<String>();

		// *********************************************************************************
		// * Schweiz
		// *********************************************************************************
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", context.getResources().getString(R.string.switzerland));
		m.put("url", "");
		m.put("icon", R.drawable.flagge_schweiz);
		allStationList.add(m);
		liveStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BAERN);
		m.put("url", "telebaern.php");
		m.put("icon", R.drawable.tele_baern);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_ZUERI);
		m.put("url", "telezueri.html");
		m.put("icon", R.drawable.tele_zueri);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BASEL_LIVE);
		m.put("url", "telebasel.php");
		m.put("icon", R.drawable.tele_basel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BASEL_ARCHIV);
		m.put("url", "telebaselArchiv.html");
		m.put("icon", R.drawable.tele_basel);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_M1_LIVE);
		m.put("url", "telem1.php");
		m.put("icon", R.drawable.tele_m1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_M1_ARCHIV);
		m.put("url", "telem1Archiv.html");
		m.put("icon", R.drawable.tele_m1);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_1_LIVE);
		m.put("url", "tele1.php");
		m.put("icon", R.drawable.tele1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_1_ARCHIV);
		m.put("url", "tele1Archiv.html");
		m.put("icon", R.drawable.tele1);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_SUEDOSTSCHWEIZ);
		m.put("url", "telesuedostschweiz.html");
		m.put("icon", R.drawable.tele_suedostschweiz);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_SUEDOSTSCHWEIZ_ARCHIV);
		m.put("url", "telesuedostschweizArchiv.html");
		m.put("icon", R.drawable.tele_suedostschweiz);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SRF_1);
		m.put("url", "srf1.php");
		m.put("icon", R.drawable.srf_1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SRF_2);
		m.put("url", "srf2.php");
		m.put("icon", R.drawable.srf_2);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SRF_Info);
		m.put("url", "srfInfo.php");
		m.put("icon", R.drawable.srf_info);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SCHWEIZ_5);
		m.put("url", "schweiz5.php");
		m.put("icon", R.drawable.schweiz_5);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SSF);
		m.put("url", "ssf.php");
		m.put("icon", R.drawable.ssf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", JOIZ);
		m.put("url", "joiz.php");
		m.put("icon", R.drawable.joiz);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", LA_TELE);
		m.put("url", "latele.php");
		m.put("icon", R.drawable.la_tele);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CANAL_ALPHA);
		m.put("url", "canalalpha.php");
		m.put("icon", R.drawable.canal_alpha);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TVM3);
		m.put("url", "tvm3.php");
		m.put("icon", R.drawable.tvm3);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ROUGE_TV);
		m.put("url", "rougetv.php");
		m.put("icon", R.drawable.rouge_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_105);
		m.put("url", "105tv.html");
		m.put("icon", R.drawable.tv_105);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_UN);
		m.put("url", "rtsUn.php");
		m.put("icon", R.drawable.rts_un);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_DEUX);
		m.put("url", "rtsDeux.php");
		m.put("icon", R.drawable.rts_deux);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_INFO);
		m.put("url", "rtsInfo.php");
		m.put("icon", R.drawable.rts_info);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RSI_LA2);
		m.put("url", "rsiLa2.php");
		m.put("icon", R.drawable.rsi_la2);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_KLEIN_MATTERHORN);
		m.put("url", "zermattKleinMatterhorn.php");
		m.put("icon", R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_SCHWARZSEE);
		m.put("url", "zermattSchwarzsee.php");
		m.put("icon", R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_ROTHORN);
		m.put("url", "zermattRothorn.php");
		m.put("icon", R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_SUNNEGGA);
		m.put("url", "zermattSunnegga.php");
		m.put("icon", R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZERMATT_TROCKENER_STEG);
		m.put("url", "zermattTrockenerSteg.php");
		m.put("icon", R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", STUDENTS_TV);
		m.put("url", "studentsTV.php");
		m.put("icon", R.drawable.students_ch);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BLOCHER);
		m.put("url", "teleBlocher.php");
		m.put("icon", R.drawable.tele_blocher);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_OSTSCHWEIZ);
		m.put("url", "teleostschweiz.html");
		m.put("icon", R.drawable.tele_ostschweiz);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_ADMIN_CH);
		m.put("url", "tv.admin.ch.html");
		m.put("icon", R.drawable.admin_ch);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NEUDINGS_TV);
		m.put("url", "neudingsTv.php");
		m.put("icon", R.drawable.neudings_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ALF_TV);
		m.put("url", "alf.html");
		m.put("icon", R.drawable.alf);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", JUMP_TV);
		m.put("url", "jumptv.html");
		m.put("icon", R.drawable.jump_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CASH_TV);
		m.put("url", "cashTV.html");
		m.put("icon", R.drawable.cash_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BIELINGUE);
		m.put("url", "telebielingue.php");
		m.put("icon", R.drawable.telebielingue);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_BIELINGUE_ARCHIV);
		m.put("url", "telebielingue.html");
		m.put("icon", R.drawable.telebielingue);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", KANAL_9);
		m.put("url", "kanal9.html");
		m.put("icon", R.drawable.kanal9);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RRO_TV);
		m.put("url", "rroTV.html");
		m.put("icon", R.drawable.rro_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", LEMAN_BLEU);
		m.put("url", "lemanbleu.html");
		m.put("icon", R.drawable.leman_bleu);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TCH);
		m.put("url", "tch.html");
		m.put("icon", R.drawable.trailer_cinema_highlights);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", REGIO_PLUS_TV);
		m.put("url", "regioPlusTV.html");
		m.put("icon", R.drawable.regio_plus_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUERI_PLUS);
		m.put("url", "zueriplustv.html");
		m.put("icon", R.drawable.zueri_plus);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_NAPF);
		m.put("url", "telenapf.html");
		m.put("icon", R.drawable.telenapf);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", GEMEINDE_TV);
		m.put("url", "gemeindetv.html");
		m.put("icon", R.drawable.gemeindetv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SARA_MACHTS_TV);
		m.put("url", "saramachtstv.html");
		m.put("icon", R.drawable.sara_machts_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_TOP);
		m.put("url", "teletop.php");
		m.put("icon", R.drawable.tele_top);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_TOP_ARCHIV);
		m.put("url", "teletop.html");
		m.put("icon", R.drawable.tele_top);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELE_DIESSENHOFEN);
		m.put("url", "telediessenhofen.html");
		m.put("icon", R.drawable.tele_diessenhofen);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZUG_TV);
		m.put("url", "zugtv.html");
		m.put("icon", R.drawable.zug_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MURMI_TV);
		m.put("url", "murmitv.html");
		m.put("icon", R.drawable.murmi_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CANAL_29);
		m.put("url", "canal29.html");
		m.put("icon", R.drawable.canal_29);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MAX_TV);
		m.put("url", "maxTV.html");
		m.put("icon", R.drawable.max_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SCHAFFHAUSER_FERNSEHEN);
		m.put("url", "schaffhausenFernsehen.html");
		m.put("icon", R.drawable.schaffhauser_fernsehen);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SF_VIDEO_PORTAL);
		m.put("url", "sf-video-portal.html");
		m.put("icon", R.drawable.schweizer_fernsehen);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TSR_VIDEO);
		m.put("url", "tsr.html");
		m.put("icon", R.drawable.tsr);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ART_TV);
		m.put("url", "artTV.html");
		m.put("icon", R.drawable.art_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BNJ_TV);
		m.put("url", "bnjTV.html");
		m.put("icon", R.drawable.bnj_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TELEVISTA);
		m.put("url", "televista.html");
		m.put("icon", R.drawable.televista);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", GESUNDHEIT_SPRECHSTUNDE);
		m.put("url", "gesundheit-sprechstunde.html");
		m.put("icon", R.drawable.gesundheitsprechstunde);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MOTOTRSHOW_TCS);
		m.put("url", "motorshow-tcs.html");
		m.put("icon", R.drawable.motorshow_tcs);
		addToArchiveAndNotLiveStations(m);

		// *********************************************************************************
		// * Deutschland
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put("name", context.getResources().getString(R.string.germany));
		m.put("url", "");
		m.put("icon", R.drawable.flagge_deutschland);
		allStationList.add(m);
		liveStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NDR);
		m.put("url", "ndr.php");
		m.put("icon", R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", WDR);
		m.put("url", "wdr.php");
		m.put("icon", R.drawable.wdr_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", HR);
		m.put("url", "hrTV.html");
		m.put("icon", R.drawable.hr_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_FAMILY);
		m.put("url", "bwfamily.php");
		m.put("icon", R.drawable.bw_family);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", FAMILY_TV);
		m.put("url", "familytv.php");
		m.put("icon", R.drawable.family_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ALEX_BERLIN);
		m.put("url", "alexberlin.php");
		m.put("icon", R.drawable.alex_berlin);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MUENCHEN_TV);
		m.put("url", "muenchenTV.php");
		m.put("icon", R.drawable.muenchen_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", FRANKEN_TV);
		m.put("url", "frankenTV.php");
		m.put("icon", R.drawable.franken_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OBERFRANKEN_TV);
		m.put("url", "oberfrankenTV.php");
		m.put("icon", R.drawable.oberfranken_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BIBEL_TV);
		m.put("url", "bibelTV.php");
		m.put("icon", R.drawable.bibel_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", K_TV);
		m.put("url", "k-tv.php");
		m.put("icon", R.drawable.k_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ERF);
		m.put("url", "erf.php");
		m.put("icon", R.drawable.erf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TRP1_FERNSEHEN);
		m.put("url", "trp1_fernsehen.php");
		m.put("icon", R.drawable.trp1_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_SUEDBADEN);
		m.put("url", "tvSuedbaden.php");
		m.put("icon", R.drawable.tv_suedbaden);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", FOUR_SESAONS_TV);
		m.put("url", "4seasonsTV.php");
		m.put("icon", R.drawable.fourseasons);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_MAG);
		m.put("url", "massiveSportsTvMag.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_BIKE);
		m.put("url", "massiveSportsTvBike.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_RUNNING);
		m.put("url", "massiveSportsTvRunning.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_FREEZE);
		m.put("url", "massiveSportsTvFreeze.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_EXTREME);
		m.put("url", "massiveSportsTvExtreme.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MASSIVE_SPORT_SPEED);
		m.put("url", "massiveSportsTvSpeed.php");
		m.put("icon", R.drawable.massive_sports_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", L_TV);
		m.put("url", "l-tv.php");
		m.put("icon", R.drawable.ltv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OBERPFALZ_TV);
		m.put("url", "oberpfalzTV.php");
		m.put("icon", R.drawable.oberpfalz_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", AUGSBURG_TV);
		m.put("url", "augsburgTV.php");
		m.put("icon", R.drawable.augsburg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DW);
		m.put("url", "dw.php");
		m.put("icon", R.drawable.dw_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BAYERN_TV);
		m.put("url", "bayerischesFernsehen.php");
		m.put("icon", R.drawable.bayrisches_fernsehen);
		liveStationList.add(m);
		allStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_DESSAU);
		m.put("url", "okDessau.php");
		m.put("icon", R.drawable.ok_dessau);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_MAGDEBURG);
		m.put("url", "okMagdeburg.php");
		m.put("icon", R.drawable.ok_magdeburg);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_MERSEBURG);
		m.put("url", "okMerseburg.php");
		m.put("icon", R.drawable.ok_merseburg);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_SALZWEDEL);
		m.put("url", "okSalzwedel.php");
		m.put("icon", R.drawable.ok_salzwedel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_STENDAL);
		m.put("url", "okStendal.php");
		m.put("icon", R.drawable.ok_stendal);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_WERNIGERODE);
		m.put("url", "okWernigerode.php");
		m.put("icon", R.drawable.ok_wernigerode);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_WETTIN);
		m.put("url", "okWettin.php");
		m.put("icon", R.drawable.ok_wettin);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OK_KIEL_TV);
		m.put("url", "okKielTV.php");
		m.put("icon", R.drawable.ok_kiel_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", TV_HALLE);
		m.put("url", "tvHalle.php");
		m.put("icon", R.drawable.tv_halle);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RAN_1);
		m.put("url", "ran1.php");
		m.put("icon", R.drawable.ran1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ELBEKANAL);
		m.put("url", "elbekanal.php");
		m.put("icon", R.drawable.elbekanal);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", PUNKT_UM);
		m.put("url", "punktUm.php");
		m.put("icon", R.drawable.punkt_um);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RBW);
		m.put("url", "rbw.php");
		m.put("icon", R.drawable.rbw);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RFH);
		m.put("url", "rfh.php");
		m.put("icon", R.drawable.rfh);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BLK_ONLINE_TV);
		m.put("url", "blkOnlineTv.php");
		m.put("icon", R.drawable.blk_online_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DAS_VIERTE);
		m.put("url", "dasVierte.php");
		m.put("icon", R.drawable.das_vierte);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RTF_1);
		m.put("url", "rtf1.php");
		m.put("icon", R.drawable.rtf1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DRESDEN_TV);
		m.put("url", "dresdenTV.php");
		m.put("icon", R.drawable.dresden_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SACHSEN_FERNSEHEN);
		m.put("url", "sachsenFernsehen.php");
		m.put("icon", R.drawable.sachsen_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", LEIPZIG_TV);
		m.put("url", "leipzigTV.php");
		m.put("icon", R.drawable.leipzig_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", FAN_TV);
		m.put("url", "fanTV.php");
		m.put("icon", R.drawable.fan_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RIC_TV_KINDER);
		m.put("url", "ricTV.php");
		m.put("icon", R.drawable.ric_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SALVE_TV);
		m.put("url", "salveTV.php");
		m.put("icon", R.drawable.salve_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ALTENBURG_TV);
		m.put("url", "altenburgTV.php");
		m.put("icon", R.drawable.altenburg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DONAU_TV_LIVE);
		m.put("url", "donauTvLive.php");
		m.put("icon", R.drawable.donau_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DONAU_TV_ARCHIV);
		m.put("url", "donauTvArchiv.php");
		m.put("icon", R.drawable.donau_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", _3_SAT);
		m.put("url", "3sat.html");
		m.put("icon", R.drawable.drei_sat);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", KIKA_PLUS);
		m.put("url", "kikaPlus.php");
		m.put("icon", R.drawable.kika_plus);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DIE_MAUS);
		m.put("url", "dieMaus.php");
		m.put("icon", R.drawable.die_maus);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ARD_DAS_ERSTE);
		m.put("url", "ardDasErste.php");
		m.put("icon", R.drawable.ard_das_erste);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ARD_MEDIATHEK);
		m.put("url", "ardMediathek.php");
		m.put("icon", R.drawable.ard_mediathek);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ZDF_MEDIATHEK);
		m.put("url", "zdfMediathek.php");
		m.put("icon", R.drawable.zdf_mediathek);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SWR_MEDIATHEK);
		m.put("url", "swr.php");
		m.put("icon", R.drawable.swr);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MDR_MEDIATHEK);
		m.put("url", "mdr.php");
		m.put("icon", R.drawable.mdr);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", HAMBURG_1_MEDIATHEK);
		m.put("url", "hamburg1.php");
		m.put("icon", R.drawable.hamburg1);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RBB_MEDIATHEK);
		m.put("url", "rbb-fernsehen.php");
		m.put("icon", R.drawable.rbb_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RBB_DOKU_REPORTAGEN);
		m.put("url", "rbb-dokuReportagen.php");
		m.put("icon", R.drawable.rbb_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BW_EINS);
		m.put("url", "bwEins.php");
		m.put("icon", R.drawable.bw_eins);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", PROMETHEUS);
		m.put("url", "prometheus.php");
		m.put("icon", R.drawable.prometheus);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SPIEGEL_ONLINE);
		m.put("url", "spiegel_online.html");
		m.put("icon", R.drawable.spiegel_online);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SPONGEBOB);
		m.put("url", "spongebob.html");
		m.put("icon", R.drawable.spongebob);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", KINDERKINO);
		m.put("url", "https://www.youtube.com/profile?user=kinderkino");
		// m.put("url", "kinderkino.html");
		m.put("icon", R.drawable.kinderkino);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NETZKINO);
		// m.put("url", "netzkino.html");
		m.put("url", "https://www.youtube.com/profile?user=netzkino");
		m.put("icon", R.drawable.netzkino);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MYSPASS);
		m.put("url", "myspass.html");
		m.put("icon", R.drawable.myspass);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BERG_TV);
		m.put("url", "bergischGladbach.html");
		m.put("icon", R.drawable.berg_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ANDROID_NEW_TV);
		m.put("url", "androidNewsTV.html");
		m.put("icon", R.drawable.android_news_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OS1_TV);
		m.put("url", "os1TV.php");
		m.put("icon", R.drawable.os1_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OSTFRIESEN_TV);
		m.put("url", "ostfriesenTV.php");
		m.put("icon", R.drawable.ostfriesen_tv);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", IT_NEWS_TV);
		m.put("url", "itNewsTV.php");
		m.put("icon", R.drawable.it_news_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DAF);
		m.put("url", "daf.php");
		m.put("icon", R.drawable.daf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", PHOENIX);
		m.put("url", "phoenix.php");
		m.put("icon", R.drawable.phoenix);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MDF1);
		m.put("url", "mdf1.php");
		m.put("icon", R.drawable.mdf1);
		addToArchiveAndNotLiveStations(m);

		// *********************************************************************************
		// * Österreich
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put("name", context.getResources().getString(R.string.austria));
		m.put("url", "");
		m.put("icon", R.drawable.flagge_oesterreich);
		allStationList.add(m);
		archivStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", RED_BULL_TV);
		m.put("url", "redbullTV.php");
		m.put("icon", R.drawable.red_bull_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SERVUS_TV);
		m.put("url", "servusTV.php");
		m.put("icon", R.drawable.servus_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", OKTO_TV);
		m.put("url", "oktoTV.php");
		m.put("icon", R.drawable.okto_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", W24_WIEN);
		m.put("url", "w24wien.php");
		m.put("icon", R.drawable.w24_wien);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", MUEHLVIERTEL_TV);
		m.put("url", "muehlviertelTV.php");
		m.put("icon", R.drawable.muehlviertel_tv);
		addToLiveStations(m);

		// m = new HashMap<String, Object>();
		// m.put("name", TIROL_TV);
		// m.put("url", "tirolTV.php");
		// m.put("icon", R.drawable.tirol_tv);
		// addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", REUTTE_EINS);
		m.put("url", "reutteEins.php");
		m.put("icon", R.drawable.reutte_eins);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", ORF_TV_THEK);
		m.put("url", "orf-tvthek.php");
		m.put("icon", R.drawable.orf_tvthek);
		addToLiveStations(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", PULS_4);
		m.put("url", "puls4.php");
		m.put("icon", R.drawable.puls_4);
		addToArchiveAndNotLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", RTS_SALZBURG);
		m.put("url", "rts-salzburg.html");
		m.put("icon", R.drawable.rts_salzburg);
		addToArchiveAndNotLiveStations(m);

		// *********************************************************************************
		// * Diverse
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put("name", context.getResources().getString(R.string.otherCountries));
		m.put("url", "");
		m.put("icon", R.drawable.flagge_globus);
		allStationList.add(m);
		archivStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_PUBLIC);
		m.put("url", "nasaTvPublic.php");
		m.put("icon", R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_MEDIA);
		m.put("url", "nasaTvMedia.php");
		m.put("icon", R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", NASA_TV_EDUCATION);
		m.put("url", "nasaTvEducation.php");
		m.put("icon", R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", SPACE_TV);
		m.put("url", "space-itv.php");
		m.put("icon", R.drawable.space_itv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CLASSIC_CARTOONS_ACME);
		m.put("url", "acme-streaming.php");
		m.put("icon", R.drawable.acme_streaming);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", AL_JAZEERA_EN);
		m.put("url", "alJazeeraEnglish.php");
		m.put("icon", R.drawable.al_jazeera);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", BLOOMBERG_TV_USA);
		m.put("url", "bloombergTV.php");
		m.put("icon", R.drawable.bloomberg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", PENTAGON_CHANNEL);
		m.put("url", "pentagonChannel.php");
		m.put("icon", R.drawable.pentagon_channel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", UNITED_NATIONS_TV);
		m.put("url", "unTV.php");
		m.put("icon", R.drawable.un_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", CCTV_CHINA);
		m.put("url", "cctv_china.php");
		m.put("icon", R.drawable.cctv_china);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", VISIT_X);
		m.put("url", "visit-x-TV.php");
		m.put("icon", R.drawable.visit_x_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put("name", DISNEY_CHANNEL);
		m.put("url", "disney.php");
		m.put("icon", R.drawable.disney_channel);
		addToArchiveAndNotLiveStations(m);

	}

	private static HashMap<String, Object> getLeerZeile(Context context) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("name", context.getResources().getString(R.string.emptyString));
		m.put("url", "");
		m.put("icon", R.drawable.leer1x1);
		return m;
	}
}
