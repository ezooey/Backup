package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է��ϼ���(�Ҽ��� ù°�ڸ�����) : ");
		double num1 = sc.nextDouble();
		
		System.out.print("���� ���� �Է��ϼ���(�Ҽ��� ù°�ڸ�����) : ");
		double num2 = sc.nextDouble();
		
		System.out.println("���� : " + num1);
		System.out.println("���� : " + num2);
		System.out.println("���� : " + (num1 * num2));
		System.out.println("�ѷ� : " + ((num1 + num2) * 2));
	}

}
