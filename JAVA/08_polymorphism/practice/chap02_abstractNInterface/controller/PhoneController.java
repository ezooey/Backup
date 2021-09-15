package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.GalaxyNote9;
import com.kh.practice.chap02_abstractNInterface.model.vo.Phone;
import com.kh.practice.chap02_abstractNInterface.model.vo.V40;

public class PhoneController {
	// 2개의 Phone 객체를 저장할 수 있는 객체배열 생성
	// 각각의 인덱스에 다형성을 적용하여 GalaxyNote9, V40 객체 저장
	// for문을 이용하여 Phone 객체배열에 각 인덱스의 printInformation()의 반환 값을 String 배열에 담아 반환

	private String[] result = new String[2];
	public String[] method() {
		Phone[] p = new Phone[2];
		p[0] = new GalaxyNote9();
		p[1] = new V40();
		
		for(int i = 0; i < p.length; i++) {
			if(p[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9)p[i]).printInformation(); // p[i]라고만 하면 Phone 객체의 내용만 보이므로 다운캐스팅 적용
			} else if (p[i] instanceof V40) {
				result[i] = ((V40)p[i]).printInformation();
			}
		}
		
		return result;
	}

}
