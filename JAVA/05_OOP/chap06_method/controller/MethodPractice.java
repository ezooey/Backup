package com.kh.example.chap06_method.controller;

import com.kh.example.chap06_method.model.vo.Trainee;

public class MethodPractice {
	// 매개변수 유무와 반환 값 유무에 따른 구분
	// 1. 매개변수 없고 반환 값 없는 메소드
	public void method1() {
		// 반환 값x	   매개변수x
		String str = "매개변수와 반환 값 둘 다 없는 메소드입니다.";
		System.out.println(str);
	}
	// 2. 매개변수 없고 반환 값 있는 메소드
	public int method2() {	// This method must return a result of type int
		// 반환 값o    매개변수x		// 반환 값 있으니 return을 추가해야 함
		int i = 0;
//		return i; 	//변수명으로 끝내기
		return 0;	//반환 값으로 끝내기
	}
	// 3. 매개변수 있고 반환 값 없는 메소드
	public void method3(int num1, int num2) {
		// 반환 값x			   매개변수o
		// 매개변수 : 호출하는 쪽에서 넘긴 데이터를 받아오는 역할
		System.out.println(num1);
		System.out.println(num2);
		int sum = num1 + num2;
		System.out.println(sum);
	}
	// 4. 매개변수 있고 반환 값 있는 메소드
	public String method4(String name, int age) {
		String str = name + "님은 " + age + "살입니다";
		return str;
	}
	
	// 심화 1. 반환 값이 배열일 때
	public char[] method5() {
		char[] chArr = {'j', 'a', 'v', 'a'}; // 선언과 동시에 초기화
		System.out.println("MethodPractice chARR : " + chArr); // chArr의 주소값 출력
			
		return chArr;
	}
		
	// 심화 2. 반환 값이 클래스일 때
	public Trainee method6() {
		Trainee t = new Trainee("강건강", 'H', "오전", 98.5);
		System.out.println("MethodPractce t : " + t);
		return t;
	}
}
