package com.kh.example.chap02_Wrapper.controller;

public class WrapperController {
	public void method() {
		int num1 = 10; // 원시 타입
		
		Integer integer1 = new Integer(num1); // 원시타입 -> 클래스타입 : boxing
		int num2 = integer1.intValue();// 클래스타입 -> 원시타입 : unboxing
		
		// JDK1.5부터 오토박싱/오토언박싱 제공
		Integer integer2 = num1; // auto-boxing
		int num3 = integer2; // auto-unboxing
	}

}
