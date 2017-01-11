package core.threads.example;


import java.util.ArrayList;
import java.util.List;

public class VolatileNotWorkingTest {

	public static void main(String[] args)  {
		List<Worker> threads = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			System.out.println(i%2 == 0);
			Worker t = new Worker(i,i%2 == 0 ? true : false);
			t.start();
			threads.add(t);
		}
		Worker killWorker = new Worker(100,false);
		System.out.println("----------------------VolatileTest -------------------");
	}
}

class Worker extends Thread {

	private Integer count = null;
	private volatile boolean keepRunning = true;

	public Worker(Integer count,boolean keepRunning) {
		this.count = count;
		this.keepRunning = keepRunning;
	}

	public void run() {
		int counterRun =0;
		while (keepRunning) {
			if (count != null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(++counterRun +" : Called by thread ::: " + count + " keepRunning :::"+keepRunning);
			}
		}

		System.out.println("Thread terminated.");
	}
}