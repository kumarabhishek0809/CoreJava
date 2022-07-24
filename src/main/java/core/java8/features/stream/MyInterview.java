package core.java8.features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyInterview {
	
	
	public static void main(String[] args) {
		Employee employee100 = new Employee(100, "100 high", "IT");
		Employee employee200 = new Employee(200, "2nd high", "HR");
		Employee employee300 = new Employee(300, "300 high", "IT");
		
		List<Employee> creditCards = Arrays.asList(employee100,employee200,employee300);
		
		List<Employee> sortedBySalary = creditCards.stream().sorted(Comparator.comparing(Employee::getSalary)//
				.reversed()) 
				.collect(Collectors.toList());
		//System.out.println(sortedBySalary);
		
		int n = 3;
		
		Employee sortedBySalary2 = creditCards.stream().sorted(Comparator.comparing(Employee::getSalary)) 
				.skip(n-1)
				.findFirst().orElse(employee300);
		
		System.out.println("Testing my 2nd hightest"+sortedBySalary2.getName());
				
		
		Map<String, Long> mapByDept = sortedBySalary.stream() //
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		System.out.println(mapByDept);
		
		Map<String, List<Employee>> mapByDept1 = sortedBySalary.stream() //
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
		System.out.println(mapByDept1);
		
		Thread thread = new Thread(() -> {
			System.out.println("Start");
		});
		
		thread.start();
		
		Iterator<Employee> iterator = creditCards.iterator();
		while(iterator.hasNext()) {
			//iterator.remove();
			
		}
		
		for(Employee e : creditCards) {
			//employees.remove(0);
			System.out.println(e);
		}
		
		CopyOnWriteArrayList<Employee> copyOnWriteArrayList = new CopyOnWriteArrayList<>(creditCards);
		for(Employee e : copyOnWriteArrayList) {
			copyOnWriteArrayList.remove(0);
			System.out.println(e);
		}
		
		CustomerIdentificaiton cif1 = new CustomerIdentificaiton("INTERVIEW",creditCards);
		CustomerIdentificaiton cif2 = new CustomerIdentificaiton("INTERVIEWER",creditCards);
		
		List<CustomerIdentificaiton> customers = Arrays.asList(cif1,cif2);
		
		Function<? super CustomerIdentificaiton, ? extends Stream<? extends Employee>> mapper = d -> d.getEmps().stream();
		
		Stream<Employee> streamOfemployees = customers.stream().flatMap(mapper);
		
		List<Employee> listOfemployees = streamOfemployees //
				.collect(Collectors.toList());
	}
	
	

}

class CustomerIdentificaiton{
	
	public String myDept; 
	public CustomerIdentificaiton(String myDept, List<Employee> emps) {
		super();
		this.myDept = myDept;
		this.emps = emps;
	}
	List<Employee> emps = new ArrayList<>();
	
	public String getMyDept() {
		return myDept;
	}
	public void setMyDept(String myDept) {
		this.myDept = myDept;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}

class Employee {
	
	
	
	public Employee(int salary, String name, String dept) {
		super();
		this.setSalary(salary);
		this.name = name;
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int salary;
	public String name;
	public String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}