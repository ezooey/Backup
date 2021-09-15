package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();

	public boolean insertObject(Lottery l) {
		boolean result = lottery.add(l);
		return result;
	}
	
	public boolean deleteObject(Lottery l) {
		boolean result = lottery.remove(l);
		if(result && win != null) { 
		// 삭제할 요소가 있으면 true를 반환하고 삭제하므로 result만 넣어도 true일 때 if문 실행 
			win.remove(l);
		}
		return result;
	}
	
	public HashSet<Lottery> winObject() {
		ArrayList<Lottery> list = new ArrayList<>(lottery);
		while(win.size() != 4) {
			int num = (int)(Math.random() * list.size());
			win.add(list.get(num));
		}
		
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> sort = new TreeSet<Lottery>(new SortedLottery()); 
		// 정렬 클래스(SortedLottery())를 기준으로 세워주기
		sort.addAll(win);
		
		return sort;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
	
}
