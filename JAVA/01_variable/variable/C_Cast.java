package com.kh.variable;

public class C_Cast {
	/*
	 	����ȯ : ���� �ڷ����� �ٸ� �ڷ������� ��ȯ�ϴ� ��(�ٲٴ� ��)
	  
	  	���� ����ȯ�� �� ���� �տ� �ٲ� �ڷ����� ����ϴ� ���� ��Ģ
	 		(�ٲ� �ڷ���)��	or	(�ٲ� �ڷ���)����
	 	�ڵ� ����ȯ������ �ڷ��� ��ø� ������ �� ������
	 	���� ����ȯ������ �ʼ������� ����ؾ� �� 
	 */
	
	public void rule1() {
		boolean flag = true;
//		flag = 100; boolean �ڷ����� ������ true/false�� �� �� ���� = ����ȯ ����
		
//		�ڵ� ����ȯ : ũ�Ⱑ ���� �ڷ����� ū �ڷ������� �ٲ�� ��
//		ex. byte->int, int->long, int->double, long->float, char->int
		int num = 'A'; //�׷��ٰ� ���ڿ� ""�� �� ��! char�� �Ǵ� ��
		System.out.println("num : " + num);
		
		char ch = 97; //�����ϱ� �⺻���� int, ���ͷ�(���� �ȿ� �ִ� ���ڸ� �޾���)
		System.out.println("ch: " + ch);
		
//		char ch2 = -97; // char�� ������ 0~65535, ����� �����ϱ� ������ ���� �Ұ���
		
//						  num�� 4byte¥�� ����, 'A'�� �������� 65�ϱ� char �ȿ��� �޾��� �� �ִ� ���̶� 4byte��� Ʋ�� ũ�⸸ �Ǵ�
		char ch2 = (char) num; // ���� ����ȯ = ����� ����ȯ
		System.out.println("ch2 : " + ch2);
		
		int num2 = -97;
		char ch3 = (char)num2; //char�� �������� �� �ϴ� ������ �� ������ ������ ũ�Ⱑ �߿��ϱ� ������ ����x
		System.out.println("ch3 : " + ch3);
		// ?�� ���� ������ ��ü�� ����ǥ�� �ƴ϶�, -97�� ���� ���ڸ� ã�� �� �ؼ� ������ ����
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100L;
		
//		int iSum = iNum + lNum;
		//			int	   long
		//�ڵ�����ȯ	long   long
		// 				long
		//�ڵ�����ȯ �� long���� int�� �����Ϸ��� �ϴ� �������� ��
		
		// ��� 1 : ���� ����� long �ڷ������� �ޱ�
		long lsum = iNum + lNum;
		System.out.println("lsum : " + lsum);
		
		// ��� 2 : long���� int������ ���� ����ȯ
		int iNum1 = iNum + (int)lNum;
		System.out.println("iNum1 : " + iNum1);
		
		// ��� 3 : ���� ����� int�� ���� ����ȯ
		int iNum2 = (int)(iNum + lNum);
		System.out.println("iNum2 : " + iNum2);
	}
}
