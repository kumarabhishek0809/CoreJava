package core.java8.features.stream;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class GroupByAndPartition {
    public static void main(String[] args) {
        Supplier<Stream<Locale>> localeSupplier = () -> Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = localeSupplier.get().collect( groupingBy(Locale::getCountry));
        Map<Boolean, List<Locale>> englishCountries = localeSupplier.get().collect(Collectors.partitioningBy(locale -> locale.getLanguage().equals("en")));
        List<Locale> englishContriesList = englishCountries.get(true);
        englishContriesList.stream().forEach(System.out::println);
        localeSupplier.get().collect(groupingBy(Locale::getCountry,counting()));
    }
}
