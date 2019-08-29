
$(document).ready(function(){
	//alert('뿅');
	hotelList(1); //최초 리스트 출력 : default pageNo=1
	hotelDetailPage(); //호텔상세보기
	hotelRoomList(); //호텔별 방 리스트 
	bookingList(); //예약 현황 리스트
	//리뷰 리스트
	memberList();//회원 리스트

	//getUserIdx();
	
	//호텔 방 등록 폼 모달 열기 
	$('#roomAddModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); 
	  var contentid = button.data('id');
	  var title = button.data('title');
	  
	  var modal = $(this);
	  
	  modal.find('.modal-title').text(title+ '에 새로운 방 등록하기');
	  modal.find('#hotelnum').val(contentid);
	  modal.find('#hotelname').val(title);
	  
	})
	
	//호텔 방 등록 폼 모달 닫기 
	$('#roomAddModal').on('hide.bs.modal', function (e) {
		$(this).find('.modal-body form')[0].reset(); 
			//폼 초기화 : 이후 다시 열어도 폼이 비워져 있도록!
	});
	
	
	//수정 폼 열기
	$('#editFormModal').on('show.bs.modal', function (event) {
		
		//alert('수정 모달 왜 안떠');
		
		  var button = $(event.relatedTarget); 
		  
		  var roomnum = button.data('roomnum');
		  var roomimage = button.data('image');
		  var roomname = button.data('roomname');
		  var maxppl = button.data('maxppl');
		  var intro = button.data('intro');
		  var price = button.data('price');
		  var convenience = button.data('convenience');
		  
		  var modal = $(this);
		  
		  modal.find('.modal-title').text(roomname+ ' 정보 수정');
		  
		  modal.find('#roomNum').val(roomnum);
		  modal.find('#oldRoomPhoto').val(roomimage);
		  modal.find('#rName').val(roomname);
		  modal.find('#rppl').val(maxppl);
		  modal.find('#rPrice').val(price);
		  modal.find('#rConvenience').val(convenience);
		  modal.find('#rIntro').val(intro);
		  
	})
	
	//수정 폼 닫기
	//호텔 방 등록 폼 모달 닫기 
	$('#editFormModal').on('hide.bs.modal', function (e) {
		$(this).find('.modal-body form')[0].reset(); 
			//폼 초기화 : 이후 다시 열어도 폼이 비워져 있도록!
	})
	
});

//호텔리스트
function hotelList(pageNo) {
	
	//alert('여기 오니 01  '+pageNo);
	
	$('#moreListBtn').remove();
	
	$.ajax({ 
		//url: 'http://localhost:8080/ad/api/hotel',
		url: 'http://13.125.249.209:8080/admin/api/hotel',
		type: 'get',
		data: {pageNo:pageNo},
		dataType: 'json',
		success : function(data) {
			
			//alert('여기 오니 07 ');
			
			//호텔리스트 출력
			var itemlist = data.response.body.items.item;
			
			//alert('itemlist.length 아이템 길이는? '+itemlist.length);
			
			var output ='';
			
			for(var i=0; i<itemlist.length; i++) {
				
				var firstimage = itemlist[i].firstimage;
				if(firstimage == 'undefined') {
					firstimage = '/image/noImg.png';
				}
				
				var title = itemlist[i].title;
				var addr1 = itemlist[i].addr1;
				var tel = itemlist[i].tel;
				var contentid = itemlist[i].contentid;
					
				output += '<div id="hotelItem" class="col-md-4">';
				output += '<img src="'+firstimage+'" class="card-img-top" width="100%" height="300px" >';
				output += '<div class="card-body">';
				output += '<h5 class="card-title mr-02">'+title+'</h5>';
				output += '<p class="card-text">'+addr1+'</p>';
				output += '<p class="card-text">'+tel+'</p>';
				output += '</div>';		
				output += '<div class="card-footer">';
				output += '<small class="text-muted">';
				output += '<button data-toggle="modal" data-target="#hotelDetail" data-id="'+contentid+'" data-keyboard="true" class="btn btn-skin mr-01">호텔소개</button>';
				//output += '<button data-toggle="modal" data-target="#hotelDetail" data-id="'+contentid+'" data-keyboard="true" class="btn btn-skin mr-01">숙박상세정보</button>';
				output += '<button data-toggle="modal" data-target="#roomListModal" data-id="'+contentid+'" data-title="'+title+'" data-keyboard="true" class="btn btn-skin mr-01">방 목록 보기</button>';
				output += '<button data-toggle="modal" data-target="#roomAddModal" data-id="'+contentid+'" data-title="'+title+'" data-keyboard="true" class="btn btn-skin mr-01">새로운 방 등록</button>';
				output += '</small>';
				output += '</div>';
				output += '</div>';
				
			}
			
			$('#hotelList').append(output);
			
			//페이징처리 
			var numOfRows = data.response.body.numOfRows;
			var totalCount = data.response.body.totalCount;
			var pageNo = data.response.body.pageNo;
			
			//alert('페이지처리 되니? '+numOfRows +' / ' + totalCount +' / '+ pageNo);
			
			var totalPageCount;
			
			if(totalCount%numOfRows>0) {
				//alert('뿅1');
				totalPageCount = parseInt(totalCount/numOfRows)+1; 
					//javascript 에서 몫 정수형으로 구할때 parseInt() 함수를 이용!
			} else {
				//alert('뿅2');
				totalPageCount = totalCount/numOfRows;
			}
			
			//alert('totalPageCount 계산되니? '+totalPageCount);
			
			var paging = '';
			/*for(var j=1; j<=totalPageCount; j++) {
				paging += '<a onclick=hotelList('+j+')>['+j+']</a>'
			}
			
			$('#hotelListPage').html(paging);*/
			
			pageNo = pageNo +1;
			if(pageNo<=totalPageCount) {
				paging += '<button id="moreListBtn" onclick="hotelList('+pageNo+')" class="btn btn-skin btn-lg btn-block">더 많은 호텔 보기</button>';
				$('#hotelListPage').append(paging);
			} else {
				$('#paging').remove();
			}
			
		}
	})
}

//호텔 상세보기 01
function hotelDetailPage() {
	
	$('#hotelDetail').on('show.bs.modal', function (e) {
		
		var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
		var contentid = button.data('id');
		
		//alert('상세보기 01 '+contentid);
		
		var modal = $(this);
		
		$.ajax({
			//url: 'http://localhost:8080/ad/api/hotel/'+contentid,
			url: 'http://13.125.249.209:8080/admin/api/hotel/'+contentid,
			type: 'get',
			dataType: 'json',
			success: function(data) {
				
				//alert('상세보기 06  ');
				var item = data.response.body.items.item;
				
				var addr1 = item.addr1;
				var addr2 = item.addr2;
				var firstimage = item.firstimage;
				var overview = item.overview;
				var tel = item.tel;
				var telname = item.telname;
				var title = item.title;
				var zipcode = item.zipcode;
				
				modal.find('.modal-title').text(title);
				modal.find('#hAddress').text(addr1);
				modal.find('#hZipcode').text(zipcode);
				modal.find('#hTel').text(tel);
				modal.find('#hAdmin').text(telname);
				modal.find('#hIntro').text(overview);
				
			}
		})
		
	})
}

/*호텔 별 방 리스트*/
function hotelRoomList() {
	
	$('#roomListModal').on('show.bs.modal', function (event) {
		 var button = $(event.relatedTarget); 
		 var contentid = button.data('id');
		 var title = button.data('title');
		 
		 var modal = $(this);
		 
		 modal.find('.modal-title').text(title+ '의 방 목록');
		 
		 //alert('방 리스트 01 '+contentid);
		 
		 $.ajax({
			 //url : 'http://localhost:8080/ad/api/hotel/room/'+contentid,
			 url : 'http://13.125.249.209:8080/admin/api/hotel/room/'+contentid,
			 type: 'get',
			 //dataType: 'json',
			 success : function(data) {
				 //alert('리스트 성공~!')
				 if(data != 0) {
					 
					 var output ='';
					 
					 for(var i=0; i<data.length; i++) {
						 //alert(data[i].roomname);
						 
						 var roomnum = data[i].roomnum;
						 var roomname = data[i].roomname;
						 var roomimg = data[i].roomimg;
						 var maxppl = data[i].maxppl;
						 var intro = data[i].intro;
						 var price = data[i].price;
						 var convenience = data[i].convenience;
				
						output += '<div class="card mb-3">';
						output += '<div>';
						output += '<div class="row no-gutters">';
						output += '<div class="col-md-8">';
						output += '<img src="http://13.125.249.209:8080/admin/uploadedfile/roomPhoto/'+roomimg+'" class="card-img roomImg" >';
						output += '</div>';
						output += '<div class="col-md-4">';
						output += '<div class="card-body">';
						output += '<h5 class="card-title">'+roomname+'</h5>';
						output += '<table class="table">';
						output += '<thead>';
						output += '<tr><th scope="col">가격</th><th scope="col">'+price+'</th></tr>';
						output += '</thead>';
						output += '<tbody>';
						output += '<tr><th scope="row">최대 수용 인원</th><td>'+maxppl+'</td></tr>';
						output += '<tr><th scope="row">편의시설</th><td>'+convenience+'</td></tr>';
						output += '<tr><th scope="row">소개</th><td>'+intro+'</td></tr>';
						output += '<tr><td colspan="2" class="righty">';
						output += '<button id="editBtn" type="button" data-toggle="modal" data-target="#editFormModal" data-roomnum="'+roomnum+'" data-image="'+roomimg+'" data-roomname="'+roomname+'" data-maxppl="'+maxppl +'" data-intro="'+intro+'" data-price="'+price+'" data-convenience="'+convenience+'"  class="btn btn-skin mr-01">수정</button>';
						output += '<button id="delBnt" onclick="delRoom('+roomnum+')" type="button" class="btn btn-skin">삭제</button>';
						output += '</td></tr>';
						output += '</tbody>';
						output += '</table></div></div></div></div></div>';
						
					 }
					 
					 modal.find('.modal-body').html(output);
				 } else {
					 modal.find('.modal-body').text('등록된 방이 없습니다!');
				 }
			 }
		 })
	}) 
} 

/*방 등록 처리*/
function submitAddForm() {
	
	var roomFormData = $('#roomAddForm')[0];
	var data = new FormData(roomFormData);
	
	//var file = $('#roomimg')[0];
	//console.log('파일등록'+file);
	//alert('방 등록 01 '+roomFormData );
	//alert('방 등록 01-1 '+data);
	
	$.ajax({
		url : 'http://localhost:8080/ad/api/hotel/room/',
		//url : 'http://13.125.249.209:8080/admin/api/hotel/room',
		type: 'post',
		data : data,
		enctype: 'multipart/form-data',
		processData: false,
		//contentType:'application/json;charset=UTF-8',
		contentType: false,
		//dataType: 'json', 
		success: function (data) {
            alert("정상적으로 등록되었습니다!");
            $('#roomAddModal').modal('hide');
        },
        error: function (e) {
            console.log("ERROR : ", e);
            alert("방 등록에 실패하였습니다! ");
        }
	})
} 

/*방삭제*/
function delRoom(roomnum) {
	
	if(confirm('삭제된 방의 정보는 다시 복구할 수 없습니다. 정말 삭제하시겠습니까? ')) {
		$.ajax({
			//url : 'http://localhost:8080/ad/api/hotel/room/'+roomnum,
			url : 'http://13.125.249.209:8080/admin/api/hotel/room/'+roomnum,
			type: 'delete',
			success : function(data) {
				if(data>0) {
					alert(data+'개의 방이 정상적으로 삭제되었습니다.');
				} else {
					alert('방 삭제에 실패하였습니다 ㅠㅠㅠ 으엉어엉어어어어엉');
				}
				$('#roomListModal').modal('hide');
				hotelList(1);
			},
			error : function(e) {
				alert(e);
			}
		})
	}
}


/*방 수정 - 방사진파일*/
function editRoomPhoto() {
	//alert('요기서 사진 수정!');
	var roomnum = $('#roomNum').val();
	var rName = $('#rName').val();
	var newPhoto = $('#rImg')[0].files[0]; 
	var oldPhoto = $('#oldRoomPhoto').val();
	
	var formData = new FormData();
	formData.append("roomimg", newPhoto);
	formData.append("oldRoomPhoto", oldPhoto);
	formData.append("roomname", rName);
	formData.append("roomnum", roomnum);
	
	console.log('사진수정 01  '+roomnum);
	console.log('사진수정 02  '+newPhoto);
	console.log('사진수정 03  '+oldPhoto);
	console.log('사진수정 04  '+formData);
	console.log('사진수정 05  '+rName);
	
	$.ajax({
		//url : 'http://localhost:8080/ad/api/hotel/room/photo',
		url : 'http://13.125.249.209:8080/admin/api/hotel/room/photo',
		type: 'post',
		data : formData,
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		success : function(data) {
			console.log(data+' 개의 사진 수정 성공');
		},
		error : function(e) {
			console.log(e+'사진 수정실패');
		}
	})
	
}


/*방수정*/
function submitEditForm() {
	
	//수정을 위해 방번호 url에 추가 
	var roomnum = $('#roomNum').val();
	
	//alert('방 정보 수정 0123 : '+roomnum);
	
	$.ajax({
		//url: 'http://localhost:8080/ad/api/hotel/room/'+roomnum,
		url: 'http://13.125.249.209:8080/admin/api/hotel/room/'+roomnum,
		type: 'put',
		data : JSON.stringify({
			roomnum : roomnum,
			roomname : $('#rName').val(),
			maxppl : $('#rppl').val(),
			price : $('#rPrice').val(),
			convenience : $('#rConvenience').val(),
			intro : $('#rIntro').val()
		}),
		contentType:'application/json;charset=UTF-8',
		success : function(data) {
			alert(data+' 개의 방 정보가 수정되었습니다!');
			$('#editFormModal').modal('hide');
			$('#roomListModal').modal('hide');
			hotelList(1);
		},
		error : function(e) {
			console.log("ERROR 방정보 수정 ERROR : ", e);
            alert("방 수정에 실패하였습니다ㅜㅠㅠㅠㅠ으엉어어엉! ");
            $('#editFormModal').modal('hide');
            $('#roomListModal').modal('hide');
			hotelList(1);
		}
	})
}


/*예약현황 리스트*/
function bookingList(){
	$.ajax({
		url : 'http://15.164.100.85:8080/booking/rest/booking',
		type: 'get',
		success : function(data) {
			
			var text = '';
			
			for(var i=0; i<data.length; i++) {
				//console.log('예약리스트 :  '+data[i].idx);
				
				text += '<tr>';
				text += '<th scope="row">'+data[i].idx+'</th>';
				text += '<td>'+data[i].uId+'</td>';
				text += '<td>'+data[i].h_name+'</td>';
				text += '<td>'+data[i].r_name+'</td>';
				text += '<td>'+data[i].r_price+'</td>';
				text += '<td>'+data[i].s_date+'</td>';
				text += '<td>'+data[i].e_date+'</td>';
				text += '<td>'+data[i].b_date+'</td>';
				
			}
			
			$('#bookingListBody').html(text);
		}
	})
}

/*리뷰 리스트*/
//function reviewList(){}

/*회원리스트*/
function memberList(){
	$.ajax({
		/* url:'http://localhost:8080/mc/rest/members', */
		// restful로 우회접근
//			url : 'http://localhost:8080/rc/list',
		url : 'http://13.209.40.5:8080/rc/list',
		type : 'GET',
		success : function(data) {
			/* alert(JSON.stringify(data)); */
			var html = '';
			for (var i = 0; i < data.length; i++) {

				html += '<tr>\n';
				html += '	<td>' + data[i].idx + '</td>\n';
				html += '	<td>' + data[i].id + '</td>\n';
				html += '	<td>' + data[i].name + '</td>\n';
				html += '	<td>' + data[i].phone + '</td>\n';
				html += '	<td>' + data[i].verify + '</td>\n';
				html += '	<td>' + data[i].regdate + '</td>\n';
				html += '	<td>' + data[i].out + '</td>\n';
				html += '	<td><span class="btn_manage " onclick="edit('
						+ data[i].idx + ')">edit</span>';
				html += '	<span class="btn_manage" onclick="del(' + data[i].idx
						+ ')">del</span></td>';
				html += '</tr>\n';
			}

			$('#memberList').html(html);

		}
	});
}


/*회원 삭제*/
function del(idx) {
	if (confirm('delete??????')) {
		$.ajax({
//			url : 'http://localhost:8080/bitcamp/rest-users/' + idx + '/del',
			url : 'http://13.209.40.5:8080/bitcamp/rest-users/' + idx + '/del',
			type : 'PUT',
			success : function(data) {

				if (data == 'success') {
					alert('삭제되었습니다');
				} else {
					alert('실-패');
				}
			},
			error : function() {
				alert('error ㅠㅠㅠㅠ');
			},
			complete : function() {
				list();
			}
		});
	}
}

/*회원 수정 정보 가져오기*/
function edit(idx) {
	if (confirm('정말 수정할거야?????리얼리????')) {
		// data를 받아오는 타이밍이 달라져서 먼저 선언하고 넣어줘야 한다.
		$('#sectionEditMember').css('display', 'block');
		$('#sectionMember').css('display', 'none');
		$.ajax({
//			url : 'http://localhost:8080/bitcamp/rest-users/' + idx,
			url : 'http://13.209.40.5:8080/bitcamp/rest-users/' + idx,
			type : 'GET',
			success : function(data) {
				// alert(data.idx);
				// alert(JSON.stringify(data));

				// data =JSON.stringify(user);
				$('#idx2').val(idx);
				$('#id2').val(data.id);
				$('#name2').val(data.name);
				$('#phone2').val(data.phone);
			},
		});
	}
}

// 회원수정 처리
$('#editform').submit(function() {
	var idx = $('#idx2').val();

	$.ajax({
//		url : 'http://localhost:8080/bitcamp/rest-users/' + idx,
		url : 'http://13.209.40.5:8080/bitcamp/rest-users/' + idx,
		type : 'PUT',
		data : JSON.stringify({
			idx : idx,
			id : $('#id2').val(),
			phone : $('#phone2').val(),
			name : $('#name2').val()
		}),
		contentType : 'application/json; charset=utf-8',
		success : function(data) {
			alert(data);

			if (data == 'success') {
				alert('수정되었습니다');
			} else {
				alert('실-패');
			}
		},
		error : function(data) {
			alert('error ㅠㅠㅠㅠ');
			alert(data);
		},
		complete : function() {
			list();
			$('#sectionEditMember').css('display', 'none');
			$('#sectionMember').css('display', 'block');
			// location.href = "#member";
		}
	});
});


//admin 로그인 세션
/*function getUserIdx(){
   $.ajax({
      url:'http://13.125.249.209:8080/admin/index.jsp',
      type: 'GET',
      success: function(uIdx){
         sessionStorage.setItem("userIdx", uIdx);
         console.log(uIdx);
      },
      error: function(e){
         console.log(e);
      }
   });
}
*/