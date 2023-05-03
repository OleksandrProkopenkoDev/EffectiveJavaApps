package interviewJava8QA;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesSalary {

	public static void main(String[] args) {

		List<Employee> employees = Stream.of(
				new Employee(1L, "Basant", "DEV", 50000),
				new Employee(8L, "Santoch", "DEV", 80000),
				new Employee(3L, "Patrick", "QA", 60000),
				new Employee(9L, "Dipac", "QA", 90000),
				new Employee(4L, "Bikash", "DEVOPS", 40000)
				).collect(Collectors.toList());
//		employees.stream()
//					.collect(Collectors.groupingBy(Employee::getDept))
//					.max(Comparator.comparing(e->e.getSalary()));
		
//		approach1
		Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
		
		   Map<String, Optional<Employee>> employeeMap = employees.stream()
				.collect(
						Collectors.groupingBy(
								Employee::getDept,
								Collectors.reducing(BinaryOperator.maxBy(compareBySalary)))
						);
		System.out.println(employeeMap);

		
		//		approach 2
		 Map<String, Employee> approach2 = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getDept,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
								Optional::get)
						));
		System.out.println(approach2);
	}

}
