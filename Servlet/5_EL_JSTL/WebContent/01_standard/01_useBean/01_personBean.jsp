<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP표준액션 태그 중 useBean을 사용하여 VO클래스의 객체 정보 불러오기</h2>
<%-- 	<jsp:useBean id="person1" class="action.model.vo.Person"></jsp:useBean> --%>
	<jsp:useBean id="person1" class="action.model.vo.Person" scope="request"/>
	<!-- 해당 스코프(request)에서 속성 값이 해당 클래스 타입으로 person1이 존재하면 그 객체를 가져오고 없으면 새로 생성(scope를 지정하지 않으면 page) -->
	
	이름 : <jsp:getProperty property="name" name="person1"/><br>
	성별 : <jsp:getProperty property="gender" name="person1"/><br>
	나이 : <jsp:getProperty property="nai" name="person1"/><br>
	<!-- getProperty는 getter의 역할을 하므로 getAge의 age와 일치해서 값을 가져오는 게 가능함 -->
	
	<hr>
	
	<h2>JSP표준액션 태그 중 useBean을 사용하여 VO클래스에 데이터 초기화하기</h2>
	<jsp:useBean id="person2" class="action.model.vo.Person" scope="request"></jsp:useBean>
	
	<jsp:setProperty property="name" name="person2" value="강건강"/>
	<jsp:setProperty property="gender" name="person2" value="남"/>
	<jsp:setProperty property="nai" name="person2" value="20"/>
	
	
	이름 : <jsp:getProperty property="name" name="person2"/><br>
	성별 : <jsp:getProperty property="gender" name="person2"/><br>
	나이 : <jsp:getProperty property="nai" name="person2"/><br>
	
	
</body>
</html>