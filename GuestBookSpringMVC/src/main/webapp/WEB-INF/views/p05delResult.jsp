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
	<h1>삭제 결과는...........두구두구두구두구구두구우!!!!!!!!!!!!!!!!!</h1>
	<%-- ${chk}개의 게시글이 삭제되었습니다.<br>
	${resultMap.get(0).get("resultCnt")}개의 게시글이 삭제되었습니다.<br>
	${resultMap[resultCnt] } 개의 게시글이 삭제되었습니다.<br>
	${resultMap.resultCnt } 개의 게시글이 삭제되었습니다.<br>
	${resultMap.key } 개의 게시글이 삭제되었습니다.<br>
	${resultMap.value} 개의 게시글이 삭제되었습니다.<br>
	
	<c:out value="${chk}"/> --%>
	
	<!-- map 형태로 저장해도 model 에 담아 뷰페이지로 보낸다면 각각 attribute 가 전달된 것으로 된다. 
	따라서 key값만 입력해준다면 value을 EL 안에서 표현할 수 있다.  -->
	
	<c:if test='${chk}'>
		${resultCnt}개의 게시글이 삭제되었습니다.
	</c:if>
	
	<c:if test='${!chk}'>
		${msg}
	</c:if>
	
	
	<br><a href="<c:url value="/gbmain"/>">메인 페이지로 돌아가기</a>
</body>
</html>