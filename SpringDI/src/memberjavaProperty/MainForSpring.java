package memberjavaProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exception.AlreadyExistingMemberException;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;

public class MainForSpring {
		
	private static ApplicationContext ctx = 
			new AnnotationConfigApplicationContext(AppContext.class);
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Scanner로 쓸 수도 있음! 
		
		while(true) {
			System.out.println("원하시는 요청을 입력해주세요.");
			String command = reader.readLine(); 		//한줄읽기 
	
			if(command.equalsIgnoreCase("종료")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			if(command.startsWith("신규")) {
				processNewCommand(command.split(" ")); 
				//split() 첨자로 문자열 잘라주기  //신규 minhee@ddd 1111 minheeSon 
			}
			
			if(command.startsWith("변경")) {
				processChangeCommand(command.split(" ")); //공백으로 문자열 잘라주기 // 
			}
		}
	
	}
	
	private static void processNewCommand(String[] args) {
		
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService service = ctx.getBean("registServiceJava", MemberRegisterService.class);
		RegisterRequest regrequest = new RegisterRequest();
		
		regrequest.setUseremail(args[1]);
		regrequest.setUserpw(args[2]);
		regrequest.setConfirmPw(args[3]);
		regrequest.setUsername(args[4]);
		
		if(!regrequest.isPwEqualToConfirmPw()) {
			System.out.println("암호 확인이 일치하지 않습니다!");
			return;
		}
		
		try {
			service.regist(regrequest);
			System.out.println("신규 회원 등록이 완료되었습니다.");
		} catch (AlreadyExistingMemberException e) {
			e.printStackTrace();
			System.out.println("이미 존재하는 회원입니다! ");
		}
		
	}
	
	private static void processChangeCommand(String[] args) {
		
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService service = ctx.getBean("chgPwServiceJava", ChangePasswordService.class);
		try {
			service.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호 변경이 완료되었습니다*^^*");
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			System.out.println("존재하지 않는 이메일 입니다! ");
		} catch (IdPasswordNotMatchingException e) {
			e.printStackTrace();
			System.out.println("이메일 혹은 암호가 일치하지 않습니다!");
		}
		
	}
	
	private static void printHelp() {
		System.out.println("");
		System.out.println("================================");
		System.out.println("잘못된 요청입니다. 아래 요청 사용법을 확인하세요. ");
		System.out.println("신규 이메일 비밀번호 비밀번호확인 사용자이름 ");
		System.out.println("변경 이메일 예전비밀번호 바꾸고자하는비밀번호");
		System.out.println("================================");

	}
}
