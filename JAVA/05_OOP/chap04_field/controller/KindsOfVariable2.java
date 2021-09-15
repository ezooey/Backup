package com.kh.example.chap04_field.controller;

public class KindsOfVariable2 {
	public static int staticNum;			// 클래스 변수 // static이라 공유라서 private을 붙이면 안 됨
	
	private int testNum = 10;				// 인스턴스 변수(객체를 만들어야 Heap 메모리 영역에 기록됨)
	private static int staticTestNum = 10;  // 클래스 변수
	
	public void method() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("staticTestNum : " + staticTestNum);
	}
}
