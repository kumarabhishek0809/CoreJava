package core.collections;

import java.util.*;

public class BinarySearchTest {
    public static void main(String[] args) {
        binarySearchResult(List.of(1,2,3,5,4));
        //binarySearchResult(new LinkedList<>());


    }

    private static void binarySearchResult(List<Integer> ll) {
        System.out.println("================================");
        System.out.println(Collections.binarySearch(ll,1));
        System.out.println(Collections.binarySearch(ll,2));
        System.out.println(Collections.binarySearch(ll,3));
        System.out.println(Collections.binarySearch(ll,6));
        System.out.println(Collections.binarySearch(ll,4));
        System.out.println(Collections.binarySearch(ll,5));
    }
}
