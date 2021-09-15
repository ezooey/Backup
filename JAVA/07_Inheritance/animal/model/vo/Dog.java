package com.kh.example.animal.model.vo;

public class Dog extends Animal{
	private double height;
	private String hair;
	
	public Dog() {}
	public Dog(String name, int age, double weight, double height, String hair) {
//		super.setName(name);
//		super.setAge(age);
//		super.setWeight(weight);
		
		super(name, age, weight);
		this.height = height;
		this.hair = hair;
		// 앞의 세 매개변수는 초기화되지 않았음
		// 그래서 값을 불러올 setter 메소드를 적는다
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getHair() {
		return hair;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	
//	@Override
//	public String inform() {
//		return super.getName() + " " + super.getAge() + " " + super.getWeight() + " " + height + " " + hair; 
//		// 그냥 super.name이라고 하면 접근제한자에 걸림
//	}

//	@Override
//	public String inform() {
//		return super.inform() + " " + height + " " + hair;
//	}
	
	@Override		// 오버라이딩 안 했으면 주소값이 대표값이 되어 출력됨 (toString 기본원리)
	public String toString() {
		return super.toString() + " " + height + " " + hair;
	}
}
