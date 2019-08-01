package com.springproject.mvc.model;

public class User {
	private String userid;
	private String userpw;
	private String username;
	private String userage;
	
	public User() {}
	
	public User(String userid, String userpw, String username, String userage) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userage = userage;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userage=" + userage
				+ "]";
	}
	
}
