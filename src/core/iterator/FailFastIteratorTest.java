package core.iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastIteratorTest {

	public static void main(String[] args) {
		List<String> myFailList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) { // if No of Elements are 2 It will work
			myFailList.add("" + i);
		}

		// Fail Fast Operation
		try {
			for (String failSTring : myFailList) {
				myFailList.remove(failSTring);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("ConcurrentModificationException");

		}
		
		 myFailList = new CopyOnWriteArrayList<String>();
			for (int i = 0; i < 10; i++) { // if No of Elements are 2 It will work
				myFailList.add("" + i);
			}
			for (String failSTring : myFailList) {
				System.out.println("Inside Copy On Write ArrayList");
				myFailList.remove(failSTring);
			}
	}
}
