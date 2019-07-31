package memberjavacomponentscan;

public class RegisterRequest {
	
	private String useremail;
	private String userpw;
	private String confirmPw;
	private String username;
	
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getConfirmPw() {
		return confirmPw;
	}
	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isPwEqualToConfirmPw() {
		return userpw.equals(confirmPw); 		//회원가입시 비밀번호값과 확인 비밀번호 값이 일치하는지 확인 --> true 이면 회원가입 승인! 
	}
	
	

}
