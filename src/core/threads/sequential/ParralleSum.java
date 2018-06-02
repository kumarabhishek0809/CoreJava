package core.threads.sequential;

import java.util.Random;
import java.util.stream.IntStream;

class ParralleSumWorker extends Thread {
    private int[] nums;
    private int low;
    private int high;
    private int partialSum;

    public ParralleSumWorker(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        partialSum = 0;
        for (int i = low; i < high; i++) {
            partialSum += nums[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}

public class ParralleSum {
    private ParralleSumWorker[] sumWorkers ;
    private int noOfThreads;
    private int totalSum;

    public ParralleSum(int noOfThreads) {
        this.noOfThreads = noOfThreads;
        sumWorkers = new ParralleSumWorker[noOfThreads];
    }

    public static void main(String[] args) throws InterruptedException {
        int[] nums = IntStream.generate(() -> new Random().nextInt(100)).limit(100).limit(100).toArray();
        ParralleSum parralleSum = new ParralleSum(4);
        parralleSum.sum(nums);

    }

    public int sum(int[] num) throws InterruptedException {
        int steps = (int) Math.ceil(num.length * 1.0 / noOfThreads);
        for (int i = 0; i < noOfThreads; i++) {
            sumWorkers[i] = new ParralleSumWorker(num, i * steps, (i + 1) * steps);
            sumWorkers[i].start();
        }
        try {
            for (ParralleSumWorker parralleSumWorker : sumWorkers) {
                parralleSumWorker.join();
            }
        } catch (Exception e) {

        }

        for (ParralleSumWorker parralleSumWorker : sumWorkers) {
            totalSum += parralleSumWorker.getPartialSum();
        }
        System.out.println("Total Sum" + totalSum);
        return totalSum;
    }
}
