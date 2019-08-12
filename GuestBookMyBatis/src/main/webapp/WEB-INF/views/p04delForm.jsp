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
	
	#writeArea {
		margin: 100px 300px;
		text-align: center;
	}
	
	.mr-10 {
		margin: 10px 0;
	}

</style>
</head>
<body>
	<div id="writeArea">
	<h2>DELETE MESSAGE</h2>
	<hr>
	<h4>messageId 넘어오니? : ${messageId}</h4>	
	
	<form action="guestDel" method="post">
		<input type="hidden" name="messageId" value='${messageId}'>
		
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
		  </div>
		  <input type="password" name="passwordConfirm" class="form-control" aria-label="Sizing example input" 
		  		aria-describedby="inputGroup-sizing-default" required>
		</div>		
		<input type="submit" value="삭제하기" class="btn btn-light mr-10">
	</form>
	
	</div>
</body>
</html>