package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootAngularCrudApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository rep;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularCrudApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * rep.save(new Employee("Sherlock","Holmes","holmes@gmail.com"));
		 * System.out.println("after saving student");
		 */
	}

}
