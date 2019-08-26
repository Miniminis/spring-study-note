package com.bitcamp.ad.domain;

import org.springframework.web.multipart.MultipartFile;

public class EditRoomForm {
	
	private String roomname;
	private int maxppl;
	private String intro;
	private int price;
	private char convenience;
	private MultipartFile roomimg;
	private String oldRoomPhoto;
	
	public EditRoomForm() {}

	public EditRoomForm(String roomname, int maxppl, String intro, int price, char convenience, MultipartFile roomimg,
			String oldRoomPhoto) {
		super();
		this.roomname = roomname;
		this.maxppl = maxppl;
		this.intro = intro;
		this.price = price;
		this.convenience = convenience;
		this.roomimg = roomimg;
		this.oldRoomPhoto = oldRoomPhoto;
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

	public MultipartFile getRoomimg() {
		return roomimg;
	}

	public void setRoomimg(MultipartFile roomimg) {
		this.roomimg = roomimg;
	}

	public String getOldRoomPhoto() {
		return oldRoomPhoto;
	}

	public void setOldRoomPhoto(String oldRoomPhoto) {
		this.oldRoomPhoto = oldRoomPhoto;
	}

	@Override
	public String toString() {
		return "EditRoomForm [roomname=" + roomname + ", maxppl=" + maxppl + ", intro=" + intro + ", price=" + price
				+ ", convenience=" + convenience + ", roomimg=" + roomimg + ", oldRoomPhoto=" + oldRoomPhoto + "]";
	}
	
	public Room toRoom() {
		Room room = new Room();
		
		room.setRoomname(roomname);
		room.setMaxppl(maxppl);
		room.setIntro(intro);
		room.setPrice(price);
		room.setConvenience(convenience);
		
		return room;
	}
}
