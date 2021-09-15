package com.kh.example.animal.model.vo;

public class Snake extends Animal {
	private String pattern;
	
	public Snake() {}
	public Snake(String name, int age, double weight, String pattern) {
		super(name, age, weight);
		this.pattern = pattern;
	}
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
//	@Override
//	public String inform() {
//		return super.inform()+ " " + pattern; 
//		//super.getName() + " " + super.getAge() + " " + super.getWeight()이라고 안 쓰고 이렇게 적어도 됨
//	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + pattern;
//	}

	@Override		// 오버라이딩 안 했으면 주소값이 대표값이 되어 출력됨 (toString 기본원리)
	public String toString() {
		return super.toString() + " " + pattern;
	}
}
