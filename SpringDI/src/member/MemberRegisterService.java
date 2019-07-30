package member;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import exception.AlreadyExistingMemberException;

@Service("registService")
public class MemberRegisterService {
	
	//방법 3: 어노테이션 이용 
	@Autowired	 //default설정 = true	
	//@Autowired(required = false)		//autowired(required=true) //default = true
										//: 주입이 제대로 되지 않았으면 아예 실행 X - 콘솔창에 java.lang.ExceptionInInitializerError
	//@Qualifier("qualifierForMemberDao")
	//@Resource(name="anotherMemberDao")
	//@Resource
	private MemberDao memberDao;
	
	//스프링 DI 설정 방법 1: xml내에서 생성자 처리 
	/*public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;		//따로 인스턴스를 생성하지 않고 매개변수로 Assembler 에서 전달받는다! 
	}*/
	
	//스프링 DI 설정 방법 2: 프로퍼티 방식 이용
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	public void regist(RegisterRequest regrequest) throws AlreadyExistingMemberException {
		Member member = memberDao.selectByEmail(regrequest.getUseremail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException();
		}
		
		Member regMember = new Member(regrequest.getUseremail(), regrequest.getUserpw(), regrequest.getUsername(), new Date());
		
		memberDao.insert(regMember); //새로운 회원정보 등록 
		
	}

}
