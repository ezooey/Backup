<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP표준액션태그 중 useBean의 param속성 이용하기</h2>
	<!-- person이라는 이름의 Person객체 생성 -->
	<jsp:useBean id="person" class="action.model.vo.Person" scope="request">
<%-- 		<jsp:setProperty property="name" name="person" param="name"/>  --%>
		<!-- param="name"은 인풋 타입의 name="name"을 뜻함 -->
<%-- 		<jsp:setProperty property="gender" name="person" param="gender"/> --%>
<%-- 		<jsp:setProperty property="nai" name="person" param="nai"/> <!-- input태그에서 nai로 썼으니 여기도 nai로 적는다 --> --%>

<%-- 		<jsp:setProperty property="name" name="person"/>  --%>
<%-- 		<jsp:setProperty property="gender" name="person"/> --%>
<%-- 		<jsp:setProperty property="nai" name="person"/> <!-- param을 지워도 프로퍼티랑 같은 이름으로 자동 설정됨 --> --%>

		<jsp:setProperty property="*" name="person"/> <!-- 아스트로 써서 한 줄로 써도 됨 -->
	</jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="person"/><br>
	성별 : <jsp:getProperty property="gender" name="person"/><br>
	나이 : <jsp:getProperty property="nai" name="person"/><br>
</body>
</html>