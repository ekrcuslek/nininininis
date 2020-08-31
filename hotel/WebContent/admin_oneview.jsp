<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>    

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="hotel.domain.*"%>
<%@ page import="hotel.dao.*"%>
<%@ page import="hotel.service.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>TheFourSeaon-admin</title>

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
	<style>
table {
	width: 400px;
	table-layout: fixed;
}


</style>
<script>
function doOpenCheck(chk){
    var obj = document.getElementsByName("room");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}
function actionPage(frm) {
	frm.action = "admin_delete.jsp";
	frm.submit();
}
</script>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
BookService bs = new BookService();

String date = request.getParameter("date");
String room = request.getParameter("room");

Booking bk = bs.OneBook(date,room);

String loginOK = null;

String jumpURL = "admin_login.jsp?jump=admin_allview.jsp";

loginOK = (String) session.getAttribute("login_ok");
if (loginOK == null) {

	response.sendRedirect(jumpURL);
	return;
}

if (!loginOK.equals("yes")) {
	response.sendRedirect(jumpURL);
	return;
}
%>
	
<!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <strong>Tht Four Season</b>
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
										<li><a href="map.html" target="here">호텔 위치</a></li>
										<li><a
											href="https://map.kakao.com/link/to/한국폴리텍대학 융합기술교육원,37.3860521, 127.1214038"
											target="here">대중교통이용</a></li>
										<li><a href="diluxroom.html">자가용이용</a></li>
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
										<li><a href="#">예약하기</a></li>
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
	<table class="table table-hover">
		<colgroup>
		<col width="100px">
		<col width="200px">
		</colgroup>
		<form action="admin_update.jsp" method="post">
			<tr>
				<td>성명</td>
				<td><input type="text" name="name" value="<%=bk.getName()%>"></td>
			</tr>
			<tr>
				<td>예약일자</td>

				<td><input type="text" name="write_date" value="<%=bk.getWrite_date()%>"></td>
			</tr>
			<tr>
				<td>투숙일</td>
				<td>
					<input type="text" name="date" value="<%=bk.getDate()%>">
				</td>
			</tr>
			<tr>
				<td>예약방</td>
				<%
					if (bk.getRoom().equals("1")) {
						%> <td><input type="checkbox" name="room" value="1" checked onclick="doOpenCheck(this);">viproom
					<input type="checkbox" name="room" value="2" onclick="doOpenCheck(this);">deluxeroom
					<input type="checkbox" name="room" value="3" onclick="doOpenCheck(this);">bizroom
						<%
					}
					if (bk.getRoom().equals("2")) {
						%><td><input type="checkbox" name="room" value="1" onclick="doOpenCheck(this);">viproom
					<input type="checkbox" name="room" value="2" checked onclick="doOpenCheck(this);">deluxeroom
					<input type="checkbox" name="room" value="3" onclick="doOpenCheck(this);">bizroom <%
					}
					if (bk.getRoom().equals("3")) {
						%> <td><input type="checkbox" name="room" value="1" onclick="doOpenCheck(this);">viproom
					<input type="checkbox" name="room" value="2"  onclick="doOpenCheck(this);">deluxeroom
					<input type="checkbox" name="room" value="3" checked onclick="doOpenCheck(this);">bizroom <%
					}
					
				
				%>
				


		</td>
			</tr>
			<tr>
				<td>주소</td>

				<td><input type="text" name="addr" value="<%=bk.getAddr()%>"></td>
			</tr>
			<tr>
				<td>전화번호1</td>
				<td><input name="tel" type="number" id="phoneNum" maxlength="11" value="<%=bk.getTelnum() %>" ></td>
			</tr>
			<tr>
				<td>입금자명</td>
				<td><input name="in_name" type="text" value="<%=bk.getIn_name()%>"></td>
			</tr>
			<tr>
				<td>남기실말</td>
				<td><input name="comment" type="text" value="<%=bk.getComment()%>"></td>
			</tr>

			<tr>
				<td ><button type="submit">전송</button></td>
				<td><button type="submit" onclick="actionPage(this.form)">삭제</button></td>
			</tr>
			<input type="hidden" name="originDate" value="<%=bk.getDate()%>">
			<input type="hidden" name="originRoom" value="<%=bk.getRoom()%>">
			
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