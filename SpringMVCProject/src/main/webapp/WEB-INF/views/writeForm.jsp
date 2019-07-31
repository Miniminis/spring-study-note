<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form method="post" action="writeForm">
		<table>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
			<tr>
				<td><input type="text" name="userid"></td>
				<td><input type="text" name="userpw"></td>
				<td><input type="text" name="username"></td>
				<td><input type="text" name="userage"></td>
			</tr>
		</table>
		<input type="submit" value="value-post 요청">
	</form>
</body>
</html>