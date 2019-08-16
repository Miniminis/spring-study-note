package com.gb.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gb.mvc.model.Message;
import com.gb.mvc.model.MessageListView;
import com.gb.mvc.service.GuestBookService;

@Controller
@RequestMapping("/api/guest")
public class GuestBookRestController {
	
	/* uri 
	 * context path : http://localhost:8080/gbmb/
	 * 메시지리스트: api/guest + get
	 * 메시지등록: api/guest + post
	 * 메시지삭제: api/guest/+ {idx} + delete  
	 * 메시지수정: api/guest/+ {idx} + update 
	 * */
	
	//서비스
	@Autowired
	private GuestBookService gbservice;
	
	
	//리스트
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin
	public @ResponseBody MessageListView getList(
			@RequestParam("page") int page) {
		
		System.out.println("1  "+page);
		return gbservice.getList(page);
	}
	
	//등록
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody int regMsg(@RequestBody Message message) {
		
		System.out.println("1   "+message);
		return gbservice.write(message); 
	}
	
	//삭제
	@RequestMapping(value = "/{mid}/{pwchk}", method = RequestMethod.DELETE)
	@CrossOrigin
	public @ResponseBody int delMsg(
			@PathVariable("mid") int mid,
			@PathVariable("pwchk") String pw) {
		
		//1) HttpServletRequest req
		//String pw = req.getParameter("passwordConfirm"); - null 값들어옴
		//2) @RequestParam("passwordConfirm") String pw - 405 ERROR
		//3) @RequestBody String pw  - 결과 없음, 매서드 실행 자체를 안함. 
		//4) url을 통해서 mid, pwchk 넘겨서 @pathvariable로 받음 - 성공적으로 처리됨
		
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("d1  "+mid+" / "+pw); //d1  18/{"passwordConfirm":"777777"} - json 문자열 형태 : 파싱이 필요  
		
		map = gbservice.delete(mid, pw);
		System.out.println("d5  "+map);
		
		return (int) map.get("resultCnt");
		//반환 java map - 출력: js 단 에서 가능한지 알아보기 
	}
	//수정 

}
