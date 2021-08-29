package com.kh.example.chap04_Math.controller;

import java.util.Random;

public class MathController {
	public void method() {
//		Math.random() // static으로 들어가 있어서 객체를 만들지 않고도 가능
		// Math클래스 : 수학 연산을 하기에 유용한 메소드들을 모아놓은 클래스
		// 싱글톤 패턴 구성
		//		static을 이용해 애플리케이션이 시작할 때 딱 한 번만 인스턴스를 만들어 메모리 할당
		//		딱 한 번 만든 인스턴스를 사용하게끔 만든 패턴
		//		-> 생성자 private, 멤버 public static 
		
		double num = 4.949;
		double num2 = 4.123;
		
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Math.abs(-num)); // 절대값
		
		System.out.println(Math.ceil(num));	// 올림
		System.out.println(Math.ceil(num2));
		
		System.out.println(Math.round(num)); // 반올림 (반환값이 long이라서 정수로 나옴)
		System.out.println(Math.round(num2));

		System.out.println(Math.floor(num)); // 내림
		System.out.println(Math.floor(num2));
		
		int random = (int)(Math.random() * 4) + 1;
		System.out.println(random);
		
		Random r = new Random();
//		System.out.println(r); // 주소값
		System.out.println(r.nextInt(4) + 1); // +1까지 해줘야 1부터 4까지 가져옴
		
		System.out.println(Math.rint(num)); // num과 가장 가까운 값이 나옴
		System.out.println(Math.rint(num2)); 
		
		System.out.println(Math.sqrt(3)); // 루트값
		System.out.println(Math.pow(2, 3)); // 제곱근
		
		System.out.println(Math.max(10, 4)); // 두 값 중에 큰 값
		System.out.println(Math.min(10, 4)); // 두 값 중에 작은 값
	}

}
