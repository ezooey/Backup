package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice2 {
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ������ �Է��ϼ��� : ");
//		String strNum = sc.nextLine();
//		int num1 = Integer.parseInt(strNum);
		int num1 = sc.nextInt();		// �� �� �� ����? : �� �� nextLine()�� �ƴϱ� ������ ���⸦ �����ڷ� �ν�
		
		System.out.print("�� ��° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		
		System.out.println("ù ��° ���� : " + num1);
		System.out.println("�� ��° ���� : " + num2);
		System.out.println("���ϱ� ��� : " + (num1 + num2));
		System.out.println("���� ��� : " + (num1 - num2));
		System.out.println("���ϱ� ��� : " + (num1 * num2));
		System.out.println("������ ��� : " + (num1 / num2));
		
		
	}

}
