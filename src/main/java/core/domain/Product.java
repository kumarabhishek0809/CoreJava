package core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Product {
	private int id;
	private String name;

	public static List<Product> getProducts() {
		return Arrays.asList(new Product(23, "potatoes"),
				new Product(14, "orange"), new Product(13, "lemon"),
				new Product(23, "bread"), new Product(13, "sugar"));

	}


}
