package com.kh.example.test.model.vo;

public class Child1 {
	private String str;
	
	public Child1() {	// �⺻ ������ ����� �ʿ�x
		Parent p = new Parent();	// ��� ���谡 �ƴ϶� ��ü ����
//		p.Num = 10;
		p.dNum = 0;		// ���� ��Ű���� ��� ���谡 �ƴ϶� ���� ����
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
