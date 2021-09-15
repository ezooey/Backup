package com.kh.homework.shape.controller;

import com.kh.homework.shape.model.vo.Shape;

public class ShapeController {
	private Shape s = new Shape();
	
	public double calcPerimeter(int type, double height, double width) { // 둘레
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);
		return (width + height) * 2;
	}
	public double calcArea(int type, double height, double width) {
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);
		if(type == 3) {
			return width * height * 0.5;
		} else {
			return width * height;
		}
			
	}
	public void  paintColor(String color) { // 색깔
		s.setColor(color);
	}
	public String print(int type) { 
		if(type == 3) {
			return "삼각형";
		} else {
			return "사각형";
		}
	}
	
	public String print() {
//		if(true) {
//			return "의 높이 또는 너비가 설정되지 않았습니다.";
//		} else {
			return s.inform();
//		}
	}
}
