package com.express.bean;

import java.sql.Timestamp;

public class Company {
	
	private String compid; 			// 公司id
	
	private String pcompid;			// 上一级公司id：若没有为null

	private String compname; 		// 公司名称

	private String address; 		// 公司地址

	private String tel; 			// 公司固话
	
	private String principal;	    // 负责人
	
	private Timestamp  crtime;		// 公司添加时间
	
	private int  level;				// 公司级别
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPcompid() {
		return pcompid;
	}

	public void setPcompid(String pcompid) {
		this.pcompid = pcompid;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}
	

}
