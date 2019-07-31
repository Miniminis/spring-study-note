package memberjavaProperty;

import java.util.Date;

import exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	public void regist(RegisterRequest regrequest) throws AlreadyExistingMemberException {
		Member member = memberDao.selectByEmail(regrequest.getUseremail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException();
		}
		
		Member regMember = new Member(regrequest.getUseremail(), regrequest.getUserpw(), regrequest.getUsername(), new Date());
		
		memberDao.insert(regMember); //새로운 회원정보 등록 
		
	}
}
