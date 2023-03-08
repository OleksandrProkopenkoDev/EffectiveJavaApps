package com.kriscfoster.school.subject;

import java.util.HashSet;
import java.util.Set;

import com.kriscfoster.school.student.Student;
import com.kriscfoster.school.teacher.Teacher;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(
			name="student_enrolled",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> enrolledStudents = new HashSet<>();// start with empty

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	private Teacher teacher;

	private String name;

	
	
	public Teacher getTeacher() {
		return teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void enrollStudent(Student student) {
		enrolledStudents.add(student);
	}

	public void assignTeacher(Teacher teacher) {
		this.teacher = teacher;
		
	}
	
	
}

