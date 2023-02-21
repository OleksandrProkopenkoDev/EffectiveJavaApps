package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDAO;
import com.to.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO dao = ap.getBean("edao", EmployeeDAO.class);
		
/*		Employee e1 = new Employee(105,"Garik", 22,"4321");
		int count = dao.addEmployee(e1);
		System.out.println(count + " records added");
	
		
		List<Employee> list = dao.getAllEmployees();
		for(Employee employee: list) {
			System.out.println(employee);
		}
*/		
		Employee e1 = new Employee(107,"Gik", 52,"5444");
		dao.performMultiActions(e1);;
		List<Employee> list = dao.getAllEmployees();
		for(Employee employee: list) {
			System.out.println(employee);
		}
		
	}

}
