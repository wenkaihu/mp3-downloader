package com.wenkaihu.mp3downloader.engine;

import com.wenkaihu.mp3downloader.CONST;

public class BaiduMp3Engine {
	
	private static String url = CONST.BAIDU_SEARCH;
	
	public static String getSearchUrl(String keyword){
		android.util.Log.d("URL", ">>>>> " + url + keyword);
		return url + keyword;
	}
	
	public static String getDownloadUrl(String downlink){
		if (downlink == null || downlink.equals("")) return null;
		return CONST.BASE_URL + downlink;
	}
}
