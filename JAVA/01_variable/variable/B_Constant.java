package com.kh.variable;

public class B_Constant {
	public void finalConstant() { //finalConstant: 메소드명
		int age;
		final int AGE;
		
		age = 20;
		AGE = 20;
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
		System.out.println("----------------------");
		
		// 변수 값 변경
		age = 30;
//		AGE = 30; // 상수 값을 이미 지정했기 때문에 변경 불가
		// The final local variable AGE may already have been assigned
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
	}
}
