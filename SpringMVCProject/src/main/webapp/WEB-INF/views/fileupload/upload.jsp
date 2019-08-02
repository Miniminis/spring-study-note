<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>file upload 결과 페이지 </h1>
	<hr>
	
	<h3>학번 : ${snum }</h3>
	<h3>리포트 : ${filename }(${filesize} byte)</h3>
	
	<h1>file upload 결과 페이지 - 커맨드 객체 이용 </h1>
	<hr>
	
	<h3>학번 : ${report.snum}</h3>
	<h3>리포트 : ${report.fileName}(${report.fileSize} byte)</h3>
	
</body>
</html>