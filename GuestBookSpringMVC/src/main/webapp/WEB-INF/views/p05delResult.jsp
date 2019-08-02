<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</style>
</head>
<body>
	<!-- <h1>삭제 결과는...........두구두구두구두구구두구우!!!!!!!!!!!!!!!!!</h1> -->
	<h2>성공적으로 삭제되었습니다.</h2>
	
	<%-- <c:if test="${chk}">
		${resultCnt}개의 게시글이 삭제되었습니다.
	</c:if>
	
	<c:if test="${!chk}">
		${msg}
	</c:if> --%>
	
	
	<br><a href="<c:url value="/gbmain"/>">메인 페이지로 돌아가기</a>
</body>
</html>