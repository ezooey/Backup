package com.kh.view;

import java.util.Scanner;

import com.kh.controller.EmployeeController;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		EmployeeController ec = new EmployeeController();
		
		int user = 0;
		
		do {
			System.out.println("=========================");
			System.out.println("[Main Menu]");
			System.out.println("1. ��ü ��� ���� ��ȸ");
			System.out.println("2. ������� ��� ���� ��ȸ");
			System.out.println("3. ���ο� ��� ���� �߰�");
			System.out.println("4. ������� ��� ���� ����");
			System.out.println("5. ������� ��� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.println("=========================");
			System.out.print("�޴� ���� : ");
			user = Integer.parseInt(sc.nextLine());
			
			switch(user) {
			case 1: ec.selectAll(); break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: System.out.println("�����մϴ�."); break;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			System.out.println();
		} while(user != 0);
	}
	

}
