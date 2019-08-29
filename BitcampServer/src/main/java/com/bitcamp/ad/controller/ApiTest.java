package com.bitcamp.ad.controller;

//네이버 검색 API 예제 - blog 검색
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testnaverapi")
public class ApiTest {

	@GetMapping()
	@CrossOrigin
	public void naverApiTest(HttpServletResponse rep) {
		
		rep.setContentType("application/json; charset=utf-8");
		
		String clientId = "kc1Ii4tyw6AHPJO4vXNF";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "6VIV74uWXK";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode("호텔 후기", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			String str = response.toString();
			System.out.println(str);
			
			PrintWriter out = rep.getWriter();
			out.println(str);
			
			JSONObject json = new JSONObject();
			json.put("data", str);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}