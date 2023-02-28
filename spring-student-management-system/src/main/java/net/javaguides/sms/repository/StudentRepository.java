package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Student;
//dont need @Repository annotation because JpaRepository has it
public interface StudentRepository extends JpaRepository<Student, Long>{

	
}
