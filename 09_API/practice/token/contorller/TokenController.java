package com.kh.practice.token.contorller;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		String at = "";
		while(st.hasMoreTokens()) {
			at += st.nextToken();
		}
		return at;
	}
	public String firstCap(String input) {
		char first = input.toUpperCase().charAt(0);
		String index = input.substring(1);
		
		return first + index;
	}
	public int findChar(String input, char one) {
		char[] inputArr = new char[input.length()];
		
		for(int i = 0; i < inputArr.length; i++) {
			inputArr[i] = input.charAt(i);
		}
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(inputArr[i] == one) {
				count++;
			}
		}
		return count;
	}

}
