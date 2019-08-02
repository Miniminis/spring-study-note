<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	body {
		margin: 200px;
		text-align: center;
	}

</style>
</head>
<body>
	<h2>방명록 삭제</h2>
	<hr>
	<h4>messageId 넘어오니? : ${messageId}</h4>
	
	<form action="guestDel" method="post">
		<h3>${messageId}번 게시물을 삭제하려면 비밀번호를 입력해주세요.</h3>  <!-- param. ~ 을 통해서 서비스에서 보낸 파라미터를 받을 수 있다.   -->
		<input type="hidden" name="messageId" value='${messageId}'>
		<input type="password" name="passwordConfirm" required><br>
		<input type="submit" value="삭제하기">
	</form>	
</body>
</html>