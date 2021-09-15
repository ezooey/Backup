package com.kh.practice.chap01.control;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("입력 메뉴입니다.");
			break;
		case 2:
			System.out.println("수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("조회 메뉴입니다.");
			break;
		case 4:
			System.out.println("삭제 메뉴입니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num <= 0) {
			System.out.println("양수만 입력해주세요.");
		} else if (num % 2 == 0) {
			System.out.println("짝수다");
		} else {
			System.out.println("홀수다");
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		
		int sum = (kor + eng + math);
		double avg = sum / 3;
		
		if (kor < 40 || math < 40 || eng < 40) {
			System.out.println("불합격입니다.");
		} else if (avg < 60) {
			System.out.println("불합격입니다.");
		} else if (avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		}
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);;
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String season = null; // 스위치문 쓸 때는 초기화하자
		switch (month) {
		case 1: case 2: case 12:
			season = "겨울";
//			System.out.println(month + "월은 겨울입니다.");
			break;
		case 3: case 4: case 5:
			season = "봄";
//			System.out.println(month + "월은 봄입니다.");
			break;
		case 6: case 7: case 8:
			season = "여름";
//			System.out.println(month + "월은 여름입니다.");
			break;
		case 9: case 10: case 11:
			season = "가을";
//			System.out.println(month + "월은 가을입니다.");
			break;
		default :
			season = "잘못 입력된 달";
//			System.out.println(month + "월은 잘못 입력된 달입니다.");
		}
		System.out.println(month + "월은 " + season + "입니다.");
	}
	
	public void practice5() {
		String id = "myId";
		String pw = "myPassword12";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPw = sc.nextLine();
		
		if (userId.equals(id) && userPw.equals(pw)) {
			System.out.println("로그인 성공");
		} else if (userId.equals(id)) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String grade = sc.nextLine();
		
		if("관리자".equals(grade)) {
			System.out.println("회원관리, 게시글 관리, 게시글 작성, 댓글 작성, 게시글 조회");
		} else if ("회원".equals(grade)) {
			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
		} else {
			System.out.println("게시글 조회");
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double BMI = weight / (height * height);
		System.out.println("BMI 지수 : " + BMI);

		if(BMI < 18.5) {
			System.out.println("저체중");
		} else if(BMI >= 18.5 && BMI < 23) {
			System.out.println("정상체중");
		} else if(BMI >= 23 && BMI < 25) {
			System.out.println("과체중");
		} else if(BMI >= 25 && BMI < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char op = sc.next().charAt(0);
		
		double first = num1;
		double second = num2;
		
		double result = 0;
		
		if(num1 > 0 && num2 > 0) {
			switch(op) {
			case '+':
				result = first + second;
				break;
			case '-':
				result = first - second;
				break;
			case '*':
				result = first * second;
				break;
			case '/':
				result = first / second;
				break;
			case '%':
				result = first % second;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			System.out.printf("%d %c %d = %f", num1, op, num2, result);
		} else {
			System.out.println("양수를 입력해주세요.");
		}
		
	}
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int fin = sc.nextInt();
		System.out.print("과제 점수 : ");
		int work = sc.nextInt();
		System.out.print("출석 회수 : ");
		int att = sc.nextInt();
		System.out.println("================ 결과 ================= ");
		
		double mid1 = (double)mid * 0.2;
		double fin1 = (double)fin * 0.3;
		double work1 = (double)work * 0.3;
		double att1 = att;
		double sum = mid1 + fin1 + work1 + att1;
		// 70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 6번 이상(30% 이상) 결석 시 Fail
		
//		if(sum >= 70) {
//			System.out.println("중간 고사 점수(20) : " + mid1);
//			System.out.println("기말 고사 점수(30) : " + fin1);
//			System.out.println("과제 점수           (30) : " + work1);
//			System.out.println("출석 점수           (20) : " + att1);
//			System.out.println("총점 : " + sum);
//			System.out.println("Pass");
//		} else if(att < 15) {
//			System.out.println("Fail [출석 회수 부족 (" + att + "/20)]");
//		} else {
//			System.out.println("중간 고사 점수(20) : " + mid1);
//			System.out.println("기말 고사 점수(30) : " + fin1);
//			System.out.println("과제 점수           (30) : " + work1);
//			System.out.println("출석 점수           (20) : " + att1);
//			System.out.println("총점 : " + sum);
//			System.out.println("Fail [점수 미달]");
//		}
		
		if(att < 15) {
			System.out.println("Fail [출석 회수 부족 (" + att + "/20)]");
		} else { 
			System.out.println("중간 고사 점수(20) : " + mid1);
			System.out.println("기말 고사 점수(30) : " + fin1);
			System.out.println("과제 점수           (30) : " + work1);
			System.out.println("출석 점수           (20) : " + att1);
			System.out.println("총점 : " + sum);
			
			if(sum >= 70) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail [점수 미달]");
			}
		}
		
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		System.out.print("선택 : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}

}
