package memberjavacomponentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;

@Service("chgPwServiceJavaComponent")
public class ChangePasswordService {
	
	@Autowired
	//@Qualifier("sys")
	//private MemberDao memberDao;
	private Dao memberDao;
	
	public void changePassword(String useremail, String oldPw, String newPw) throws MemberNotFoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(useremail);
		
		if(member == null) {
			throw new MemberNotFoundException(); //useremail 과 일치하는 회원정보가 없을때 예외처리 
		}
		
		member.changePw(oldPw, newPw); //이전 비밀번호가 일치하지 않을때 예외처리 
		
		memberDao.update(member);
	}
	
}
