package com.gb.mvc.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//JSON 문자열 형태로 넘겨진 form 데이터들을 받는 클래스 
//@JsonDeserialize(using = MessageDeserializer.class)
public class MessageJSON {
	
	private String gname;
	private String gpassword;
	private String gmessage;
	
	//default 생성자 
	public MessageJSON() {}	

	public MessageJSON(String gname, String gpassword, String gmessage) {
		this.gname = gname;
		this.gpassword = gpassword;
		this.gmessage = gmessage;
	}

	//getters & setters 
	public String getGname() {
		return gname;
	}

	public String getGpassword() {
		return gpassword;
	}

	public String getGmessage() {
		return gmessage;
	}
	
	public void setGname(String gname) {
		this.gname = gname;
	}

	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}

	public void setGmessage(String gmessage) {
		this.gmessage = gmessage;
	}

	@Override
	public String toString() {
		return "Message [gname=" + gname + ", gpassword=" + gpassword + ", gmessage="
				+ gmessage + "]";
	}

}