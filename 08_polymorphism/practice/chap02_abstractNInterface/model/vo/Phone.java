package com.kh.practice.chap02_abstractNInterface.model.vo;

public interface Phone {
	char[] NUMBERPAD = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'}; 
	// public static 생략해도 됨(인터페이스의 메소드는 묵시적으로 public abstract)
	String makeCall();
	String takeCall();
}
