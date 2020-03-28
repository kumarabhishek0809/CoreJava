package core.threads.diningphilosopher;

import java.util.Random;

public class Philosper implements Runnable {
    private int id;
    private ChopStick leftChopStick;
    private ChopStick rightChopStick;
    private Random random;
    private int eatingCounter;
    private volatile boolean isFull = false;

    public Philosper(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
    }


    public void think() throws InterruptedException {
        System.out.println("Philosper" + this + " Thinking");
        Thread.sleep(1000);
    }

    public void eatting() throws InterruptedException {
        System.out.println("Philosper" + this + " eatting");
        eatingCounter++;
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (!isFull) {
                think();
                if (leftChopStick.pickUpChopStick(this, State.LEFT)) {
                    if (rightChopStick.pickUpChopStick(this, State.RIGHT)) {
                        eatting();
                        rightChopStick.putDownChopStick(this, State.RIGHT);
                    }
                    leftChopStick.putDownChopStick(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getEatingCounter() {
        return eatingCounter;
    }

    @Override
    public String toString() {
        return "Philosper{" +
                "id=" + id +
                ", leftChopStick=" + leftChopStick +
                ", rightChopStick=" + rightChopStick +
                ", random=" + random +
                ", eatingCounter=" + eatingCounter +
                ", isFull=" + isFull +
                '}';
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getId() {
        return id;
    }
}
