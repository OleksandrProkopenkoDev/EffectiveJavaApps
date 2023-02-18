package com.spro.value;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Student {

	@Value("${student.name}")
	private String name;
	@Value("${student.interestedCourse}")
	private String interestedCourse;
	@Value("${student.hobby}")
	private String hobby;
	
	public void displayStudentInfo() {
		System.out.println("Student name is "+name+". Interested course: "+
					interestedCourse+", hobby: "+hobby);
	}
	
	public String getName() {
		return name;
	}
//	@Value("Abhilash")
//	@Value("${student.name}") //injecting value from properties file
	public void setName(String name) {
		this.name = name;
	}
	public String getInterestedCourse() {
		return interestedCourse;
	}
	
	@Required
//	@Value("java")
	@Value("${student.interestedCourse}")
	public void setInterestedCourse(String interestedCourse) {
		this.interestedCourse = interestedCourse;
	}
	
	public String getHobby() {
		return hobby;
	}
//	@Value("cricket")
	@Value("${student.hobby}")
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
