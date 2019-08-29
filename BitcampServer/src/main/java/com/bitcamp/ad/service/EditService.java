package com.bitcamp.ad.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.ad.dao.RoomSessionDao;
import com.bitcamp.ad.domain.EditRoomForm;
import com.bitcamp.ad.domain.EditRoomPhoto;
import com.bitcamp.ad.domain.Room;

@Service("editService")
public class EditService {
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;

	private RoomSessionDao dao;
	
	
	public int editRoomInfo(EditRoomForm editRoomForm) {
		
		System.out.println("방 정보 수정 07  " +editRoomForm);
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		
		int rscnt =  dao.editRoom(editRoomForm);
		System.out.println("방 정보 수정 10  " +rscnt);
		
		return rscnt;
	}

	
	
	//방 사진 수정
	public int editRoomPhoto(EditRoomPhoto editRoomPhoto,
								HttpServletRequest req) {
		
		dao = sqlTemplate.getMapper(RoomSessionDao.class);
		
		System.out.println("사진수정07  "+editRoomPhoto);
		
		//기존 이미지 + 신규 이미지 처리 
		String path = "/uploadedfile/roomPhoto";
		String dir = req.getSession().getServletContext().getRealPath(path);
		
		String newFileName = null;
		
		
		if(editRoomPhoto.getRoomimg() != null
				&& !editRoomPhoto.getRoomimg().isEmpty()
				&& editRoomPhoto.getRoomimg().getSize()>0) {
			
			newFileName = editRoomPhoto.getRoomname()+"_"+System.nanoTime();
			
			try {
				//새 파일 업로드 
				editRoomPhoto.getRoomimg().transferTo(new File(dir, newFileName));		
				
				//디렉토리에 있는 이전 파일 삭제 
				File oldFile = new File(dir, editRoomPhoto.getOldRoomPhoto());
				if(oldFile != null && oldFile.exists()) {
					oldFile.delete();
				}
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {			
			newFileName = editRoomPhoto.getOldRoomPhoto();
		}
		
		System.out.println("사진수정08  "+newFileName);
		System.out.println("사진수정09  "+editRoomPhoto.getRoomnum());
		int rscnt =  dao.editRoomPhoto(newFileName, editRoomPhoto.getRoomnum());
		
		System.out.println("사진수정10  "+rscnt);
		return rscnt;
	}

}
