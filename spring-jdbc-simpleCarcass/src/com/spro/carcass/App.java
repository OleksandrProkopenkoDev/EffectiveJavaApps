package com.spro.carcass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
		Employee employee = new Employee(5, "Peter", 28, 80000);
//		employeeDAO.insertEmployee(employee);
		
		try {
			employee = employeeDAO.findByEmployeeId(7);
		} catch (Exception e) {
			System.out.println("eror: "+e.getMessage());
		}
		System.out.println(employee);
	}
}
