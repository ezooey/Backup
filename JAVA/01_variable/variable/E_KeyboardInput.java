package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void inputScanner1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ��� : ");
//		String name = sc.nextLine(); // nextLine() : ����ڿ��Լ� ���ڿ��� �޾ƿ��� �޼ҵ�
		String name = sc.next(); // next() :����ڿ��Լ� ���ڿ��� �޾ƿ��� �޼ҵ�
		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); // nextInt() : ����ڿ��Լ� ������ �޾ƿ��� �޼ҵ�
		
		System.out.print("Ű�� �Է��ϼ���(�Ҽ��� ù°�ڸ����� �Է�) : ");
		double height = sc.nextDouble(); // nextDouble() : ����ڿ��Լ� �Ǽ��� �޾ƿ��� �޼ҵ�
		
		System.out.println(name + "���� " + age + "���̸�, Ű�� " + height + "cm�Դϴ�.");
	}

	public void inputScanner2() {
		// next()�� nextLine() ��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();	// �ڽſ�\n
		
//		System.out.print("���̸� �Է��ϼ��� : ");
//		int age = sc.nextInt();			// 20\n -> 20�� �Էµǰ� \n�� ����
		
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.nextLine();
		
		// �ذ� ��� 1. next()�� �ּ� �޾��ֱ�
		// ���⸦ �����ڷ� �ν��ϱ� ������ ���Ⱑ ���� ��� �� �� �Ϻθ� �о��
		
//		System.out.print("���̸� �Է��ϼ��� : ");
//		int age = sc.nextInt();
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.next();
//		System.out.println(sc.next());
//		System.out.println(sc.next());
		
		// 2. �ٹٲ��� ���ֱ� ���� nextLine() �߰�
//		System.out.print("���̸� �Է��ϼ��� : ");
//		int age = sc.nextInt();
//		sc.nextLine();					// ������ ���� \n�� �����ͼ� ������
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.nextLine(); // ����� ������ ���ﵿ\n <-nextLine()�� ��� ������
		
		// 3. �Ľ�(parsing)�ϱ� : ���ڿ��� �ٸ� �ڷ������� �ٲٴ� ��
		System.out.print("���̸� �Է��ϼ��� : ");
		String strAge = sc.nextLine();
		int age = Integer.parseInt(strAge);
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		String address = sc.nextLine();
		
		// + char �ޱ�
		System.out.print("������ �Է��ϼ���(M/F) : ");
		String strGender = sc.nextLine();
		char gender = strGender.charAt(0);
		
		System.out.println(name + "��(" +gender +")�� " + age + "���̸�, ��� ���� " + address + "�Դϴ�.");
	}
}
