package core.threads;
public class ThreadJoinExample implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" Increment "+i);
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadJoinExample threadJoinExample = new ThreadJoinExample();
		Thread t1 = new Thread(threadJoinExample);
		Thread t2 = new Thread(threadJoinExample);
		Thread t3 = new Thread(threadJoinExample);
		Thread t4 = new Thread(threadJoinExample);
		
		t1.start();
		t1.join();
		System.out.println("Now start Thread 2");
		t2.start();
		t2.join();
		System.out.println("Now start Thread 3");
		t3.start();
		t3.join();
		System.out.println("Now start Thread 4");
		t4.start();
		t4.join();
	}
}
