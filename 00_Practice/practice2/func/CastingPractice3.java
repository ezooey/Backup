package com.kh.practice2.func;

public class CastingPractice3 {
	public void method() {
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println(iNum1 - (iNum2 * 2));
		
		int dNum1 = (int)dNum;
		System.out.println(dNum1);
		
		double inum1 = iNum1;
		System.out.println(inum1);
		
		double inum2 = iNum2 * dNum;
		System.out.println(inum2);
		
		double inum3 = (double)iNum1 / (double)iNum2;
		System.out.println(inum3);
		
		System.out.println(dNum);
		
		int fnum = (int)fNum;
		System.out.println(fnum);
		
//		int inum4 = (iNum2 * 2) - (int)(dNum * 2);
		int inum4 = (int)(iNum1 * fNum / iNum1);
		System.out.println(inum4);
		
		float fnum1 = iNum1 / fNum;
		System.out.println(fnum1);
		
		double dnum = (double)iNum1 / (double)fNum;
		System.out.println(dnum);
		
		System.out.println("'" + ch + "'");
		
		int inum5 = ch;
		System.out.println(inum5);
		
		System.out.println(inum5 + iNum1);
		
		char ch1 = (char)(inum5 + iNum1);
		System.out.println("'" + ch1 + "'");
		
		
		
		
	}

}
