package com.wenkaihu.mp3downloader.engine;

import com.wenkaihu.mp3downloader.CONST;

public class BaiduMp3Engine {
	
	private static String url = CONST.BAIDU_SEARCH;
	
	public static String getSearchUrl(String keyword){
		return url + keyword;
	}
}
