package com.kh.variable;

public class D_PrintMethod {
	public void printlnExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		System.out.println(str1);
		System.out.println(); // 줄바꿈만 해줌, 줄바꿈이 필요할 때 사용
		System.out.println(str2);
	}
	
	public void printExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		System.out.print(str1 + "\n"); // 어디서든 사용 가능, \n은 문자열로 보기 때문에 ""안에서 사용
		System.out.print(str2 + "%n"); // %n은 printf 안에서만 사용 가능
//		-> 반갑습니다%n으로 출력
//		System.out.print(); // 이대로는 사용 불가
	}
	
	public void printfExample() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		
//		System.out.printf(format, args)
//			format : 형식
//			args : 형식에 들어갈 데이터
		
		// 안녕하세요, 박신우입니다. 반갑습니다.
		System.out.printf("%s, 박신우입니다. %s.\n", str1, str2);
		// 반갑습니다, 친하게 지내요.
		System.out.printf("%s, 친하게 지내요.", str2);
		
		System.out.println();
		
		int age = 20;
		String name = "박신우";
		String job = "강사";
		// 안녕하세요, 저는 20살 박신우 강사입니다. 만나서 반갑습니다.
		System.out.printf("%s, 저는 %s살 %s %s입니다. 만나서 %s.%n", str1, age, name, job, str2);
//		System.out.println();
		System.out.printf("%s, 저는 %d살 %s %s입니다. 만나서 %s.", str1, age, name, job, str2);
	}

}
