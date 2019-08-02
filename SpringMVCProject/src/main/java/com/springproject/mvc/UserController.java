package com.springproject.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.mvc.model.User;
import com.springproject.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//@RequestMapping("/write")
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	//@RequestMapping("/writeForm")
	@RequestMapping(value = "/writeForm", method=RequestMethod.POST)
	public String submit(@ModelAttribute("user") User user) {
		
		userservice.enroll(user);
		
		return "redirect:view";
	}
	
	//회원리스트 
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewList(Model model) {
		
		List<User> userlist = new ArrayList<User>();
		
		//System.out.println("1");
		
		userlist = userservice.viewusers(userlist);
		model.addAttribute("userlist", userlist);
		//view 페이지로 데이터가 담긴 객체를 보내주려면 반드시 model 에 담아야 한다. 
		
		return "userlist";
		
		//파라미터: 페이지 번호 --> List<> 생성 --> Model 에 담아서 --> view page 에 공유 
	}
	
	//회원조회
	@RequestMapping(value = "/viewDetail", method = RequestMethod.GET)
	public String viewDetail(@ModelAttribute("user") User user, 
								@RequestParam("userid") String uid) {
				
		//String uid = req.getParameter("userid");
		userservice.viewuser(user, uid);
		
		return  "viewOneUser";
		
		//@ModelAttribute("user") User user 
		//- 커맨드 객체 : http 요청 파라미터를 저장한 객체 
		//- view page 에서 form 을 통해 받은 파라미터들의 name 값 == User 객체의 변수 값 
		//- 자동으로 객체에 파라미터 값을 대입해준다. 
		// - 다음 view page 에서 사용 가능 
		
	}
	//회원수정
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@ModelAttribute("user") User user, 
							@RequestParam("userid") String uid) {
		
		userservice.viewuser(user, uid);
		
		return "editForm";
		
		//RequestParam : 1-2 개 등 간단한 파라미터를 받을 때 사용 --> 페이지 번호 등 
		//파라미터: 글번호 --> user 객체 생성 --> DB 정보 받아서 담기 --> Model 에 담아서 view 페이지와 공유 
	}
	
	@RequestMapping(value = "/editprocess", method = RequestMethod.POST)
	public String editProcess(@ModelAttribute("user") User user, 
								@RequestParam("userid") String uid) {
		
		userservice.editUser(user, uid);
		
		System.out.println(user+uid);
		
		return "editConfirm";
		
		//RequestParam : 1-2 개 등 간단한 파라미터를 받을 때 사용 --> 페이지 번호 등 
		//파라미터: 글번호 --> user 객체 생성 --> DB 정보 받아서 담기 --> Model 에 담아서 view 페이지와 공유 
	}
	//회원삭제 
	
	//RequestParam : 1-2 개 등 간단한 파라미터를 받을 때 사용 --> 페이지 번호 등 
	//파라미터: 글번호 --> user 객체 생성 --> DB 정보 받아서 담기 --> Model 에 담아서 view 페이지와 공유 

}
