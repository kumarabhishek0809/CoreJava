package core.test;

public class FindLargestSmallestNumber {

	public static void main(String[] args) {
		int numbers[] = new int[] { 37, 47, 57, 58, 31, 67, 98, 43, 22 };
		int smallest = numbers[0];
		int largest = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > largest)
				largest = numbers[i];
			else if (numbers[i] < smallest)
				smallest = numbers[i];
		}
		System.out.println(largest);
		System.out.println(smallest);
	}

}
