package com.wenkaihu.mp3downloader.model;

public class TrackInfo {
	private String track_name;
	private String singer;
	private String file_type;
	private String track_size;
	private String album;
	private String track_number;
	
	public TrackInfo(String track_name, String singer, String file_type, String track_size, String album, String track_number){
		this.track_name = track_name;
		this.singer = singer;
		this.file_type = file_type;
		this.track_size = track_size;
		this.album = album;
		this.track_number = track_number;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("{");
		sb.append("track_name:");
		sb.append(track_name);
		sb.append(", singer:");
		sb.append(singer);
		sb.append(", file_type:");
		sb.append(file_type);
		sb.append(", track_size:");
		sb.append(track_size);
		sb.append(", album:");
		sb.append(album);
		sb.append(", track_number:");
		sb.append(track_number);
		sb.append("}");
		return sb.toString();
	}
	
	public String getTrack_number() {
		return track_number;
	}

	public void setTrack_number(String track_number) {
		this.track_number = track_number;
	}

	public String getTrack_name() {
		return track_name;
	}
	public void setTrack_name(String track_name) {
		this.track_name = track_name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getTrack_size() {
		return track_size;
	}
	public void setTrack_size(String track_size) {
		this.track_size = track_size;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
