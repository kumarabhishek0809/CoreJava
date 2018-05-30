package core.collections.nonconcurrent;

import java.util.Hashtable;

public class HashtableTest {
	private Hashtable<String,String> hashtable = new Hashtable<String,String>();
	
	public static void main(String[] args) {
		HashtableTest hashtableTest = new HashtableTest();
		hashtableTest.testNullableKey();
	}

	private void testNullableKey() {
		hashtable.put(null,"Will Fail");
		
	}

}
