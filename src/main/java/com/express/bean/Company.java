package com.express.bean;

import java.sql.Timestamp;

public class Company {
	
	private String compid; 			// ��˾id
	
	private String pcompid;			// ��һ����˾id����û��Ϊnull

	private String compname; 		// ��˾����

	private String address; 		// ��˾��ַ

	private String tel; 			// ��˾�̻�
	
	private String principal;	    // ������
	
	private Timestamp  crtime;		// ��˾���ʱ��
	
	private int  level;				// ��˾����
	
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
