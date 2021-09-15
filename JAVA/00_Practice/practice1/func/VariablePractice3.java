package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 값을 입력하세요(소수점 첫째자리까지) : ");
		double num1 = sc.nextDouble();
		
		System.out.print("세로 값을 입력하세요(소수점 첫째자리까지) : ");
		double num2 = sc.nextDouble();
		
		System.out.println("가로 : " + num1);
		System.out.println("세로 : " + num2);
		System.out.println("면적 : " + (num1 * num2));
		System.out.println("둘레 : " + ((num1 + num2) * 2));
	}

}
