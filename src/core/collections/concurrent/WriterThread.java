package core.collections.concurrent;

import java.util.Date;
import java.util.Map;

public class WriterThread implements Runnable {
	private Map<String, String> chm;
	public WriterThread(Map<String, String> concurrentHashMap){
		this.chm = concurrentHashMap;
	}
	
	@Override
	public void run() {
		int count = 0;
		Date startDate = new Date();
		while (true) {
		++count;
		 chm.put("test","test");
		  if (count % 1000000 == 0) {
		    Date endDate = new Date();
		    System.out.println("Put : " + (endDate.getTime() - startDate.getTime()));
		   startDate = endDate;
		   }
		 }
		
	}
}
