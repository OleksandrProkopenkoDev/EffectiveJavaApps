package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Position;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);

	List<Position> getAllPositions();
	
	Employee getEmployeeById(Long id);

	void deleteEmployeeById(Long id);
}
