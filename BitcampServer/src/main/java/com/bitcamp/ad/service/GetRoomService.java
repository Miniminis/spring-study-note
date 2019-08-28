package com.bitcamp.ad.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.Room;

@Service("getRoomService")
public class GetRoomService {

	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private RoomSessionDao dao;
	
	public Room getOneRoom(int roomnum) {
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		return dao.selectRoomByRoomnum(roomnum);		
	}
	
	

}
