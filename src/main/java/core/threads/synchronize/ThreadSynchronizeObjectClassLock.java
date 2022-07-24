package core.threads.synchronize;

public class ThreadSynchronizeObjectClassLock {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread t1 = new Thread(new ClassObjectLockWorker());
			t1.setName("t" + i);
			t1.start();
		}
	}
}

class ClassObjectLockWorker implements Runnable {
	public void run() {
		lockObject();
		lockStatic();
	}

	public void lockObject() {

		synchronized (this) {
			System.out.println("Line no 34 " + Thread.currentThread().getName());
			try {
				if ("t3".equalsIgnoreCase(Thread.currentThread().getName())) {
					Thread.sleep(10000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Object " + Thread.currentThread().getName() + " end");
		}
	}

	public static void lockStatic() {
		synchronized (ClassObjectLockWorker.class) {
			try {
				if ("t2".equalsIgnoreCase(Thread.currentThread().getName())) {
					Thread.sleep(10000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" Line no 55 " + Thread.currentThread().getName());
			System.out.println("Exit Static " + Thread.currentThread().getName() + " end");
		}
	}
}
