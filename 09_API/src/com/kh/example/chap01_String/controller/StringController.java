package com.kh.example.chap01_String.controller;

import java.util.StringTokenizer;

public class StringController {
	public void method1() {
		// String test
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		System.out.println("str1 : " + str1); 	//java(x)
		System.out.println("str2 : " + str2);	//주소값이 안 나오는 이유? toString()이 오버라이딩 되었다
		System.out.println("str3 : " + str3);
		
		boolean bool1 = str1 == str2; // 문자열에서의 == 비교는 주소값 비교
		boolean bool2 = str1 == str3;
		System.out.println("str1과 str2의 주소는 같은가? : " + bool1);
		System.out.println("str1과 str3의 주소는 같은가? : " + bool2);
		
		System.out.println("str1의 hashCode : " + str1.hashCode());
		System.out.println("str2의 hashCode : " + str2.hashCode());
		System.out.println("str3의 hashCode : " + str3.hashCode());
//		같은 값이면 같은 해시코드가 나옴
//		내용을 .equals해서 비교했을 때 같을 것
//		주소값은 다르지만 str1 str2 str3를 .equals하면 모두 같은 내용 -> "java"니까
		
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3));
		
		str1 += "API";
		System.out.println("str1 : " + str1); 	
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3));

	}
	
	public void method2() {
		// StringBuffer/StringBuilder
		// 어떤 문자열을 작업할 때, 계속해서 문자열을 변경해야 할 경우 String클래스의 '불변'이라는 특징상
		// 값이 새로 생기고 참조 위치만 바꿔주기 때문에 가비지컬렉터가 계속 지워야 하는 단점이 있음
		// String클래스의 경우는 변경이 적고 읽기만 많은 경우에 더 적합
		// 변경이 많은 경우 StringBuffer나 StringBuilder를 이용하는 것이 더 적합
		// 변경/저장을 위한 메모리 공간(버퍼)을 내부에 지니는데 초기에는 16개의 공간이 생기고 자동으로 증가
		// 두 클래스의 차이는 동기화가 되느냐 안 되느냐의 차이
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("초기 buffer1의 수용량 : " + buffer1.capacity()); // 16
		System.out.println("buffer1에 들어가 있는 실제 값의 길이 : " + buffer1.length());
		
		System.out.println();
		
		StringBuffer buffer2 = new StringBuffer(100);
		System.out.println("초기 buffer2의 수용량 : " + buffer2.capacity()); // 100
		System.out.println("buffer2에 들어가 있는 실제 값의 길이 : " + buffer2.length());

		System.out.println();
		
		StringBuffer buffer3 = new StringBuffer("abc");
		System.out.println("초기 buffer3의 수용량 : " + buffer3.capacity()); // 19 -> 초기수용량 16에 3 더해진 것
		System.out.println("buffer3에 들어가 있는 실제 값의 길이 : " + buffer3.length()); // 3
		
		System.out.println();
		
		System.out.println("buffer3의 실주소값: " + System.identityHashCode(buffer3));
		// append(String str): StringBuffer
		// 맨 뒤에 값을 추가하는 메소드
//		buffer3.append("abc");
//		System.out.println("abc 추가 후의 buffer3 : " + buffer3);
//		System.out.println("abc 추가 후의 buffer3 용량 : " + buffer3.capacity()); // 19 // 같은 용량 안에서 처리되게 했지만
//		System.out.println("abc 추가 후의 buffer3 길이 : " + buffer3.length()); // 6	// 길이는 늘어남
//
//		System.out.println();
//		
//		buffer3.append("def");
//		System.out.println("def 추가 후의 buffer3 : " + buffer3);
//		System.out.println("def 추가 후의 buffer3 용량 : " + buffer3.capacity());
//		System.out.println("def 추가 후의 buffer3 길이 : " + buffer3.length());
		
		buffer3.append("abc").append("def"); // 메소드 체이닝
// StringBuffer -------------
//		StringBuffer.append(String str):StringBuffer
		System.out.println("abc, def 추가 후의 buffer3 : " + buffer3);
		System.out.println("abc, def 추가 후의 buffer3 용량 : " + buffer3.capacity());
		System.out.println("abc, def 추가 후의 buffer3 길이 : " + buffer3.length());
		System.out.println("buffer3의 실주소값 : " + System.identityHashCode(buffer3));
		
		// insert(int offset, String str):StringBuffer
		// 원하는 위치에 str을 추가하는 메소드
		buffer3.insert(2, "zzz");
		System.out.println("인덱스 2에 zzz추가 후의 buffer3 : " + buffer3);
		
		System.out.println();
		
		// delete(int start, int end):StringBuffer
		// start <= index < end ; end 전까지만 지워짐
		buffer3.delete(2, 5);
		System.out.println("인덱스2부터 인덱스5까지 삭제 후의 buffer3 :" + buffer3);
		
		System.out.println();
		
		// reverse():StringBuffer
		buffer3.reverse();
		System.out.println("reverse 후의 buffer3 : " + buffer3);
		
		StringBuffer sb = new StringBuffer("abc");
		sb.append("zzz").insert(2, "yy").reverse().delete(1, 3);
//		abczzz abyyczzz zzzcyyba zcyyba
		
	}
	
	public void method3() {
		String str = "Hello World";
		
		// CharAt(int index):char
		// String의 index번째의 char 반환
		char ch = str.charAt(4); // o
		System.out.println(ch);
		
		// concat(String str):String
		// 본래 값 뒤에 str을 추가해주는 메소드
		String concatStr = str.concat("!!!"); // Hello World!!!
		System.out.println(concatStr);
		str += "!!!";	// Hello World!!!
		System.out.println(str);
		
		// equals():boolean
		System.out.println("concatStr.equals(str) : " + concatStr.equals(str)); // true
		
		// substring(int beginIndex):String
		// substring(int beginIndex, int endIndex):String
		// String의 일부 반환
		System.out.println("str.substring(6) : " + str.substring(6)); // World!!!
		System.out.println("str.substring(0, 4) : " + str.substring(0, 4)); // Hell
		
		// replace(char oldChar, char newChar):String
		// oldChar를 newChar로 대체한 문자열 반환
		System.out.println("str.replace('l', 'e') : " + str.replace('l', 'e')); // Heeeo Wored!!!
		
		// toUpperCase()/toLowerCase():String
		//
		System.out.println("str.toUpperCase() : " + str.toUpperCase()); //HELLO WORLD!!!
		System.out.println("str.toLowerCase() : " + str.toLowerCase()); //hello world!!!
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("더 하시겠습니까?(y/n) : ");
//		String answerStr = sc.nextLine().toLowerCase();
//		char answer = answerStr.charAt(0);
//		if(answer == 'y') {
//			System.out.println("계속 한답니다.");
//		} else if(answer == 'n') {
//			System.out.println("그만 한답니다.");
//		}
		
		// equalsIgnoreCase():boolean
		// 대소문자를 가리지 않고 문자열 비교
		String str2 = "WONDERFUL";
		String str3 = "wonderful";
		System.out.println(str2.equals(str3)); // false
		System.out.println(str2.equalsIgnoreCase(str3)); // true / 대소문자 상관없이 문자열만 비교
		
		// trim():String
		// 앞/뒤에 있는 빈 공간을 제거한 문자열 반환
		String str4 = "     Java";
		String str5 = "Java     ";
		String str6 = "  Java   ";
		String str7 = "Ja     va";
		System.out.println(str4 + " : " + str4.trim()); // Java
		System.out.println(str5 + " : " + str5.trim()); // Java
		System.out.println(str6 + " : " + str6.trim()); // Java
		System.out.println(str7 + " : " + str7.trim()); // Ja     va // 중간의 띄어쓰기도 문자열로 인식함
		
		// split(String str):String[] // 무조건 String[]이 반환값
		// StringTokenizer : split과 같은 기능, but 구분자가 다양할 때 사용
		// 문자열을 분리해주는 메소드
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		String[] strArr = splitStr.split(", ");	// ", "를 구분자로 하여 문자열을 분리
		
		
		// 일반 for문
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// 향상된 for문 = for-each
		for(String s : strArr) { // strArr에 들어있는 인자들을 하나씩 꺼내서 임시변수s에 담는다(인덱스를 이용한 게 아님)
			System.out.println(s);
		}
	}
	public void method4() {
		String str = "Java, Oracle, JDBC, Front, Server, Framework";
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println("분리된 문자열 개수 : " + st.countTokens());
		
		// hasMoreTokens():boolean
		// 다음 토큰(분리된 문자열) 값이 있다면 true 반환
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
			// nextToken():String
			// 해당하는 다음 값 반환
		}
		
		String str2 = "Apple,Banana-Cream*Dessert#Egg Fruits"; // 구분자가 다양할 때
		String[] strArr = str2.split(",-*# ");
//		String[] strArr = str2.split(",|-|*|#| "); // 정규표현식(인데 *는 특수표현으로 돼서 여기서는 구분자로 사용 불가함) 
		
		for(String s : strArr) {
			System.out.println(s);
		}
		
		StringTokenizer st2 = new StringTokenizer(str2, ",-* #");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	}
}
