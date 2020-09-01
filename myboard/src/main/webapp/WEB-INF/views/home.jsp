<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>게시판</title>
<style>
a {
	text-decoration: none;
}

a:hover {
	color: black;
	font-weight: bold;
	text-decoration: none;
}

table {
	table-layout: fixed;
}

.log-out {
	position: fixed;
	right: 320px;
	top: 30px;
}

.logout-btn {
	position: fixed;
	right: 240px;
	top: 20px;
	width: 80px;
	height: 40px;
	background: #166cea;
	color: #fff;
	font-size: 16px;
	border: none;
	border-radius: 25px;
	cursor: pointer;
}

.new-btn {
	width: 80px;
	height: 40px;
	background: #166cea;
	color: #fff;
	font-size: 16px;
	border: none;
	border-radius: 25px;
	cursor: pointer;
}
</style>

</head>

<body>
	<c:if test="${member==null}">
		<script>
			window.location="goLogin";
		</script>
	</c:if>
	<div style="width: 0px; margin: auto;">
		<div
			style="position: relative; width: 1024px; left: 50%; margin-left: -512px;">
			<h2 align="center">MyBoard(Hibernate&JPA)</h2>
			<c:if test="${member != null}">
				<span class="log-out">${member.userId}님, 안녕하세요.
					<button class="logout-btn" type="button"
						onclick="location.href='logout.do'">로그아웃</button>
				</span>
			</c:if>
			<table class="table table-hover">
				<colgroup>
					<col width="60px">
					<col width="300px">
					<col width="100px">
					<col width="150px">
				</colgroup>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>아이디</td>
					<td>조회수</td>
					<td>등록일</td>
				</tr>
				<c:if test="${bdlist.size() == 0}">
				<tr><td colspan="5">찾으시는 결과가 없습니다</td></tr>
				</c:if>
				<c:forEach items="${bdlist}" var="board">
					<tr>
						<td style="padding-left: 15px;">${board.bbsno}</td>

						<td><a href="oneview?bbsno=${board.bbsno}">${board.title}</a></td>

						<td>${board.userId}</td>
						<td>${board.viewcnt}</td>
						<td>${board.writedDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right"><button class="new-btn"
							onclick="location.href='goWrite'">신규</button></td>
				</tr>

			</table>
		</div>
	</div>
	<script>
	 function list(page) {
		window.location.href="goMain?curPage="+page;
	}
		
	 </script>
	<div style="display: table; margin-left: auto; margin-right: auto;">
		<ul class="pagination">
			<li><a href="#" onclick="list(1)">[처음]</a> <c:if
					test="${1 < page.curBlock}">
					<li><a href="#" onclick="list(${page.prevPage})">[이전] -
							${page.prevPage}</a>
				</c:if> <c:forEach begin="${page.blockBegin}" end="${page.blockEnd}"
					var="num">
					<c:choose>
						<c:when test="${num eq page.curPage}">
							<li><span style="color: red">${num}</span>&nbsp
						</c:when>
						<c:otherwise>
							<li><a href="#" onclick="list(${num})">${num}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${page.curBlock <=page.totBlock}">
					<li><a href="#" onclick="list(${page.nextPage})">[다음]</a>
				</c:if> <c:if test="${page.curBlock<=page.totPage}">
					<li><a href="#" onclick="list(${page.totPage})">[끝] </a>
				</c:if>
		</ul>
	</div>
	<div style="display: table; margin-left: auto; margin-right: auto;">
	<form action="search.do" method="post">
		<select style="width: 100px; text-align: center;" name="category">
			<option value="userId">아이디</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="keyword"> <button type="submit">검색</button>
	</form>
	</div>
</body>
</html>
