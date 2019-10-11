package core.threads.fileprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProcessor {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		ExecutorService WORKER_THREAD_POOL = null;
		try {
			String source = "Server.log";
			String output = "Server.log.split";
			
			Split split = new Split();
			List<String> splitFiles = Split.splitFiles(source, output);
			List<Callable<Boolean>> readers = new ArrayList<Callable<Boolean>>();
			ConcurrentHashMap<String, Integer> sharedMap = new ConcurrentHashMap<String, Integer>();
			int availableProcessors = Runtime.getRuntime().availableProcessors();
			WORKER_THREAD_POOL = Executors.newFixedThreadPool(availableProcessors);

			/*
			 * do not trust this way it will fail in multiple executions.
			 * 
			 * splitFiles.parallelStream().forEach(fileName -> { readers.add(new
			 * FileReaderCallableWorker(sharedMap, fileName)); });
			 * 
			 * List<Future<Boolean>> futures = WORKER_THREAD_POOL.invokeAll(readers);
			 * awaitTerminationAfterShutdown(WORKER_THREAD_POOL);
			 */

			/* approach 2 with latch */
			availableProcessors = splitFiles.size() > availableProcessors ? availableProcessors : splitFiles.size();
			System.out.println("availableProcessors    :::: "+availableProcessors);
			CountDownLatch latch = new CountDownLatch(availableProcessors);
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

			for (String fileName : splitFiles) {
				Future<Boolean> future = service.take(); // this will hung if threads already completed.
				Boolean firstThreadResponse = future.get();
				long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
				//awaitTerminationAfterShutdown(WORKER_THREAD_POOL);
				System.out.println("Total Time taken :::" + totalProcessingTime);
			}
 */
			sharedMap.keySet()
					.forEach(key -> System.out.println("Key ::: " + key + "           Value :::" + sharedMap.get(key)));

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
			if (!threadPool.awaitTermination(180, TimeUnit.SECONDS)) {
				threadPool.shutdownNow();
			}
		} catch (InterruptedException ex) {
			threadPool.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}
