package core.functional.interfaces;

import core.domain.Product;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorFunctional {

    public static void main(String[] args) {
        List<String> productNameList = Product.getProducts().stream().map(Product::getName).collect(Collectors.toList());
        productNameList.stream().forEach(p -> System.out.print("\t"+p));

        String stringName = Product.getProducts().stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(stringName);
    }
}
