<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String topping = (String)request.getAttribute("topping");
	String side = (String)request.getAttribute("side");
	int total = (int)request.getAttribute("total");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_pizzaEnd</title>
<style>
	#pizza{color: red;}
	#topping{color: green;}
	#side{color: blue;}
	#total{text-decoration: underline;}
</style>
</head>
<body>
	<h2>주문 내역</h2>
	<h3>
		피자는 <span id="pizza"><%= pizza %></span>, 
		토핑은 <span id="topping"><%= topping %></span>,
		
<!-- 		만약 topping을 배열로 가져왔으면 아래처럼 해줌. 출력문을 쓰기 위해 스크립틀릿을 나눠야 함.  -->
<%-- 		<% --%>
<!--  			for(int i = 0; i < topping.length; i++){ -->
<!--  				if(i == 0){ -->
<%-- 		%> --%>
<%-- 					<%= topping[i] %> --%>
<%-- 		<%  --%>
<!--  				} else { -->
<%-- 		%> --%>
<%-- 					, <%= topping[i] %> --%>
<%-- 		<% --%>
<!--  				} -->
<%-- 		%> --%>
			
		사이드는 <span id="side"><%= side %></span> 주문하셨습니다.
		
		<br><br><br><br>
		총합 : <span id="total"><%= total %>원</span>
	</h3>
	<br>
	<h2 style="color: pink;">즐거운 식사시간 되세요 ~</h2>
</body>
</html>