package core.java8.features.stream;

import java.util.List;
import java.util.Optional;

public class ReduceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> listElements = List.of(50, 60, 10, 20, 30, 40);
		Integer reduceSum = listElements.stream().reduce(0, (a, b) -> a + b);
		System.out.println(reduceSum);
		Optional<Integer> reduceSum2 = listElements.stream().reduce(Integer::sum);
		System.out.println(reduceSum2);

	}

}
