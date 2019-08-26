package com.bitcamp.ad.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;

@Service("delService")
public class DeleteService {

	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private RoomSessionDao dao;
	
	public int deleteRoom(int roomnum) {
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		return dao.deleteByRoomNum(roomnum);		
	}
	
	

}
