package com.firstboot.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstboot.domain.Member;
import com.firstboot.entity.MemberEntity;
import com.firstboot.mapper.MemberMapper;
import com.firstboot.repository.MemberRepository;

@Controller
public class IndexController {

	@Autowired
	private SqlSessionTemplate template;

	private MemberMapper mapper;
	
	@Autowired
	private MemberRepository repository; //interface 임에도 주입을 받을 수 있고 + 부트 시작과 동시에 객체 생성 

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Spring Boot Test STARTEDDDDDDDDDDDDDDDDDDDD";
	}

	@RequestMapping("/hello")
	public void hello() {
		// void type 으로 아무런 반환 타입이 없기 /hello url 에 지정된 페이지를 표시하게 된다.
	}

	// return 타입을 정해준다면 : 해당 데이터를 표시
	// return 타입이 없다면 : url 에 지정된 페이지를 표시

	@RequestMapping("/member")
	@ResponseBody
	public Member selectByIdx() {
		mapper = template.getMapper(MemberMapper.class);
		Member member = mapper.selectMemberById("minhee4735@naver.com");
		System.out.println("member from mapper :::::: " + member);
		
		return member;
	}

	@RequestMapping("/members")
	@ResponseBody
	public List<Member> selectMembers() {
		mapper = template.getMapper(MemberMapper.class);
		List<Member> memberlist = mapper.selectMemberList();
		for (Member member : memberlist) {
			System.out.println("member 리스트 ::: "+member);
		}
		return memberlist;
	}
	
	////////////////////////////////////////JPA/////////////////////////////////////
	
	@RequestMapping("/jpa/members")
	@ResponseBody //return entity 타입 + @ResponseBody = json 형태로 페이지 출력 
	public List<MemberEntity> getMemberList() {
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		for(MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	@RequestMapping("/jpa/member/insert")
	@ResponseBody
	public String insertMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setUserid("cool00001@hot");
		entity.setUsername("minimini0001");
		entity.setUserpw("123456");
		
		return repository.saveAndFlush(entity).toString();
	}
	
	@RequestMapping("/jpa/member/edit/{idx}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		
		entity.setIdx(idx);
		entity.setUserid("afterEdit@edit");
		entity.setUsername("Edited NAMEEEE");
		entity.setUserpw("123456");
		
		return repository.saveAndFlush(entity).toString();
	}
	
	@RequestMapping("/jpa/member/delete/{idx}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();		
		entity.setIdx(idx);
		
		repository.delete(entity); //return type 이 void 이기 때문에 아래와 같이 확인하는 방법을 사용
		
		return "DELETE SUCCESSSSSSSSSSSSSSSSSSS";
	}
	
	@RequestMapping("/jpa/member/{idx}")
	@ResponseBody
	public MemberEntity getMember(@PathVariable("idx") int idx) {
		MemberEntity entity = null;
		entity = repository.findByIdx(idx);
		System.out.println("entity  ::: "+entity);
		
		return entity;
	}
	
	@RequestMapping("/jpa/member/searchByName/{username}")
	@ResponseBody
	public List<MemberEntity> getMember(@PathVariable("username") String username) {
		List<MemberEntity> list = null;
		
		list = repository.findByUsernameLike("%"+username+"%");
		//System.out.println("findByUsernameLike ::: "+list);
		
		return list;
	}
	
	@RequestMapping("/jpa/member/searchByBetween/{idx1}/{idx2}")
	@ResponseBody
	public List<MemberEntity> getMember(@PathVariable("idx1") int idx1,
										@PathVariable("idx2") int idx2) {
		List<MemberEntity> list = null;
		
		list = repository.findByIdxBetween(idx1, idx2);
		
		return list;
	}
}
