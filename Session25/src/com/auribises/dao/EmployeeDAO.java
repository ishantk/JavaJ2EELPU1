package com.auribises.dao;

import java.util.List;

import javax.sql.DataSource;

import com.auribises.bean.Employee;

public interface EmployeeDAO {
	
	// Rule Book
	// DataSource API form javax.sql will hold the information of the DataBase :) eg: url, user, password ...
	void setDataSource(DataSource dataSource);
	
	void saveEmployee(Employee employee);
	
	Employee getEmployee(Integer eid);
	List<Employee> listEmployees();
	
	void deleteEmployee(Integer eid);
	
	void updateEmployee(Employee employee);
}
