package com.spro.carcass;

public interface EmployeeDAO {

	public void insertEmployee(Employee employee);
	public Employee findByEmployeeId(int employeeId) throws Exception;
}
