package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {

		User u1 = new User();		//User()�� �޼ҵ�, Ŭ���� �̸��� ������ ������, �Ű������� ������ �⺻��������
//		u1.inform();
		
//		�Ʒ� ����ó�� �Ű����� �ִ� �����ڸ� ���� ����鼭 ���ÿ� �ʱ�ȭ �ϰڴٴ� ��
//		int[] arr = new int[3]; // 0 0 0
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		// 1 2 3
//		
//		int[] arr2 = {1, 2, 3}; // 1 2 3
		
		User u2 = new User("user01" , "pass01", "���ǰ�" , new Date());
		u2.inform();
		// ������ ���ÿ� �ʱ�ȭ
		
		User u3 = new User("user02", "pass02" , "������");	// �̷��� 3���� ���� ��
		u3.inform();
		
//		User u4 = new User("user03", "pass03");	  // ����� ���� ������ �ƹ��ų� ���� ��
//		u4.inform();
	}

}
