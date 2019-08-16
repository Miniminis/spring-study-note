package com.gb.mvc.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.mvc.dao.MessageJDBCTemplateDao;
import com.gb.mvc.dao.MessageSessionDao;
import com.gb.mvc.dao.MessageSessionTemplateDao;
import com.gb.mvc.exception.InvalidMessagePasswordException;
import com.gb.mvc.exception.MessageNotFoundException;
import com.gb.mvc.model.Message;
import com.gb.mvc.model.MessageListView;

@Service("gbservice")
public class GuestBookService {
	
	//@Autowired
	//private MessageSessionTemplateDao sqlSessionTemplateDao;
	
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	private MessageSessionDao msgSessionDao;
	
	//글등록
	public int write(Message message) {
		
		msgSessionDao = sqlTemplate.getMapper(MessageSessionDao.class);
		
		System.out.println("2  "+message);
		return msgSessionDao.insert(message); 				
	}
	
	
	//글리스트출력
	public MessageListView getList(int page) {
		
		//MessageListView 변수선언 
		MessageListView view = null; 
		System.out.println("2  "+page);
		view = getMessageListView(view, page);
		
		System.out.println("5   "+view);
		return view;
		
	}
	
	//MessageListView를 생성해서 결과로 반환! 
	//1. 페이지 별 방명록의 수 : 기획안에 따라 3으로 상수  선언 
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	//MessageListView을 출력하는 매서드 
	public MessageListView getMessageListView(MessageListView view, 
												int pageNumber) {
		
		//dao생성
		msgSessionDao = sqlTemplate.getMapper(MessageSessionDao.class);
		
		//2. 현재페이지 번호 
		int curretPageNumber = pageNumber;
		
		//전체 게시물의 개수 
		int messageTotalCnt = msgSessionDao.selectCnt();
						
		//게시물 내용 리스트, DB 검색에 사용할 startRow, endRow
		List<Message> messageList = null;
		int startRow = 0;
		int endRow= 0;
			
		if(messageTotalCnt >0) {
			
			//파라미터로 넘겨받은 pageNumber 에 따라서 게시판 리스트의 시작로우와 끝 로우가 정해진다.
			startRow = (pageNumber -1)*MESSAGE_COUNT_PER_PAGE;
			//endRow = startRow + MESSAGE_COUNT_PER_PAGE -1;
			endRow = 3;
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			
			System.out.println("3  "+map);
			
			messageList = msgSessionDao.selectList(map);
			
		} else {
			curretPageNumber = 0;
			messageList = Collections.emptyList();
		}
		
		view = new MessageListView(
				messageTotalCnt, 
				curretPageNumber, 
				messageList, 
				MESSAGE_COUNT_PER_PAGE, 
				startRow, 
				endRow
				); 
		
		System.out.println("4   "+view);
		
		return view;
	}
	
	//글삭제
	public Map<String, Object> delete (int mid, String pw) {
		
		int resultCnt = 0; //삭제 실행 결과담을 변수 설정 
		boolean chk = false; //비밀번호 유효성 검사 결과 담은 체크 결과 담을 변수 설정  
		String msg = ""; //삭제 실행 결과에 따라 다른 메시지 출력 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			System.out.println("d2  "+mid+"/"+pw);
			resultCnt = deleteMessage(mid, pw);
			chk = true;
			System.out.println("d3  "+resultCnt);

		} catch (SQLException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidMessagePasswordException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		map.put("resultCnt", resultCnt);
		map.put("chk", chk);
		map.put("msg", msg);

		System.out.println("d4  "+map);
		return map;
	}
	
	public int deleteMessage(int mId, String pw) throws SQLException, 
														MessageNotFoundException, 
														InvalidMessagePasswordException {
		
		msgSessionDao = sqlTemplate.getMapper(MessageSessionDao.class);
		
		//1. 전달받은 게시물 아이디 mId로 게시물 확인
		//- MessageDao 필요 --> 원하는 게시물 선택 select() 
		Message message = msgSessionDao.select(mId);
		System.out.println("d2-1  "+message);
		
		//2. 게시물이 존재하지 않으면 예외처리 
		if(message == null) {
			throw new MessageNotFoundException(mId+"번 메시지가 존재하지 않습니다.");
		}
		
		//3. 게시물이 존재하면 비밀번호 확인 (존재 여부 있다, 없다 ) --> 없으면 예외처리  
		//4. 비밀번호가 존재하면 --> 비밀번호가 존재하지 않거나 사용자 비밀번호가 틀린 경우에 대해 예외처리
		if(!message.hasPassword()) {
			throw new InvalidMessagePasswordException("비밀번호가 존재하지 않습니다.");
		}
		
		//비밀번호 비교
		if(!message.matchPassword(pw)) {
			throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
		}
			 
		//5. 비밀번호가 존재하고 일치한다면 --> 정상처리 commit 
		return msgSessionDao.deleteMessage(mId); 

	}
	
}
