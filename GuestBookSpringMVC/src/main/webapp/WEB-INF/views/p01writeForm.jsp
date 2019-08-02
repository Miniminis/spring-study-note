<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		margin: 200px;
		text-align: center;
	}
	table {
		margin: 0 auto;
	}
	

</style>

</head>
<body>
	<h2>방명록 글쓰기</h2>
	<hr>
	<form action="guestWrite" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="gname"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="gpassword"></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea rows="3" cols="30" name="gmessage"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록하기"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>