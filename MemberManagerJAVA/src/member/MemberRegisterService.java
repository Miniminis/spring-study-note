package member;

import java.util.Date;

import exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;		//따로 인스턴스를 생성하지 않고 매개변수로 Assembler 에서 전달받는다! 
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
