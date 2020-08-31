<%@page import="java.util.ArrayList"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="dao.File1DAO,domain.File1,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*,java.util.List"%>
	
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
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style>

</style>
<script >

function goPage() {
	location.href="gongji_delete.jsp";
}
function actionPage(frm) {
	frm.action = "gongji_delete.jsp";
	frm.submit();
}

function postForm() {
	$('textarea[name="textup"]').val($('#summernote').summernote('code'));
}
$(document).ready(function() {
    $('#summernote').summernote({
		height:350
        });
});

function checkdelete(frm) {
	var ask=confirm("really do it?");
	
	if (ask==true) {
		return true;
	} else {
		return false;
		}
}
$(document).ready(function(){
	$('#addFile').click(function() {
		var fileindex = $('#fileview tr').children().length;
		if (fileindex==4) {
			alert("max 3");
		} else {
			$('#fileview').append('<tr><td colspan=2>'+'<input type="file" name="file'+fileindex+'">'+'</td></tr>');
		}
	});	
});
</script>
<%
	request.setCharacterEncoding("UTF-8");
if (request.getParameter("num")==null) {
out.println(request.getParameter("num"));
return;
}

BoardService bs = new BoardService();
File1DAO fd = new File1DAO();
List<File1> fList = fd.fileAll();
List<File1> newfList = new ArrayList<File1>();
Board bd = bs.selectOne(Integer.parseInt(request.getParameter("num")));
for (File1 f:fList) {
	if (bd.getNo()==f.getId()) {
		newfList.add(f);
	}
}
%>
</head>
<body>
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

	<h2 align="center">글 수정 삭제</h2>
	<form method="post" action="gongji_write.jsp" onsubmit="postForm()" enctype="multipart/form-data">
	<table class="table table-hover" style="width:1000px; margin:auto">
		
		<tr>
			<td>번호</td>
			<td><input type="number" name="noup" value="<%=bd.getNo() %>" readonly></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="titleup" value="<%=bd.getTitle()%>"></td>
		</tr>
		<tr>
			<td>일자</td>
			<td><%=bd.getDate() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="summernote" style="width:300px; height:300px;" name="textup" ><%= bd.getText()%></textarea></td>
		</tr>
		
		</table>
		<table id="fileview" class="table table-hover" style="width:1000px; margin:auto">
		
		<tr><td colspan=2><input id="addFile" type="button" value="File blank add"></td></tr>
		
		</table>
	
		<table class="table table-hover" style="width:1000px; margin:auto">
		
			<tr>
			<td></td><td align="right"><input type="button" onclick="location.href='gongji_list.jsp'" value="취소"><input
				type="submit" value="쓰기"><input
				type="button" onclick="return actionPage(this.form); goPage()" value="삭제"></td>
		</tr>
		<tr>
			<td colspan=2>파일목록</td>
			</tr>
		</form>
		
				<%
					if (newfList.size()>0) {
						for (File1 f:newfList) {
						%> 
						<form method="post" name="deletefile" id="deldel" action="deletefile.jsp" >						
						<tr><td colspan=2 id="filefile">
						<a href="download.jsp?filename=<%=f.getFilename1()%>" >
						<span class='glyphicon glyphicon-download-alt' aria-hidden='true'></span><%=f.getFilename1() %></a>
						<input type="hidden" name="filename" value="<%=f.getFilename1() %>">
						<input type="hidden" name="fileid" value="<%=f.getId() %>">
						<input type="submit" value="delete"></td></tr> 
						
						<%
						}
					} else {
						%>	<tr> <td colspan=2>파일 없음</td></tr> <%
					}
				%>
			</form>
		
	</table>
	

</body>
</html>