package com.firstboot.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstboot.domain.Member;
import com.firstboot.mapper.MemberMapper;

@Controller
public class IndexController {

	@Autowired
	private SqlSessionTemplate template;

	private MemberMapper mapper;

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

	@RequestMapping("/memberInfo")
	public void selectByIdx() {
		mapper = template.getMapper(MemberMapper.class);
		Member member = mapper.selectMemberById("minhee4735@naver.com");
		System.out.println("member from mapper :::::: " + member);
	}

	@RequestMapping("/memberlist")
	@ResponseBody
	public List<Member> selectMembers() {
		mapper = template.getMapper(MemberMapper.class);
		List<Member> memberlist = mapper.selectMemberList();
		for (Member member : memberlist) {
			System.out.println("member 리스트 ::: "+member);
		}
		return memberlist;
	}

}
