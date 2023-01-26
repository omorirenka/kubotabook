<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="dto.Book" %>
	<%@ page import="dao.BookDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧</title>
</head>
<body>
	<table>
	<tr>
		<th style="width: 60%;">図書名</th>
		<th style="width: 20%">作者</th>
		<th style="width: 10%">出版社</th>
		<th style="width: 10%"></th>

	</tr>
	
	<%
	request.setCharacterEncoding("UTF-8");
	List<Book> list = BookDAO.selectAllBook();
	for(Book b:list) {
	%>
	<tr>
		<td><%= b.getBookname()%></td>
		<td><%= b.getName()%></td>
		<td><%= b.getSyuppan()%></td>
		<%
		if(b.getKasikari().equals("貸出中")){
		%>
		<td><%= b.getKasikari()%></td>
		<%
		}else{
		%>
		<td><a href=BorrowServlet?id=<%= b.getId() %> class="m_button">借りる</a></td>
		<%} %>
	</tr>
	<%} %>
	</table>
	<a href="#">戻る</a>
</body>
</html>