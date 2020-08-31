<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="hotel.domain.*"%>
<%@ page import="hotel.dao.*"%>
<%@ page import="hotel.service.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>TheFourSeaon-admin</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
        <!-- Place favicon.ico in the root directory -->

		<!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/gijgo.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
  
<meta charset="utf-8">
<title>admin page</title>
<style>
#goBlack:link, #goBlack:visited {
	color:red; text-decoration:none;
}
@font-face { font-family: '양진체'; src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'MaplestoryOTFBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'Arita-buri-SemiBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Arita-buri-SemiBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	
	li {
		font-family:"Arita-buri-SemiBold", "NanumGothic";
		font-size: large;
		font-weight: bold;
	}

</style>
<%
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

request.setCharacterEncoding("UTF-8");


response.setHeader("cache-control","no-store, no-cache, must-revalidate");
response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 

response.setHeader("expires","0");
response.setHeader("pragma","no-cache");
%>

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

    <header>
        <!-- Header Start -->
       <div class="header-area header-sticky" style="background-color: #E6CDA7;">
            <div class="main-header ">
                <div class="container">
                    <div class="row align-items-center">
                        <!-- logo -->
                        <div class="col-xl-2 col-lg-2">
                            <div class="logo">
                               <a href="newindex.html"><img style="width:250px;height:100px;" src="logo.jpg" alt=""></a>
                            </div>
                        </div>
                    <div class="col-xl-8 col-lg-8">
                            <!-- main-menu -->
                            <!-- main-menu -->
							<div class="main-menu f-right d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li style="margin-left: 30px;">리조트소개
											<ul class="submenu">
												<li><a href="about.html">사계절 호텔&리조트</a></li>
												<li><a href="viproom.html" >VIP룸</a></li>
												<li><a href="diluxroom.html" >디럭스룸</a></li>
												<li><a href="bizroom.html" >비즈니스룸</a></li>
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
        <!-- Header End -->
    </header>
	<%
		BookService bs = new BookService();
	List<Booking> bkList = bs.selectBookList();

	Calendar cal = Calendar.getInstance(); //Calendar객체 cal생성
	int currentYear = cal.get(Calendar.YEAR); //현재 날짜 기억
	int currentMonth = cal.get(Calendar.MONTH);
	int currentDate = cal.get(Calendar.DATE);
	String Year = request.getParameter("year"); //나타내고자 하는 날짜
	String Month = request.getParameter("month");
	int year, month;
	if (Year == null && Month == null) { //처음 호출했을 때
		year = currentYear;
		month = currentMonth;
	} else { //나타내고자 하는 날짜를 숫자로 변환
		year = Integer.parseInt(Year);
		month = Integer.parseInt(Month);
		if (month < 0) {
			month = 11;
			year = year - 1;
		} //1월부터 12월까지 범위 지정.
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
	}
	int count = 0;
	%>
	<center>
		<table border=0>
			<!-- 달력 상단 부분, 더 좋은 방법이 없을까? -->
			<tr>
				<td width=200></td>
				<td align=center width=300>
					<!-- 월 --> <a
					href="book_list2.jsp?year=<%out.print(year);%>&month=<%out.print(month - 1);%>">◀</a>
					<%
						out.print(month + 1);
					%>월<%
						if (month > currentMonth) {

					} else {
					%> <a
					href="book_list2.jsp?year=<%out.print(year);%>&month=<%out.print(month + 1);%>">▶</a>
				</td>
				<%
					}
				%>
				<td align=right width=200>
					<%
						out.print(currentYear + "년" + (currentMonth + 1) + "월" + currentDate + "일");
					%>
				</td>
			</tr>
		</table>
		<table border=1 cellspacing=0>
			<!-- 달력 부분 -->
			<tr>
				<td align=center width=150>일</td>
				<!-- 일=1 -->
				<td align=center width=150>월</td>
				<!-- 월=2 -->
				<td align=center width=150>화</td>
				<!-- 화=3 -->
				<td align=center width=150>수</td>
				<!-- 수=4 -->
				<td align=center width=150>목</td>
				<!-- 목=5 -->
				<td align=center width=150>금</td>
				<!-- 금=6 -->
				<td align=center width=150>토</td>
				<!-- 토=7 -->
			</tr>
			<tr>
				<%
					cal.set(year, month, 1); //현재 날짜를 현재 월의 1일로 설정
				int startDay = cal.get(Calendar.DAY_OF_WEEK); //현재날짜(1일)의 요일
				int end = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //이 달의 끝나는 날
				int br = 0; //7일마다 줄 바꾸기
				for (int i = 0; i < (startDay - 1); i++) { //빈칸출력
					out.println("<td style='background-color:gray; border:1px solid;'>&nbsp;</td>");
					br++;
					if ((br % 7) == 0) {
						out.println("<br>");
					}
				}
				for (int i = 1; i <= end; i++) { //날짜출력

					Date systemcal = Calendar.getInstance().getTime();
					String formatString = "d";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
					String formattedDate = simpleDateFormat.format(systemcal);
					int checkDay = Integer.parseInt(formattedDate);
					Calendar systemcal1 = Calendar.getInstance();
					if (i < checkDay && month == systemcal1.get(Calendar.MONTH)) { // 오늘 날짜부터 날짜를 찍어내기
				%>
				<td style='background: red;'><%=i%><br> <b>예약불가</b><br>
					<b>예약불가</b><br> <b>예약불가</b><br></td>
				<%
					br++;
				} else {
				%><td><%=i%><br> <%
 	String dddd = year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", i);
 if (bs.selectOneBook(dddd, "1") == 1) {
	 Booking onebook = bs.OneViewBook(dddd,1);
 %> <b><a id="goBlack" href="admin_oneview.jsp?date=<%=onebook.getDate()%>&room=<%=onebook.getRoom()%>"><%=onebook.getName().substring(0,1) + "*"+onebook.getName().substring(onebook.getName().length()-1) %></a></b><br> <%
 	// 데이트 ,룸 번호 뽑아서 있으면 1이 나올꺼임 그래서 1 이면 예약완료 찍으면 됨 아니면 그냥 링크 찍고!!!
 } else {
 %> <a
					href="booking.jsp?day=<%=i%>&month=<%=month%>&year=<%=year%>&room='1'">
						vip룸 </a><br> <%
 	}

 if (bs.selectOneBook(dddd, "2") == 1) {
	 Booking onebook = bs.OneViewBook(dddd,2);
 %> <b><a id="goBlack" href="admin_oneview.jsp?date=<%=onebook.getDate()%>&room=<%=onebook.getRoom()%>"><%=onebook.getName().substring(0,1) + "*"+onebook.getName().substring(onebook.getName().length()-1) %></a></b><br> <%
 	} else {
 %> <a
					href="booking.jsp?day=<%=i%>&month=<%=month%>&year=<%=year%>&room='2'">
						디럭스룸 </a><br> <%
 	}

 if (bs.selectOneBook(dddd, "3") == 1) {
	 Booking onebook = bs.OneViewBook(dddd,3);
 %> <b><a id="goBlack" href="admin_oneview.jsp?date=<%=onebook.getDate()%>&room=<%=onebook.getRoom()%>"><%=onebook.getName().substring(0,1) + "*"+onebook.getName().substring(onebook.getName().length()-1) %></a></b><br> <%
 	} else {
 %> <a
					href="booking.jsp?day=<%=i%>&month=<%=month%>&year=<%=year%>&room='3'">
						비즈니스룸 </a> <%
 	}
 %></td>
				<%
					br++;
				count++;
				}
				if ((br % 7) == 0 && i != end) {
				%>
			</tr>
			<tr>
				<%
					}
				}
				while ((br++) % 7 != 0) //말일 이후 빈칸출력
				%>
				<td style='background-color: gray; border: 1px solid;'>&nbsp;</td>
			</tr>
		</table>
	</center>
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