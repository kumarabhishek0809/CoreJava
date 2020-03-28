package core.threads.reenterant;

import java.util.concurrent.locks.ReentrantLock;

class Worker {

}

public class ReEnterantLockTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

       public static void counter() {
           lock.lock();
        for (int i = 0; i < 100000000; i++) {
            counter++;
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        Worker worker = new Worker();
        Thread t1 = new Thread(() -> {
            counter();
        });

        Thread t2 = new Thread(() -> {
            counter();
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution Finished  "+counter);
    }
}
