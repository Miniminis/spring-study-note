package com.springproject.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springproject.mvc.domain.GuestMessage;
import com.springproject.mvc.domain.GuestMessageList;

@Controller
public class GuestListController {
	
	@RequestMapping(value = "/guestmessage/list.xml")
	@ResponseBody
	public GuestMessageList xmlList() {
		return getMessageList();
	}

	private GuestMessageList getMessageList() {
		
		List<GuestMessage> messages = new ArrayList<GuestMessage>();
		
		messages.add(new GuestMessage(1, "메시지임당~!", new Date()));
		messages.add(new GuestMessage(2, "수업 시간~!", new Date()));
		
		return new GuestMessageList(messages);
	}
}

/* DOM parser: 느리고  시간이 오래걸림. 하지만 일단 올려놓으면 빠르게 처리가능
 * & sax parser : 시간이 그리 오래 걸리지는 않으나 찾는시간 문제 - 안드로이드에서 주로 사용.  
 * */