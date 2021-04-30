package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		// 자료구조는 데이터가 중심, 객체인지 그런것보단 내용 중심.
		String ks1 = "one";

		map.put(ks1, 1); // auto boxing
		map.put("two", 2);
		map.put("three", 3);

		int i = map.get(ks1); // auto unboxing
		int j = map.get(new String("one"));

		System.out.println(i + " : " + j);

		map.put("three", 33333);
		System.out.println(map.get("three"));
		System.out.println();

		// 순회
		Set<String> s = map.keySet();

		for (String key : s) {
			int val = map.get(key);
			System.out.println(val);
		}

	}
}