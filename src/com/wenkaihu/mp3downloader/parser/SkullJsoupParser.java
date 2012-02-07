package com.wenkaihu.mp3downloader.parser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.model.TrackInfo;

public class SkullJsoupParser implements JsoupParser {

	@Override
	public List<TrackInfo> getSearchResults(Document doc) {
		Elements results = doc.select(CONST.TAG_DIV + "#" + CONST.ID_SONG_HTML);
		if (results == null || results.size() == 0) return null;
	
    	List<TrackInfo> tracks = new ArrayList<TrackInfo>();
    	int count = results.size() < 26 ? results.size() : 25;
    	for (int i=0; i< count; i++){
    		Element song_html = results.get(i);
    		TrackInfo track = new TrackInfo();
    		track.setTrack_number(i + "");
    		track.setTrack_name(song_html.child(1).child(0).child(0).text());
    		track.setTrack_link(song_html.child(1).child(2).child(0).child(1).child(0).attr(CONST.ATTR_HREF));
    		track.setSinger("");
    		track.setAlbum("");
    		track.setFile_type("mp3");
    		String info = song_html.child(0).text();
    		track.setTrack_size(info.substring(info.lastIndexOf("<br>") + 4));
    		tracks.add(track);
    	}
		return tracks;
	}

	@Override
	public String getDownloadUrl(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

}
