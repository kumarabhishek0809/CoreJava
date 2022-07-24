package core.threads.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class TestCompletableFutureWithThreadPool {

	public static ForkJoinPool fjp = new ForkJoinPool(10);

	public static int compute() {
		System.out.println("Compute :" + Thread.currentThread());
		return 2;
	}

	public static void printIt(int value) {
		System.out.println(value);
		System.out.println("PrintIT " + Thread.currentThread());
	}

	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute(), fjp);
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main : " + Thread.currentThread());
		CompletableFuture<Integer> completableFuture = create();
		sleep(1000);

		completableFuture.thenAccept(TestCompletableFutureWithThreadPool::printIt);

	}

	private static void sleep(int i) {

		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
