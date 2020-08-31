<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DB에 입력하는 페이지</title>
<script>
function gomain() {
	window.location.href="gongji_list.jsp";
}
</script>
</head>
<body>
	<%
		String fileName= request.getParameter("filename");
		ServletContext context = getServletContext();
		String downloadPath = context.getRealPath("upload");
		String filePath = downloadPath + "\\" + fileName;
		File file = new File(filePath);
		
		String mimeType= getServletContext().getMimeType(filePath);
		if (mimeType ==null) {
			mimeType="application/.octet-stream";
		}
		response.setContentType(mimeType);
		String encoding = new String(fileName.getBytes("utf-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment; filename= " + encoding);
		
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream outStream = response.getOutputStream();
		
		byte[] b = new byte[4096];
		int data = 0;
		while ((data=in.read(b,0,b.length)) != -1) {
			outStream.write(b,0,data);
			
		}
		outStream.flush();
		outStream.close();
		in.close();
		%>
		
		<h1> down완료</h1>		
		
	

</body>
</html>