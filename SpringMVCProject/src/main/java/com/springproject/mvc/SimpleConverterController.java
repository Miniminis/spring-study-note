package com.springproject.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/simpleRest")
public class SimpleConverterController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String simpleForm() {
		return "/rest/simpleRest";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String simple(@RequestBody String body) {
		
		System.out.println("==SIMPLE CONTROLLER - POST :  "+body);
		
		return body;
	}

}
