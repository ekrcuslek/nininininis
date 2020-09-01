<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
	//$(document).ready(function() {
	//	$('#summernote').summernote({
	//		height : 350
	//	});
	//});

	function today() {
		var day = new Date();
		var year = day.getFullYear();
		var mon = day.getMonth() + 1;
		var d = day.getDate();
		document.getElementById("date").value = year + "-" + mon + "-" + d;
	}
	//function postForm() {
	//	$('textarea[name="content"]').val($('#summernote').summernote('code'));
	//}
	//onsubmit="postForm()"
</script>
<style>
.select_img img {
width:300px;
heigth:300px;}

</style>
</head>
<body onload="today()">
	<c:if test="${member != null }">
		<h2 align="center">글 수정하기</h2>
		<div style="position: absolute; left: 25%;">

			<form action="update.do" method="post" id="writeForm"
				enctype="multipart/form-data">
				<table class="table table-hover"
					style="width: 800px; margin-top: 50px;">
					<colgroup>
						<col width="50px">
						<col width="500px">

					</colgroup>
					<tr>
						<td>번호</td>
						<td><input type="text" id="bbsno" name="bbsno"
							value="${board.bbsno}" readonly></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title"
							value="${board.title}"></td>
					<tr>
						<td>아이디</td>
						<td><input type="text" id="userId" name="userId"
							value="${board.userId}" readonly></td>
					</tr>
					<tr>
						<td>일자</td>
						<td><input type="text" name="writedDate" value="${board.writedDate }" readonly></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" id="gdsImg" name="file"/>
							<div class="select_img">
								<img src="upload/${board.fileName}" /> <input type="hidden"
									name="imgfile" value="${board.fileName}" />
							</div>
					<tr>
						<td>내용</td>
						<td><textarea style="width: 500px; height: 300px;"
								name="content" id="content">${board.content}</textarea></td>

					</tr>
					
				</table>

				<table style="width: 800px; margin: auto">

					<tr>
						<td></td>
						<td align="right"><input type="button"
							onclick="location.href='/myboard/'" value="취소">
							<button id="update-btn" type="submit">수정</button>
					</tr>
				</table>
			</form>
		</div>

	</c:if>
	<c:if test="${member==null}">
		<script>
			swal({
				title : "세션 없음",
				text : "로그인 요망",
				icon : "info"
			}).then(function() {
				window.location = "../myboard/goLogin";
			});
		</script>
	</c:if>
	<script>

	  $("#gdsImg").change(function(){
	   if(this.files && this.files[0]) {
	    var reader = new FileReader;
	    reader.onload = function(data) {
	     $(".select_img img").attr("src", data.target.result).width(300).heigth(300);        
	    }
	    reader.readAsDataURL(this.files[0]);
	   }
	  });
	 
		
	</script>
</body>
</html>