package com.kh.practice.file.controller;

import com.kh.practice.file.model.dao.FileDAO;

public class FileController {
	FileDAO fd = new FileDAO();
	public boolean checkName(String file) {
		// DAO에 매개변수를 전달하고, DAO로부터 전달받은 값을 다시 반환
		boolean check = fd.checkName(file); // DAO에 매개변수 file을 전달해서 받은 값을 check에 저장
		return check;
	}
	public void fileSave(String file, StringBuilder sb) {
		// 전달받은 매개변수를 변경하고 DAO에 전달
		String str = sb.toString();
// Returns a string containing the characters in this sequence in the same order as this sequence. 
// The length of the string will be the length of this sequence.
// 여러개의 문자를 같은 순서와 같은 길이의 String으로 반환
		fd.fileSave(file, str);
	}
	public StringBuilder fileOpen(String file) {
		// DAO에 매개변수를 전달하고, DAO로부터 전달받은 값을 다시 반환
		StringBuilder sb = fd.fileOpen(file); // DAO에 매개변수 file을 전달해서 받은 값을 sb에 저장
		return sb;
	}
	public void fileEdit(String file, StringBuilder sb) {
		// 전달받은 매개변수를 변경하고 DAO에 전달
		String str = sb.toString();
		fd.fileEdit(file, str);
	}
}
