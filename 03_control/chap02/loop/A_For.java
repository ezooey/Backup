package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
//	for(초기식; 조건식; 증감식){
//		실행문장;
//	}
//	초기식 -> 조건식 확인 -> (조건식이 true일 때) 실행문장 수행 -> 증감식 -> 조건식 확인 -> (반복)
//	조건식의 결과가 false가 될 때까지 반복
//	
//	for문 안에 있는 초기식, 조건식, 증감식 생략 가능
//	초기식은 무엇인지, 조건은 무엇인지, 증감은 얼마나 되는지 다 표기 해야 함
//	결국 for문의 소괄호() 안에서만 생략될 뿐, 모두 필요한 요소임
	public void method1() {
		// 1부터 5까지 출력
		for(int i = 1; i <= 5;) {
			System.out.println(i);
			i++;					// 이 줄 없으면 증감식이 없어서 1만 무한반복됨
		}
	}
	
	public void method1_1() {
		// 자기 소개 다섯 번 하기 : 내 이름은 박신우야
//		for(int i = 1; i <= 5; i++) { // 1 2 3 4 5 
//		for(int i = 2; i <= 6; i++) { // 2 3 4 5 6 다섯 번인 건 똑같음
//		for(int i = 0; i <= 4; i++) { // 0 1 2 3 4 다섯 번인 건 똑같음
		for(int i = 0; i < 5; i++) { // 0 1 2 3 4 다섯 번인 건 똑같음
			System.out.println("내 이름은 박신우야");
		}
	}
	
	public void method2() {
		// 5부터 1까지 출력
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	public void method2_1() {
		// 8부터 3까지 출력
//		for(int i = 8; i >= 3; i--) {
//			System.out.println(i);
//		}
		for(int i = 0; i < 6; i++) {
			System.out.println(8 - i);
		}
	}

	public void method3() {
		// 1부터 10 사이의 숫자 중 홀수만 출력 : 1 3 5 7 9
		// for문만 이용
		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		// for문 + if문
//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 != 0) {
//				System.out.println(i);
//			}
//		}
	}
	
	public void method4() {
		// 정수 두 개를 입력 받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();
		
//		for(int i = start; i <= end; i++) {
//			System.out.println(i);
//		}
		
		int max = 0; // 두 숫자 중 큰 숫자 저장
		int min = 0; // 두 숫자 중 작은 숫자 저장
		if(start > end) {
			max = start;
			min = end;
		} else { // start <= end
			max = end;
			min = start;
		}
		
//		for(int i = min; i <= max; i++) {
//			System.out.println(i);
//		}
		
		for(; min <= max; min++) {	//위에서 이미 선언했기 때문에 초기식 생략
			System.out.println(min);
		}
	}
	
	public void method4_1() {
		// 정수를 하나 입력받아 그 수가 1~9 사이의 수일 때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 "1~9 사이의 양수를 입력하여야 합니다" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 사이의 양수를 하나 입력하세요 : ");
		int dan = sc.nextInt();
		
		if(dan >= 1 && dan <= 9) {
			for(int i = 1; i <= 9; i++) {
//				System.out.println(dan + " X " + i + " = " + dan*i);
				System.out.printf("%d X %d = %2d%n", dan, i, (dan*i));
			}
		} else {
			System.out.println("1~9 사이의 양수를 입력하여야 합니다");
		}
	}
	
	public void method5() {
		// 1부터 10 사이의 임의의 난수를 정해 1부터 난수까지의 정수 합계
		// 난수? 랜덤한 숫자
//		double random = Math.random();
//		System.out.println(Math.random());
		
//		Math.random으로 1 ~ 10 만들기!
//		(0단계) 0 <= Math.random() < 1 : double
//		(1단계) 0 <= Math.random() * 10 < 10 : 0 ~ 0.999999999999999999...
//		(2단계) 1 <= Math.random() * 10 + 1 < 11 : 1 ~ 10.999999999999999999...
//		(3단계) 1 <= (int)(Math.random() * 10 + 1) < 11 : 1 ~ 10
//		2단계와 3단계의 순서는 바뀌어도 상관 없음
		
		int random = (int)(Math.random() * 10 + 1);
		int sum = 0;
		for(int i = 1; i <= random; i++) {
			sum += i;
		}
		
		System.out.println("1부터 " + random + "까지의 정수 합계 : " + sum);
	}
	
	public void method6() {
		// 2단부터 9단까지 출력
		// 2*1=2 2*2=4 2*3=6 .... 2*9=18
		// 3*1=3 3*2=6 3*3=9 .... 3*9=27
		// ...
		// 크게 도는 것 : 단 -> 큰 for문
		// 작게 도는 것 : 수 -> 작은 for문
		for(int i = 2; i <= 9; i++) { // 단에 대한 큰 for문
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
	
	public void method7() {
		// 0시 0분~23시 59분
		for(int i = 0; i <= 23; i++) {
			for(int j = 0; j <= 59; j++) {
//				System.out.println(i + "시 " + j + "분");
				System.out.printf("%2d시 %2d분%n", i, j);
			}
		}
	}
	
	public void method8() {
		// 한 줄에 별표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수만큼 출력
		/*
		 	출력할 줄 수 : 3		출력할 줄 수 : 5
		 	*****			*****
		 	*****			*****
		 	*****			*****
		 					*****
		 					*****
		 					
		*/	
		// 틀린 답안 : 별 표(*)는 하나씩 출력하기
//		for(int i = 1; i <= 3; i++) {
//			System.out.println("*****");
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수 : " );
		int num = sc.nextInt();
				
		for(int i = 1; i <= num; i++) {		//i는 1로 시작해서 num보다 작거나 같아질 때까지 1씩 증가하며 반복해
			for(int j = 1; j <= 5; j++) {	//j는 1로 시작해서 5보다 작거나 같아질 때까지 1씩 증가하며 반복해
				System.out.print("*");
			}
			System.out.println();
		}	
	}	
	
	public void method9() {
		// 한 줄에 별표 문자를 입력된 줄 수와 칸 수만큼 출력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		/*
		 	줄 수 : 6		줄 수 : 5		줄 수 : 4
		 	칸 수 : 6 	칸 수 : 4		칸 수 : 5
		 	1*****		1***		1****
		 	*2****		*2**		*2***
		 	**3***		**3*		**3**
		 	***4**		***4		***4*
		 	****5*		****
		 	*****6
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int num1 = sc.nextInt();
		System.out.print("칸 수 : ");
		int num2 = sc.nextInt();
		
		
		
		for(int i = 1; i <= num1; i++) {
			for(int j = 1; j <= num2; j++) {
				
				if(i == j) {
					System.out.print(i);
				} else {
				System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
