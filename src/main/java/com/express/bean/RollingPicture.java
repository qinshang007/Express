package com.express.bean;

import java.sql.Timestamp;

public class RollingPicture {
	
	private String id;	
	
	private String title;	
	
	private String link;	
	
	private String filesrc;		
	
	private int    sequence;
	
	private Timestamp crtime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFilesrc() {
		return filesrc;
	}
	public void setFilesrc(String filesrc) {
		this.filesrc = filesrc;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Timestamp getCrtime() {
		return crtime;
	}
	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}
}
