package com.bitcamp.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.ad.domain.AddRoomForm;
import com.bitcamp.ad.service.AddService;

@RestController
@RequestMapping("/api/hotel/room")
public class RoomController {
	
	@Autowired
	private AddService addService;
	
	//새로운 방 등록 
	@PostMapping()
	@CrossOrigin
	public int addRoom(AddRoomForm addRoomForm) {
		
		System.out.println("방 등록 02 "+addRoomForm);
		
		addService.addRoom(addRoomForm);
		
	}

}
