package com.springproject.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.mvc.dao.Dao;
import com.springproject.mvc.model.User;

@Service("userservice")
public class UserService {
	
	@Autowired
    BasicDataSource dataSource;
	
	public void enroll(User user) {
		
		Connection conn;
		try {
			conn = dataSource.getConnection();
			System.out.println("1. service"+user);
			Dao dao = Dao.getInstance();
			dao.insert(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//회원리스트 
	public List<User> viewusers(List<User> userlist) {
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Dao dao = Dao.getInstance();
		userlist = dao.viewList(conn, userlist);
		
		//System.out.println("1. "+userlist);
		
		return userlist;
	}

	//회원조회
	public User viewuser(User user, String uNum) {
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
			Dao dao = Dao.getInstance();
			user = dao.select(conn, uNum, user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	//회원수정
	public void editUser(User user, String uid) {
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
			Dao dao = Dao.getInstance();
			dao.update(conn, user, uid);
			System.out.println("2");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//회원삭제 
	
}
