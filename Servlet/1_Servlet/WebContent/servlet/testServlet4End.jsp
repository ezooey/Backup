<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// setAttribute로 설정했으니 가져와야 함
	// request.getAttribute(String name):Object
	// -> 매개변수 String name : 변수명
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String food = (String)request.getAttribute("food");
	String recommendation = (String)request.getAttribute("recommendation");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h2{color: red;}
	span{font-weight: bold;}
	#name{color: orange;}
	#gender{color: yellow; background: black;}
	#age{color: green;}
	#city{color: blue;}
	#height{color: navy;}
	#food{color: purple;}
</style>
<title>testServlet4End</title>
</head>
<body>
<h2>개인 취향 테스트 결과(POST)</h2>
		<span id='name'><%= name %></span>님은 
		<span id='age'><%= age %></span>이시며, 
		<span id='city'><%= city %></span>에 사는 
		키 <span id='height'><%= height%></span>cm인 
		<span id='gender'><%= gender %></span>입니다.
		좋아하는 음식은 <span id='food'><%= food %></span>입니다.
		
		<hr>
		
		<h3><%= age %>에 맞는 선물 추천</h3>
		'<%= recommendation %>' 선물은 어떠신가요?
</body>
</html>