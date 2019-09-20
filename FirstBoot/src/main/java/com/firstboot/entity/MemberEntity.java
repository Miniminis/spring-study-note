package com.firstboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberinfo")
public class MemberEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) //mysql 의 경우 auto_increment 이므로 필요 X
	@Column
	private int idx;
	
	@Column(length = 45, nullable = false)
	private String userid;
	
	@Column(length = 45, nullable = false)
	private String userpw;
	
	@Column(length = 45, nullable = false)
	private String username;
	
	@Column(length = 45, nullable = false)
	private String userphoto;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}

	@Override
	public String toString() {
		return "MemberEntity [idx=" + idx + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userphoto=" + userphoto + "]";
	}
	
}
