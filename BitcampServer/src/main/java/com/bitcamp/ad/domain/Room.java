package com.bitcamp.ad.domain;


public class Room {
	
	private int roomnum;
	private String hotelname;
	private String roomname;
	private String roomimg;
	private int maxppl;
	private String intro;
	private int price;
	private char convenience;

	
	public Room () {}


	public Room(int roomnum, 
				String hotelname, 
				String roomname, 
				String roomimg, 
				int maxppl, 
				String intro, 
				int price,
				char convenience) {
		this.roomnum = roomnum;
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
		return "Room [roomnum=" + roomnum + ", hotelname=" + hotelname + ", roomname=" + roomname + ", roomimg="
				+ roomimg + ", maxppl=" + maxppl + ", intro=" + intro + ", price=" + price + ", convenience="
				+ convenience + "]";
	}
	
	
	
	
}
