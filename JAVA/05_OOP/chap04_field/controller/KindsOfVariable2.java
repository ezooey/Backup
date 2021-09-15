package com.kh.example.chap04_field.controller;

public class KindsOfVariable2 {
	public static int staticNum;			// Ŭ���� ���� // static�̶� ������ private�� ���̸� �� ��
	
	private int testNum = 10;				// �ν��Ͻ� ����(��ü�� ������ Heap �޸� ������ ��ϵ�)
	private static int staticTestNum = 10;  // Ŭ���� ����
	
	public void method() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("staticTestNum : " + staticTestNum);
	}
}
