package com.rothconsulting.android.localtv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;

public class Stations {

	public static final String TAG = "Stations";

	public static final String streamFile = "_streams.php?stationName=";
	public static final String archiveFile = "_archives.php?stationName=";
	public static final String URL = "url";
	public static final String NAME = "name";
	public static final String ICON = "icon";
	public static final String TYP = "typ";

	public static final String TELE_BAERN = "Tele Bärn";
	public static final String TELE_BAERN_ARCHIV = "Tele Bärn Archiv";
	public static final String TELE_ZUERI = "Tele Züri";
	public static final String TELE_ZUERI_ARCHIV = "Tele Züri Archiv";
	public static final String TELE_BASEL_LIVE = "Tele Basel";
	public static final String TELE_BASEL_ARCHIV = "Tele Basel Archiv";
	public static final String TELE_M1_LIVE = "Tele M1";
	public static final String TELE_M1_ARCHIV = "Tele M1 Archiv";
	public static final String TELE_1 = "Tele 1";
	public static final String TELE_1_ARCHIV = "Tele 1 Archiv";
	public static final String SRF_1 = "SRF 1";
	public static final String SRF_2 = "SRF 2";
	public static final String SRF_INFO = "SRF Info";
	public static final String SCHWEIZ_5 = "Schweiz 5";
	public static final String LA_TELE = "La Télé";
	public static final String CANAL_ALPHA_JURA_BERNOISE = "Canal Alpha (Jura – Jura bernois)";
	public static final String CANAL_ALPHA_NEUCHATEL_YVERDON = "Canal Alpha (Neuchâtel – District d’Yverdon)";
	public static final String ROUGE_TV = "Rouge TV";
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
	public static final String RADIO_PILATUS = "Radio Pilatus";
	public static final String PILATUS_BEATZ = "Pilatus Beatz";
	public static final String JOIZ = "joiz";
	public static final String CH_TV = "CH TV";
	public static final String FCZ_TV = "FCZ TV";
	public static final String YB_TV_CHANNEL = "YB TV Channel";

	public static final String NEUDINGS_TV = "neu dings TV";
	public static final String TV_ADMIN_CH = "Bundesverwaltung (admin.ch)";
	public static final String ALF_TV = "Alf-TV";
	public static final String JUMP_TV = "Jump-TV";
	public static final String TELE_BIELINGUE = "Tele Bielingue";
	public static final String TELE_BIELINGUE_ARCHIV = "Tele Bielingue Archiv";
	public static final String KANAL_9 = "Kanal 9";
	public static final String RRO_TV = "RRO TV";
	public static final String FC_SION = "FC Sion WebTV";
	public static final String LEMAN_BLEU = "Léman bleu";
	public static final String TELE_OSTSCHWEIZ = "Tele Ostschweiz";
	public static final String TELE_OSTSCHWEIZ_ARCHIV = "Tele Ostschweiz Archiv";
	public static final String TELE_SUEDOSTSCHWEIZ = "Tele Südostschweiz";
	public static final String TELE_SUEDOSTSCHWEIZ_ARCHIV = "Tele Südostschweiz Archiv";
	public static final String TCH = "Trailer Cinema Highlights";
	public static final String REGIO_PLUS_TV = "Regio TV Plus";
	public static final String ZUERI_PLUS = "Züri Plus";
	public static final String TELE_NAPF = "Tele Napf";
	public static final String GEMEINDE_TV = "Gemeinde TV";
	public static final String SARA_MACHTS_TV = "Sara machts TV";
	public static final String TELE_TOP = "Tele Top";
	public static final String TELE_TOP_ARCHIV = "Tele Top Archiv";
	public static final String TELE_DIESSENHOFEN = "Tele Diessenhofen";
	public static final String ZUG_TV = "Zug TV";
	public static final String MURMI_TV = "Murmi TV";
	public static final String CANAL_29 = "Canal 29";
	public static final String MAX_TV = "max tv";
	public static final String SCHAFFHAUSER_FERNSEHEN = "Schaffhauser Fernsehen";
	public static final String SRF_PLAYER = "SRF Player Archiv";
	public static final String ART_TV = "art tv";
	public static final String BNJ_TV = "bnj.tv";
	public static final String RTS_VIDEO = "RTS video";
	public static final String TELEVISTA = "Televista";
	public static final String STUDENTS_TV = "Students TV";
	public static final String TELE_BLOCHER = "Tele Blocher";
	public static final String TELE_TICINO = "Tele Ticino";

	public static final String BW_FAMILY = "BW Family";
	public static final String FAMILY_TV = "Family TV";
	public static final String ALEX_BERLIN = "Alex Berlin";
	public static final String MUENCHEN_TV = "München TV";
	public static final String FRANKEN_TV = "Franken Fernsehen";
	public static final String TRP1_FERNSEHEN = "TRP1 Fernsehen";
	public static final String BIBEL_TV = "Bibel TV";
	public static final String K_TV = "K-TV (Kephas Kirche Kultur)";
	public static final String ERF = "ERF";
	public static final String HOPE_TV = "Hope TV";
	public static final String TV_SUEDBADEN = "TV Südbaden";
	public static final String NDR = "NDR";
	public static final String NDR_HAMBURG = "NDR Hamburg";
	public static final String NDR_MV = "NDR Meklenburg Vorpommern";
	public static final String NDR_SH = "NDR Schleswig Holstein";
	public static final String NDR_NS = "NDR Niedersachsen";
	public static final String WDR = "WDR";
	public static final String WDR_LOKALZEIT_KOELN = "WDR Lokalzeit Köln";
	public static final String HR = "HR";
	public static final String MDR_SACHSEN = "MDR Sachsen";
	public static final String MDR_SACHSEN_ANH = "MDR Sachsen Anhalt";
	public static final String MDR_THUERINGEN = "MDR Thüringen";
	public static final String MDR_PLUS = "MDR+";
	public static final String SPIEGEL_ONLINE = "Spiegel Online";
	public static final String SPONGEBOB = "Spongebob";
	public static final String NETZKINO = "Netzkino";
	public static final String KINDERKINO = "Kinderkino";
	public static final String MYSPASS = "myspass.de";
	public static final String RBB_BERLIN = "RBB Berlin";
	public static final String RBB_BRANDENBURG = "RBB Brandenburg";
	public static final String RBB_MEDIATHEK = "RBB Mediathek";
	public static final String RBB_DOKU_REPORTAGEN = "RBB Doku Reportagen";
	public static final String FOUR_SESAONS_TV = "4 seasons TV";
	public static final String L_TV = "L TV";
	public static final String _3_SAT = "3 sat";
	public static final String OBERPFALZ_TV = "Oberpfalz TV";
	public static final String AUGSBURG_TV = "Augsburg TV";
	public static final String BERG_TV = "Bergisch Gladbach TV";
	public static final String ANDROID_NEW_TV = "Android News TV";
	public static final String DW = "DW - Deutsche Welle";
	public static final String SACHSEN_FERNSEHEN = "Sachsen Fernsehen";
	public static final String DRESDEN_TV = "Dresden Fernsehen";
	public static final String LEIPZIG_TV = "Leipzig Fernsehen";
	public static final String BAYERN_TV = "Bayerisches Fernsehen";
	public static final String BAYERN_TV_MEDIATHEK = "Bayerisches Fernsehen - Mediathek";
	public static final String PEARL_TV = "Pearl TV";
	public static final String QVC = "QVC";
	public static final String GIPSY_TV = "GIPSY TV";
	public static final String OK_54 = "OK 54 Trier";
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
	public static final String HAMBURG_1 = "Hamburg1";
	public static final String HAMBURG_1_MEDIATHEK = "Hamburg1 Mediathek";
	public static final String DONAU_TV_LIVE = "Donau TV";
	public static final String DONAU_TV_ARCHIV = "Donau TV Archiv";
	public static final String OBERFRANKEN_TV = "Oberfranken TV";
	public static final String KIKA_PLUS = "KIKA Plus";
	public static final String OK_KIEL_TV = "OK Kiel TV";
	public static final String DIE_MAUS = "Die Maus";
	public static final String OS1_TV = "OS1 TV";
	public static final String OSTFRIESEN_TV = "Ostfriesen TV";
	public static final String FAN_TV = "Fan TV";
	public static final String OEINS_OLDENBURG = "Oldenburg eins";
	public static final String NRW_TV = "NRW TV";
	public static final String RIC_TV_KINDER = "RiC TV - Kinder";
	public static final String SALVE_TV = "Salve TV";
	public static final String ALTENBURG_TV = "Altenburg TV";
	public static final String ARD_DAS_ERSTE = "ARD Das Erste";
	public static final String ARD_DAS_ERSTE_TAGESSCHAU = "ARD Das Erste Tagesschau";
	public static final String ARD_MEDIATHEK = "ARD Mediathek";
	public static final String ZDF = "ZDF Live";
	public static final String ZDF_NEO = "ZDF Neo";
	public static final String ZDF_INFO = "ZDF Info";
	public static final String ZDF_KULTUR = "ZDF Kultur";
	public static final String ZDF_MEDIATHEK = "ZDF Mediathek";
	public static final String IT_NEWS_TV = "IT News TV";
	public static final String MDF1 = "MDF.1";
	public static final String DAF = "DAF";
	public static final String PHOENIX = "Phoenix";
	public static final String BUNDESTAG_1 = "Bundestag TV 1";
	public static final String BUNDESTAG_2 = "Bundestag TV 2";
	public static final String BADEN_TV = "Baden TV";
	public static final String TV_AKTUELL = "TVAktuell";
	// public static final String LIGHT_CHANNEL_TV = "Light Channel TV";
	public static final String TV_TOURING_SCHWEINFURT = "TV Touring Schweinfurt";
	public static final String TV_TOURING_WUERZBURG = "TV Touring Würzburg";
	public static final String ASTRO_TV = "Astro TV";
	public static final String SPORT_1 = "Sport 1";
	public static final String CENTER_TV_KOELN = "Center TV - Köln";
	public static final String CENTER_TV_MUENSTER = "Center TV - Münster";
	public static final String DELUXE_MUSIC = "Deluxe Music";
	// public static final String MELODIE_EXPRESS = "Melodie Express";
	// public static final String EURONEWS = "Euronews";

	public static final String ORF_1_HQ = "ORF 1 HQ";
	public static final String ORF_2_HQ = "ORF 2 HQ";
	public static final String ORF_2_EUROPE_HQ = "ORF 2 Europe HQ";
	public static final String ORF_3_HQ = "ORF 3 HQ";
	public static final String ORF_SPORT_HQ = "ORF Sport+ HQ";
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
	public static final String AUSTRIA_24_TV = "Austria 24 TV";

	public static final String SUEDTIROL_TV = "Südtirol TV";

	public static final String NASA_TV_PUBLIC = "Nasa TV - Public";
	public static final String NASA_TV_MEDIA = "Nasa TV - Media";
	public static final String NASA_TV_EDUCATION = "Nasa TV - Education";
	public static final String SPACE_TV = "SpaceTV.eu";
	public static final String ESA_TV = "ESA TV";
	public static final String CLASSIC_CARTOONS_ACME = "Classic Cartoons Acme Streaming";
	public static final String DISNEY_CHANNEL = "Disney Channel";
	public static final String AL_JAZEERA_EN = "Al Jazeera English";
	public static final String BLOOMBERG_TV_USA = "Bloomberg TV USA";
	public static final String BLOOMBERG_TV_ASIA = "Bloomberg TV ASIA";
	public static final String BLOOMBERG_TV_EU = "Bloomberg TV EU";
	public static final String PENTAGON_CHANNEL = "The Pentagon Channel";
	public static final String UNITED_NATIONS_TV = "United Nations TV";
	public static final String CCTV_CHINA = "CCTV China";
	public static final String VISIT_X = "Visit-X TV";

	private static ArrayList<HashMap<String, Object>> liveStationList;
	private static ArrayList<HashMap<String, Object>> archivStationList;
	private static ArrayList<HashMap<String, Object>> allStationList;
	private static List<String> allowZoomStations = new ArrayList<String>();

	public Stations() {
		liveStationList = new ArrayList<HashMap<String, Object>>();
		archivStationList = new ArrayList<HashMap<String, Object>>();
		allStationList = new ArrayList<HashMap<String, Object>>();
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
		stations.add(TV_ADMIN_CH);
		stations.add(TELE_OSTSCHWEIZ_ARCHIV);
		return stations;
	}

	public static List<String> orientationPortrait() {
		List<String> stations = new ArrayList<String>();
		stations.add(ALF_TV);
		stations.add(TELE_NAPF);
		stations.add(SCHAFFHAUSER_FERNSEHEN);
		stations.add(DONAU_TV_ARCHIV);
		stations.add(OS1_TV);
		stations.add(ORF_TV_THEK);
		stations.add(MDR_MEDIATHEK);
		stations.add(ZDF_MEDIATHEK);
		stations.add(ARD_MEDIATHEK);
		stations.add(ARD_DAS_ERSTE_TAGESSCHAU);
		stations.add(FCZ_TV);
		stations.add(YB_TV_CHANNEL);
		stations.add(SPIEGEL_ONLINE);
		stations.add(BAYERN_TV_MEDIATHEK);

		return stations;
	}

	public static List<String> allowZoomList() {
		if (allowZoomStations == null) {
			allowZoomStations = new ArrayList<String>();
		}
		allowZoomStations.add(TELE_M1_LIVE);
		allowZoomStations.add(DAS_VIERTE);
		allowZoomStations.add(TELE_TOP);
		allowZoomStations.add(PHOENIX);
		allowZoomStations.add(AUSTRIA_24_TV);
		allowZoomStations.add(RSI_LA2);
		allowZoomStations.add(BAYERN_TV);
		allowZoomStations.add(MUEHLVIERTEL_TV);
		return allowZoomStations;
	}

	public static ArrayList<HashMap<String, Object>> getLiveStations() {
		if (liveStationList == null) {
			liveStationList = new ArrayList<HashMap<String, Object>>();
		}
		return liveStationList;
	}

	public static ArrayList<HashMap<String, Object>> getArchivStations() {
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

	private static void addToArchiveStations(HashMap<String, Object> map) {
		map.put(TYP, R.drawable.globe);
		allStationList.add(map);
		archivStationList.add(map);
		String stationName = "" + map.get(NAME);
		allowZoomList().add(stationName);
	}

	private static void addToLiveStations(HashMap<String, Object> map) {
		Object url = map.get(URL);
		Util.log(TAG, "" + map.get(NAME) + " / URL = " + url);
		if (url != null) {
			allStationList.add(map);
			liveStationList.add(map);
		}
	}

	private static void setLiveUrl(HashMap<String, Object> m, String flashUrl, String noFlashUrl) {
		Context context = CustomApplication.getCustomAppContext();
		String flashOption = Settings.getFlashOption(context);
		Util.log(TAG, "flashOption = " + flashOption);

		if ((flashOption.equals(context.getString(R.string.flashDoNotUse)) || !Util.isBorderOver()) && noFlashUrl == null) {
			return;
		}

		if ((flashOption.equals(context.getString(R.string.flashAlways)) && flashUrl != null)
				|| (flashOption.equals(context.getString(R.string.flashWhenNoOther)) && flashUrl != null && noFlashUrl == null)) {
			m.put(URL, flashUrl);
			m.put(TYP, R.drawable.flash);
		} else if (noFlashUrl != null) {
			m.put(URL, streamFile + noFlashUrl);
			m.put(TYP, R.drawable.tv);
		}
	}

	public static void init(Context context) {
		allStationList = new ArrayList<HashMap<String, Object>>();
		liveStationList = new ArrayList<HashMap<String, Object>>();
		archivStationList = new ArrayList<HashMap<String, Object>>();

		// *********************************************************************************
		// * Schweiz
		// *********************************************************************************
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put(NAME, context.getResources().getString(R.string.switzerland));
		m.put(URL, "");
		m.put(ICON, R.drawable.flagge_schweiz);
		allStationList.add(m);
		liveStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BAERN);
		setLiveUrl(m, "telebaern.php", "Tele-Baern");
		m.put(ICON, R.drawable.tele_baern);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BAERN_ARCHIV);
		m.put(URL, archiveFile + "Tele-Baern-Archiv");
		m.put(ICON, R.drawable.tele_baern);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_ZUERI);
		setLiveUrl(m, "telezueri.php", "Tele-Zueri");
		m.put(ICON, R.drawable.tele_zueri);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_ZUERI_ARCHIV);
		m.put(URL, archiveFile + "Tele-Zueri-Archiv");
		m.put(ICON, R.drawable.tele_zueri);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BASEL_LIVE);
		setLiveUrl(m, "telebasel.php", "Tele-Basel");
		m.put(ICON, R.drawable.tele_basel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BASEL_ARCHIV);
		m.put(URL, archiveFile + "Tele-Basel-Archiv");
		m.put(ICON, R.drawable.tele_basel);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_1);
		setLiveUrl(m, "tele1.php", "Tele-1");
		m.put(ICON, R.drawable.tele1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_1_ARCHIV);
		m.put(URL, archiveFile + "Tele-1-Archiv");
		m.put(ICON, R.drawable.tele1);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_M1_LIVE);
		setLiveUrl(m, "telem1.php", null);
		m.put(ICON, R.drawable.tele_m1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_M1_ARCHIV);
		m.put(URL, archiveFile + "Tele-M1-Archiv");
		m.put(ICON, R.drawable.tele_m1);
		addToArchiveStations(m);

		if (!Util.isPlatformBelow_4_0()) {
			m = new HashMap<String, Object>();
			m.put(NAME, TELE_OSTSCHWEIZ);
			setLiveUrl(m, null, "Tele-Ostschweiz");
			m.put(ICON, R.drawable.tele_ostschweiz);
			addToLiveStations(m);
		}
		m = new HashMap<String, Object>();
		m.put(NAME, TELE_OSTSCHWEIZ_ARCHIV);
		m.put(URL, archiveFile + "Tele-Ostschw-Archiv");
		m.put(ICON, R.drawable.tele_ostschweiz);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_SUEDOSTSCHWEIZ);
		setLiveUrl(m, "telesuedostschweiz.html", null);
		m.put(ICON, R.drawable.tele_suedostschweiz);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_SUEDOSTSCHWEIZ_ARCHIV);
		m.put(URL, archiveFile + "Tele-Suedostschw");
		m.put(ICON, R.drawable.tele_suedostschweiz);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_TOP);
		setLiveUrl(m, "teletop.php", null);
		m.put(ICON, R.drawable.tele_top);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_TOP_ARCHIV);
		m.put(URL, archiveFile + "Tele-Top-Archiv");
		m.put(ICON, R.drawable.tele_top);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_TICINO);
		setLiveUrl(m, null, "Tele-Ticino");
		m.put(ICON, R.drawable.tele_ticino);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SRF_1);
		setLiveUrl(m, "srf1.php", "SRF-1");
		m.put(ICON, R.drawable.srf_1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SRF_2);
		setLiveUrl(m, "srf2.php", "SRF-2");
		m.put(ICON, R.drawable.srf_2);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SRF_INFO);
		setLiveUrl(m, "srfInfo.php", "SRF-info");
		m.put(ICON, R.drawable.srf_info);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SRF_PLAYER);
		m.put(URL, archiveFile + "SRF-Player");
		m.put(ICON, R.drawable.srf_player);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SCHWEIZ_5);
		setLiveUrl(m, "schweiz5.php", null);
		m.put(ICON, R.drawable.schweiz_5);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, JOIZ);
		setLiveUrl(m, "joiz.php", null);
		m.put(ICON, R.drawable.joiz);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BIELINGUE);
		setLiveUrl(m, "telebielingue.php", "Tele-Bielingue");
		m.put(ICON, R.drawable.telebielingue);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BIELINGUE_ARCHIV);
		m.put(URL, archiveFile + "Tele-Bielingue");
		m.put(ICON, R.drawable.telebielingue);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, LA_TELE);
		setLiveUrl(m, "latele.php", "La-Tele");
		m.put(ICON, R.drawable.la_tele);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CANAL_ALPHA_NEUCHATEL_YVERDON);
		setLiveUrl(m, "canalalpha.php", "Canal-Alpha-NE");
		m.put(ICON, R.drawable.canal_alpha);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CANAL_ALPHA_JURA_BERNOISE);
		setLiveUrl(m, "canalalpha_ju_be.php", "Canal-Alpha-JU");
		m.put(ICON, R.drawable.canal_alpha);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, KANAL_9);
		setLiveUrl(m, "kanal9.php", "Canal-9");
		m.put(ICON, R.drawable.kanal9);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TVM3);
		setLiveUrl(m, "tvm3.php", "TVM3");
		m.put(ICON, R.drawable.tvm3);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RADIO_PILATUS);
		setLiveUrl(m, null, "Radio-Pilatus");
		m.put(ICON, R.drawable.radio_pilatus);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PILATUS_BEATZ);
		setLiveUrl(m, null, "Pilatus-Beatz");
		m.put(ICON, R.drawable.radio_pilatus);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ROUGE_TV);
		setLiveUrl(m, "rougetv.php", "Rouge-TV");
		m.put(ICON, R.drawable.rouge_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTS_UN);
		setLiveUrl(m, "rtsUn.php", "RTS-un");
		m.put(ICON, R.drawable.rts_un);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTS_DEUX);
		setLiveUrl(m, "rtsDeux.php", "RTS-deux");
		m.put(ICON, R.drawable.rts_deux);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTS_INFO);
		setLiveUrl(m, "rtsInfo.php", "RTS-info");
		m.put(ICON, R.drawable.rts_info);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, LEMAN_BLEU);
		setLiveUrl(m, "lemanbleu.php", null);
		m.put(ICON, R.drawable.leman_bleu);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RSI_LA2);
		setLiveUrl(m, "rsiLa2.php", null);
		m.put(ICON, R.drawable.rsi_la2);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZERMATT_KLEIN_MATTERHORN);
		setLiveUrl(m, "zermattKleinMatterhorn.php", null);
		m.put(ICON, R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZERMATT_SCHWARZSEE);
		setLiveUrl(m, "zermattSchwarzsee.php", null);
		m.put(ICON, R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZERMATT_ROTHORN);
		setLiveUrl(m, "zermattRothorn.php", null);
		m.put(ICON, R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZERMATT_SUNNEGGA);
		setLiveUrl(m, "zermattSunnegga.php", null);
		m.put(ICON, R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZERMATT_TROCKENER_STEG);
		setLiveUrl(m, "zermattTrockenerSteg.php", null);
		m.put(ICON, R.drawable.zermatt);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, STUDENTS_TV);
		m.put(URL, archiveFile + "Students-TV");
		m.put(ICON, R.drawable.students_ch);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_BLOCHER);
		m.put(URL, archiveFile + "Tele-Blocher");
		m.put(ICON, R.drawable.tele_blocher);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_ADMIN_CH);
		m.put(URL, archiveFile + "tv.admin.ch");
		m.put(ICON, R.drawable.admin_ch);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NEUDINGS_TV);
		m.put(URL, archiveFile + "Neudings-TV");
		m.put(ICON, R.drawable.neudings_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ALF_TV);
		m.put(URL, archiveFile + "ALF-TV");
		m.put(ICON, R.drawable.alf);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, JUMP_TV);
		m.put(URL, "jumptv.html");
		m.put(ICON, R.drawable.jump_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RRO_TV);
		m.put(URL, "rroTV.php");
		m.put(ICON, R.drawable.rro_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FC_SION);
		m.put(URL, archiveFile + "FC-Sion");
		m.put(ICON, R.drawable.fc_sion);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TCH);
		m.put(URL, "tch.html");
		m.put(ICON, R.drawable.trailer_cinema_highlights);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, REGIO_PLUS_TV);
		m.put(URL, "regioPlusTV.html");
		m.put(ICON, R.drawable.regio_plus_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZUERI_PLUS);
		m.put(URL, "zueriplustv.html");
		m.put(ICON, R.drawable.zueri_plus);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_NAPF);
		m.put(URL, "telenapf.html");
		m.put(ICON, R.drawable.telenapf);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, GEMEINDE_TV);
		m.put(URL, "gemeindetv.html");
		m.put(ICON, R.drawable.gemeindetv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SARA_MACHTS_TV);
		m.put(URL, "saramachtstv.html");
		m.put(ICON, R.drawable.sara_machts_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELE_DIESSENHOFEN);
		m.put(URL, "telediessenhofen.html");
		m.put(ICON, R.drawable.tele_diessenhofen);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZUG_TV);
		m.put(URL, "zugtv.html");
		m.put(ICON, R.drawable.zug_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MURMI_TV);
		m.put(URL, "murmitv.html");
		m.put(ICON, R.drawable.murmi_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CANAL_29);
		m.put(URL, "canal29.html");
		m.put(ICON, R.drawable.canal_29);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MAX_TV);
		m.put(URL, "maxTV.html");
		m.put(ICON, R.drawable.max_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SCHAFFHAUSER_FERNSEHEN);
		m.put(URL, "schaffhausenFernsehen.html");
		m.put(ICON, R.drawable.schaffhauser_fernsehen);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTS_VIDEO);
		m.put(URL, "rts.php");
		m.put(ICON, R.drawable.rts);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ART_TV);
		m.put(URL, "artTV.html");
		m.put(ICON, R.drawable.art_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BNJ_TV);
		m.put(URL, "bnjTV.html");
		m.put(ICON, R.drawable.bnj_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TELEVISTA);
		m.put(URL, "televista.html");
		m.put(ICON, R.drawable.televista);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CH_TV);
		m.put(URL, "chTV.php");
		m.put(ICON, R.drawable.ch_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FCZ_TV);
		m.put(URL, "fczTV.php");
		m.put(ICON, R.drawable.fcz_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, YB_TV_CHANNEL);
		m.put(URL, "ybChannel.php");
		m.put(ICON, R.drawable.yb_tv_channel);
		addToArchiveStations(m);

		// *********************************************************************************
		// * Deutschland
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put(NAME, context.getResources().getString(R.string.germany));
		m.put(URL, "");
		m.put(ICON, R.drawable.flagge_deutschland);
		allStationList.add(m);
		liveStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NDR);
		setLiveUrl(m, "ndr.php", null);
		m.put(ICON, R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NDR_HAMBURG);
		setLiveUrl(m, "ndr.php", "NDR-Hamburg");
		m.put(ICON, R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NDR_MV);
		setLiveUrl(m, null, "NDR-MV");
		m.put(ICON, R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NDR_NS);
		setLiveUrl(m, null, "NDR-NS");
		m.put(ICON, R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NDR_SH);
		setLiveUrl(m, null, "NDR-SH");
		m.put(ICON, R.drawable.ndr_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, WDR);
		setLiveUrl(m, "wdr.php", "WDR");
		m.put(ICON, R.drawable.wdr_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, WDR_LOKALZEIT_KOELN);
		m.put(URL, archiveFile + "Lokalzeit-Koeln");
		m.put(ICON, R.drawable.wdr_fernsehen);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDR_SACHSEN);
		setLiveUrl(m, null, "MDR-Sachsen");
		m.put(ICON, R.drawable.mdr);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDR_SACHSEN_ANH);
		setLiveUrl(m, null, "MDR-Sachsen-A");
		m.put(ICON, R.drawable.mdr);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDR_THUERINGEN);
		setLiveUrl(m, null, "MDR-Thuringen");
		m.put(ICON, R.drawable.mdr);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDR_PLUS);
		setLiveUrl(m, null, "MDR-Plus");
		m.put(ICON, R.drawable.mdr);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDR_MEDIATHEK);
		setLiveUrl(m, null, "MDR-Mediathek");
		m.put(ICON, R.drawable.mdr);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SWR_MEDIATHEK);
		setLiveUrl(m, null, "SWR-Mediathek");
		m.put(ICON, R.drawable.swr);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, HR);
		setLiveUrl(m, "hrTV.php", null);
		m.put(ICON, R.drawable.hr_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BW_FAMILY);
		setLiveUrl(m, "bwfamily.php", "BW-Family-TV");
		m.put(ICON, R.drawable.bw_family);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FAMILY_TV);
		setLiveUrl(m, "familytv.php", null);
		m.put(ICON, R.drawable.family_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ALEX_BERLIN);
		setLiveUrl(m, "alexberlin.php", "Alex-Berlin");
		m.put(ICON, R.drawable.alex_berlin);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MUENCHEN_TV);
		setLiveUrl(m, "muenchenTV.php", null);
		m.put(ICON, R.drawable.muenchen_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FRANKEN_TV);
		setLiveUrl(m, "frankenTV.php", "Franken-TV");
		m.put(ICON, R.drawable.franken_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OBERFRANKEN_TV);
		setLiveUrl(m, "oberfrankenTV.php", "TV-OBERFRANKEN1");
		m.put(ICON, R.drawable.oberfranken_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_AKTUELL);
		setLiveUrl(m, "tvAktuell.php", "TV-AKTUELL");
		m.put(ICON, R.drawable.tvaktuell);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BIBEL_TV);
		setLiveUrl(m, "bibelTV.php", null);
		m.put(ICON, R.drawable.bibel_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, K_TV);
		setLiveUrl(m, "k-tv.php", null);
		m.put(ICON, R.drawable.k_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ERF);
		setLiveUrl(m, "erf.php", null);
		m.put(ICON, R.drawable.erf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, HOPE_TV);
		setLiveUrl(m, "hopeTV.php", null);
		m.put(ICON, R.drawable.hope_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TRP1_FERNSEHEN);
		setLiveUrl(m, "trp1_fernsehen.php", "TRP1");
		m.put(ICON, R.drawable.trp1_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_SUEDBADEN);
		setLiveUrl(m, "tvSuedbaden.php", "TV-Suedbaden");
		m.put(ICON, R.drawable.tv_suedbaden);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BADEN_TV);
		setLiveUrl(m, "badenTV.php", "Baden-TV");
		m.put(ICON, R.drawable.baden_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FOUR_SESAONS_TV);
		setLiveUrl(m, "4seasonsTV.php", null);
		m.put(ICON, R.drawable.fourseasons);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, L_TV);
		setLiveUrl(m, "l-tv.php", "L-TV");
		m.put(ICON, R.drawable.ltv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OBERPFALZ_TV);
		setLiveUrl(m, "oberpfalzTV.php", null);
		m.put(ICON, R.drawable.oberpfalz_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, AUGSBURG_TV);
		setLiveUrl(m, "augsburgTV.php", "AugsburgTV");
		m.put(ICON, R.drawable.augsburg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DW);
		setLiveUrl(m, "dw.php", "DW-EUROPA");
		m.put(ICON, R.drawable.dw_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BAYERN_TV);
		setLiveUrl(m, "bayerischesFernsehen.php", null);
		m.put(ICON, R.drawable.bayrisches_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BAYERN_TV_MEDIATHEK);
		setLiveUrl(m, "bayerischesFernsehen_Mediathek.php", null);
		m.put(ICON, R.drawable.bayrisches_fernsehen);
		addToArchiveStations(m);

		// m = new HashMap<String, Object>();
		// m.put(name, GIPSY_TV);
		// m.put(url, streamFile + "GIPSY-TV");
		// m.put(icon, R.drawable.qvc);
		// addToLiveStations(m);
		//
		// m = new HashMap<String, Object>();
		// m.put(name, OK_54);
		// m.put(url, streamFile + "OK-54");
		// m.put(icon, R.drawable.ok54);
		// addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_DESSAU);
		setLiveUrl(m, "okDessau.php", "OK-Dessau");
		m.put(ICON, R.drawable.ok_dessau);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_MAGDEBURG);
		setLiveUrl(m, "okMagdeburg.php", "OK-Magdeburg");
		m.put(ICON, R.drawable.ok_magdeburg);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_MERSEBURG);
		setLiveUrl(m, "okMerseburg.php", "OK-Merseburg");
		m.put(ICON, R.drawable.ok_merseburg);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_SALZWEDEL);
		setLiveUrl(m, "okSalzwedel.php", "OK-Salzwedel");
		m.put(ICON, R.drawable.ok_salzwedel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_STENDAL);
		setLiveUrl(m, "okStendal.php", "OK-Stendal");
		m.put(ICON, R.drawable.ok_stendal);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_WERNIGERODE);
		setLiveUrl(m, "okWernigerode.php", "OK-Wernigerode");
		m.put(ICON, R.drawable.ok_wernigerode);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_WETTIN);
		setLiveUrl(m, "okWettin.php", "OK-Wettin");
		m.put(ICON, R.drawable.ok_wettin);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OK_KIEL_TV);
		setLiveUrl(m, "okKielTV.php", null);
		m.put(ICON, R.drawable.ok_kiel_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_HALLE);
		setLiveUrl(m, "tvHalle.php", "TV-Halle");
		m.put(ICON, R.drawable.tv_halle);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RAN_1);
		setLiveUrl(m, "ran1.php", "Ran1");
		m.put(ICON, R.drawable.ran1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ELBEKANAL);
		setLiveUrl(m, "elbekanal.php", "Elbekanal");
		m.put(ICON, R.drawable.elbekanal);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PUNKT_UM);
		setLiveUrl(m, "punktUm.php", "Punktum");
		m.put(ICON, R.drawable.punkt_um);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RBW);
		setLiveUrl(m, "rbw.php", "RBW");
		m.put(ICON, R.drawable.rbw);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RFH);
		setLiveUrl(m, "rfh.php", "RFH");
		m.put(ICON, R.drawable.rfh);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BLK_ONLINE_TV);
		setLiveUrl(m, "blkOnlineTv.php", "blkOnlineTv");
		m.put(ICON, R.drawable.blk_online_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDF1);
		setLiveUrl(m, "mdf1.php", "MDF1");
		m.put(ICON, R.drawable.mdf1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MDF1);
		m.put(URL, "mdf1.php");
		m.put(ICON, R.drawable.mdf1);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DAS_VIERTE);
		setLiveUrl(m, "dasVierte.php", null);
		m.put(ICON, R.drawable.das_vierte);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTF_1);
		setLiveUrl(m, "rtf1.php", null);
		m.put(ICON, R.drawable.rtf1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DRESDEN_TV);
		setLiveUrl(m, "dresdenTV.php", "Dresden-Fernsehen");
		m.put(ICON, R.drawable.dresden_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SACHSEN_FERNSEHEN);
		setLiveUrl(m, "sachsenFernsehen.php", "Sachsen-Fernsehen");
		m.put(ICON, R.drawable.sachsen_fernsehen);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, LEIPZIG_TV);
		setLiveUrl(m, "leipzigTV.php", "Leipzig-Fernsehen");
		m.put(ICON, R.drawable.leipzig_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NRW_TV);
		setLiveUrl(m, null, "NRW-TV");
		m.put(ICON, R.drawable.nrw_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, FAN_TV);
		setLiveUrl(m, "fanTV.php", "Fan-TV");
		m.put(ICON, R.drawable.fan_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OEINS_OLDENBURG);
		setLiveUrl(m, "oeins.php", null);
		m.put(ICON, R.drawable.oeins);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RIC_TV_KINDER);
		setLiveUrl(m, "ricTV.php", null);
		m.put(ICON, R.drawable.ric_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SALVE_TV);
		setLiveUrl(m, "salveTV.php", null);
		m.put(ICON, R.drawable.salve_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ALTENBURG_TV);
		setLiveUrl(m, "altenburgTV.php", null);
		m.put(ICON, R.drawable.altenburg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DONAU_TV_LIVE);
		setLiveUrl(m, "donauTvLive.php", null);
		m.put(ICON, R.drawable.donau_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DONAU_TV_ARCHIV);
		m.put(URL, archiveFile + "Donau-TV");
		m.put(ICON, R.drawable.donau_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, _3_SAT);
		m.put(URL, "3sat.html");
		m.put(ICON, R.drawable.drei_sat);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, KIKA_PLUS);
		m.put(URL, archiveFile + "KIKA-Plus");
		m.put(ICON, R.drawable.kika_plus);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DIE_MAUS);
		m.put(URL, "dieMaus.php");
		m.put(ICON, R.drawable.die_maus);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ARD_DAS_ERSTE);
		setLiveUrl(m, "ardDasErste.php", "ARD-Das-Erste");
		m.put(ICON, R.drawable.ard_das_erste);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ARD_DAS_ERSTE_TAGESSCHAU);
		setLiveUrl(m, "ardDasErsteTagesschau.php", null);
		m.put(ICON, R.drawable.ard_tagesschau);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ARD_MEDIATHEK);
		m.put(URL, archiveFile + "ARD-Mediathek");
		m.put(ICON, R.drawable.ard_mediathek);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZDF);
		setLiveUrl(m, "zdfLive.php", "ZDF");
		m.put(ICON, R.drawable.zdf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZDF_NEO);
		setLiveUrl(m, "zdfNeo.php", "ZDF-neo");
		m.put(ICON, R.drawable.zdf_neo);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZDF_INFO);
		setLiveUrl(m, "zdfInfo.php", "ZDF-info");
		m.put(ICON, R.drawable.zdf_info);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZDF_KULTUR);
		setLiveUrl(m, "zdfKultur.php", "ZDF-kultur");
		m.put(ICON, R.drawable.zdf_kultur);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ZDF_MEDIATHEK);
		m.put(URL, archiveFile + "ZDF-Mediathek");
		m.put(ICON, R.drawable.zdf_mediathek);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, HAMBURG_1);
		setLiveUrl(m, null, "Hamburg1");
		m.put(ICON, R.drawable.hamburg1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, HAMBURG_1_MEDIATHEK);
		m.put(URL, archiveFile + "Hamburg1");
		m.put(ICON, R.drawable.hamburg1);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RBB_BERLIN);
		setLiveUrl(m, null, "RBB-Berlin");
		m.put(ICON, R.drawable.rbb_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RBB_BRANDENBURG);
		setLiveUrl(m, null, "RBB-Brandenburg");
		m.put(ICON, R.drawable.rbb_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RBB_MEDIATHEK);
		m.put(URL, archiveFile + "RBB-Mediathek");
		m.put(ICON, R.drawable.rbb_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RBB_DOKU_REPORTAGEN);
		m.put(URL, archiveFile + "RBB-Doku-Report");
		m.put(ICON, R.drawable.rbb_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BW_EINS);
		m.put(URL, "bwEins.php");
		m.put(ICON, R.drawable.bw_eins);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PROMETHEUS);
		m.put(URL, "prometheus.php");
		m.put(ICON, R.drawable.prometheus);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SPIEGEL_ONLINE);
		m.put(URL, "spiegel_online.html");
		m.put(ICON, R.drawable.spiegel_online);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SPONGEBOB);
		m.put(URL, "spongebob.html");
		m.put(ICON, R.drawable.spongebob);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, KINDERKINO);
		m.put(URL, "https://www.youtube.com/profile?user=kinderkino");
		// m.put(url, "kinderkino.html");
		m.put(ICON, R.drawable.kinderkino);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NETZKINO);
		// m.put(url, "netzkino.html");
		m.put(URL, "https://www.youtube.com/profile?user=netzkino");
		m.put(ICON, R.drawable.netzkino);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MYSPASS);
		m.put(URL, archiveFile + "my-spass-de");
		m.put(ICON, R.drawable.myspass);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BERG_TV);
		m.put(URL, "bergischGladbach.php");
		m.put(ICON, R.drawable.berg_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ANDROID_NEW_TV);
		m.put(URL, "androidNewsTV.html");
		m.put(ICON, R.drawable.android_news_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OS1_TV);
		m.put(URL, "os1TV.php");
		m.put(ICON, R.drawable.os1_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OSTFRIESEN_TV);
		m.put(URL, "ostfriesenTV.php");
		m.put(ICON, R.drawable.ostfriesen_tv);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, IT_NEWS_TV);
		setLiveUrl(m, "itNewsTV.php", null);
		m.put(ICON, R.drawable.it_news_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DAF);
		setLiveUrl(m, "daf.php", null);
		m.put(ICON, R.drawable.daf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PHOENIX);
		setLiveUrl(m, "phoenix.php", null);
		m.put(ICON, R.drawable.phoenix);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BUNDESTAG_1);
		setLiveUrl(m, null, "Bundestag-TV1");
		m.put(ICON, R.drawable.bundestag);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BUNDESTAG_2);
		setLiveUrl(m, null, "Bundestag-TV2");
		m.put(ICON, R.drawable.bundestag);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_TOURING_SCHWEINFURT);
		setLiveUrl(m, null, "TV-Touring-Sch2");
		m.put(ICON, R.drawable.tv_touring);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, TV_TOURING_WUERZBURG);
		setLiveUrl(m, null, "TV-Touring-Wue2");
		m.put(ICON, R.drawable.tv_touring);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ASTRO_TV);
		setLiveUrl(m, null, "Astro-TV");
		m.put(ICON, R.drawable.astro_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PEARL_TV);
		setLiveUrl(m, null, "Pearl-TV");
		m.put(ICON, R.drawable.pearl_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, QVC);
		setLiveUrl(m, null, "QVC");
		m.put(ICON, R.drawable.qvc);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SPORT_1);
		setLiveUrl(m, null, "SPORT-1");
		m.put(ICON, R.drawable.sport1);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CENTER_TV_KOELN);
		setLiveUrl(m, null, "Center-Koeln");
		m.put(ICON, R.drawable.center_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CENTER_TV_MUENSTER);
		setLiveUrl(m, null, "Center-Muenster");
		m.put(ICON, R.drawable.center_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DELUXE_MUSIC);
		setLiveUrl(m, null, "Deluxe-Music");
		m.put(ICON, R.drawable.deluxe_music);
		addToLiveStations(m);

		// m = new HashMap<String, Object>();
		// m.put(name, MELODIE_EXPRESS);
		// m.put(url, streamFile + "MELODIE-EXPRESS");
		// m.put(icon, R.drawable.tv_touring);
		// addToLiveStations(m);

		// *********************************************************************************
		// * Österreich
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put(NAME, context.getResources().getString(R.string.austria));
		m.put(URL, "");
		m.put(ICON, R.drawable.flagge_oesterreich);
		allStationList.add(m);
		archivStationList.add(m);
		liveStationList.add(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_1_HQ);
		setLiveUrl(m, null, "ORF-1-HQ");
		m.put(ICON, R.drawable.orf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_2_HQ);
		setLiveUrl(m, null, "ORF-2-HQ");
		m.put(ICON, R.drawable.orf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_2_EUROPE_HQ);
		setLiveUrl(m, null, "ORF-2-EUROPE-HQ");
		m.put(ICON, R.drawable.orf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_3_HQ);
		setLiveUrl(m, null, "ORF-3-HQ");
		m.put(ICON, R.drawable.orf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_SPORT_HQ);
		setLiveUrl(m, null, "ORF-SPORT-HQ");
		m.put(ICON, R.drawable.orf);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ORF_TV_THEK);
		m.put(URL, archiveFile + "ORF-TV-Thek");
		m.put(ICON, R.drawable.orf_tvthek);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RED_BULL_TV);
		setLiveUrl(m, "redbullTV.php", "RedBull");
		m.put(ICON, R.drawable.red_bull_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SERVUS_TV);
		setLiveUrl(m, "servusTV.php", null);
		m.put(ICON, R.drawable.servus_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, OKTO_TV);
		setLiveUrl(m, "oktoTV.php", "OKTO-TV");
		m.put(ICON, R.drawable.okto_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, W24_WIEN);
		setLiveUrl(m, "w24wien.php", "W24");
		m.put(ICON, R.drawable.w24_wien);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, MUEHLVIERTEL_TV);
		setLiveUrl(m, "muehlviertelTV.php", "Muehlviertel");
		m.put(ICON, R.drawable.muehlviertel_tv);
		addToLiveStations(m);

		// m = new HashMap<String, Object>();
		// m.put(name, TIROL_TV);
		// m.put(url, "tirolTV.php");
		// m.put(icon, R.drawable.tirol_tv);
		// addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, REUTTE_EINS);
		setLiveUrl(m, "reutteEins.php", null);
		m.put(ICON, R.drawable.reutte_eins);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, AUSTRIA_24_TV);
		setLiveUrl(m, "austria24TV.php", "Austria24");
		m.put(ICON, R.drawable.austria24tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PULS_4);
		m.put(URL, "puls4.php");
		m.put(ICON, R.drawable.puls_4);
		addToArchiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, RTS_SALZBURG);
		m.put(URL, archiveFile + "RTS-Salzburg");
		m.put(ICON, R.drawable.rts_salzburg);
		addToArchiveStations(m);

		// *********************************************************************************
		// * Diverse
		// *********************************************************************************
		allStationList.add(getLeerZeile(context));
		archivStationList.add(getLeerZeile(context));
		liveStationList.add(getLeerZeile(context));

		m = new HashMap<String, Object>();
		m.put(NAME, context.getResources().getString(R.string.otherCountries));
		m.put(URL, "");
		m.put(ICON, R.drawable.flagge_globus);

		liveStationList.add(m);
		allStationList.add(m);
		archivStationList.add(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SUEDTIROL_TV);
		setLiveUrl(m, null, "Suedtirol-TV");
		m.put(ICON, R.drawable.suedtirol_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NASA_TV_PUBLIC);
		setLiveUrl(m, "nasaTvPublic.php", "NASA-Public");
		m.put(ICON, R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NASA_TV_MEDIA);
		setLiveUrl(m, "nasaTvMedia.php", null);
		m.put(ICON, R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, NASA_TV_EDUCATION);
		setLiveUrl(m, "nasaTvEducation.php", null);
		m.put(ICON, R.drawable.nasa_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, SPACE_TV);
		setLiveUrl(m, "space-itv.php", null);
		m.put(ICON, R.drawable.space_itv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, ESA_TV);
		setLiveUrl(m, "esaTv.php", null);
		m.put(ICON, R.drawable.esa);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CLASSIC_CARTOONS_ACME);
		setLiveUrl(m, "acme-streaming.php", null);
		m.put(ICON, R.drawable.acme_streaming);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, AL_JAZEERA_EN);
		setLiveUrl(m, "alJazeeraEnglish.php", "Al-Jazeera-EN");
		m.put(ICON, R.drawable.al_jazeera);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BLOOMBERG_TV_USA);
		setLiveUrl(m, "bloombergTV.php", "Bloomberg-USA");
		m.put(ICON, R.drawable.bloomberg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BLOOMBERG_TV_ASIA);
		setLiveUrl(m, null, "Bloomberg-ASIA");
		m.put(ICON, R.drawable.bloomberg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, BLOOMBERG_TV_EU);
		setLiveUrl(m, null, "Bloomberg-EU");
		m.put(ICON, R.drawable.bloomberg_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, PENTAGON_CHANNEL);
		setLiveUrl(m, "pentagonChannel.php", null);
		m.put(ICON, R.drawable.pentagon_channel);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, UNITED_NATIONS_TV);
		setLiveUrl(m, "unTV.php", null);
		m.put(ICON, R.drawable.un_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, CCTV_CHINA);
		setLiveUrl(m, "cctv_china.php", null);
		m.put(ICON, R.drawable.cctv_china);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, VISIT_X);
		setLiveUrl(m, "visit-x-TV.php", null);
		m.put(ICON, R.drawable.visit_x_tv);
		addToLiveStations(m);

		m = new HashMap<String, Object>();
		m.put(NAME, DISNEY_CHANNEL);
		m.put(URL, archiveFile + "Disney");
		m.put(ICON, R.drawable.disney_channel);
		addToArchiveStations(m);
	}

	private static HashMap<String, Object> getLeerZeile(Context context) {
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put(NAME, context.getResources().getString(R.string.emptyString));
		m.put(URL, "");
		m.put(ICON, R.drawable.leer1x1);
		return m;
	}
}
