package core.java8.features.stream;

import java.util.Comparator;
import java.util.List;

public class SteamSortingTest {

	public static void main(String[] args) {
		List<Integer> listElements = List.of(41,50, 60, 10, 20, 30, 40);
		// XCollections.sort(listElements);
		listElements.stream().sorted().forEach(a -> System.out.println(a));
		listElements.stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.println(a));
		System.out.println( listElements.parallelStream().filter(a -> a > 39).findAny());
		System.out.println(listElements.parallelStream().filter(a -> a > 39).findFirst());

	}

}
