package core.collections.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapNullKeyTest {
	
	private Map<String, String> nullTestConcurrentHashMap = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		ConcurrentHashMapNullKeyTest concurrentHashMapTest = new ConcurrentHashMapNullKeyTest();
		concurrentHashMapTest.testConcurrentHashMapNull();
	}
	private void testConcurrentHashMapNull() {
		nullTestConcurrentHashMap.put(null,"WhyNot");
		//nullTestConcurrentHashMap.containsKey(null);

	}

}
