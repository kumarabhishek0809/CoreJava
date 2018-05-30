package core.collections.concurrent.queue;

import core.domain.Person;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class PriorityProducer implements Runnable {
    private BlockingQueue<Person> blockingQueue;

    public PriorityProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(new Person("a", 38));
            blockingQueue.put(new Person("d", 41));
            blockingQueue.put(new Person("e", 42));
            blockingQueue.put(new Person("b", 39));
            blockingQueue.put(new Person("c", 40));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PriorityConsumer implements Runnable {
    private BlockingQueue<Person> blockingQueue;

    public PriorityConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (!blockingQueue.isEmpty()) {
                Person person = blockingQueue.take();
                System.out.println(person);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityBlockingQueue<Person> priorityBlockingQueue = new PriorityBlockingQueue<>();
        new Thread(new PriorityProducer(priorityBlockingQueue)).start();
        new Thread(new PriorityConsumer(priorityBlockingQueue)).start();
    }
}
