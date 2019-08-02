<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	table {
		margin: 0 auto;
	}
	
	div {
		margin: 5px auto;
		width: 700px;
		border: 2px solid #333;
	}
	
</style>
</head>
<body>
	<h3>
		${list.messageTotalCnt}
		${list.currentPageNumber}
		${list.pageTotalCnt}
		${list.messageCountPerPage}
		${list.startRow}
		${list.endRow}
	</h3> 
	
	<hr>
	
	<a href="<c:url value="/guestWriteForm"/>">새로운 글 등록하기</a>
	
	<hr>
	<c:forEach items="${list.messageList}" var="message">
		<div>
			<table>
				<tr>
					<td>메시지번호 : ${message.message_id}</td>
					<td>손님이름 : ${message.gname }</td>
					<td>메시지 : ${message.gmessage }</td>
					<td>비밀번호: ${message.gpassword }</td>
					<td><a href="guestDelForm?messageId=${message.message_id}">삭제하기</a></td>
				</tr>
			</table>
		</div>
	</c:forEach>
	
	<c:forEach begin="1" end="${list.pageTotalCnt}" step="1" var="i">
		<a href="gbmain?page=${i}">[${i}]</a>
	</c:forEach>

	<hr>
	
</body>
</html>