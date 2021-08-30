package com.kh.example.chap03_user.model.exception;

public class MyException extends Exception { // 이름만 exception이라고 해서 예외가 되지는 않음 상속 필요
	public MyException() {}
	public MyException(String msg) {
		super(msg);
	}

}
