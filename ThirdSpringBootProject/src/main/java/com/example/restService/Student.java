package com.example.restService;

import jakarta.persistence.*;


@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	private String address;
	
	public Student() {}
	
	public Student(String name, int age, String address) {
				this.name = name;
		this.age = age;
		this.address = address;
	}
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}

	
	
}
