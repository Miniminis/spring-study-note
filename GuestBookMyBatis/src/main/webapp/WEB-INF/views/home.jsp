<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

</body>
</html>

<!-- guestbook project - mvc
------------------------
필요한 라이브러리 추가 
- mysql or : maven 
- oracle : lib 추가 
커넥션 풀 : pom.xml 에 추가 
-------------------
1. DB 설정 : DBCP Init 서블릿 
Connection : connectionProvider.getConnection() 

2. 만들어야하는 폼 
- 리스트 : /list 
- 쓰기 폼 : /writeForm 
- 쓰기 : /write
- 삭제 폼 - 비밀번호 임력 : /deleteForm 
- 삭제 : /delete 
--> 