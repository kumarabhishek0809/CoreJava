package core.java8.features.stream;

import java.util.List;
import java.util.stream.Collectors;

import core.domain.Customer;

public class MapFlatMapTest {
	public static void main(String[] args) {
		List<Customer> customers = Customer.getAll();

		// data transformation using map
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(emails);

		List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());

		System.out.println(phones);
	}
}
