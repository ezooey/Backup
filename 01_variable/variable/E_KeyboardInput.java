package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void inputScanner1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
//		String name = sc.nextLine(); // nextLine() : 사용자에게서 문자열을 받아오는 메소드
		String name = sc.next(); // next() :사용자에게서 문자열을 받아오는 메소드
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // nextInt() : 사용자에게서 정수를 받아오는 메소드
		
		System.out.print("키를 입력하세요(소수점 첫째자리까지 입력) : ");
		double height = sc.nextDouble(); // nextDouble() : 사용자에게서 실수를 받아오는 메소드
		
		System.out.println(name + "님은 " + age + "세이며, 키는 " + height + "cm입니다.");
	}

	public void inputScanner2() {
		// next()와 nextLine() 비교
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();	// 박신우\n
		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();			// 20\n -> 20만 입력되고 \n은 남음
		
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.nextLine();
		
		// 해결 방법 1. next()로 주소 받아주기
		// 띄어쓰기를 구분자로 인식하기 때문에 띄어쓰기가 있을 경우 그 중 일부만 읽어옴
		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.next();
//		System.out.println(sc.next());
//		System.out.println(sc.next());
		
		// 2. 줄바꿈을 없애기 위한 nextLine() 추가
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();
//		sc.nextLine();					// 위에서 남은 \n을 가져와서 없애줌
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.nextLine(); // 서울시 강남구 역삼동\n <-nextLine()이 모두 가져감
		
		// 3. 파싱(parsing)하기 : 문자열을 다른 자료형으로 바꾸는 것
		System.out.print("나이를 입력하세요 : ");
		String strAge = sc.nextLine();
		int age = Integer.parseInt(strAge);
		System.out.print("주소를 입력하세요 : ");
		String address = sc.nextLine();
		
		// + char 받기
		System.out.print("성별을 입력하세요(M/F) : ");
		String strGender = sc.nextLine();
		char gender = strGender.charAt(0);
		
		System.out.println(name + "님(" +gender +")은 " + age + "세이며, 사는 곳은 " + address + "입니다.");
	}
}
