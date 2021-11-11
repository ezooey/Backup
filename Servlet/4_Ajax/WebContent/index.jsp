<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<style>.test{border: 1px solid orange; height: 70px;}</style>
<title>Insert title here</title>
</head>
<body>
	<h1>jQuery를 이용한 Ajax 구현</h1>
	<h3>1. 버튼 선택 시 전송 값 서버에 출력</h3>
	이름 : <input type="text" id="myName">
	<button id="nameBtn">이름 전송</button>
	<script>
	$('#nameBtn').click(function(){
		var myName = $('#myName').val();
		
		$.ajax({
			url: 'jQueryAjax1.do',
			data: {name:myName}, // name이라는 변수에 myName을 집어넣겠다(parameter로 보내는 변수명이 name이 됨!)
			type: 'get',
			success: function(data){
				console.log('서버 전송 성공 시 호출되는 함수');
			}, error: function(data){
				console.log('서버 전송 실패 시 호출되는 함수');
			}, complete: function(data){
				console.log('서버 전송 성공/실패 여부와 상관 없이 무조건 호출되는 함수');
			}
		});
	});
	</script>
	
	<h3>2. 버튼 선택 시 서버에서 보낸 값 사용자가 수신</h3>
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').on('click', function(){
			$.ajax({
				url: 'jQueryAjax2.do',
				success: function(data){ // 저쪽에서 받아올 데이터만 있으므로 정의없이 바로 data이용
					console.log(data);
					$('#p1').text(data);
				}, 
				error: function(data){
					console.log(data);
				}
			});
			
		});
	</script>
	
	<h3>3. 서버로 기본형 전송 값이 있고 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫 번째 숫자 : <input type="text" id="firstNum"><br>
	두 번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		$('#plusBtn').click(function(){
			var firstNum = $('#firstNum').val();
			var secondNum = $('#secondNum').val();
			
			$.ajax({
				url: 'jQueryAjax3.do',
				data: {firstNum:firstNum, secondNum:secondNum},
				success: function(data){
					console.log(data);
					console.log(typeof data); // 숫자를 더한 값이지만 String 반환형으로 나옴
					$('#p2').text(data);
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>4. Object형태의 데이터를 서버에 전송, 서버에서 처리 후 서버 console로 출력</h3>
	학생 1 : <input type="text" id="student1"><br>
	학생 2 : <input type="text" id="student2"><br>
	학생 3 : <input type="text" id="student3"><br>
	<button id="studentTest">결과 확인</button>
	<script>
		// 학생 1, 2, 3의 이름을 받아와 ajax를 통해 jQueryAjax4.do로 넘기고
		// 해당 서블릿에서 콘솔에 학생들의 이름 출력
		$('#studentTest').click(function(){
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
			
			var students = {student1:student1, student2:student2, student3:student3};
			$.ajax({
				url: 'jQueryAjax4.do',
				data: students,
				success: function(data){
					console.log('통신성공');
				},
				error: function(data){
					console.log('통신실패');
				}
			});
		});
	</script>
	
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h3>
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="test" id="textarea3" rows="5" cols="40"></textarea>
	<script>
		$('#getUserInfoBtn').click(function(){
			$.ajax({
				url: 'jQueryAjax5.do',
				data: {userNo:$('#userNo').val()}, // 바로 넣어줘도 됨
				success: function(data){
					console.log(data);
					console.log(typeof data); // 객체를 받아와야 하는데 String으로 나옴 -> json 이용해야 함
					var result = '';
					if(data != null){
						resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
					} else {
						resultStr = '해당 회원이 없습니다.';
					}
					
					$('#p3').text(resultStr);
					$('#textarea3').val(resultStr); // 값을 쓰는 공간이기 때문에 val()로 넣어야 함
				},
				error: function(data){
					console.log(data);
				}
			});
		});
	</script>
</body>
</html>