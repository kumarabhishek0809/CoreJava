package core.collections.concurrent;

import java.util.concurrent.Exchanger;

class ExchangerWorkerOne implements Runnable {
    private Exchanger<String> exchanger;
    private String address = "A";
    private int counter = 0;

    public ExchangerWorkerOne(Exchanger<String> StringExchanger) {
        this.exchanger = StringExchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter++;
            try {
                System.out.println("Value of String ExchangerWorkerOne :::"+exchanger.exchange(address+counter));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExchangerWorkerTwo implements Runnable {
    Exchanger<String> exchanger;
    String address = "B";

    public ExchangerWorkerTwo(Exchanger<String> StringExchanger) {
        this.exchanger = StringExchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Value of String ExchangerWorkerTwo :::"+ exchanger.exchange(address));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> StringExchanger = new Exchanger<>();
        new Thread(new ExchangerWorkerOne(StringExchanger)).start();
        new Thread(new ExchangerWorkerTwo(StringExchanger)).start();
    }
}
