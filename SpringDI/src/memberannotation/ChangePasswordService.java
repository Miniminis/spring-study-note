package memberannotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;

@Service("chgPwService")
public class ChangePasswordService {
	
	//원래는 DAO 객체를 생성하여 처리하였으나 이제 이렇게 안함! 
	//private MemberDao memberDao = new MemberDao();

	@Autowired
	//@Autowired(required = false)
	//@Qualifier("qualifierForMemberDao")
	//@Resource(name="anotherMemberDao")
	//@Resource
	//@Required
	private MemberDao memberDao;

	//스프링 DI 설정 방법 1: xml내에서 생성자 처리 
	/*public ChangePasswordService(MemberDao dao) {
		this.memberDao = dao;
	}*/
	
	//스프링 DI 설정 방법 2: 프로퍼티 방식 이용 
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	public void changePassword(String useremail, String oldPw, String newPw) throws MemberNotFoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(useremail);
		
		if(member == null) {
			throw new MemberNotFoundException(); //useremail 과 일치하는 회원정보가 없을때 예외처리 
		}
		
		member.changePw(oldPw, newPw); //이전 비밀번호가 일치하지 않을때 예외처리 
		
		memberDao.update(member);
	}
	
}
