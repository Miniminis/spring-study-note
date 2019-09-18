package com.firstboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.firstboot.domain.Member;

public interface MemberMapper {

	@Select("select * from memberinfo order by idx")
	public List<Member> selectMemberList();
	public Member selectMemberById(String userid);
	
	/*
	 * Boot에서는 Mapper 설정하는 방법이 2가지 
	 * 1. @MapperScan("com.firstboot.mapper")
	 * 	  @Select 
	 * 등 어노테이션 이용 
	 * 
	 * 2. 스프링 프로젝트처럼 xml 파일로 설정 
	 */
}
