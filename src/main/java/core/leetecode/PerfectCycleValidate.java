package core.leetecode;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.Map.entry;

/*
 * 
 * ```
 	The perfect cycle has two conditions needed to arise in a list, and they are as follows:
		Condition
		All elements of the list must be visited.
		The last element to be visited takes you back to position zero.
 		Note: Each value points to the next index to visit in the list.

 		e.g., a = [3,0,1,2] is a perfect cycle => a[0] = 3, a[3] = 2, a[2] = 1, a[1] = 0, a[0] = 3
		This is a perfect cycle since we visited all elements, and the last element took us back to the beginning of the list. 

 
		Junit
		input: 
		
		{
		
		"list1":[1, 2, 3],
		
		"list2":[0, 2 , 5],
		
		"list3":[3,0,1,2],
		
		....
		
		"listn" : [],
		
		}

		output: 
		
		{
		
		"list1": False,
		
		"list2": False
		
		"list3": True,
		
		....,
		
		"listn": True
		
		}
 */

public class PerfectCycleValidate {

	// arr[] is array of n elements visited[] is boolean array of size n
	static boolean validatePerfectCycle(int[] arr, int arrayLength) {

		// Initially no element is placed at any position
		int[] visited = new int[arrayLength];

		// Traverse each element of array to confirm all are visisted.
		for (int i = 0; i < arrayLength; i++) {
			// Element must be smaller than n, Checking cycle
			if (arr[i] < arrayLength) {
				// Place "arr[i]" at position "i" or at position n-arr[i]-1
				if (visited[arr[i]] == 0)
					visited[arr[i]] = 1;
				else
					visited[arrayLength - arr[i] - 1] = 1;
			} else {
				return false; // as this is not perfect array and supposted to go the new location.
			}
		}

		// This is a perfect cycle since we visited all elements.
		for (int i = 0; i < arrayLength; i++) {
			if (visited[i] == 0)
				return false;
		}

		int itr = 0;
		int currentValue = 0;
		// The last element took us back to the beginning of the list
		while (itr < arrayLength) {
			if (itr == 0) {
				currentValue = arr[itr];
			} else {
				currentValue = arr[currentValue];
			}
			if (itr == arrayLength - 1) {
				if (arr[0] != arr[currentValue]) {
					return false;
				}
			}
			itr++;
		}
		return true;

	}

	public static void main(String[] args) {
		Map<String, int[]> mapOfArray = Map.ofEntries(//
				entry("test1", new int[] { 2, 1, 5, 2, 1, 5 }), //
				entry("test2", new int[] { 3, 0, 1, 2 }), //
				entry("test3", new int[] { 1, 2, 3 }), //
				entry("test4", new int[] { 0, 2, 5 })); //

		Set<Entry<String, int[]>> entrySet = mapOfArray.entrySet();
		for (Entry<String, int[]> a : entrySet) {
			if (validatePerfectCycle(a.getValue(), a.getValue().length)) {
				System.out.println(a.getKey() + "  "+ a.getValue().toString() +" " + "Yes Perfect Cycle");
			} else {
				System.out.println(a.getKey() + "  "+ a.getValue().toString() +" "  + "Not a Perfect Cycle");
			}
		}
	}

}
