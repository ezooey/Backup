package com.kh.example.list.model.vo;

public class Student implements Comparable<Student>{ // 인터페이스 상속 받을 때는 강제 오버라이딩 필요하기 때문에 처음에 빨간줄
	private String name;
	private int score;
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return name + "(" + score + "점)";
	}
	
	@Override
	public boolean equals(Object obj) { // equals가 호출되었으므로 나라는 객체가 하나 생성된 것
		// 객체 측면
		if(this == obj) { // this : 나, 나와 주소값이 같다면 true
			return true;
		}
		if(obj == null) { // obj랑 null이랑 같다고 볼 수 없기 때문에 false
			return false;
		}
		if(getClass() != obj.getClass()) { // 내 클래스 정보를 가진 getClass와 obj가 가진 클래스 비교
			return false;
		}
		
		// 필드(데이터) 측면
		Student other = (Student)obj;
		if(name == null) { // 내꺼의 이름은 null
			if(other.name != null) { // other의 이름은 null이 아니면 false
				return false;
			}
		} else if(!name.equals(other.name)) { // 내꺼의 이름이 null이 아닐 때 other의 이름이랑도 같지 않으면 false
			return false;
		}
		if(score != other.score) { // int는 간단하게 한다 같지않으면 false 같으면 true
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() { // 해시코드의 값도 같아야 하기 때문에 오버라이딩 해줘야 함
		final int PRIME = 31; // 31이 컴퓨터가 계산하기에 적당히 크면서 가장 가까운 소수
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + score;
		
		return result; 		// 꼭 이런 식으로 써야 하는 건 아님 다양한 방법 존재
	}
//	@Override
//	public int compareTo(Object o) { // 제네릭으로 타입 제한 하지 않은 상태의 오버라이딩.
//		return 0;					 // 제한해줘야 하기 때문의 하단의 오버라이딩 사용
//	}
		
	@Override
	public int compareTo(Student o) {
		// 이름(String)으로 오름차순
		
		// 비교 주체(나)와 비교 대상(o)을 비교하는데
		// 비교 주체가 비교 대상과 같으면 0,
		// 비교 주체가 비교 대상보다 크면 1,
		// 비교 주체가 비교 대상보다 작으면 -1 반환하게 돼 있다 (compareTo, 오름차순 기본)
		return name.compareTo(o.name); // o.name이 비교할 이름, 이미 오름차순이니까 기준만 삼아주는 것
//		return -name.compareTo(o.name); // 앞에 마이너스 하나만 붙이면 위의 공식에 따라 결과가 뒤집힘(내림차순)
		
	}
	
	
}
