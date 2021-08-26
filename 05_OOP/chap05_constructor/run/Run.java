package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {

		User u1 = new User();		//User()는 메소드, 클래스 이름과 같으니 생성자, 매개변수가 없으니 기본생성자임
//		u1.inform();
		
//		아래 예시처럼 매개변수 있는 생성자를 통해 만들면서 동시에 초기화 하겠다는 뜻
//		int[] arr = new int[3]; // 0 0 0
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		// 1 2 3
//		
//		int[] arr2 = {1, 2, 3}; // 1 2 3
		
		User u2 = new User("user01" , "pass01", "강건강" , new Date());
		u2.inform();
		// 생성과 동시에 초기화
		
		User u3 = new User("user02", "pass02" , "남나눔");	// 이렇게 3개만 만들어도 됨
		u3.inform();
		
//		User u4 = new User("user03", "pass03");	  // 만들고 싶은 생성자 아무거나 만들어도 됨
//		u4.inform();
	}

}
