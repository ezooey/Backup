<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_sum</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 : 클라이언트에게 전달이 되지 않는 주석 --%>
	
	<%
		// 스크립트릿에서는 자바코드 사용 가능
		int total = 0;
	
		for(int i = 1; i <= 10; i++){
			total += i;
		// 두 가지 방법
		// 1. out.print() 이용
// 			out.println("안녕<br>");
		
		// 2. 중간에 끊어서 사용
	%>
			반가워<br>
	<%
		}
		System.out.println("또 보자"); // 콘솔에 바로 찍는 것(printWriter 아님, 구분해야!)
	%>
	
	expression 출력 : 1부터 10까지의 합은 <%= total %>입니다. 
	<!-- 세미콜론 붙이지 않음 -->
	<br>
	<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); %>입니다.
	<!-- 일반 코드이기 때문에 세미콜론 필요! -->
</body>
</html>