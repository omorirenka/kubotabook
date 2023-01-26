<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>検索画面</h1>
	<h3>検索する商品名を入力してください</h3>
	<form action="SearchServlet2" method="post">
	<h3>図書名：<input type="text" name="search"></h3><br>
	<input type="submit" value="検索"class="botan">
	</form>
</body>
</html>