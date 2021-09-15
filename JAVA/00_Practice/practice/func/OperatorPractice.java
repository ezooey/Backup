package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		String result = num > 0 ? "�����" : "����� �ƴϴ�";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		String result = num > 0 ? "�����" : (num == 0 ? "0�̴�" : "������");
		System.out.println();
		System.out.println(result);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		String result = num % 2 == 0 ? "¦����" : "Ȧ����";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ο� �� : ");
		int human = sc.nextInt();
		System.out.print("���� ���� : ");
		int candy = sc.nextInt();
		
		int result1 = candy / human;
		int result2 = candy % human;
		
		System.out.println();
		System.out.println("1�δ� ���� ���� : " + result1);
		System.out.println("���� ���� ���� : " + result2);
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�г�(���ڸ�) : ");
		int level = sc.nextInt();
		System.out.print("��(���ڸ�) : ");
		int cn = sc.nextInt();
		System.out.print("��ȣ(���ڸ�) : ");
		int num = sc.nextInt();
		System.out.print("����(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : " );
		double grade = sc.nextDouble();
		
		String result = gender == 'F' ? "��" : "��";
		System.out.println();
		System.out.print(level + "�г� " + cn + "�� " + num + "�� " + name + " " + result + "�л��� ������ " + grade + "�̴�.");
		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "���" : (age <= 19 ? "û�ҳ�" : "����");
		System.out.println();
		System.out.println(result);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int kor = sc.nextInt();
		System.out.print("���� : ");
		int eng = sc.nextInt();
		System.out.print("���� : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		String result = (avg >= 60 && kor >= 40 && eng >= 40 && math >= 40 ? "�հ�" : "���հ�" );
		
		System.out.println();
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + avg);
		System.out.println(result);
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���(- ����) : ");
		char pId = sc.nextLine().charAt(7);
		
		String result = pId % 2 == 0 ? "����" : "����";
		System.out.println();
		System.out.println(result);
		
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����1 : ");
		int num1 = sc.nextInt();
		System.out.print("����2 : ");
		int num2 = sc.nextInt();
		System.out.print("�Է� : ");
		int num3 = sc.nextInt();
		
		String result = num1 > num2 ? "����: num1�� num2���� �۾ƾ� �մϴ�." : (num3 <= num1 || num3 > num2 ? "true" : "false");
		
		System.out.println();
		System.out.println(result);
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�1 : ");
		int num1 = sc.nextInt();
		System.out.print("�Է�2 : ");
		int num2 = sc.nextInt();
		System.out.print("�Է�3 : ");
		int num3 = sc.nextInt();
		
		String result = num1 == num2 && num2 == num3 ? "true" : "false";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("A����� ���� : ");
		int num1 = sc.nextInt();
		System.out.print("B����� ���� : ");
		int num2 = sc.nextInt();
		System.out.print("C����� ���� : ");
		int num3 = sc.nextInt();
		
		double sal1 = num1 + (double)(num1 * 0.4);
		double sal2 = num2;
		double sal3 = num3 + ((double)num3 * 0.15);
		
		String result1 = sal1 >= 3000 ? "3000 �̻�" : "3000 �̸�";
		String result2 = sal2 >= 3000 ? "3000 �̻�" : "3000 �̸�";
		String result3 = sal3 >= 3000 ? "3000 �̻�" : "3000 �̸�";
		
		System.out.println();
		System.out.println("A��� ����/����+a : " + num1 + "/" + sal1);
		System.out.println(result1);
		System.out.println("B��� ����/����+a : " + num2 + "/" + sal2);
		System.out.println(result2);
		System.out.println("C��� ����/����+a : " + num3 + "/" + sal3);
		System.out.println(result3);
		
		
	}
}
