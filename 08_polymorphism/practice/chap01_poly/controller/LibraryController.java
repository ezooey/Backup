package com.kh.practice.chap01_poly.controller;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	public void insertMember(Member mem) {
		// 전달받은 mem 주소 값을 해당 회원 레퍼런스(mem)에 대입
		this.mem = mem;
	}
	public Member myInfo() {
		// 회원 레퍼런스(mem) 주소 값 리턴
		return mem;
	}
	public Book[] selectAll() {
		return bList;
	}
	public Book[] searchBook(String keyword) {
		Book[] bookArr = new Book[bList.length]; // 검색 결과를 담아줄 새로운 Book 객체 배열 생성
		int count = 0;
		
		for(int i = 0; i < bookArr.length; i++) {
				if(bList[i].getTitle().contains(keyword)) { // bList 도서 목록들의 도서명과 전달받은 keyword 비교
					bookArr[count++] = bList[i];
				}
		}
		return bookArr;
	}
	
	public int rentBook(int index) {
		int result = 0;
		if(bList[index] instanceof AniBook) {
			if(((AniBook)bList[index]).getAccessAge() > mem.getAge()) {
				result = 1;
			}
		}
		
		if(bList[index] instanceof CookBook) {
			if(((CookBook)bList[index]).getCoupon() == true) {
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}
		
		return result;
	}
	
}
