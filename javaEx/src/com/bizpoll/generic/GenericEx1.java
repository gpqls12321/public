package com.bizpoll.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericEx1 {

	public static void main(String[] args) {
		List list1 = new ArrayList();
		list1.add("hello");
		
		// String str1 = list1.get(0); ==> list1.get(0)이 Object 타입이라서 오류남.
		String str1 = (String) list1.get(0);
		System.out.println(str1);
		
		System.out.println("=============");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("hello");
		
		String str2 = list2.get(0);
		System.out.println(list2.get(0));
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "한혜빈");
		map.put("2", "홍길동");
		map.put("3", "어쩌고");
		map.put("4", "저쩌구");
		map.put("5", "김개똥");
		
		System.out.println(map);
		System.out.println(map.get("4"));
		
	}
}
