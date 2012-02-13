package com.wenkaihu.mp3downloader.net;

import java.io.InputStream;
import java.net.URL;

import com.wenkaihu.mp3downloader.CONST;

public class Network {
	private int engine;

	public Network(int engine) {
		this.engine = engine;
	}

	public String[] getSuggestions(String url){
		switch (engine) {
		case CONST.ID_SE_BAIDU:
			return getBaiduSuggestions(url);
		case CONST.ID_SE_SKULL:
			return getSkullSuggestions(url);
		default:
			return null;
		}
	}

	private String[] getSkullSuggestions(String url) {
		String sb = getResponseStr(url);
		String str = sb.substring(sb.indexOf(CONST.SK_SU_FLAG_S) + 10, sb.indexOf(CONST.SK_SU_FLAG_E));
		return str.replaceAll("\'", "").split(",");
	}
	
	private String[] getBaiduSuggestions(String url) {
		String sb = getResponseStr(url);
		String str = sb.substring(sb.indexOf(CONST.BD_SU_FLAG_S) + 4, sb.indexOf(CONST.BD_SU_FLAG_E));
		return str.replaceAll("\"", "").split(",");
	}
	
	private String getResponseStr(String url){
		try {
			URL mUrl = new URL(url);
			InputStream input = mUrl.openConnection().getInputStream();
			StringBuffer sb = new StringBuffer();
			byte[] buffer = new byte[1024];
			while(input.read(buffer, 0, buffer.length) != -1){
				sb.append(new String(buffer, CONST.ZH_GBK));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
