package com.kriscfoster.school.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kriscfoster.school.student.Student;
import com.kriscfoster.school.student.StudentRepository;
import com.kriscfoster.school.teacher.Teacher;
import com.kriscfoster.school.teacher.TeacherRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	
	@GetMapping
	public List<Subject> getSubjects(){return subjectRepository.findAll();}
	
	@PostMapping
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@PutMapping("/{subjectId}/students/{studentId}")
	public Subject enrollStudentToSubject(
			@PathVariable Long subjectId,
			@PathVariable Long studentId) {
		System.out.println("enrollStudentToSubject: subjectId "+subjectId+" studentId "+studentId);
		Subject subject = subjectRepository.findById(subjectId).get();
		Student student = studentRepository.findById(studentId).get();
		subject.enrollStudent(student);
		return subjectRepository.save(subject);
	}
	
	@PutMapping("/{subjectId}/teachers/{teacherId}")
	public Subject assignTeacherToSubject(
			@PathVariable Long subjectId,
			@PathVariable Long teacherId) {
		System.out.println("Assign TeacherToSubject: subjectId "+subjectId+" teacherId "+teacherId);
		Subject subject = subjectRepository.findById(subjectId).get();
		Teacher teacher = teacherRepository.findById(teacherId).get();
		subject.assignTeacher(teacher);
		return subjectRepository.save(subject);
	}
}
