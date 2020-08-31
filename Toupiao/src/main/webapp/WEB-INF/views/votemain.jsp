<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 페이지</title>
<style>
a:hover {
	text-decoration: none;
	color: black;
	font-weight: bold;
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
					<td id="A" style="text-align: center;"><a href="goVote">투표</a></td>
					<td style="text-align: center; border-radius: 0px 10px 0px 0px;"><a
						href="goResult">개표결과</a></td>
				</tr>
			</table>
			<table style="width: 600px;">
				<colgroup>
					<col width="200px">
					<col width="200px">
					<col width="100px">
				</colgroup>

				<tr>
					<form method="post" action="gogoVote">
						<td align="center"><select style="width: 200px;text-align:center;" name="no">
								<c:forEach items="${hubolist}" var="hubolist">
									<option value="${hubolist.no}">${hubolist.no} -
										${hubolist.name}</option>
								</c:forEach>
						</select></td>
						<td align="center"><select name="age" style="width: 200px;text-align:center;">
								<option value="10">10대</option>
								<option value="20">20대</option>
								<option value="30">30대</option>
								<option value="40">40대</option>
								<option value="50">50대</option>
								<option value="60">60대</option>
								<option value="70">70대</option>
								<option value="80">80대</option>
								<option value="90">90대</option>
						</select></td>
						<td align="center"><button type="submit">투표하기</button></td>
					</form>
				</tr>

			</table>
		</div>
	</div>

</body>
</html>