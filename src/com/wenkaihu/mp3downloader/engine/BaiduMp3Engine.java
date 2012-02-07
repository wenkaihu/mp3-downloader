package com.wenkaihu.mp3downloader.engine;

import com.wenkaihu.mp3downloader.CONST;

public class BaiduMp3Engine implements SearchEngine {
	
	private static String url = CONST.BAIDU_SEARCH;
	
	public String getSearchUrl(String keyword){
		android.util.Log.d("URL", ">>>>> " + url + keyword);
		return url + keyword;
	}
	
	public String getDownloadUrl(String downlink){
		if (downlink == null || downlink.equals("")) return null;
		return CONST.BASE_URL + downlink;
	}
}
