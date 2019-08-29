package com.bitcamp.ad.dao;

import java.util.List;

import com.bitcamp.ad.domain.EditRoomForm;
import com.bitcamp.ad.domain.Room;

public interface RoomSessionDao {

	public int insert(Room room);

	public List<Room> selectRoomListByHotel(int hotelnum);

	public int deleteByRoomNum(int roomnum);

	public Room selectByRoomnum(int roomnum);

	public int editRoom(EditRoomForm room);

	public Room selectRoomByRoomnum(int roomnum);

	public int editRoomPhoto(String newFileName, int roomnum);

}
