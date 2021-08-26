package com.kh.example.test.model.vo;

// 클래스 Child2는 상속받는다 Parent 클래스를
public class Child2 extends Parent {
	private String str;
	
	public Child2() {
//		super.num = 10;
		super.dNum = 0;		// 같은 패키지고 디폴트라서 가능
		super.bool = false;
		super.ch = 'A';
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}

}
