package core.marker;

import core.inheritence.Base;

public class ClonableTest  {

	public static void main(String[] args) {
		Base base = new Child();
		// No Visiblity base.clone();
		
		Base base1 = new Base();
		// No visiblity base1.clone();
		
		Child child = new Child();
		child.clone();
	}
}



class Child extends Base   {
	@Override
	protected Object clone(){
		System.out.println("Called From Child");
		return new Object();
	}
	
}
