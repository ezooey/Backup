<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자 데이터 포맷 지정 : formatNumber</h3>
	천 단위 구분 : <fmt:formatNumber value="123456789"/><br> <!-- 자동으로 구분자 추가됨. true가 디폴트-->
	숫자 그대로 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	
	<br>
	
	<b>실수값 소수점 아래 자리수 지정 : pattern(#, 0)</b><br>
	<fmt:formatNumber value="1.234567"/><br> <!-- 마지막 수는 반올림됨 -->
	<fmt:formatNumber value="1.234567" pattern="#.##"/><br>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br><!-- 1.2 -->
	<fmt:formatNumber value="1.2" pattern="#.00"/><br><!-- 1.20// 없는 자리까지 0으로 채워줌 -->
	
	<h3>백분율, 통화기호 표시 : type</h3>
	<fmt:formatNumber value="0.12" type="percent"/><br>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/>
	
	<h3>지역대 설정 : setLocale</h3>
	<fmt:setLocale value="ko_kr"/>
	<fmt:formatNumber value="123456789" type="currency"/><br>
</body>
</html>