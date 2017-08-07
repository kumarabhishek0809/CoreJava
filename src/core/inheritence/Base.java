package core.inheritence;

import java.sql.SQLException;

public class Base  implements Cloneable {
	@Override
	protected Object clone(){
		System.out.println("Called From Base");
		return new Object();
	}
	
	public void myMethod() throws SQLException {

	}
	
	public void print() {
		System.out.println("Base:print");
	}
}
