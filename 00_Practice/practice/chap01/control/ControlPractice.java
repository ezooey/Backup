package com.kh.practice.chap01.control;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("�Է� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("��ȸ �޴��Դϴ�.");
			break;
		case 4:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 7:
			System.out.println("���α׷��� ����˴ϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if (num <= 0) {
			System.out.println("����� �Է����ּ���.");
		} else if (num % 2 == 0) {
			System.out.println("¦����");
		} else {
			System.out.println("Ȧ����");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� : ");
		int math = sc.nextInt();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		
		int sum = (kor + eng + math);
		double avg = sum / 3;
		
		if (kor < 40 || math < 40 || eng < 40) {
			System.out.println("���հ��Դϴ�.");
		} else if (avg < 60) {
			System.out.println("���հ��Դϴ�.");
		} else if (avg >= 60) {
			System.out.println("���� : " + kor);
			System.out.println("���� : " + math);
			System.out.println("���� : " + eng);
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + avg);
			System.out.println("�����մϴ�, �հ��Դϴ�!");
		}
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);;
		System.out.print("1~12 ������ ���� �Է� : ");
		int month = sc.nextInt();
		
		String season = null; // ����ġ�� �� ���� �ʱ�ȭ����
		switch (month) {
		case 1: case 2: case 12:
			season = "�ܿ�";
//			System.out.println(month + "���� �ܿ��Դϴ�.");
			break;
		case 3: case 4: case 5:
			season = "��";
//			System.out.println(month + "���� ���Դϴ�.");
			break;
		case 6: case 7: case 8:
			season = "����";
//			System.out.println(month + "���� �����Դϴ�.");
			break;
		case 9: case 10: case 11:
			season = "����";
//			System.out.println(month + "���� �����Դϴ�.");
			break;
		default :
			season = "�߸� �Էµ� ��";
//			System.out.println(month + "���� �߸� �Էµ� ���Դϴ�.");
		}
		System.out.println(month + "���� " + season + "�Դϴ�.");
	}
	
	public void practice5() {
		String id = "myId";
		String pw = "myPassword12";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String userId = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String userPw = sc.nextLine();
		
		if (userId.equals(id) && userPw.equals(pw)) {
			System.out.println("�α��� ����");
		} else if (userId.equals(id)) {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		} else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		String grade = sc.nextLine();
		
		if("������".equals(grade)) {
			System.out.println("ȸ������, �Խñ� ����, �Խñ� �ۼ�, ��� �ۼ�, �Խñ� ��ȸ");
		} else if ("ȸ��".equals(grade)) {
			System.out.println("�Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
		} else {
			System.out.println("�Խñ� ��ȸ");
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();
		System.out.print("������(kg)�� �Է��� �ּ��� : ");
		double weight = sc.nextDouble();
		
		double BMI = weight / (height * height);
		System.out.println("BMI ���� : " + BMI);

		if(BMI < 18.5) {
			System.out.println("��ü��");
		} else if(BMI >= 18.5 && BMI < 23) {
			System.out.println("����ü��");
		} else if(BMI >= 23 && BMI < 25) {
			System.out.println("��ü��");
		} else if(BMI >= 25 && BMI < 30) {
			System.out.println("��");
		} else {
			System.out.println("�� ��");
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		char op = sc.next().charAt(0);
		
		double first = num1;
		double second = num2;
		
		double result = 0;
		
		if(num1 > 0 && num2 > 0) {
			switch(op) {
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
				result = first / second;
				break;
			case '%':
				result = first % second;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			}
			System.out.printf("%d %c %d = %f", num1, op, num2, result);
		} else {
			System.out.println("����� �Է����ּ���.");
		}
		
	}
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰� ��� ���� : ");
		int mid = sc.nextInt();
		System.out.print("�⸻ ��� ���� : ");
		int fin = sc.nextInt();
		System.out.print("���� ���� : ");
		int work = sc.nextInt();
		System.out.print("�⼮ ȸ�� : ");
		int att = sc.nextInt();
		System.out.println("================ ��� ================= ");
		
		double mid1 = (double)mid * 0.2;
		double fin1 = (double)fin * 0.3;
		double work1 = (double)work * 0.3;
		double att1 = att;
		double sum = mid1 + fin1 + work1 + att1;
		// 70�� �̻��� ��� Pass, 70�� �̸��̰ų� ��ü ���ǿ� 6�� �̻�(30% �̻�) �Ἦ �� Fail
		
//		if(sum >= 70) {
//			System.out.println("�߰� ��� ����(20) : " + mid1);
//			System.out.println("�⸻ ��� ����(30) : " + fin1);
//			System.out.println("���� ����           (30) : " + work1);
//			System.out.println("�⼮ ����           (20) : " + att1);
//			System.out.println("���� : " + sum);
//			System.out.println("Pass");
//		} else if(att < 15) {
//			System.out.println("Fail [�⼮ ȸ�� ���� (" + att + "/20)]");
//		} else {
//			System.out.println("�߰� ��� ����(20) : " + mid1);
//			System.out.println("�⸻ ��� ����(30) : " + fin1);
//			System.out.println("���� ����           (30) : " + work1);
//			System.out.println("�⼮ ����           (20) : " + att1);
//			System.out.println("���� : " + sum);
//			System.out.println("Fail [���� �̴�]");
//		}
		
		if(att < 15) {
			System.out.println("Fail [�⼮ ȸ�� ���� (" + att + "/20)]");
		} else { 
			System.out.println("�߰� ��� ����(20) : " + mid1);
			System.out.println("�⸻ ��� ����(30) : " + fin1);
			System.out.println("���� ����           (30) : " + work1);
			System.out.println("�⼮ ����           (20) : " + att1);
			System.out.println("���� : " + sum);
			
			if(sum >= 70) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail [���� �̴�]");
			}
		}
		
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		System.out.print("���� : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
	}

}
