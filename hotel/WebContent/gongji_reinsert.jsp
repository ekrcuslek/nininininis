<%@page import="domain.Board"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
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
<title>공지사항 만들기</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<style>
@font-face { font-family: '양진체'; src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'MaplestoryOTFBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'Arita-buri-SemiBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Arita-buri-SemiBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	
	li {
		font-family:"Arita-buri-SemiBold", "NanumGothic";
		font-size: large;
		font-weight: bold;
	}

</style>
<script>
	function actionPage(frm) {
		frm.action = "gongji_write.jsp";
		frm.submit();
	}
	function today() {
		var day = new Date();
		var year = day.getFullYear();
		var mon = day.getMonth() + 1;
		var d = day.getDate();
		document.getElementsByName("date")[0].value = year + "-" + mon + "-"
				+ d;
	}
	function postForm() {
		$('textarea[name="text"]').val($('#summernote').summernote('code'));
	}
	$(document).ready(function() {
	    $('#summernote').summernote({
			height:350
	        });
	});
</script>
<%
BoardService bs = new BoardService();
Board bd = new Board();
request.setCharacterEncoding("UTF-8");
int recnt=0;
if (request.getParameter("no") != null && request.getParameter("relevel") != null) {
	bd = bs.selectOne(Integer.parseInt(request.getParameter("no")));
	recnt = bs.countRecnt(Integer.parseInt(request.getParameter("no"))); 
	
}

if (request.getParameter("rererootid")!=null) {
	
	
	bd = bs.selectOne(Integer.parseInt(request.getParameter("rererootid"))); // 루트아이디가 아이디랑 같은 애들을 뽑아냄
	recnt = bs.countRecnt(Integer.parseInt(request.getParameter("rererootid"))); 
	
	
}
%>
	
</head>
<body onload="today()">
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
	<h2 align="center">댓글 새로입력</h2>
	<table class="table table-hover" style="width:1000px; margin:auto">
		<colgroup>
			<col width="100px">
			<col width="500px" >
		</colgroup>
		<form method="post" action="gongji_write.jsp" onsubmit="postForm()" enctype="multipart/form-data">
			<tr>
				<td>번호</td>
				<td>댓글(insert)</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="titleRe"></td>
			</tr>
			<tr>
				<td>일자</td>
				<td><input type="text" name="date"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="summernote" style="width: 400px; height: 300px;"
					name="textRe"></textarea></td>
			</tr>
			<tr><td colspan=2><input type="file" name="file"></td></tr>
			<tr>
				<td>원글</td>
				<td><input style="width: 50px;" type="number" name="rootid"
					value="<%=bd.getRootid()%>" readonly></td>
			</tr>
			<tr>
				<td>댓글수준</td>
				<td><input style="width: 50px;" type="number" name="relevel"
					value="<%=request.getParameter("relevel")%>"
					readonly> 댓글내 순서<input style="width: 50px;" type="number"
					name="recnt" value="<%=recnt +1%>" readonly></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="button"
					onclick="location.href='gongji_list.jsp'" value="취소"><input
					type="submit" onclick="location.href='gongji_write.jsp'" value="쓰기">
			</tr>
		</form>
	</table>


</body>