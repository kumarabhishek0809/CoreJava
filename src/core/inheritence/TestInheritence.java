package core.inheritence;

public class TestInheritence {
	public void print(Integer i) {
		System.out.println("Integer");
	}

	public void print(int i) {
		System.out.println("int");
	}

	public void print(long i) {
		System.out.println("long");
	}

	public static void main(String args[]) {
		TestInheritence test = new TestInheritence();
		test.print(10);
	}

//	@Override
//	public Class<?> getClass() {
//
//	}
}

interface Rectangle {
}

interface ColoredRectangle extends Rectangle {
}

interface RoundedRectangle extends Rectangle {
}

class ColoredRoundedRectangle implements ColoredRectangle, RoundedRectangle {
}