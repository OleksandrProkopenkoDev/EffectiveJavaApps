package com.spro.college;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Client {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		College college = context.getBean("college", College.class);
//		College collegeSetter = context.getBean("collegeSetter", College.class);
		System.out.println("College obj created");
		college.test();
//		collegeSetter.test();
		context.close();
	}
}
