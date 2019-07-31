package com.springproject.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.mvc.service.WriteService;

import WriteService.java.model.User;

@Controller
public class WriteController {
	
	@Autowired
	private WriteService writeService;
	
	//@RequestMapping("/write")
	@RequestMapping(method = RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	//@RequestMapping("/writeForm")
	@RequestMapping(method=RequestMethod.POST)
	public String submit() {
		
		User user = new User(userid, userpw, username, userage);
		
		return "";
	}
	
	public void setWriteService(WriteService writeService) {
		this.writeService = writeService;
	}

}
