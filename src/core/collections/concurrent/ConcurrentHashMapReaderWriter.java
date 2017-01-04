package core.collections.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapReaderWriter {
	
	private Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
	public static void main(String[] args) {
		ConcurrentHashMapReaderWriter concurrentHashMapTest = new ConcurrentHashMapReaderWriter();
		concurrentHashMapTest.testConcurrentHashMapNull();
	}
	private void testConcurrentHashMapNull() {
		new Thread(new WriterThread(concurrentHashMap)).start();
		new Thread(new ReaderThread(concurrentHashMap)).start();
		
	}

}
