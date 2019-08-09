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
	.paging {
		cursor: pointer;
	}
	
</style>
</head>
<body>
	
	<hr>
	
	<a href="<c:url value="/guestWriteForm"/>">새로운 글 등록하기</a>
	
	<hr>
	
	<article id="list">
		
	</article>
	
	<p id="paging">
		
	</p>	
	
	<hr>
<script>

	$(document).ready(function(){
		pageview(1);
	});		
		
	function pageview(num) {		
		$.ajax ({
				url: 'gbmain/JSON',
				type: 'get',
				data: {page:num},
				success : function(data){
					//data: 무조건 js 형식의 객체 
					//alert(data);
					//console.log(data);
					//alert(data.messageTotalCnt); //js 타입 객체를 .으로 직접참조 가능! 
					//alert(JSON.stringify(data)); //JSON 문자열 타입으로 형변환 

					var output='';
					
					var list = data.messageList;
					
					for(var i=0; i<list.length; i++) {
						//console.log(list[i]);
						var message_id = list[i].message_id;
						var gname = list[i].gname;
						var gpassword = list[i].gpassword;
						var gmessage = list[i].gmessage;
						
						output += '<div><table><tr>';
						output += '<td>메시지번호 : '+message_id+'</td>';
						output += '<td>손님이름 : '+gname+'</td>';
						output += '<td>메시지 : '+gmessage+'</td>';
						output += '<td>비밀번호: '+gpassword+'</td>';
						output += '</tr></table></div>';
						
					};
					
					var paging='';
						
					for(var j=1; j<data.pageTotalCnt+1; j++) {
						paging +='<span class="paging"><a onclick="pageview('+j+')">['+j+']</a></span>'; 
					};
					
					//alert(output);
					$('#list').html(output);
					$('#paging').html(paging);
				}
		});
	} 	

</script>
</body>
</html>