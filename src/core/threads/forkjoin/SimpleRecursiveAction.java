package core.threads.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class RecursiveWorker extends RecursiveAction {
    private int simulateWork;

    public RecursiveWorker(int simulateWork) {
        this.simulateWork = simulateWork;
    }

    @Override
    protected void compute() {
        if (simulateWork > 10) {
            System.out.println("Parallel Execution simulate work");
            RecursiveWorker recursiveWorker1 = new RecursiveWorker(simulateWork / 2);
            RecursiveWorker recursiveWorker2 = new RecursiveWorker(simulateWork / 2);
            recursiveWorker1.fork();
            recursiveWorker2.fork();
        }else {
            System.out.println("No Need of Parallel Execution ");
        }
    }
}

public class SimpleRecursiveAction {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        RecursiveWorker recursiveWorker = new RecursiveWorker(20);
        forkJoinPool.invoke(recursiveWorker);
    }
}
