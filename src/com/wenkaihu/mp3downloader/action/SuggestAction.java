package com.wenkaihu.mp3downloader.action;

import com.wenkaihu.mp3downloader.engine.SearchEngine;
import com.wenkaihu.mp3downloader.net.Network;
import com.wenkaihu.mp3downloader.utils.Utils;

public class SuggestAction {
	private SearchEngine mEngine;
	private Network mNet;
	
	public SuggestAction(int engine) {
		mEngine = Utils.getFromID(engine);
		mNet = new Network(engine);
	}
	
	public String[] getSuggestion(String keyword){
		return mNet.getSuggestions(mEngine.getSuggestUrl(keyword));
	}
}
