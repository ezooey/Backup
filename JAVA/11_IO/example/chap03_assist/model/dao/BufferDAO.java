package com.kh.example.chap03_assist.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferDAO {
	public void inputByte() {
		// 파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶다
		// ---			  --------	 ---- ------
		// File			  Stream	 	  Input 	==> FileInputStream
		//							 Buffered
		try(FileInputStream fis = new FileInputStream("c_buffer.txt"); // 이 세미콜론은 생략 불가(구분 필요)
			BufferedInputStream bis = new BufferedInputStream(fis);) { // 이 뒤의 세미콜론은 구분할 필요 없으므로 생략 가능
			
			int value;
			while((value = bis.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outputByte() {
		// 파일에 데이터를 바이트 기반으로 빠르게 쓰고 싶다
		// ---		  --------	 ----- ------
		// File		  Stream		   Output  ==> FileOutputStream
		// 						 Buffered	   ==> BufferedOutputStream
		
//		BufferedOutputStream bos = null;
		try (FileOutputStream fos = new FileOutputStream("c_buffer.txt", true);
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			
			bos.write(65);
			byte[] bArr = {66, 67, 68, 69};
			bos.write(bArr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			try {
				bos.close(); 
				// bos 안에 fos가 있기 때문에 fos는 안 닫아줘도 bos 닫을 때 같이 닫힘
			} catch (IOException e) {
				e.printStackTrace();
			}
		} */
	}
	public void outputChar() {
			// 파일에 문자 기반으로 데이터를 빠르게 쓰고 싶다
			// ---	------			---- ------
			// File Stream(x)			 Writer		==> FileWriter
			//						Buffered		==> BufferedWriter
			
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt", true));) {
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("저리가세요\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public void inputChar() {
		// 파일로부터 문자기반으로 데이터를 빠르게 읽고 싶다
		// ---	   ------		  ----- -----
		// File	   Stream(x)			Reader	==> FileReader
		//						  Buffered		==> BufferedReader
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
			
			String value = null;
			while((value = br.readLine()) != null) {
//			br.readLine(); // 끝에 도달하면 null을 반환
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void ioTest() {
		// 사용자에게 이름과 나이를 입력 받고, 사용자의 10년 후의 나이 출력
		// 기본 입출력 (기반 스트림)
		// System.in : InputStream (스트림이니까 바이트 기반)
		// System.out : OutputStream
		 
		
		try(InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr); // 바이트기반을 문자로 감싸줬으니까  문자기반으로
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
			
			System.out.print("이름 입력 : ");
			String name = br.readLine();
			System.out.print("나이 입력 : ");
			int age = Integer.parseInt(br.readLine());
			
//			System.out.println(name + "님의 10년 후의 나이는 " + (age + 10) + "살입니다.");
			bw.write(name + "님의 10년 후의 나이는 " + (age + 10) + "살입니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
