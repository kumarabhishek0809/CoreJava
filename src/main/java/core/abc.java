package core;

public class abc {

	static int a = 3;
	static int b;

	static void method(int x) {
		System.out.println("X = " + x);
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

	static {
		System.out.println("a = " + a);
		b=a*4;

	}

	public static void main(String[] args) {
		method(55);
	}

}
