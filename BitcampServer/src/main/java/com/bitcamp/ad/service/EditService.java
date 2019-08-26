package com.bitcamp.ad.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.EditRoomForm;
import com.bitcamp.ad.domain.Room;

@Service("editService")
public class EditService {
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;

	private RoomSessionDao dao;
	
	
	public int editRoomInfo(int roomnum, 
								EditRoomForm editRoomForm,
								HttpServletRequest req) {
		
		System.out.println("방 정보 수정 06  " +roomnum);
		System.out.println("방 정보 수정 07  " +editRoomForm);
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		Room room = editRoomForm.toRoom(); //Room 객체 생성 및 파일 이외의 변수들 모두 Room 객체로 삽입 
		
		room.setRoomnum(roomnum); //룸넘버 삽입 
		
		System.out.println("방 정보 수정 08  " +room);
		//룸넘버 이용하여 hotelnum & hotelname 받아오기 
		/*Room otherRoom = dao.selectByRoomnum(roomnum);
		int hotelnum = otherRoom.getHotelnum();
		String hotelname = otherRoom.getHotelname();
		
		room.setHotelnum(hotelnum);
		room.setHotelname(hotelname);*/
		
		//기존 이미지 + 신규 이미지 처리 
		String path = "/uploadedfile/roomPhoto";
		String dir = req.getSession().getServletContext().getRealPath(path);
		
		String newFileName="";
		
		if(editRoomForm.getRoomimg() != null
				&& editRoomForm.getRoomimg().isEmpty()
				&& editRoomForm.getRoomimg().getSize()>0) {
			
			newFileName = editRoomForm.getRoomname()+"_"+System.nanoTime();
			
			try {
				//새 파일 업로드 
				editRoomForm.getRoomimg().transferTo(new File(dir, newFileName));
				//새 파일 DB 저장 위해 Room 객체에 삽임 
				room.setRoomimg(newFileName);
				
				System.out.println("방 정보 수정 08-1  " +room);
				
				//디렉토리에 있는 이전 파일 삭제 
				File oldFile = new File(dir, editRoomForm.getOldRoomPhoto());
				if(oldFile != null && oldFile.exists()) {
					oldFile.delete();
				}
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {			
			room.setRoomimg(editRoomForm.getOldRoomPhoto());
			System.out.println("방 정보 수정 08-2  " +room);
		}
		
		System.out.println("방 정보 수정 09  " +room);
		
		int rscnt =  dao.editRoom(room);
		System.out.println("방 정보 수정 10  " +rscnt);
		
		return rscnt;
	}
	
	

}
