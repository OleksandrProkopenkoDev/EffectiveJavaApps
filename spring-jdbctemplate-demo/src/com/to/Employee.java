package com.to;

public class Employee {

	private int eId;
	private String eName;
	private int age;
	private String password;
	
	public Employee() {}
	
	public Employee(int eId, String eName, int age, String password) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.age = age;
		this.password = password;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName 
				+ ", age=" + age + ", password=" + password + "]";
	}
	
	
}
