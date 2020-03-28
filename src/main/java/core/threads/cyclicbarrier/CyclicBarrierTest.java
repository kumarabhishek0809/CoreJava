package core.threads.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.*;

class Worker implements Callable<String> {

    private int id;
    private CyclicBarrier cyclicBarrier;
    private Random random;

    public Worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    @Override
    public String call() throws Exception {
        cyclicBarrier.await();
        return "";
    }

    private void doWork() throws InterruptedException, BrokenBarrierException {
        System.out.println("Thread With Id " + id + " Starts Working");
        Thread.sleep(1000);

        System.out.println("After Finishing");

    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
            System.out.println("All the task are completed");
        });
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker(i, cyclicBarrier));
        }

    }
}
