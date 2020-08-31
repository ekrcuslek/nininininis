<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html; charset=utf-8"
	import="dao.File1DAO,domain.File1,domain.Board, dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 만들기</title>
<style>
td {
	border: 1px solid red;
}

table {
	margin: auto;
}
</style>

<%
	BoardService bs = new BoardService();
Board bd = new Board();
File1DAO fd = new File1DAO();
List<File1> fList = fd.fileAll();
List<File1> newfList= new ArrayList<>();

request.setCharacterEncoding("UTF-8");
if (request.getParameter("nodl") != null) {
	bd.setRootid(Integer.parseInt(request.getParameter("nodl"))); //원글 삭제시 댓글도 같이 삭제 하기 위함
	bs.delete(bd);
	for (int i=0; i< fList.size(); i++) {
		if (bd.getNo()==fList.get(i).getId()) {
			String uploadpath = request.getRealPath("upload");
			File f = new File(uploadpath,fList.get(i).getFilename1()); // 해당 루트에 있는 파일 객체를 생성
			if (f.exists()) { // 파일이 존재하면 아래 코드 수행
				fd.deleteFile(bd.getNo(), fList.get(i).getFilename1());
				f.delete();			
			}
		}
	}
	
} else {
	bd.setNo(Integer.parseInt(request.getParameter("noup")));
	
	bs.delete(bd);
	for (int i=0; i< fList.size(); i++) {
		if (bd.getNo()==fList.get(i).getId()) {
			String uploadpath = request.getRealPath("upload");
			File f = new File(uploadpath,fList.get(i).getFilename1()); // 해당 루트에 있는 파일 객체를 생성
			if (f.exists()) { // 파일이 존재하면 아래 코드 수행
				fd.deleteFile(bd.getNo(), fList.get(i).getFilename1());
				f.delete();			
			}
		}
	}
}
//bd.setTitle(request.getParameter("titleup"));
//bd.setText(request.getParameter("textup"));
%>
</head>
<body>
	<h2 align="center">삭제 완료</h2>
	<p style="text-align: center">
		<input type="button" onclick="location.href='gongji_list.jsp'"
			value="첫 화면으로 이동">
	</p>



</body>