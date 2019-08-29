package com.bitcamp.ad.domain;

import org.springframework.web.multipart.MultipartFile;


public class EditRoomPhoto {
	
	private int roomnum;
	private String roomname;
	private MultipartFile roomimg;
	private String oldRoomPhoto;
	
	public EditRoomPhoto() {}

	public EditRoomPhoto(int roomnum, String roomname, MultipartFile roomimg, String oldRoomPhoto) {
		super();
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.roomimg = roomimg;
		this.oldRoomPhoto = oldRoomPhoto;
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
		return "EditRoomPhoto [roomnum=" + roomnum + ", roomname=" + roomname + ", roomimg=" + roomimg
				+ ", oldRoomPhoto=" + oldRoomPhoto + "]";
	}
}
