package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.Employee;

public class EmployeeMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee e = new Employee();
		e.seteId(rs.getInt("eId"));
		e.setAge(rs.getInt("age"));
		e.seteName(rs.getString("eName"));
		e.setPassword(rs.getString("ePassword"));
		return e;
	}

	
}
