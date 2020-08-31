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
</head>
<body>
<%
BoardService bs = new BoardService();
bs.createTable();
out.println("완료");
%>


</body>
