<%@page import="java.util.ArrayList"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="hotel.domain.Gongji,hotel.dao.GongjiDAO,hotel.service.GongjiService,java.sql.*,javax.sql.*,java.io.*,java.util.List"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>notice</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style>

</style>
<script >

function goPage() {
	location.href="real_delete.jsp";
}
function actionPage(frm) {
	frm.action = "real_delete.jsp";
	frm.submit();
}

function postForm() {
	$('textarea[name="textup"]').val($('#summernote').summernote('code'));
}
$(document).ready(function() {
    $('#summernote').summernote({
		height:350
        });
});

function checkdelete(frm) {
	var ask=confirm("really do it?");
	
	if (ask==true) {
		return true;
	} else {
		return false;
		}
}
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
<%
	request.setCharacterEncoding("UTF-8");
if (request.getParameter("num")==null) {
out.println(request.getParameter("num"));
return;
}

GongjiService bs = new GongjiService();
Gongji bd = bs.selectOne(Integer.parseInt(request.getParameter("num")));

%>
</head>
<body>
	<h2 align="center">글 수정 삭제</h2>
	<form method="post" action="real_write.jsp" onsubmit="postForm()" >
	<table class="table table-hover" style="width:1000px; margin:auto">
		
		<tr>
			<td>번호</td>
			<td><input type="number" name="noup" value="<%=bd.getNo() %>" readonly></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="titleup" value="<%=bd.getTitle()%>"></td>
		</tr>
		<tr>
			<td>일자</td>
			<td><%=bd.getDate() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="summernote" style="width:300px; height:300px;" name="textup" ><%= bd.getText()%></textarea></td>
		</tr>
		
		
		
			<tr>
			<td></td><td align="right"><input type="button" onclick="location.href='realgongji_list.jsp'" value="취소"><input
				type="submit" value="쓰기"><input
				type="button" onclick="return actionPage(this.form); goPage()" value="삭제"></td>
		</tr>
		
	</table>
	

</body>
</html>