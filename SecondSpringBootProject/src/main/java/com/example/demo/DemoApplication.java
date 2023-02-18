package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Let`s inspect the beans provided by Spring boot:");
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String name : beanNames) {
			System.out.println(name);
		}
	}

}
