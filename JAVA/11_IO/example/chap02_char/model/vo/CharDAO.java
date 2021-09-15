package com.kh.example.chap02_char.model.vo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileOpen() {
		// 파일로부터 문자기반으로 데이터를 읽어오고 싶다
		// ---	   ------	------------
		// File	   Stream (x)	Reader ==> FileReader
		FileReader fr = null; // 처음부터 쓰면 close에 캐치 버튼 안 뜸ㄱ-
		try {
			fr = new FileReader("b_char.txt");
			int value;
			while((value = fr.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen2() {
		try(FileReader fr = new FileReader("b_char.txt");) {
// Unhandled exception type IOException thrown by automatic close() invocation on fr
		
// 원래 방법대로면 close()에서 끝나는 게 아니라 IOException을 예외처리 해줬었음
// 그래서 try~with~resource로도 IOException을 예외처리 해야만 구동 가능			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) { // try~with~resource에 대한 예외처리
			e1.printStackTrace();
		}
	}
	
	public void fileSave() {
		// 파일에 문자기반으로 데이터를 쓰고 싶다
		// ---  ------	 ---------
		// File Stream(x) Writer ==> FileWriter
		FileWriter fw = null;
		try {
			fw = new FileWriter("b_char.txt", true);
			fw.write("와, IO 재밌다!");
			fw.write('A');
			char[] cArr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(cArr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		} finally { // close 안 해주면 데이터가 저장 안 될 수 있으니 신경쓰자
//			try {
//				fw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	public void fileSave2() {
		try(FileWriter fw = new FileWriter("b_char.txt", true);) {
			// ㄴ try~with~resource 방법 (finally 없이 자동으로 끝내는 것)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
