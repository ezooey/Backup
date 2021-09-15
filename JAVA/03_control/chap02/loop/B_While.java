package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
//	while(���ǽ�){
//		���๮��;
//		[������ or �б⹮;]
//	}
//	���ǽ� Ȯ�� -> (���ǽ��� true�� ��) ���๮�� ���� -> ���ǽ� Ȯ�� -> (�ݺ�)
//	���ǽ��� ����� false�� �� ������ �ݺ�

//	do{
//		���๮��;
//		[������ or �б⹮;]
//	} while(���ǽ�);
//	���๮�� -> ���ǽ� Ȯ�� -> (���ǽ��� true�� ��) do�� ���๮�� ���� -> ���ǽ� Ȯ�� -> (�ݺ�)
//	���ǽ��� ����� false�� �� ������ �ݺ�
	
//	while�� do~while�� ������ : do~while�� ������ �� �� �̻� ����

	public void method1() {
		// 1���� 5���� ���
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	public void method1_1() {
		// �ڱ� �Ұ� �ټ� �� �ϱ� : �� �̸��� �ڽſ��
		int i = 1;
		while(i <= 5) {
			System.out.println("�� �̸��� �ڽſ��");
			i++;
		}
		
	}
	
	public void method2() {
		// 5���� 1���� ���
		int i = 5;
		while(i >= 1) {
			System.out.println(i);
			i--;
		}
	}
	
	public void method3() {
		// ���ڿ��� �Է¹޾� �ε��� ���� ���� ���
		// java
		// 0 : j
		// 1 : a
		// 2 : v
		// 3 : a
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� �Է� : ");
		String str = sc.nextLine();
		// ���ڿ��� ���� : String Ŭ������ length()
//		int length = str.length();
//		System.out.println(length);
		//apple
		
//		int i = 0;
//		while(i < length) {
//		while(i < str.length()) {
//			char ch = str.charAt(i);
//			System.out.println(i + " : " + ch);
//			i++;
//		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
				System.out.println(i + " : " + ch);
		}
	}
	
	public void method4() {
		int i = 2;
		while(i <= 9) {
			int j = 1;
			while(j < 10) {
				System.out.println(i + " * " + j + " = " + i*j);
				j++;
			}
			i++;
		}
		
//		return; // <- ����������. ���� ȣ������ �޼ҵ�� ���ư��� ���� (���� �� ������ ���ư�)
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		while(menuNum != 9) {		//menuNum�� 9�� �ƴ� �� Ʈ��� �ؼ� �Ʒ� �����ض�
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			menuNum = sc.nextInt();	//�� �տ� int �� ������ �ߺ� �����̱� ������ ������ �� 2�� 51��
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("�����մϴ�."); break;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	public void method5_1() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		do {		// do ���� ������ �ϴ� �� ���� ������ ����
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			menuNum = sc.nextInt();				// �ߺ����� ��ħ
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("�����մϴ�."); break;		//���� ������ �־��� ������ return �ҿ�
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} while(menuNum != 9);		// do �ȿ� ����� menuNum�� ������ ����� ������ ������ ��
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {	// ������ Ʈ��� ����� ���(���ѹݺ���)
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			int menuNum = sc.nextInt();	
			
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("�����մϴ�."); break; // break; ��� return; �־ ����, ���������
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");// ���ѹݺ������� ������� ������ return�� �־�� ����
			}
		}
	}
	
	public void method6_1() {
		// method6�� do~while ��������
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. 1~5���� ���");
			System.out.println("2. 5~1���� ���");
			System.out.println("3. ���ڿ� �ε���");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			int menuNum = sc.nextInt();	
		
			switch(menuNum) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("�����մϴ�."); return; 
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} while(true);
	}
	
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� : ");
		int row = sc.nextInt();
		System.out.print("ĭ �� : ");
		int col = sc.nextInt();
		
		int i = 1;
		while(i <= row) {
			int j = 1;
			while(j <= 5) {
				System.out.println("*");
				j++;						// ������ ������ ������ 5�� �� �ż� ���ѹݺ�
			}
			System.out.println();
			i++;
		}
		
	}
//		do {
//			System.out.print("*");
//			i++;
//		} while(i <= row);
//	}
	
	public void method8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� : ");
		int row = sc.nextInt();
		System.out.print("ĭ �� : ");
		int col = sc.nextInt();
		
		int i = 1;
		while(i <= row) {
			int j = 1;
			while(j <= col) {
				if( i == j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public void method9() {
		// Ű����� ���ڿ� ���� �Է� �޾� ��� �ݺ� ����
		// exit�� ���� �ݺ� ���� -> exit�� �ƴϸ� ��� ����
		// ������ ������ �������� �𸣴ϱ� while���� ����
		
		Scanner sc = new Scanner(System.in);
		
//		String str = null;		// String�� �⺻��
		// null ? �ƹ��͵� ����(= ���� ����)
		String str = "";		// �ƹ� ���̳� �� ����. null���� �ٸ���!
		while(!str.equals("exit")) {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		}
	}
	
	public void method10() {
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		do {									// do�� ���� ������ �� ���ǹ��� ���� ������ ���� ���� �޸� ��������
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		} while(!str.equals("exit"));
	}
}
