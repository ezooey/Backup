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
	<c:if test="${ param.num1 > param.num2 }">
		${ param.num1 } 숫자는, ${ param.num2 }보다 크다
	</c:if>
	<c:if test="${ param.num1 < param.num2 }">
		${ param.num2 } 숫자는, ${ param.num1 }보다 크다
	</c:if>
	<c:if test="${ param.num1 == param.num2 }">
		${ param.num2 } 숫자는 ${ param.num1 } 숫자와 같다
	</c:if>
	<!-- 문자형 비교가 되므로 제대로 비교 불가능. 7이 20보다 크다고 나오게 됨 문자열로 비교해서 앞자리인 2보다 7이 크기 때문 -->
	
	<hr>
	
	<!-- 형변환 해줘야 숫자로 비교가 가능! -->
	<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
		${ param.num1 } 숫자는, ${ param.num2 }보다 크다
	</c:if>
	<c:if test="${ Integer.parseInt(param.num1) < Integer.parseInt(param.num2) }">
		${ param.num2 } 숫자는, ${ param.num1 }보다 크다
	</c:if>
	<c:if test="${ param.num1 == param.num2 }">
		${ param.num2 } 숫자는 ${ param.num1 } 숫자와 같다
	</c:if>
	
</body>
</html>