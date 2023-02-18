package com.spro.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("xml loaded");
		Student student1 = context.getBean("student1", Student.class);
		student1.displayStudentInfo();
	}
}
