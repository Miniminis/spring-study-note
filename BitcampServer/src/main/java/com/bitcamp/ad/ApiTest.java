package com.bitcamp.ad;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.helpers.IOUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {
	
	@GetMapping()
	@CrossOrigin
	public void test (HttpServletRequest req, 
						HttpServletResponse rep) throws IOException {
		
		req.setCharacterEncoding("utf-8");
		rep.setContentType("text/html; charset=utf-8"); 
		
		String address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay?serviceKey=iA5SFu8j3sfAOrfx1%2Fl76Q%2BGo2963ingKmSugopRBjtv80927wny9zzCvWuY5cCUyTeVZAN3hAdg1%2BYLKfB3%2Bg%3D%3D&numOfRows=10&pageSize=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&arrange=A&listYN=Y&hanOk=1&_type=json";
	
		URL url = new URL(address);
		
		System.out.println(address);
		
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
		
	};

}
