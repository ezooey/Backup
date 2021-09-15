package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	// switch(���ǽ�){
	// case 1: ���๮1; break; // ���ǽ��� ��� ���� 1�� ��� ����
	// case 2: ���๮2; break; // ���ǽ��� ��� ���� 2�� ��� ����
	// default: ���๮3;		 // ���ǽ��� ��� ���� case�� �ش����� ���� �� ����
	// }
	// ���ǽ��� ��� ���� case���� ã�� ����� �����ϴ� ���ǹ�
	// �ش��ϴ� ���� case�� ���� ��� default�� ��ɹ� ����
	// case�� ���๮ ���̿��� �ݷ�(:)�� ���־�� ��
	// break�� ������ ������ �ʰ� ��� ����
	public void method1() {
		// ���� �� ���� ���� ��ȣ ���� 1���� �Է� �޾� ���� ��ȣ ���ڿ� �ش��ϴ� ����� ���� �� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ���� : ");
		int first = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int second = sc.nextInt();					// �̴�� ���� �Է°��� \n���� �Ѿ�ͼ� ���� �߻�
		System.out.print("������(+,-,*,/) : ");
//		char op = sc.nextLine().charAt(0);
		char op = sc.next().charAt(0);
		// �ذ���
		// 1. int�� �޾ƿ� �� String���� �޾� �Ľ��ϱ�
		// 2. nextLine()���� �ٹٲ� ���ֱ�
		// 3. nextLine() ��� next()�� ����
		
		int result = 0; // ���� ���� �� �ʱ�ȭ
		switch(op) { // op�� case�� �����ڴ�
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			if(second == 0) {
				System.out.println("0���δ� ���� �� �����ϴ�. ����� ��Ȯ���� �ʽ��ϴ�.");
			} else {
				result = first / second;
			}	
			break;
		default:
			System.out.println("���ÿ� ���� �������Դϴ�. ����� ��Ȯ���� �ʽ��ϴ�.");
		}
		
		System.out.printf("%d %c %d = %d", first, op, second, result);
	}
	
	public void method2() {
		System.out.println("***** �ſ�� ���� ���� *****");
		System.out.println("���, �ٳ���, ������, Ű�� �ֽ��ϴ�! ���� ���ϰ� �������!");
		System.out.print("� ������ ������ �ñ��ϼ���? : ");
		
		Scanner sc = new Scanner(System.in);
		String fruit = sc.nextLine();
		
		// ��� 1000 / �ٳ��� 3000 / ������ 2000 / Ű�� 5000
		// ���� ������ ���, "�� ������ �ſ�� ���� ���Կ� �����ϴ�. ���� �ſ츶Ʈ�� ��������!" ���� ���
		// ���� ��� : (ex) ����� ������ 1000���Դϴ�.
		
		int price = 0;
//		boolean flag = false;
		
		
		
//		if(fruit.equals("���")) {						//����ġ�� if������ �ٲٱ� ����!
//			price = 1000;
//		} else if(fruit.equals("�ٳ���")) {
//			price = 3000;
//		} else if(fruit.equals("������")) {
//				price = 2000;
//		} else if(fruit.equals("Ű��")) {
//				price = 5000;
//		} else {
//			System.out.println("�� ������ �ſ�� �����ϴ�.");
//			flag = true;
//		}
//		
		
		
		
		switch(fruit) {
		case "���":
			price = 1000;
			break;
		case "�ٳ���":
			price = 3000;
			break;
		case "������":
			price = 2000;
			break;
		case "Ű��":
			price = 5000;
			break;
		default:
			System.out.println("�� ������ �ſ�� ���� ���Կ� �����ϴ�. ���� �ſ츶Ʈ�� ��������!");
//			flag = true;
		}
		
//		if(flag == false) {
//		Ȥ��
//		if(!flag) {	
//		-> flag:false�� �� // ����ǥ�� O
//		-> flag:true�� �� // ����ǥ�� X		//�̰� ���� boolean flag = true;�� �θ� �׳� if(flag)�� �ֵ� ����x
		System.out.println(fruit + "�� ������ " + price + "�� �Դϴ�." );
//		}
		
		// ���� ������ �Է����� �� ������ �� ������ �ϴ� ��� -> �ּ�ó���� �͵��� �߰��ϸ� ��
		
		
	}
	
	public void method3() {
		// 1���� 12���� �Է¹޾� �ش��ϴ� ���� ������ ��¥ ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1���� 12���� �� �ϳ��� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
//		int date = 0;
//		switch(num) {
//		case 1:
//			date = 31;
//			break;
//		case 2:
//			date = 28;
//			break;
//		case 3:
//			date = 31;
//			break;
//		case 4:
//			date = 30;
//			break;
//		case 5:
//			date = 31;
//			break;
//		case 6:
//			date = 30;
//			break;
//		case 7:
//			date = 31;
//			break;
//		case 8:
//			date = 31;
//			break;
//		case 9:
//			date = 30;
//			break;
//		case 10:
//			date = 31;
//			break;
//		case 11:
//			date = 30;
//			break;
//		case 12:
//			date = 31;
//		}
		
		int date = 0;
		switch(num) {
		case 2:
			date = 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			date = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			date = 30;
			break;
		default:
			System.out.println("1~12 ������ ���ڰ� �ƴմϴ�.");
		}
		
		System.out.println(num + "���� ������ ��¥�� " + date + "���Դϴ�.");
	}
	
	public void method4() {
		Scanner sc = new Scanner(System.in);
		
		// ȸ���� ���� �޴�
		System.out.println("1. ȸ�����");
		System.out.println("2. ȸ������");
		System.out.println("3. ȸ������");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("ȸ����� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("ȸ������ �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("ȸ������ �޴��Դϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. �����ϱ�");
		System.out.println("2. �ſ�� ���ϰ���");
		System.out.println("3. ������ ��¥");
		System.out.println("4. �޴� ���");
		System.out.print("�޴� ��ȣ : ");
		
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			method1();
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		case 4: 
			method3();
			break;
		default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
	}

}
