package com.express.bean;

import java.sql.Timestamp;

public class MercBlacklist {
	
	private String mercid;

	private String mercname; 		// 黑名单电商名称

	private Timestamp crtime; 		// 最后修改时间

	public String getMercid() {
		return mercid;
	}

	public void setMercid(String mercid) {
		this.mercid = mercid;
	}

	public String getMercname() {
		return mercname;
	}

	public void setMercname(String mercname) {
		this.mercname = mercname;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}

}
