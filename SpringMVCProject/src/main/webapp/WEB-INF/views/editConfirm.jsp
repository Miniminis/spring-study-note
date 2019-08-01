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
	<h1>수정 완료 페이지</h1>
	<h2>${user.userid}</h2>
	<h2>${user.userpw}</h2>
	<h2>${user.username}</h2>
	<h2>${user.userage}</h2>
	
	<a href='<c:url value="userlist"/>'>목록되돌아가기</a>

</body>
</html>