package com.bitcamp.ad.domain;


public class Room {
	
	private int roomnum; //auto_increment
	private int hotelnum; //파라미터 01
	private String hotelname; //파라미터 02
	private String roomname; //toRoom() 
	private String roomimg; //AddService 단 
	private int maxppl; //toRoom()
	private String intro; //toRoom()
	private int price; //toRoom()
	private char convenience; //toRoom()

	
	public Room () {}

	public Room(int roomnum, int hotelnum, String hotelname, String roomname, String roomimg, int maxppl, String intro,
			int price, char convenience) {
		super();
		this.roomnum = roomnum;
		this.hotelnum = hotelnum;
		this.hotelname = hotelname;
		this.roomname = roomname;
		this.roomimg = roomimg;
		this.maxppl = maxppl;
		this.intro = intro;
		this.price = price;
		this.convenience = convenience;
	}

	public int getRoomnum() {
		return roomnum;
	}


	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
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


	public String getRoomimg() {
		return roomimg;
	}


	public void setRoomimg(String roomimg) {
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
		return "Room [roomnum=" + roomnum + ", hotelnum=" + hotelnum + ", hotelname=" + hotelname + ", roomname="
				+ roomname + ", maxppl=" + maxppl + ", intro=" + intro + ", price=" + price + ", convenience="
				+ convenience + "]";
	}

}
