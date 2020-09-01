<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

</head>
<body onload="today()">
	<c:if test="${member != null }">
		<h2 align="center">내글 쓰기</h2>
		<div style="position:absolute; left:25%;">
		
			<form action="write.do" method="post" id="writeForm" enctype="multipart/form-data">
				<table class="table table-hover"
					style="width: 800px; margin-top: 50px;">
					<colgroup>
						<col width="50px">
						<col width="500px">

					</colgroup>
					<tr>
						<td align>번호</td>
						<td>신규(insert)</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title"></td>
					<tr>
						<td>아이디</td>
						<td><input type="text" id="userId" name="userId"
							value="${member.userId}" readonly></td>
					</tr>
					<tr>
						<td>일자</td>
						<td><input type="text" id="date" readonly></td>
					</tr>
					
					<tr>
						<td>내용</td>
						<td><textarea style="width: 500px; height: 300px;"
								name="content" id="content"></textarea></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input type="file" name="imgfile" id="imgfile">
						<div>
								<div class="img_wrap" ><img id="img" style="width:100px;height:100px;" /></div>
						</div></td>
						
					</tr>

				</table>

				<table style="width: 800px; margin: auto">

					<tr>
						<td></td>
						<td align="right"><input type="button"
							onclick="location.href='/myboard/'" value="취소">
							<button type="submit">쓰기</button>
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
		$('#writeForm button[type=submit]').click(addBoard);
		function addBoard(e) {
			e.preventDefault();
			var form = $('#writeForm')[0];
			var data = new FormData(form);
			//var bbsData = $('#writeForm').serialize();
			var url = $('#writeForm').attr('action');

			$.ajax({
				type : 'post',
				enctype : 'multipart/form-data',
				contentType:false,
				processData:false,
				cache: false,
				url : url,
				data : data,
				success : onSuccess
			});
		}
		function onSuccess() {
			swal({
				title : "등록이 완료되었습니다",
				text : "메인화면으로 이동합니다",
				icon : "success"
			}).then(function() {
				window.location.href = "goMain";
			});
		}


		$(document).ready(function(){
			$('#imgfile').on('change',preview);
		});
		function preview(e){
			var files = e.target.files;
			var filesArr = Array.prototype.slice.call(files);
			filesArr.forEach(function(f){
				if(!f.type.match("image.*")){
					alert("확장자는 이미지 확장자만 가능");
					return
				}
				sel_file = f;
				var reader = new FileReader();
				reader.onload = function(e){
					$('#img').attr("src",e.target.result);
				}
				reader.readAsDataURL(f);
				
				});
			}
	</script>
</body>
</html>