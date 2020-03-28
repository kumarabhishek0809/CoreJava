package core.oops.concepts;

public class InheritenceTest {
	private interface Add {
		int calculate(int a, int b);

		default int calculateImpl(int a, int b) {
			return a + b;
		}
		
		int variable = 5;
	}

	private interface Subtract {
		int calculate(int a, int b);

		default int calculateImpl(int a, int b) {
			return a - b;
		}
		
		int variable = 6;
	}

	private class Calculator implements Add, Subtract {
		
		private int variable = 7; 
		
		public int calculate(int a, int b) {
			return a + b;
			// return a - b;
		}

		@Override
		public int calculateImpl(int a, int b) {
			// TODO Auto-generated method stub
			return Add.super.calculateImpl(a, b);
		}
	
	}
	
	public static void main(String[] args) {
		Add add = new InheritenceTest().new Calculator();
		System.out.println(add.variable);
		Subtract substract = new InheritenceTest().new Calculator();
		System.out.println(substract.variable);
		Calculator calculator = new InheritenceTest().new Calculator();
		System.out.println(calculator.variable);
		
	}

}
