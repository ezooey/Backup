package com.kh.example.chap02_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {
	public void method1() {
		System.out.println("method1() 호출됨...");
		try {
			method2();
			System.out.println("예외 발생 시에는 출력되지 않음");
		} catch (IOException e) {
// Unreachable catch block for IOException. 
// It is already handled by the catch block for Exception
			e.printStackTrace();
		} catch (Exception e) { // 위에 예외랑 별개임 // (12시 40분쯤) 상속 관계를 고려할 것
			System.out.println("Exception으로 잡음");
		} finally {
			System.out.println("예외 발생 여부와 상관 없이 무조건 수행");
		}
		System.out.println("method2() 종료됨...");
	}
	public void method2() throws IOException {
		System.out.println("method2() 호출됨...");
		throw new IOException();
//		System.out.println("method2() 종료됨..."); 
		// Unreachable code
		
	}

}
