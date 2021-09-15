package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
//		int num = 0;

		while (true) { // ������ num�� 0���� �ʱ�ȭ�����Ƿ� num < 1�� ���ǹ� �޸� true�� ��// �ƿ� true�� �־ ��
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();

			if (num >= 1) { // �� ���Ŀ� �Է��� 1 �̻��� ���ڴ� ���⿡ ����
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break; // �ݺ����� �������� �Ʒ� ��¹����� �����ϰ� ���ִ� ��?
			} else if (num < 1) { // else { �� �ص� ��
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			}
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = 0; i < num; i++) {
				System.out.print(num - i + " ");
//			for(int i = num; i >= 1; i--) {
//				SYstem.out.print(i + " "); 
			}
		} else {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
			int num = sc.nextInt();

			if (num >= 1) {
				for (int i = 0; i < num; i++) {
					System.out.print(num - i + " ");
				}
				break;
			} else {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			}
		}
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (i == num) {
				System.out.print(i + " = ");
			} else {
				System.out.print(i + " + ");
			}
			sum += i;
		}
		System.out.print(sum);
	}
	
//	public void practice5() {		// ������ ��
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("������ �ϳ� �Է��ϼ��� : ");
//		int num = sc.nextInt();
//		
//		int sum = 0;
//		int i = 1;
//		while(i <= num){
//			sum += i;
//			if(i != num) {
//				System.out.print(i + " + ");
//			} else {
//				System.out.print(i + " = " + sum);
//			}
//			i++;
//		}
//	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int first = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int second = sc.nextInt();

		int min = 0;
		int max = 0;

		if (first > second) {
			min = second;
			max = first;
		} else {
			min = first;
			max = second;
		}

		if (min < 1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		} else {
			for (; min <= max; min++) {
				System.out.print(min + " ");
			}
		}
	}
	
//	public void practice6() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("ù ��° ���� : ");
//		int num1 = sc.nextInt();
//		System.out.print("�� ��° ���� : ");
//		int num2 = sc.nextInt();
//		
//		if(num1 >= 1 && num2 >= 1) {
//			int max = 0;
//			int min = 0;
//			
//			if(num1 > num2) {
//				max = num1;
//				min = num2;
//			} else {
//				max = num2;
//				min = num1;
//			}
//			
//			for(int i = min; i <= max; i++) {
//				System.out.print(i + " ");
//			}			
//		} else {
//			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
//		}
//	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		int min = 0;
		int max = 0;

		while (true) {
			System.out.print("ù ��° ���� : ");
			int first = sc.nextInt();
			System.out.print("�� ��° ���� : ");
			int second = sc.nextInt();

			if (first > second) {
				min = second;
				max = first;
			} else {
				min = first;
				max = second;
			}
			if (min >= 1) {
				for (; min <= max; min++) {
					System.out.print(min + " ");
				}
				break;
			} else if (min < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			}
		}
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		System.out.println("===== " + num + "�� =====");

		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}

	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		if (num <= 9) {
			for (int i = num; i <= 9; i++) {
				System.out.println("===== " + i + "�� =====");
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + " * " + j + " = " + i * j);
				}
			}
		} else {
			System.out.println("9 ������ ���ڸ� �Է����ּ���.");
		}
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("���� : ");
			int num = sc.nextInt();
			if (num <= 9) {
				for (int i = num; i <= 9; i++) {
					System.out.println("===== " + i + "�� =====");
					for (int j = 1; j <= 9; j++) {
						System.out.println(i + " * " + j + " = " + i * j);
					}
					System.out.println();
				}
				break;
			} else {
				System.out.println("9 ������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int start = sc.nextInt();
		System.out.print("���� : ");
		int codif = sc.nextInt();

		int j = start + (9 * codif);

		for (int i = start; i <= j; i += codif) {
			System.out.print(i + " ");
		}
	}
	
//	public void practice11() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("���� ���� : ");
//		int start = sc.nextInt();
//		System.out.print("���� : ");
//		int num = sc.nextInt();
//		
//		for(int i = 0; i < 10; i++) {
//			System.out.print(num * i + start + " ");
//		}
		
//		int count = 0;
//		for(int i = start; ; i += num) {
//			System.out.print(i + " ");
//			count++;
//			
//			if(count == 10) {
//				break;
//			}
//		}
//	}

	public void practice12() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("������(+, -, *, /, %) : ");
			String str = sc.next();
			System.out.print("����1 : ");
			int num1 = sc.nextInt();
			System.out.print("����2 : ");
			int num2 = sc.nextInt();
			if (!str.equals("exit")) {
				
				if (str.equals("/") && num2 == 0) {
					System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.\n");
					continue;
				}

				switch (str) {
				case "+":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 + num2));
					break;
				case "-":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 - num2));
					break;
				case "*":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 * num2));
					break;
				case "/":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 / num2));
					break;
				case "%":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 % num2));
					break;
				default:
					System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.");
				}
				break;
			} else if (str.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	} // ���� exit ���α׷� ���ᰡ �׾ �� �ȴ�

	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) { // i�� num���� �۰ų� ������ ������ 1�� �����Ѵ�
			for (int j = 1; j <= i; j++) { // j�� i���� �۰ų� ������ ������ 1�� �����Ѵ�
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		for(int i = num; i >= 1; i--) {	//�Է��� �������� �����ؼ� 1���� ũ�ų� ������ ������ 1�� �����Ѵ�
			for(int j = i; j >= 1; j--) { // ù ���� ���ڵ� �پ���� �ϹǷ� �ʱ�� j = i;
				System.out.print("*");
			} System.out.println();
		}
	}
	
	// ������ i�� �پ��鼭 j�� ���� ����
	// 4 3 2 1
	// 3 2 1
	// 2 1
	// 1

//	public void practice14() {	// ���ͳݿ��� �ֿ� ��
//		Scanner sc = new Scanner(System.in);
//		System.out.print("���� �Է� : ");
//		int num = sc.nextInt();
//
//		for (int i = 1; i <= num; i++) { // 1���� 4���� �þ��.
//			for (int j = num; j >= i; j--) { 
//				// 4���� 1���� �پ��� ����.
//				// 4 3 2 1
//				// 4 3 2
//				// 4 3
//				// 4
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
}
