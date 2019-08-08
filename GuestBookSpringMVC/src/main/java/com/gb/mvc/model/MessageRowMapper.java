package com.gb.mvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

		Message msg = new Message();
		
		msg.setMessage_id(rs.getInt(1));
		msg.setGname(rs.getString(2));
		msg.setGpassword(rs.getString(3));
		msg.setGmessage(rs.getString(4));
		
		
		return msg;
	}

}
