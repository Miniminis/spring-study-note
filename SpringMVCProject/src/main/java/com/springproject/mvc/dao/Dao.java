package com.springproject.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springproject.mvc.model.User;

@Repository
public class Dao {
	
	private Dao(){}; 
	private static Dao dao = new Dao();
	public static Dao getInstance() {
		return dao;
	}
	
	//회원등록
	public void insert(Connection conn, User user) {
		PreparedStatement pstmt;
		String sql = "insert user values(?,?,?,?)";
		int rscnt = 0;
		
		try {
			System.out.println("2. dao "+user);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getUserage());
			
			rscnt = pstmt.executeUpdate();
			System.out.println("3. pstmt result: "+rscnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원리스트
	public List<User> viewList(Connection conn, List<User> userlist) {
		
		Statement stmt = null;
		String sql = "select * from user";
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User();
				
				user.setUserid(rs.getString(1));
				user.setUserpw(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setUserage(rs.getString(4));
				
				//System.out.println("1"+user);
				
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return userlist;
	}

	//회원조회
	public User select(Connection conn, String uNum, User user) {
		
		PreparedStatement pstmt; 
		String sql = "select * from user where userid =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, uNum);
			ResultSet rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUserid(rs.getString(1));
				user.setUserpw(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setUserage(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	//회원수정
	public void update(Connection conn, User user, String uid) {
		
		PreparedStatement pstmt;
		String sql = "update user set userpw=?, username=?, userage=? where userid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("user"+user+"uid"+uid);
			
			pstmt.setString(1, user.getUserpw());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getUserage());
			pstmt.setString(4, uid);
			
			int rs = pstmt.executeUpdate();
			
			System.out.println("rs from update"+rs+"userid"+uid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//회원삭제
	

}
