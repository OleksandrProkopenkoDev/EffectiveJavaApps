package net.javaguides.springboot;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.Position;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.PositionRepository;

@SpringBootApplication
public class SpringMvcThymeleafEmployeeCrudWebAppApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository eRep;
	@Autowired
	private PositionRepository posRep;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcThymeleafEmployeeCrudWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Position pos = posRep.findById(1L).get(); Employee empl = new
		 * Employee("Kolya", Date.valueOf("1989-08-30"), pos); eRep.save(empl);
		 */
	}

}
