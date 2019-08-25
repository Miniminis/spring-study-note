
$(document).ready(function(){
	//alert('뿅');
	hotelList(1);

	$('#hotelDetail').on('show.bs.modal', function (e) {
		
		var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
		var contentid = button.data('id');
		
		alert('상세보기 01 '+contentid);
		
		var modal = $(this);
		
		$.ajax({
			url: 'http://localhost:8080/ad/api/hotel/'+contentid,
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
	
})

//호텔리스트
function hotelList(pageNo) {
	
	alert('여기 오니 01  '+pageNo);
	
	$('#moreListBtn').remove();
	
	/*호텔리스트*/
	$.ajax({
		url: 'http://localhost:8080/ad/api/hotel',
		type: 'get',
		data: {pageNo:pageNo},
		dataType: 'json',
		success : function(data) {
			
			alert('여기 오니 07 ');
			
			//호텔리스트 출력
			var itemlist = data.response.body.items.item;
			
			alert('itemlist.length 아이템 길이는? '+itemlist.length);
			
			var output ='';
			
			for(var i=0; i<itemlist.length; i++) {
					
				output += '<div class="col-md-4">';
				output += '<img src="'+itemlist[i].firstimage+'" class="card-img-top" alt="...">';
				output += '<div class="card-body">';
				output += '<h5 class="card-title">'+itemlist[i].title+'</h5>';
				output += '<p class="card-text">'+itemlist[i].addr1+'</p>';
				output += '<p class="card-text">'+itemlist[i].tel+'</p>';
				output += '</div>';		
				output += '<div class="card-footer">';
				output += '<small class="text-muted">Last updated 3 mins ago';
				output += '<button data-toggle="modal" data-target="#hotelDetail" data-id="'+itemlist[i].contentid+'" data-keyboard="true" class="btn btn-light">호텔소개</button>';
				//output += '<button data-toggle="modal" data-target="#hotelDetail" data-id="'+itemlist[i].contentId+'" data-keyboard="true" class="btn btn-light">숙박상세정보</button>';
				//output += '<button data-toggle="modal" data-target="#hotelDetail" data-id="'+itemlist[i].contentId+'" data-keyboard="true" class="btn btn-light">룸보기</button>';
				output += '</small>';
				output += '</div>';
				output += '</div>';
				
			}
			
			$('#hotelList').append(output);
			
			//페이징처리 
			var numOfRows = data.response.body.numOfRows;
			var totalCount = data.response.body.totalCount;
			var pageNo = data.response.body.pageNo;
			
			alert('페이지처리 되니? '+numOfRows +' / ' + totalCount +' / '+ pageNo);
			
			var totalPageCount;
			
			if(totalCount%numOfRows>0) {
				alert('뿅1');
				totalPageCount = parseInt(totalCount/numOfRows)+1; 
					//javascript 에서 몫 정수형으로 구할때 parseInt() 함수를 이용!
			} else {
				alert('뿅2');
				totalPageCount = totalCount/numOfRows;
			}
			
			alert('totalPageCount 계산되니? '+totalPageCount);
			
			var paging = '';
			/*for(var j=1; j<=totalPageCount; j++) {
				paging += '<a onclick=hotelList('+j+')>['+j+']</a>'
			}
			
			$('#hotelListPage').html(paging);*/
			
			pageNo = pageNo +1;
			if(pageNo<=totalPageCount) {
				paging += '<button id="moreListBtn" onclick="hotelList('+pageNo+')">더 많은 호텔 보기</button>';
				$('#hotelListPage').append(paging);
			} else {
				$('#paging').remove();
			}
			
		}
	})
}

/*호텔-상세보기*/
/*function getHotelDetail(contentId) {
	
	alert('상세보기 01 '+contentId);
	
	$.ajax({
		url: 'http://localhost:8080/ad/api/hotel/'+contentId,
		type: 'get',
		success: function(data) {
			
			alert('상세보기 06  ');
			var item = data.response.body.items.item;
			
			var addr1 = item.addr1;
			var addr2 = item.addr2;
			var firstimage = item.firstimage;
			var overview = item.overview;
			var tel = item.tel;
			var telname = item.telname;
			var title = item.title;
			var zipcode = item.zipcode;
			
			$('#hotelDetail').on('show.bs.modal', function (e) {
				var button = $(e.relatedTarget) // model 이벤트를 만드는 요소 
				var hotelidx = button.data('id');
				
				var modal = $(this); 

				modal.find('.modal-title').text(title);
				
			})
		}
	})
	
}*/


/*방리스트*/
/*방추가*/
/*방삭제*/
/*방수정*/