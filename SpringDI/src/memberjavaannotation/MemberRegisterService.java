package memberjavaannotation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	@Autowired
	@Qualifier("sys")
	//private MemberDao memberDao;
	private Dao memberDao;
	
	public void regist(RegisterRequest regrequest) throws AlreadyExistingMemberException {
		Member member = memberDao.selectByEmail(regrequest.getUseremail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException();
		}
		
		Member regMember = new Member(regrequest.getUseremail(), regrequest.getUserpw(), regrequest.getUsername(), new Date());
		
		memberDao.insert(regMember); //새로운 회원정보 등록 
		
	}
}
