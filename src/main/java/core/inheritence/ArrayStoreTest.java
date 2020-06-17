package core.inheritence;

class DeriOne extends Base {
}

class DeriTwo extends Base {
}

class ArrayStoreTest {
	public static void main(String[] args) {
		Base[] baseArr = new DeriOne[3]; //BASE type will work
		baseArr[0] = new DeriOne();
		baseArr[2] = new DeriTwo();
		System.out.println(baseArr.length);
	}
}


