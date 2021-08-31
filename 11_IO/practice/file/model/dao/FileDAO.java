package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	public boolean checkName(String file) {
		// 존재하는 파일이 있는지 확인 후 반환
		File f = new File(file);
		boolean check = f.exists();
//		try (FileInputStream fis = new FileInputStream(file);) {
//			
//			int value;
//			while((value = fis.read()) != -1) {
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		return check;
	}
	public void fileSave(String file, String s) {
		// 매개변수로 받은 파일명에 문자열 저장
		try (FileWriter fw = new FileWriter(file);) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public StringBuilder fileOpen(String file) {
		// 매개변수로 받은 파일명을 이용하여 저장 되어 있는 데이터 반환
		StringBuilder sb = new StringBuilder();
		try (FileReader fr = new FileReader(file);) {
			int value;
			while((value = fr.read()) != -1) {
				sb.append((char)value); 		// StringBuilder sb에 char로 변환한 value값 추가
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return sb;
	}
	public void fileEdit(String file, String s) {
		// 매개변수로 받은 파일명에 문자열 저장
		try (FileWriter fw = new FileWriter(file, true);) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
