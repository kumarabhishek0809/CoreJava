package core.test;

public class Test {

	public static void main(String[] args) {
		int x = 1;
		while (checkAndIcrement(x)) {
			System.out.println(x);
		}
	}

	private static boolean checkAndIcrement(int x) {
		if (x < 5) {
			x++;
			return true;
		} else {
			return false;
		}
	}

}
