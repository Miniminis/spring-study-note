<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색</h1>
	<p>
		인기 검색어 :
		<!--DB에서 받아온 데이터의 반복 - option 리스트 생성  --> 
		<c:forEach var="keyword" items="${popularList }">
			#${keyword }
		</c:forEach>
	</p>
	<select>
		<option>선택</option>
		<!-- DB에서 받아온 데이터의 반복 - option 리스트 생성 -->
		<c:forEach var="option" items="${optionList}">
			<option>${option }</option>
		</c:forEach>
	</select>
</body>
</html>