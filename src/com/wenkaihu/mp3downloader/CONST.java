package com.wenkaihu.mp3downloader;

public class CONST {

	// baidu search engine url
	public static final String BAIDU_SEARCH = "http://mp3.baidu.com/m?f=ms&rf=idx&tn=baidump3&word=";
	public static final String BASE_URL = "http://mp3.baidu.com";
	public static final String BAIDU_SEARCH_SU = "http://nssug.baidu.com/su?wd=%s&prod=mp3";
	// skull search engine url 
	public static final String SKULL_SEARCH = "http://mp3skull.com/mp3/%s.html";
	public static final String SKULL_SEARCH_SU = "http://ac1.mp3skull.com/autocomplete/get.php?q=";
	// encoding of webpage
	public static final String ZH_GB2312 = "gb2312";
	public static final String UTF_8 = "UTF-8";
	public static final String ENCODING = ZH_GB2312;
	public static final String ZH_GBK = "GBK";
	// id in the baidu document
	public static final String ID_SONG_RESULT = "songResults";
	public static final String ID_DOWNLINK = "downlink";
	// id in the skull document
	public static final String ID_SONG_HTML = "song_html";
	// tag in the document
	public static final String TAG_TR = "tr";
	public static final String TAG_TD = "td";
	public static final String TAG_A = "a";
	public static final String TAG_DIV = "div";
	// attribute in the tag
	public static final String ATTR_HREF = "href";
	// key for the intent extra
	public static final String EXTRA_KEY_WORD = "key_word";
	public static final String EXTRA_SEARCH_ENGINE = "search_engine";
	// key in maps
	public static final String MAP_TRACK_NAME = "track_name";
	public static final String MAP_SINGER = "singer";
	public static final String MAP_FILE_TYPE = "file_type";
	public static final String MAP_TRACK_SIZE = "track_size";
	public static final String MAP_ALBUM = "album";
	public static final String MAP_TRACK_NUMBER = "track_number";
	public static final String MAP_TRACK_LINK = "track_link";
	// list of search engine 
	public static final int ID_SE_BAIDU = 0;
	public static final int ID_SE_SKULL = 1;
	// flag for baidu suggestion results
	public static final String BD_SU_FLAG_S = ",s:[";
	public static final String BD_SU_FLAG_E = "]});";
	// flag for skull suggestion results
	public static final String SK_SU_FLAG_S = "new Array(";
	public static final String SK_SU_FLAG_E = "), new Array(";

}
