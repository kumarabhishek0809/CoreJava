package core.threads;

import java.util.ArrayList;
import java.util.List;

class Processor {
    private static final int LIMIT = 3;
    private static final int BOTTOM = 0;
    private final Object lock = new Object();
    private List<Integer> storage = new ArrayList<>();
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (storage.size() == LIMIT) {
                    System.out.println("Storage is full");
                    lock.wait();
                } else {
                    storage.add(value++);
                    System.out.println("Adding "+value);
                    lock.notify();
                }
            }
        }
    }

        public void consume () throws InterruptedException {
            synchronized (lock) {
                while (true) {
                    if (storage != null && storage.size() == BOTTOM) {
                        System.out.println("Waiting");
                        lock.wait();
                    } else if (storage != null) {
                        System.out.println("Removing Item " + storage.remove(--value));
                        lock.notify();
                    }
                    Thread.sleep(1000);
                }
            }
        }
    }

    public class ProducerConsumer {

        public static void main(String[] args) {
            Processor processor = new Processor();
            Thread t1 = new Thread(() -> {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            t2.start();


            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
