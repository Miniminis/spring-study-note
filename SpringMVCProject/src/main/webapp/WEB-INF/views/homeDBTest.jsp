<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	THIS IS A PAGE CONNECTED WITH MYSQL DB  
</h1>

<P>  Memberinfo 테이블에서 가져온 userid :  ${userid}. </P>
<a href='<c:url value="/header/getheader"/>'>Header Referer</a>
</body>
</html>
