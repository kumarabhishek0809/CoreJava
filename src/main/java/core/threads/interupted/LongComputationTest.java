package core.threads.interupted;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LongComputationTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("10000000")));
        thread.start();
        thread.interrupt();

    }

    public static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }


        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                System.out.println("Cycles "+ i);
                System.out.println("Thread.currentThread().isInterrupted() :::"+ Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is prematurely interupted");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
