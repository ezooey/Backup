package com.kh.example.chap03.branch;

import java.util.Scanner;

public class A_Break {
	public void method() {
		// ���ڿ��� �Է� �޾� ���� ������ ����ϴ� �ݺ� ���α׷�
		// ��, end�� �ԷµǸ� �ݺ� ����
		
		Scanner sc = new Scanner(System.in);
		
//		String str = null;
//		do {
//			System.out.print("���ڿ� �Է� : ");
//			str = sc.nextLine();
//			System.out.println("���� ���� : " + str.length());
//		} while(!str.equals("end"));
	
		while(true) {
			System.out.print("���ڿ� �Է� : ");
			String str = sc.nextLine();
			
			if(str.equals("end")) {			// ���� str�� end�� ���ٸ� ���� ����� �ݺ����� while���� ������
				break;
			}
			
			System.out.println("���� ���� : " + str.length());
		}
	}

}
