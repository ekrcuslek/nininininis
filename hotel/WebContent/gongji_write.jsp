<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="dao.File1DAO,domain.File1,domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.Enumeration,java.io.File" %>

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
	String count="";
	String fileLength="";
	String originName="";
	String fileName="";
	File file= null;
	request.setCharacterEncoding("UTF-8");
	String uploadPath = request.getRealPath("upload");
	File h = new File(uploadPath);
	if(!(h.exists())) {
		h.mkdirs();
	}
	int maxFileSize= 1024 * 1024 *5;
	// 멀티파트리퀘스트 객체를 생성, 인자로는 request, 파일업로드 주소, 파일 최대크기, 인코딩, 파일이 중복될 경우 인덱스를 붙여주는 객체 가 있다
	MultipartRequest multi = new MultipartRequest(request,uploadPath,maxFileSize,"utf-8",new DefaultFileRenamePolicy());
		File1DAO fd = new File1DAO();
		File1 ff = new File1();
		
		BoardService bs = new BoardService();
		Board bd = new Board();
		// 수정페이지에서 오는 파라미터를 받는 곳
		if (multi.getParameter("noup") != null && multi.getParameter("titleup") != null
		&& multi.getParameter("textup") != null) {
			if(multi.getParameter("titleup").contains("<!--")) {
				%> <script>alert("수작부리지 마세요~"); gomain();</script> <%
				return;
			}
			if(multi.getParameter("titleup").length() > 50 ) {
				%> <script>alert("제목 최대 50"); gomain();</script> <%
				return;
			}
			if(multi.getParameter("textup").length() > 60000 ) {
				%> <script>alert("내용 최대 60000"); gomain();</script> <%
				return;
			}
			bd.setNo(Integer.parseInt(multi.getParameter("noup")));
			bd.setTitle(multi.getParameter("titleup"));
			bd.setText(multi.getParameter("textup"));
			
				
				Enumeration efiles =multi.getFileNames();
				while(efiles.hasMoreElements()) {
					String filed=(String)efiles.nextElement();
					originName=multi.getOriginalFileName(filed);
					fileName=multi.getFilesystemName(filed);
					file = multi.getFile(filed);
					
					if (fileName == null || originName == null) {
						continue;
					}
					ff.setId(bd.getNo());
					ff.setFilename1(fileName);
					ff.setFilename2(originName);
					out.println(ff.getId() +" "+ff.getFilename1() + " "+ff.getFilename2());
					fd.newFile(ff);
					
				
				
			}
			
			bs.update(bd, Integer.parseInt(multi.getParameter("noup")));
			
			
		}
		// 댓글페이지에서 오는 파라미터를 받는 곳
		if (multi.getParameter("rootid") != null && multi.getParameter("relevel") != null) {
			if(multi.getParameter("titleRe").contains("<!--")) {
				out.println("수작부리지 마셔요. 돌아가세요");
				%><input type="button" onclick="location.href='gongji_list.jsp'" value="리스트로 돌아가기"> <%
				return;
			}
			if(multi.getParameter("titleRe").length()>50) {
				out.println("제목 최대 글자 50임다");
				%><input type="button" onclick="location.href='gongji_list.jsp'" value="리스트로 돌아가기"> <%
				return;
			}
			if(multi.getParameter("textRe").length()>=60000) {
				out.println("내용 최대 글자 60000임다");
				%><input type="button" onclick="location.href='gongji_list.jsp'" value="리스트로 돌아가기"> <%
				return;
			}
			bd.setRootid(Integer.parseInt(multi.getParameter("rootid")));
			bd.setRelevel(Integer.parseInt(multi.getParameter("relevel")));
			bd.setTitle(multi.getParameter("titleRe"));
			bd.setText(multi.getParameter("textRe"));
			bd.setRecnt(Integer.parseInt(multi.getParameter("recnt")));
			
			bd.setFilename(multi.getFilesystemName("file"));
			bd.setOriginname(multi.getOriginalFileName("file"));
			
			bs.insertreply(bd);
	
		}
		
		
		// 신규 게시물 쓰기에서 받는 파라미터
		if (multi.getParameter("title") != null && multi.getParameter("text") != null) {
			out.println("<h1>이요</h1>");
			if(multi.getParameter("title").contains("<!--")) {
				
				%> <script>alert("수작부리지 마세요~"); gomain();</script> <%
				return;
			}
			if (multi.getParameter("title")=="") {
				
				%><script>alert("최소 제목은 넣어주셔야쥬"); gomain();</script> <%
				return;
			}
			bd.setTitle(multi.getParameter("title"));
			bd.setText(multi.getParameter("text"));
			bd.setRelevel(0);
			bs.insertNewData(bd);
			
			bd.setRootid(bs.selectLastNum());
			
			bs.updateRootid(bd);
			
			
			Enumeration efiles =multi.getFileNames();
			while(efiles.hasMoreElements()) {
				String filed=(String)efiles.nextElement();
				originName=multi.getOriginalFileName(filed);
				fileName=multi.getFilesystemName(filed);
				file = multi.getFile(filed);
				
				if (fileName == null || originName == null) {
					continue;
				}
				ff.setId(bd.getRootid());
				ff.setFilename1(fileName);
				ff.setFilename2(originName);
				out.println(ff.getId() +" "+ff.getFilename1() + " "+ff.getFilename2());
				fd.newFile(ff);
				
			}
			
			//bd.setFilename(multi.getFilesystemName("file"));
			//bd.setOriginname(multi.getOriginalFileName("file"));
			
			
			
			
		}
		
		
	%>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>

function go(){
	location.href="gongji_list.jsp";
}
</script>
<script>
go();
</script>	
</body>