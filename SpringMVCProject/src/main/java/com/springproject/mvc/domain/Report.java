package com.springproject.mvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {
	
	private String snum;
	private MultipartFile sreport;
	
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public MultipartFile getSreport() {
		return sreport;
	}
	public void setSreport(MultipartFile sreport) {
		this.sreport = sreport;
	}
	
	public long getFileSize() {
		return sreport.getSize();
	}
	
	public String getFileName() {
		return sreport.getOriginalFilename();
	}
	

	
}
