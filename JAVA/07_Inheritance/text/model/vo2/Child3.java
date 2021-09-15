package com.kh.example.text.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child3 {
	public Child3() {
		Parent p = new Parent();
//		p.num = 10;
//		p.dNum = 0;			// 다른 패키지라서 접근 불가
//		p.bool = flase;		// 상속 관계일 때만 접근 가능한데 상속x
		p.ch = 'A';
	}

}
