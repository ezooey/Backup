<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap"%>
<%@ page import="java.util.HashSet" errorPage="error/errorPage.jsp"%>
<%--
	page 지시어 : 현재 JSP페이지에서 필요한 속성을 기술하는 부분, 보통 맨 위에 위치
		language		사용할 스크립트 언어 유형 지정
		contentType 	브라우저가 받아볼 페이지 인코딩 방식
		pageEncoding	JSP파일에 기록된 소스코드 자체의 인코딩 방식
		import			자바의 import와 동일, 여러 번 사용 가능하며 여러 개의 값을 import 가능
						(직접 적어서 import 해줘야 함, 한 줄에 적어도 되고 분리할 수도 있음)
		errorPage		현재 JSP페이지에서 오류가 발생할 경우 호출할 페이지 지정
		isErrorPage		오류를 처리할 페이지에 설정, false 기본 값, true로 지정하면 exception내장객체 사용 가능
--%>
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
		
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		HashSet<String> set = new HashSet<String>();
		
		list.add(0, null);
		System.out.println(list.get(0).charAt(0)); // null의 charAt을 구할 수 없어서 nullPointerException 발생
	%>
	
	expression 출력 : 1부터 10까지의 합은 <%= total %>입니다. 
	<!-- 세미콜론 붙이지 않음 -->
	<br>
	<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); %>입니다.
	<!-- 일반 코드이기 때문에 세미콜론 필요! -->
</body>
</html>