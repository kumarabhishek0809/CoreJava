package core.functional.interfaces;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {



    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {4,5,6};
        Object[] array = Stream.of(arr1, arr2).flatMap(ints -> Arrays.stream(ints)).toArray();

        System.out.println(array);

        String str = "HelloWorld";
        str.codePoints().forEach(System.out::println);

        str.codePoints().mapToObj( c -> (char) c).distinct().forEach(System.out::print);

        Map<Character, Long> characterLongMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c.charValue(), Collectors.counting()));
        System.out.println(characterLongMap);

        long count = str.chars().filter(e -> e == 'l' || e == 'L').count();
        System.out.println(count);


    }
}
