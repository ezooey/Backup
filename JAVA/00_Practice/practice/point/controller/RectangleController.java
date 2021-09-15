package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	public String calcArea(int x, int y, int height, int width) { // 면적 : 너비 * 높이
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int calcArea = width * height;
		
		return "둘레 : " + x + ", " + y + " " + height + " " + width + " / " + calcArea;
	}

	public String calcPerimeter(int x, int y, int height, int width) { // 둘레 : 2*(너비 + 높이)
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int calcPerimeter = 2 * (width + height);
		
		return "둘레 : " + x + ", " + y + " " + height + " " + width + " / " + calcPerimeter;
	}
}
