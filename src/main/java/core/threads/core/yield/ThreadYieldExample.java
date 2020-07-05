package core.threads.core.yield;

public class ThreadYieldExample implements Runnable {

	@Override
	public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
					System.out.println("i =  " + i + " " + Thread.currentThread().getName());
					if(i==5)
					{
						System.out.println("Yielding " + Thread.currentThread().getName());
						Thread.yield();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		

	}

	public static void main(String[] args) throws InterruptedException {

		ThreadYieldExample threadJoinExample = new ThreadYieldExample();
		Thread t = new Thread(threadJoinExample);
		Thread t1 = new Thread(threadJoinExample);
		Thread t2 = new Thread(threadJoinExample);

		t.start();
		t1.start();
		t2.start();

	}
}
