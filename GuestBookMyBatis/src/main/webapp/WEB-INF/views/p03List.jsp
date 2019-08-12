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
	
	<a href="<c:url value="/guestWriteForm"/>" class="btn btn-light">새로운 글 등록하기</a>
	
	<hr>
	<div class="row">
		<c:forEach items="${list.messageList}" var="message">
			<div class="col-sm-4">
				<div class="card">
					<h5 class="card-title">${message.message_id}번 메시지</h5>
					<h6 class="card-subtitle mb-2 text-muted">작성자 ${message.gname }/ 비번 ${message.gmessage }</h6>
					<p class="card-text">${message.gmessage }</p>
					<a href="guestDelForm?messageId=${message.message_id}" class="btn btn-light">삭제하기</a>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<c:forEach begin="1" end="${list.pageTotalCnt}" step="1" var="i">
		<a href="gbmain?page=${i}">[${i}]</a>
	</c:forEach>
	
</body>
</html>