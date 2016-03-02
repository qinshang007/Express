package com.express.query;

import java.sql.Timestamp;

public class UserQuery {
	private String userid; 		// 用户id

	private String compid; 		// 用户所属公司id

	private String username; 	// 用户名称

	private String passwd; 		// 用户密码

	private String phone; 		// 用户手机号码

	private String email; 		// 用户邮箱

	private int level; 			// 用户权限，0：普通，1：单位，2：理事，3：管理员

	private Timestamp restime; 		// 用户注册时间

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
