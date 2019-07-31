package memberjavaconstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {
	//방법1. xml 에서 설정 
	//방법2. xml + annotation 설정 
	//방법3. 설정파일을 JAVA 코드로 작성하기 
	
	@Bean(name = "memberDao")
	@Scope(value = "singleton")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	@Bean(name = "registServiceJava")
	public MemberRegisterService getMemberRegisterService() {
		return new MemberRegisterService(getMemberDao());
	}

	@Bean(name = "chgPwServiceJava")
	public ChangePasswordService getChangePasswordService() {
		return new ChangePasswordService(getMemberDao());
	}
}
