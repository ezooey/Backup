package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.practice.generics.model.vo.Farm;

public class FarmController {
	private HashMap<Farm, Integer> hMap = new HashMap<Farm, Integer>();
	private ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		boolean check = hMap.containsKey(f);
		if(check) { // 전달 받은 f가 key로 존재할 때
			return false;
		} else {
			hMap.put(f, amount);	// 존재하지 않을 때 저장
			return true;
		}
	}
	
	public boolean removeKind(Farm f) {
		boolean check = hMap.containsKey(f);
		if(check) { // 전달 받은 f가 key로 존재할 때
			hMap.remove(f);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean changeAmout(Farm f, int amount) {
		boolean check = hMap.containsKey(f);
		if(check) {
			hMap.put(f, amount);	// 존재할 때 저장(수정); 키 중복 => 덮어씌움
			return true;
		} else {
			return false;
		}
	}
	
	public HashMap<Farm, Integer> printFarm(){
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		boolean check = hMap.containsKey(f);
		int oldA = hMap.get(f);
		if(check) {
			if(oldA >= 0) {
				list.add(f);
				hMap.put(f, (oldA - 1));
				return true;
			}
		}
			return false;
	}
	
	public boolean removeFarm(Farm f) {
		boolean check = list.contains(f);
		int oldA = hMap.get(f);
		if(check) {
			list.remove(f);
			hMap.put(f, (oldA + 1));
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Farm> printBuyFarm(){
		return list;
	}
}
