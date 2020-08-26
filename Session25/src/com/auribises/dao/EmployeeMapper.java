package com.auribises.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.auribises.bean.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Employee employee = new Employee();
		employee.setEid(rs.getInt("eid"));
		employee.setName(rs.getString("name"));
		employee.setPhone(rs.getString("phone"));
		employee.setDepartment(rs.getString("department"));
		employee.setDesignation(rs.getString("designation"));
		employee.setSalary(rs.getInt("salary"));
		
		return employee;
	}
	
	

}
