package com.spro.carcass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 



public class EmployeeDAOImpl implements EmployeeDAO {

	
	private String url;
	
	private String user;
	
	private String password;
	
	
	@Override
	public void insertEmployee(Employee employee) {
			System.out.println("inserting employee to DB");
			String sql = "insert into employee "
					+ "(employee_id, employee_name,age,salary) values (?,?,?,?)";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, employee.getEmployeeId());
				ps.setString(2, employee.getName());
				ps.setInt(3, employee.getAge());
				ps.setInt(4, employee.getSalary());
				ps.executeUpdate();
				ps.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}

	@Override
	public Employee findByEmployeeId(int employeeId) throws SQLException {
		System.out.println("finding by id");
		String sql = "Select * from employee where employee_id = ?";
		Connection conn = null;
		Employee employee = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				employee = new Employee(
						rs.getInt("employee_Id"),
						rs.getString("employee_name"),
						rs.getInt("age"),
						rs.getInt("Salary")
						);
			}
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(employee==null) throw new SQLException("employee not found");
		return employee;
		
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
