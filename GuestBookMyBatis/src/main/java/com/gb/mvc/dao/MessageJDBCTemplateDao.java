package com.gb.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gb.mvc.model.Message;
import com.gb.mvc.model.MessageRowMapper;

@Repository("jdbcTemplateDao")
public class MessageJDBCTemplateDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
			
	//1. insert 기능 : 게시글 추가기능
	public int insert(Message message) {
				
		String sql = "insert into GUESTBOOK_MESSAGE values (null, ?, ?, ?)";
		
		return jdbcTemplate.update(sql, 
							message.getGname(), 
							message.getGpassword(), 
							message.getGmessage());
	}
	
	
	//2. 메시지 선택 기능 
	public Message select(int mid) {

		String sql = "select * from guestbook_message where message_id=?";
		
		return jdbcTemplate.queryForObject(sql, new MessageRowMapper(), mid);
		
	}

	
	//3.전체 게시물의 개수 반환 
	public int selectCnt() {
		
		String sql = "select count(*) from guestbook_message";
		Integer totalCnt = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return totalCnt;
	}

	
	//4-1) 게시물 리스트 출력 기능 - 클래스 생성 않고 DAO 내부에서 처리
	/*public List<Message> selectList(int startRow, int endRow) {
		
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		List<Message> list = jdbcTemplate.query(sql, new RowMapper<Message>(){

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message(
										rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4)
										);
				
				return message;
			}
		}, startRow, 3); 
		
		return list;
	}*/
	
	//4-2) 게시물 리스트 출력 기능 - rowmapper 클래스 따로 만들어서 처리 
	public List<Message> selectList(int startRow, int endRow) {
		
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		
		return jdbcTemplate.query(sql, new MessageRowMapper(), startRow, endRow); 
		
	}


	//5. 게시물 삭제 기능 
	//@transactional 어노테이션 통해서 스프링 통해 트랜잭션 처리 
	@Transactional
	public int deleteMessage(int mId) {
		
		String sql = "delete from guestbook_message where message_id=?";
		
		return jdbcTemplate.update(sql, mId);
		//String sql = "delete from guestbook_message where MESSAGE_ID=?";		
	}

}


