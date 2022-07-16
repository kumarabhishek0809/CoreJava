package core.threads.core.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFutureTest ct = new CompletableFutureTest();

        Future<String> completableFuture = ct.calculateAsync();
        String result = completableFuture.get();
        System.out.println("Hello"+ result);


        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        System.out.println("test 2" +completableFuture2.get());
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }
}
