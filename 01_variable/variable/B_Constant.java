package com.kh.variable;

public class B_Constant {
	public void finalConstant() { //finalConstant: �޼ҵ��
		int age;
		final int AGE;
		
		age = 20;
		AGE = 20;
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
		System.out.println("----------------------");
		
		// ���� �� ����
		age = 30;
//		AGE = 30; // ��� ���� �̹� �����߱� ������ ���� �Ұ�
		// The final local variable AGE may already have been assigned
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
	}
}
