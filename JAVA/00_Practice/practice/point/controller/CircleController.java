package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	public String calcArea(int x, int y, int radius) { // 원 면적 = PI*반지름*반지름
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double calcArea = Math.PI * radius * radius;
		
		return "면적 : " + x + ", " + y + ", " + radius + " / " + calcArea;
	}
	public String calcCircum(int x, int y, int radius) { // 원 둘레 = PI*반지름*2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double calcCircum = Math.PI * radius * 2;
		
		return "둘레 : " + x + ", " + y + ", " + radius + " / " + calcCircum;
	}

}
