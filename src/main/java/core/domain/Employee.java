package core.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
	private int id;
	private String name;

	public String getDepartment() {
		return department;
	}

	private String department;
	private int salary;

	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(Employee.builder().id(100).name("Kumar0").department("ENBD0").salary(1000000).build());
		employees.add(Employee.builder().id(101).name("Kumar1").department("ENBD1").salary(1000001).build());
		employees.add(Employee.builder().id(102).name("Kumar2").department("ENBD2").salary(1000002).build());
		employees.add(Employee.builder().id(104).name("Kumar3").department("ENBD3").salary(1000003).build());
		employees.add(Employee.builder().id(105).name("Kumar4").department("ENBD4").salary(1000004).build());
		employees.add(Employee.builder().id(106).name("Kumar5").department("ENBD5").salary(1000005).build());
		employees.add(Employee.builder().id(107).name("Kumar6").department("ENBD6").salary(1000006).build());
		employees.add(Employee.builder().id(108).name("Kumar7").department("ENBD7").salary(1000007).build());
		return employees;
	}


	public int getSalary() {
		return this.salary;
	}
}
