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
a:hover {
	text-decoration: none;
	color: black;
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
img {
	border: 0px red;
	height: 10px;
	background: red;
	margin-top: 6px;
}
a:hover {
	font-weight: bold;
	color:red;
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
					<td  id="A" style="text-align: center; border-radius: 0px 10px 0px 0px;"><a
						href="goResult">개표결과</a></td>
				</tr>
			</table>
			<table style="width: 600px;">
				<colgroup>
					<col width="100px">
					<col width="500px">
				</colgroup>
				<tr>
					<td colspan="2" align="left">기호 ${huboVo.no} - ${huboVo.name}의
						연령대별 투표 결과</td>
				</tr>
				<tr>
					<td width="60px">10대</td>
					<td><img width="${((voteVo.age10 / voteVo.sum()) * 100)*1.7}">${voteVo.age10}(<fmt:formatNumber
							value="${(voteVo.age10 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">20대</td>
					<td><img width="${((voteVo.age20 / voteVo.sum()) * 100)*1.7}">${voteVo.age20}(<fmt:formatNumber
							value="${(voteVo.age20 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">30대</td>
					<td><img width="${((voteVo.age30 / voteVo.sum()) * 100)*1.7}">${voteVo.age30}(<fmt:formatNumber
							value="${(voteVo.age30 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">40대</td>
					<td><img width="${((voteVo.age40 / voteVo.sum()) * 100)*1.7}">${voteVo.age40}(<fmt:formatNumber
							value="${(voteVo.age40 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">50대</td>
					<td><img width="${((voteVo.age50 / voteVo.sum()) * 100)*1.7}">${voteVo.age50}(<fmt:formatNumber
							value="${(voteVo.age50 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">60대</td>
					<td><img width="${((voteVo.age60 / voteVo.sum()) * 100)*1.7}">${voteVo.age60}(<fmt:formatNumber
							value="${(voteVo.age60 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">70대</td>
					<td><img width="${((voteVo.age70 / voteVo.sum()) * 100)*1.7}">${voteVo.age70}(<fmt:formatNumber
							value="${(voteVo.age70 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">80대</td>
					<td><img width="${((voteVo.age80 / voteVo.sum()) * 100)*1.7}">${voteVo.age80}(<fmt:formatNumber
							value="${(voteVo.age80 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>
				<tr>
					<td width="60px">90대</td>
					<td><img width="${((voteVo.age90 / voteVo.sum()) * 100)*1.7}">${voteVo.age90}(<fmt:formatNumber
							value="${(voteVo.age90 / voteVo.sum()) * 100}" pattern=".00" />%)</td>
				</tr>


			</table>
		</div>
	</div>

</body>
</html>