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
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="<c:url value='static/default.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	.table th {
		width : 150px;
	}
	
	.righty {
		text-align: right;
	}
</style>
</head>
<body>
	<h1>ADMIN PAGE</h1>
	
	<!-- 호텔리스트 -->
	<div>
		<h2> 호텔리스트 api </h2>
		<div class="container">
			<div id="hotelList" class="row">
				<!-- list 출력장소 -->
			</div>
			
			<div id="hotelListPage"><!-- 리스트 페이징처리 --></div>
		</div>
	</div>
	
	<!-- 호텔 상세 페이지 MODAL -->
	<div id="hotelDetail" class="modal" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<img src="">
	        <table class="table">
			  <tbody>
			    <tr>
			      <th scope="row">주소</th>
			      <td id="hAddress">Mark</td>
			    </tr>
			    <tr>
			      <th scope="row">우편번호</th>
			      <td id="hZipcode">Larry</td>
			    </tr>
			    <tr>
			      <th scope="row">전화번호</th>
			      <td id="hTel">Jacob</td>
			    </tr>
			    <tr>
			      <th scope="row">담당자 이름</th>
			      <td id="hAdmin"></td>
			    </tr>
			    <tr>
			      <th scope="row">소개</th>
			      <td id="hIntro">mini</td>
			    </tr>
			  </tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 호텔 방 등록 MODAL -->
	<div id="roomAddModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">새로운 방 등록</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form id="roomAddForm">
	      	  <input type="hidden" id="hotelnum" name="hotelnum" value="" >
	      	  <input type="hidden" id="hotelname" name="hotelname" value="" >
	          <div class="form-group">
	            <label for="roomname" class="col-form-label">방 이름</label>
	            <input type="text" class="form-control" id="roomname" name="roomname">
	          </div>
	          <div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="inputGroupFileAddon01">방 이미지</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" id="roomimg" name="roomimg" aria-describedby="inputGroupFileAddon01">
				    <label class="custom-file-label" for="roomimg">탐색</label>
				  </div>
			  </div>
			  <div class="form-group">
	            <label for="maxppl" class="col-form-label">최대 수용 인원</label>
	            <select class="custom-select" id="maxppl" name="maxppl">
				    <option selected>선택</option>
				    <option value="2">2명</option>
				    <option value="4">4명</option>
				    <option value="8">8명</option>
				    <option value="20">20명</option>
				  </select>
	          </div>
	          <div class="form-group">
	            <label for="price" class="col-form-label">방 가격</label>
	            <input type="number" class="form-control" id="price" name="price">
	          </div>
	          <div class="form-group">
	            <label for="convenience" class="col-form-label">편의시설</label>
	            <select class="custom-select" id="convenience" name="convenience">
				    <option selected>선택</option>
				    <option value="Y">있음</option>
				    <option value="N">없음</option>
				  </select>
	          </div>
	          <div class="form-group">
	            <label for="intro" class="col-form-label">방 소개 </label>
	            <textarea class="form-control" id="intro" name="intro"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button type="button"  onclick="submitAddForm()" class="btn btn-primary">등록</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 각 호텔 별 룸 리스트 MODAL -->
	<div id="roomListModal" class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-scrollable" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <!-- 방 리스트 출력  -->
	      </div>
	      <div class="modal-footer">
	        <button id="roomListCloseBtn" type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 호텔 방 수정 MODAL -->
	<div id="editFormModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form id="editForm">
	          <input type="text" id="roomNum" name="roomnum" value="" >
	      	  <input type="text" id="oldRoomPhoto" name="oldRoomPhoto" value="" >
	      	  
	          <div class="form-group">
	            <label for="rName" class="col-form-label">방 이름</label>
	            <input type="text" class="form-control" id="rName" name="roomname">
	          </div>
	          <div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="rImg">방 이미지</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" id="rImg" name="roomimg" aria-describedby="inputGroupFileAddon01">
				    <label class="custom-file-label" for="rImg">탐색</label>
				  </div>
			  </div>
			  <div class="form-group">
	            <label for="rppl" class="col-form-label">최대 수용 인원</label>
	            <select class="custom-select" id="rppl" name="maxppl">
				    <option selected>선택</option>
				    <option value="2">2명</option>
				    <option value="4">4명</option>
				    <option value="8">8명</option>
				    <option value="20">20명</option>
				  </select>
	          </div>
	          <div class="form-group">
	            <label for="rPrice" class="col-form-label">방 가격</label>
	            <input type="number" class="form-control" id="rPrice" name="price">
	          </div>
	          <div class="form-group">
	            <label for="rConvenience" class="col-form-label">편의시설</label>
	            <select class="custom-select" id="rConvenience" name="convenience">
				    <option selected>선택</option>
				    <option value="Y">있음</option>
				    <option value="N">없음</option>
				  </select>
	          </div>
	          <div class="form-group">
	            <label for="rIntro" class="col-form-label">방 소개 </label>
	            <textarea class="form-control" id="rIntro" name="intro"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button onclick="submitEditForm()" type="button" class="btn btn-primary">변경내용저장</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 룸 예약 리스트  -->
	
</body>
</html>