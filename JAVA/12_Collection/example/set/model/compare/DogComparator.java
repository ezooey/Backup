package com.kh.example.set.model.compare;

import java.util.Comparator;

import com.kh.example.set.model.vo.Dog;

public class DogComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		String standard = o1.getName();
		String object = o2.getName();
		
		int result = standard.compareTo(object);
		if(result == 0) { // 이름이 같을 때
			Double standardWeight = o1.getWeight();
			Double objectWeight = o2.getWeight();
			return standardWeight.compareTo(objectWeight);
		} else {
			return result;
		}
		
//		return standard.compareTo(object);
		
		
	}
	
	

}
