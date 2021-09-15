package com.kh.example.chap01_throws.controller;

public class ThrowsController {
	public void method1() throws Exception {
		System.out.println("method1() 호출됨...");
		method2();
		System.out.println("method1() 종료됨...");
	}
	
	public void method2() throws Exception {
		System.out.println("method2() 호출됨...");
		method3();
		System.out.println("method2() 종료됨..."); 
		// 예외를 가진 채로 넘어갔기 때문에 1,2,3 종료됨은 안 뜨게 됨
	}
	
	public void method3() throws Exception {
		System.out.println("method3() 호출됨...");
		// 강제 Exception 발생 : try~catch (x) --> 내가 발생시키고 내가 처리하는 건 말이 안 된다
		throw new Exception();
		// Unhandled exception type Exception
//		System.out.println("method3() 종료됨...");
		// Unreachable code // 위의 예외를 처리하느라 이 출력문까지 처리할 수 없다.
		
	}
	

}
