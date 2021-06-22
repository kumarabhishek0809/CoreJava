package core.java8.features.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import core.domain.Customer;

public class MapFlatMapTest {
	public static void main(String[] args) {
		List<Customer> customers = Customer.getAll();
		Map<Integer,Integer>  a = new HashMap();
		// data transformation using map
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(emails);
		a.putIfAbsent(1, 2);
		List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());

		System.out.println(phones);
	}
}
