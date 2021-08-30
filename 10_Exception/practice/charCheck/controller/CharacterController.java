package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	public void CharacterController() {}
	// 매개변수로 들어온 값에 있는 영문자를 세어 반환
	// 문자열에 공백이 있다면 CharCheckException발생, 에러 메시지는 출력 값 참고
	public int countAlpha(String s) throws CharCheckException {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
				count++;
			} else if(s.charAt(i) == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
		}
		return count;
	}
}
