package com.kh.example.text.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child4 extends Parent {
	public Child4() {
//		super.num = 10;
//		super.dNum = 0;		// 다른 패키지라서 접근 불가
		super.bool = false; // 상속돼서 접근 가능
		super.ch = 'A';
	}

}
