package com.to;

public class Employee {

	private int employeeID;
	private String employeeName;
	
	public Employee() {
		System.out.println("default constructor called");
	}
		

	public Employee(int employeeID, String employeeName) {
		System.out.println("parametrized cunstructor called");
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}



	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + 
				", employeeName=" + employeeName + "]";
	}





	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		System.out.println("Setter employeeID called");
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		System.out.println("Setter employeeName called");
		this.employeeName = employeeName;
	}
	
	
}
