package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���: ");
		double kor = sc.nextDouble();
		System.out.print("���� ������ �Է��ϼ���: ");
		double eng = sc.nextDouble();
		System.out.print("���� ������ �Է��ϼ���: ");
		double math = sc.nextDouble();
		
		int sum = (int)(kor + eng + math);
		int avr = (int)(sum / 3);
		
		System.out.println("���� : " + sum);
		System.out.println("��� : " + avr);
	}

}
