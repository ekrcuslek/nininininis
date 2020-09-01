<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="resources/css/login.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>로그인 페이지</title>
</head>
<body>

	<section class="login-form">


		<form action="login.do" method="post" id="loginForm">
			<c:if test="${member == null}">

				<h1>로그인 페이지</h1>
				<div class="int-area">
					<input type="text" name="userId" id="userId" autocomplete="off"
						required> <label for="userId">USER ID</label>
				</div>
				<div class="int-area">
					<input type="password" name="userPw" id="userPw" autocomplete="off"
						required> <label for="userPw">PASSWORD</label>
				</div>
				<div class="btn-area">
					<button type="submit" id="btn">LOGIN</button>
				</div>
				<div class="btn-area">
					<button type="button" onclick="location.href='goJoin'">회원가입</button>
				</div>
			</c:if>
			<c:if test="${member != null}">
				<div>
					<script>
					
						swal({
							title : "환영합니다",
							text : "방가방가",
							icon : "success"
						}).then(function() {
							window.location = "goMain";
						});
					</script>
				</div>
			</c:if>
			<c:if test="${msg == false}">
				<script>
						swal({
							title : "로그인 실패",
							text : "아이디와 비밀번호를 확인하세요",
							icon : "warning"
						});
					</script>
			</c:if>
		</form>
		<div class="caption">
			<a href="#">Forgot Password?</a>
		</div>
	</section>

	<script>
		$('#btn').click(function() {
			if ($('#userId').val() == "" || $('#userId').val() == null) {
				$('#userId').next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');
				}, 1500);
			} else if ($('#userPw').val() == "" || $('#userPw').val() == null) {
				$('#userPw').next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');

				}, 1500);
			}
		});
	</script>
</body>
</html>