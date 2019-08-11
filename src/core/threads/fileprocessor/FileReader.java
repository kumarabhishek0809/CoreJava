package core.threads.fileprocessor;

import java.util.concurrent.ConcurrentHashMap;

public class FileReader implements Runnable {
	
	private ConcurrentHashMap<String, Integer> sharedMap;
	private String filePath;
	
	public FileReader(ConcurrentHashMap<String, Integer> sharedMap, String filePath) {
		this.sharedMap = sharedMap;
		this.filePath = filePath;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
