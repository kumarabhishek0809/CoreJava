package core.collections.concurrent;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapNullKeyTest {
	
	private Map<String, String> nullTestConcurrentHashMap = new TreeMap<>();
	public static void main(String[] args) {
		TreeMapNullKeyTest concurrentHashMapTest = new TreeMapNullKeyTest();
		concurrentHashMapTest.testConcurrentHashMapNull();
	}
	private void testConcurrentHashMapNull() {
		nullTestConcurrentHashMap.put(null,"WhyNot");
		
	}

}
