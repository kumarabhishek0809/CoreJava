package core.java11;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateNotTest {
    public static void main(String[] args) {
        Stream<String> kumar = Stream.of("Kumar", "Neeraj", "Raju");

        System.out.println(kumar.filter(str()));
        System.out.println(kumar.filter(str().negate()));
        System.out.println(kumar.filter(Predicate.not(str())));
    }

    public static Predicate str(){
        Predicate<String> str = str1 -> str1.startsWith("R");
        return str;
    }
}


