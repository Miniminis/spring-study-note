package com.bitcamp.ad.domain;

public class EditRoomForm {
	
	private int roomnum;
	private String roomname;
	private int maxppl;
	private String intro;
	private int price;
	private char convenience;
	
	public EditRoomForm() {}
	
	

	public EditRoomForm(int roomnum, String roomname, int maxppl, String intro, int price, char convenience) {
		super();
		this.roomnum = roomnum;
		this.roomname = roomname;
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



	public String getRoomname() {
		return roomname;
	}



	public void setRoomname(String roomname) {
		this.roomname = roomname;
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
		return "EditRoomForm [roomnum=" + roomnum + ", roomname=" + roomname + ", maxppl=" + maxppl + ", intro=" + intro
				+ ", price=" + price + ", convenience=" + convenience + "]";
	}

}
