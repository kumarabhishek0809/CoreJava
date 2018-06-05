package core.threads.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class RecursiveActionMaximumFinder extends RecursiveTask<Integer> {
    private List<Integer> numbers;
    private int lowIndex;
    private int hightIndex;

    public RecursiveActionMaximumFinder(List<Integer> numbers, int lowIndex, int hightIndex) {
        this.numbers = numbers;
        this.lowIndex = lowIndex;
        this.hightIndex = hightIndex;
    }

    @Override
    protected Integer compute() {
        if ((hightIndex - lowIndex) < Runtime.getRuntime().availableProcessors()) {
            System.out.println("Sequential");
            return maxfinder();
        } else {
            System.out.println("Parallel");
            int middleIndex = (lowIndex + hightIndex) / 2;
            RecursiveActionMaximumFinder recursiveActionMaximumFinder1 = new RecursiveActionMaximumFinder(numbers, lowIndex, middleIndex);
            RecursiveActionMaximumFinder recursiveActionMaximumFinder2 = new RecursiveActionMaximumFinder(numbers, middleIndex + 1, hightIndex);
            invokeAll(recursiveActionMaximumFinder1, recursiveActionMaximumFinder2);
            return Math.max(recursiveActionMaximumFinder1.join(), recursiveActionMaximumFinder2.join());

        }

    }

    private int maxfinder() {
        return numbers.parallelStream().mapToInt(v -> v).max().getAsInt();

    }

}

public class ParallelMaximumFinder {
    public static void main(String[] args) {
        List<Integer> numbers = populateNumbers();
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        RecursiveActionMaximumFinder recursiveActionMaximumFinder = new RecursiveActionMaximumFinder(numbers, 0, numbers.size());
        System.out.println("Max =="+forkJoinPool.invoke(recursiveActionMaximumFinder));

    }

    private static List<Integer> populateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i =0;i<100444000;i++){
            Random random = new Random();
            int nextInt = random.nextInt(14400000);
            numbers.add(nextInt);
            System.out.println("nextInt "+nextInt);
        }
        return numbers;
    }
}
