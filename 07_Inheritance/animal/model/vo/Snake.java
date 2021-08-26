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
//		//super.getName() + " " + super.getAge() + " " + super.getWeight()�̶�� �� ���� �̷��� ��� ��
//	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + pattern;
//	}

	@Override		// �������̵� �� ������ �ּҰ��� ��ǥ���� �Ǿ� ��µ� (toString �⺻����)
	public String toString() {
		return super.toString() + " " + pattern;
	}
}
