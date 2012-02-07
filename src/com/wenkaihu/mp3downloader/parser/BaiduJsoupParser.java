package com.wenkaihu.mp3downloader.parser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.model.TrackInfo;

public class BaiduJsoupParser implements JsoupParser {

	public List<TrackInfo> getSearchResults(Document doc){
		
		Element div = doc.getElementById(CONST.ID_SONG_RESULT);
		if (div == null) return null;
    	Elements trs =  div.getElementsByTag(CONST.TAG_TR);
    	List<TrackInfo> tracks = new ArrayList<TrackInfo>();
    	for (Element tr : trs){
    		Elements tds = tr.getElementsByTag(CONST.TAG_TD);
    		if (tds == null || tds.size() == 0) continue;
    		TrackInfo track = new TrackInfo();
    		track.setTrack_number(tds.get(0).child(0).text());
    		track.setTrack_name(tds.get(1).child(0).text());
    		track.setTrack_link(tds.get(1).child(0).attr(CONST.ATTR_HREF));
    		if (tds.get(2).child(0).hasText()){
    			track.setSinger(tds.get(2).child(0).child(0).text());
    		} else {
    			track.setSinger("");
    		}
    		if(tds.get(3).child(0).hasText()){
    			track.setAlbum(tds.get(3).child(0).child(0).text());
    		}else{
    			track.setAlbum("");
    		}
    		track.setFile_type(tds.get(6).child(0).text());
    		track.setTrack_size(tds.get(7).child(0).text());
    		tracks.add(track);
    	}
    	
//    	String link =  trs.get(1)
//    			.getElementsByTag(CONST.TAG_TD)
//    			.get(1).getElementsByTag("a").get(0).attr("href");
//    	
//    	Document sdoc = Jsoup.connect(link).get();
//    	String downlink = sdoc.getElementById("downlink").attr("href");
//    	
//    	downlink  = "http://mp3.baidu.com" + downlink;
//    	Log.d("DOC", downlink);
//    	
//    	String dirName = Environment.getExternalStorageDirectory()+"/MyDownload/";
//    	File f = new File(dirName);
//    	if(!f.exists())
//    	{
//    	    f.mkdir();
//    	}
//    	
//    	String newFilename = "b.mp3";
//    	newFilename = dirName + newFilename;
//    	File file = new File(newFilename);
//    	if(file.exists()){
//    	    file.delete();
//    	}
    	
//    	URLConnection conn = new URL(downlink).openConnection();
//    	int length = conn.getContentLength();
//    	Log.d("DOC", "" + length);
//    	InputStream is = conn.getInputStream();  
//        byte[] bs = new byte[1024];
//        int len;
//        int sum = 0;
//        OutputStream os = new FileOutputStream(newFilename);   
//        while ((len = is.read(bs)) != -1) {
//        	sum += len;
//        	Log.d("DOC", "" + sum * 100 / length );
//            os.write(bs, 0, len);   
//        }   
//        os.close();  
//        is.close();
//    	for (Element ele : eles){
//    		Log.e("TR", "=========================");
//    		Log.e("TR", ele.getElementsByTag("td").get(0).toString());
//    		Log.e("TR", "=========================");
//    	}
		return tracks;
	}
	
	public String getDownloadUrl(Document doc){
		return doc.getElementById(CONST.ID_DOWNLINK).attr(CONST.ATTR_HREF);
	}
}
