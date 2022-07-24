package core.threads.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
	public static void main(String[] args) {
        System.out.println("Starting Completable Future Example..");
        CompletableFuture<String> basePrep = CompletableFuture.supplyAsync(() -> {
            System.out.println("Preparing Base");
           return "Base Ready";
        });
        CompletableFuture<String> topPrep = CompletableFuture.supplyAsync(() -> {
            System.out.println("Preparing Top");
            return "Toppings Ready";
        });
        CompletableFuture<String> foodPrep = basePrep.thenCombine(topPrep,(baseResponse,topResponse) ->{
           System.out.println("Top and Base are::"+baseResponse+":"+topResponse);
           return "Pizza Ready";
        });
        CompletableFuture<String> foodServe = foodPrep.thenCompose(food ->{
            System.out.println("Serving Food");
            return CompletableFuture.supplyAsync(()->"Food Served");
        });
        CompletableFuture<String> order = foodServe.thenApply(orderComplete -> "Oder Completed..");
        try{
            System.out.println(order.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
