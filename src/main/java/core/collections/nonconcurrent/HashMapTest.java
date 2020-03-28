package core.collections.nonconcurrent;

import java.util.HashMap;

public class HashMapTest {
private HashMap<Integer,String> hashMap = new HashMap<>();
	
	public static void main(String[] args) {
		HashMapTest hashtableTest = new HashMapTest();
		hashtableTest.testNullableKey();
		System.out.println();
	}

	private void testNullableKey() {
		hashMap.put(null,"Will Fail");
		hashMap.put(0, "Without Faile");
		for(Integer i : hashMap.keySet()){
			System.out.println(hashMap.get(i));
		}
	}
}
