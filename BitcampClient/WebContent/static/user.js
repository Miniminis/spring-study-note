
$(document).ready(function(){
	//alert('뿅');
	hotelList(1); //최초 리스트 출력 : default pageNo=1
	hotelDetailPage(); //호텔상세보기
	hotelRoomList();
	
    $(function() {
        //모든 datepicker에 대한 공통 옵션 설정
        $.datepicker.setDefaults({
            dateFormat: 'yy-mm-dd' //Input Display Format 변경
            ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
            ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능                
            ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
            ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
            ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
            ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
            ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
            ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
            ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
            ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
            ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
            ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
            ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
        });
        //input을 datepicker로 선언
        $("#datepicker").datepicker();                    
        $("#datepicker2").datepicker();
        
        //From의 초기값을 오늘 날짜로 설정
        $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
        //To의 초기값을 내일로 설정
        $('#datepicker2').datepicker('setDate', '+1D'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
    });
    
    
    
    
    $('#datepicker2').change(function() {
    	
   		r_price();
   		available();
    });
    
    
    function r_price()
    {
        var sdd = document.getElementById("datepicker").value;
        var edd = document.getElementById("datepicker2").value;
        var ar1 = sdd.split('-');
        var ar2 = edd.split('-');
        var dat1 = new Date(ar1[0], ar1[1], ar1[2]);
        var dat2 = new Date(ar2[0], ar2[1], ar2[2]);
        
  		// 날짜 차이 알아 내기
        var diff = dat2 - dat1;
        var currDay = 24 * 60 * 60 * 1000;// 시 * 분 * 초 * 밀리세컨
        var currMonth = currDay * 30;// 월 만듬
        var currYear = currMonth * 12; // 년 만듬
        var ddif = parseInt(diff/currDay);
        var mdif = parseInt(diff/currMonth);
        var ydif = parseInt(diff/currYear);
        
        var totalP = parseInt(diff/currDay) * $('#r_price').val();
        $('#r_price').val(totalP);
        
/*         
        document.write("* 날짜 두개 : " + sdd + ", " + edd + "<br/>");
        document.write("* 일수 차이 : " + parseInt(diff/currDay) + " 일<br/>");
        document.write("* 월수 차이 : " + parseInt(diff/currMonth) + " 월<br/>");
        document.write("* 년수 차이 : " + parseInt(diff/currYear) + " 년<br/><br/>"); */
     
    }
        
    function available()
    {
    	$('#chkMsg').empty();
    	
        $.ajax({
            url : 'http://localhost:8080/booking/rest/booking/aval',
            type : 'get',
            data : {
                h_name : $('#h_name').val(),
                r_name : $('#r_name').val(),
                s_date : $('#datepicker').val(),
                e_date : $('#datepicker2').val()
            },
            success : function(data){
                alert(data);
                if(data=='success') {
                	$('#chkMsg').append('지정 하신 날짜에는 모든 방이 소진되었습니다. 다른 날짜를 선택해주세요.').css('color', 'red');
                }
                else {
                	$('#chkMsg').append('예약 가능한 날짜입니다.').css('color', 'blue');
                }
            },
    		error : function(e) {
    			alert(e);
    		}
        });
    }
    
    
    $('#kakaopay-btn').on(function() {
    	
    	kakaopay(e);
    	
    });

	
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
						output += '<button onclick="resvAction('+contentid+', '+roomnum+')" class="btn btn-skin">예약</button></td></tr>';
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
function resvAction(contentid, roomnum) {
	//$('#roomListModal').hide();
	//alert(contentid);
	//alert(roomnum);
	location.href='#sectionReserv'; //예약 진행 스크롤로 이동 
	$('#roomListModal').modal('hide'); //이동과 함께 모달 숨기기
	
	$.ajax({
		//url : 'http://localhost:8080/ad/api/hotel/room/'+contentid+'/'+roomnum,
		url : 'http://13.125.249.209:8080/admin/api/hotel/room/'+contentid+'/'+roomnum,
		type: 'get',
		success : function(data) {
			//Room 에서 받아올 수 있는 정보들 표시 
			/*alert('성공!' + data.roomnum);
			alert('성공!' + data.hotelnum);
			alert('성공!' + data.hotelname);
			alert('성공!' + data.roomname);
			alert('성공!' + data.roomimg);
			alert('성공!' + data.maxppl);
			alert('성공!' + data.intro);
			alert('성공!' + data.price);
			alert('성공!' + data.convenience);
			alert('성공!' + data.availability);*/
		},
		error : function(e) {
			alert(e);
		}

	})
	
}

