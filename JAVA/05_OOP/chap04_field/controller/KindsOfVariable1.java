package com.kh.example.chap04_field.controller;

// 변수 선언 위치에 따른 구분
public class KindsOfVariable1 { // <-- 클래스 영역의 시작
	
	// 클래스 영역에 작성하는 변수 : 필드 = 멤버 변수 = 멤버 필드 = 전역 변수
	private int global;
	
	public void method1(int num) { // <-- 메소드 영역의 시작
//						------- 외부에서 데이터를 받아오는 변수 : 매개 변수
		// 메소드 영역에 작성하는 변수 : 지역 변수
		// 매개 변수도 일종의 지역 변수
		// 지역 변수는 선언 외에 다시 사용하기 위해서는 꼭 초기화 필요
		// 예외적으로 매개 변수는 초기화 불요
		// 넘어올 때부터 초기화가 되어 있기 때문
		
		int local; 
//		System.out.println(local);	// 선언만 하고 초기화 안 하면 값이 없는 상태
		
		System.out.println(num);	// num은 매개변수; 외부에 데이터가 있을 수밖에 없다(이미 초기화 된 상태)
		
		System.out.println(global); // 전역변수라서 영향이 미침
		
	} // <-- 메소드 영역의 끝
	
	public void method2() { // 11시
		System.out.println(global); // global은 여기서도 영향이 미침
//		System.out.println(local);	// 지역변수는 영향이 안 미침
//		System.out.println(num);	// 매개변수도 method1까지만
	}
} // <-- 클래스 영역의 끝

