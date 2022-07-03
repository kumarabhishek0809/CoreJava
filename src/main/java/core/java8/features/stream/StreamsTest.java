package core.java8.features.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
       /* Stream<String> silence = Stream.empty();
        Stream<String> echos = Stream.generate(() -> "Echo");
        Stream<Double> generate = Stream.generate(Math::random);
        Stream<BigDecimal> iterate = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE));
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        Set<String> result1 = echos.collect(HashSet::new, HashSet::add, HashSet::addAll);
        List<String> result2 = echos.collect(Collectors.toList());
        Set<String> result3 = echos.collect(Collectors.toSet());
*/


        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya",null,null);

        Map<String, Long> result =
                items.stream().filter(f -> f!=null).collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
    }
}
