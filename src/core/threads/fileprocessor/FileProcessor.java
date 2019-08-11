package core.threads.fileprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileProcessor {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// String source = args[0];
		String source = "Server.log";
		// String output = args[1];
		String output = "Server.log.split";
		Split split = new Split();
		List<String> splitFiles = split.splitFiles(source, output);
		splitFiles.parallelStream().forEach(fileName -> System.out.println(fileName));
		
		ConcurrentHashMap<String, Integer> sharedMap = new ConcurrentHashMap<String, Integer>(); 
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
		ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);
		
		CompletableFuture<Boolean> completableFuture = new CompletableFuture<Boolean>();
		new FileReader(sharedMap,"");
	}
}
