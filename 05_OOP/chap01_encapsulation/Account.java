package com.kh.example.chap01_encapsulation;

public class Account {
	private String name = "박신우";
	private String phone = "010-1111-2222";
	private String pwd = "q1w2e3";
	private int bankCode = 3030;
	private int balance = 0; // 잔액
	
	// 입금을 위한 메소드
	public void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name +"님의 계좌에 " + money +"원이 입금되었습니다.");
		} else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
	}
	// 출금을 위한 메소드
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.println(name + "님의 계좌에서 " + money + "원이 출금되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
	}
	
	// 잔액 조회를 위한 메소드
	public void displayBalance() {
		System.out.println(name + "님의 계좌에 잔액은 " + balance + "원입니다.");
	}

}
