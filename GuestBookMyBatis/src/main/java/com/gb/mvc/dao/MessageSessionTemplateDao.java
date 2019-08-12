package com.gb.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gb.mvc.model.Message;
import com.gb.mvc.model.MessageRowMapper;

@Repository("sqlSessionTemplateDao")
public class MessageSessionTemplateDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//namespace는 모든 dao 매서드들에서 공통으로 사용되므로 하나의 변수에 담아 처리 
	private String namespace="com.gb.mvc.mapper.mybatis.GuestMapper";
	
	//1. insert 기능 : 게시글 추가기능
	public int insert(Message message) {
				
		String str = namespace+".insertMsg"; //com.gb.mvc.mapper.mybatis.GuestMapper.insertMsg
		int rscnt = sqlSessionTemplate.update(str, message);
			System.out.println("DAO insert"+rscnt);
		return rscnt;
	}
	
	
	//2. 메시지 선택 기능 
	public Message select(int mid) {

		String str = namespace+".selectOne";
		return sqlSessionTemplate.selectOne(str, mid);
		
	}

	
	//3.전체 게시물의 개수 반환 
	public int selectCnt() {
		
		String str = namespace+".selectCnt";
		return sqlSessionTemplate.selectOne(str);
		
	}

	
	//4-2) 게시물 리스트 출력 기능 - rowmapper 클래스 따로 만들어서 처리 
	public List<Message> selectList(Map<String, Object> map) {
		
		String str = namespace+".selectAllList";
		return sqlSessionTemplate.selectList(str, map);
		 
	}


	//5. 게시물 삭제 기능 
	//@transactional 어노테이션 통해서 스프링 통해 트랜잭션 처리 
	@Transactional
	public int deleteMessage(int mId) {
		
		String str = namespace+".deleteMsg";
		return sqlSessionTemplate.update(str, mId);		
	}

}


