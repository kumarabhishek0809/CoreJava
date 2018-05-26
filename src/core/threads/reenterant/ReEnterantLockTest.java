package core.threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReEnterantLockTest {

    private ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    private void counter(){
        counter++;
        System.out.println("Counter "+counter);
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2" + i);
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
        System.out.println("Execution Finished");
    }
}
