<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>비트캠프 | 관리자 페이지</title>

<!-- css -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="css/nivo-lightbox.css" rel="stylesheet" />
<link href="css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
<link href="css/owl.carousel.css" rel="stylesheet" media="screen" />
<link href="css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="css/flexslider.css" rel="stylesheet" />
<link href="css/animate.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet">
<link href="color/default.css" rel="stylesheet">
<!-- =======================================================
  Theme Name: Shuffle
  Theme URL: https://bootstrapmade.com/bootstrap-3-one-page-template-free-shuffle/
  Author: BootstrapMade
  Author URL: https://bootstrapmade.com
======================================================= -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="<c:url value='static/default.js'/>" type="text/javascript"></script>
<link href="static/default.css" rel="stylesheet" >
<!-- bootstrap 3.1.1 버전과 4.3.1 버전 충돌 : 3.1.1 버전 유지하고 바뀐 부분만 스타일 적용하기로 결정함  -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

<!-- Navigation -->
  <div id="navigation">
    <nav class="navbar navbar-custom" role="navigation">
      <div class="container">
        <div class="row">
          <!-- 로고 -->
          <div class="col-md-2">
            <div class="site-logo">
              <a href="#" class="brand">BITCAMP</a>
            </div>
          </div>
          <!-- 네브바 -->
          <div class="col-md-10">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu"><i class="fa fa-bars"></i></button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="menu">
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#sectionHotel">호텔 리스트</a></li>
                <li><a href="#sectionReserv">예약 현황</a></li>
                <li><a href="#sectionReview">호텔 리뷰</a></li>
                <li><a href="#sectionMember">회원 관리</a></li>
              </ul>
            </div>
            <!-- /.Navbar-collapse -->
          </div>
        </div>
      </div>
      <!-- /.container -->
    </nav>
  </div>
  <!-- /Navigation -->

  <!-- Section: 호텔리스트 -->
  <section id="sectionHotel" class="home-section color-dark bg-white">
    <div class="container marginbot-50">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
            <div class="section-heading text-center">
              <h2 class="h-bold">호텔 리스트</h2>
              <div class="divider-header"></div>
              <p>대한민국 거의 모든 숙박 리스트 입니다</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="container">
      <div class="row">
      	<div id="hotelList" class="row">
			<!-- list 출력장소 -->
		</div>			
		<div id="hotelListPage"><!-- 리스트 페이징처리 --></div>
      </div>
    </div>

  </section>
  <!-- /Section: 호텔리스트 -->

  <!-- 호텔 상세 페이지 MODAL -->
	<div id="hotelDetail" class="modal fade" tabindex="-1" role="dialog"aria-labelledby="exampleModalLabel" aria-hidden="true">
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
	        <button type="button" class="btn btn-skin" data-dismiss="modal">닫기</button>
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
	        <button type="button" class="btn btn-skin mr-01" data-dismiss="modal">닫기</button>
	        <button type="button"  onclick="submitAddForm()" class="btn btn-skin">등록</button>
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
	        <button id="roomListCloseBtn" type="button" class="btn btn-skin" data-dismiss="modal">닫기</button>
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
	        <button type="button" class="btn btn-skin mr-01" data-dismiss="modal">닫기</button>
	        <button onclick="submitEditForm()" type="button" class="btn btn-skin">변경내용저장</button>
	      </div>
	    </div>
	  </div>
	</div>


  <!-- Section: 예약 리스트 -->
  <section id="sectionReserv" class="home-section color-dark bg-gray">
    <div class="container marginbot-50">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
            <div class="section-heading text-center">
              <h2 class="h-bold">예약 현황</h2>
              <div class="divider-header"></div>
              <p>Lorem ipsum dolor sit amet, agam perfecto sensibus usu at duo ut iriure.</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="text-center">
      <div class="container">

        <div class="row">
          <div class="col-md-3">
            <div class="wow fadeInLeft" data-wow-delay="0.2s">
              <div class="service-box">
                <div class="service-icon">
                  <span class="fa fa-cogs fa-5x"></span>
                </div>
                <div class="service-desc">
                  <h5>Web Design</h5>
                  <p>
                    Ad denique euripidis signiferumque vim, iusto admodum quo cu. No tritani neglegentur mediocritatem duo.
                  </p>
                  <a href="#" class="btn btn-skin">Learn more</a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="wow fadeInUp" data-wow-delay="0.2s">
              <div class="service-box">
                <div class="service-icon">
                  <span class="fa fa-camera fa-5x"></span>
                </div>
                <div class="service-desc">
                  <h5>Photography</h5>
                  <p>
                    Ad denique euripidis signiferumque vim, iusto admodum quo cu. No tritani neglegentur mediocritatem duo.
                  </p>
                  <a href="#" class="btn btn-skin">Learn more</a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="wow fadeInUp" data-wow-delay="0.2s">
              <div class="service-box">
                <div class="service-icon">
                  <span class="fa fa-laptop fa-5x"></span>
                </div>
                <div class="service-desc">
                  <h5>Graphic design</h5>
                  <p>
                    Ad denique euripidis signiferumque vim, iusto admodum quo cu. No tritani neglegentur mediocritatem duo.
                  </p>
                  <a href="#" class="btn btn-skin">Learn more</a>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="wow fadeInRight" data-wow-delay="0.2s">
              <div class="service-box">
                <div class="service-icon">
                  <span class="fa fa-mobile-phone fa-5x"></span>
                </div>
                <div class="service-desc">
                  <h5>Mobile apps</h5>
                  <p>
                    Ad denique euripidis signiferumque vim, iusto admodum quo cu. No tritani neglegentur mediocritatem duo.
                  </p>
                  <a href="#" class="btn btn-skin">Learn more</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- /Section: 예약 리스트 -->


  <!-- Section: 리뷰 리스트 -->
  <section id="sectionReview" class="home-section color-dark text-center bg-white">
    <div class="container marginbot-50">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
            <div class="section-heading text-center">
              <h2 class="h-bold">호텔 리뷰</h2>
              <div class="divider-header"></div>
              <p>Lorem ipsum dolor sit amet, agam perfecto sensibus usu at duo ut iriure.</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="wow bounceInUp" data-wow-delay="0.4s">
            <div id="owl-works" class="owl-carousel">
              <div class="item"><a href="img/works/1.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/1@2x.jpg"><img src="img/works/1.jpg" class="img-responsive" alt="img"></a></div>
              <div class="item"><a href="img/works/2.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/2@2x.jpg"><img src="img/works/2.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/3.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/3@2x.jpg"><img src="img/works/3.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/4.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/4@2x.jpg"><img src="img/works/4.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/5.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/5@2x.jpg"><img src="img/works/5.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/6.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/6@2x.jpg"><img src="img/works/6.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/7.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/7@2x.jpg"><img src="img/works/7.jpg" class="img-responsive " alt="img"></a></div>
              <div class="item"><a href="img/works/8.jpg" title="This is an image title" data-lightbox-gallery="gallery1" data-lightbox-hidpi="img/works/8@2x.jpg"><img src="img/works/8.jpg" class="img-responsive " alt="img"></a></div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </section>
  <!-- /Section: 리뷰 리스트 -->

  <!-- Section: 멤버 리스트 -->
  <section id="sectionMember" class="home-section nopadd-bot color-dark bg-gray text-center">
    <div class="container marginbot-50">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
            <div class="section-heading text-center">
              <h2 class="h-bold">회원 관리</h2>
              <div class="divider-header"></div>
              <p>Lorem ipsum dolor sit amet, agam perfecto sensibus usu at duo ut iriure.</p>
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="container">
     <div class="row marginbot-80">
        <div class="col-md-8 col-md-offset-2">
          <div id="sendmessage">Your message has been sent. Thank you!</div>
          <div id="errormessage"></div>
          <form action="" method="post" role="form" class="contactForm">
            <div class="form-group">
              <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
              <div class="validation"></div>
            </div>
            <div class="form-group">
              <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
              <div class="validation"></div>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
              <div class="validation"></div>
            </div>
            <div class="form-group">
              <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
              <div class="validation"></div>
            </div>
            <div class="text-center"><button type="submit" class="btn btn-skin btn-lg btn-block">Send Message</button></div>
          </form>
        </div>
      </div>
    </div>
  </section>
  <!-- /Section: 멤버 리스트 -->

  <!-- Footer 시작 -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">

          <div class="text-center">
            <a href="#sectionHotel" class="totop"><i class="fa fa-angle-up fa-3x"></i></a>
            <p>&copy; Bitcamp - Where Change Begins </p>
            <div class="credits">
              <!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Shuffle
              -->
              Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!-- footer END -->
  
  
  <!-- Core JavaScript Files -->
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.sticky.js"></script>
  <script src="js/jquery.flexslider-min.js"></script>
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/jquery.scrollTo.js"></script>
  <script src="js/jquery.appear.js"></script>
  <script src="js/stellar.js"></script>
  <script src="js/wow.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/nivo-lightbox.min.js"></script>
  <script src="js/custom.js"></script>
  <script src="contactform/contactform.js"></script>

</body>
</html>
