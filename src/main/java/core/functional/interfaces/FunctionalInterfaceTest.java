package core.functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
        strings.forEach(tConsumer.andThen(tSecondConsumer));
    }
}