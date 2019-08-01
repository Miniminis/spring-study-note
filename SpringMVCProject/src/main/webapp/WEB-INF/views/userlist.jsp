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
		width: 500px;
		border : 1px solid black;
		border-collapse: collapse;
		margin: 0 auto;
	}
	table tr, table td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<h1>userlist 페이지입니다.</h1>

		<table>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>수정 | 삭제</td>
			</tr>
			
			<c:forEach var="user" items="${userlist}">
				<tr>
					<td>${user.userid}</td>
					<td>${user.userpw}</td>
					<td><a href="viewDetail?userid=${user.userid}">${user.username}</a></td>
					<td>${user.userage}</td>
					<td><a href="edit?userid=${user.userid}">수정</a> | <a href="">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<a href='<c:url value="/index.jsp"/>'>index 페이지로 돌아가기 </a>
	
</body>
</html>