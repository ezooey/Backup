package com.kh.example.chap04_field.run;

import com.kh.example.chap04_field.controller.KindsOfVariable2;

public class Run {
	public static void main(String[] args) {
		KindsOfVariable2 k2 = new KindsOfVariable2();
		int a1 = k2.staticNum;		// ����� ���� ������ ���� ������ ���߿� ������ ���� ���� ������ ���� �� ���ٴ� ��
//		��)The value of the local variable a1 is not used
//		������ �����Ǿ����� ���� ������ �ʾҴ�
//		��) The static field KindsOfVariable2.staticNum should be accessed in a static way
//		static ������� �����ؾ� �Ѵ�
		
		// static ���� �� �ִ� �Ϳ� ���� ������ ��ü�� ���� �ʿ� x
		// ��ü ���� ���� Ŭ������.�ʵ�� or Ŭ������.�޼ҵ�� ���� ���� ����
		int a2 = KindsOfVariable2.staticNum;	// �׳� ���� �ϳ��� �������� ��
		
		k2.method();
		k2.method();
		
		KindsOfVariable2 k22 = new KindsOfVariable2();
		k22.method();
	}

}
