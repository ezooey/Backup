package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	// ���ǽ� ? ���� �� ����� �� : ������ �� ����� ��;
	
	public void method1() {
		// �Է��� ������ ������� �ƴ��� �Ǻ�
		// ����� "�����", ����� �ƴϸ� "����� �ƴϴ�"��� ���� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է�: ");
		int num = sc.nextInt();
		
//		String result = num > 0 ? "�����" : "����� �ƴϴ�";
		String result = num > 0 ? "�����" : (num == 0 ? "0�̴�" : "������");
		
		System.out.println(num + "���ڴ� " + result);
	}
	
	public void method2() {
		// �Է��� ������ Ȧ������ ¦������ �Ǻ�
		// Ȧ����, Ȧ���Դϴ�
		// ¦����, ¦���Դϴ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է�: ");
		int num = sc.nextInt();
		
		String result = num % 2 == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
//		String result = num % 2 != 0 ? "Ȧ���Դϴ�" : (num == 0 ? "0�Դϴ�" : "¦���Դϴ�");
		
		System.out.println(num + "���ڴ�" + result);
	}

}
