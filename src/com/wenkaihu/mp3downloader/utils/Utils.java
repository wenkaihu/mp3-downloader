package com.wenkaihu.mp3downloader.utils;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.engine.BaiduMp3Engine;
import com.wenkaihu.mp3downloader.engine.Mp3SkullEngine;
import com.wenkaihu.mp3downloader.engine.SearchEngine;

public class Utils {

	/**
	 * get the search engine object from the search engine ID
	 * @param engine
	 * @return
	 */
	public static SearchEngine getFromID(int engine) {
		SearchEngine mSearchEngine;
		switch (engine) {
		case CONST.ID_SE_BAIDU:
			mSearchEngine = new BaiduMp3Engine();
			break;
		case CONST.ID_SE_SKULL:
			mSearchEngine = new Mp3SkullEngine();
			break;
		default:
			mSearchEngine = new BaiduMp3Engine();
			break;
		}
		return mSearchEngine;
	}
}
