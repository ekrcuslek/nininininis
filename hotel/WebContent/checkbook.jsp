<meta http-equiv="content-Type" content="text/html; charset=UTF-8">

<%@ page contentType="text/html; charset=utf-8"
	import="hotel.domain.Booking, hotel.dao.bookDAO, hotel.service.BookService, java.sql.*,javax.sql.*,java.io.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String date = request.getParameter("date");
String room = request.getParameter("room");
BookService bs = new BookService();
out.println(date +"임둥");
out.println(room +"임두요");
Booking bk = bs.OneBook(date, room);

%>
<div style="text-align:center;">
	<table>
		<colgroup>
		<col width="100px">
		<col width="500px">
		</colgroup>
		<form action="bookmodify.jsp" method="post">
			<tr>
				<td>성명</td>
				<td><%=bk.getName() %></td>
			</tr>
			<tr>
				<td>예약일자</td>

				<td><%=bk.getDate() %></td>
			</tr>
			<tr>
				<td>예약방</td>

				<td>
				<%=bk.getRoom() %>
				</td>
			</tr>
			<tr>
				<td>주소</td>

				<td><%=bk.getAddr() %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=bk.getTelnum() %></td>
			</tr>
			<tr>
				<td>입금자명</td>
				<td><%=bk.getIn_name() %></td>
			</tr>
			<tr>
				<td>남기실말</td>
				<td><%=bk.getComment() %></td>
			</tr>
			<tr>
				<td>예약 진행 상황</td>
				<td><%=bk.getComment() %></td>
			</tr>
			<tr>
				<td><input type="button" onclick="here.location.href='index.html'" value="홈페이지 이동" ></td><button type="submit">수정</button></td>
			</tr>
		</form>
	</table>

</body>
</html>