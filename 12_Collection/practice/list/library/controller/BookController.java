package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.practice.list.library.model.vo.Book;

public class BookController {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookController() {
		bookList.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		bookList.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		bookList.add(new Book("대화의 기술", "강보람", "인문", 17500));
		bookList.add(new Book("암 정복기", "박신우", "의료", 21000));
	}
	public void insertBook(Book bk) {
		// 전달 받은 bk를 bookList에 추가
		
		bookList.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		// 해당 bookList의 주소 값 반환
		return bookList;
	}
	
	public ArrayList<Book> searchBook(String keyword){
		// 반복문을 통해 list의 책 중 도서명에 전달 받은 keyword가 포함되어 있는 경우
		// searchList에 해당 책 추가하고 searchList 반환
		ArrayList<Book> searchList = new ArrayList<Book>();
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				searchList.add(bookList.get(i));
			}
		}
		
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		// 삭제된 도서를 담을 Book객체 (Book removeBook) 선언 및 null로 초기화
		// 반복문을 통해 bookList의 책 중 도서명이 전달 받은 title과 동일하고
		// 저자명이 전달 받은 author와 동일한 경우 해당 인덱스 도서 삭제 후 빠져나감
		// 이때 해당 인덱스 도서를 removeBook에 대입 후 removeBook 반환
//		Book removeBook = new Book();
//		removeBook = null;
		Book removeBook = null;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(title) && bookList.get(i).getAuthor().equals(author)) {
				removeBook = bookList.remove(i);
				break;
			}
		}
		
		return removeBook;
	}
	
	public int ascBook() {
		// 책 이름으로 오름차순 후 1 반환
		Collections.sort(bookList);
		return 1;
	}

}
