package core.functional.interfaces;

import core.domain.Employee;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamListEmployees {

    private long   counter;

    private void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        Stream<Employee> es = Employee.getEmployees().stream();
        Stream<List<Employee>> employeesStream = Stream.of(Employee.getEmployees());
        Map<String, Long> collect = es.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Kumar its coming as count :: "+collect);

        Map<String, List<Employee>> employees = employeesStream.findFirst().get().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
        employees.keySet().stream().forEach( e -> System.out.println(" printing list for "+ e +" __ " + employees.get(e)));

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        System.out.println(streamGenerated);

        Stream<Integer> streamIterator = Stream.iterate(40, n -> n + 2).limit(20);
        streamIterator.forEach( aInteger -> System.out.println(aInteger));

        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1);

        onceModifiedStream.forEach(a -> System.out.println(a));
    }

    List<String> list = Arrays.asList("abc1", "abc2", "abc3");

    Stream<String> stream = list.stream().filter(element -> {
        wasCalled();
        return element.contains("2");
    });


}
