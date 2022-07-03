package core.test;

class Parent {
	static {
		System.out.println("Static Parent");
	}

	Parent() {
		System.out.println("Parent Constructor");
	}
}

class Child extends Parent {
	static {
		System.out.println("Static Child");
	}

	Child() {
		System.out.println("Child Constructor");
	}

	public static void main(String[] args) {
		Parent p;
	}
}