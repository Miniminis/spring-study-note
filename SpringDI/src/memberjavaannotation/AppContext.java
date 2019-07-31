package memberjavaannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
//@Import({AppContext01.class, AppContext02.class})
//@ImportResource
public class AppContext {
	//방법1. xml 에서 설정 
	//방법2. xml + annotation 설정 
	//방법3. 설정파일을 JAVA 코드로 작성하기 
	
	/*@Bean(name = "memberDao")
	@Scope(value = "singleton")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}*/
	
	@Bean(name = "memberDao")
	@Scope(value = "singleton")
	@Qualifier("sys")
	public Dao getMemberDao() {
		return new MemberDao();
	}
	
	@Bean(name="boardDao")
	public Dao getBoardDao() {
		return new BoardDao();
	}
	
	@Bean(name = "registServiceJava")
	public MemberRegisterService getMemberRegisterService() {
		MemberRegisterService service = new MemberRegisterService();
		
		//service.setMemberDao(getMemberDao());
		
		return service;
		
	}

	@Bean(name = "chgPwServiceJava")
	public ChangePasswordService getChangePasswordService() {
		
		ChangePasswordService service = new ChangePasswordService();
		
		//service.setMemberDao(getMemberDao());
		
		return service;
	}
}
