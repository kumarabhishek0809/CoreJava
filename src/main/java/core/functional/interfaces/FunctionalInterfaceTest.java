package core.functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {

        Consumer<String> tConsumer = (t) -> {
            System.out.println("Print T from -->" + t);
        };

        Consumer<String> tSecondConsumer = (t) -> {
            System.out.println("Print T from Second -->" + t);
        };

        List<String> strings = Arrays.asList("Kumar", "Abhishek", "Printint");
       // tConsumer.accept("Lambda");
        //tConsumer.andThen(tSecondConsumer);

        Predicate<String> predicate1 =  str -> str.startsWith("A");
        Predicate<String> predicate2 =  str -> str.length() < 5;

        strings.stream().filter(predicate1.and(predicate2));
        strings.forEach(tConsumer.andThen(tSecondConsumer));
    }


}

 class PredicateA implements Predicate<String> {

     @Override
     public boolean test(String s) {
         return false;
     }
 }

class PredicateB implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return false;
    }
}