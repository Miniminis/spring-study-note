package com.springproject.mvc.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list") //해당 element 태그가 생성될 예정 
public class GuestMessageList {
	
	@XmlElement(name = "message")
	private List<GuestMessage> messages;

	
	public GuestMessageList() {}
	
	public GuestMessageList(List<GuestMessage> messages) {
		super();
		this.messages = messages;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}
}
