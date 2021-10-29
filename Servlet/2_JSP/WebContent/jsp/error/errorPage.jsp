<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage</title>
</head>
<body>
	<h1 style="color:red;">에러 페이지입니다.</h1>
	<%= exception %> <!-- isErrorPage="true" 있어야만 빨간줄 사라짐 -->
	<%= exception.getMessage() %>
	<%= exception.getClass().getName() %>
	
</body>
</html>