package core.inheritence;

public class InheritenceImpl implements IInheritance {
	public static void main(String[] args) {
		System.out.println("Starts");
		InheritenceImpl.myStaticMethod();
		IInheritance.myStaticMethod();
		myStaticMethod();
		
		new InheritenceImpl().myStaticMethod();
	}

	static void myStaticMethod() {
		System.out.println("InheritenceImpl Class");
	}
}
