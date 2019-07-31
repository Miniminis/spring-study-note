package memberjavaconstructor;

import java.util.Date;

import exception.IdPasswordNotMatchingException;

public class Member {
	private Long userid; //회원들의 등록 순번을 나타내는 단순한 index의 기능 
	private String useremail;
	private String userpw;
	private String username;
	private Date regdate;
	
	
	public Member() {}
	
	public Member(String useremail, String userpw, String username, Date regdate) {
		super();
		this.useremail = useremail;
		this.userpw = userpw;
		this.username = username;
		this.regdate = regdate;
	}


	//생성자를 통해서만 객체를 생성할 것이기 때문에, setter는 굳이 만들지 않는다 (단, userid 는 제외!)	

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;				//userid 는 나중에 회원등록 순번대로 설정해주기 때문에 setter 매서드가 필요함! 
	}

	public String getUseremail() {
		return useremail;
	}

	public String getUserpw() {
		return userpw;
	}

	public String getUsername() {
		return username;
	}

	public Date getRegdate() {
		return regdate;
	}
	
	public void changePw(String oldPw, String newPw) throws IdPasswordNotMatchingException {

		if(!this.userpw.equals(oldPw)) {
			//현재 비밀번호와 oldPW 가 같다면, --> 새로운 비밀번호 바꾸기 전에 확인절차! 
			throw new IdPasswordNotMatchingException();
		}
		
		//위의 상황이 아니라면 --> 비밀번호로 본인 확인이 된다면 
		this.userpw = newPw;
	}
	
	
}
