package core.threads.completable;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuture {

	public static int compute() {
		System.out.println("Compute :" + Thread.currentThread());
		return 2;
	}

	public static void printIt(int value) {
		System.out.println(value);
		System.out.println("PrintIT " + Thread.currentThread());
	}

	public static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute());
	}

	public static int handle(Throwable t) {
		System.out.println("Error : " + t);
		throw new RuntimeException("This is beyond exception");
//		return 100;
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main : " + Thread.currentThread());
		CompletableFuture<Integer> future = create();
		sleep(1000);

		future//
				.exceptionally(throwable -> handle(throwable))//
				.thenApply(data -> data * 2)//
				.thenApply(data -> data + 1)//
				.thenAccept(TestCompletableFuture::printIt)//
				.completeExceptionally(new RuntimeException("Something Went Wrong"));

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
