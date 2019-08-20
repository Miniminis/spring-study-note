package com.springproject.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailSendController {
	
	@Autowired
	MailSender sender;
	
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo("minhee4735@naver.com");
		msg.setSubject("Spring을 통해 보내는 자동 메일입니다. 너무 설레지마여ㅎ ");
		msg.setText("힝, 속았지?");
		msg.setFrom("minimini");
		
		sender.send(msg);
		
		return "successfully sent";
	}
}
