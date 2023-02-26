package com.spro.amigoscode.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student(
					"Mariam",
					"marian@jama@gmail.com",LocalDate.of(2000, 10, 15));
			Student alex = new Student(
					"Alex",
					"alex@gmail.com",LocalDate.of(2004, 11, 19));
			repository.saveAll(List.of(mariam, alex));
		};
		
	}
}
