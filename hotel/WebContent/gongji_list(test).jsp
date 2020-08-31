<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="domain.Board,dao.BoardDAO,service.BoardService,java.sql.*,javax.sql.*,java.io.*, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 만들기</title>
<script>
function gomain() {
	window.location.href="gongji_list(test).jsp";
}
</script>
<style>

td {
	border: 1px solid red;
}
a {
	text-decoration:none;
}
table {
	margin: auto;
}
</style>
<%
	BoardService bs = new BoardService();


int pageSize = 10;
List<Board> newList = new ArrayList<Board>();
List<Board> secondList = new ArrayList<Board>();
request.setCharacterEncoding("UTF-8");

String pageNum = request.getParameter("pageNum");
if (pageNum == "" || pageNum == null) {
	pageNum = "1";
}



int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize;
int endRow = currentPage * pageSize - 1;

int count=0;
if (request.getParameter("category") != null && (request.getParameter("keyword") != null || request.getParameter("keyword") != "")) {
	if(request.getParameter("keyword").equals("")) {
		%> <script>alert("키워드를 입력하셔야죠"); gomain();</script> <%
		return;
	}
	String category = request.getParameter("category");
	String title= request.getParameter("title");
	String keyword= request.getParameter("keyword");
	List<Board> all = bs.selectKeyword(category, keyword);
	for (int i = 0; i < all.size(); i++) {
		all.get(i).setCategory(category);
		all.get(i).setKeyword(keyword);
		if (i >= startRow && i <= endRow) {
			newList.add(all.get(i));
		}					
	}
	
	
	if (request.getParameter("total") != "" && request.getParameter("total") !=null) {
		count = Integer.parseInt(request.getParameter("total"));
	}else {
		count=newList.size();
	}

} else {
	List<Board> all = bs.selectAll();
	for (int i = 0; i < count; i++) {
		if (i >= startRow && i <= endRow) {

			newList.add(all.get(i));
		}
	}
	count=all.size();
}
%>


</head>
<body>
	<h2 align="center">공지사항 게시판</h2>
	<table>

		<colgroup>
			<col width="50px">
			<col width="300px">
			<col width="100px">
			<col width="150px">
		</colgroup>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
			<%
			if (count==0) {
				%><tr><td colspan="4" align="center"> 찾으시는 결과가 없습니다</td></tr><%
			}else {
				out.println("여기는 몇?");
				out.println(count);
				out.println(newList.size());
				
				for (int i = 0; i < newList.size(); i++) {
					
						
					
			%>
		
		<tr>
			<td align="center"><%=newList.get(i).getNo()%></td>
			<%
				if (newList.get(i).getRelevel() > 0) {
				String a = "";
				for (int j = 0; j < newList.get(i).getRelevel(); j++) {
					a += "-";
				}
				a += ">";
			%>
			<td><a href="gongji_view.jsp?no=<%=newList.get(i).getNo()%>">[<%=a%>RE]<%=newList.get(i).getTitle()%><%=newList.get(i).getDate().equals("2020-07-16") ? "[new]" : ""%></a></td>
			<td><%=newList.get(i).getViewcnt()%></td>
			<td><%=newList.get(i).getDate()%></td>
			<%
				} else {
			%>
			<td><a href="gongji_view.jsp?no=<%=newList.get(i).getNo()%>"><%=newList.get(i).getTitle()%></a></td>
			<td><%=newList.get(i).getViewcnt()%></td>
			<td><%=newList.get(i).getDate()%></td>
		</tr>
		<%
			}
		}
			}
			
		%>
		<tr>
			<td align="right" colspan=4><a href="gongji_list(test).jsp"><input
					type="button" value="신규"></a></td>
	</table>
	<%
		if (count > 0) {
			out.println("카운트 보깅");
			out.println(count);
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int pageBlock = 10;
		int startPage = ((int) (currentPage / pageBlock) - (currentPage % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;

		if (endPage > pageCount) {
			endPage = pageCount;
		}
	%>
	<h4 align="center">
		<a href="gongji_list(test).jsp"> << </a>

		<%
			if (startPage > pageBlock) {
		%>
		<a href="gongji_list(test).jsp?pageNum=<%=startPage - pageBlock%>"> < </a>
		<%
			} else {
		%>
		<a href="gongji_list(test).jsp?pageNum=<%=startPage%>"> < </a>
		<%
			}
		for (int i = startPage; i <= endPage; i++) {
			int a= count;
			String b = "";
			
		%><a href="gongji_list(test).jsp?pageNum=<%=i%><%=newList.get(0).getCategory()==null ? "" : "&category="+newList.get(0).getCategory() %><%=newList.get(0).getKeyword()==null ? "" : "&keyword="+newList.get(0).getKeyword()%>&total=<%=a%>">[<%=i%>]
		</a>
		<%
			}
		if (endPage < pageCount) {
		%>
		<a href="gongji_list(test).jsp?pageNum=<%=startPage + pageBlock%>" > > </a>
		<%
			} else {
		%>
		<a href="gongji_list(test).jsp?pageNum=<%=endPage%>"> > </a>
		<%
			}
		%><a href="gongji_list(test).jsp?pageNum=<%=pageCount%>"> >> </a>
	</h4>
	<%
		}
	int b = count;
	%>
	<table>
		<form method="get" action="gongji_list(test).jsp">
			<tr>
				<td><select style="width: 100px; text-align: center;"
					name="category">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select></td>
				<td><input type="text" placeholder="입력" name="keyword"></td>
				<td><input type="submit" value="검색" "><input type="button" value="초기화면 돌아가기" onclick="gomain()"></td>
			</tr>
		</form>

	</table>
</body>
</html>