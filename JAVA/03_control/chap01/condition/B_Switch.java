package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	// switch(조건식){
	// case 1: 실행문1; break; // 조건식의 결과 값이 1일 경우 실행
	// case 2: 실행문2; break; // 조건식의 결과 값이 2일 경우 실행
	// default: 실행문3;		 // 조건식의 결과 값이 case에 해당하지 않을 때 실행
	// }
	// 조건식의 결과 값을 case에서 찾아 명령을 수행하는 조건문
	// 해당하는 값이 case에 없을 경우 default의 명령문 수행
	// case와 수행문 사이에는 콜론(:)을 써주어야 함
	// break가 없으면 멈추지 않고 계속 실행
	public void method1() {
		// 정수 두 개와 연산 기호 문자 1개를 입력 받아 연산 기호 문자에 해당하는 계산을 수행 후 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int second = sc.nextInt();					// 이대로 쓰면 입력값의 \n까지 넘어와서 에러 발생
		System.out.print("연산자(+,-,*,/) : ");
//		char op = sc.nextLine().charAt(0);
		char op = sc.next().charAt(0);
		// 해결방법
		// 1. int를 받아올 때 String으로 받아 파싱하기
		// 2. nextLine()으로 줄바꿈 없애기
		// 3. nextLine() 대신 next()로 변경
		
		int result = 0; // 변수 선언 및 초기화
		switch(op) { // op로 case를 나누겠다
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			if(second == 0) {
				System.out.println("0으로는 나눌 수 없습니다. 결과가 정확하지 않습니다.");
			} else {
				result = first / second;
			}	
			break;
		default:
			System.out.println("예시에 없는 연산자입니다. 결과가 정확하지 않습니다.");
		}
		
		System.out.printf("%d %c %d = %d", first, op, second, result);
	}
	
	public void method2() {
		System.out.println("***** 신우네 과일 가게 *****");
		System.out.println("사과, 바나나, 복숭아, 키위 있습니다! 가격 편하게 물어보세요!");
		System.out.print("어떤 과일의 가격이 궁금하세요? : ");
		
		Scanner sc = new Scanner(System.in);
		String fruit = sc.nextLine();
		
		// 사과 1000 / 바나나 3000 / 복숭아 2000 / 키위 5000
		// 없는 과일일 경우, "그 과일은 신우네 과일 가게에 없습니다. 옆에 신우마트로 가보세요!" 문구 출력
		// 최종 출력 : (ex) 사과의 가격은 1000원입니다.
		
		int price = 0;
//		boolean flag = false;
		
		
		
//		if(fruit.equals("사과")) {						//스위치문 if문으로 바꾸기 가능!
//			price = 1000;
//		} else if(fruit.equals("바나나")) {
//			price = 3000;
//		} else if(fruit.equals("복숭아")) {
//				price = 2000;
//		} else if(fruit.equals("키위")) {
//				price = 5000;
//		} else {
//			System.out.println("그 과일은 신우네 없습니다.");
//			flag = true;
//		}
//		
		
		
		
		switch(fruit) {
		case "사과":
			price = 1000;
			break;
		case "바나나":
			price = 3000;
			break;
		case "복숭아":
			price = 2000;
			break;
		case "키위":
			price = 5000;
			break;
		default:
			System.out.println("그 과일은 신우네 과일 가게에 없습니다. 옆에 신우마트로 가보세요!");
//			flag = true;
		}
		
//		if(flag == false) {
//		혹은
//		if(!flag) {	
//		-> flag:false일 때 // 가격표시 O
//		-> flag:true일 때 // 가격표시 X		//이건 위의 boolean flag = true;로 두면 그냥 if(flag)로 둬도 문제x
		System.out.println(fruit + "의 가격은 " + price + "원 입니다." );
//		}
		
		// 없는 과일을 입력했을 때 가격이 안 나오게 하는 방법 -> 주석처리한 것들을 추가하면 됨
		
		
	}
	
	public void method3() {
		// 1부터 12까지 입력받아 해당하는 달의 마지막 날짜 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1부터 12까지 중 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
//		int date = 0;
//		switch(num) {
//		case 1:
//			date = 31;
//			break;
//		case 2:
//			date = 28;
//			break;
//		case 3:
//			date = 31;
//			break;
//		case 4:
//			date = 30;
//			break;
//		case 5:
//			date = 31;
//			break;
//		case 6:
//			date = 30;
//			break;
//		case 7:
//			date = 31;
//			break;
//		case 8:
//			date = 31;
//			break;
//		case 9:
//			date = 30;
//			break;
//		case 10:
//			date = 31;
//			break;
//		case 11:
//			date = 30;
//			break;
//		case 12:
//			date = 31;
//		}
		
		int date = 0;
		switch(num) {
		case 2:
			date = 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			date = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			date = 30;
			break;
		default:
			System.out.println("1~12 사이의 숫자가 아닙니다.");
		}
		
		System.out.println(num + "월의 마지막 날짜는 " + date + "일입니다.");
	}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		
		// 회원에 대한 메뉴
		System.out.println("1. 회원등록");
		System.out.println("2. 회원수정");
		System.out.println("3. 회원삭제");
		System.out.print("메뉴 번호를 입력하세요 : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("회원등록 메뉴입니다.");
			break;
		case 2:
			System.out.println("회원수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("회원삭제 메뉴입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 연산하기");
		System.out.println("2. 신우네 과일가게");
		System.out.println("3. 마지막 날짜");
		System.out.println("4. 메뉴 출력");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			method1();
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		case 4: 
			method3();
			break;
		default: System.out.println("잘못 입력하셨습니다.");
		}
		
	}

}
