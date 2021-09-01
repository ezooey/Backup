package com.kh.example.set.model.vo;

public class Dog implements Comparable<Dog>{
	private String name;
	private double weight;
	public Dog() {}
	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + "(" + weight + "kg)";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null) { // 나는 형체가 있는데 상대가 없으면 다른 것
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Dog other = (Dog)obj;
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		} else if(!name.equals(other.name)) {
			return false;
		}
		if(weight != other.weight) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() { 
		final int PRIME = 31; 
		int result = 1;
		result = PRIME * result + (name == null ? 0 : name.hashCode());
		result = PRIME * result + (int)weight;
		
		return result;
	}
	
	@Override
	public int compareTo(Dog o) {
//		double object = o.weight;
//		
		// 내림차순
//		if(weight > object) {
//			return -1;
//		} else if(weight == object) {
//			return 0;
//		} else {
//			return 1;
//		}
		// 아래로 써도 똑같이 나옴
		Double standard = weight;
		Double object = o.weight;
		return -standard.compareTo(object);
	} 
}
