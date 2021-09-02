package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private BookController bc = new BookController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		System.out.println();
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			int menuNum = sc.nextInt();		// 여기서 친 엔터가 자꾸 아래 스캐너로 내려오니 주의하자
			sc.nextLine();
			
			switch(menuNum) {
			case 1: insertBook(); break;
			case 2: selectList(); break;
			case 3: searchBook(); break;
			case 4: deleteBook(); break;
			case 5: ascBook(); break;
			case 9: System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
		
	}
	public void insertBook() {
		System.out.println("===== 새 도서 추가 =====");
		System.out.println("책 정보를 입력해주세요.");
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("장르(1. 인문 / 2. 과학 / 3. 외국어 / 4. 기타) : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		String category = null;
		switch(num) {
		case 1: category = "인문"; break;
		case 2: category = "과학"; break;
		case 3: category = "외국어"; break;
		case 4: category = "기타"; break;
		}
		
		Book bk = new Book(title, author, category, price);
		bc.insertBook(bk);
		
	}
	public void selectList() {
		// 1. bc(BookController)의 selectList() 메소드를 호출 후
		// --> 결과 값을 임의의 리스트(ArrayList<Book> bookList)에 대입
		// 2. 조건식 이용해서
		//	2_1. bookList가 "비어있는 경우" --> "존재하는 도서가 없습니다." 라는 알람 문구 출력
		//	2_2. bookList가 "비어있지 않은 경우" --> 반복문을 통해 bookList 안의 Book 객체들 출력
		System.out.println("===== 도서 전체 조회 =====");
		ArrayList<Book> bookList = bc.selectList();
		if(bookList.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다");
			System.out.println();
		} else {
			for(int i = 0; i < bookList.size(); i++) {
				System.out.println("\t" + bookList.get(i));
				System.out.println();
			}
		}
	}
	public void searchBook() {
		// 1. 검색할 도서명 키워드로 입력 받기 (String keyword)
		// 2. bc(BookController)의 searchBook() 메소드로 위의 keyword 값 전달 후
		// --> 결과 값을 임의의 리스트(ArrayList<Book> searchList)에 대입
		// 결과 값이 한 도서의 Book 객체가 아니라 리스트인 이유
		// 보통 프로그램에서 검색할 때 풀네임을 쳐서 검색하지 않고 키워드로 검색
		// 즉, 키워드를 포함한 결과가 하나가 아닌 여러 개일 수 있기 때문에 리스트로 받기
		// 3. 조건식 이용해서
		// 	3_1. searchList가 "비어있는 경우" --> "검색 결과가 없습니다."라는 알람 문구 출력
		//	3_2. searchList가 "비어있지 않은 경우" --> 반복문으로 searchList 안의 Book 객체들 출력
		System.out.println("===== 도서 검색 =====");
		System.out.print("검색 키워드 : ");
		String keyword = sc.nextLine();
		ArrayList<Book> searchList = bc.searchBook(keyword);
		if(searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
			System.out.println();
		} else {
			for(int i = 0; i < searchList.size(); i++) {
				System.out.println("\t" + searchList.get(i));
				System.out.println();
			}
		}
	}
	public void deleteBook() {
		// 1. 삭제할 도서명 입력 받기 (String title)
		// 2. 삭제할 저자명 입력 받기 (String author)
		// 도서명과 저자명을 같이 입력 받는 이유
		// --> 같은 도서명이라고 해도 저자명이 다른 도서가 있을 수 있기 때문에
		// 3. bc(BookController)의 deleteBook() 메소드로 위의 title, author 값 전달 후
		// --> 결과 값을 임의의 Book(Book remove)에 대입
		// 4. 조건식 이용해서
		//	4_1. remove가 존재하는 경우 --> "성공적으로 삭제되었습니다."라는 문구 출력
		//	4_2. remove가 존재하지 않는 경우 --> "삭제할 도서를 찾지 못했습니다."라는 문구 출력
		System.out.println("===== 도서 삭제 =====");
		System.out.print("삭제할 도서 명 : ");
		String title = sc.nextLine();
		System.out.print("삭제할 저자 명 : ");
		String author = sc.nextLine();
		
		Book remove = bc.deleteBook(title, author);
		if(remove != null) {
			System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
		
	}
	public void ascBook() {
		// 도서명 오름차순 정렬용 view 메소드
		System.out.println("정렬에 성공하였습니다.");
		System.out.println();
		int result = bc.ascBook();
	}

}
