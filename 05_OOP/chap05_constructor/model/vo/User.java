package com.kh.example.chap05_constructor.model.vo;

import java.util.Date;

public class User {
//	- userId:String
//	- userPwd:String
//	- userName:String
//	- enrollDate:Date(java.util)
	
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	
	// 생성자 사용 목적
	//		객체를 생성하면서 필드 초기화하기 위해 사용
	
	// 생성자 특징
	//		1. 생성자 명은 클래스 명과 동일
	//		2. 반환형 존재하지 않음
	// 기본 생성자
	//		아무 매개변수가 없는 생성자
	//		써주지 않아도 JVM이 기본적으로 생성해줌
	//		기본 생성자가 없는 상태에서 매개변수 있는 생성자만 만들어주면 기본생성자는 자동으로 생성되지 않음
	
//	public User() {} // 바로바로 초기화 시키면서 객체를 만들어줄 거니까 기본 생성자만! 안 쓰려고 하면 u1에서 에러남
					 // 그러니까 그냥 습관처럼 기본 생성자 넣어주는 게 좋다
	public User() {}
	
	// 매개변수 있는 생성자
	//		매개변수가 있는 생성자
	//		넘겨 받은 매개변수를 이용하여 필드 초기화
	
//	public User(String id, String pwd, String name, Date enrollDate, Date editDate) {
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		this.enrollDate = enrollDate;
//		this.editDate = editDate;
//	}
	
	// 가독성 높이기 (10시 40분)
	public User(String userId, String userPwd, String userName, Date enrollDate) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd, userName);	// String이 세 개인 아래의 생성자를 불러온 것임
		this.enrollDate = enrollDate;
	}
	
	public User(String userId, String userPwd, String userName) {
//		this.userId = userId;
//		this.userPwd = userPwd;
		this(userId, userPwd);		// 반드시 첫줄에 적는다
		this.userName = userName;
	}
	
	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
//	
//	public User(String id, String name) {	// 위랑 매개변수 개수, 타입, 타입의 순서도 같다(오버로딩 불가)
//		userId = id;
//		userName = name;
//	}
	
	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}
}
