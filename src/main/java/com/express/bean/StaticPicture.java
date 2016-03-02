package com.express.bean;

import java.sql.Timestamp;

public class StaticPicture {
	
	private String id;	
	
	private String description;	

	private String picturesrc;		
	
	private Timestamp crtime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicturesrc() {
		return picturesrc;
	}

	public void setPicturesrc(String picturesrc) {
		this.picturesrc = picturesrc;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}


}
