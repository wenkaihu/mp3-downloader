package com.wenkaihu.mp3downloader.engine;

import com.wenkaihu.mp3downloader.CONST;

public class Mp3SkullEngine implements SearchEngine {

	private static String url = CONST.SKULL_SEARCH;

	public String getSearchUrl(String keyword){
		android.util.Log.d("URL", ">>>>> " + String.format(url, keyword));
		return String.format(url, keyword);
	}

	@Override
	public String getDownloadUrl(String downlink) {
		// TODO Auto-generated method stub
		return null;
	}
}
