package com.kh.example.chap03_user.controller;

import java.util.Scanner;

import com.kh.example.chap03_user.model.exception.MyException;

public class UserExceptionController {
	public void inputAge() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		try {
			checkAge(age);
		} catch (MyException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage()); // "입장불가"메세지
		}

	}
	public void checkAge(int age) throws MyException {
		if(age < 19) {
			throw new MyException("입장 불가"); // Exception에서 메세지 역할을 함ㄴ
		} else {
			System.out.println("즐거운 관람되시길 바랍니다.");
		}
	}
}
