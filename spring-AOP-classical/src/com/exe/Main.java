package com.exe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.to.SomeBO;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		SomeBO bo = app.getBean("proxy", SomeBO.class);
		bo.validate();
		try {
			bo.validate(17);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
