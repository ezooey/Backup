package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
		System.out.print("������ �Է��ϼ���(��/��) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("���̸� �Է��ϼ��� : ");
		String strAge = sc.nextLine();
		int age = Integer.parseInt(strAge);
		
		System.out.print("Ű�� �Է��ϼ���(cm) : ");
		double height = sc.nextDouble();
		
		System.out.print("Ű " + height + "�� " + age + "�� " + gender +"�� " + name + "�� �ݰ����ϴ�^^");
	}
	
	

}
