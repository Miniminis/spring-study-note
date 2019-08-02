<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		text-align: center;
	}
	table {
		margin : 30px auto;
	}
</style>
</head>
<body>
	<h1>@RequestParam 을 이용한 파일 업로드 처리 </h1>
	<hr>
	<form action="upload1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="snum"></td>
			</tr>
			<tr>
				<td>과제</td>
				<td><input type="file" name="sreport"></td>
			</tr>
		</table>
		<input type="submit" value="제출하기">
	</form>
	
	
	
	
	<h1>MultipartHttpRequest 를 이용한 파일 업로드 처리 </h1>
	<hr>
	<form action="upload02" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="snum"></td>
			</tr>
			<tr>
				<td>과제</td>
				<td><input type="file" name="sreport"></td>
			</tr>
		</table>
		<input type="submit" value="제출하기">
	</form>
		
		
		
		
	<h1>커맨드 객체 를 이용한 파일 업로드 처리 </h1>
	<hr>
	<form action="upload03" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="snum"></td>
			</tr>
			<tr>
				<td>과제</td>
				<td><input type="file" name="sreport">	<input type="submit" value="제출하기"></td>
			</tr>
		</table>
	
	</form>
</body>
</html>