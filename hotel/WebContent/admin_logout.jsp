<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>TheFourSeaon-admin</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>

function hihi() {
	if(swal("요청 수행 완료", "3초 후 홈페이지로 이동합니다","success")) {
		 go();
	}
}
function go(){
	location.href="newindex.html";
}
</script>
</head>
<body>
	
<%
String loginOK = null;

String jumpURL = "admin_login.jsp?jump=admin_allview.jsp";

loginOK = (String) session.getAttribute("login_ok");
if (loginOK == null) {

	response.sendRedirect(jumpURL);
	return;
}

if (!loginOK.equals("yes")) {
	response.sendRedirect(jumpURL);
	return;
}

	request.setCharacterEncoding("UTF-8");
	session.invalidate();
	
	response.setHeader("cache-control","no-store, no-cache, must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 

	response.setHeader("expires","0");
	response.setHeader("pragma","no-cache");
	

%>
	<script>
		hihi();
	</script>
</body>
</html>