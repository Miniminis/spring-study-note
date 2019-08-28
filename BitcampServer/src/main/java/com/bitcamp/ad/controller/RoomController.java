package com.bitcamp.ad.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.ad.domain.AddRoomForm;
import com.bitcamp.ad.domain.EditRoomForm;
import com.bitcamp.ad.domain.Room;
import com.bitcamp.ad.service.AddService;
import com.bitcamp.ad.service.DeleteService;
import com.bitcamp.ad.service.EditService;
import com.bitcamp.ad.service.GetRoomService;
import com.bitcamp.ad.service.ListService;

@RestController
@RequestMapping("/api/hotel/room")
public class RoomController {
	
	@Autowired
	private AddService addService;

	@Autowired
	private ListService listService;
	
	@Autowired
	private DeleteService delService;
	
	@Autowired
	private EditService editService;
	
	@Autowired
	private GetRoomService getRoomService;
	
	//호텔별 방 리스트 출력
	@GetMapping("/{id}")
	@CrossOrigin
	public List<Room> getRoomListByHotel(@PathVariable("id") int hotelnum) {
		
		System.out.println("방 리스트 02  "+hotelnum);
		
		return listService.getRoomList(hotelnum);
		
	};
	
	//특정 호텔의 특정 방 출력 
	@GetMapping("/{id}/{idx}")
	@CrossOrigin
	public Room getRoom(@PathVariable("id") int hotelnum, 
						@PathVariable("idx") int roomnum) {
		
		//어차피 roomnum 은 pk 이므로 hotelnum은 보낼 필요가 없음 
		return getRoomService.getOneRoom(roomnum);
		
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
	};

	
	//방 삭제 
	@DeleteMapping("/{id}")
	@CrossOrigin
	public int delRoom(@PathVariable("id") int roomnum) {
		
		return delService.deleteRoom(roomnum);
		
	};
	
	//방 수정;
	@PutMapping("/{id}")
	@CrossOrigin
	public int editRoom(@PathVariable("id") int roomnum,
						@RequestBody EditRoomForm editRoomForm, 
						HttpServletRequest req) {
		
		System.out.println("방 정보 수정 04  " +roomnum);
		System.out.println("방 정보 수정 05  " +editRoomForm);
		return editService.editRoomInfo(roomnum, editRoomForm, req);
		
	}
	
}
