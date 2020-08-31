<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page errorPage="error.jsp"%>
<%@ page contentType="text/html; charset=utf-8"
	import="dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 만들기</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 

<script>


function actionPage(frm) {
	frm.action="gongji_write.jsp";
	
	frm.submit();
}
function today() {
	var day = new Date();
	var year = day.getFullYear();
	var mon = day.getMonth() +1;
	var d = day.getDate();
	document.getElementsByName("date")[0].value=year+"-"+mon+"-"+d;
}
function postForm() {
	$('textarea[name="text"]').val($('#summernote').summernote('code'));
}
$(document).ready(function() {
    $('#summernote').summernote({
		height:350
        });
});

$(document).ready(function(){
	$('#addFile').click(function() {
		var fileindex = $('#fileview tr').children().length;
		if (fileindex==4) {
			alert("max 3");
		} else {
			$('#fileview').append('<tr><td colspan=2>'+'<input type="file" name="file'+fileindex+'">'+'</td></tr>');
		}
	});	
});

</script>
</head>
<body onload="today()">
	<form method="post" action="gongji_write.jsp" onsubmit="postForm()" enctype="multipart/form-data">
	<h2 align="center">새 글 입력</h2>
	<table class="table table-hover" style="width:1000px; margin:auto">
	
		
		<tr>
			<td>번호</td>
			<td>신규(insert)</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>일자</td>
			<td><input type="text" name="date"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="summernote" style="width:300px; height:300px;" name="text"></textarea></td>
		</tr>
		</table>
		<table id="fileview" class="table table-hover" style="width:1000px; margin:auto">
		
		<tr><td colspan=2><input id="addFile" type="button" value="File blank add"></td></tr>
		
		</table>
		<table class="table table-hover" style="width:1000px; margin:auto">
		
		<tr>
			<td></td><td align="right"><input type="button" onclick="location.href='gongji_list.jsp'" value="취소"><input
				type="submit" onclick="location.href='gongji_write.jsp'"  value="쓰기">
		</tr>
		
	</table>
</form>
		

</body>
</html>