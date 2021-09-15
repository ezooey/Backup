package com.kh.example.test.model.vo;

public class Child1 {
	private String str;
	
	public Child1() {	// 기본 생성자 비워둘 필요x
		Parent p = new Parent();	// 상속 관계가 아니라서 객체 생성
//		p.Num = 10;
		p.dNum = 0;		// 같은 패키지라서 상속 관계가 아니라도 접근 가능
		p.bool = false;
		p.ch = 'A';
		
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}

}
