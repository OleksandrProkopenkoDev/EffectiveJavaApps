package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	int id;
	String name;
	int salary;

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
}

public class Demo4FilterAndMap {


	
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee(1,"Alex", 12000),
				new Employee(2,"Brian", 20000),
				new Employee(3,"Charles", 15000),
				new Employee(4,"David", 30000),
				new Employee(5,"Edward", 18000)
				);
		
//		Collection-->stream--> Filter-->map-->collect
//		print salary of employees what is greater then ... number
		int number = 25000;
		
		List<Integer>results = employees.stream()
				.filter(employee->employee.salary>number)
				.map(item->item.salary)
				.collect(Collectors.toList());
	
		System.out.println("list of sallary, of employees with sallary greater than "+number);
		System.out.println(results);
		System.out.println();
		
		
	}

}
