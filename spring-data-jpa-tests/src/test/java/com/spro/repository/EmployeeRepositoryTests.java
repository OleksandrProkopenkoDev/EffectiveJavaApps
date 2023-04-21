package com.spro.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spro.model.Employee;

@DataJpaTest //load only repository layer components
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepo;

	private Employee employee1;
	
	@BeforeEach
	public void setup() {
		employee1 = Employee.builder()
				.firstName("Ramesh")
				.lastName("Fadatare")
				.email("ram@gmail.com")
				.build();
		
	}
	
	//JUnit test for save employee operation
//	given_when_then
	@DisplayName("JUnit test for save employee operation")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
//		given - precondition or setup
//		Employee employee = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
//		when - action or the behavior that we are going to test
		Employee savedEmployee = employeeRepo.save(employee1);
//		then - verify the output
		/*
		 * Assertions.assertThat(savedEmployee).isNotNull();
		 * Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
		 */
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);
		
	}
//	JUnit test for get all employees operation
	@DisplayName("JUnit test for get all employees operation")
	@Test
	public void givenEmployeesList_whenFindAll_thenEmployeesList() {
//		given - precondition or setup
//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		Employee employee2 = Employee.builder()
				.firstName("John")
				.lastName("Cena")
				.email("cena@gmail.com")
				.build();
		employeeRepo.save(employee1);
		employeeRepo.save(employee2);

		
		//		when - action or behavior
		List<Employee> employeeList = employeeRepo.findAll();
//		then - verify the output
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
	
	
	}
	
	//	JUnit test for get employee by id operation
	@DisplayName("JUnit test for get employee by id operation")
	@Test
	public void givenEmployee_whenFindById_thenEmployee() {
		//		given - precondition or setup
//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		System.out.println(employee1);
		employeeRepo.save(employee1);
		System.out.println(employee1);
		//		when - action or behavior that we are going to test
		Employee employeeDB = employeeRepo.findById(employee1.getId()).get();
		//		then - verify the output
		assertThat(employeeDB).isNotNull();
	}
	
	//	JUnit test for get employee by email operation
	@DisplayName("JUnit test for get employee by email operation")
	@Test
	public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {
		//		given - precondition or setup
//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
		//		when - action or behavior that we are going to test
		Employee employeeDB = employeeRepo.findByEmail(employee1.getEmail()).get();
		//		then - verify the output
		assertThat(employeeDB).isNotNull();
		System.out.println("given employee: "+employee1);
		System.out.println("employee finded by Email: "+employeeDB);
	}
	
	//	JUnit test for update employee operation
	@Test
	@DisplayName("JUnit test for update employee operation")
	public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
		//		given - precondition or setup
//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
		//		when - action or behavior that we are going to test	
		Employee employeeDB = employeeRepo.findById(employee1.getId()).get();
		employeeDB.setEmail("asdasd@sadf.com");
		employeeDB.setFirstName("sasssss");
		Employee updatedEmployee = employeeRepo.save(employeeDB);
		
		//		then - verify the output
		assertThat(updatedEmployee.getEmail()).isEqualTo("asdasd@sadf.com");
		assertThat(updatedEmployee.getFirstName()).isEqualTo("sasssss");
		
	
	}
	
	//	JUnit test for delete employee operation
	@Test
	@DisplayName("JUnit test for delete employee operation")
	public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {
		//		given - precondition or setup

//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
		//		when - action or behavior that we are going to test
//		employeeRepo.delete(employee1);
		employeeRepo.deleteById(employee1.getId());
		Optional<Employee> employeeOptional = employeeRepo.findById(employee1.getId());
		
		//		then - verify the output
		assertThat(employeeOptional).isEmpty();
		 
		
	}
	
	//	JUnit test for custom query using JPQL with index
	@Test
	public void givenName_whenFindByJPQL_thenReturnEmployeeObject() {
		//		given - precondition or setup

//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
		String firstName = "Ramesh";
		String lastName = "Fadatare";
		//		when - action or behavior that we are going to test
		
		Employee savedEmployee = employeeRepo.findByJPQL(firstName, lastName);
		//		then - verify the output
		assertThat(savedEmployee).isNotNull();
	
	}
	//	JUnit test for custom query using JPQL with named params
	@Test
	@DisplayName("JUnit test for custom query using JPQL with named params")
	public void givenName_whenFindByJPQLNamedParams_thenReturnEmployeeObject() {
		//		given - precondition or setup

//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
		String firstName = "Ramesh";
		String lastName = "Fadatare";
		//		when - action or behavior that we are going to test
		
		Employee savedEmployee = employeeRepo.findByJPQLNamedParams(firstName, lastName);
		//		then - verify the output
		assertThat(savedEmployee).isNotNull();
	
	}

	//	JUnit test for query using native sql with index params
	@Test
	@DisplayName("JUnit test for query using native sql with index params")
	public void givenName_whenFindByNativeSQL_thenReturnEmployeeObject() {
		//		given - precondition or setup

//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
//		String firstName = "Ramesh";
//		String lastName = "Fadatare";
		//		when - action or behavior that we are going to test

		Employee savedEmployee = employeeRepo.findByNativeSQL(employee1.getFirstName(), employee1.getLastName());
		//		then - verify the output
		assertThat(savedEmployee).isNotNull();
	}


	//	JUnit test for query using native sql with index params
	@Test
	@DisplayName("JUnit test for query using native sql with named params")
	public void givenName_whenFindByNativeSQLNamed_thenReturnEmployeeObject() {
		//		given - precondition or setup

//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("ram@gmail.com")
//				.build();
		employeeRepo.save(employee1);
//		String firstName = "Ramesh";
//		String lastName = "Fadatare";
		//		when - action or behavior that we are going to test

		Employee savedEmployee = employeeRepo.findByNativeSQLNamed(employee1.getFirstName(), employee1.getLastName());
		//		then - verify the output
		assertThat(savedEmployee).isNotNull();
	}

}
