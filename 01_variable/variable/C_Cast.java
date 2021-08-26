package com.kh.variable;

public class C_Cast {
	/*
	 	형변환 : 현재 자료형을 다른 자료형으로 변환하는 것(바꾸는 것)
	  
	  	원래 형변환을 할 때는 앞에 바꿀 자료형을 명시하는 것이 원칙
	 		(바꿀 자료형)값	or	(바꿀 자료형)변수
	 	자동 형변환에서는 자료형 명시를 생략할 수 있지만
	 	강제 형변환에서는 필수적으로 명시해야 함 
	 */
	
	public void rule1() {
		boolean flag = true;
//		flag = 100; boolean 자료형은 무조건 true/false만 들어갈 수 있음 = 형변환 예외
		
//		자동 형변환 : 크기가 작은 자료형이 큰 자료형으로 바뀌는 것
//		ex. byte->int, int->long, int->double, long->float, char->int
		int num = 'A'; //그렇다고 문자열 ""은 안 됨! char만 되는 것
		System.out.println("num : " + num);
		
		char ch = 97; //정수니까 기본형인 int, 리터럴(범위 안에 있는 숫자면 받아줌)
		System.out.println("ch: " + ch);
		
//		char ch2 = -97; // char의 범위는 0~65535, 양수만 가능하기 때문에 저장 불가능
		
//						  num은 4byte짜리 변수, 'A'의 실제값은 65니까 char 안에서 받아줄 수 있는 값이라도 4byte라는 틀의 크기만 판단
		char ch2 = (char) num; // 강제 형변환 = 명시적 형변환
		System.out.println("ch2 : " + ch2);
		
		int num2 = -97;
		char ch3 = (char)num2; //char가 인지하지 못 하는 음수가 들어가 있지만 값보다 크기가 중요하기 때문에 오류x
		System.out.println("ch3 : " + ch3);
		// ?는 실제 데이터 자체의 물음표가 아니라, -97에 대한 문자를 찾지 못 해서 나오는 문자
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100L;
		
//		int iSum = iNum + lNum;
		//			int	   long
		//자동형변환	long   long
		// 				long
		//자동형변환 된 long값을 int에 저장하려고 하니 빨간줄이 뜸
		
		// 방법 1 : 수행 결과를 long 자료형으로 받기
		long lsum = iNum + lNum;
		System.out.println("lsum : " + lsum);
		
		// 방법 2 : long형을 int형으로 강제 형변환
		int iNum1 = iNum + (int)lNum;
		System.out.println("iNum1 : " + iNum1);
		
		// 방법 3 : 수행 결과를 int로 강제 형변환
		int iNum2 = (int)(iNum + lNum);
		System.out.println("iNum2 : " + iNum2);
	}
}
