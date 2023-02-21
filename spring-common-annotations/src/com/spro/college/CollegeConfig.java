package com.spro.college;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.spro.college")
@PropertySource("classpath:college-info.properties")
public class CollegeConfig {
	/*
	@Bean
	public Teacher mathTeacherBean() {
		return new MathTeacher();
	}

	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	
	@Bean(name = "collegeSetter") 	
	public College collegeSetter() { 
		College c = new College();
		c.setPrincipal(principalBean());
		c.setTeacher(mathTeacherBean());
	return c;
	}
	
	@Bean(name = {"college", "college2"})// this "name" overwrites the bean`s id name. So now id is college, not a collegeBean 
//				we can define many names in curly braces		
	public College collegeBean() { //method name = bean id
		return new College(principalBean());
	}
	*/
}
