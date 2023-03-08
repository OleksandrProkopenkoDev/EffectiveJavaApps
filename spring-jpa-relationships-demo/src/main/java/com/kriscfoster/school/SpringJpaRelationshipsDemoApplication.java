package com.kriscfoster.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kriscfoster.school.student.Student;
import com.kriscfoster.school.student.StudentRepository;

@SpringBootApplication
public class SpringJpaRelationshipsDemoApplication implements CommandLineRunner{

	@Autowired
	StudentRepository rep;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaRelationshipsDemoApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
//		rep.save(new Student("Vasil"));
		
	}

}
