package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice2() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 - i;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice4() {
		String[] arr = new String[5];
		arr[0] = "���";
		arr[1] = "��";
		arr[2] = "����";
		arr[3] = "������";
		arr[4] = "����";

		System.out.print(arr[1]);
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.next();
		System.out.print("���� : ");
		char ch = sc.next().charAt(0);

//		String[] arr = new String[str.length()]; 
		char[] chArr = new char[str.length()];

		int j = 0;
		System.out.print(str + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");
		for (int i = 0; i < str.length(); i++) {
//			char ch1 = str.charAt(i);
//			if(ch == ch1) {
			chArr[i] = str.charAt(i); // char�� �����ָ� �ٷ� charAt ���� ����
			if (ch == chArr[i]) {
				System.out.print(i + " ");
				j++; // �Է��� ���ڰ� ã�� ���ڿ� ������ ������ j�� 1�� Ŀ��
			}
		}
		System.out.println();
		System.out.print(ch + " ���� : " + j);
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("0 ~ 6 ���� ���� �Է� : ");
		int num = sc.nextInt();

		String[] strArr = { "��", "ȭ", "��", "��", "��", "��", "��" };
		if (num >= 0 && num < 7) {
			System.out.println(strArr[num] + "����");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

//		System.out.print("�迭 0��° �ε����� ���� �� : ");
//		int num0 = sc.nextInt();
//		System.out.print("�迭 1��° �ε����� ���� �� : ");
//		int num1 = sc.nextInt();
//		System.out.print("�迭 2��° �ε����� ���� �� : ");
//		int num2 = sc.nextInt();
//		System.out.print("�迭 3��° �ε����� ���� �� : ");
//		int num3 = sc.nextInt();
//		System.out.print("�迭 4��° �ε����� ���� �� : ");
//		int num4 = sc.nextInt();
//			
//		arr[0] = num0;
//		arr[1] = num1;
//		arr[2] = num2;
//		arr[3] = num3;
//		arr[4] = num4;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("�迭 " + i + "��° �ε����� ���� �� : ");
			arr[i] = sc.nextInt();
		}

		int j = 0;
//		for(int i = 0; i < arr.length; i++) {
		for (int i = 0; i < arr.length; i++) {
			j += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.print("�� �� : " + j);
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		
//		while (true) {
//			System.out.print("���� : ");
//			int num = sc.nextInt();
//
//			int div = num / 2;
//			int minus = num - 2;
//
//			if (num >= 3 && num % 2 != 0) {
//				int[] arr = new int[num];
//				for (int i = 0; i <= div; i++) {
//					arr[i] = (i + 1);
//					System.out.print(arr[i] + ", ");
//				}
//				System.out.print(arr[i] + ", ");
//				for (int i = div + 1; i <= minus; i++) {
//					for(int j = div; j >= 2; j--){
//					arr[i] = j;
//					}
//					System.out.print(arr[i] + ", ");
//				}
//				System.out.print("1");
//				break;
//			} else {
//				System.out.println("�ٽ� �Է��ϼ���.");
//			}
//		}
		
		int[] arr;
		while (true) {
			System.out.print("���� : ");
			int num = sc.nextInt();

			int div = num / 2;

			if (num >= 3 && num % 2 != 0) {
				arr = new int[num];
				for (int i = 0; i <= div; i++) {
					arr[i] = (i + 1);			// arr[0]~[div]���� �濡 ����ֱ⸸ ��
				}
				for (int i = div + 1; i < arr.length; i++) { // �ε����� ���� ������ 1 �����ϱ� 1 ���ؼ� �������
					arr[i] = num - i;			// i�� 1�� Ŀ���� �� ���� num���� ���� 1�� �پ��� ��
				}								// arr[div+1]~arr[num-1]���� �濡 ����־���
				break;
			} else {
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
		for(int i = 0; i < arr.length; i++) {	// ���⼭���� ������ ������ ���� �������
			if(i == arr.length - 1) {
				System.out.print(arr[i]); 	// 1���� �����ϴٰ� ���ǿ� �´� ������ ���ڸ��� ���. �ڿ� ��ǥ ����
			} else {
				System.out.print(arr[i] + ", "); // 1���� ������ ���� �տ� ��µ�. ��ǥ ����
			}
		}
	}
	
	public void practice9() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
//		String menu = sc.nextLine();
//		
//		String[] strArr = {"�Ķ��̵�", "���", "����", "����", "�Ĵ�"};
//		for(int i = 0; i < strArr.length; i++) {
//			if(strArr[i].equals(menu)) {
//				System.out.println(menu + "ġŲ ��� ����");
//			} else if(!strArr[i].equals(menu)) {
//				System.out.println(menu + "ġŲ�� ���� �޴��Դϴ�.");
//			}
//		}
//	
		Scanner sc = new Scanner(System.in);
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String menu = sc.nextLine();
		String[] arr = {"�Ķ��̵�", "���", "����", "����", "�Ĵ�"};

		boolean possible = false;			// �� �𸣰����� ���� ���� ���� ��
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(menu)) {
				possible = true;
				break;
			}
		}
		if(possible) {
			System.out.println(menu + "ġŲ ��� ����");
		} else {
			System.out.println(menu + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String pId = sc.nextLine();
		
//		String[] arr = {pId};
//		String[] copyArr = new String[arr.length];
		

		char[] arr = new char[pId.length()];
		char[] copyArr = new char[pId.length()];
		
		for(int i = 0; i < pId.length(); i++) {
			arr[i] = pId.charAt(i);
			
//			if(i <= 7) {
//				copyArr[i] = arr[i];
//			} else {
//				copyArr[i] = '*';
//			}
			System.arraycopy(arr, 0, copyArr, 0, 8);
			if(i >= 8) {
				copyArr[i] = '*';
			}
			System.out.print(copyArr[i]);
		}
	}
	
	public void practice11() {
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		int[] arr = new int[10];
		int max = 1;
		int min = 10;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			if(arr[i] > max) {
				max = arr[i];
//				arr[i] = max; ��� ���� �ʰ� �������� (������ ���� max �ϳ��� ������ ���ϵŹ���)
			}
			if(arr[i] < min) {
				min = arr[i];
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
	}
	
	public void practice13() {
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {	// ���� arr[i]�� arr[j]���� ������
					i--;				// �ߺ��� ���� arr[i]�� �ǵ��� for���� ó������ �����, ���� �����
					break;				// (i���� ���� 3�̸� �������鼭 4�� �ƴµ� �ٽ� 3���� ���ư��� �ٽ� �ϰ� ��)
				}						// �̶� i���� j�� ���� ���̹Ƿ� arr[i]�� �ٽ� �ʱ�ȭ�ϴ� ��
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}			
//		ȥ�� �ϴٰ� ��ģ ��
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 10 + 1);
//			for(int j = 0; j < i; j++) {
//				if(i < j && arr[i] == arr[j]) {
//					arr[j] = (int)(Math.random() * 10 + 1);
//				} else if (i < j && arr[i] != arr[j]) {
//					arr[j] = arr[j];
//				}
////			break;
//			System.out.print(arr[i] + " ");
	
	
	public void practice14() {
		int[] arr = new int[6];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
				if(arr[j] > arr[i]) {
//					arr[i] = arr[j];	// �ڸ� �ٲٱ�
					int temp = arr[i];	// arr[i]���� �ӽ÷� temp������ ��´�
					arr[i] = arr[j];	// arr[i]�ڸ��� arr[j]���� �ִ´�
					arr[j] = temp;		// arr[j]�ڸ��� temp���� �ִ´�
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		char ch = sc.nextLine().charAt(0);
		
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = ch;
		}
		
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt();
		System.out.print("1��° ���ڿ� : ");
		String first = sc.nextLine();
		System.out.print("2��° ���ڿ� : ");
		String second = sc.nextLine();
		System.out.print("3��° ���ڿ� : ");
		String third = sc.nextLine();
		
		int[] arr = new int[size];
	}
}
