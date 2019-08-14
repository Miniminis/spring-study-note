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
					output += '<button data-toggle="modal" data-id="'+message_id+'" data-target="#delModal" class="btn btn-light">삭제하기</button>';
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
	//var msgFormData = JSON.stringify($('#writeMsgForm').serialize());
	var msgFormData = $('#writeMsgForm').serialize();
	/*var msgFormData = {
			gname : "minhww",
			gpassword : "1111",
			gmessage : "12345678"
			
	}*/
	//alert(msgFormData);
	$.ajax({
		url: 'guestWrite/JSON',
		type: 'post',
		data: msgFormData,
		//dataType: 'json',
		//contentType:'application/json;charset=UTF-8',
		success: function(data){
			//성공여부 결과값이 data에 담겨 전달됨 
			if(data>0) {
				alert(data+'개의 메시지가 등록되었습니다.');
			} else {
				alert(data+'개의 메시지 등록에 실패하였습니다!');
			}
			pageview(1); //바뀐 데이터 결과 적용된 리스트 재출력 (redirect 의 기능)
		}, 
		error: function(){
            alert("메세지 등록 실패에요 ㅠㅠㅠㅠ왜죠?");
        }
	});
	document.getElementById("writeMsgForm").reset();
}

/* 게시글 삭제 */
$('#delModal').on('show.bs.modal', function(e){
	var mid = $(this).data('id');
	
})