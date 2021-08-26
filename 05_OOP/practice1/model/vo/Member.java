package com.kh.example.practice1.model.vo;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;				// 실제로 이름을 저장할 공간
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public void changeName(String name) {	// 내가 받아온 값
		memberName = name;					// 내가 받아온 값을 memberName에 저장
	}
	
	public void printName() {
		System.out.println("name : " + memberName);
	}

}
