package core.threads.reenterant.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Worker {
    private static final int LIMIT = 3;
    private static final int BOTTOM = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    //private final Object lock = new Object();
    private List<Integer> storage = new ArrayList<>();
    private int value = 0;

    public void produce() throws InterruptedException {
        //synchronized (lock) {
        while (true) {
            lock.lock();
            if (storage.size() == LIMIT) {
                System.out.println("Storage is full");
                //lock.wait();
                condition.await();
            } else {
                storage.add(value++);
                System.out.println("Adding " + value);
                //lock.notify();
                condition.signalAll();
            }
            lock.unlock();
        }
        //}
    }

    public void consume() throws InterruptedException {
        //synchronized (lock) {
        while (true) {
            lock.lock();
            if (storage != null && storage.size() == BOTTOM) {
                System.out.println("Waiting");
                //lock.wait();
                condition.await();
            } else if (storage != null) {
                System.out.println("Removing Item " + storage.remove(--value));
                //lock.notify();
                condition.signalAll();
            }
            Thread.sleep(1000);
            lock.unlock();
        }
        //}
    }
}

public class ReEnterantWithConditionTest {

    public static void main(String[] args) {
        Worker processor = new Worker();
        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
