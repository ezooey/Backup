package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: addList(); break;
			case 2: addAtZero(); break;
			case 3: printAll(); break;
			case 4: searchMusic(); break;
			case 5: removeMusic(); break;
			case 6: setMusic(); break;
			case 7: ascTitle(); break;
			case 8: descSinger(); break;
			case 9: System.out.println("종료"); return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		// 곡명과 가수명을 사용자에게 입력 받는다.
		// MusicController에 addList()를 이용해서 입력한 정보를 넘기고
		// 추가 성공 시 "추가 성공", 추가 실패 시 "추가 실패" 콘솔창에 출력
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		Music music = new Music(title, singer);
		int result = mc.addList(music);
		if(result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
		System.out.println();
	}
	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		// 곡명과 가수명을 사용자에게 입력 받는다.
		// MusicController에 addAtZero()를 이용해서 입력한 정보를 넘기고
		// 추가 성공 시 "추가 성공", 추가 실패 시 "추가 실패" 콘솔창에 출력
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		Music music = new Music(title, singer);
		int result = mc.addAtZero(music);
		if(result == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
		
	}
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		// MusicController에 printAll() 반환 값을 출력한다.
		List<Music> list = mc.printAll();
		if(list == null) {
			System.out.println("곡 목록이 없습니다.");
		} else {
			System.out.println(mc.printAll());
		}
		System.out.println();

	}
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		// 사용자에게 곡 이름을 받고 MusicController에 있는 searchMusic으로 값을 넘긴다.
		// searchMusic()의 반환 값에 따라 반환 값이 없으면 "검색한 곡이 없습니다."
		// 반환 값이 있으면 "검색한 곡은 000(곡명, 가수명) 입니다." 콘솔 창에 출력
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		if(mc.searchMusic(title) == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println("검색한 곡은 " + mc.searchMusic(title) + "입니다.");
		}
		System.out.println();

	}
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		// 사용자에게 삭제할 곡의 이름을 직접 받고 MusicController에 removeMusic으로 값을 넘긴다.
		// removeMusic()의 반환 값에 따라 반환 값이 없으면 "삭제할 곡이 없습니다."
		// 반환 값이 있으면 "000(곡명, 가수명)을 삭제했습니다" 콘솔 창에 출력
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		Music music = mc.searchMusic(title);
		if(mc.searchMusic(title) == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			mc.removeMusic(title);
			System.out.println(music + "을(를) 삭제했습니다.");
		}
		System.out.println();

	}
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		// 사용자에게 수정할 곡명과 가수명을 받아  MusicController에 setMusic으로 값을 넘긴다.
		// 검색 결과 값이 없으면 "수정할 곡이 없습니다."
		// 검색 결과 값이 있으면 "000(곡명, 가수명)의 값이 변경되었습니다" 콘솔 창에 출력
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String setTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String singer = sc.nextLine();
		Music before = new Music(title, singer);
		Music music = new Music(setTitle, singer);
		
		if(mc.setMusic(title, music) == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			mc.setMusic(title, music); // 수정 전의 title로 검색하고 music 자리에 새로운 곡명과 가수명을 넣는다
			System.out.println(before + "의 값이 변경되었습니다.");
		}
		System.out.println();
		
	}
	public void ascTitle() {
		// ****** 곡 명 오름차순 정렬 ******
		// MusicController에 ascTitle()의 값에 따라 성공 시 "정렬 성공", 실패 시 "정렬 실패"
		if(mc.ascTitle() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}

		
	}
	public void descSinger() {
		// ****** 곡 명 내림차순 정렬 ******
		// MusicController에 descSinger()의 값에 따라 성공 시 "정렬 성공", 실패 시 "정렬 실패"
		if(mc.descSinger() == -1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}


	}
	

}
