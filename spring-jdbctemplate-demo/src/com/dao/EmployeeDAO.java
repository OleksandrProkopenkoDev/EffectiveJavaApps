package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.to.Employee;

public class EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager platformTransactionManager;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public int addEmployee(Employee e) {
		int count = 0;
		String query = "insert into employee values(?,?,?,?);";
		count = jdbcTemplate.update(query, 
				e.geteId(), e.geteName(), e.getAge(), e.getPassword());
		return count;
	}
	
	public List<Employee> getAllEmployees(){
		String sql = "select * from employee;";
		@SuppressWarnings("unchecked") // allows cast type of query result to 'Employee'
		List<Employee> listEmpl = jdbcTemplate.query(sql, new EmployeeMapper());
		return listEmpl;
	}
	
	public List<Employee> getAllEmployeesOnAge(int age){
		String sql = "select * from employee where age = ?;";
		@SuppressWarnings("unchecked")
		List<Employee> listEmpl = jdbcTemplate.query(sql, new EmployeeMapper(), age);
		return listEmpl;
	}
	
	public void performMultiActions(Employee e) {
		System.out.println("\nPerforming Multiple Actions");
		TransactionDefinition transactionDefinition = 
				new DefaultTransactionDefinition();
		TransactionStatus transactionStatus =
				platformTransactionManager.getTransaction(transactionDefinition);
		
		try {
			String query = "insert into employee values(?,?,?,?);";
			int count = jdbcTemplate.update(query, 
					e.geteId(),e.geteName(),e.getAge(), e.getPassword());
			System.out.println(count + " records inserted");
			
			String sql = "select * from employee where age="+
						 "(select max(age) from employee);";
			List<Employee> result = jdbcTemplate.query(sql, new EmployeeMapper());
			System.out.println("max age = " + result);
			platformTransactionManager.commit(transactionStatus);
		} catch (DataAccessException | TransactionException e1) {
			System.out.println("Transaction failed " + e1);
			platformTransactionManager.rollback(transactionStatus);
		}
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
	
	
}
