package com.kh.example.chap01_encapsulation;

public class Run {
	public static void main(String[] args) {
		Account a = new Account();
		
		a.displayBalance(); // �޼ҵ� ��ü�� �ƹ��͵� ���� �ʾƼ� ������ ��� ��ȣ ���� �Ȱ��� ������� ��
		
		a.deposit(1000000); // �޼ҵ忡 int money�� �ְڴٰ� ������ �־�� �� (���� 2�� 33����)
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
