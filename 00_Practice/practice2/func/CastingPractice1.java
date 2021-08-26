package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		char ch1 = sc.nextLine().charAt(0);
		int num1 = ch1;
		
		System.out.println(ch1 + " unicode : " + num1);
		System.out.println();
		
		System.out.print("문자를 입력하세요 : ");
		char ch2 = sc.nextLine().charAt(0);
		int num2 = ch2;
		System.out.println(ch2 + " unicode : " + num2);
	}

}
