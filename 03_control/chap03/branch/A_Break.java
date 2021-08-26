package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	public void method() {
		// 문자열을 입력 받아 글자 개수를 출력하는 반복 프로그램
		// 단, end가 입력되면 반복 종료
		
		Scanner sc = new Scanner(System.in);
		
//		String str = null;
//		do {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.println("글자 개수 : " + str.length());
//		} while(!str.equals("end"));
	
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("end")) {			// 만약 str이 end와 같다면 가장 가까운 반복문인 while문을 나갈게
				break;
			}
			
			System.out.println("글자 개수 : " + str.length());
		}
	}

}
