package com.springproject.mvc.domain;

public class SearchType {
	
	private int num;
	private String name;
	
	public SearchType(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "SearchType [num=" + num + ", name=" + name + "]";
	}
	
	

}
