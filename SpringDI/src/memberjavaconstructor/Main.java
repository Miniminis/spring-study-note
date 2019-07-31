package memberjavaconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		MemberDao dao1 = context.getBean("memberDao", MemberDao.class);
		MemberDao dao2 = context.getBean("memberDao", MemberDao.class);
		
		boolean chk = dao1 == dao2;
		System.out.println("dao1 == dao2 결과는 "+chk);
		//@Scope : default 로 싱글톤 처리 되었기때문에 true 결과값이 나온다. 
		//@Scope(value = "prototype") : false 
			
		
	}

}
