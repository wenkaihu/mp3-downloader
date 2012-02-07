package com.wenkaihu.mp3downloader.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

import com.wenkaihu.mp3downloader.engine.BaiduMp3Engine;
import com.wenkaihu.mp3downloader.engine.Mp3SkullEngine;
import com.wenkaihu.mp3downloader.engine.SearchEngine;
import com.wenkaihu.mp3downloader.model.TrackInfo;
import com.wenkaihu.mp3downloader.parser.BaiduJsoupParser;
import com.wenkaihu.mp3downloader.parser.JsoupParser;
import com.wenkaihu.mp3downloader.parser.SkullJsoupParser;

public class TrackAction {

	private SearchEngine engine;
	private JsoupParser parser;
	
	public TrackAction(SearchEngine engine){
		this.engine = engine;
		if (engine instanceof Mp3SkullEngine){
			parser = new SkullJsoupParser();
		}else if (engine instanceof BaiduMp3Engine){
			parser = new BaiduJsoupParser();
		}else{
			parser = null;
		}
	}
	
	public List<TrackInfo> searchTracks(String keyword) throws IOException{
		return parser.getSearchResults(Jsoup.parse(new File(engine.getSearchUrl(keyword)), "UTF-8"));
	}
	
	public String trackDownload(String down_link) throws IOException{
		return engine.getDownloadUrl(parser.getDownloadUrl(Jsoup.connect(down_link).get()));
	}
}
