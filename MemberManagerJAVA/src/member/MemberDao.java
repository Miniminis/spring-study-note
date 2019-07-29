package member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static long nextId=0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	//email 을 통해서 Member 존재 여부 검색
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	//회원정보 등록 : id가 index 처럼 사용되었다. 
	public void insert(Member member) {
		member.setUserid(++nextId); //전위형 계산자 : 1대입 		
		map.put(member.getUseremail(), member);
	}
	
	//member의 회원정보 변경 : changepw 에서 이용됨  
	public void update(Member member) {
		map.put(member.getUseremail(), member);
	}
	
	//모든 회원의 정보 가져오기 
	public Collection<Member> selectAll() {
		return map.values(); //collection 객체를 그대로 반환 
	}

}
