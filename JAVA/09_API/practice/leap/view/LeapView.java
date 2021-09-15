package com.kh.practice.leap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		Calendar c = new GregorianCalendar();
		int year = c.get(Calendar.YEAR);
		
		LeapController lc = new LeapController();
		boolean leap = lc.isLeapYear(year);
		if(leap) {
			System.out.println(year + "년은 윤년입니다.");
		} else {
			System.out.println(year + "년은 평년입니다.");
		}
		System.out.println("총 날짜 수 : " + lc.leapDate(c));
	}


}
