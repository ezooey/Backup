package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		boolean check = map.containsKey(id);
		if(check) {
			return false; // 중복
		} else {
			map.put(id, m);
			return true; // 중복x
		}
	}
	
	public String login(String id, String password) {
		boolean check = map.containsKey(id);
		String checkPw = map.get(id).getPassword();
		if(check) {
			if(checkPw.equals(password)) {
				return map.get(id).getName();
			}
		}
		return null;
		
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		boolean checkId = map.containsKey(id);
		String checkPw = map.get(id).getPassword();
		if(checkId) {
			if(checkPw.equals(oldPw)) {
				map.get(id).setPassword(newPw);
				return true;
			}
		} 
		return false;
		
	}
	
	public void changeName(String id, String newName) {
//		Member m = map.get(id);
//		map.get(id).setName(newName);
		map.get(id).setName(newName);
//		map.put(id, m);
	}
	
	public TreeMap<String, String> sameName(String name) {
		// joinMembership()에서 map에 key = id, value = m으로 값들을 넣었으므로
		// 매개변수로 넣지 않아도 value값인 Member m에서 name도 가져올 수 있다
		TreeMap<String, String> sn = new TreeMap();
		Set<String> set = map.keySet(); // key(id)를 모아 Set으로 반환
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Member m = map.get(key);
			if(m.getName().equals(name)) {
				sn.put(key, name);
			}
		}
		return sn;
	}

}
