package com.springproject.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.mvc.domain.Login;

@RestController
//@RequestMapping("/restapi/{id}") //이후 매서드 단에서 mapping method의 유형에 따라 같은 uri로 다른 처리가 가능
public class RestAPIController {
	
	//@GetMapping(value = "/restapi/hello") //아예 매서드의 방식이 get으로 정해져 있음
	//@PostMapping(value = "/restapi/hello") 
	//@PutMapping(value = "/restapi/hello") 
	//@DeleteMapping(value = "/restapi/hello") 
	@RequestMapping(value = "/restapi/hello", method = RequestMethod.GET)
	public String hello() {
		
		return "hello";
	}
	
	@RequestMapping("restapi/login") //json 객체로 반환
	public Login login() {
		
		Login login = new Login();
		login.setuId("miniss");
		login.setuPw("1234");
		
		return login;
	}
	
	@RequestMapping("restapi/loginlist")
	public List<Login>loginlist() {
		
		List<Login> loginlist = new ArrayList<Login>();
		
		Login login = new Login();
		login.setuId("miniss");
		login.setuPw("1234");
		
		loginlist.add(login);
		
		login = new Login();
		login.setuId("yoojin123");
		login.setuPw("1234");
		loginlist.add(login);
		

		login = new Login();
		login.setuId("marco");
		login.setuPw("1111");
		loginlist.add(login);
		
		return loginlist;
	}
	
	@RequestMapping("restapi/loginmap")
	public Map<String, Login> loginmap() {
		
		Map<String, Login> loginmap = new HashMap<String, Login>();
		
		Login login = new Login();
		login.setuId("miniss");
		login.setuPw("1234");
		
		loginmap.put("1", login);
		
		login = new Login();
		login.setuId("yoojin123");
		login.setuPw("1234");
		loginmap.put("2", login);

		login = new Login();
		login.setuId("marco");
		login.setuPw("1111");
		loginmap.put("3", login);
		
		
		return loginmap;
	}
}
