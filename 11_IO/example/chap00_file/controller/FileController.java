package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
		try {
			File f1 = new File("test.txt"); // 이거로 파일이 생성되는 건 아님 // 정보만 갖고 있겠다는 뜻
			f1.createNewFile();
			// 새 파일 생성 
			// 경로를 지정하지 않은 상태에서 파일을 생성해주면 프로젝트의 최상단에 파일이 만들어짐
			// Unhandled exception type IOException // createNewFile이 IOException을 위임 받고 있음
			// 그래서 try~catch해줌
			
			File f2 = new File("c:/test/test.txt");
			f2.createNewFile(); // 단순하게 파일만 만들어주는 메소드(경로가 없으면 만들 수 없음)
			
			File f3 = new File("c:/temp1/temp2");
			File f4 = new File("c:/temp1/temp2/test.txt");
//			f4.createNewFile(); // 없는 경로를 지정해서 파일이 만들어지지 않음
			f3.mkdirs(); // make directories
			f4.createNewFile();
			f4.delete();
			
			System.out.println(f2.exists()); // true
			System.out.println(f3.exists()); // true
			System.out.println(f4.exists()); // false
			System.out.println(f3.isFile()); // false
			System.out.println(f1.getName()); // 파일명
			System.out.println(f1.getAbsolutePath()); // 절대경로
			System.out.println(f1.getPath()); // 상대경로
			System.out.println(f1.length()); // 파일 크기
			System.out.println(f1.getParent()); // 상위폴더가 누가 있느냐
			System.out.println(f4.getParent());
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
