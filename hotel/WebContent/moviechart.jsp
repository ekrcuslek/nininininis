<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="org.jsoup.Jsoup,org.jsoup.nodes.Document,org.jsoup.nodes.Element, org.jsoup.select.Elements"%>
    <link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%
	
Document doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
Elements el = doc.body().getElementsByClass("tit");
Elements el2 = doc.body().getElementsByClass("info_star");
Elements el3 = doc.body().getElementsByClass("star_t1 b_star");

Elements file = el.select("a");
Elements file2 = el2.select(".star_t1 .num");
Elements file3 = el3.select(".num");
int count = 0;
%><table class="table table-hover">
	<tr><td style="background-color:gray">순위</td><td style="background-color:gray">영화타이틀</td><td style="background-color:gray">평점</td><td style="background-color:gray">예매율</td></tr>
  <%
for (int i = 0; i < 10; i++) {

	out.println("<tr><td>"+"No"+(i+1)+"</td><td><a href='https://www.google.com/search?q=%EB%8B%A4%EB%A7%8C%EC%95%85%EC%97%90%EC%84%9C%EA%B5%AC%ED%95%98%EC%86%8C%EC%84%9C" + file.get(i).text()+"' target='_blank'>"+file.get(i).text()+"</a>"+"</td><td>"+file2.get(i).text()+"</td><td>"+file3.get(i).text()+"%"+"</td><tr>");

}
%>
	<a href='https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query='></a>
</table>
</body>
</html>