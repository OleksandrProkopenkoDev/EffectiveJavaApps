package com.spro.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("xml loaded");
		Student student = context.getBean("student", Student.class);
		student.cheating();
		AnotherStudent anotherStudent = context.getBean("anotherStudent", AnotherStudent.class);
		anotherStudent.startCheating();
	}
}
