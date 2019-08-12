package com.gb.mvc.model;

//DB 와 연결 - 테이블에서 가져온 데이터들을 저장하는 클래스 
public class Message {
	
	private int message_id;
	private String gname;
	private String gpassword;
	private String gmessage;
	
	//default 생성자 
	public Message() {}	

	public Message(int message_id, String gname, String gpassword, String gmessage) {
		super();
		this.message_id = message_id;
		this.gname = gname;
		this.gpassword = gpassword;
		this.gmessage = gmessage;
	}


	//getters & setters 
	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

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
	
	//메시지 삭제 시 사용자 확인을 위한 비밀번호 검사 
	//1. 사용자의 비밀번호 입력값이 있는지, 
	//2. 사용자가 입력한 비밀번호 값과, DB에서 가져와 Message 객체에 저장한 gpassword 가 일치하는지 
	
	//password 유효성 검사
	public boolean hasPassword() {
		//사용자가 입력한 password 가 값이 존재하고, 공백이 아니라면 --> true 반환 --> password 조건 통과! 
		return gpassword !=null && !gpassword.isEmpty();	
	}
	
	//삭제시에 사용자 확인을 위한 비밀번호 비교 
	public boolean matchPassword(String pw) {
		return hasPassword() && gpassword.equals(pw); 
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", gname=" + gname + ", gpassword=" + gpassword + ", gmessage="
				+ gmessage + "]";
	}

}