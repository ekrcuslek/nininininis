<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="domain.File1,dao.File1DAO,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*,java.util.*"%>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
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


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 만들기</title>
<script>
function gomain() {
	window.location.href="gongji_list.jsp";
}
</script>
<style>

@font-face { font-family: '양진체'; src: url('https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'MaplestoryOTFBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	@font-face { font-family: 'Arita-buri-SemiBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Arita-buri-SemiBold.woff') format('woff'); font-weight: normal; font-style: normal; }
	
	li {
		font-family:"Arita-buri-SemiBold", "NanumGothic";
		font-size: large;
		font-weight: bold;
	}
a {
	text-decoration:none;

}

</style>
<%



	String filename=""; // 파일 이름을 받을 변수
	BoardService bs = new BoardService();

int pageSize = 10; // 한 페이지에 볼 게시물 수
List<Board> newList = new ArrayList<Board>(); // 필터 후 게시물을 담는 리스트
List<Board> all = new ArrayList<Board>(); // 전체 게시물을 담는 리스트
List<File1> newfList = new ArrayList<File1>();
File1DAO fd = new File1DAO();
List<File1> fileList = fd.fileAll();; // 파일을 담을 리스트
request.setCharacterEncoding("UTF-8");

// pageNum은 페이지 번호, null이거나 비어있으면 디폴트로 1로  설정
String pageNum = request.getParameter("pageNum");
if (pageNum == "" || pageNum == null) {
	pageNum = "1";
}
if (request.getParameter("keyword")!=null && request.getParameter("keyword").contains("<!--")) {
	%> <script>alert("수작부리지 마쇼잉");</script> <% 
}
// 현재페이지
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize; // 몇번째 부터
int endRow = currentPage * pageSize - 1; // 몇번째 까지

int count=0;

// 검색 기능
if (request.getParameter("category") != null && (request.getParameter("keyword") != null || request.getParameter("keyword") != "")) {
	if(request.getParameter("keyword").equals("")) {
%> <script>alert("키워드를 입력하셔야죠"); gomain();</script> <%
		return;
	}
	// 파라미터들을 변수에 담는데
	String category = request.getParameter("category");
	String title= request.getParameter("title");
	String keyword= request.getParameter("keyword");
	//검색 조건에 부합하는 게시물을 리스트로 뽑는다
	all = bs.selectKeyword(category, keyword);
	
	for (int i = 0; i < all.size(); i++) {
		// 카테고리와 키워드를 갖고 있게 하기 위해 객체 필드에 넣어준다
		all.get(i).setCategory(category);
		all.get(i).setKeyword(keyword);
		// 몇번째부터 몇번째 까지 필터해서 리스트에 담는다
		if (i >= startRow && i <= endRow) {
			 // 해당 인덱스의 파일목록
			
			newList.add(all.get(i));
		}
	}
		
		count=all.size();

// 검색기능 아닌 그냥 전체
} else {
	all = bs.selectAll();
	for (int i = 0; i < all.size(); i++) {
		if (i >= startRow && i <= endRow) {
			fileList=fd.fileAll(); // 해당 인덱스의 파일목록
			newList.add(all.get(i));
		}
	}
	count=all.size();
}
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
	<h2 align="center">후기 게시판</h2>
	<table  class="table table-hover" style="width:1400px; margin:auto">

		<colgroup>
			<col width="50px">
			<col width="300px">
			<col width="100px">
			<col width="60px">
			<col width="150px">
		</colgroup>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>파일</td>
			<td>등록일</td>
		</tr>
			<%
			// 검색기능을 해서 count가 없으면 해당 결과가 없음
			if (count==0) { 
				%><tr><td colspan="5" align="center"> 찾으시는 결과가 없습니다</td></tr><%
			}else {
				// 조건에 부합한 결과가 있으면 아래 반복문 수행
				for (int i = 0; i < newList.size(); i++) {
					
			%>
		
		<tr>
			<td align="center"><%=newList.get(i).getNo()%></td>
			<%
				//댓글을 표시하기 위한 기능
				if (newList.get(i).getRelevel() > 0) {
				String a = "";
				for (int j = 0; j < newList.get(i).getRelevel(); j++) {
					a += "-";
				}
				a += ">";
			%>
			<!-- 댓글에 NEW 표시를 다는 곳 -->
			<td><a href="gongji_view.jsp?no=<%=newList.get(i).getNo()%>">[<%=a%>RE]<%=newList.get(i).getTitle()%><%=newList.get(i).getDate().equals("2020-07-20") ? "[new]" : ""%></a></td>
			<td><%=newList.get(i).getViewcnt()%></td>
			
			<td>
			<!-- 해당 게시물에 파일첨부가 있다면 게시판에 표시해준다 -->
			<% for(int j=0; j<fileList.size(); j++) {
				if (fileList.get(j).getId()==newList.get(i).getNo()) {
					filename = fileList.get(j).getFilename1();
					%> <a href="download.jsp?filename=<%=filename%>"><span class='glyphicon glyphicon-cloud-download' aria-hidden='true'></span></a> <%
					
				}
			}
			
			 %>
			</td>
			
			
			<td><%=newList.get(i).getDate()%></td>
			<%
				} else {
			%>
			<td><a href="gongji_view.jsp?no=<%=newList.get(i).getNo()%>"><%=newList.get(i).getTitle()%></a></td>
			<td><%=newList.get(i).getViewcnt()%></td>
			<td>
			<% for(int j=0; j<fileList.size(); j++) {
				if (fileList.get(j).getId()==newList.get(i).getNo()) {
				filename = fileList.get(j).getFilename1();
					%> <a href="download.jsp?filename=<%=filename%>" ><span class='glyphicon glyphicon-cloud-download' aria-hidden='true'></span></a> <%
				}
			}
			
			 %>
			</td>
			
			<td><%=newList.get(i).getDate()%></td>
		</tr>
		<%
			}
		}
			}
		%>
		<tr>
			<td align="right" colspan=5><a href="gongji_insert.jsp"><input
					type="button" value="신규"></a></td>
	</table>
	<%
		if (count > 0) {
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); // 총 페이지 수 구하기
		int pageBlock = 10; // 한 화면에 몇개의 페이지를 표시할 지
		// 시작 페이지 구하기
		int startPage = ((int) (currentPage / pageBlock) - (currentPage % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
		// 끝나는 페이지 구하기
		int endPage = startPage + pageBlock - 1;

		if (endPage > pageCount) {
			endPage = pageCount;
		}
	%>
		<div class="text-center" style="margin-left:39%;"><ul class="pagination">
		<li><a href="gongji_list.jsp"> << </a></li>
		<%
			if (startPage > pageBlock) {
		%>
		<li><a href="gongji_list.jsp?pageNum=<%=startPage - pageBlock%>"> < </a></li>
		<%
			} /*else {
		%>
		<li><a href="gongji_list.jsp?pageNum=<%=startPage%>"> < </a></li>
		<%
			} */
		%>  <%
		for (int i = startPage; i <= endPage; i++) {
			if (currentPage==i) {
				%>
				<li class="active"><a size="5" href="gongji_list.jsp?pageNum=<%=i%><%=all.get(0).getCategory()==null ? "" : "&category="+all.get(0).getCategory() %><%=all.get(0).getKeyword()==null ? "" : "&keyword="+all.get(0).getKeyword()%>&total=<%=all.size()%>"><%=i%>
		</a></li> <%
			} else {
				%><li><a href="gongji_list.jsp?pageNum=<%=i%><%=all.get(0).getCategory()==null ? "" : "&category="+all.get(0).getCategory() %><%=all.get(0).getKeyword()==null ? "" : "&keyword="+all.get(0).getKeyword()%>&total=<%=all.size()%>"><%=i%>
				</a></li>
				<%
			}
			// 아래 a태그는 카테고리와 키워드를 계속 다음 페이지로 보내기 위해 get방식으로 보낸다
		
			}
		if (endPage < pageCount) {
		%>
		<li><a href="gongji_list.jsp?pageNum=<%=startPage + pageBlock%>" > > </a></li>
		<%
			} /*else {
		%>
		<li><a href="gongji_list.jsp?pageNum=<%=endPage%>"> > </a></li>
		<%
			}*/
		%><li><a href="gongji_list.jsp?pageNum=<%=pageCount%>"> >> </a></li></ul></div>
	
	<%
		} 
	%>
	<table style="margin:auto">
		<form method="get" action="gongji_list.jsp">
			<tr>
				<td><select style="width: 100px; text-align: center;"
					name="category"  >
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select></td>
				<td><input style="border:solid 1px #dca73a;	border-radius:5px;  height:51px;" type="text" placeholder="입력" name="keyword"></td>
				<td><input style="border:solid 1px #dca73a; border-radius:5px; height:51px;" type="submit" value="검색"><input type="button" style="border:solid 1px #dca73a; border-radius:5px; height:51px;" value="초기화면 돌아가기" onclick="gomain()"></td>
			</tr>
		</form>

	</table>
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