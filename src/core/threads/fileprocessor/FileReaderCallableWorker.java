package core.threads.fileprocessor;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileReaderCallableWorker<Boolean> implements Callable<Boolean> {

	private ConcurrentHashMap<String, Integer> sharedMap;
	private String filePath;
	private String REGEX = ",";

	public FileReaderCallableWorker(ConcurrentHashMap<String, Integer> sharedMap, String filePath) {
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
					//sharedMap.computeIfAbsent(data, mappingFunction)
					if (sharedMap.contains(data)) {
						sharedMap.put(data, sharedMap.get(data) + 1);
					} else {
						sharedMap.put(data, 1);
					}
				}
			});
		}
		return (Boolean) new java.lang.Boolean(true);
	}

}
