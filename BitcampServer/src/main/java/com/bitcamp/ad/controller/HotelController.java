package com.bitcamp.ad.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.helpers.IOUtils;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	@GetMapping()
	@CrossOrigin
	public void getHotelList(HttpServletRequest req, 
								HttpServletResponse rep,
								@RequestParam("pageNo") int pageNo
								) throws IOException {
		
		req.setCharacterEncoding("utf-8"); 
		rep.setContentType("text/html; charset=utf-8");
		
		System.out.println("컨트톨러에서 pageNo 받아지니? "+pageNo);
		
		
		String address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay?"
				+ "ServiceKey=iA5SFu8j3sfAOrfx1%2Fl76Q%2BGo2963ingKmSugopRBjtv80927wny9zzCvWuY5cCUyTeVZAN3hAdg1%2BYLKfB3%2Bg%3D%3D";
		
		String param = "";
		
		param += "&areaCode="+ "";
		param += "&sigunguCode="+ "";
		param += "&MobileOS=ETC";
		param += "&MobileApp=Bitcamp";
		param += "&listYN=Y";
		param += "&arrange=A";
		param += "&numOfRows="+ 9;
		param += "&pageNo="+ pageNo;
		param += "&_type=json";
		
		address = address + param;
		
		URL url = new URL(address); 
		
		System.out.println("address 01 "+address); //만들어진 url 확인
		
		InputStream in = url.openStream(); 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		IOUtils.copy(in, bos);
		
		in.close();
		bos.close();
		
		String mbos = bos.toString("utf-8");
		
		byte[] b = mbos.getBytes("utf-8");
		String str = new String(b, "utf-8");
		
		PrintWriter out = rep.getWriter();
		out.println(str);
		
		JSONObject json = new JSONObject();
		json.put("data", str);
		
	}
}
