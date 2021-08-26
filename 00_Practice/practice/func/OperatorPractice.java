package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = num > 0 ? "양수다" : "양수가 아니다";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다");
		System.out.println();
		System.out.println(result);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String result = num % 2 == 0 ? "짝수다" : "홀수다";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int human = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		int result1 = candy / human;
		int result2 = candy % human;
		
		System.out.println();
		System.out.println("1인당 사탕 개수 : " + result1);
		System.out.println("남는 사탕 개수 : " + result2);
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("학년(숫자만) : ");
		int level = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int cn = sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("성적(소수점 아래 둘째자리까지) : " );
		double grade = sc.nextDouble();
		
		String result = gender == 'F' ? "여" : "남";
		System.out.println();
		System.out.print(level + "학년 " + cn + "반 " + num + "번 " + name + " " + result + "학생의 성적은 " + grade + "이다.");
		
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : (age <= 19 ? "청소년" : "성인");
		System.out.println();
		System.out.println(result);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		String result = (avg >= 60 && kor >= 40 && eng >= 40 && math >= 40 ? "합격" : "불합격" );
		
		System.out.println();
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(result);
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		char pId = sc.nextLine().charAt(7);
		
		String result = pId % 2 == 0 ? "여자" : "남자";
		System.out.println();
		System.out.println(result);
		
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		String result = num1 > num2 ? "오류: num1은 num2보다 작아야 합니다." : (num3 <= num1 || num3 > num2 ? "true" : "false");
		
		System.out.println();
		System.out.println(result);
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		String result = num1 == num2 && num2 == num3 ? "true" : "false";
		System.out.println();
		System.out.println(result);
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("A사원의 연봉 : ");
		int num1 = sc.nextInt();
		System.out.print("B사원의 연봉 : ");
		int num2 = sc.nextInt();
		System.out.print("C사원의 연봉 : ");
		int num3 = sc.nextInt();
		
		double sal1 = num1 + (double)(num1 * 0.4);
		double sal2 = num2;
		double sal3 = num3 + ((double)num3 * 0.15);
		
		String result1 = sal1 >= 3000 ? "3000 이상" : "3000 미만";
		String result2 = sal2 >= 3000 ? "3000 이상" : "3000 미만";
		String result3 = sal3 >= 3000 ? "3000 이상" : "3000 미만";
		
		System.out.println();
		System.out.println("A사원 연봉/연봉+a : " + num1 + "/" + sal1);
		System.out.println(result1);
		System.out.println("B사원 연봉/연봉+a : " + num2 + "/" + sal2);
		System.out.println(result2);
		System.out.println("C사원 연봉/연봉+a : " + num3 + "/" + sal3);
		System.out.println(result3);
		
		
	}
}
