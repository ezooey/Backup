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
		// ���� �� �Ű������� �ʱ�ȭ���� �ʾ���
		// �׷��� ���� �ҷ��� setter �޼ҵ带 ���´�
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
//		// �׳� super.name�̶�� �ϸ� ���������ڿ� �ɸ�
//	}

//	@Override
//	public String inform() {
//		return super.inform() + " " + height + " " + hair;
//	}
	
	@Override		// �������̵� �� ������ �ּҰ��� ��ǥ���� �Ǿ� ��µ� (toString �⺻����)
	public String toString() {
		return super.toString() + " " + height + " " + hair;
	}
}
