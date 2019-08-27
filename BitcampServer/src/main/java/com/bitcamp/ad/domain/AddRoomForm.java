package com.bitcamp.ad.domain;

import org.springframework.web.multipart.MultipartFile;

public class AddRoomForm {
	
	private int hotelnum; //파라미터 01
	private String hotelname; //파라미터 02
	private String roomname;
	private MultipartFile roomimg;
	private int maxppl;
	private String intro;
	private int price;
	private char convenience;
	private char availability;
	
	public AddRoomForm() {}

	public AddRoomForm(int hotelnum, String hotelname, String roomname, MultipartFile roomimg, int maxppl, String intro,
			int price, char convenience, char availability) {
		super();
		this.hotelnum = hotelnum;
		this.hotelname = hotelname;
		this.roomname = roomname;
		this.roomimg = roomimg;
		this.maxppl = maxppl;
		this.intro = intro;
		this.price = price;
		this.convenience = convenience;
		this.availability = availability;
	}

	public int getHotelnum() {
		return hotelnum;
	}

	public void setHotelnum(int hotelnum) {
		this.hotelnum = hotelnum;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public MultipartFile getRoomimg() {
		return roomimg;
	}

	public void setRoomimg(MultipartFile roomimg) {
		this.roomimg = roomimg;
	}

	public int getMaxppl() {
		return maxppl;
	}

	public void setMaxppl(int maxppl) {
		this.maxppl = maxppl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getConvenience() {
		return convenience;
	}

	public void setConvenience(char convenience) {
		this.convenience = convenience;
	}

	@Override
	public String toString() {
		return "AddRoomForm [roomname=" + roomname + ", roomimg=" + roomimg + ", maxppl=" + maxppl + ", intro=" + intro
				+ ", price=" + price + ", convenience=" + convenience + "]";
	}
	
	public Room toRoom() {
		Room room = new Room();
		
		room.setHotelnum(hotelnum);
		room.setHotelname(hotelname);
		room.setRoomname(roomname);
		room.setPrice(price);
		room.setMaxppl(maxppl);
		room.setIntro(intro);
		room.setConvenience(convenience);
		room.setAvailability('Y'); //최초 방 등록시에는 예약 가능이 default 
		//file 은 service 단에서 추가 
		
		return room;
	}
}
