package member;

public class A1Outline {}

/* //outline 
- Member : 회원 정보를 저장할 클래스 
- RegisterRequest : 회원가입시 받을 정보의 저장 (임시저장) 

- MemberDao : 데이터 저장을 위해 필요한 매서드들의 모음 
	- selectByEmail() : email 값으로 이미 존재하는 회원인지 검색 
	- insert(member) : 회원가입시 받은 정보들이 기존의 member 객체에 존재하지 않는다면 신규 데이터 저장 
	- update(member) : 비밀번호 변경 후 바뀐 정보를 업데이트 
	- selectAll() : member 객체에 저장된 모든 회원정보를 반환 

- Service 
1) MemberRegisterService 
	- DB관련 처리를 해야하니 DAO 필요 --> 따로 객체 생성을 하지 않고 생성자의 매개변수로 전달받음! 
	- regist(RegisterRequest) 
		- RegisterRequest를 통해 받은 정보 중 email 값이  selectByEmail() 를 통해 검색된다면 --> 이미 존재하는 회원이므로 가입 불가! 
		- 검색이 안되고 null 값이 반환된다면 --> 새로운 멤버 객체 생성 후, 생성자를 통해 객체 초기화; --> 해당 객체를 insert() 통해서 데이터 저장해주기 
		
2) ChangePasswordService
	- 비밀번호 변경 : 역시 DB관련 처리를 해야하니 DAO 필요 --> 생성자의 매개변수를 통해 전달받음! 
	- changePw(email, oldPw, newPw) 
		- selectByEmail(email) 통해서 email 과 일치하는 회원 존재하는지 체크 
		- 존재하지 않는다면 --> 해당 회원이 존재하지 않습니다! 
		- 존재한다면 --> 비밀번호 기존과 일치하는지 확인 후, member.changePw() 매서드를 통해 비밀번호 변경 
		- 새롭게 업데이트 된 member 객체를 update() 통해서 데이터에 저장 

- Assembler : 모든 객체들을 생성, 보관 
	- MemberDao 객체 생성 
	- 서비스 2개의 객체 생성 후, 생성자 매개변수로 MemberDao 주입 
	- 나중에 main 에서 assembler 하나만으로 모든 dao 및 서비스에 접근할 수 있도록 getter 매서드만 생성

- MainFormAssembler: 메인 흐름  
	- assembler 에 담긴 dao 및 service 객체들을 이용하기 위해 assembler 객체 생성 
	- while() 무한반복문으로 프로그램 계속 이어지도록 처리 
	- 종료: 프로그램 종료 
	- 신규 : processnew()
	- 변경: processchange()
	
	- 신규 시, 
	MemberRegisterService = assembler.getinstance()
	RegisterRequest req = new RegisterRequest(); 
	
	사용자 입력값 : string 문자열 형태 --> 차례대로 대입 
	만약 비밀번호와 확인 비밀번호가 같지 않다면 --> 예외처리 
	
	확인 끝나면 service.regist() 
	
	- 변경 시, 
	ChangePasswordService = assembler.getinstance() 
	service.changePassword(email, oldpw, newpw) --> string[] 차례대로 입력 
	
	각각의 경우 예외처리 
	
 */