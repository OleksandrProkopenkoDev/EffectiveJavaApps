package com.exe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bo.SomeBO;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		SomeBO bo = ap.getBean("bo", SomeBO.class);
		bo.validate();
		try {
			bo.validate(17);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
