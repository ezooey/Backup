package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice2() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 - i;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}

	public void practice4() {
		String[] arr = new String[5];
		arr[0] = "사과";
		arr[1] = "귤";
		arr[2] = "포도";
		arr[3] = "복숭아";
		arr[4] = "참외";

		System.out.print(arr[1]);
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);

//		String[] arr = new String[str.length()]; 
		char[] chArr = new char[str.length()];

		int j = 0;
		System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		for (int i = 0; i < str.length(); i++) {
//			char ch1 = str.charAt(i);
//			if(ch == ch1) {
			chArr[i] = str.charAt(i); // char로 맞춰주면 바로 charAt 대입 가능
			if (ch == chArr[i]) {
				System.out.print(i + " ");
				j++; // 입력한 문자가 찾을 문자와 같아질 때마다 j도 1씩 커짐
			}
		}
		System.out.println();
		System.out.print(ch + " 개수 : " + j);
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();

		String[] strArr = { "월", "화", "수", "목", "금", "토", "일" };
		if (num >= 0 && num < 7) {
			System.out.println(strArr[num] + "요일");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];

//		System.out.print("배열 0번째 인덱스에 넣을 값 : ");
//		int num0 = sc.nextInt();
//		System.out.print("배열 1번째 인덱스에 넣을 값 : ");
//		int num1 = sc.nextInt();
//		System.out.print("배열 2번째 인덱스에 넣을 값 : ");
//		int num2 = sc.nextInt();
//		System.out.print("배열 3번째 인덱스에 넣을 값 : ");
//		int num3 = sc.nextInt();
//		System.out.print("배열 4번째 인덱스에 넣을 값 : ");
//		int num4 = sc.nextInt();
//			
//		arr[0] = num0;
//		arr[1] = num1;
//		arr[2] = num2;
//		arr[3] = num3;
//		arr[4] = num4;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
		}

		int j = 0;
//		for(int i = 0; i < arr.length; i++) {
		for (int i = 0; i < arr.length; i++) {
			j += arr[i];
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.print("총 합 : " + j);
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);

		
//		while (true) {
//			System.out.print("정수 : ");
//			int num = sc.nextInt();
//
//			int div = num / 2;
//			int minus = num - 2;
//
//			if (num >= 3 && num % 2 != 0) {
//				int[] arr = new int[num];
//				for (int i = 0; i <= div; i++) {
//					arr[i] = (i + 1);
//					System.out.print(arr[i] + ", ");
//				}
//				System.out.print(arr[i] + ", ");
//				for (int i = div + 1; i <= minus; i++) {
//					for(int j = div; j >= 2; j--){
//					arr[i] = j;
//					}
//					System.out.print(arr[i] + ", ");
//				}
//				System.out.print("1");
//				break;
//			} else {
//				System.out.println("다시 입력하세요.");
//			}
//		}
		
		int[] arr;
		while (true) {
			System.out.print("정수 : ");
			int num = sc.nextInt();

			int div = num / 2;

			if (num >= 3 && num % 2 != 0) {
				arr = new int[num];
				for (int i = 0; i <= div; i++) {
					arr[i] = (i + 1);			// arr[0]~[div]까지 방에 집어넣기만 함
				}
				for (int i = div + 1; i < arr.length; i++) { // 인덱스는 실제 값보다 1 작으니까 1 더해서 계산해줌
					arr[i] = num - i;			// i는 1씩 커지고 그 값을 num에서 빼면 1씩 줄어들게 됨
				}								// arr[div+1]~arr[num-1]까지 방에 집어넣어줌
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}
		for(int i = 0; i < arr.length; i++) {	// 여기서부터 위에서 나열된 방을 출력해줌
			if(i == arr.length - 1) {
				System.out.print(arr[i]); 	// 1부터 연산하다가 조건에 맞는 마지막 숫자만을 출력. 뒤에 쉼표 없음
			} else {
				System.out.print(arr[i] + ", "); // 1부터 연산한 값이 앞에 출력됨. 쉼표 포함
			}
		}
	}
	
	public void practice9() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("치킨 이름을 입력하세요 : ");
//		String menu = sc.nextLine();
//		
//		String[] strArr = {"후라이드", "양념", "간장", "마늘", "파닭"};
//		for(int i = 0; i < strArr.length; i++) {
//			if(strArr[i].equals(menu)) {
//				System.out.println(menu + "치킨 배달 가능");
//			} else if(!strArr[i].equals(menu)) {
//				System.out.println(menu + "치킨은 없는 메뉴입니다.");
//			}
//		}
//	
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String menu = sc.nextLine();
		String[] arr = {"후라이드", "양념", "간장", "마늘", "파닭"};

		boolean possible = false;			// 잘 모르겠으니 자주 보고 익힐 것
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(menu)) {
				possible = true;
				break;
			}
		}
		if(possible) {
			System.out.println(menu + "치킨 배달 가능");
		} else {
			System.out.println(menu + "치킨은 없는 메뉴입니다.");
		}
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pId = sc.nextLine();
		
//		String[] arr = {pId};
//		String[] copyArr = new String[arr.length];
		

		char[] arr = new char[pId.length()];
		char[] copyArr = new char[pId.length()];
		
		for(int i = 0; i < pId.length(); i++) {
			arr[i] = pId.charAt(i);
			
//			if(i <= 7) {
//				copyArr[i] = arr[i];
//			} else {
//				copyArr[i] = '*';
//			}
			System.arraycopy(arr, 0, copyArr, 0, 8);
			if(i >= 8) {
				copyArr[i] = '*';
			}
			System.out.print(copyArr[i]);
		}
	}
	
	public void practice11() {
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		int[] arr = new int[10];
		int max = 1;
		int min = 10;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			if(arr[i] > max) {
				max = arr[i];
//				arr[i] = max; 라고 쓰지 않게 주의하자 (난수의 값이 max 하나의 값으로 통일돼버림)
			}
			if(arr[i] < min) {
				min = arr[i];
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice13() {
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {	// 만약 arr[i]와 arr[j]값이 같으면
					i--;				// 중복이 생긴 arr[i]를 되돌려 for문을 처음부터 재실행, 난수 재생성
					break;				// (i값이 만약 3이면 내려오면서 4가 됐는데 다시 3으로 돌아가서 다시 하게 됨)
				}						// 이때 i보다 j가 작은 수이므로 arr[i]를 다시 초기화하는 것
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}			
//		혼자 하다가 망친 것
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 10 + 1);
//			for(int j = 0; j < i; j++) {
//				if(i < j && arr[i] == arr[j]) {
//					arr[j] = (int)(Math.random() * 10 + 1);
//				} else if (i < j && arr[i] != arr[j]) {
//					arr[j] = arr[j];
//				}
////			break;
//			System.out.print(arr[i] + " ");
	
	
	public void practice14() {
		int[] arr = new int[6];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
				if(arr[j] > arr[i]) {
//					arr[i] = arr[j];	// 자리 바꾸기
					int temp = arr[i];	// arr[i]값을 임시로 temp변수에 담는다
					arr[i] = arr[j];	// arr[i]자리에 arr[j]값을 넣는다
					arr[j] = temp;		// arr[j]자리에 temp값을 넣는다
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char ch = sc.nextLine().charAt(0);
		
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = ch;
		}
		
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		System.out.print("1번째 문자열 : ");
		String first = sc.nextLine();
		System.out.print("2번째 문자열 : ");
		String second = sc.nextLine();
		System.out.print("3번째 문자열 : ");
		String third = sc.nextLine();
		
		int[] arr = new int[size];
	}
}
