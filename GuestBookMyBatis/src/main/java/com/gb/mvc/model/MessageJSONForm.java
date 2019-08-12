package com.gb.mvc.model;

//DB 와 연결 - 테이블에서 가져온 데이터들을 저장하는 클래스 
public class MessageJSONForm {
	
	private String gname;
	private String gpassword;
	private String gmessage;
	
	//default 생성자 
	public MessageJSONForm() {}	

	public MessageJSONForm(String gname, String gpassword, String gmessage) {
		this.gname = gname;
		this.gpassword = gpassword;
		this.gmessage = gmessage;
	}


	//getters & setters 
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGpassword() {
		return gpassword;
	}

	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}

	public String getGmessage() {
		return gmessage;
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