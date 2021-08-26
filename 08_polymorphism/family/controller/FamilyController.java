package com.kh.example.family.controller;

import com.kh.example.family.model.vo.Baby;
import com.kh.example.family.model.vo.Basic;
import com.kh.example.family.model.vo.Family;
import com.kh.example.family.model.vo.Mother;

public class FamilyController {
	public void method() {
//		Family f = new Family();
		// 추상클래스는 객체 생성 불가, 참조형 변수만 가능
		
		Family f1 = new Mother("엄마", 50, 70, "출산");
		Family f2 = new Baby("아기", 3.5, 70);
		
//		f1.eat(); // 다형성+오버라이딩으로 동적바인딩 실행되어 f1을 썼지만 Mother의 eat이 들어감
//		f2.eat();
		
//		Basic b = new Basic();
		// 인터페이스는 객체 생성 불가, 참조형 변수만 가능
		Basic b1 = new Mother("엄마", 50, 70, "출산");
		Basic b2 = new Baby("아기", 3.5, 70);
		
		// 동적 바인딩 들어간 상태
		b1.sleep();
		b2.sleep();
	}

}
