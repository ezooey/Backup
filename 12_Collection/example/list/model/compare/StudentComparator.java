package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> { // 제네릭 해줘야 Student로 매개변수 나온다

	@Override
	public int compare(Student o1, Student o2) {
		// 비교 주체 : o1
//		int standard = o1.getScore();
		Integer standard = o1.getScore(); // int는 객체가 아니기 때문에 안 된다
		// 비교 대상 : o2
//		int object = o2.getScore();
		Integer object = o2.getScore(); 
		
		// 오름차순
		// 비교 주체가 비교 대상보다 크면 1
		// 비교 주체가 비교 대상과 같으면 0
		// 비교 주체가 비교 대상보다 작으면 -1 반환
		// 문자열이 아니므로 직접 오름차순 규칙을 따라 지정해줌
		
//		if(standard > object) {
//			return 1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return -1;
//		}
		
		// 내림차순
//		if(standard > object) {
//			return -1;
//		} else if(standard == object) {
//			return 0;
//		} else {
//			return 1;
//		}
		
//		return standard.compareTo(object);
		
		// compareTo의 반환 값은 int
		
		int result = -standard.compareTo(object); // 점수 먼저 비교한 결과값 
//		 레퍼 클래스로 만들어줘야 이 문장 사용가능 (13, 16줄의 Integer로 설정한 것)
		String standardName = o1.getName(); // 비교 주체 이름
		String objectName = o2.getName();	// 비교 대상 이름
		
		if(result == 0) { // 점수가 같을 때
			return standardName.compareTo(objectName); // 이름은 오름차순으로 기준 설정
		} else {
			return result;
		} 
	}
	
}
