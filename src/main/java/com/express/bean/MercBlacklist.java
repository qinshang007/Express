package com.express.bean;

import java.sql.Timestamp;

public class MercBlacklist {
	
	private String mercid;

	private String mercname; 		// ��������������

	private Timestamp crtime; 		// ����޸�ʱ��

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
