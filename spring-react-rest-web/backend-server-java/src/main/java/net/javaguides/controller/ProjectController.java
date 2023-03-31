package net.javaguides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.model.Project;
import net.javaguides.repository.ProjectRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects(){
		List<Project> projects = projectRepository.findAll();
		/*
		 * for (Project project : projects) { System.out.println(project); }
		 */
		return projects;
	}

	@PostMapping("/projects")
	public Project createProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
}
