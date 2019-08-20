package com.springproject.mvc;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {
	
	@Autowired
	private MailSender sender; //단 3개의 매서드로 한정됨 
	
	@Autowired
	private JavaMailSender javaSender; 
	//쓸 수 있는 매서드의 수가 더 많음 
	//MailSender 를 상속받는 구조 - MailSender의 매서드들 모두 포함 
	//: 궁극적으로 이것을 쓰면 모든 매서드 사용이 가능!  
	
	//일반 텍스트 메일 전송 
	@RequestMapping("/mail/send")
	@ResponseBody
	public String sendMail() {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo("minhee4735@naver.com");
		msg.setSubject("Spring을 통해 보내는 자동 메일입니다. 너무 설레지마여ㅎ ");
		msg.setText("힝, 속았지?");
		msg.setFrom("minimini");
		
		sender.send(msg);
		
		return "SUCCESSFULLY SENT";
	}
	
	//html 형식으로 메일 전송
	@RequestMapping("/mail/send02")
	@ResponseBody
	public String sendJavaMainSender() {
		
		//html 형식으로 네일을 보내기 위해서는 mime message를 이용해야만 한다. 
		MimeMessage message = javaSender.createMimeMessage();
		
		try {
			//메일제목
			message.setSubject("[깜!짝!선!물!] 오늘부터 30일 동남아 배낭여행~!", "utf-8");
			
			//메일내용 
			String htmlStr = "<h1 style='color: pink'>또 속았냐옹~!?</h1>"
					+ " <a href='http://www.naver.com'>네이버 로그인 바로 하기 </a>";
			message.setText(htmlStr, "utf-8", "html");
			
			//수신자 
			message.addRecipient(RecipientType.TO, new InternetAddress("minhee4735@naver.com", "니미니미니님*^^*", "utf-8"));
			
			//전송 
			javaSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "A Java Mail was successfully sent!";   
	}
	
	//파일 형식 포함하여 메일 전송 
	@RequestMapping("/mail/send03")
	@ResponseBody
	public String sendFileAttach() {
		
		MimeMessage msg = javaSender.createMimeMessage();
		
		try {
			MimeMessageHelper msghelper = new MimeMessageHelper(msg, true, "utf-8");
			
			msghelper.setSubject("[공지] 공기에 수면제가 들었나, 핵!졸!립!다! ");
			
			String text = "<h1 style='color: lightblue'>잠이온다 잠이와....!</h1>";
			
			msghelper.setText(text, true);
			msghelper.setTo(new InternetAddress("minhee4735@naver.com", "플래쉬님", "utf-8"));
			
			DataSource dataSource 
				= new FileDataSource("C:\\Users\\minhe\\Pictures\\zootopia01.jpg");
			
			msghelper.addAttachment(MimeUtility.encodeText(
									"zootopia01.jpg", "utf-8", "B"), dataSource);
			
			javaSender.send(msg);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "A Mail with File was successfully sent";
	}
}
