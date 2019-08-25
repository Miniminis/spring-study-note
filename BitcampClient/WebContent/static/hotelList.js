
$(document).ready(function(){
	//alert('뿅');
	hotelList(1);
	
	
})

function hotelList(pageNo) {
	
	//alert('pageNo들어왔니? '+pageNo);
	
	$('#moreListBtn').remove();
	
	/*호텔리스트*/
	$.ajax({
		url: 'http://localhost:8080/ad/api/hotel',
		type: 'get',
		data: {pageNo:pageNo},
		dataType: 'json',
		success : function(data) {
			
			//호텔리스트 출력
			var itemlist = data.response.body.items.item;
			
			//alert('itemlist.length 아이템 길이는? '+itemlist.length);
			
			var output ='';
			
			for(var i=0; i<itemlist.length; i++) {
					
				output += '<hr><ul>';
				output += '<li>'+itemlist[i].addr1+'</li>';
				output += '<li><img src="'+itemlist[i].firstimage+'"></li>';
				output += '<li>'+itemlist[i].title+'</li>';
				output += '<li>'+itemlist[i].tel+'</li>';
				output += '</ul><hr>';
				
			}
			
			$('#hotelList').append(output);
			
			//페이징처리 
			var numOfRows = data.response.body.numOfRows;
			var totalCount = data.response.body.totalCount;
			var pageNo = data.response.body.pageNo;
			
			//alert('페이지처리 되니? '+numOfRows +' / ' + totalCount +' / '+ pageNo);
			
			
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


/*방리스트*/
/*방추가*/
/*방삭제*/
/*방수정*/