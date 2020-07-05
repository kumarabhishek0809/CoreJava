package core.threads.core.yield;

public class YieldTest extends Thread{
    @Override
    public void run(){
        System.out.println("Start");
        Thread.yield();
        System.out.println("End");
    }

    public static void main(String[] args) {
        (new YieldTest()).start();
    }
}
