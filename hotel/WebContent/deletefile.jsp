<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="dao.File1DAO,domain.File1,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List,java.util.ArrayList"%>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.Enumeration,java.io.File" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DB에 입력하는 페이지</title>


</head>
<body>
	
<%
File1DAO fd = new File1DAO();
request.setCharacterEncoding("UTF-8");
String filename = request.getParameter("filename");
int fileid = Integer.parseInt(request.getParameter("fileid"));
String uploadPath = request.getRealPath("upload");
out.println(filename + " " + fileid + " " + uploadPath);
File ff = new File(uploadPath,filename);
	fd.deleteFile(fileid, filename);
if (ff.exists()) {
	ff.delete();
	%> <script>alert("The file is deleted");
	location.href="gongji_update.jsp?num=<%=fileid%>";</script>
	<%
} else {
	%> <script>alert("wrong action");
	location.href="gongji_update.jsp?num="<%=fileid%>";</script>
<%}

%>
<h2>finish</h2>
</body>