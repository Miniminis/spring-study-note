package com.bitcamp.ad.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.AddRoomForm;
import com.bitcamp.ad.domain.Room;

@Service("addService")
public class AddService {

	@Autowired
	private SqlSessionTemplate sqltemplate;
	
	private RoomSessionDao roomDao; 
	
	public int addRoom(AddRoomForm addRoomForm, HttpServletRequest req) {
		
		System.out.println("방 등록 03 "+addRoomForm + "/"+req);
		
		roomDao = sqltemplate.getMapper(RoomSessionDao.class);
		
		//form 데이터로 먼저 Room 객체 생성 
		Room room = addRoomForm.toRoom(); //남은 변수 1개: file  
		
		System.out.println("방 등록 04 "+room.toString());
		
		/* 파일 저장*/ 
		 //* 1. 파일 경로 설정 : 상대경로-path /roomPhoto, 절대경로-dir 
		//서버상의 경로 
		String path = "/uploadedfile/roomPhoto";
		//절대 경로 : request, session, servletcontext, getrealpath 
		String dir = req.getSession().getServletContext().getRealPath(path);
		//파일이름 중복 방지를 위한 이름 재정의
		String newfileName = null;
		
		 //* 2. 파일 이름 값 설정 
		 //* 3. 파일 존재 여부에 따라 분기처리 
		if(addRoomForm.getRoomimg() == null) {
			newfileName = "noImg.png";
		} else {
			
			try {
				newfileName = addRoomForm.getRoomname()+"_"+System.nanoTime();
				addRoomForm.getRoomimg().transferTo(new File(dir, newfileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		room.setRoomimg(newfileName);
		System.out.println("방등록 04-1  "+newfileName);
		System.out.println("방 등록 05 "+room.getRoomimg());
		
		//* 4. 완성된 room 객체 DAO 단으로 넘기기
		//* 5. 결과값 받기 */
		
		int rscnt =  roomDao.insert(room);
		
		System.out.println("방 등록 06 "+rscnt);
	
		return rscnt;
	}
	
	

}
