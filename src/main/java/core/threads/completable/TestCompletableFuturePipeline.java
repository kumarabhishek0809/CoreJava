package core.threads.completable;

import java.util.concurrent.CompletableFuture;

public class TestCompletableFuturePipeline {

	public static void process(CompletableFuture<Integer> future) {
		future.thenApply(data -> data * 2)//
				.thenAccept(System.out::println);
	}

	public static void main(String[] args) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		process(future);
		future.complete(2);
	}
}
