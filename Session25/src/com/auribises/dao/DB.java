package com.auribises.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.auribises.bean.Employee;

public class DB implements EmployeeDAO{

	DataSource dataSource;
	JdbcTemplate jdbc; // From the Spring FW
	
	// Setter Method using which we can give Setter Injection with Spring FW DI Technique
	public void setDataSource(DataSource dataSource) {
		System.out.println("Setter Injection for DataSource");
		this.dataSource = dataSource;
		
		// HIGH COUPLING -> BAD
		// Make Coupling to go Low for creating Object of JdbcTemplate
		jdbc = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveEmployee(Employee employee) {
		String sql = "insert into Employee(eid, name, phone, department, designation, salary) values(null, ?, ?, ?, ?, ?)";
		jdbc.update(sql, employee.name, employee.phone, employee.department, employee.designation, employee.salary);
		System.out.println("Employee "+employee.name+" Saved");
	}

	@Override
	public Employee getEmployee(Integer eid) {
		
		String sql = "select * from Employee where eid = ?";
		Employee employee = jdbc.queryForObject(sql, new Object[] {eid}, new EmployeeMapper());
		
		//String sql = "select * from Employee where eid = ? and salary > ?";
		//Employee employee = jdbc.queryForObject(sql, new Object[] {eid, 30000}, new EmployeeMapper());
		
		return employee;
	}

	@Override
	public List<Employee> listEmployees() {
		String sql = "select * from Employee";
		List<Employee> employees = jdbc.query(sql, new EmployeeMapper());
		return employees;
	}

	@Override
	public void deleteEmployee(Integer eid) {
		String sql = "delete from Employee where eid = ?";
		jdbc.update(sql, eid);
		System.out.println("Employee with EID "+eid+" Deleted");
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "update Employee set name=?, phone=?, department=?, designation=?, salary=? where eid=?";
		jdbc.update(sql, employee.name, employee.phone, employee.department, employee.designation, employee.salary, employee.eid);
		System.out.println("Employee "+employee.name+" Updated");
	}
	
}
