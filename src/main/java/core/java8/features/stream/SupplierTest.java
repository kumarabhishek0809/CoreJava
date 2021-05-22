package core.java8.features.stream;

import java.util.function.Supplier;

public class SupplierTest implements Supplier<String> {

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "MY Supplier Test";
	}

	public static void main(String[] args) {
		SupplierTest supplierTest = new SupplierTest();
		System.out.println(supplierTest.get());

		Supplier<String> supplierLambda = () -> "Supplier Lambda";

		System.out.println(supplierLambda.get());
	}

}
