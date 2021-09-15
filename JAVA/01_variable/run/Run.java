package com.kh.run;

import com.kh.variable.E_KeyboardInput;

//import com.kh.variable.D_PrintMethod;

//import com.kh.variable.C_Cast;

public class Run { // 실행 클래스

	public static void main(String[] args) { // 실행 메소드
		// A_Variable 클래스 접근
		// 1. 클래스 앞의 패키지까지 다 적어 클래스의 풀네임으로 접근
//		com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
//		-------------------------- -> 클래스의 풀네임
		
		// 2. import를 사용하여 접근
//		A_Variable av = new A_Variable();
		// 			    ---------------- -> 해당 클래스의 알맹이 만들기 (av라는 변수에 담아둔 것임)
//		test.A_Variable av2 = new test.A_Variable(); // 같은 이름 있을 때는 import 안 되고 직접 적어서 명시
		
		
		// 클래스 안에 있는 메소드 접근(어느 위치에 있는지를 명시해야)
//		av.declareVariable();
//		av.initVariable(); // 위에서 위치 명시했기 때문에 이번엔 import 불필요
		
//		B_Constant bc = new B_Constant();
//		bc.finalConstant();
		
//		C_Cast cc = new C_Cast(); 
		//처음에 빨간줄이 뜨는 건 클래스가 어느 위치인지 명시되지 않아서
//		cc.rule1();
//		cc.rule2();
		
//		D_PrintMethod dp = new D_PrintMethod();
//		dp.printlnExample();
//		dp.printExample();
//		dp.printfExample();
		
		E_KeyboardInput eki = new E_KeyboardInput();
//		eki.inputScanner1();
//		eki.inputScanner2();
		
		
	}

}
