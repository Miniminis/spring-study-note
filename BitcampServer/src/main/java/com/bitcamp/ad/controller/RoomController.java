package com.bitcamp.ad.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.ad.domain.AddRoomForm;
import com.bitcamp.ad.domain.Room;
import com.bitcamp.ad.service.AddService;
import com.bitcamp.ad.service.ListService;

@RestController
@RequestMapping("/api/hotel/room")
public class RoomController {
	
	@Autowired
	private AddService addService;

	@Autowired
	private ListService listService;
	
	//호텔별 방 리스트 출력
	@GetMapping("/{id}")
	@CrossOrigin
	public List<Room> getRoomListByHotel(@PathVariable("id") int hotelnum) {
		
		System.out.println("방 리스트 02  "+hotelnum);
		
		return listService.getRoomList(hotelnum);
		
	}
	
	//새로운 방 등록 
	@PostMapping()
	@CrossOrigin
	public int addRoom(AddRoomForm addRoomForm, 
						HttpServletRequest req) {
		
		System.out.println("방 등록 02 "+addRoomForm+"/"+req);
		
		int rscnt =  addService.addRoom(addRoomForm, req);
		
		System.out.println("방 등록 07 "+rscnt);
		
		return rscnt;
	}

	
	//방 삭제 
	//방 수정 
	
}
