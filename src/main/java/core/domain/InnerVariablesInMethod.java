package core.domain;

public class InnerVariablesInMethod {

	public static void main(String[] args) {
		InnerVariablesInMethod innerVariablesInMethod = new InnerVariablesInMethod();
		innerVariablesInMethod.innerMethod(10, new Person(10,"Kumar"));

	}

	
	private void innerMethod(final int age,Person person){
		//Cant Change compilation Error age = 25;
		person = new Person(11,"Can Change NP");
		
	}
}
