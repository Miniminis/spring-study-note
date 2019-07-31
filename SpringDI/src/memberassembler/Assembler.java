package memberassembler;

public class Assembler {
	
	//조립기 : 객체 생성, 보관 및 관리의 역할!  ---> MVC 구조에서는 외부 설정파일인 web.xml 에서 해당 처리를 해줌! 
	
	//보관 객체 
	private MemberDao memberDao;
	private MemberRegisterService registerService;
	private ChangePasswordService chgPwService;
	
	public Assembler() {
		//객체 생성 및 주입 
		memberDao = new MemberDao();
		registerService = new MemberRegisterService(memberDao);
		chgPwService = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegisterService() {
		return registerService;
	}

	public ChangePasswordService getChgPwService() {
		return chgPwService;
	}
	
	

}
