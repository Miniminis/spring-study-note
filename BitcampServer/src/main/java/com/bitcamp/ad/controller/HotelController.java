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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	
	//private static final String SERVICEKEY = "ServiceKey=iA5SFu8j3sfAOrfx1%2Fl76Q%2BGo2963ingKmSugopRBjtv80927wny9zzCvWuY5cCUyTeVZAN3hAdg1%2BYLKfB3%2Bg%3D%3D";
	
	@GetMapping()
	@CrossOrigin
	public void getHotelList(HttpServletRequest req, 
								HttpServletResponse rep,
								@RequestParam("pageNo") int pageNo
								) throws IOException {
		
		req.setCharacterEncoding("utf-8"); 
		rep.setContentType("text/html; charset=utf-8");
		
		System.out.println("여기 오니 02  "+pageNo);

		String address = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay?";

		String serviceKey = "ServiceKey=iA5SFu8j3sfAOrfx1%2Fl76Q%2BGo2963ingKmSugopRBjtv80927wny9zzCvWuY5cCUyTeVZAN3hAdg1%2BYLKfB3%2Bg%3D%3D";
		
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
		
		address = address + serviceKey +param;
		
		//makeJsonObject(rep, address);
		
		URL url = new URL(address); 
		
		System.out.println("여기 오니 03  "+address); //만들어진 url 확인
		
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
		System.out.println("여기 오니 04 "+json);
		
		json.put("data", str);
		System.out.println("여기 오니 05 "+json);
		
		System.out.println("여기 오니 06 "+str);
		
	};
	
	//상세보기
	@GetMapping("/{id}")
	@CrossOrigin
	public void getHotelDetail(HttpServletRequest req, 
								HttpServletResponse rep,
								@PathVariable("id") String contentid
								) throws IOException {
		
		req.setCharacterEncoding("utf-8"); 
		rep.setContentType("text/html; charset=utf-8");
		
		System.out.println("상세보기 02 "+contentid);
		
		String address ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?";
		
		String serviceKey = "ServiceKey=iA5SFu8j3sfAOrfx1%2Fl76Q%2BGo2963ingKmSugopRBjtv80927wny9zzCvWuY5cCUyTeVZAN3hAdg1%2BYLKfB3%2Bg%3D%3D";
		
		String param ="";
		
		param += "&contentTypeId=32";
		param += "&contentId="+contentid;
		param += "&MobileOS=ETC";
		param += "&MobileApp=Bitcamp";
		param += "&defaultYN=Y";
		param += "&firstImageYN=Y";
		param += "&areacodeYN=Y";
		param += "&catcodeYN=Y";
		param += "&addrinfoYN=Y";
		param += "&mapinfoYN=Y";
		param += "&overviewYN=Y";
		param += "&transGuideYN=Y";
		param += "&_type=json";
		
		address = address + serviceKey + param;		
		
		//makeJsonObject(rep, address);
		//System.out.println("여기까지오니02222? ");
		
		URL url = new URL(address); 
		
		System.out.println("상세보기 03 "+address); //만들어진 url 확인
		
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

		System.out.println("상세보기 04 "+str);
		System.out.println("상세보기 05 "+json);

	}
	
	/*public void makeJsonObject(HttpServletResponse rep, String address) 
								throws IOException {
		
		URL url = new URL(address); 
		
		System.out.println("address 확인! "+address); //만들어진 url 확인
		
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
		
		System.out.println("여기까지오니? ");
	}*/
	
}
