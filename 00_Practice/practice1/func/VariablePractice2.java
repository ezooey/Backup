package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice2 {
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요 : ");
//		String strNum = sc.nextLine();
//		int num1 = Integer.parseInt(strNum);
		int num1 = sc.nextInt();		// 왜 둘 다 되지? : 둘 다 nextLine()이 아니기 때문에 띄어쓰기를 구분자로 인식
		
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		System.out.println("첫 번째 정수 : " + num1);
		System.out.println("두 번째 정수 : " + num2);
		System.out.println("더하기 결과 : " + (num1 + num2));
		System.out.println("빼기 결과 : " + (num1 - num2));
		System.out.println("곱하기 결과 : " + (num1 * num2));
		System.out.println("나누기 결과 : " + (num1 / num2));
		
		
	}

}
