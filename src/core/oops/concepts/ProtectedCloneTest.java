package core.oops.concepts;

import core.inheritence.Base;
import core.oops.concepts.marker.ClonableTest;

public class ProtectedCloneTest {
	
	public static void main(String[] args) {
		ClonableTest clonableTest = new ClonableTest();
		clonableTest.main(null);
		
		Base base = new Base();
		//base.clone();
	}


}
