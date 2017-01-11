package core.threads.example;

public class VolatileEvenOddProblem {

	static volatile int counter = 1;
	final static int limit = 100;
	volatile static boolean flag;

	public static void main(String[] args) throws InterruptedException {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (flag) {
					if (counter % 2 == 0) {
						System.out.println("Even :::" + counter);
						counter++;
						flag = false;
					}
				}
			}

		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!flag) {
					if (counter % 2 != 0) {
						System.out.println("Odd :::" + counter);
						counter++;
						flag = true;
					}
				}
			}

		}).start();

	}
}