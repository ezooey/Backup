package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
//	while(조건식){
//		실행문장;
//		[증감식 or 분기문;]
//	}
//	조건식 확인 -> (조건식이 true일 때) 실행문장 수행 -> 조건식 확인 -> (반복)
//	조건식의 결과가 false가 될 때까지 반복

//	do{
//		실행문장;
//		[증감식 or 분기문;]
//	} while(조건식);
//	실행문장 -> 조건식 확인 -> (조건식이 true일 때) do의 실행문장 수행 -> 조건식 확인 -> (반복)
//	조건식의 결과가 false가 될 때까지 반복
	
//	while과 do~while의 차이점 : do~while은 무조건 한 번 이상 수행

	public void method1() {
		// 1부터 5까지 출력
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	public void method1_1() {
		// 자기 소개 다섯 번 하기 : 내 이름은 박신우야
		int i = 1;
		while(i <= 5) {
			System.out.println("내 이름은 박신우야");
			i++;
		}
		
	}
	
	public void method2() {
		// 5부터 1까지 출력
		int i = 5;
		while(i >= 1) {
			System.out.println(i);
			i--;
		}
	}
	
	public void method3() {
		// 문자열을 입력받아 인덱스 별로 문자 출력
		// java
		// 0 : j
		// 1 : a
		// 2 : v
		// 3 : a
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		// 문자열의 길이 : String 클래스의 length()
//		int length = str.length();
//		System.out.println(length);
		//apple
		
//		int i = 0;
//		while(i < length) {
//		while(i < str.length()) {
//			char ch = str.charAt(i);
//			System.out.println(i + " : " + ch);
//			i++;
//		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
				System.out.println(i + " : " + ch);
		}
	}
	
	public void method4() {
		int i = 2;
		while(i <= 9) {
			int j = 1;
			while(j < 10) {
				System.out.println(i + " * " + j + " = " + i*j);
				j++;
			}
			i++;
		}
		
//		return; // <- 생략돼있음. 나를 호출해준 메소드로 돌아가는 역할 (값을 안 가지고 돌아감)
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		while(menuNum != 9) {		//menuNum이 9가 아닐 때 트루로 해서 아래 실행해라
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menuNum = sc.nextInt();	//맨 앞에 int 를 넣으면 중복 선언이기 때문에 지워야 함 2시 51분
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void method5_1() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		do {		// do 안의 내용은 일단 한 번은 무조건 실행
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menuNum = sc.nextInt();				// 중복선언 고침
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break;		//종료 설정을 넣었기 때문에 return 불요
			default: System.out.println("잘못 입력하셨습니다.");
			}
		} while(menuNum != 9);		// do 안에 선언된 menuNum의 범위를 벗어나기 때문에 빨간줄 뜸
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {	// 무조건 트루로 만드는 방법(무한반복문)
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int menuNum = sc.nextInt();	
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break; // break; 대신 return; 넣어도 무방, 강제종료됨
			default: System.out.println("잘못 입력하셨습니다.");// 무한반복문으로 만들었기 때문에 return을 넣어야 종료
			}
		}
	}
	
	public void method6_1() {
		// method6을 do~while 버전으로
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int menuNum = sc.nextInt();	
		
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); return; 
			default: System.out.println("잘못 입력하셨습니다.");
			}
		} while(true);
	}
	
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		
		int i = 1;
		while(i <= row) {
			int j = 1;
			while(j <= 5) {
				System.out.println("*");
				j++;						// 증감식 없으면 영원히 5가 안 돼서 무한반복
			}
			System.out.println();
			i++;
		}
		
	}
//		do {
//			System.out.print("*");
//			i++;
//		} while(i <= row);
//	}
	
	public void method8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int row = sc.nextInt();
		System.out.print("칸 수 : ");
		int col = sc.nextInt();
		
		int i = 1;
		while(i <= row) {
			int j = 1;
			while(j <= col) {
				if( i == j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public void method9() {
		// 키보드로 문자열 값을 입력 받아 출력 반복 실행
		// exit가 들어가면 반복 종료 -> exit가 아니면 계속 진행
		// 끝나는 지점이 언제인지 모르니까 while문이 적합
		
		Scanner sc = new Scanner(System.in);
		
//		String str = null;		// String의 기본값
		// null ? 아무것도 없음(= 진공 상태)
		String str = "";		// 아무 값이나 준 것임. null과는 다르다!
		while(!str.equals("exit")) {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		}
	}
	
	public void method10() {
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		do {									// do를 먼저 실행한 후 조건문을 보기 때문에 위의 경우와 달리 문제없음
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		} while(!str.equals("exit"));
	}
}
