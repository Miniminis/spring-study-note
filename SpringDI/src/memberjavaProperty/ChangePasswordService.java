package memberjavaProperty;

import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;

public class ChangePasswordService {

	private MemberDao memberDao;

	public void setMemberDao (MemberDao dao) {
		this.memberDao = dao;
	}
	
	public void changePassword(String useremail, String oldPw, String newPw) throws MemberNotFoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(useremail);
		
		if(member == null) {
			throw new MemberNotFoundException(); //useremail 과 일치하는 회원정보가 없을때 예외처리 
		}
		
		member.changePw(oldPw, newPw); //이전 비밀번호가 일치하지 않을때 예외처리 
		
		memberDao.update(member);
	}
	
}
