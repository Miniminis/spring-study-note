
$(document).ready(function(){
	alert('뿅');
	/*호텔리스트*/
	$.ajax({
		url: 'http://localhost:8080/ad/test',
		type: 'get',
		dataType: 'json',
		success : function(data) {
			
			var itemlist = data.response.body.items.item;
			
			alert('itemlist.length'+itemlist.length);
			
			var output ='';
			
			for(var i=0; i<itemlist.length; i++) {
					
				output += '<ul>';
				output += '<li>'+itemlist[i].addr1+'</li>';
				output += '<li><img src="'+itemlist[i].firstimage+'"></li>';
				output += '<li>'+itemlist[i].title+'</li>';
				output += '<li>'+itemlist[i].tel+'</li>';
				output += '</ul><hr>';
				
			}
			
			$('#hotelList').append(output);
			
		}
	})
})


/*방리스트*/
/*방추가*/
/*방삭제*/
/*방수정*/