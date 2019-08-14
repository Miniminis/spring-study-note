package com.springproject.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Login {

	private String uId;
	
	@JsonIgnore //사용자나 페이지에 노출되어서는 안되는 정보나 불필요한 정보가 표현되는 것을 미리 차단한다.
	private String uPw;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

}