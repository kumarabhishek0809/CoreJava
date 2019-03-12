package core.threads.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCompletionServiceTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(100,200,300,400,500,600,700);
		
		Executor executor= Executors.newFixedThreadPool(10);
		CompletionService<ViolationDetails> completionService = new ExecutorCompletionService<ViolationDetails>(executor);
		for(Integer estCode : list){
			completionService.submit(new ViolationWorker(new ViolationDetails(estCode)));
		}
		
		
		
		for(int i=0;i<list.size();i++){
			ViolationDetails violationDetails;
			try {
				violationDetails = completionService.take().get();
				System.out.println(" -> "+violationDetails.getTransactionID() + "    " + violationDetails.getViolation());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		((ExecutorService) executor).shutdownNow();
	}
}


class ViolationWorker implements Callable<ViolationDetails>{
	
	private ViolationDetails violationDetails;
	
	public ViolationWorker(ViolationDetails violationDetails){
		this.violationDetails = violationDetails;
	}
	
	@Override
	public ViolationDetails call() throws Exception {
		Thread.sleep(10001);
		violationDetails.setViolation(System.currentTimeMillis());
		System.out.println(violationDetails.getTransactionID() + "    " + violationDetails.getViolation());
		return violationDetails;
	}
	 
 }

class ViolationDetails {
	private long transactionID;
	private long violation;

	
	public ViolationDetails(long transactionID){
		this.transactionID = transactionID;
	}
	
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public long getViolation() {
		return violation;
	}
	public void setViolation(long violation) {
		this.violation = violation;
	}
	
}