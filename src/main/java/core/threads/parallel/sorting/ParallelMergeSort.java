package core.threads.parallel.sorting;

import java.util.Random;
import java.util.stream.IntStream;

public class ParallelMergeSort {
    private int[] numbers;
    private int[] tempNumers;

    public static void main(String[] args) {
        int[] numbers = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(numbers);
        parallelMergeSort.parallelMergeSort(0,numbers.length,2);
        parallelMergeSort.showResult();

    }

    private void showResult() {
        for(int i = 0; i < numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }

    public ParallelMergeSort(int[] numbers) {
        this.numbers = numbers;
        this.tempNumers = new int[numbers.length];
    }

    private Thread mergeSortWorker(int low, int high, int noOfThreads) {
        return new Thread(() -> {
            parallelMergeSort(low, high, noOfThreads / 2);
        });
    }

    private void parallelMergeSort(int low, int high, int noOfThreads) {
        if (noOfThreads <= 1) {
            mergeSort(low, high);
            return;
        }
        int middleIndex = (low + high) / 2;
        Thread leftMergeSorter = mergeSortWorker(low, middleIndex, noOfThreads);
        Thread rightMergeSorter = mergeSortWorker(middleIndex, high, noOfThreads);
        leftMergeSorter.start();
        rightMergeSorter.start();
        try {
            leftMergeSorter.join();
            rightMergeSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(low, middleIndex, high);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i < high; i++) {
            tempNumers[i] = numbers[i];
        }
        int i = low;
        int j = middle;
        int k = high;
        while ((i <= middle) && (j <= high)) {
            if (tempNumers[i] <= tempNumers[j]) {
                numbers[k] = tempNumers[i];
                i++;
            } else {
                numbers[k] = tempNumers[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = tempNumers[i];
            k++;
            i++;
        }

    }
}
