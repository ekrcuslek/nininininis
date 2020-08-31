<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
a:link {
   font-family: "";
   font-size: 14pt;
   text-decoration: none;
   color: darkblue
}

a:visited {
   font-family: "";
   font-size: 14pt;
   text-decoration: none;
   color: darkblue
}

a:hover {
   font-family: "";
   font-size: 14pt;
   text-decoration: :none;
   color: crimson
}

#day {
   color: white;
   font-size: 20px;
   width: 100;
   
}

tr {
   height: 100px;
}

td{

}
</style>
<%
   int year;
int month;
Calendar today = Calendar.getInstance();
Calendar cal = new GregorianCalendar();
year = (request.getParameter("year") == null) ? today.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("year").trim());

month = (request.getParameter("month") == null) ? today.get(Calendar.MONTH) + 1 : Integer.parseInt(request.getParameter("month").trim());

if (month <= 0) {

   month = 12;
   year = year - 1;
} else if (month >= 13) {

   month = 1;
   year = year + 1;
}
cal.set(Calendar.YEAR, year);
cal.set(Calendar.MONTH, (month - 1));
cal.set(Calendar.DATE, 1);
%>
</head>
<body >
   <h2 align=center>오픈 예정</h2>


   <table align="center" border=0>
      <colgroup>
         <col width=100>
         <col width=100>
         <col width=100>
         <col width=100>
         <col width=100>
         <col width=100>
         <col width=100>
      </colgroup>
      <tr height=50>
         <td align="center" height='20' valign='center' colspan="7"><a
            href='book_list.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH) + 1) - 1)%>'> <font color='d4a162' style="font-size: 30px">◀
            </font></a> <font color='d4a162' style="font-size: 40px"><%=cal.get(Calendar.YEAR)%> / <%=(cal.get(Calendar.MONTH) + 1)%></font> <a
            href='book_list.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH) + 1) + 1)%>'> <font color='d4a162' style="font-size: 30px">▶
            </font></a></td>
      </tr>
      <tr align="center" bgcolor="d4a162">
         <td bgcolor=lightcoral id="day">SUN</td>
         <td id="day">MON</td>
         <td id="day">TUE</td>
         <td id="day">WED</td>
         <td id="day">THU</td>
         <td id="day">FRI</td>
         <td bgcolor=lightskyblue id="day">SAT</td>
      </tr>

      <%
         cal.set(year, month - 1, 1);
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
      %>
      <tr align="right" valign="top" bgcolor="e3e3e3">
         <%
            for (int i = 1; i < dayOfWeek; i++) {
         %><td align="right" valign="top" ></td>
         <%
            }

         for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
         if ((dayOfWeek - 1 + i) % 7 == 0) {
         %>
         <td bgcolor=powderblue><a href='day.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH) + 1))%>&day=<%=i%>'><%=i%></a>토욜</td>
         <%
            } else if ((dayOfWeek - 1 + i) % 7 == 1) {
         %>
         <td bgcolor=lightsalmon><a href='day.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH) + 1))%>&day=<%=i%>'><%=i%></a>일욜</td>
         <%
            } else {
         %>
         <td><a href='day.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH) + 1))%>&day=<%=i%>'><%=i%></a>평일?</td>
         <%
            }
         if ((dayOfWeek - 1 + i) % 7 == 0) {
         %>
      </tr>
      <tr align="right" valign="top" bgcolor="e3e3e3">
         <%
            }
         }
         %>

      </tr>
   </table>

</body>
</html>