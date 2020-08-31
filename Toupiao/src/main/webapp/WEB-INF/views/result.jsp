<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 페이지</title>
<style>
img {
	border: 0px red;
	height: 10px;
	background: red;
	margin-top: 6px;
}
style>a:hover {
	text-decoration: none;
	color: black;
}
a:hover {
	font-weight: bold;
	color:red;
}
a:link {
	text-decoration: none;
	color: black;
}

a:visited {
	text-decoration: none;
	color: black;
}

a:active {
	text-decoration: none;
	color: black;
}

a {
	text-decoration: none;
}

#A {
	background-color: skyblue;
}

td {
	border: 2px solid black;
}

.wrap {
	position: relative;
	margin-top: 100px;
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="wrap1" align="center">
			<h1>당신의 중요한 한표를 주세요!</h1>
			<table style="width: 600px;">
				<colgroup>
					<col width="200px">
					<col width="200px">
					<col width="200px">

				</colgroup>
				<tr>
					<td 
						style="border:2px solid black; border-radius: 10px 0px 0px 0px; text-align: center;"><a
						href="/toupiao/">후보등록</a></td>
					<td style="text-align: center;"><a href="goVote">투표</a></td>
					<td id="A" style="text-align: center; border-radius: 0px 10px 0px 0px;"><a
						href="goResult">개표결과</a></td>
				</tr>
			</table>
			<table style="width: 600px;">
				<colgroup>
					<col width="300px">
					<col width="300px">
				</colgroup>
					<tr><td colspan="2" align="center"><strong>전체 투표율</strong></td></tr>
				<c:forEach items="${hubolist}" var="hubolist" varStatus="status">
					<tr>
						<td><a href="OneResult?no=${hubolist.no}">${hubolist.no}
								- ${hubolist.name}</a></td>
						<td ><img
							width="${((votelist[status.index].sum() / votesum) * 100) * 1.7 }">
							<fmt:formatNumber
								value="${((votelist[status.index].sum() / votesum) * 100) }"
								pattern=".00" />%</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>