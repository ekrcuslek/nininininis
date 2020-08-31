<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
function doOpenCheck(chk){
    var obj = document.getElementsByName("room");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}

$("#phoneNum").bind("keyup",function(event){
	var regNumber = /^[0-9]*$/;
	var temp = $("#phoneNum").val();
	if(!regNumber.test(temp)) {
		alert("only input number plz");
		$("#phoneNum").val(temp.replace(/^0-9/g,""));
	}
})




</script>


<%
request.setCharacterEncoding("UTF-8");





%>
<style>
table {
	width: 400px;
	table-layout: fixed;
}


</style>
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
										<li><a href="map.html" >호텔 위치</a></li>
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
<div style="text-align:center;">
	<table class="table table-hover" style="width: 1000px; margin: auto">
		<colgroup>
		<col width="300px">
		<col width="400px">
		</colgroup>
		<form action="bookfin.jsp" method="post">
			<tr>
				<td>성명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>예약일자</td>

				<td><input type="date" name="date" id="date1" size="12" class="text" required pattern="\d{4}-\d{2}-\d{2}" ></td>
			</tr>
			
			<tr>
				<td>예약방</td>

				<td><input type="checkbox" name="room" value="1" onclick="doOpenCheck(this);">viproom
					<input type="checkbox" name="room" value="2" onclick="doOpenCheck(this);">deluxeroom
					<input type="checkbox" name="room" value="3" onclick="doOpenCheck(this);">bizroom

		</td>
			</tr>
			<tr>
				<td>주소</td>

				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="tel" type="number" id="phoneNum" maxlength="11" ></td>
			</tr>
			<tr>
				<td>입금자명</td>
				<td><input name="in_name" type="text"></td>
			</tr>
			<tr>
				<td>남기실말</td>
				<td><input name="comment" type="text"></td>
			</tr>

			<tr>
				<td colspan='2' align="center"><button type="submit">전송</button></td>
			</tr>
		</form>
	</table>
	</div>
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