package memberannotation;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainForScope {
	
	//private static Assembler assembler = new Assembler();
	
	//스프링 컨테이너 생성 : 조립기 설정파일 == appCtx1.xml 
	//appCtx1.xml 설정 파일을 읽어 객체 관리
	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5Scope.xml");	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("==============================================");
		System.out.println("스프링 컨테이너에서 받은 객체1 ");
		System.out.println("");
		MemberRegisterService regiterService01 = ctx.getBean("registService", MemberRegisterService.class);
		MemberRegisterService registerService02 = ctx.getBean("registService", MemberRegisterService.class);
		
		//참조변수 비교 : 참조 주소값을 비교 --> 싱글톤 처리 비교 : 싱글톤의 경우는 
		boolean chk = regiterService01 == registerService02;
		
		System.out.println("regiterService01 == registerService02   "+ chk);
		System.out.println("==============================================");
		
		System.out.println("스프링 컨테이너에서 받은 객체2 ");
		System.out.println("");
		ChangePasswordService chgPwService01  = ctx.getBean("chgPwService", ChangePasswordService.class);
		ChangePasswordService chgPwService02  = ctx.getBean("chgPwService", ChangePasswordService.class);
		
		boolean chk2 = chgPwService01 == chgPwService02;
		
		System.out.println("chgPwService01 == chgPwService02 :   "+chk2);
		System.out.println("==============================================");

	}
	
		
}
