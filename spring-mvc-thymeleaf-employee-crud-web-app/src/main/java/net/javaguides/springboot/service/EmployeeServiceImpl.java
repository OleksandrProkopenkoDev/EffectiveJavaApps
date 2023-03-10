package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Position;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.PositionRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		Position position = positionRepository.findByTitle(employee.getPosition().getTitle());
		if(position==null) {
			position = new Position(employee.getPosition().getTitle());
			positionRepository.save(position);
		}		
		employee.setPosition(position);
		employeeRepository.save(employee);		
	}

	@Override
	public List<Position> getAllPositions() {
		return positionRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee;
		employee = optional.orElseThrow(
				()-> new RuntimeException("Employee not found for id "+id));

		
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);		
	}
	
	
	

}
