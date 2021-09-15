package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	// �ܵ� if��
	//		if(���ǽ�){
	//			������ ����;
	//		}
	//		���ǽ��� ��� ���� ��(true)�̸� { } �ȿ� �ִ� �ڵ� ����
	// 		���ǽ��� ��� ���� ����(false)�̸� { } �ȿ� �ִ� �ڵ� �����ϰ� �Ѿ

	// if~else��
	//		if(���ǽ�){
	//			������ ����1;
	//		} else {
	//			������ ����2;
	//		}
	//		�� �� �� ���� �����ϴ� ���ǹ�
	//		���ǽ��� ��� ���� ��(true)�̸� if �ȿ� �ִ� ���๮��1 ����
	//		���ǽ��� ��� ���� ����(false)�̸� else �ȿ� �ִ� ���๮��2 ����
	
	// if~else if~else��
	//		if(���ǽ�1){
	//			������ ����1;
	//		} else if(���ǽ�2){
	//			������ ����2;
	//		} else{
	//			������ ����3;
	//		}
	//		���� ������ �� �� �ִ� ���ǹ�
	//		if���� ���ǽ��� ������� ��(true)�̸� if �ȿ� �ִ� ���๮��1 ����
	//		if���� ���ǽ��� ������� ����(false)�̸鼭 else if���� ���ǽ� ��� ���� ��(true)�̸� else if �ȿ� �ִ� ���๮��2 ����
	//		�� �� ����(false)�̶�� ���๮��3 ����
	//		==> if������ true��� ����Ǿ����� �� �Ʒ� ������� ���ǽ��� true�� �ϴ���/�����ϴ��� ������� ����
	//		==> else if���� �������� �� �ְ�, else���� ���� ���� ����
	
	public void method1() {
		// Ű����� �Է��� ���ڰ� ������� �������� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �� �� �Է� : ");
		int num = sc.nextInt();
		
		// ���� if�� ����
//		// �������
//		if(num > 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
//		}
//		// 0����
//		if(num == 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
//		}
//		// ��������
//		if(num < 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
//		}
		
		// if-else�� ����
//		if(num > 0) {
//			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
//		} else { // num <= 0
//			// ��ø if��
//			if(num == 0) {
//				System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
//			} else {
//				System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
//			}
//		}
		
		// if-else if-else ����
		if(num > 0) {
			System.out.println("�Է��Ͻ� ���ڴ� ����Դϴ�");
		} else if (num == 0) {
			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�");
		} else {
			System.out.println("�Է��Ͻ� ���ڴ� �����Դϴ�");
		}
	}
	
//		switch(num) {
//		case num > 0 :
//		}
		// if���� switch�� �ٲٱ� ����
	
	public void method2() {
		// Ű����� �Է��� ���ڰ� ¦������ Ȧ������ ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է�: ");
		int num = sc.nextInt();
		
		// ���� if�� ����
//		if(num % 2 == 0) {
//			System.out.println("¦���Դϴ�");
//		}
//		if(num % 2 != 0) {
//			System.out.println("Ȧ���Դϴ�");
//		}
		
		// if-else�� ���� -> �������� �� �����ۿ� �����Ƿ� if-else���� �� ����
//		if(num % 2 == 1) {
//			System.out.println("Ȧ���Դϴ�");
//		} else {
//			System.out.println("¦���Դϴ�");
//		}
//		
		// if-else if-else�� ����
		if(num % 2 == 0) {
			System.out.println("¦���Դϴ�");
		} else if(num % 2 != 0) {
			System.out.println("Ȧ���Դϴ�");
		}
	}
	
	public void method3() {
		// ����ڿ��� �ֹι�ȣ�� �޾Ƽ� ���� �Ǻ�
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է�(-����) : ");
//		String str = sc.nextLine();
//		char pId = str.charAt(7);
		char pId = sc.nextLine().charAt(7);
		
		
		
//		switch(pId) {						//if���� ����ġ������ �ٲ� ��
//		case '1':
//		case '3':
//			System.out.println("�����Դϴ�");
//			break;
//		case '2': case '4':
//			System.out.println("�����Դϴ�");
//		}
				
		
		
//		if(pId == 2) {
//			System.out.println("�����Դϴ�");
//		} else {
//			System.out.println("�����Դϴ�");
//		}
		
		// ���ڸ� char�� �ٲ�� ������ �� �̻� ���ڸ� �� �� ����
		//		  ''�� �������� ǥ��!
		if(pId == '1' || pId == '3') { //������ ��� = pId 1�̳� 3�� ���
			System.out.println("�����Դϴ�");
		} else if(pId == '2' || pId == '4') {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
		}
	}
	
	public void method4() {
		// �̸��� �Է��Ͽ� �������� Ȯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = sc.nextLine();
		
//		if(name == "�ڽſ�") { // ���ڿ��� �񱳴� == ���� �Ұ���, equals()�� ����
//		if(name.equals("�ڽſ�")) { // name�� �ڽſ�� ����?
		if("�ڽſ�".equals(name)) { // name�� �ڽſ�� ����?
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("������ �ƴմϴ�");
		}
	}
}
