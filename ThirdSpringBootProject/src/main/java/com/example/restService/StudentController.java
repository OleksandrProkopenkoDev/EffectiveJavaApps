package com.example.restService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/student/create")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentRepository.findById(id).get();
	}
}
