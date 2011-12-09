package com.wenkaihu.mp3downloader.action;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

import com.wenkaihu.mp3downloader.engine.BaiduMp3Engine;
import com.wenkaihu.mp3downloader.model.TrackInfo;
import com.wenkaihu.mp3downloader.parser.JsoupParser;

public class TrackSearch {

	public List<TrackInfo> searchTracks(String keyword) throws IOException{
		return new JsoupParser().getSearchResults(Jsoup.connect( BaiduMp3Engine.getSearchUrl(keyword)).get());
	}
}
