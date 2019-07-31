package memberjavaannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext02 {
	
	@Bean(name = "registServiceJava")
	public MemberRegisterService getMemberRegisterService() {
		MemberRegisterService service = new MemberRegisterService();
		
		return service;
		
	}

	@Bean(name = "chgPwServiceJava")
	public ChangePasswordService getChangePasswordService() {
		
		ChangePasswordService service = new ChangePasswordService();
				
		return service;
	}
}
