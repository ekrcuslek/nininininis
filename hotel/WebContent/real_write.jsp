<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="hotel.domain.Gongji,hotel.dao.GongjiDAO,hotel.service.GongjiService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>

<%@ page import="java.util.Enumeration,java.io.File" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>notice</title>
<script>
function gomain() {
	window.location.href="realgongji_list.jsp";
}
</script>
</head>
<body>
	<%
	

	request.setCharacterEncoding("UTF-8");
	GongjiService gs = new GongjiService();
	Gongji gj = new Gongji();
		// 신규 게시물 쓰기에서 받는 파라미터
		if (request.getParameter("title") != null && request.getParameter("text") != null) {
			if(request.getParameter("title").contains("<!--")) {				
				%> <script>alert("수작부리지 마세요~"); gomain();</script> <%
				return;
			}
			if (request.getParameter("title")=="") {
				%><script>alert("최소 제목은 넣어주셔야쥬"); gomain();</script> <%
				return;
			}
			gj.setTitle(request.getParameter("title"));
			gj.setText(request.getParameter("text"));
			gs.insertNewData(gj);
										
			}
		// 수정
		
		
		if(request.getParameter("noup") !=null) {
			gj.setNo(Integer.parseInt(request.getParameter("noup")));
			gj.setTitle(request.getParameter("titleup"));
			gj.setText(request.getParameter("textup"));
			gs.update(gj);
			
		}
			

			
			

		
		
	%>
	<h3 align="center">요청 수행 완료</h3>
	<p align="center">
		<input type="button" onclick="location.href='realgongji_list.jsp'"
			value="첫 화면으로 돌아가기">
	</p>
</body>