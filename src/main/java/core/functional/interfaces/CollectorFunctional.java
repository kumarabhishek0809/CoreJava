package core.functional.interfaces;

import core.domain.Employee;
import core.domain.Product;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorFunctional {

    public static void main(String[] args) {
        List<String> productNameList = Product.getProducts().stream().map(Product::getName).collect(Collectors.toList());
        productNameList.stream().forEach(p -> System.out.print("\t"+p));
        System.out.println();

        String stringName = Product.getProducts().stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(stringName);
        Double collect = Product.getProducts().stream().collect(Collectors.averagingInt(Product::getId));
        System.out.println(collect);

        IntSummaryStatistics summaryStatistics = Product.getProducts().stream().collect(Collectors.summarizingInt(Product::getId));
        System.out.println(summaryStatistics);


        Map<String, Employee> employeesDepartment = Employee.getEmployees().stream().collect(Collectors.groupingBy(e -> e.getDepartment(), //
                Collectors.collectingAndThen(Collectors.maxBy((o1, o2) -> o1.getSalary() - o2.getSalary()), Optional::get)
        ));


        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                Product.getProducts().stream().collect(toLinkedList);

        System.out.println(employeesDepartment);


    }
}
