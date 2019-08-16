/* 프로그램 시작과 동시에 pageview() 실행  */
$(document).ready(function(){
	pageview(1);
	
	/* 게시글 삭제 */
	$('#delModal').on('show.bs.modal', function(e){
		var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
		var mid = button.data('id');   
		
		var modal = $(this); 

		modal.find('.modal-title').text(mid+'번 메시지 삭제');
		modal.find('#msgNum').val(mid);

	});

	$('#delModal').on('hide.bs.modal', function (e) {
		
		$(this).find('.modal-body form')[0].reset(); //삭제 폼 초기화 : 이후 다른 삭제시 폼이 비워져있도록!
	});
});		
	
/* 리스트 출력, 페이지 번호 표시를 위한 ajax 처리 */
function pageview(num) {		
	$.ajax ({
			url: 'http://localhost:8080/gbmb/api/guest',
			type: 'get',
			data: {page:num},
			success : function(data){  //data: 무조건 js 형식의 객체 
				//alert(data);

				//html 처리 
				var output='';
				
				var list = data.messageList;
				
				for(var i=0; i<list.length; i++) {
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
					output += '<button data-toggle="modal" data-target="#delModal" data-id="'+message_id+'" class="btn btn-light">삭제하기</button>';
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

	$.ajax({
		url: 'http://localhost:8080/gbmb/api/guest',
		type: 'post',
		data: JSON.stringify({
			gname : $('#gname').val(),
			gpassword : $('#gpassword').val(),
			gmessage : $('#gmessage').val()
		}),
		dataType: 'json',
		contentType:'application/json;charset=UTF-8',
		success: function(data){
			//성공여부 결과값이 data에 담겨 전달됨 
			if(data>0) {
				alert(data+'개의 메시지가 성공적으로 들어가 부러쓰~!ㅊㅋㅊㅋ');
			} else {
				alert('우쨰쓰까...'+data+'개의 메시지 등록 실패랑께ㅠㅠㅠ');
			}
			pageview(1); //바뀐 데이터 결과 적용된 리스트 재출력 (redirect 의 기능)
		}, 
		error: function(){
            alert("메세지 등록 실패에요 ㅠㅠㅠㅠ왜죠????");
        }
	});
	document.getElementById("writeMsgForm").reset();
}

/*게시글 삭제처리*/
function submitDelMsg() {

	var mid = $('#msgNum').val();
	var pwChk = $('#delPwChk').val();
	//pwchk 은 data로 보내서 @requestparam으로 받기 시도했으나 실패함. 
	//delete 매서드는 파라미터 보내는 것이 불가한 듯 함;; --> 구글링 결과 url 로 모두 처리 
	$.ajax({
		url: 'http://localhost:8080/gbmb/api/guest/'+mid+'/'+pwChk,
		type: 'delete',
		//data: {},
		/*JSON.stringify({
			passwordConfirm: $('#delPwChk').val()
		})*/
		//dataType: 'json',
		//contentType:'application/json;charset=UTF-8',
		success : function(data) {
			//alert(data);
			//alert(data.get('resultCnt'));
			if(data>0) {
				alert('삭제 성공쓰~!');
			} else {
				alert('삭제 안됐는데 ㅠㅠㅠ 힘내여');
			}
			pageview(1);
			$('#delModal').modal('hide');
		}
	}) 
}

