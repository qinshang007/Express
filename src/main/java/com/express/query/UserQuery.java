package com.express.query;

import java.sql.Timestamp;

public class UserQuery {
	private String userid; 		// �û�id

	private String compid; 		// �û�������˾id

	private String username; 	// �û�����

	private String passwd; 		// �û�����

	private String phone; 		// �û��ֻ�����

	private String email; 		// �û�����

	private int level; 			// �û�Ȩ�ޣ�0����ͨ��1����λ��2�����£�3������Ա

	private Timestamp restime; 		// �û�ע��ʱ��

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Timestamp getRestime() {
		return restime;
	}

	public void setRestime(Timestamp restime) {
		this.restime = restime;
	}
}
