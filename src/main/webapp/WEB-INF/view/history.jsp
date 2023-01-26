<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.History" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出履歴の表示</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");
			%>
<table border="1">
<tr>
	<th>id</th>
	<th>図書名</th>
	<th>著者</th>
	<th>出版社</th>
	</tr>
	<%
	List<History> history=(ArrayList<History>)request.getAttribute("detail");
	for(History h :history){	
	%>
	<tr>
		<td><%=h.getId() %></td>
		<td><%=h.getAc_id() %></td>
		<td><%=h.getBook_id() %></td>
		</tr>
	<%} %>
</table>
<a href="./">戻る</a>
</body>
</html>