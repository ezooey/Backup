<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, action.model.vo.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str1 = "안녕";
		String str2 = new String("안녕");
		
		int big = 10;
		int small = 3;
		
		Person p1 = new Person("박신우", '여', 20);
		Person p2 = new Person("박신우", '여', 20);
		
		// page영역에 데이터 담기
		pageContext.setAttribute("str1", str1);
		pageContext.setAttribute("str2", str2);
		pageContext.setAttribute("big", big);
		pageContext.setAttribute("small", small);
		pageContext.setAttribute("p1", p1);
		pageContext.setAttribute("p2", p2);
		
		ArrayList<String> list = new ArrayList<>();
		list.add(str1);
		pageContext.setAttribute("list", list);
		
		ArrayList<String> list2 = new ArrayList<>();
		pageContext.setAttribute("list2", list2);
		
		ArrayList<String> list3 = null;
		pageContext.setAttribute("list3", list3);
		
	%>
	<h2>EL연산</h2>	
	<h3>산술연산</h3>
	10 * 7 = ${ 10 * 7 }<br>
	10 / 3 = ${ 10 / 3 } = ${ 10 div 3 }<br>
	15 % 4 = ${ 15 % 4 } = ${ 15 mod 4 }<br>
	
	<hr>
	
	<h3>비교연산</h3>
	<b>str1 == str2</b><br>
	스크립틀릿 str1 == str2 : <%= str1 == str2 %><br>
	<!-- str의 주소값을 비교했기 때문에 같은 "안녕"이 들어가 있어도 false로 나옴 -->
	<!-- 그 안의 값을 비교하려면 equals 써야 함 -->
	el str1 == str2 : ${ str1 == str2 } 또는 ${ str1 eq str2 }
	
	<br>
	
	<b>str1 != str2</b><br>
	스크립틀릿 str1 != str2 : <%= str1 != str2 %><br>
	el str1 != str2 : ${ str1 != str2 } 또는 ${ str1 ne str2 }<br>
	
	<br>
	
	<b>숫자형은 자동형변환 후 처리</b><br>
	big > small : ${ big > small } 또는 ${ big gt small }<br>
	big < small : ${ big < small } 또는 ${ big lt small }<br>
	big >= small : ${ big >= small } 또는 ${ big ge small }<br>
	big <= small : ${ big <= small } 또는 ${ big le small }<br>
	
	<br>
	
	<b>p1 == p2</b><br>
	스크립틀릿 p1 == p2 : <%= p1 == p2 %><br>
	el p1 == p2 : ${ p1 == p2 } 또는 ${ p1 eq p2 }<br>
	
	<br>
	
	<b>객체가 null 또는 비어있는지 체크하는 연산자</b><br>
	list가 비었나요? ${ empty list }<br>
	list2가 비었나요? ${ empty list2 }<br>
	list3이 비었나요? ${ empty list3 }<br>
	
	
	<hr>
	
	
	
</body>
</html>