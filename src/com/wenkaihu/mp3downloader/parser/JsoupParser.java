package com.wenkaihu.mp3downloader.parser;

import java.util.List;

import org.jsoup.nodes.Document;

import com.wenkaihu.mp3downloader.model.TrackInfo;

public interface JsoupParser {

	public List<TrackInfo> getSearchResults(Document doc);
	
	public String getDownloadUrl(Document doc);
	
}
