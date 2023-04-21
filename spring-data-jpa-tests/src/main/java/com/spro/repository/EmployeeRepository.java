package com.spro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spro.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByEmail(String email);
	
	@Query("select e from Employee e where e.firstName = ?1 or e.lastName = ?2")
	Employee findByJPQL(String firstName, String lastName);
	
//	define custom query using JPQL with named parameters 
	@Query("select e from Employee e where e.firstName = :firstName or e.lastName = :lastName")
	Employee findByJPQLNamedParams(
			@Param("firstName")	String firstName, 
			@Param("lastName") String lastName);

	//	define custom query using native sql with index parameters 
	@Query(value = "select * from employees e where e.first_name = ?1 or e.last_name=?2", nativeQuery = true)
	Employee findByNativeSQL(String firstName, String lastName);
	
//	define custom query using native sql with named parameters 
	@Query(value = "select * from employees e where e.first_name = :firstName or e.last_name=:lastName",
			nativeQuery = true)
	Employee findByNativeSQLNamed(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName);
	
}
