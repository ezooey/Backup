package com.kh.example.chap04_field.controller;

// ���� ���� ��ġ�� ���� ����
public class KindsOfVariable1 { // <-- Ŭ���� ������ ����
	
	// Ŭ���� ������ �ۼ��ϴ� ���� : �ʵ� = ��� ���� = ��� �ʵ� = ���� ����
	private int global;
	
	public void method1(int num) { // <-- �޼ҵ� ������ ����
//						------- �ܺο��� �����͸� �޾ƿ��� ���� : �Ű� ����
		// �޼ҵ� ������ �ۼ��ϴ� ���� : ���� ����
		// �Ű� ������ ������ ���� ����
		// ���� ������ ���� �ܿ� �ٽ� ����ϱ� ���ؼ��� �� �ʱ�ȭ �ʿ�
		// ���������� �Ű� ������ �ʱ�ȭ �ҿ�
		// �Ѿ�� ������ �ʱ�ȭ�� �Ǿ� �ֱ� ����
		
		int local; 
//		System.out.println(local);	// ���� �ϰ� �ʱ�ȭ �� �ϸ� ���� ���� ����
		
		System.out.println(num);	// num�� �Ű�����; �ܺο� �����Ͱ� ���� ���ۿ� ����(�̹� �ʱ�ȭ �� ����)
		
		System.out.println(global); // ���������� ������ ��ħ
		
	} // <-- �޼ҵ� ������ ��
	
	public void method2() { // 11��
		System.out.println(global); // global�� ���⼭�� ������ ��ħ
//		System.out.println(local);	// ���������� ������ �� ��ħ
//		System.out.println(num);	// �Ű������� method1������
	}
} // <-- Ŭ���� ������ ��

