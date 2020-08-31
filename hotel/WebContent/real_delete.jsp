<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="hotel.domain.Gongji, hotel.dao.GongjiDAO,hotel.service.GongjiService,java.sql.*,javax.sql.*,java.io.*, java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>notice</title>
<style>
td {
	border: 1px solid red;
}

table {
	margin: auto;
}
</style>

<%
	GongjiService bs = new GongjiService();
Gongji bd = new Gongji();


request.setCharacterEncoding("UTF-8");

if (request.getParameter("nodl") != null) {
	bd.setNo(Integer.parseInt(request.getParameter("nodl")));
	bs.delete(bd);
	
	
}
if (request.getParameter("noup") != null){
	bd.setNo(Integer.parseInt(request.getParameter("noup")));
	bs.delete(bd);
}
//bd.setTitle(request.getParameter("titleup"));
//bd.setText(request.getParameter("textup"));
%>
</head>
<body>
	<h2 align="center">삭제 완료</h2>
	<p style="text-align: center">
		<input type="button" onclick="location.href='realgongji_list.jsp'"
			value="첫 화면으로 이동">
	</p>



</body>