package com.kh.example.array;

import java.util.Arrays;

public class B_ArrayCopy {
	// 얕은 복사 : 배열의 주소만 복사
	// 깊은 복사 : 동일한 새로운 배열을 하나 생성하여 실제 내부 값 복사
	// 		1) for문		2) System.arraycopy 	3) Arrays.copyOf		4) clone (X)
	public void method1() {
		int[] originArr = {1, 2, 3, 4, 5}; // 선언과 동시에 초기화
		int[] copyArr = originArr; // 얕은 복사
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		// 같은 주소 값과 같은 결과 값 출력됨
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		System.out.println();
		copyArr[0] = 99;
		System.out.println();
		
		System.out.println("originArr : " + originArr);	// 사본을 바꿔도 주소는 같고
		for(int i = 0; i < originArr.length; i++) {		// 원본도 첫번째 값이 99로 바뀌었음
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		// 원본 배열과 사본 배열이 서로 참조하고 있는 배열이 같음(주소 값이 같음)
	}
	
	// 깊은 복사
	public void method2() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[originArr.length];	// new int[5]라고 해도 됨
		
		// for문을 이용한 복사
		for(int i = 0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];				// 오른쪽에 있는 것이 값, 왼쪽이 공간	
		}
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);		// 다른 주소 값 출력됨
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
			System.out.print(copyArr[i] + " ");		// 99 2 3 4 5 // 안에 있는 값이 사본만 바뀜
		}
		
		// 원본 배열과 사본 배열이 서로 참조하는 있는 배열이 다름(주소 값이 다름)
	}
	
	public void method3() {
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];			// 값 없이 공간만 0개 생김
		
		System.out.println("originArr : " + originArr);
		for(int i = 0; i < originArr.length; i++) {
			System.out.print(originArr[i] + " ");
		}
		System.out.println();
		System.out.println("copyArr : " + copyArr);	
		for(int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		
		// System.arraycopy() 이용한 복사
//		System.arraycopy(src, srcPos, dest, destPos, length);
//			src 	: 원본 배열
//			srcPos	: 원본 배열에서 복사를 시작할 위치
//			dest	: 복사 배열
//			destPos : 복사 배열에서 붙여넣기를 시작할 위치
//			length	: 복사 길이
		
		// 원본 배열의 0번째서부터 원본 배열 길이만큼 복사 후, 복사 배열 3번째서부터 붙여넣기 (모두 인덱스기준으로 셈)
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
			System.out.print(originArr[i] + " ");		// 서로 다른 주소값을 가져서 원본만 바뀜
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
//			original	: 원본 배열
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
