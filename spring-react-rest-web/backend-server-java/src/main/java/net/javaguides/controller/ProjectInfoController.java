package net.javaguides.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.exception.ResourceNotFoundException;
import net.javaguides.model.Project;
import net.javaguides.model.ProjectInfo;
import net.javaguides.repository.ProjectInfoRepository;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RestController
@RequestMapping("/api/v1/")
public class ProjectInfoController {
	
	@Autowired
	private ProjectInfoRepository projInfoRep;
	
	@GetMapping("/project_info/{id}")
	public ProjectInfo getProjectInfo(@PathVariable Long id){
		ProjectInfo info = projInfoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException(
				"Project info not exists with id "+id));

		return  info;
	}

}
