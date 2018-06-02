package core.threads.core;

public class EvenOdd {

    private int x = 0;

    public static void main(String[] args) {

        final EvenOdd evenOdd = new EvenOdd();

        Thread t = new Thread(() -> {

            while (true) {
                try {
                    evenOdd.printEven();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }, "Even");

        t.start();

        Thread t1 = new Thread(() -> {

            while (true) {
                try {
                    evenOdd.printOdd();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }, "Odd");

        t1.start();

    }

    private synchronized void printEven() throws InterruptedException {

        if (x % 2 == 0) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " " + x);

            wait();

        }
        ++x;
        notify();
    }

    private synchronized void printOdd() throws InterruptedException {

        if (!(x % 2 == 0)) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " " + x);

            wait();

        }
        ++x;
        notify();

    }

}
