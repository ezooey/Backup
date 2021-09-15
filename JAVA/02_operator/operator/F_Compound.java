package com.kh.operator;

public class F_Compound {
	public void method() {
		int num = 12;
		System.out.println("num : " + num);
		
//		num1 = num + 3;
		num += 3;
		System.out.println("num : " + num);
		
//		num2 = num1 - 5;
		num -= 5;
		System.out.println("num : " + num);
		
//		num3 = num2 * 6
		num *= 6;
		System.out.println("num : " + num);
		
//		num4 = num3 / 2;
		num /= 2;
		System.out.println("num : " + num);
		
//		num5 = num4 % 4;
		num %= 4;
		System.out.println("num : " + num);
	}

}
