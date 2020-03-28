//thread starvation

package core.threads.core;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter {

	public static void main(String[] args) {
		for (int i = 0; i <10; i++) {
			new Thread(new WorkerCounter()).start();
		}
	}

}

class WorkerCounter implements Runnable {

	static private AtomicInteger counter = new AtomicInteger(0);
	static Set<Integer> counterSet = new HashSet<Integer>();

	@Override
	public void run() {
		while (counter.get() < 1000) {
			//synchronized(WorkerCounter.class){
				counter.incrementAndGet();
			//}
			if (!counterSet.add(counter.get())) {
				System.out.println(
						Thread.currentThread().getName() + "   Duplicate Value :::: " + counter.get());
			}
			System.out.println(
					Thread.currentThread().getName() + "   Value :::: " + counter.get());
		}
	}

}