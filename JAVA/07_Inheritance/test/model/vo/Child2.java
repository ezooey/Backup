package com.kh.example.test.model.vo;

// Ŭ���� Child2�� ��ӹ޴´� Parent Ŭ������
public class Child2 extends Parent {
	private String str;
	
	public Child2() {
//		super.num = 10;
		super.dNum = 0;		// ���� ��Ű���� ����Ʈ�� ����
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
