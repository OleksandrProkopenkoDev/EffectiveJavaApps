package net.javaguides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.model.Project;
import net.javaguides.repository.ClientRepository;
import net.javaguides.repository.ProjectRepository;

@SpringBootApplication
public class SpringReactRestWebApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ProjectRepository projectRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringReactRestWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
//			client
		  ContactInfo info = new ContactInfo("+38 063 222 66 44", "info@gmail.com");
		  Client client = new Client("Vasil", info); 
//		  employee
		  Employee employee = new Employee("Luba", Date.valueOf("2023-01-01"), 20000);
//		  proj
		  ProjectInfo projInfo = new ProjectInfo(3000, "Reportage", Date.valueOf("2023-03-01"),Date.valueOf("2023-04-01"));
		  Project project1 = new Project("Liza DR",projInfo, new HashSet<Employee>(),client);
		  project1.getEmployees().add(employee);
		
		  projectRepo.save(project1);
		  
//		  Client savedClient = clientRepo.save(client);
		 
		Project project1 = projectRepo.findById(3L).orElseThrow();
		System.out.println(project1);*/
	}

}
