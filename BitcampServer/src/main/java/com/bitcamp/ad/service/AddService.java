package com.bitcamp.ad.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.AddRoomForm;
import com.bitcamp.ad.domain.Room;

@Service("addService")
public class AddService {

	@Autowired
	private SqlSessionTemplate sqltemplate;
	
	private RoomSessionDao roomDao; 
	
	public int addRoom(AddRoomForm addRoomForm) {
		
		//form 데이터로 먼저 Room 객체 생성 
		Room room = addRoomForm.toRoom(); //남은 변수 1개: file  
		
		/* 파일 저장*/ 
		 //* 1. 파일 경로 설정 : 상대경로-path /roomPhoto, 절대경로-dir 
		
		 //* 2. 파일 이름 값 설정 
		 //* 3. 파일 존재 여부에 따라 분기처리 
		 //* 4. 완성된 room 객체 DAO 단으로 넘기기 
		 //* 5. 결과값 받기 */
		
		
	}
	
	

}
