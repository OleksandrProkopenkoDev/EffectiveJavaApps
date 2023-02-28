package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class SpringStudentManagementSystemApplication 
				implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student student1 = new Student("Ramesh", "Fadatare","ramesh@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Student student2 = new Student("Sasha", "Pro","spro@gmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Student student3 = new Student("Tony", "Stark","stark@gmail.com");
		 * studentRepository.save(student3);
		 */
		
	}

}
