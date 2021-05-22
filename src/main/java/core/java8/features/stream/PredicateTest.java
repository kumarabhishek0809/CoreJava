package core.java8.features.stream;

import java.util.function.Predicate;

public class PredicateTest implements Predicate<Integer> {

	public static void main(String[] args) {
		PredicateTest predicateTest = new PredicateTest();
		System.out.println(predicateTest.test(4));
		System.out.println(predicateTest.test(7));

		Predicate<String> strPrdeicateLambd = (str) -> str.length() > 7 ? true : false;
		System.out.println(strPrdeicateLambd.test("KUmar"));
		System.out.println(strPrdeicateLambd.test("ABhishek"));
	}

	@Override
	public boolean test(Integer t) {

		return t % 2 == 0 ? true : false;
	}
}
