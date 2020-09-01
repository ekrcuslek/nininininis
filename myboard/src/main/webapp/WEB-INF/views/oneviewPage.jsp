<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<script src="resources/js/jquery.magnific-popup.js"></script>
<style>
#no {
	border: none;
	border-right: 0px;
	border-top: 0px;
	boder-left: 0px;
	boder-bottom: 0px;
}

</style>
<script>
	function deletePage() {
		frm.action = "delete.do";
	}
	function updatePage() {
		frm.action = "goUpdate";
	}
</script>
</head>
<body>
<body>
	<div style="width: 0px; margin: auto;">
		<div
			style="position: relative; width: 1024px; left: 50%; margin-left: -450px;">
			<h2 align="center">글 보기</h2>
			<form name="frm" method="post">
				<table class="table table-hover"
					style="width: 1024px; margin-top: 50px;">
					<colgroup>
						<col width="50px">
						<col width="500px">

					</colgroup>
					<tr>
						<td>번호</td>
						<td><input type="text" id="no" name="bbsno" readonly
							value="${board.bbsno}"></td>
					</tr>
					<tr>
					<tr>
						<td>아이디</td>
						<td>${board.userId}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>${board.title}</td>
					</tr>
					<tr>
						<td>일자</td>
						<td>${board.writedDate}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${board.content}<c:if test="${board.fileName != null }">
								<br>
								<input type="hidden" id="hidenFile" value="${board.fileName}">
								<img id="oneview" style="cursor:pointer; width: 300px; height: 300px;"
									src="upload/${board.fileName}" >
							</c:if></td>
					</tr>

				</table>

				<table style="width: 1024px; margin: auto">

					<tr>
						<td></td>
						<td align="right"><input type="button"
							onclick="location.href='goMain'" value="목록"> <c:if
								test="${member.userId == board.userId}">
								<button type="submit" onclick="updatePage()">수정</button>

								<input type="submit" onclick="deletePage()" value="삭제">
							</c:if>
					</tr>
				</table>
			</form>
			<c:if test="${member.userId == null}">
				<table class="table table-hover">
				<tr><td>로그인 후 대글 달기 가능</td></tr>
			</table>
			</c:if>
			<c:if test="${member.userId != null}">
				<table id="recomment" class="table table-hover">
					<colgroup>
					<col width="30%">
					<col width="70%">
					</colgroup>
					<c:forEach items="${comlist}" var="com"><
					<tr><td><strong>${com.userId}</strong> -- ${com.writedDate} </td></tr>
					<tr><td colspan=2>${com.comment}</td></tr>
					</c:forEach>
				</table>
				<input type="hidden" id="id" value="${member.userId}">
				<input id="inputComment" type="text" class="reply" placeholder="댓글달기..">
				<button id="recomment-btn" type="button">전송</button>
			</c:if>
		</div>
	</div>
	<script>
		// 이미지 팝업창 띄우기
		var filfile = document.querySelector("#hidenFile").value;
				console.log(filfile);
				var ssrc = document.querySelector("#oneview").src;
				console.log(ssrc);
			$(document).ready(function(){
				$("#oneview").magnificPopup({
					items: {
						src:ssrc
						},
					type:'image',
					 closeOnContentClick: true,
					
				});
			});
			//items: {
			//	src : popurl
			//	},
			//type:'image',
			//closeOnContentClick: true	
			//});
		
		$("#recomment-btn").click(addComment);

		function addComment(){
		var com = document.querySelector(".reply").value;
		var bbsno = document.querySelector("#no").value;
		var id = document.querySelector("#id").value;
		
		var url = "reply.do";
		var data = {"bbsno":bbsno,"comment":com, "userId":id};
		$.ajax({
			type : "POST",
			url : url,
			data : data,
			dataType : 'json',
			error : onError,
			success : didwell
		});		
		}
		function didwell(data) {
			var result = "<tr><td><strong>"+data.userId +"</strong>--" + data.writedDate+ "</td></tr>"
			+ "<tr><td colspan=2>"+data.comment+"</td><tr>";
			$("#recomment").append(result);
			$("#inputComment").focus();
		}
		
		$(document).ready(function() {
			var bbsno = document.querySelector("#no").value;
			var url = "viewUp";
			var data = {
				"bbsno" : bbsno
			};
			$.ajax({
				type : "POST",
				url : url,
				data : data,
				dataType : 'json',
				error : onError,
				success : onSuccess
			});
		});
		function onSuccess(data) {
			console.log("조회수" + data);
		}
		function onError() {
			alert("통신 실패 다시다시");
		}

		</script>

		
	
</body>
</html>