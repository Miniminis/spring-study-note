<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		text-align: center;
		margin: 30px auto;
		padding: 50px;
	}
	ul {
		margin: 50px 500px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>webapp 안에 있는 index 페이지 입니다! </h1>
	<hr>
	<ul>
		<li><a href="hello">/hello</a></li>
		<li><a href="homeDBTest">MYSQL DB와 연결된 페이지</a></li>
		<li><a href='<c:url value="/header/getheader"/>'>Header Referer</a></li>
		<li><a href='<c:url value="/search/search"/>'>@ModelAttribute 의 유용성!!!!</a></li>
		<li><a href='<c:url value="/search/search2"/>'>@ModelAttribute 의 유용성2!!!!</a></li>
		<li><a href='<c:url value="/fileupload/uploadForm"/>'>FileUpload </a></li>
		<li><a href="#">보고싶은지현뚜♥</a></li>
		<hr>
		<li><a href="write">회원등록</a></li>
		<li><a href="view">회원리스트 보기</a></li>
	</ul>
</body>
</html>