package core.threads.library.management;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private int id;
    private Lock lock = new ReentrantLock();

    public Book(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void read(Student student) throws InterruptedException {
        lock.tryLock(1,TimeUnit.MINUTES);
        System.out.println("Student "+student+" Started reading Book "+this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("Student "+student+" finished reading Book "+this);
    }
}
