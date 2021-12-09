<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person"%>
<%
	Person p = (Person)request.getAttribute("person");
	String beverage = (String)request.getAttribute("beverage");
	String[] products = (String[])request.getAttribute("products");
	String book = (String)session.getAttribute("book");
	String movie = (String)application.getAttribute("movie");
	// session이랑 application에 받지 않고 request로 받아오면 null로 뜸
	// application->session->request순이지만 request 안에는 아무것도 안 담았기 때문에!
	int year = (int)request.getAttribute("year");
%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptlet을 통해 request객체에 저장된 데이터 출력하기</h2>
	<h4>개인정보(<%= year %>)</h4>
	이름 : <%= p.getName() %><br>
	성별 : <%= p.getGender() %><br>
	나이 : <%= p.getNai() %><br>
	<h4>취향정보</h4>
	<%= p.getName() %>님이 가장 좋아하는 음료 : <%= beverage %><br>
	<%= p.getName() %>님이 가장 좋아하는 물건 : <%= products[0] %>, <%= products[1] %>, <%= products[2] %><br>
	<%= p.getName() %>님이 가장 좋아하는 도서 : <%= book %><br>
	<%= p.getName() %>님이 가장 좋아하는 영화 : <%= movie %><br>
	<!-- book과 movie는 각각 session, application영역에 존재하는데 request영역에서 값을 가져오려고 하면 null출력 -->
	
	<hr>
	
	<h2>el의 내장객체 XXXScope를 통해 저장된 데이터 출력하기</h2>
	<h4>개인정보(${ requestScope.year })</h4>
	이름 : ${ requestScope.person.name }<br>
	성별 : ${ requestScope.person.gender }<br>
	나이 : ${ requestScope.person.nai }<br>
	<h4>취향정보</h4>
	${ requestScope.person.name }님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br>
	${ requestScope.person.name }님이 가장 좋아하는 물건 : ${ requestScope.products[0] }, ${ requestScope.products[1] }, ${ requestScope.products[2] }<br>
	${ requestScope.person.name }님이 가장 좋아하는 도서 : ${ sessionScope.book }<br>
	${ requestScope.person.name }님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	${ requestScope.person.name }님이 가장 좋아하는 도서 : ${ requestScope.book }<br>
	${ requestScope.person.name }님이 가장 좋아하는 영화 : ${ requestScope.movie }<br>
	<!-- session, application이 아니라 request영역에서 값을 가져오려고 해도 null이 뜨지 않고 공백이 나옴 -->
	
	<hr>
	
	<h2>scope 생략하여 저장된 데이터 출력하기</h2>
	<p>
		el내장객체 pageScope, requestScope, sessionScope, applicationScope 생략 가능<br>
		el은 pageScope -> requestScope -> sessionScope, applicationScope순으로 찾음
		여러 scope에 동일한 속성을 기록해서 이름 충돌이 의심되면 명시적으로 scope를 지정해야 해당 scope의 속성을 가져올 수 있음
	</p>
	<h4>개인정보(${ year })</h4>
	이름 : ${ person.name }<br>
	성별 : ${ person.gender }<br>
	나이 : ${ person.nai }<br>
	<h4>취향정보</h4>
	${ person.name }님이 가장 좋아하는 음료 : ${ beverage }<br>
	<!-- sessionScope, applicationScope 지정해주면 아메리카노와 물이 나온다 -->
	<!-- 지정 안 하면 이미 request로 찾아왔기 때문에 입력한 음료값만 나옴 -->
	${ person.name }님이 가장 좋아하는 물건 : ${ products[0] }, ${ products[1] }, ${ products[2] }<br>
	${ person.name }님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name }님이 가장 좋아하는 영화 : ${ movie }<br>
	${ person.name }님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name }님이 가장 좋아하는 영화 : ${ movie }<br>
	
	 
</body>
</html>