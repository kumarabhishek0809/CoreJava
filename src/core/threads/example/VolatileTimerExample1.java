package core.threads.example;

public class VolatileTimerExample1 {
	private int a = 0;
	private int b = 0;

	private static long lastA;
	private static long lastB;

	public static void main(String[] args) throws InterruptedException {
		final VolatileTimerExample1 instance = new VolatileTimerExample1();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lastA = System.nanoTime();
				while (true) {
					instance.a++;
					if (instance.a % 100_000_000 == 0) {
						System.out.println("A: " + (System.nanoTime() - lastA) / 1000000 + "ms");
						instance.a = 0;
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lastB = System.nanoTime();
				while (true) {
					instance.b++;
					if (instance.b % 100_000_000 == 0) {
						System.out.println("B: " + (System.nanoTime() - lastB) / 1000000 + "ms");
						instance.b = 0;
					}
				}
			}
		}).start();

	}
}
