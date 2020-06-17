package core.java8.features.stream;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        Stream<String> silence = Stream.empty();
        Stream<String> echos = Stream.generate(() -> "Echo");
        Stream<Double> generate = Stream.generate(Math::random);
        Stream<BigDecimal> iterate = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE));
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        Set<String> result1 = echos.collect(HashSet::new, HashSet::add, HashSet::addAll);
        List<String> result2 = echos.collect(Collectors.toList());
        Set<String> result3 = echos.collect(Collectors.toSet());
    }
}
