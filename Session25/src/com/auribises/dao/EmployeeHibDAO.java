package com.auribises.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import com.auribises.bean.Employee;

public interface EmployeeHibDAO {
	
	// Rule Book
	// DataSource API form javax.sql will hold the information of the DataBase :) eg: url, user, password ...
	void setSessionFactory(SessionFactory sessionFactory);
	
	void saveEmployee(Employee employee);
	
	Employee getEmployee(Integer eid);
	List<Employee> listEmployees();
	
	void deleteEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
}
