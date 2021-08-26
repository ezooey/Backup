package com.kh.example.practice1.model.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		m.printName();				// 아직 초기화를 안 해서 null이 뜸
		m.changeName("박신우");
		m.printName();
	}

}
