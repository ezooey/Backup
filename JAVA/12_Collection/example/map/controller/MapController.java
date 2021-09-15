package com.kh.example.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		HashMap<String, Snack> map = new HashMap<String, Snack>();
		
		// put(K key, V value):V		키와 값을 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));
		System.out.println(map);
//		{다이제=단맛[2500원], 새우깡=짠맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]}
		// 순서유지 안 됨, 가격도 1500인 게 두 개지만 중복 아닌 것으로 처리
		
		map.put("새우깡", new Snack("매운맛", 1500));
		System.out.println(map);
//		{다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]}
		// 같은 값이 들어가서 매운맛으로 덮어씌워졌음
		
		// containsKey(Object key):boolean			해당 key가 있는지 확인
		// containsValue(Object value):boolean		해당 value가 있는지 확인
		System.out.println(map.containsKey("새우깡")); // true
		System.out.println(map.containsValue(new Snack("짠맛", 1500))); 
		// 주소값 달라서 false, equals & hashCode 오버라이딩 후엔 true
		
		// get(Object key):V		키에 해당하는 값 반환
		System.out.println(map.get("다이제")); // 단맛[2500원]
		System.out.println(map.get("홈런볼")); // null
		
		// values():Collection<V>		모든 value를 Collection에 담아 반환
		System.out.println(map.values());
//		[단맛[2500원], 매운맛[1500원], 짠맛[1500원], 고소한맛[1000원]]
		
		// keySet():Set<K>			Map 안에 있는 key들을 모아 Set으로 반환
		Set<String> set1 = map.keySet();
		// Set의 타입은 key인데 key는 String 타입이므로 Set도 String으로 제네릭
		System.out.println(set1);
//		[다이제, 새우깡, 포테이토칩, 고소미]
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {			// key들을 모아놓고 Map으로 가져오는 방식 11시 25분쯤
			String key = it1.next();
			System.out.println(key + "=" + map.get(key));	// key만 있었기 때문에 value를 가져오려면 get(key)해줘야
		}
//		다이제=단맛[2500원]
//		새우깡=매운맛[1500원]
//		포테이토칩=짠맛[1500원]
//		고소미=고소한맛[1000원]
		
		// entrySet():Set<Map.Entry<K,V>>	entry(key와 value)들을 모아 set으로 반환
		Set<Entry<String, Snack>> set2 = map.entrySet();
		System.out.println(set2);
//		[다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]]
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry.getKey() + "=" + entry.getValue()); // 둘 다 있어서 둘 다 get으로 가져오기 가능
//			다이제=단맛[2500원]
//			새우깡=매운맛[1500원]
//			포테이토칩=짠맛[1500원]
//			고소미=고소한맛[1000원]
		}
		
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2); // 정렬된 것
//		{고소미=고소한맛[1000원], 다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원]}
		
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackComparator());
		map3.putAll(map);
		System.out.println(map3);
//		{포테이토칩=짠맛[1500원], 새우깡=매운맛[1500원], 다이제=단맛[2500원], 고소미=고소한맛[1000원]}
		// comparator 해줬으므로 내림차순으로 나온다
		
		// remove(object key):V							해당 key의 entry 삭제 후 해당 값 반환
		System.out.println(map3.remove("다이제")); // 단맛[2500원]
		System.out.println(map3);
//		{포테이토칩=짠맛[1500원], 새우깡=매운맛[1500원], 고소미=고소한맛[1000원]}
		// remove(Object key, Object value):boolean		해당 키와 값이 모두 맞으면 삭제 후 true 반환
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1500))); // false
		System.out.println(map3);
//		{포테이토칩=짠맛[1500원], 새우깡=매운맛[1500원], 고소미=고소한맛[1000원]}
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1000))); // true
		System.out.println(map3);
//		{포테이토칩=짠맛[1500원], 새우깡=매운맛[1500원]}
		
		// clear():void			모든 entry 삭제
		// isEmpty():boolean	map이 비어있는지 확인
		map3.clear();
		System.out.println(map3); // {}
		System.out.println(map3.isEmpty()); // true
	}
	
	public void doProperties() {
		// Properties : key와 value의 타입을 String으로 제한
		Properties prop = new Properties();
//		prop.put(1, 10);	
//		System.out.println(prop); // {1=10}
		// String 타입으로 제한돼 있다고 하는데 int 값이 들어간다 => HashTable에 있는 메소드를 가져온 것
		// setProperty로 해줘야 String으로 제한된 프로퍼티가 됨
		
		// setProperty(String key, String value):Object		Properties에 데이터 추가
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		prop.setProperty("채소", "피망");
		System.out.println(prop);
//		{과일=사과, 채소=피망, 간식=젤리} ==> 같은 키가 있으면 덮어씌우는 것을 확인
		
		// getProperty(String key):String		key를 통해 value반환
		// getProperty(String key, String defaultValue):String		key를 통해 value반환, 해당 key가 없으면 defaultValue반환
		System.out.println(prop.getProperty("채소")); // 피망
		System.out.println(prop.getProperty("견과")); // null
		System.out.println(prop.getOrDefault("채소", "땅콩")); // 피망	=> 채소가 있으니 피망 출력
		System.out.println(prop.getOrDefault("견과", "땅콩")); // 땅콩	=> 견과가 없으니 땅콩 출력 
	}

}
