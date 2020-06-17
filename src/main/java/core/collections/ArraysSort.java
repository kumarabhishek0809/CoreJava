package core.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysSort {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(Thread.currentThread().getName());
        Arrays.sort(list.toArray(),(o1, o2) -> {
            System.out.println(Thread.currentThread().getName());
            return o1.hashCode() > o2.hashCode() ? 1 : 0;
        });
    }
}
