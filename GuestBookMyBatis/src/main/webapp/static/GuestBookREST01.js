/* 프로그램 시작과 동시에 pageview() 실행  */
$(document).ready(function(){
	pageview(1); //최초 리스트 출력 : 내림차순으로 3개만 출력 
	
	/* 게시글 삭제 */
	$('#delModal').on('show.bs.modal', function(e){
		var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
		var mid = button.data('id');   
		
		var modal = $(this); 

		modal.find('.modal-title').text(mid+'번 메시지 삭제');
		modal.find('#msgNum').val(mid);
		modal.find('#delPwChk').focus(); //not working ㅠㅠㅠ 
		

	});

	$('#delModal').on('hide.bs.modal', function (e) {
		
		$(this).find('.modal-body form')[0].reset(); //삭제 폼 초기화 : 이후 다른 삭제시 폼이 비워져있도록!
	});
});		
	
/* 리스트 출력, 페이지 번호 표시를 위한 ajax 처리 */
function pageview(num) {
	//alert("1  "+num);	//최초 리스트 출력을 위한 num 매개변수 1 확인
	$('#moreListBtn').remove();
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
					
					output += '<div class="col-sm-4 mr-10">';
					output += '<div class="card">';
					output += '<div class="card-body">';
					output += '<h5 class="card-title">'+message_id+'번 메시지</h5>';
					output += '<h6 class="card-subtitle mb-2 text-muted">작성자 '+gname+'/ 비번'+gpassword+'</h6>';
					output += '<p class="card-text">'+gmessage+'</p>';
					output += '<button data-toggle="modal" data-target="#delModal" data-id="'+message_id+'" data-keyboard="true" class="btn btn-light">삭제하기</button>';
					output += '</div>';
					output += '</div>';
					output += '</div>';
					
				};
				$('#list').append(output);
				
				//더보기 버튼을 통한 페이징 처리 
				var paging='';
				
				num = num+1; //다음 페이지 출력을 위해 버튼을 누르면 다음 페이징 값이 전달되어 매소드 실행이 되어야 함
				if(num<=data.pageTotalCnt) {
					paging += '<button id="moreListBtn" onclick="pageview('+num+')" class="btn btn-light">더 많은 방명록 보기</button>';
					$('#paging').append(paging);
				} else {
					$('#paging').remove();
				}

				//alert("2  "+num);	
				//num = num+1;
				//alert("3  "+num);	
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
			$('#list').empty(); //새로 등록된 메시지 결과 출력을 위해 기존 리스트 비워주기
			pageview(1); //바뀐 데이터 결과 적용된 리스트 재출력 (redirect 의 기능)
            //window.location = "http://localhost:8080/gbmb/api/guest"; //페이지 번호 파라미터를 받을 수 없음 
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
			$('#list').empty(); //새로 등록된 메시지 결과 출력을 위해 기존 리스트 비워주기
			pageview(1); //바뀐 데이터 결과 적용된 리스트 재출력 (redirect 의 기능)            
			$('#delModal').modal('hide');
		}
	}) 
}

