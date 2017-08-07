package core.inheritence;

abstract class TestAbstraction extends Base { // #1
	public static void main(String[] args) {
		Base obj = new Base();
		obj.print(); // #2
	}
}