package com.wenkaihu.mp3downloader.utils;

public class LOGD {

	private static boolean LOG_SWITCH = true;

	public static void d(Object obj, String str) {
		if (LOG_SWITCH) android.util.Log.d(obj.getClass().getName(), ">>>>> " + str);
	}
}
