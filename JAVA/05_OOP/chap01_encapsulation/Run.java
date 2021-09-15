package com.kh.example.chap01_encapsulation;

public class Run {
	public static void main(String[] args) {
		Account a = new Account();
		
		a.displayBalance(); // 메소드 자체에 아무것도 쓰지 않아서 정의한 대로 괄호 안을 똑같이 비워놔야 됨
		
		a.deposit(1000000); // 메소드에 int money를 넣겠다고 했으니 넣어야 함 (강의 2시 33분쯤)
		a.displayBalance();
		
		a.deposit(1500000);
		a.displayBalance();
		
		a.withdraw(500000);
		a.displayBalance();
		
//		a.balance -= 5000000;
		// The field Account.balance is not visible
		
		a.withdraw(100000);
		a.displayBalance();
	}

}
