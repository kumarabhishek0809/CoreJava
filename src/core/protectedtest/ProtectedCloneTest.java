package core.protectedtest;

import core.inheritence.Base;
import core.marker.ClonableTest;

public class ProtectedCloneTest {
	
	public static void main(String[] args) {
		ClonableTest clonableTest = new ClonableTest();
		clonableTest.main(null);
		
		Base base = new Base();
		// Cannot Call from here base.clone();
	}


}
