<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本貸出</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("fail") != null){	
	%>
		<h3>本を借りれませんでした！</h3>
	<%
		}else{
	%>
		<h3>本を借りました！</h3>
	<%
		}
	%>
	<a href="AllBookServlet">戻る</a>
</body>
</html>