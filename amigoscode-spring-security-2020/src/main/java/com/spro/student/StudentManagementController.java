package com.spro.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "James Bond"),
			new Student(2, "Maria Jones"),
			new Student(3, "Anna Smith")
			); 
	
//	hasRole('ROLE_') 
//	hasAnyRole('ROLE_') 
//	hasAuthority('permission') 
//	hasAnyAuthority('permission') 
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudents(){
		System.out.println("printed students list:"+ STUDENTS);
		return STUDENTS;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public String registerNewStudent(@RequestBody Student student) {
		System.out.println("Post: register new student "+student);
		return "new student registred succesfully";
	}
	
	@DeleteMapping(path = "{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public String deleteStudent(@PathVariable("studentId") Integer studentId) {
		System.out.println("delete student with id: "+studentId);
		return "student %s deleted succesfully".formatted(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	@PreAuthorize("hasAuthority('student:write')")
	public String updateStudent(
			@PathVariable("studentId") Integer studentId,
			@RequestBody Student student) {
		System.out.println("update student where id="+String.format("%s %s", studentId, student));
		return "student %s updated succesfully".formatted(studentId);
	}
}
