package com.springproject.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	//FrontController 로 전송할 view 경로 + 결과 데이터를 저장하고 전달할 객체
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("hello");	//WEB-INF/views/hello.jsp 
		//model : .addObject 로 여러개 전달 가능 
		//view : 하지만 view page는 하나만! 
		
		modelAndView.addObject("username", "나니아 연대기 사자마녀 ");
		modelAndView.addObject("userpw", "그리고 옷장");
		modelAndView.addObject("greeting", "아래날짜 대 개 봉 ");
		modelAndView.addObject("now", new Date());
		
		return modelAndView; //Dispatcher 는 hello라는 뷰페이지 + 네 개의 모델 데이터를 전달받게 된다. 
	}
	

}
