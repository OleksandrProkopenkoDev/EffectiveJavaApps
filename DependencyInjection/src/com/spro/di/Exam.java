package com.spro.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student abhi = context.getBean("student", Student.class);
		Student ashish = context.getBean("student2", Student.class);
		Student abhi3 = context.getBean("student3", Student.class);
		abhi.displayStudentInfo();
		ashish.displayStudentInfo();
		abhi3.displayStudentInfo();
		
//		this is old hardcoding
//		Student student = new Student();
//		student.setStudentName("abhilAsh panigrahI");  
//		
//		student.displayStudentInfo();
	}
	
}
