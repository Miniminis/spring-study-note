<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Flow 정리 
1. 웹브라우저: 사용자 요청 uri 
2. web.xml
- 등록된 DispatcherServlet 으로 처리 
- 파라미터로 servlet-context.xml 전달 : 이 파일도 같이 읽음 
3. servlet-context.xml (Handler Mapping)
- HomeController 등록 : either 어노테이션 방식 or xml 에서 빈 객체 등록 
- ViewResolver 등록: 등록된 프로퍼티 방식으로 뷰페이지 경로 설정됨 
4. HomeController 
- return 뷰페이지 + model에 담긴 데이터 정보
- + model 에 전달하고자 하는 데이터 담아서 보내기 
	- 사용자 요청에 맞는 service 및 model, dao 에 접근하여 데이터 받아오기 
5. view resolver 
- controller 에서 받은 view 페이지 정보를 등록된 view resolver 형식에 맞게 
uri 구성해서 return 
6. 응답 뷰 jsp 페이지
-->