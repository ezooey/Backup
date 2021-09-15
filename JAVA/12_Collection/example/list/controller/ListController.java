package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		ArrayList l = new ArrayList(); // 크기 10개로 기본 생성
// ArrayList is a raw type. 
// References to generic type ArrayList<E> should be parameterized		
// 타입 제한 안 하면 기본으로 Object로 설정되어 다양한 자료형이 들어갈 수 있다
// 이렇게는 잘 사용하지 않음		
		l.add("박신우");
		l.add(20);
		l.add(new Student());
//		System.out.println(l);
		
		ArrayList<Student> list = new ArrayList<Student>(3); // 크기가 3인 ArrayList
		// add(E e): boolean	리스트 끝에 데이터 추가
		list.add(new Student("테스트", 0));
		list.add(new Student("도대담", 60));
		list.add(new Student("남나눔", 90));
		System.out.println(list); // 순서 유지
		
		list.add(new Student("하현호", 85));
		System.out.println(list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		list.add(new Student("문미미", 66));
		System.out.println(list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		// 컬렉션 장점1. 크기 제약이 없다
		
		// 컬렉션 장점2. 추가/삭제/정렬 등의 기능처리 간단
		// add(int index, E e):void		index번째 인덱스에 E 추가
		list.add(0, new Student("류라라", 100));
		System.out.println(list);
		list.add(3, new Student("강건강", 40));
		System.out.println(list);
		
		// remove(int index):E		해당 index번째 객체 삭제
		list.remove(1);
		System.out.println(list);
		// remove(Object o):boolean 	해당 Object객체 삭제
		list.remove(new Student("강건강", 40)); // 다른 객체(주소값)로 인식해서 지워지지 않음
		// 오버라이딩으로 같은 객체라는 것을 알려줘야 함
		// for문으로도 가능
		System.out.println(list); // 11시
		
//		ArrayList<String> test = new ArrayList<String>();
//		test.add("전은정");
//		test.add("곽우찬");
//		test.add("나은혜");
//		test.add("이현애");
//		System.out.println(test);
//		Collections.sort(test);
//		System.out.println(test);
		// 이미 정렬이 돼 있다
		
		Collections.sort(list); // 하지만 이것은 이름으로 할지 점수로 할지 기준이 불분명
		// The method sort(List<T>) in the type Collections is not 
		// applicable for the arguments (ArrayList<Student>)
		// 기준 세워줬기 때문에 경고메시지 사라짐
		System.out.println(list);
		Collections.sort(list, new StudentComparator());
		System.out.println(list);
		
		list.add(new Student("박보배", 85));
		list.sort(new StudentComparator());
		System.out.println(list);
		
		// set(int index, E e):E	index번째에 있는 요소를 E로 수정
		list.set(3, new Student("박보배", 85)); // 중복 허용
		System.out.println(list); 
		
		// get(int index):E			index번째에 있는 요소 반환
		Student s = list.get(2);
		System.out.println(s);
		System.out.println(list);
		
		// contains(Object o):boolean		o가 리스트에 존재하는지 확인, 있으면 true/없으면 false
		// indexOf(Object o):int			o가 리스트에 위치하는 인덱스 번호 반환
		
		System.out.println(list.contains(new Student("남나눔", 90))); // 이미 equals를 오버라이딩 해서 인식 가능
		System.out.println(list.indexOf(new Student("남나눔", 90)));
		System.out.println(list.indexOf(new Student("강건강", 45))); // 리스트에 없으면 -1 반환
		
		// Clear():void			저장된 모든 객체 삭제
		// isEmpty():boolean	리스트가 비어있는지 확인, 비어 있으면 true/ 비어 있지 않으면 false
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
		
		 
	}
	
}
