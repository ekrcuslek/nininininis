<%@page import="java.text.*, java.util.*"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page errorPage="error.jsp"%>
<%@ page contentType="text/html; charset=utf-8"
	import="hotel.domain.Booking, hotel.dao.bookDAO, hotel.service.BookService, java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book</title>
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- CSS here -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/gijgo.css">
<link rel="stylesheet" href="assets/css/slicknav.css">
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/css/themify-icons.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/nice-select.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
</head>
<body>
	<!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <strong>The Four Season</b>
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
	<header> <!-- Header Start -->
	<div class="header-area header-sticky"
		style="background-color: #E6CDA7;">
		<div class="main-header ">
			<div class="container">
				<div class="row align-items-center">
					<!-- logo -->
					<div class="col-xl-2 col-lg-2">
						<div class="logo">
							<a href="newindex.html"><img
								style="width: 250px; height: 100px;" src="logo.jpg" alt=""></a>
						</div>
					</div>
					<div class="col-xl-8 col-lg-8">
						<!-- main-menu -->
						<div class="main-menu f-right d-none d-lg-block">
							<nav>
							<ul id="navigation">
								<li style="margin-left: 30px;">리조트소개
									<ul class="submenu">
										<li><a href="about.html">사계절 호텔&리조트</a></li>
										<li><a href="viproom.html">VIP룸</a></li>
										<li><a href="diluxroom.html">디럭스룸</a></li>
										<li><a href="bizroom.html">비즈니스룸</a></li>
									</ul>
								</li>
								<li style="margin-left: 30px;">오시는 길
									<ul class="submenu">
										<li><a href="map.html">호텔 위치</a></li>
										<li><a
											href="https://map.kakao.com/link/to/한국폴리텍대학 융합기술교육원,37.3860521, 127.1214038"
											>대중교통이용</a></li>
										<li><a href="https://map.kakao.com/link/to/한국폴리텍대학 융합기술교육원,37.3860521, 127.1214038">자가용이용</a></li>
									</ul>
								</li>

								<li style="margin-left: 30px;">주변여행지
									<ul class="submenu">
										<li><a href="around.html">분당스퀘어</a></li>
										<li><a href="around1.html">황새울공원</a></li>
										<li><a href="around2.html">CGV서현</a></li>
									</ul>
								</li>
								<li style="margin-left: 30px;">예약하기
									<ul class="submenu">
										<li><a href="book_list2.jsp">예약상황</a>
										<li><a href="admin_allview.jsp">관리자페이지</a></li>
										<li><a href="admin_logout.jsp">관리자로그아웃</a></li>
									</ul>
								</li>
								<li style="margin-left: 30px;">리조트소식
									<ul class="submenu">
										<li><a href="realgongji_list.jsp">공지사항 게시판</a></li>
										<li><a href="gongji_list.jsp">후기 남기기</a></li>
									</ul>

								</li>
							</ul>
							</nav>
						</div>
					</div>
					<div class="col-xl-2 col-lg-2">
						<!-- header-btn -->
						<div class="header-btn">
							<a href="bookonline.jsp" class="btn btn1 d-none d-lg-block ">예약하기</a>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End --> </header>
	<%
		request.setCharacterEncoding("UTF-8");
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	BookService bs = new BookService();
	java.util.Date nowdate = new java.util.Date(); 
	
	String name = request.getParameter("name");
	String date = request.getParameter("date");
	// java.util.Date checkin = df.parse(date);
	
	cal.setTime(nowdate);
	//cal2.setTime(checkin);
	
	// int howmuch = Integer.parseInt(request.getParameter("howmuch").substring(0,1));
	
	String room = request.getParameter("room");
	String addr = request.getParameter("addr");
	String tel = request.getParameter("tel");
	String in_name = request.getParameter("in_name");
	String comment = request.getParameter("comment");
	int count_duplicate =0;
	
	// for(int i = 0; i < howmuch+1; i++) {
	//	cal.add(Calendar.DATE, 1);
	//	out.println(df.format(cal.getTime())+" "+ "yida");
	
		if(bs.selectOneBook(date, room)==1){
			count_duplicate++;
		}
	//}
	if (count_duplicate > 0) {
		%>
		
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			 <script>
		   function notice2() {
		      swal({
		          title: "중복입니다",
		          text: "다시 입력하세요",
		          icon: "warning"
		      }).then(function() {
		          history.back();
		      });
		   }
		   notice2();</script> <%
	} else {
		//for(int i = 0; i < howmuch + 1; i++) {
		//	cal2.add(Calendar.DATE, 1);
		//	out.println(df.format(cal2.getTime())+" "+ "yida2");
			bs.insertBook(new Booking(name, date, room, addr, tel, in_name, comment, df.format(cal.getTime()), "1"));
			%><script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			 <script>
		   function notice1() {
		      swal({
		          title: "예약 완료",
		          text: "홈페이지로 이동합니다",
		          icon: "success"
		      }).then(function() {
		          window.location = "newindex.html";
		      });
		   }
		   notice1();
		</script> <%
	//	}
	}
	%>
	
	<!-- JS here -->
	
		<!-- All JS Custom Plugins Link Here here -->
        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
		
		<!-- Jquery, Popper, Bootstrap -->
		<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="./assets/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="./assets/js/owl.carousel.min.js"></script>
        <script src="./assets/js/slick.min.js"></script>
        <!-- Date Picker -->
        <script src="./assets/js/gijgo.min.js"></script>
		<!-- One Page, Animated-HeadLin -->
        <script src="./assets/js/wow.min.js"></script>
		<script src="./assets/js/animated.headline.js"></script>
        <script src="./assets/js/jquery.magnific-popup.js"></script>

		<!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
		<script src="./assets/js/jquery.sticky.js"></script>
        
        <!-- contact js -->
        <script src="./assets/js/contact.js"></script>
        <script src="./assets/js/jquery.form.js"></script>
        <script src="./assets/js/jquery.validate.min.js"></script>
        <script src="./assets/js/mail-script.js"></script>
        <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>

</body>
</html>