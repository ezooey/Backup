package com.kh.example.family.model.vo;

public class Baby extends Family implements Basic {	// �տ� �� extends�� ���� �ʿ�� ����
	public Baby() {}
	public Baby(String name, double weight, int health) {
		super(name, weight, health);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public void eat() {
		super.setWeight(super.getWeight() + 3);
		super.setHealth(super.getHealth() + 1);
		
	}
	@Override
	public void sleep() {
		super.setHealth(super.getHealth() + 3);
		
	}
	
//	public void eat() {
//		super.setWeight(super.getWeight() + 3);
//		super.setHealth(super.getHealth() + 1);
//	}
//	
//	public void sleep() {
//		super.setHealth(super.getHealth() + 3);
//	}

}
