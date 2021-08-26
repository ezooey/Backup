package com.kh.homework.shape.view;

import java.util.Scanner;

import com.kh.homework.shape.controller.ShapeController;
import com.kh.homework.shape.model.vo.Shape;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	ShapeController spr = new ShapeController();
	
	public void inputMenu() {
		while(true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			switch(menuNum) {
			case 3:
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
	}
	public void triangleMenu() {
		
		while(true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: 
				inputData(3, menuNum);
				break;
			case 2:
				inputData(3, menuNum);
				break;
			case 3:
				printInform(3);
				break;
			case 9:
				spr.calcArea(0, 0, 0);
				spr.paintColor("white");
				System.out.println("메인메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
		
	}
	public void squareMenu() {
		while(true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			switch(menuNum) {
			case 1:
				inputData(4, menuNum);
				break;
			case 2:
				inputData(4, menuNum);
				break;
			case 3:
				inputData(4, menuNum);
				break;
			case 4:
				printInform(4);
				break;
			case 9:
				spr.calcArea(0, 0, 0);
				spr.paintColor("white");
				System.out.println("메인메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			}
		}
		
	}
	public void inputData(int type, int menuNum) {
		if(type == 3) {
			switch(menuNum) {
			case 1:
				if(menuNum == 1) {
					System.out.print("높이 : ");
					double height = Double.parseDouble(sc.nextLine());
					System.out.print("너비 : ");
					double width = Double.parseDouble(sc.nextLine());
					
					System.out.println("면적 : " + spr.calcArea(type, height, width));
				}
				break;
			case 2:
				System.out.print("색깔 : ");
				String color = sc.nextLine();
				spr.paintColor(color);
				System.out.println("색이 설정되었습니다.");
				break;
			}
		} else {
			switch(menuNum) {
			case 1: case 2:
				System.out.print("높이 : ");
				double height = Double.parseDouble(sc.nextLine());
				System.out.print("너비 : ");
				double width = Double.parseDouble(sc.nextLine());
				
				
				if(menuNum == 1) {
					System.out.println("둘레 : " + spr.calcPerimeter(type, height, width));
				} else {
					System.out.println("면적 : " + spr.calcArea(type, height, width));
				}
				break;
			case 3:
				System.out.print("색깔 : ");
				String color = sc.nextLine();
				spr.paintColor(color);
				System.out.println("색이 설정되었습니다.");
				break;
			}
		}
	}
	public void printInform(int type) {
//		double area = spr.calcArea(type, 0, 0);
//		if(area == 0.0) {
//			System.out.println(spr.print(type) + "의 높이 또는 너비가 설정되지 않았습니다.");
//		} else {
			System.out.println(spr.print(type) + spr.print());
//		}
	}

}
