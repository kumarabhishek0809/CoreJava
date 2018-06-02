package core.threads.sequential;

import java.util.Random;
import java.util.stream.IntStream;

public class SequentialSum {
    public static void main(String[] args) {
        int sum = 0;
        int[] ints = IntStream.generate(() -> new Random().nextInt(100)).limit(50).toArray();
        for(int i = 0; i< ints.length;i++){
            System.out.print(ints[i]+",");
            sum +=ints[i];
        }
        System.out.println();
        System.out.println("Total Sum "+sum);

    }
}
