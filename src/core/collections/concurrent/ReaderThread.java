package core.collections.concurrent;

import java.util.Date;
import java.util.Map;

public class ReaderThread implements Runnable{
	private Map<String, String> chm;
	public ReaderThread(Map<String, String> concurrentHashMap){
		this.chm = concurrentHashMap;
	}
	
	@Override
	public void run() {
		int count = 0;
		Date startDate = new Date();
		while (true) {
		++count;
		 chm.get("test");
		  if (count % 1000000 == 0) {
		    Date endDate = new Date();
		    System.out.print("Get : " + (endDate.getTime() - startDate.getTime()));
		   startDate = endDate;
		   }
		 }
		
	}
}
