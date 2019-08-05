package com.gb.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gb.mvc.dao.MessageDao;
import com.gb.mvc.exception.InvalidMessagePasswordException;
import com.gb.mvc.exception.MessageNotFoundException;
import com.gb.mvc.model.Message;
import com.gb.mvc.model.MessageListView;

@Service
public class GuestBookService {
	
	@Autowired
	BasicDataSource dataSource;
	
	//글등록
	public void write(Message message) {
		
		Connection conn;
		
		try {
			conn = dataSource.getConnection();
			
			MessageDao dao = MessageDao.getInstance();
			int rscnt = dao.insert(conn, message);
			
			System.out.println("service"+message.getGname());
			System.out.println("2"+rscnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//글리스트출력
	public MessageListView getList(int page) {
		
		//MessageListView 변수선언 
		MessageListView view = null; 
		
		view = getMessageListView(view, page);
		
		return view;
		
	}
	
	//MessageListView를 생성해서 결과로 반환! 
	//1. 페이지 별 방명록의 수 : 기획안에 따라 3으로 상수  선언 
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	//MessageListView을 출력하는 매서드 
	public MessageListView getMessageListView(MessageListView view, int pageNumber) {
				
		//2. 현재페이지 번호 
		int curretPageNumber = pageNumber;
		
		//connection
		Connection conn;
		
		
		try {
			//Connection
			conn = dataSource.getConnection();
			
			//DAO
			MessageDao dao = MessageDao.getInstance();
			
			//전체 게시물의 개수 
			int messageTotalCnt = dao.selectCnt(conn);
			
			//게시물 내용 리스트, DB 검색에 사용할 startRow, endRow
			List<Message> messageList = null;
			int startRow = 0;
			int endRow=0;
			
			if(messageTotalCnt >0) {
				
				//파라미터로 넘겨받은 pageNumber 에 따라서 게시판 리스트의 시작로우와 끝 로우가 정해진다.
				startRow = (pageNumber -1)*MESSAGE_COUNT_PER_PAGE +1;
				endRow = startRow + MESSAGE_COUNT_PER_PAGE -1;
				
				messageList = dao.selectList(conn, startRow, endRow);
				
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
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return view;
	}
	//글삭제
	public Map<String, Object> delete (int mid, String pw) {
		
		int resultCnt = 0; //삭제 실행 결과담을 변수 설정 
		boolean chk = false; //비밀번호 유효성 검사 결과 담은 체크 결과 담을 변수 설정  
		String msg = ""; //삭제 실행 결과에 따라 다른 메시지 출력 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			resultCnt = deleteMessage(mid, pw);
			chk = true;
			
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
		
		return map;
	}
	
	public int deleteMessage(int mId, String pw) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
		
		int resultCnt = 0;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			//1. 전달받은 게시물 아이디 mId로 게시물 확인
			//- MessageDao 필요 --> 원하는 게시물 선택 select() 
			MessageDao dao = MessageDao.getInstance();
			Message message = dao.select(conn, mId);
			
			//2. 게시물이 존재하지 않으면 예외처리 
			if(message == null) {
				throw new MessageNotFoundException(mId+"번 메시지가 존재하지 않습니다.");
			}
			
			//3. 게시물이 존재하면 비밀번호 확인 (존재 여부 있다, 없다 ) --> 없으면 예외처리  
			//4. 비밀번호가 존재하면 --> 비밀번호가 존재하지 않거나 사용자 비밀번호가 틀린 경우에 대해 예외처리
			if(!message.hasPassword()) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
			}
			
			//비밀번호 비교
			if(!message.matchPassword(pw)) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
			}
			 
			
			//5. 비밀번호가 존재하고 일치한다면 --> 정상처리 commit 
			resultCnt = dao.deleteMessage(conn, mId);
			
			//트랜잭션 종료 : 정상처리
			conn.commit(); 
			
		} catch (SQLException e) {
			//트랜잭션의 롤백: 마지막 커밋 위치로 이동 
			dataSource.getConnection().rollback();
			e.printStackTrace();
			throw e;
		} catch (MessageNotFoundException e) {
			dataSource.getConnection().rollback();;
			e.printStackTrace();
			throw e;
		} catch (InvalidMessagePasswordException e) {
			dataSource.getConnection().rollback();;
			e.printStackTrace();
			throw e;
		}  
		
		return resultCnt;
		
	}
}
