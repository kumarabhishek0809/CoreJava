package core.collections.concurrent;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class WriterThread implements Runnable {
    private Map<String, String> concurrentHashmap;

    public WriterThread(Map<String, String> concurrentHashMap) {
        this.concurrentHashmap = concurrentHashMap;
    }

    @Override
    public void run() {
        int count = 0;
        Date startDate = new Date();
        while (true) {
            ++count;
            concurrentHashmap.put("count"+count, ""+count);
            if (count % 100 == 0) {
            }
        }
    }
}

class ReaderThread implements Runnable {
    private Map<String, String> concurrentHashmap;

    public ReaderThread(Map<String, String> concurrentHashMap) {
        this.concurrentHashmap = concurrentHashMap;
    }

    @Override
    public void run() {
        int count = 0;
        Date startDate = new Date();
        while (true) {
            ++count;
            concurrentHashmap.get(""+count);
            if (count % 10 == 0) {
            }
        }

    }
}

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

