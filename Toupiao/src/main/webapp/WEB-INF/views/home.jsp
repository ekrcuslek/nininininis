<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<title>Home</title>
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

<script >
	function numberMaxLength(e) { //점수 점수 지정할수 있게 해줌
		if (e.value > 21) {//후보는 20명까지만 등록가능
			alert("후보갯수를 초과했습니다..");
			e.value = null;
		}
	}
	function numberMinLength(e) { //점수 점수 지정할수 있게 해줌
		if (e.value < 0) {
			alert("잘못된 번호 입니다");
			e.value = null;
		}
	}
	function noString(obj) {//숫자만 입력되게 해줌
		obj.value = obj.value.replace(/[\a-zㄱ-ㅎㅏ-ㅣ가-힣]/g, '');
	}
	function characterCheck() { //특수문자막기
		var RegExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\+'\"\\\(\=]/gi;
		var obj = document.getElementsByName("name")[document
				.getElementsByName("name").length - 1];
		if (RegExp.test(obj.value)) {
			alert("특수문자는 입력하실 수 없습니다.");
			obj.value = obj.value.substring(0, obj.value.length - 1);//특수문자를 지우는 구문
		}
	}
	function alertmsg(){
		var obj = document.getElementsByName("name")[document
			.getElementsByName("name").length - 1];
		alert(obj.value+" 후보님의 등록을 완료했습니다");
	}
</script>

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
					<td id="A"
						style="border: 2px solid black; border-radius: 10px 0px 0px 0px; text-align: center;"><a
						href="/toupiao/">후보등록</a></td>
					<td style="text-align: center;"><a href="goVote">투표</a></td>
					<td style="text-align: center; border-radius: 0px 10px 0px 0px;"><a
						href="goResult">개표결과</a></td>
				</tr>
			</table>
			<table style="width: 600px;">
				<colgroup>
					<col width="300px">
					<col width="300px">
				</colgroup>

				<c:forEach items="${hubolist}" var="hubo">
					<form method="post" action="godelete">
						<tr>
							<td>기호번호 : <input type="text" name="no" value="${hubo.no}"
								readonly>
							</td>
							<td>후보명 : <input type="text" readonly name="name"
								value="${hubo.name}">
								<button type="submit">삭제</button>
							</td>
						</tr>
					</form>
				</c:forEach>

				<form method="post" action="goAdd">
					<tr>
						<td style="border-radius: 0px 0px 0px 10px;">기호번호 : <input
							type="number" name="no"
							oninput="numberMinLength(this), numberMaxLength(this)"
							onkeyup="noString(this)"></td>
						<td style="border-radius: 0px 0px 10px 0px;">후보명 : <input
							type="text" name="name" maxlength="5" onkeyup="characterCheck()"
							onkeydown="characterCheck()">
							<button id="inputProcess" type="submit" onclick="alertmsg()">등록</button></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
</body>
</html>
