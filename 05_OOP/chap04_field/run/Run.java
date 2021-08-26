package com.kh.example.chap04_field.run;

import com.kh.example.chap04_field.controller.KindsOfVariable2;

public class Run {
	public static void main(String[] args) {
		KindsOfVariable2 k2 = new KindsOfVariable2();
		int a1 = k2.staticNum;		// 노란색 줄은 당장은 문제 없지만 나중에 문제가 생길 수도 있으니 없는 게 좋다는 뜻
//		왼)The value of the local variable a1 is not used
//		변수는 지정되었지만 아직 사용되지 않았다
//		오) The static field KindsOfVariable2.staticNum should be accessed in a static way
//		static 방식으로 접근해야 한다
		
		// static 예약어가 들어가 있는 것에 대한 접근은 객체를 만들 필요 x
		// 객체 생성 없이 클래스명.필드명 or 클래스명.메소드명 으로 접근 가능
		int a2 = KindsOfVariable2.staticNum;	// 그냥 변수 하나에 저장해준 것
		
		k2.method();
		k2.method();
		
		KindsOfVariable2 k22 = new KindsOfVariable2();
		k22.method();
	}

}
