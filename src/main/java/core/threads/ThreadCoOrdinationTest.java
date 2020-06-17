package core.threads;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadCoOrdinationTest {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0l, 3435l, 35435l, 2324l, 4656l, 23l, 5556l);
        List<FactorialThread> factorialThreads = new ArrayList<>();

        for (Long inputNumber : inputNumbers) {
            FactorialThread factorialThread = new FactorialThread(inputNumber);
            factorialThreads.add(factorialThread);
        }

        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.start();
        }

        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = factorialThreads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + factorialThread.getInputNumber() + " is  " + factorialThread.getResult());
            } else {
                System.out.println("Calculation is still in progress for " + factorialThread.getInputNumber());
            }

        }
    }

    public static class FactorialThread extends Thread {


        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean finished = false;


        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.finished = true;
        }

        private BigInteger factorial(long inputNumber) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = inputNumber; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return finished;
        }

        public BigInteger getResult() {
            return result;
        }

        public long getInputNumber() {
            return inputNumber;
        }
    }
}
