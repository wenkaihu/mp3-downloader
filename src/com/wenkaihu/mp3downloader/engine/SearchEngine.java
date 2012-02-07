package com.wenkaihu.mp3downloader.engine;

public interface SearchEngine {

	public String getSearchUrl(String keyword);
	
	public String getDownloadUrl(String downlink);
	
}
