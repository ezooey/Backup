package com.kh.run;

import com.kh.operator.A_LogicalNegation;
import com.kh.operator.B_InDecrease;
import com.kh.operator.C_Arithmetic;
import com.kh.operator.D_Comparison;
import com.kh.operator.E_Logical;
import com.kh.operator.F_Compound;
import com.kh.operator.G_Triple;


public class Run {
	public static void main(String[] args) {
		A_LogicalNegation aln = new A_LogicalNegation();
//		aln.method();
		
		B_InDecrease bid = new B_InDecrease();
//		bid.method1();
//		bid.method2();
//		bid.method3();
//		bid.method4();
		
		C_Arithmetic ca = new C_Arithmetic();
//		ca.method1();
//		ca.method2();
		
		D_Comparison dc = new D_Comparison();
//		dc.method1();
		
		E_Logical el = new E_Logical();
//		el.method1();
		el.method2();
//		el.method3();
		
		F_Compound fc = new F_Compound();
//		fc.method();
		
		G_Triple gt = new G_Triple();
//		gt.method1();
//		gt.method2();
		
		
	}
	
}
