package core.collections.concurrent;

import java.util.concurrent.*;

class Producer implements Callable<Integer> {
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public Integer call() throws Exception {
        int counter = 1;
        while (true) {
            blockingQueue.put(counter);
            //blockingQueue.offer(counter);
            counter++;
            System.out.println("Inside Producer "+counter);
        }
    }
}

class Consumer implements Callable<Integer> {
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public Integer call() throws Exception {
        while (true) {
            //Integer counter = blockingQueue.peek();
            Integer take = blockingQueue.take();
            System.out.println("Inside Consumer "+take);
        }
    }
}

public class ArrayBlockingQueueTest {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService execService = Executors.newFixedThreadPool(1);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(execService);
        completionService.submit(new Producer(blockingQueue));
        completionService.submit(new Consumer(blockingQueue));
        execService.shutdown();
        try {
            while (!execService.isTerminated()) {
                int result = completionService.take().get().intValue();
                System.out.println("Result is: " + result);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
        System.out.println("done!");
    }

}
