package core.collections.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = duration;
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return duration < ((DelayedWorker) o).getDuration() ? -1 : 1;
    }

    @Override
    public String toString() {
        return "DelayedWorker{" +
                "duration=" + duration +
                ", message='" + message + '\'' +
                '}';
    }
}

public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedWorker> delayedWorkers = new DelayQueue<>();
        delayedWorkers.add(new DelayedWorker(4000,"THIS IS FIRST"));
        delayedWorkers.add(new DelayedWorker(2000,"THIS IS Second"));
        delayedWorkers.add(new DelayedWorker(3000,"THIS IS Third"));
        while(!delayedWorkers.isEmpty()){
            System.out.println(delayedWorkers.take());
        }
    }
}
