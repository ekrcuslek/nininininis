<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*, javax.sql.*, java.net.*, java.io.*" %>    

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="hotel.domain.*"%>
<%@ page import="hotel.dao.*"%>
<%@ page import="hotel.service.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>TheFourSeaon-admin</title>
</head>
<body>
<%
String jump = request.getParameter("jump"); // admin_allview.jsp
String id = request.getParameter("id");
String pass = request.getParameter("passwd");
//여기에서 엉뚱한 값을 체크해야 하는 데 생략

boolean bPassChk=false;


//아이디 패스워드 체크
if (id.replace(" ", "").equals("admin")&& pass.replaceAll(" ", "").equals("1234")) {
	bPassChk=true;
} else {
	bPassChk=false;
	
}

//패스워드 체크가 끝나면, 세션을 기록하고 점프한다.
if (bPassChk) {
	session.setAttribute("login_ok", "yes");
	session.setAttribute("login_id", id);
	response.sendRedirect(jump); //로그인체크 이후 돌아갈 곳 admin_allview.jsp
} else {
	out.println("<h2>아이디 또는 패스워드 오류. </h2>");
	out.println("<input type=button value='로그인' onclick=\"location.href='admin_login.jsp?jump="+jump+"'\">");
}
%>
</body>
</html>