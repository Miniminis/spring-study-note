package com.gb.mvc.dao;

import java.util.List;
import java.util.Map;

import com.gb.mvc.model.Message;

public interface MessageSessionDao {
	
	public int insert(Message message);
	public Message select(int mid);
	public int selectCnt();
	public List<Message> selectList(Map<String, Object> map);
	public int deleteMessage(int mId);
}