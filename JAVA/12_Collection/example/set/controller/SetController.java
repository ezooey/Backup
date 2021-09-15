package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.kh.example.set.model.compare.DogComparator;
import com.kh.example.set.model.vo.Dog;

public class SetController {
	public void doSet() {
		HashSet<Dog> set = new HashSet<Dog>();
		// add(E e):boolean		set 안에 e 추가
		set.add(new Dog("자두", 6.4));
		set.add(new Dog("두이", 4));
		set.add(new Dog("호두", 3.4));
		System.out.println(set); 
		// [자두(6.4kg), 호두(3.4kg), 두이(4.0kg)]
		// 순서 유지 안 됨
		
		set.add(new Dog("자두", 6.4));
		System.out.println(set);
		// 오버라이딩 전 : [두이(4.0kg), 자두(6.4kg), 자두(6.4kg), 호두(3.4kg)]
		// equals, hashCode 오버라이딩 없이는 중복추가된다 => 같은 주소값인 걸 인지하지 못 하기 때문
		// 오버라이딩 후 : [자두(6.4kg), 호두(3.4kg), 두이(4.0kg)]
		
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2);
		// [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg)] 
		// 오버라이딩 후라서 초코 중복추가 안 됨
		
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		System.out.println(set2);
		// [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg), 로이(6.1kg), 공주(5.2kg), 왕자(9.5kg), 조이(12.5kg)]
		
		// 요소 가져오기 1. Set을 List로 바꾸기
		ArrayList<Dog> list = new ArrayList<Dog>(set2); // set2의 내용을 List에 집어넣음
		System.out.println(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}


		// 요소 가져오기 2. iterator 이용
		Iterator<Dog> it = set2.iterator();
		while(it.hasNext()) {
			Dog d = it.next();
			System.out.println(d);
		}
		// set은 ListIterator 불가능
//		초코(2.1kg)
//		콩이(8.3kg)
//		두부(5.0kg)
//		로이(6.1kg)
//		공주(5.2kg)
//		왕자(9.5kg)
//		조이(12.5kg)
		
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2); // 내림차순 정렬
		System.out.println(set3);
//		[조이(12.5kg), 왕자(9.5kg), 콩이(8.3kg), 로이(6.1kg), 공주(5.2kg), 두부(5.0kg), 초코(2.1kg)]
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogComparator()); // 이름, 무게로 이중정렬
		set4.addAll(set3);
		set4.add(new Dog("로이", 2.1));
		System.out.println(set4);		
		// 이름이 같아서 무게가 다른 로이를 추가하려고 해도 안 됨 
		// => DogComparator에서 compareTo를 이용해서 기준을 하나 더 추가한다 
//		[공주(5.2kg), 두부(5.0kg), 로이(2.1kg), 로이(6.1kg), 왕자(9.5kg), 조이(12.5kg), 초코(2.1kg), 콩이(8.3kg)]
		
	}

}
