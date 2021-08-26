package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
//	배열을 같은 자료형의 변수를 하나의 묶음으로 다루는 것
//	
//	배열의 선언
//		자료형[] 배열명;
//		자료형 배열명[];
//	배열의 할당
//		자료형[] 배열명 = new 자료형[배열크기];
//		자료형 배열명[] = new 자료형[배열크기];
//		new연산자를 통해 Heap메모리 영역에 공간을 배열 크기만큼 생성
//		생성이 되는 순간 그 공간에 대한 주소 값 발생	
//		발생한 주소 값은 대입 연산자에 의해 배열명 공간에 대입(=참조하고 있음)
//	배열의 초기화	
//		1) 인덱스 이용 : zero-based
//		2) for문 이용 : 규칙이 있을 때만 사용 가능
//		3) 선언과 동시에 초기화
//			자료형[] 배열명 = {값};
//			자료형[] 배열명 = new 자료형[]{값};
	
	public void method1() {
		int num1 = 10;
		
		int[] arr = new int [9];
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		System.out.println(arr[5]);
//		System.out.println(arr[6]);
//		System.out.println(arr[7]);
//		System.out.println(arr[8]);
		for(int i = 0; i < arr.length; i++) {		//arr.length는 new int[9]의 9를 의미
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		// 인덱스를 이용한 초기화
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		arr[5] = 60;
//		arr[6] = 70;
//		arr[7] = 80;
//		arr[8] = 90;
		
		// 규칙이 보이므로 for문을 이용한 초기화
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (i+1) * 10;
//		}
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		
		for(int i = 0; i < arr.length; i++) {		// i <= arr.length라고 하면 안 되는 이유
			arr[i] = (i + 1) * 10;					// :arr[9]라는 방이 없기 때문
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		System.out.println(arr);					// 주소값이 출력
	}
	
	public void method2() {
		int[] iArr1 = {1, 2, 3, 4, 5};
		int[] iArr2 = new int[] {11, 22, 33, 44, 55};
		String[] strArr = {"red", "orange", "yellow"};
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < iArr2.length; i++) {
			System.out.print(iArr2[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
	}
	
	public void method3() {
		// 5개의 공간을 가진 int형 배열 iArr
		int[] iArr = new int[5];		// int의 기본값 0
		// 10개의 공간을 가진 char형 배열 cArr
		char[] cArr = new char[10];		// char의 기본값 ' '
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		for(char i = 0; i < cArr.length; i++) {
			System.out.print(cArr[i] + "|");
		}
		
		System.out.println();
		
		System.out.println("iArr : " + iArr);
		System.out.println("cArr : " + cArr);
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("새로 할당할 배열의 크기 입력: ");
		int size = sc.nextInt();
		
		iArr = new int[size];					// iArr에 새로운 값이 들어가면서 예전 값과의 연결이 끊김
		for(int i = 0; i < iArr.length; i++) {	// 원래 있던 공간을 늘린 게 아니라 새롭게 할당한 것이다.
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		System.out.println("iArr : " + iArr);
		
		iArr = null;
	}
}
