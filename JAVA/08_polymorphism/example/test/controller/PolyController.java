package com.kh.example.test.controller;

import com.kh.example.test.model.vo.Child1;
import com.kh.example.test.model.vo.Child2;
import com.kh.example.test.model.vo.Parent;

public class PolyController {
	public void method() {
		System.out.println("1. 부모타입 레퍼런스로 부모 객체 다루는 경우");
		Parent p1 = new Parent();
		// ㄴ부모타입 레퍼런스	ㄴ부모객체
		p1.printParent();
		
		System.out.println("2. 자식타입 레퍼런스로 자식 객체 다루는 경우");
		Child1 c1 = new Child1();
		// ㄴ자식타입 레퍼런스	ㄴ자식객체
		c1.printChild1();
		c1.printParent();
		
		System.out.println("3. 부모타입 레퍼런스로 자식 객체 다루는 경우");
		Parent p2 = new Child2();	// 다형성 적용
		//	ㄴ부모타입 레퍼런스	ㄴ자식객체
		// 업 캐스팅 : 부모타입의 참조형 변수가 모든 자식 객체를 받을 수 있는 것
		p2.printParent();
//		p2.printChild2();
		((Child2)p2).printChild2(); 	// Parent까지만 보이던 시야를 Child2까지 보이게 해준 것
		
		System.out.println("4. 자식타입 레퍼런스로 부모 객체 다루는 경우");
//		Child2 c2 = new Parent();
		// ㄴ자식타입 레퍼런스	ㄴ부모객체
		
		
		System.out.println();
		System.out.println("== 간단 예제 ==");
		System.out.println();
		
		Parent[] pArr = new Parent[4];
		// 업캐스팅이 적용된 상태
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		pArr[2] = new Child2();
		pArr[3] = new Child1();
		
//		((Child1)pArr[0]).printChild1();
//		((Child2)pArr[1]).printChild2();
//		((Child2)pArr[2]).printChild2();
//		((Child1)pArr[3]).printChild1();
		
		for(int i = 0; i < pArr.length; i++) {
			// instanceof 연산자 : 현재의 참조형 변수가 어떤 클래스형의 객체를 참조하고 있는지 확인할 때 사용
//			pArr[0] instanceof Child1	// pArr[0]에 들어가 있는 객체가 Child1 형식이니? true
//			pArr[1] instanceof Child2	// pArr[1]에 들어가 있는 객체가 Child2 형식이니? true
//			pArr[2] instanceof Child1	// pArr[2]에 들어가 있는 객체가 Child1 형식이니? false
//			pArr[3] instanceof Child2	// pArr[3]에 들어가 있는 객체가 Child2 형식이니? false
			// instnaceof 연산자의 결과 값은 true/false -> 조건식에 많이 사용
			
			if(pArr[i] instanceof Child1) {
				((Child1)pArr[i]).printChild1();
			} else if(pArr[i] instanceof Child2) {
				((Child2)pArr[i]).printChild2();
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < pArr.length; i++) {
			pArr[i].print();	
			// 갖고 있는 객체가 Child1 Child2라도 타입이 Parent라서 Parent의 print만 출력될 거라고 예상했으나 제대로 나옴
			// -> 동적 바인딩 실행되었기 때문
		}
	}
	

}
