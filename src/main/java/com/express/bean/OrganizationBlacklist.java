package com.express.bean;

import java.sql.Timestamp;

public class OrganizationBlacklist {
	
	private String organizationid;

	private String organizationname; 	

	private Timestamp crtime; 		// 最后修改时间

	public String getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}

	
}
