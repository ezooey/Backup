package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	// ���� ���� : �迭�� �ּҸ� ����
	// ���� ���� : ������ ���ο� �迭�� �ϳ� �����Ͽ� ���� ���� �� ����
	// 		1) for��		2) System.arraycopy 	3) Arrays.copyOf		4) clone (X)
	public void method1() {
		int[] originArr = {1, 2, 3, 4, 5}; // ����� ���ÿ� �ʱ�ȭ
		int[] copyArr = originArr; // ���� ����
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		// ���� �ּ� ���� ���� ��� �� ��µ�
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);	// �纻�� �ٲ㵵 �ּҴ� ����
		for(int i = 0; i < originArr.length; i++) {		// ������ ù��° ���� 99�� �ٲ����
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		// ���� �迭�� �纻 �迭�� ���� �����ϰ� �ִ� �迭�� ����(�ּ� ���� ����)
	}
	
	// ���� ����
	public void method2() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[originArr.length];	// new int[5]��� �ص� ��
		
		// for���� �̿��� ����
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];				// �����ʿ� �ִ� ���� ��, ������ ����	
		}
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		// �ٸ� �ּ� �� ��µ�
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr); // originArr : [I@5caf905d
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");	// 1 2 3 4 5 
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		// copyArr : [I@27716f4
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");		// 99 2 3 4 5 // �ȿ� �ִ� ���� �纻�� �ٲ�
		}
		
		// ���� �迭�� �纻 �迭�� ���� �����ϴ� �ִ� �迭�� �ٸ�(�ּ� ���� �ٸ�)
	}
	
	public void method3() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];			// �� ���� ������ 0�� ����
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		// System.arraycopy() �̿��� ����
//		System.arraycopy(src, srcPos, dest, destPos, length);
//			src 	: ���� �迭
//			srcPos	: ���� �迭���� ���縦 ������ ��ġ
//			dest	: ���� �迭
//			destPos : ���� �迭���� �ٿ��ֱ⸦ ������ ��ġ
//			length	: ���� ����
		
		// ���� �迭�� 0��°������ ���� �迭 ���̸�ŭ ���� ��, ���� �迭 3��°������ �ٿ��ֱ� (��� �ε����������� ��)
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		System.out.println();
		originArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");		// ���� �ٸ� �ּҰ��� ������ ������ �ٲ�
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
	}
	
	public void method4() {
		System.out.println();
		System.out.println("=========================");
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
//		Arrays.copyOf(original, newLength)
//			original	: ���� �迭
//			newLength	: ?????
		
		copyArr = Arrays.copyOf(originArr, originArr.length);
		
		System.out.println();
		System.out.println();
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
	}
		
}
