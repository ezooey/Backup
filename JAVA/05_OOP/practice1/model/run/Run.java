package com.kh.example.practice1.model.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		m.printName();				// ���� �ʱ�ȭ�� �� �ؼ� null�� ��
		m.changeName("�ڽſ�");
		m.printName();
	}

}
