<%@page import="dao.File1DAO"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="domain.File1,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*,java.util.List,java.util.ArrayList"%>
	
	
<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Hotel</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

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
<title>공지사항 만들기</title>
<style>

#num {
	border: none;
	border-right: 0px;
	border-top: 0px;
	boder-left: 0px;
	boder-bottom: 0px;
}
</style>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	function actionPage(frm) {
		frm.action = "gongji_delete.jsp";
		frm.submit();
	}
	
</script>
</head>
<body>
<header>
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
	String loginOK = null;



	loginOK = (String) session.getAttribute("login_ok");
	
		request.setCharacterEncoding("UTF-8");
		BoardService bs = new BoardService();
		File1DAO fd = new File1DAO(); 
		int count = bs.countvisit(Integer.parseInt(request.getParameter("no")));
		List<Board> bdList = bs.selectAll();
		List<File1> fList = fd.fileAll();
		List<File1> newfList = new ArrayList<File1>();
		for(File1 f: fList) {
			if (f.getId()==Integer.parseInt(request.getParameter("no"))) {
				newfList.add(f);
			}
		}
	%>
	<h2 align="center">글 보기</h2>
	<table  class="table table-hover" style="width:1400px; margin:auto">
		
		<form method="post" action="gongji_update.jsp"  >
			<%
				//원글
			for (int i = 0; i < bdList.size(); i++) {
				if (Integer.parseInt(request.getParameter("no")) == bdList.get(i).getNo() && bdList.get(i).getRelevel() == 0) {
			%>
			<tr>
				<td>번호</td>
				<td><input id="num" type="number" name="num"
					value="<%=bdList.get(i).getNo()%>" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=bdList.get(i).getTitle()%></td>
			</tr>
			<tr>
				<td>일자</td>
				<td><%=bdList.get(i).getDate()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=count%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><%=bdList.get(i).getText()%></td>
			</tr>
			<tr>
				<td>원글</td>
				<td><%=bdList.get(i).getRootid()%></td>
				
			</tr>
			<tr>
			<td>파일</td>
			<td>
				<%
					if (newfList.size() > 0) {
						for (File1 f : newfList) {
						%> 
						<a href="download.jsp?filename=<%=f.getFilename1()%>" >
						<span class='glyphicon glyphicon-download-alt' aria-hidden='true'></span><%=f.getFilename1() %></a>
						 <%
						} %></td><%
					} else {
						
					}
				%>
			</tr>
			<tr>
			 <% if (loginOK == null || !loginOK.equals("yes")) {
				%> <td></td>
					<td align="right"><input type="button"
						onclick="location.href='gongji_list.jsp'" value="목록"><input
						type="submit" onclick="location.href='gongji_update.jsp'"
						value="수정"><input type="button"
						onclick="location.href='gongji_delete.jsp?nodl=<%=bdList.get(i).getRootid()%>'"
						value="삭제"> </td> <%
				 
			 } else {
				 %> <td></td>
					<td align="right"><input type="button"
						onclick="location.href='gongji_list.jsp'" value="목록"><input
						type="submit" onclick="location.href='gongji_update.jsp'"
						value="수정"><input type="button"
						onclick="location.href='gongji_delete.jsp?nodl=<%=bdList.get(i).getRootid()%>'"
						value="삭제"> 
						<input type="button"
						onclick="location.href='gongji_reinsert.jsp?relevel=<%=bdList.get(i).getRelevel()+1 %>&rererootid=<%=bdList.get(i).getRootid() %>'" value="댓글"></td>
						<%
				 
			 } %>
				

			</tr>
			<%
				} else {
			if (Integer.parseInt(request.getParameter("no")) == bdList.get(i).getNo()) {
			%>
			<tr>
				<td>번호</td>
				<td><input id="num" type="number" name="num"
					value="<%=bdList.get(i).getNo()%>" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=bdList.get(i).getTitle()%></td>
			</tr>
			<tr>
				<td>일자</td>
				<td><%=bdList.get(i).getDate()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=count%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><%=bdList.get(i).getText()%></td>
			</tr>
			<tr>
				<td>원글</td>
				<td><%=bdList.get(i).getRootid()%></td>
			</tr>
			
			<tr>
			<td>파일</td>
			<td>
				<%
					if (newfList.size()>0) {
						for (File1 f : newfList) {
						%> 
						
						<a href="download.jsp?filename=<%=f.getFilename1()%>" >
						<span class='glyphicon glyphicon-download-alt' aria-hidden='true'></span><%=f.getFilename1() %></a> <%
						}
						%> </td><% 
					} else {
						%>  <%
					}
				%>
			</tr>
			<tr>
			<%
			
			
			if (loginOK == null || !loginOK.equals("yes")) {
				%> <td></td>
				<td align="right"><input type="button"
					onclick="location.href='gongji_list.jsp'" value="목록"><input
					type="submit" onclick="location.href='gongji_update.jsp'"
					value="수정"><input type="button"
					onclick="location.href='gongji_delete.jsp?nodl=<%=bdList.get(i).getRootid()%>'"
					value="삭제"> </td> <%
			} else {
				%> <td></td>
				<td align="right"><input type="button"
					onclick="location.href='gongji_list.jsp'" value="목록"><input
					type="submit" onclick="location.href='gongji_update.jsp'"
					value="수정"><input type="button"
					onclick="location.href='gongji_delete.jsp?nodl=<%=bdList.get(i).getRootid()%>'"
					value="삭제"> 
					<input type="button"
					onclick="location.href='gongji_reinsert.jsp?relevel=<%=bdList.get(i).getRelevel()+1 %>&rererootid=<%=bdList.get(i).getRootid() %>'" value="댓글"></td>
					<%
			}
			%>
				
					
					
			</tr>
		<%
			}
		}
		}
		%>
		</form>
	</table>
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