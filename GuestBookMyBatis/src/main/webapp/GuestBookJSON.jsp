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
	html, body {
		height: 100%;
		margin: 0;
	}
	body {
		margin: 50px 200px 0 200px;
		text-align: center;
	}
	
	#writeArea {
		margin: 0px 200px;
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
	
<script>
	/* 프로그램 시작과 동시에 pageview() 실행  */
	$(document).ready(function(){
		pageview(1);
	});		
		
	/* 리스트 출력, 페이지 번호 표시를 위한 ajax 처리 */
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

					//html 처리 
					var output='';
					
					var list = data.messageList;
					
					for(var i=0; i<list.length; i++) {
						//console.log(list[i]);
						var message_id = list[i].message_id;
						var gname = list[i].gname;
						var gpassword = list[i].gpassword;
						var gmessage = list[i].gmessage;
						
						output += '<div class="col-sm-4">';
						output += '<div class="card">';
						output += '<div class="card-body">';
						output += '<h5 class="card-title">'+message_id+'번 메시지</h5>';
						output += '<h6 class="card-subtitle mb-2 text-muted">작성자 '+gname+'/ 비번'+gpassword+'</h6>';
						output += '<p class="card-text">'+gmessage+'</p>';
						output += '<a href="guestDelForm?messageId='+message_id+'" class="btn btn-light">삭제하기</a>';
						output += '</div>';
						output += '</div>';
						output += '</div>';
						
					};
					
					//페이징 처리 
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
	
	/* 게시글 등록 */
	function submitMsgForm() {
		var msgFormData = JSON.stringify($('#writeMsgForm').serialize());
		var msgFormData2 = $('#writeMsgForm').serialize();
		alert(msgFormData);
		//alert($('#writeMsgForm').serialize());
		$.ajax({
			url: 'guestWrite/JSON',
			type: 'post',
			data: msgFormData,
			dataType: 'json',
			contentType:'application/json;charset=UTF-8',
			success: function(data){
				//성공여부 결과값이 data에 담겨 전달됨 
				if(data>0) {
					alert(data+'개의 메시지가 등록되었습니다.');
				} else {
					alert(data+'개의 메시지 등록에 실패하였습니다!');
				}
				//pageview(1); //바뀐 데이터 결과 적용된 리스트 재출력 (redirect 의 기능)
			}, 
			error: function(){
                alert("등록실패얌 ㅠㅠㅠ 불짱 ㅠㅠㅠ");
            }
		
		});
		
	}
	/* 게시글 삭제 */

</script>
</body>
</html>