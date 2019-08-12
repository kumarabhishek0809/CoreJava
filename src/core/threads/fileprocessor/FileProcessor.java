package core.threads.fileprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProcessor {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		ExecutorService WORKER_THREAD_POOL = null;
		try {
			// String source = args[0];
			String source = "Server.log";
			// String output = args[1];
			String output = "Server.log.split";
			Split split = new Split();
			List<String> splitFiles = Split.splitFiles(source, output);
			List<Callable<Boolean>> readers = new ArrayList<Callable<Boolean>>();
			ConcurrentHashMap<String, AtomicInteger> sharedMap = new ConcurrentHashMap<String, AtomicInteger>();
			int availableProcessors = Runtime.getRuntime().availableProcessors();
			WORKER_THREAD_POOL = Executors.newFixedThreadPool(availableProcessors);

			/*
			 * approach 1 with await and invoke all
			 * splitFiles.parallelStream().forEach(fileName -> { readers.add(new
			 * FileReaderCallableWorker(sharedMap, fileName)); });
			 * 
			 * List<Future<Boolean>> futures = WORKER_THREAD_POOL.invokeAll(readers);
			 * awaitTerminationAfterShutdown(WORKER_THREAD_POOL);
			 * 
			 */

			/* approach 2 with latch */
			CountDownLatch latch = new CountDownLatch(availableProcessors - 1);
			for (String fileName : splitFiles) {
				WORKER_THREAD_POOL.submit(new FileReaderCallableLatchWorker(sharedMap, fileName, latch));
			}
			latch.await();

			/*
			 * approach 3
			 
			CompletionService<Boolean> service = new ExecutorCompletionService<>(WORKER_THREAD_POOL);

			for (String fileName : splitFiles) {
				WORKER_THREAD_POOL.submit(new FileReaderCallableWorker(sharedMap, fileName));
			}

			long startProcessingTime = System.currentTimeMillis();
			 
			Future<Boolean> future = service.take();
			Boolean firstThreadResponse = future.get();
			long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
			
			awaitTerminationAfterShutdown(WORKER_THREAD_POOL);
			System.out.println("Total Time taken :::" +totalProcessingTime);
			
			*/
			
			sharedMap.keySet().forEach(key -> System.out.println("Key ::: " + key + "           Value :::" + sharedMap.get(key)));

		} catch (InterruptedException e) {// thread was interrupted
			e.printStackTrace();
		} finally {

			// shut down the executor manually
			if (WORKER_THREAD_POOL != null) {
				WORKER_THREAD_POOL.shutdown();
			}

		}

		/*
		 * CompletableFuture<Boolean> completableFuture = new
		 * CompletableFuture<Boolean>(); completableFuture.supplyAsync(() -> {
		 * 
		 * return true;
		 * 
		 * }, executor); new FileReaderWorker(sharedMap,"");
		 */
	}

	public static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
		threadPool.shutdown();
		try {
			if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
				threadPool.shutdownNow();
			}
		} catch (InterruptedException ex) {
			threadPool.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}
