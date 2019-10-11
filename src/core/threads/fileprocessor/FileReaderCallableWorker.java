package core.threads.fileprocessor;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileReaderCallableWorker<Boolean> implements Callable<Boolean> {

	private ConcurrentHashMap<String, AtomicInteger> sharedMap;
	private String filePath;
	private String REGEX = ",";

	public FileReaderCallableWorker(ConcurrentHashMap<String, AtomicInteger> sharedMap, String filePath) {
		System.out.println("Inside Constructor " + filePath);
		this.sharedMap = sharedMap;
		this.filePath = filePath;
	}

	@Override
	public Boolean call() throws Exception {
		System.out.println("Current Thread Name :::" + Thread.currentThread().getName());
		try (Stream linesStream = Files.lines(new File(filePath).toPath())) {
			linesStream.forEach(line -> {
				String string = line.toString();
				Pattern pattern = Pattern.compile(REGEX);
				String[] result = pattern.split((CharSequence) line);
				for (String data : result) {
					if (sharedMap.get(data) != null) {
						sharedMap.put(data, new AtomicInteger(sharedMap.get(data).get() + 1));
					} else {
						sharedMap.put(data, new AtomicInteger(1));
					}
				}
			});
		}
		return (Boolean) new java.lang.Boolean(true);
	}

}
