<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="6">
		<h${ i }>반복문</h${ i }>
	</c:forEach>
	
	<hr>
	
	<c:forEach var="i" begin="1" end="6" step="2">
		<h${ i }>반복문</h${ i }>
	</c:forEach>
	
	<hr>
	
	<c:forEach var="i" begin="1" end="6" varStatus="vs">
		<h${ 7 - i }>반복문</h${ 7 - i }>
		vs.first : ${ vs.first }<br>
		vs.last : ${ vs.last }<br>
		vs.index : ${ vs.index }<br>
		<!-- index는 0기반이지만 1부터 시작하게 했으니 1부터 시작하는 것처럼 보임 -->
		vs.count : ${ vs.count }<br>
		vs.current : ${ vs.current }<br>
	</c:forEach>
</body>
</html>