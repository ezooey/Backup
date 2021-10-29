<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_directiveInclude</title>
</head>
<body>
	<h2>
		오늘 날짜 <span style="color: lightgray;"><%= today %></span><br>
		오늘 날짜 <span style="color: lightgray;"><%@ include file="today.jsp" %></span>
		<!-- Date와 today가 들어 있는 today.jsp를 삽입했기 때문에 변수가 중복됨  -->
	</h2>
</body>
</html>