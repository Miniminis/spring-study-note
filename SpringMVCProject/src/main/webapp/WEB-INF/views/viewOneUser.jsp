<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>회원정보 상세페이지</h1>
	<ul>
		<li>회원아이디 : ${user.userid}</li>
		<li>회원 비밀번호 : ${user.userpw}</li>
		<li>회원 이름 : ${user.username}</li>
		<li>회원 나이 : ${user.userage}</li>
	</ul>
	<a href='<c:url value="/view"/>'>목록으로 되돌아가기</a>
</body>
</html>