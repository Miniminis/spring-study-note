package com.gb.mvc;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gb.mvc.model.Message;
import com.gb.mvc.model.Message2;
import com.gb.mvc.model.MessageListView;
import com.gb.mvc.service.GuestBookService;

@Controller
public class GuestBookController {
	
	//서비스
	@Autowired
	GuestBookService gbservice;
	
	//메인페이지 && 글리스트 출력
	@RequestMapping("/gbmain") 
	public String getMain(HttpServletRequest request, Model model) {
		
		//사용자의 요청받기 --> 초기 페이지 1로 설정
		int page = 1;
		
		String pagestr = request.getParameter("page");
		
		System.out.println(pagestr);
		
		if(pagestr != null) {
			page = Integer.parseInt(pagestr);
		}
		
		System.out.println(page);
		
		MessageListView view = gbservice.getList(page);
		
		model.addAttribute("list", view);
		
		return "p03List";
	}	
	
	//글쓰기 폼
	@RequestMapping("/guestWriteForm")
	public String writeForm() {
		return "p01writeForm";
	}

	//글등록
	@RequestMapping(value="/guestWrite", method = RequestMethod.POST)
	public String writeMessage(Message message) {
		
		System.out.println("====SERVICE WRITE===="+message.getGname()+"======");
		
		gbservice.write(message);
		
		return "redirect:/gbmain";
	}


	
	//글 삭제폼
	@RequestMapping("/guestDelForm")
	public String delMessageForm(
			@RequestParam("messageId") int mid,
			Model model) {
		
		model.addAttribute("messageId", mid);
		
		return "p04delForm";
	}
	
	//글삭제
	@RequestMapping(value = "/guestDel", method = RequestMethod.POST)
	public String delMessage(
			@RequestParam("messageId") int mid, 
			@RequestParam("passwordConfirm") String pw,
			Model model
			) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = gbservice.delete(mid, pw);
		
		model.addAllAttributes(resultMap);
		System.out.println("======deleteController chk===="+resultMap.get("chk"));
		System.out.println("======deleteController msg===="+resultMap.get("msg"));
		System.out.println("======deleteController resultCnt===="+resultMap.get("resultCnt"));
				
		return "p05delResult";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////JSON - AJAX로 싱글페이지에서 화면 처리 /////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

	
	//메인페이지 && 글리스트 출력 - JSON 형식 
	@RequestMapping("/gbmain/JSON") 
	@ResponseBody
	public MessageListView getMain(@RequestParam(
									value = "page", 
									defaultValue = "1") int page) {
		
		MessageListView view = gbservice.getList(page);
		//System.out.println("===JSON view"+view);			
		return view;
	}
	
	//글등록
	@RequestMapping(value="/guestWrite/JSON", method = RequestMethod.POST)
	public @ResponseBody int writeMessageJSON(@RequestBody Message2 message) {
		System.out.println("@RequestBody"+message);
		//System.out.println("==JSON SERVICE WRITE=="+message.getGname()+"===");
		
		//int rscnt = gbservice.write(message);
		
		//return rscnt;
		return 0;
	}
	
	//글 삭제폼
	/*@RequestMapping("/guestDelForm/JSON")
	public String delMessageForm(
			@RequestParam("messageId") int mid,
			Model model) {
		
		model.addAttribute("messageId", mid);
		
		return "p04delForm";
	}
	
	//글삭제
	@RequestMapping(value = "/guestDel/JSON", method = RequestMethod.POST)
	public String delMessage(
			@RequestParam("messageId") int mid, 
			@RequestParam("passwordConfirm") String pw,
			Model model
			) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = gbservice.delete(mid, pw);
		
		model.addAllAttributes(resultMap);
		System.out.println("======deleteController chk===="+resultMap.get("chk"));
		System.out.println("======deleteController msg===="+resultMap.get("msg"));
		System.out.println("======deleteController resultCnt===="+resultMap.get("resultCnt"));
				
		return "p05delResult";
	}*/
	
}
