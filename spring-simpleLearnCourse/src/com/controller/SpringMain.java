package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.to.Employee;
import com.to.Hello;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		/*
		 * Hello h1 = context.getBean("h1",Hello.class); Hello h2 =
		 * context.getBean("h2",Hello.class); System.out.println(h1.getMessage());
		 * System.out.println(h2.getMessage());
		 */
		Employee e1 = context.getBean("e1", Employee.class);
		System.out.println(e1);
		Employee e2 = context.getBean("e2", Employee.class);
		System.out.println(e2 );
		
	}

}
