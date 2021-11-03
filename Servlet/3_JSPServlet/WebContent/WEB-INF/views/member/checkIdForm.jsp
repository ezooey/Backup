<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	
	<%
	Integer result = (Integer)request.getAttribute("result");
	if(result != null){
		if(result > 0){
	%>
			이미 사용 중인 아이디 입니다.
	<%	} else { %>
			사용 가능한 아이디입니다.
	<%	} %>
	<%} %>
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
			if(<%= result %> == null){ 
			/* if로 나눠주지 않으면 중복확인 버튼을 누를 때마다 새로 페이지가 로딩되면서 계속 부모 페이지애 적은 아이디값으로 덮어씌워짐 */
				document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
			/* 
			signUpForm.jsp의 joinForm과 joinUserId임
			opener는 나를 열어줌
			*/
			} else {
				document.getElementById('inputId').value = '<%= request.getAttribute("checkedId") %>';
				/* CheckIdServlet에서 가져온 checkedId */
			}
		}
		
		document.getElementById('usedId').onclick = function(){
			opener.document.joinForm.joinUserId.value = document.getElementById('inputId').value;
			/* 이걸 누를 때는 이미 inputId에 값이 들어가 있어서 이렇게 써도 됨 */
			self.close();
		}
	</script>
</body>
</html>