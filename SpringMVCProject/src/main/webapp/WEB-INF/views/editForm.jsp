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
	table {
		margin: 0 auto;
	}
</style>
</head>
<body>
	<h1>Spring project - MVC 패턴으로 게시글 작성 </h1>
	<hr>
	<form method="post" action="editprocess">
		<table>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
			<tr>
				<td>${user.userid}</td>
				<td><input type="text" name="userpw" value="${user.userpw}"></td>
				<td><input type="text" name="username" value="${user.username}"></td>
				<td><input type="text" name="userage" value="${user.userage}"></td>
			</tr>
		</table>
		<input type="submit" value="edit">
	</form>
</body>
</html>