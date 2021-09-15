package com.kh.example.chap06_method.run;

import com.kh.example.chap06_method.controller.MethodPractice;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {

	public static void main(String[] args) {
		MethodPractice mp = new MethodPractice();
		
		mp.method1();	// 반환 값이 void = 반환 값이 없다 -> void는 절대로 다른 자료형에 담을 수 없음
		
//		mp.method2();	// 값을 반환받긴 하나 따로 저장을 하지 않아서 데이터가 날아감
//		int result1 = mp.method2();	// 0을 가지고 호출해준 method2()로 돌아왔기 때문에 method2() 자체가 0이 됨
//		System.out.println((result1));
		System.out.println(mp.method2()); // 출력만이 목적일 때 따로 저장 안 하고 바로 출력해도 됨
		
		mp.method3(10, 20);
		
		String result2 = mp.method4("박신우", 20);
		System.out.println(result2);
		
		char[] result3 = mp.method5(); // 얕은 복사
		System.out.println("Run result3 : " + result3);
		for(int i = 0; i < result3.length; i++) {
			System.out.print(result3[i]);
		}
		
		System.out.println();
		
		Trainee result4 = mp.method6(); // 얕은 복사
		System.out.println("Run result4 : " + result4);
		System.out.println(result4.inform());
		
		result4.setName("이주희");
		result4.setClassRoom('G');
		System.out.println(result4.inform());
		
		System.out.println(result4.getACADEMY());
		System.out.println(result4.getClassRoom());
		System.out.println(result4.getName());
		System.out.println(result4.getTime());
		System.out.println(Trainee.getScore());
	}
}
