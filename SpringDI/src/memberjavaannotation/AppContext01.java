package memberjavaannotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
//@Import({AppContext02.class})
public class AppContext01 {
	
	@Bean(name = "memberDao")
	@Scope(value = "singleton")
	@Qualifier("sys")
	public Dao getMemberDao() {
		return new MemberDao();
	}
	
}
