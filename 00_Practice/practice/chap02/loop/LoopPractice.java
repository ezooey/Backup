package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
//		int num = 0;

		while (true) { // 위에서 num을 0으로 초기화했으므로 num < 1로 조건문 달면 true가 됨// 아예 true를 넣어도 됨
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();

			if (num >= 1) { // 그 이후에 입력한 1 이상의 숫자는 여기에 들어간다
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break; // 반복문을 빠져나가 아래 출력문장을 실행하게 해주는 듯?
			} else if (num < 1) { // else { 만 해도 됨
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num >= 1) {
			for (int i = 0; i < num; i++) {
				System.out.print(num - i + " ");
//			for(int i = num; i >= 1; i--) {
//				SYstem.out.print(i + " "); 
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1이상의 숫자를 입력하세요 : ");
			int num = sc.nextInt();

			if (num >= 1) {
				for (int i = 0; i < num; i++) {
					System.out.print(num - i + " ");
				}
				break;
			} else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (i == num) {
				System.out.print(i + " = ");
			} else {
				System.out.print(i + " + ");
			}
			sum += i;
		}
		System.out.print(sum);
	}
	
//	public void practice5() {		// 선생님 답
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("정수를 하나 입력하세요 : ");
//		int num = sc.nextInt();
//		
//		int sum = 0;
//		int i = 1;
//		while(i <= num){
//			sum += i;
//			if(i != num) {
//				System.out.print(i + " + ");
//			} else {
//				System.out.print(i + " = " + sum);
//			}
//			i++;
//		}
//	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int second = sc.nextInt();

		int min = 0;
		int max = 0;

		if (first > second) {
			min = second;
			max = first;
		} else {
			min = first;
			max = second;
		}

		if (min < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (; min <= max; min++) {
				System.out.print(min + " ");
			}
		}
	}
	
//	public void practice6() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 숫자 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 숫자 : ");
//		int num2 = sc.nextInt();
//		
//		if(num1 >= 1 && num2 >= 1) {
//			int max = 0;
//			int min = 0;
//			
//			if(num1 > num2) {
//				max = num1;
//				min = num2;
//			} else {
//				max = num2;
//				min = num1;
//			}
//			
//			for(int i = min; i <= max; i++) {
//				System.out.print(i + " ");
//			}			
//		} else {
//			System.out.println("1 이상의 숫자를 입력해주세요.");
//		}
//	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);

		int min = 0;
		int max = 0;

		while (true) {
			System.out.print("첫 번째 숫자 : ");
			int first = sc.nextInt();
			System.out.print("두 번째 숫자 : ");
			int second = sc.nextInt();

			if (first > second) {
				min = second;
				max = first;
			} else {
				min = first;
				max = second;
			}
			if (min >= 1) {
				for (; min <= max; min++) {
					System.out.print(min + " ");
				}
				break;
			} else if (min < 1) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
		}
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.println("===== " + num + "단 =====");

		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}

	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		if (num <= 9) {
			for (int i = num; i <= 9; i++) {
				System.out.println("===== " + i + "단 =====");
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + " * " + j + " = " + i * j);
				}
			}
		} else {
			System.out.println("9 이하의 숫자만 입력해주세요.");
		}
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자 : ");
			int num = sc.nextInt();
			if (num <= 9) {
				for (int i = num; i <= 9; i++) {
					System.out.println("===== " + i + "단 =====");
					for (int j = 1; j <= 9; j++) {
						System.out.println(i + " * " + j + " = " + i * j);
					}
					System.out.println();
				}
				break;
			} else {
				System.out.println("9 이하의 숫자만 입력해주세요.");
			}
		}
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		System.out.print("공차 : ");
		int codif = sc.nextInt();

		int j = start + (9 * codif);

		for (int i = start; i <= j; i += codif) {
			System.out.print(i + " ");
		}
	}
	
//	public void practice11() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("시작 숫자 : ");
//		int start = sc.nextInt();
//		System.out.print("공차 : ");
//		int num = sc.nextInt();
//		
//		for(int i = 0; i < 10; i++) {
//			System.out.print(num * i + start + " ");
//		}
		
//		int count = 0;
//		for(int i = start; ; i += num) {
//			System.out.print(i + " ");
//			count++;
//			
//			if(count == 10) {
//				break;
//			}
//		}
//	}

	public void practice12() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("연산자(+, -, *, /, %) : ");
			String str = sc.next();
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			if (!str.equals("exit")) {
				
				if (str.equals("/") && num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.\n");
					continue;
				}

				switch (str) {
				case "+":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 + num2));
					break;
				case "-":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 - num2));
					break;
				case "*":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 * num2));
					break;
				case "/":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 / num2));
					break;
				case "%":
					System.out.printf("%d %s %d = %d", num1, str, num2, (num1 % num2));
					break;
				default:
					System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				}
				break;
			} else if (str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	} // 스바 exit 프로그램 종료가 죽어도 안 된다

	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) { // i가 num보다 작거나 같아질 때까지 1씩 증가한다
			for (int j = 1; j <= i; j++) { // j가 i보다 작거나 같아질 때까지 1씩 증가한다
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = num; i >= 1; i--) {	//입력한 정수에서 시작해서 1보다 크거나 같아질 때까지 1씩 감소한다
			for(int j = i; j >= 1; j--) { // 첫 시작 숫자도 줄어들어야 하므로 초기식 j = i;
				System.out.print("*");
			} System.out.println();
		}
	}
	
	// 내꺼는 i가 줄어들면서 j도 같이 감소
	// 4 3 2 1
	// 3 2 1
	// 2 1
	// 1

//	public void practice14() {	// 인터넷에서 주운 답
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int num = sc.nextInt();
//
//		for (int i = 1; i <= num; i++) { // 1에서 4까지 늘어난다.
//			for (int j = num; j >= i; j--) { 
//				// 4에서 1까지 줄어들며 돈다.
//				// 4 3 2 1
//				// 4 3 2
//				// 4 3
//				// 4
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
}
