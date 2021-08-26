package com.kh.example.test.run;

import com.kh.example.test.controller.InheritanceTest;

public class Run {

	public static void main(String[] args) {
//		InheritanceTest it = new InheritanceTest();
//		it.method();
		// 한 객체에서 불러올 메소드가 많을 때 위의 방법을 씀
		new InheritanceTest().method();

	}

}
