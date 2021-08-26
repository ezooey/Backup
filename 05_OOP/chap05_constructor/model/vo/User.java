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
	
	// ������ ��� ����
	//		��ü�� �����ϸ鼭 �ʵ� �ʱ�ȭ�ϱ� ���� ���
	
	// ������ Ư¡
	//		1. ������ ���� Ŭ���� ��� ����
	//		2. ��ȯ�� �������� ����
	// �⺻ ������
	//		�ƹ� �Ű������� ���� ������
	//		������ �ʾƵ� JVM�� �⺻������ ��������
	//		�⺻ �����ڰ� ���� ���¿��� �Ű����� �ִ� �����ڸ� ������ָ� �⺻�����ڴ� �ڵ����� �������� ����
	
//	public User() {} // �ٷιٷ� �ʱ�ȭ ��Ű�鼭 ��ü�� ������� �Ŵϱ� �⺻ �����ڸ�! �� ������ �ϸ� u1���� ������
					 // �׷��ϱ� �׳� ����ó�� �⺻ ������ �־��ִ� �� ����
	public User() {}
	
	// �Ű����� �ִ� ������
	//		�Ű������� �ִ� ������
	//		�Ѱ� ���� �Ű������� �̿��Ͽ� �ʵ� �ʱ�ȭ
	
//	public User(String id, String pwd, String name, Date enrollDate, Date editDate) {
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		this.enrollDate = enrollDate;
//		this.editDate = editDate;
//	}
	
	// ������ ���̱� (10�� 40��)
	public User(String userId, String userPwd, String userName, Date enrollDate) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd, userName);	// String�� �� ���� �Ʒ��� �����ڸ� �ҷ��� ����
		this.enrollDate = enrollDate;
	}
	
	public User(String userId, String userPwd, String userName) {
//		this.userId = userId;
//		this.userPwd = userPwd;
		this(userId, userPwd);		// �ݵ�� ù�ٿ� ���´�
		this.userName = userName;
	}
	
	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
//	
//	public User(String id, String name) {	// ���� �Ű����� ����, Ÿ��, Ÿ���� ������ ����(�����ε� �Ұ�)
//		userId = id;
//		userName = name;
//	}
	
	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}
}
