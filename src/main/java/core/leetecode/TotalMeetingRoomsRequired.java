package core.leetecode;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TotalMeetingRoomsRequired {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] req = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int ret = meetingRooms(req);
		System.out.print("[" + ret + "]");
	}

	public static int meetingRooms(int intervals[][]) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] interval : intervals) {
			if (pq.size() == 0) {
				pq.add(interval[1]);
			} else {
				if (pq.peek() > interval[0]) {
					pq.add(interval[1]);
				} else {
					pq.remove();
					pq.add(interval[1]);
				}
			}
		}

		return pq.size();

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