package com.gb.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gb.mvc.model.Message;

@Repository
public class MessageDao {
	
	private MessageDao () {}
	private static MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}
		
	//1. insert 기능 : 게시글 추가기능
	public int insert(Connection conn, Message message) {
		
		String sql = "insert into GUESTBOOK_MESSAGE values (null, ?, ?, ?)";
		//String sql = "insert into guestbook_message (message_id, gname, gpassword, gmessage) values (GM_MID_SEQ.nextval, ?,?,?)";
		PreparedStatement pstmt = null;		
		int resultCnt = 0; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//입력 3. Message 클래스에만 저장되어있었던 게시글 등록 정보가 DB 에 저장됨 
			pstmt.setString(1, message.getGname());
			pstmt.setString(2, message.getGpassword());
			pstmt.setString(3, message.getGmessage());		
			
			resultCnt = pstmt.executeUpdate();
			System.out.println("1"+resultCnt);	
			
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return resultCnt;
		
	}
	
	
	//2. 메시지 선택 기능 
	public Message select(Connection conn, int mid) {
		Message message = null;
		
		String sql02 = "select * from guestbook_message where message_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql02);
			
			pstmt.setInt(1, mid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//사용자가 클릭한 message id 가 데이터 베이스에 있다면, message 객체 생성! 
				message = new Message();
				
				//message 클래스에 데이터베이스에서 받은 데이터를 삽입
				message.setMessage_id(rs.getInt(1));
				message.setGname(rs.getString(2));
				message.setGpassword(rs.getString(3));
				message.setGmessage(rs.getString(4));	
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		//message 타입 반환
		return message;
	}
	
	//3.전체 게시물의 개수 반환 
	public int selectCnt(Connection conn) {
		
		String sql = "select count(*) from guestbook_message";
		Statement stmt = null;
		ResultSet rs = null;
		int totalCnt = 0;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return totalCnt;
	}

	//4. 게시물 리스트 출력 기능 
	public List<Message> selectList(Connection conn, int startRow, int endRow) {
		
		List<Message> list = new ArrayList<Message>();
		
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		//String sql = "select MESSAGE_ID, GNAME, GPASSWORD, GMESSAGE from ( "
		//		+ " select rownum rnum, MESSAGE_ID, GNAME, GPASSWORD, GMESSAGE from ( "
		//		+ " select * from GUESTBOOK_MESSAGE m order by m.message_id desc "   //최근 게시물부터 보이기 : desc 
		//		+ " ) where rownum <= ? "
		//		+ ") where rnum >= ?";
		//정렬 : message_id 순서대로 내림차순 정렬 : 최근 메시지부터 노출 --> rownum의 마지막열과 처음열을 이용해서 페이지 개수인 3개 별로 나눠준 3행짜리 표 
		PreparedStatement pstmt = null;
		ResultSet rs = null; //
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, 3);
			rs = pstmt.executeQuery(); //rs 는 전체 게시물 리스트를 3행마다 쪼갠 3행짜리 표를 갖게 된다.
			
			while(rs.next()) {
				Message msg = new Message();
				
				msg.setMessage_id(rs.getInt(1));
				msg.setGname(rs.getString(2));
				msg.setGpassword(rs.getString(3));
				msg.setGmessage(rs.getString(4));
				
				list.add(msg);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return list;
	}

	//5. 게시물 삭제 기능 
	public int deleteMessage(Connection conn, int mId) throws SQLException {
		
		//PreparedStatement 객체 생성 
		PreparedStatement pstmt = null;
		
		String sql = "delete from guestbook_message where message_id=?";
		//String sql = "delete from guestbook_message where MESSAGE_ID=?";
		int resultCnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mId);
			resultCnt = pstmt.executeUpdate();
		} finally {
			//다른 예외 구문은 Service 페이지에서 처리하므로 catch 구문은 삭제, 여기서는 throw 로 처리 
			//jdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
  
	
}
