package com.bitcamp.ad.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.Room;

@Service("listService")
public class ListService {

	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private RoomSessionDao dao;
	
	public List<Room> getRoomList(int hotelnum) {
		
		System.out.println("방 리스트 02  "+hotelnum);
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		List<Room> roomlist = new ArrayList<Room>();
		
		roomlist = dao.selectRoomListByHotel(hotelnum);
		
		System.out.println("방 리스트 03  "+roomlist);
		
		return roomlist;
	}

}
