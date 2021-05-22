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
	private String department;
	private long salary;

	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(Employee.builder().id(100).name("Kumar").department("ENBD").salary(100000).build());
		employees.add(Employee.builder().id(101).name("Kumar1").department("ENBD1").salary(1000001).build());
		employees.add(Employee.builder().id(102).name("Kumar2").department("ENBD2").salary(1000002).build());
		employees.add(Employee.builder().id(104).name("Kumar3").department("ENBD3").salary(1000003).build());
		return employees;
	}

}
