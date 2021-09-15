package com.kh.homework.member.controller;

import com.kh.homework.member.model.vo.Member;

public class MemberController {
	private Member[] m = new Member[SIZE];
	public static int SIZE = 10;
	public int existMemberNum() {
		int count = 0;
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				count++;
			}
		}
		return count;
	}
	public boolean checkId(String inputId) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(inputId)) {
					return false;		// 중복됨. false값 리턴
				}
			}
		}
		return true;					// 중복 안 됨 true값 리턴
	}
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		int index = 0;
		for(int i = 0; i < m.length; i++) {
			if(m[i] == null) {	// 값이 빈 곳을 찾는 조건식
				index = i;		// 빈 곳에 변수 값 저장
				break;
			}
		}
		m[index] = new Member(id, name, password, email, gender, age);
	}
	public String searchId(String id) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					return m[i].inform();
				}
			}
		}
		return null;	// 반환타입이 String이므로 Member[] 객체 배열 생성 불가능
	}
	
	public Member[] searchName(String name) {
		Member[] result = new Member[SIZE];
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getName().equals(name)) {
					result[i] = m[i];
				} 
			}
		}
		return result;
		
	}
	public Member[] searchEmail(String email) {
		Member[] result = new Member[SIZE];
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getEmail().equals(email)) {
					result[i] = m[i];
				}
			}
		}
		return result;
	}
	public boolean updatePassword(String id, String password) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					m[i].setPassword(password);
					return true;
				}
			}
		}
		return false;
	}
	public boolean updateName(String id, String name) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					m[i].setName(name);
					return true;
				}
			}
		}
		return false;
	}
	public boolean updateEmail(String id, String email) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					m[i].setEmail(email);
					return true;
				}
			}
		}
		return false;
	}
	public boolean delete(String id) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(m[i].getId().equals(id)) {
					m[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	public void delete() {
		for(int i = 0; i < m.length; i++) {
			m[i] = null;
		}
	}
	public Member[] printAll() {
		return m;
	}
	
	

}
