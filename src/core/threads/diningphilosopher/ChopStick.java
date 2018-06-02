package core.threads.diningphilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    private int id;
    private Lock lock = new ReentrantLock();

    public ChopStick(int id) {
        this.id = id;
    }


    public boolean pickUpChopStick(Philosper philosper, State state) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println("Philosper " + philosper + "Picked Stick " + state + " chopstick" + this);
            return true;
        }
        return false;
    }

    public void putDownChopStick(Philosper philosper, State state) throws InterruptedException {
        lock.unlock();
        System.out.println("Philosper " + philosper + "put down " + state + " chopstick" + this);
    }

    @Override
    public String toString() {
        return "ChopStick{" +
                "id=" + id +
                '}';
    }

}
