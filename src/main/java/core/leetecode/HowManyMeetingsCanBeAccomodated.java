package core.leetecode;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class HowManyMeetingsCanBeAccomodated {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * n = Integer.parseInt(br.readLine()); int[][] arr = new int[n][2];
		 * 
		 * for (int j = 0; j < n; j++) { String line = br.readLine(); arr[j][0] =
		 * Integer.parseInt(line.split(" ")[0]); arr[j][1] =
		 * Integer.parseInt(line.split(" ")[1]); }
		 */
		int[][] req = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] ret = meetingRooms(req);
		System.out.print("[");
		for (int i = 0; i < ret.length; i++) {
			System.out.print("[" + ret[i][0] + "," + ret[i][1] + "],");
		}
		System.out.print("]");
	}

	public static int[][] meetingRooms(int[][] arr) {
		int result[][];
		Pair[] pairs = new Pair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			pairs[i] = new Pair(arr[i][0], arr[i][1]);
		}

		Arrays.sort(pairs);

		Stack<Pair> stack = new Stack<>();

		for (int i = 0; i < pairs.length; i++) {
			if (i == 0) {
				stack.push(pairs[i]);
			} else {
				Pair top = stack.peek();
				if (pairs[i].start > top.end) {
					stack.push(pairs[i]);
				} else {
					top.end = Math.max(top.end, pairs[i].end);
				}
			}
		}

		Stack<Pair> reverseStack = new Stack<>();
		while (stack.size() > 0) {
			reverseStack.push(stack.pop());
		}

		result = new int[reverseStack.size()][2];
		int count = 0;
		while (reverseStack.size() > 0) {
			Pair p = reverseStack.pop();
			result[count][0] = p.start;
			result[count][1] = p.end;
			count++;
		}
		return result;

	}

	public static class Pair implements Comparable<Pair> {
		int start;
		int end;

		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Pair other) {
			if (this.start != other.start) {
				return this.start - other.start;
			} else {
				return this.end - other.end;
			}
		}
	}

}