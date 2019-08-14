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
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="<c:url value="static/GuestBookSP.js" />" text="text/javascript"></script>
<style>

	html, body {
		height: 100%;
		margin: 0;
	}
	body {
		margin: 50px 200px 0 200px;
		text-align: center;
	}
	
	#writeArea {
		width: 100%;
		padding: 0px 200px;
	}
	
	.paging {
		cursor: pointer; 
	}
	
	.mr-10 {
		margin: 10px 0;
	}

</style>
</head>
<body>
	<div id="writeArea">
		<h2>LEAVE YOUR MESSAGE!</h2>
		<hr>
		
		<form id="writeMsgForm" name="writeMsgForm" method="post">
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
			  </div>
			  <input type="text" name="gname" class="form-control" aria-label="Sizing example input" 
			  		aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
			  </div>
			  <input type="text" name="gpassword" class="form-control" aria-label="Sizing example input" 
			  		aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group">
			  <div class="input-group-prepend">
			    <span class="input-group-text">메시지</span>
			  </div>
			  <textarea name="gmessage" class="form-control" aria-label="With textarea"></textarea>
			</div>			
		</form>
		<button onclick="submitMsgForm()" class="btn btn-light mr-10">메시지등록</button>
		<hr>
	</div>
	
	<div id="list" class="row"><!-- ajax 통해서 DB에 저장된 메시지 리스트 출력 --></div>
	
	<p id="paging"><!-- ajax 통해서 paging 처리 --></p>	
	
	<!-- Modal -->
	<div id="delModal" class="modal fade" role="dialog" id="deleteFormModal">
	  <div class="modal-dialog">
	  
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	      
	      	<h4 class="modal-title">DELETE MESSAGE</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      
	      <div class="modal-body">
	        <p>삭제폼 구현해야함!!!!!!!!!!!!</p>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-light" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	    
	  </div>
	</div>
</body>
</html>