<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	body {
		margin: 200px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>삭제 결과는...........두구두구두구두구구두구우!!!!!!!!!!!!!!!!!</h1>
	<hr>
	<!-- map 형태로 저장해도 model 에 담아 뷰페이지로 보낸다면 각각 attribute 가 전달된 것으로 된다. 
	따라서 key값만 입력해준다면 value을 EL 안에서 표현할 수 있다.  -->
	
	<div class="card">
		<c:if test='${chk}'>
			<h5 class="card-title">${resultCnt}개의 게시글이 삭제되었습니다.</h5>
		</c:if>
		<c:if test='${!chk}'>
			<h5 class="card-title">${message.gmessage }</h5>
		</c:if>
		<a href="<c:url value="/gbmain"/>" class="btn btn-light mr-10">메인 페이지로 돌아가기</a>
	</div>
</body>
</html>