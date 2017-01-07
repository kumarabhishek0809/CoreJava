package core.inheritence;

import java.sql.SQLException;

public class InheritenceExceptionTest {

	public static void main(String[] args) {
		Base base = new Base();
		base.clone(); // Can call as protected
	}
}

class Child extends Base {

	//Cannot Widen Exception public void myMethod() throws Exception {}
	
	@Override //Only new Runtime can be added.
	public void myMethod() throws SQLException , ArithmeticException {}
	
	//@Override
	//No New checked not allowed
	//It will blow up backward compatiblity.
	//public void myMethod() throws SQLException , IOException {}
}