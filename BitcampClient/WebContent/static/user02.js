
$(document).ready(function(){
	//alert('뿅');
	hotelList(1); //최초 리스트 출력 : default pageNo=1
	hotelDetailPage(); //호텔상세보기
	hotelRoomList();
	
});

//호텔리스트
function hotelList(pageNo) {
	
	//alert('여기 오니 01  '+pageNo);
	
	$('#moreListBtn').remove();
	
	$.ajax({ 
		url: 'http://localhost:8080/ad/api/hotel',
		//url: 'http://13.125.249.209:8080/testBitcampServer/ad/api/hotel',
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
			url: 'http://localhost:8080/ad/api/hotel/'+contentid,
			//url: 'http://13.125.249.209:8080/testBitcampServer/ad/api/hotel'+contentid,
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
			 url : 'http://localhost:8080/ad/api/hotel/room/'+contentid,
			 //url : 'http://13.125.249.209:8080/testBitcampServer/ad/api/hotel'+contentid,
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
						output += '<div class="row no-gutters">';
						output += '<div class="col-md-4">';
						output += '<img src="..." class="card-img" alt="..." value="">';
						//output += '<img src="<c:url value =\"/uploadedfile/roomPhoto\"/>" class="card-img" alt="..." value="">';
						output += '</div>';
						output += '<div class="col-md-8">';
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
						output += '<button onclick="resvAction('+roomnum+')" class="btn btn-skin">예약</button></td></tr>';
						output += '</tbody>';
						output += '</table></div></div></div></div>';
						
					 }
					 
					 modal.find('.modal-body').html(output);
				 } else {
					 modal.find('.modal-body').text('등록된 방이 없습니다!');
				 }
			 }
		 })
	}) 
} 


/*방 페이지에서 예약 버튼 작동시*/
function resvAction(roomnum) {
	//$('#roomListModal').hide();
	//alert(roomnum);
	//alert(roomname);
	location.href='#sectionReserv'; //예약 진행 스크롤로 이동 
	$('#roomListModal').modal('hide'); //이동과 함께 모달 숨기기
}

