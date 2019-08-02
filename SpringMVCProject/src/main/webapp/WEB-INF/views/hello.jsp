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
	<h1>WELCOME TO HELLO PAGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE</h1>
	
	<h2>username : ${username }</h2>
	<h2>userpw : ${userpw}</h2>
	<h2>greeting : ${greeting }</h2>
	<h2>now : ${now }</h2>
	
	<a href='<c:url value="/header/getheader"/>'>Header Referer</a>
</body>
</html>