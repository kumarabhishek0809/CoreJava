package core.java8.features.stream;

import java.util.HashMap;
import java.util.Map;

public class SortMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(a -> System.out.println(a));
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(a -> System.out.println(a));

	}
}
