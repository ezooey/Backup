package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String word = sc.nextLine();
		char ch1 = word.charAt(0);
		char ch2 = word.charAt(1);
		char ch3 = word.charAt(2);
		
		System.out.println("ù ��° ���� : " + ch1); 
		System.out.println("�� ��° ���� : " + ch2);
		System.out.println("�� ��° ���� : " + ch3);
				
	}

}
