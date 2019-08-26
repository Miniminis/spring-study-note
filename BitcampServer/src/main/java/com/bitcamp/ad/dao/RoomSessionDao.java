package com.bitcamp.ad.dao;

import java.util.List;

import com.bitcamp.ad.domain.Room;

public interface RoomSessionDao {

	public int insert(Room room);

	public List<Room> selectRoomListByHotel(int hotelnum);

}
