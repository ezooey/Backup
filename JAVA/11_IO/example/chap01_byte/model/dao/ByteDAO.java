package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		// 파일로부터 byte 단위로 데이터를 읽어오고 싶다
		// ------- --------  ------------
		//  File   Stream 		Input ==> FileInputStream
		
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("a_byte.txt");
		try(FileInputStream fis = new FileInputStream("a_byte.txt");) { // try~with~resource
				
			
//			fis.read();
			// FileInputStream.read():int
			// the next byte of data, or -1 if the end of thefile is reached.
			// 데이터의 다음 값을 가져오는데, 데이터 끝에 도달하면 -1을 반환
			
			
//			while((value=fis.read()) != -1) {
//			System.out.print((char)fis.read() + " ");
			// read()는 커서의 다음값을 가져오는 메소드이기 때문에
			// abcdefgcde 에서 a는 -1이 아니므로 그 다음 값인 b를 가져오고
			// c는 -1이 아니므로 그 다음 값인 d를 가져오고
			// 반복해서 결과값이 b d f c e가 나오게 된다
			// 그래서 아래처럼 value라는 변수에 따로 하나씩 저장
			
			int value;
			while((value=fis.read()) != -1) {
				System.out.print((char)value + " ");
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		} finally {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	public void fileSave() {
		// 파일에 byte단위로 데이터를 쓰고 싶다
		// ---- -------  ---------
		// File Stream	 Output ==> FileOutputStream
		
//		FileOutputStream fos = null; // 참조형 변수라서 null로 초기화해줌 (finally에까지 닿게 하기 위함)
//		try {
//			fos = new FileOutputStream("a_byte.txt");
		try(FileOutputStream fos = new FileOutputStream("a_byte.txt");) { // try~with~resource
			
			// 여기서 열어둔 Stream 길을 작업이 다 끝나면 닫아줘야 함
		
			fos.write(97);
			
			byte[] bArr = {98, 99, 100, 101, 102, 103}; // 덮어쓰기 
			// 이어쓰기면 97 두 번 실행되기 때문에 aabcdefg 라고 나옴
			fos.write(bArr);
			
			fos.write(bArr, 1, 3);
			// bArr = bcdefg
			//		   cde ==> 인덱스[1]부터 세개만 쓰겠다
				
//		} catch (FileNotFoundException | IOException e) { 
// The exception FileNotFoundException is already caught by the alternative IOException
// 같이 두면 IOException이 더 상위클래스라서 더 범위가 커져버림 // FileNotFoundException이 할 일이 없음
		
		
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { // 그래서 catch절을 추가하는 방법을 쓴다
			e.printStackTrace();
		}
//		} finally { // Stream 길을 닫는 역할
//			try {
//				fos.close(); // fos는 try까지만이라서 영향이 안 미침
//			} catch (IOException e) { // 위의 IOException과 영역이 달라서 또 추가
//				e.printStackTrace();
//			} 
//		}
	}

}
