<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="dao.LoginDAO,domain.Membercc,dao.File1DAO,domain.File1,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.util.Enumeration,java.io.File"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 만들기</title>
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
	
<% 
request.setCharacterEncoding("UTF-8");
LoginDAO lg = new LoginDAO();



String id = request.getParameter("id");

String passwd = request.getParameter("passwd");

Membercc mb = lg.checkLogin(id, passwd);

if (mb.getId().equals(request.getParameter("id")) && mb.getPwd().equals((request.getParameter("passwd")))) {
	session.setAttribute("id", id);
	response.sendRedirect("gongji_list.jsp");
}



%>
</head>


<body>
	<title>Login 확인</title>
	<form action="sessionLogin.jsp" method="post">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비번 :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="로그인">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>


</body>
</html>