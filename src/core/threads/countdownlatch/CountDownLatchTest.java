package core.threads.countdownlatch;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Callable<String> {

    private int id;
    private CountDownLatch countDownLatch;

    public Worker(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        doWork();
        countDownLatch.countDown();
        return "";
    }

    private void doWork() throws InterruptedException {
        System.out.println("Thread With Id " + id + " Starts Working");
        Thread.sleep(1000);
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker(i, countDownLatch));
        }
        countDownLatch.await();
        System.out.println("all the process is done");

    }
}
