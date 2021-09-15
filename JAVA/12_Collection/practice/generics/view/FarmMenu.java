package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: adminMenu(); break;
			case 2: customerMenu(); break;
			case 9: System.out.println("프로그램 종료"); return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("=====***** 직원 메뉴 *****=====");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: addNewKind(); break;
			case 2: removeKind(); break;
			case 3: changeAmount(); break;
			case 4: printFarm(); break;
			case 9: return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void customerMenu() {
		// 현재 KH마트 농산물 수량부터
		
		while(true) {
			System.out.println("현재 KH마트 농산물 수량");
			printFarm();
			System.out.println();
			System.out.println("=====***** 고객 메뉴 *****=====");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1: buyFarm(); break;
			case 2: removeFarm(); break;
			case 3: printBuyFarm(); break;
			case 9: return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addNewKind() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			int num = sc.nextInt();
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			
			
			Farm f = null;
			switch(num) {
			case 1: f = new Fruit("과일", name); break;
			case 2: f = new Vegetable("채소", name); break;
			case 3: f = new Nut("견과", name); break;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			boolean check = fc.addNewKind(f, amount);
			
			if(check) {
				System.out.println("새 농산물이 추가되었습니다."); // true
				return;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요."); // false
			}
				
		}
	}
	
	public void removeKind() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			Farm f = null;
			switch(num) {
			case 1: f = new Fruit("과일", name); break;
			case 2: f = new Vegetable("채소", name); break;
			case 3: f = new Nut("견과", name); break;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			
			boolean check = fc.removeKind(f);
			
			if(check) {
				System.out.println("농산물 삭제에 성공하였습니다."); // true
				return;
			} else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요."); // false
			}
		}
	}
	
	public void changeAmount() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			int num = sc.nextInt();
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수정할 수량 : ");
			int amount = sc.nextInt();
			sc.nextLine();
			
			Farm f = null;
			switch(num) {
			case 1: f = new Fruit("과일", name); break;
			case 2: f = new Vegetable("채소", name); break;
			case 3: f = new Nut("견과", name); break;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			
			boolean check = fc.changeAmout(f, amount);
			if(check) {
				System.out.println("농산물 수량이 수정되었습니다."); // true
				return;
			} else {
				System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요."); // false
			}
		}
	}
	
	public void printFarm() {
//		fc.printFarm();
//		keySet();
		// "종류 : 이름(n개)"
		Set<Farm> set = fc.printFarm().keySet();
		Iterator<Farm> it = set.iterator();
		while(it.hasNext()) {
			Farm f = it.next();
			System.out.println(f  + "(" + fc.printFarm().get(f) + "개)");
		}
	}
	
	public void buyFarm() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매 종류 번호 : ");
			int num = sc.nextInt();
			System.out.print("구매할 것 : ");
			String name = sc.next();
			sc.nextLine();
			
			Farm f = null;
			switch(num) {
			case 1: f = new Fruit("과일", name); break;
			case 2: f = new Vegetable("채소", name); break;
			case 3: f = new Nut("견과", name); break;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			
			boolean check = fc.buyFarm(f);
			if(check) {
				System.out.println("구매에 성공하였습니다."); // true
				return;
			} else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요."); // false
			}
		}
	}
	
	public void removeFarm() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소 종류 번호 : ");
			int num = sc.nextInt();
			System.out.print("구매 취소할 것 : ");
			String name = sc.next();
			sc.nextLine();
			
			Farm f = null;
			switch(num) {
			case 1: f = new Fruit("과일", name); break;
			case 2: f = new Vegetable("채소", name); break;
			case 3: f = new Nut("견과", name); break;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			
			boolean check = fc.removeFarm(f);
			if(check) {
				System.out.println("구매 취소에 성공하였습니다."); // true
				return;
			} else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요."); // false
			}
		}
	}
	
	public void printBuyFarm() {
//		Iterator
//		fc.printBuyFarm();
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
